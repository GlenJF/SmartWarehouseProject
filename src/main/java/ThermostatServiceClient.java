import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
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

    public ThermostatServiceClient(String consulHost, int consulPort, String consulServiceName) {
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

    private ThermostatServiceGrpc.ThermostatServiceStub initializeStub() {
        return ThermostatServiceGrpc.newStub(channel);
    }

    public void getCurrentThermostatReading() {
        RequestSource request = RequestSource.newBuilder().setRequest("current").build();
        stub.getCurrentThermostatReading(request, new ResponseObserver<ThermostatReadingInformation>() {
          /*  @Override
            public void onNext(ThermostatReadingInformation response) {
                System.out.println("Current Thermostat Reading: " + response.getTemperature());
            }*/

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
            public void onCompleted() {
                System.out.println("Streaming thermostat readings completed");
            }
        };

        RequestSource request = RequestSource.newBuilder().setRequest("stream").build();
        stub.streamThermostatReadings(request, responseObserver);
    }

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

    public void shutdown() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Error while shutting down client: " + e.getMessage());
        }
    }
}
