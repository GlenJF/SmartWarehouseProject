import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.health.model.HealthService;
import com.ncirl.smartwarehouse.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

    public class MotionSensorClient {

        private final ManagedChannel channel;
        private final ConsulClient consulClient;
        private final String consulServiceName;
        private final MotionSensorServiceGrpc.MotionSensorServiceStub stub;

        public MotionSensorClient(String consulHost, int consulPort, String consulServiceName) {
            this.consulClient = new ConsulClient(consulHost, consulPort);
            this.consulServiceName = consulServiceName;
            this.channel = initializeChannel();
            this.stub = initializeStub();
            System.out.println("Client initialized.");
        }

        private ManagedChannel initializeChannel() {
            List<HealthService> healthServices = consulClient.getHealthServices(consulServiceName, true, null).getValue();
            if (healthServices.isEmpty()) {
                throw new RuntimeException("No healthy instances of " + consulServiceName + " found in Consul.");
            }
            HealthService healthService = healthServices.get(0);
            String serverHost = healthService.getService().getAddress();
            int serverPort = healthService.getService().getPort();
            return ManagedChannelBuilder.forAddress(serverHost, serverPort).usePlaintext().build();
        }

        private MotionSensorServiceGrpc.MotionSensorServiceStub initializeStub() {
            return MotionSensorServiceGrpc.newStub(channel);
        }

        public void detectMotion() {
            StreamObserver<DetectMotionStatusRequest> requestObserver = stub.detectMotion(new StreamObserver<DetectMotionResponse>() {
                @Override
                public void onNext(DetectMotionResponse response) {
                   // System.out.println("Motion Detected: " + response.getMessage());
                    System.out.println("Received response from server: " + response);
                    System.out.println("Motion Detected: " + response.getMessage());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error in detecting motion: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Motion detection completed");
                }
            });

            // Simulate motion detection
            try {
                int count=0;
                while (count<3) {
                    boolean isMotionDetected;
                    if (Math.random() < 0.5) isMotionDetected = true;
                    else isMotionDetected = false;
                    System.out.println("Sending motion detection request with isMotionDetected: " + isMotionDetected);
                    DetectMotionStatusRequest request = DetectMotionStatusRequest.newBuilder()
                            .setIsMotionDetected(isMotionDetected)
                            .build();
                    requestObserver.onNext(request);
                    Thread.sleep(5000); // Send request every 5 seconds
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            requestObserver.onCompleted();
        }

        public static void main(String[] args) {
            String consulHost = "localhost"; // Consul host
            int consulPort = 8500; // Consul port
            String consulServiceName = "motionsensor-service";

            MotionSensorClient client = new MotionSensorClient(consulHost, consulPort, consulServiceName);
            System.out.println("Starting MotionSensorClient");
            try {
                // Detect motion
                client.detectMotion();

                // Wait for user input to exit
                Scanner scanner = new Scanner(System.in);
                System.out.println("Press any key to exit...");
                scanner.nextLine();
            } finally {
                client.shutdown();
                System.out.println("Client shutdown.");
            }
        }

        public void shutdown() {
            try {
                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                System.err.println("Error while shutting down client: " + e.getMessage());
            }
        }
    }


