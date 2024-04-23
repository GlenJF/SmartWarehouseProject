import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.health.model.HealthService;
import com.ncirl.smartwarehouse.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LightSensorClient {

    private final ManagedChannel channel;
    private final ConsulClient consulClient;
    private final String consulServiceName;
    private final LightSensorServiceGrpc.LightSensorServiceStub stub;

    public LightSensorClient(String consulHost, int consulPort, String consulServiceName) {
        this.consulClient = new ConsulClient(consulHost, consulPort);
        this.consulServiceName = consulServiceName;
        this.channel = initializeChannel();
        this.stub = initializeStub();
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

    private LightSensorServiceGrpc.LightSensorServiceStub initializeStub() {
        return LightSensorServiceGrpc.newStub(channel);
    }

    public void adjustBrightness() {
        StreamObserver<LightResponse> responseObserver = new StreamObserver<LightResponse>() {
            @Override
            public void onNext(LightResponse response) {
                if (response.getIncreaseBrightness()) {
                    System.out.println("Increasing brightness...");
                } else if (response.getDecreaseBrightness()) {
                    System.out.println("Decreasing brightness...");
                } else {
                    System.out.println("No adjustment needed.");
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in adjusting brightness: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Brightness adjustment completed");
            }
        };

        StreamObserver<LightRequest> requestObserver = stub.adjustBrightness(responseObserver);

        // Simulate sending luminous intensity
        try {
            int count = 0;
            while (count < 14) {
                int luminousIntensity = (int) (Math.random() * 100); // Generate random luminous intensity
                LightRequest request = LightRequest.newBuilder()
                        .setLuminousIntensity(luminousIntensity)
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
        String consulServiceName = "lightsensor-service";

        LightSensorClient client = new LightSensorClient(consulHost, consulPort, consulServiceName);
        try {
            // Adjust brightness
            client.adjustBrightness();

            // Wait for user input to exit
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press any key to exit...");
            scanner.nextLine();
        } finally {
            client.shutdown();
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

