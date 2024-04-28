import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.health.model.HealthService;
import com.ncirl.smartwarehouse.RequestSource;
import com.ncirl.smartwarehouse.ThermostatReadingInformation;
import com.ncirl.smartwarehouse.ThermostatServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ThermostatServiceClient {


    private final ManagedChannel channel;
    private final ConsulClient consulClient;
    private final String consulServiceName;
    private final ThermostatServiceGrpc.ThermostatServiceStub stub;

    // Constructor to initialize the client with Consul details and service name
    public ThermostatServiceClient(String consulHost, int consulPort, String consulServiceName) {
        this.consulClient = new ConsulClient(consulHost, consulPort);
        this.consulServiceName = consulServiceName;
        this.channel = initializeChannel();
        this.stub = initializeStub();
    }

    // Method to initialize gRPC channel
    private ManagedChannel initializeChannel() {
        // Get healthy instances from Consul
        List<HealthService> healthServices = consulClient.getHealthServices(consulServiceName, true, null).getValue();
        // Check if any instance is available

        if (healthServices.isEmpty()) {
            throw new RuntimeException("No healthy instances of " + consulServiceName + " found in Consul.");
        }
        // Select the first healthy instance
        HealthService healthService = healthServices.get(0);
        String serverHost = healthService.getService().getAddress();
        int serverPort = healthService.getService().getPort();
        return ManagedChannelBuilder.forAddress(serverHost, serverPort).usePlaintext().build();
    }

    //initialize gRPC stub
    private ThermostatServiceGrpc.ThermostatServiceStub initializeStub() {
        return ThermostatServiceGrpc.newStub(channel);
    }

    // Unary Method to get the current thermostat reading
    public void getCurrentThermostatReading() {
        RequestSource request = RequestSource.newBuilder().setRequest("current").build();
        stub.getCurrentThermostatReading(request, new StreamObserver<ThermostatReadingInformation>() {
            @Override
            public void onNext(ThermostatReadingInformation response) {
                System.out.println("Current Thermostat Reading: " + response.getTemperature());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in getting current thermostat reading: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Getting current thermostat reading completed");
            }
        });
    }

    // Client Side streaming method implementation
    public void streamThermostatReadings() {
        StreamObserver<ThermostatReadingInformation> responseObserver = new StreamObserver<ThermostatReadingInformation>() {
            @Override
            public void onNext(ThermostatReadingInformation response) {
                System.out.println("Thermostat Reading: " + response.getTemperature());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in streaming thermostat readings: " + t.getMessage());
            }

            @Override
            // Complete the stream
            public void onCompleted() {
                System.out.println("Streaming thermostat readings completed");
            }
        };

        RequestSource request = RequestSource.newBuilder().setRequest("stream").build();
        stub.streamThermostatReadings(request, responseObserver);
    }

    // Main method to start the client
    public static void main(String[] args) {
        String consulHost = "localhost"; // Consul host
        int consulPort = 8500; // Consul port
        String consulServiceName = "thermostat-service"; // Name of the service registered in Consul

        ThermostatServiceClient client = new ThermostatServiceClient(consulHost, consulPort, consulServiceName);
        try {
            // Get current thermostat reading
            client.getCurrentThermostatReading();

            // Stream thermostat readings
            client.streamThermostatReadings();

            // Wait for user input to exit
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press any key to exit...");
            scanner.nextLine();
        } finally {
            client.shutdown();
        }
    }

    // Shutdown the client
    public void shutdown() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Error while shutting down client: " + e.getMessage());
        }
    }
}
