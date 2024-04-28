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
    // Declare Variables
        private final ManagedChannel channel;
        private final ConsulClient consulClient;
        private final String consulServiceName;
        private final MotionSensorServiceGrpc.MotionSensorServiceStub stub;

        // Constructor to intilaize  Consul client and gRPC stub
        public MotionSensorClient(String consulHost, int consulPort, String consulServiceName) {
            this.consulClient = new ConsulClient(consulHost, consulPort);
            this.consulServiceName = consulServiceName;
            this.channel = initializeChannel();
            this.stub = initializeStub();
            System.out.println("Client initialized.");
        }

        // Method to initialize gRPC channel
        private ManagedChannel initializeChannel() {
            // Check if any healthy instances are available
            List<HealthService> healthServices = consulClient.getHealthServices(consulServiceName, true, null).getValue();
            if (healthServices.isEmpty()) {
                throw new RuntimeException("No healthy instances of " + consulServiceName + " found in Consul.");
            }
            // Select the first helathy instance available
            HealthService healthService = healthServices.get(0);
            String serverHost = healthService.getService().getAddress();
            int serverPort = healthService.getService().getPort();
            return ManagedChannelBuilder.forAddress(serverHost, serverPort).usePlaintext().build();
        }

            // Method to initialize gRpc stub
        private MotionSensorServiceGrpc.MotionSensorServiceStub initializeStub() {
            return MotionSensorServiceGrpc.newStub(channel);
        }

        // Method to detect motion
        public void detectMotion() {
            // Create a request observer to handel responses from the server
            StreamObserver<DetectMotionStatusRequest> requestObserver = stub.detectMotion(new StreamObserver<DetectMotionResponse>() {
                @Override
                public void onNext(DetectMotionResponse response) {
                    // Print motion detection status received from server
                   // System.out.println("Motion Detected: " + response.getMessage());
                    System.out.println("Received response from server: " + response);
                    System.out.println("Motion Detected: " + response.getMessage());
                }

                @Override
                // handle errors
                public void onError(Throwable t) {
                    System.err.println("Error in detecting motion: " + t.getMessage());
                }

                @Override
                // Notify Completion of motion detection
                public void onCompleted() {
                    System.out.println("Motion detection completed");
                }
            });

            // Simulate motion detection
            try {
                int count=0;
                while (count<10) {
                    // generate a random boolean to simulate motion detection
                    boolean isMotionDetected;
                    if (Math.random() < 0.5) isMotionDetected = true;
                    else isMotionDetected = false;
                    System.out.println("Sending motion detection request with isMotionDetected: " + isMotionDetected);
                   // Create a motion detection request and send it to the server
                    DetectMotionStatusRequest request = DetectMotionStatusRequest.newBuilder()
                            .setIsMotionDetected(isMotionDetected)
                            .build();
                    requestObserver.onNext(request);
                    count++;
                    Thread.sleep(5000); // Send request every 5 seconds
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Complete the motion detection stream
            requestObserver.onCompleted();
        }
        // main method to start client
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
                // Shutdown the client
                client.shutdown();
                System.out.println("Client shutdown.");
            }
        }
            // Method to shut down client
        public void shutdown() {
            try {
                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                System.err.println("Error while shutting down client: " + e.getMessage());
            }
        }
    }


