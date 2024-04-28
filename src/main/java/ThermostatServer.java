import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import com.ncirl.smartwarehouse.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ThermostatServer {

    private Server server;

    // Start server
    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new ThermostatServiceImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        // Register server to Consul
        registerToConsul();

        // Add shutdown hook to gracefully shut down the server
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            ThermostatServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    // Stop server
    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    //block until the server shuts down
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    // register to consul for service discovery
    private void registerToConsul() {
        System.out.println("Registering server to Consul...");

        // Load Consul configuration from thermostat.properties file
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/thermostat.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Extract Consul configuration properties
        String consulHost = props.getProperty("consul.host");
        int consulPort = Integer.parseInt(props.getProperty("consul.port"));

        String serviceName = props.getProperty("thermostat.service.name");
        int servicePort = Integer.parseInt(props.getProperty("thermostat.service.port"));
        String healthCheckInterval = props.getProperty("thermostat.service.healthCheckInterval");

        // Get host address
        String hostAddress;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }

        // Create a Consul client
        ConsulClient consulClient = new ConsulClient(consulHost, consulPort);

        // Define service details
        NewService newService = new NewService();
        newService.setName(serviceName);
        newService.setPort(servicePort);
        newService.setAddress(hostAddress); // Set host address

        // Register service with Consul
        consulClient.agentServiceRegister(newService);

        // Print registration success message
        System.out.println("Server registered to Consul successfully. Host: " + hostAddress);
    }


    // Main method to start server
    public static void main(String[] args) throws IOException, InterruptedException {
        final ThermostatServer server = new ThermostatServer();
        server.start();
        server.blockUntilShutdown();
    }

    // Thermostat service implementation
    public class ThermostatServiceImpl extends ThermostatServiceGrpc.ThermostatServiceImplBase {

        // List to  store thermostat readings
        private List<ThermostatReading> thermostatReadings;
        private int currentIndex = 0;

        public ThermostatServiceImpl() {
            // Initialize the thermostat readings list
            thermostatReadings = new ArrayList<ThermostatReading>();
            // Added some example thermostat readings to simulate the process

            thermostatReadings.add(new ThermostatReading(6.0));
            thermostatReadings.add(new ThermostatReading(5.0));
            thermostatReadings.add(new ThermostatReading(4.8));
            thermostatReadings.add(new ThermostatReading(4.9));
            thermostatReadings.add(new ThermostatReading(4.4));
            thermostatReadings.add(new ThermostatReading(4.2));
            thermostatReadings.add(new ThermostatReading(4.3));
            thermostatReadings.add(new ThermostatReading(4.0));
            thermostatReadings.add(new ThermostatReading(4.1));
            thermostatReadings.add(new ThermostatReading(4.0));
        }

        @Override
        // RPC method to get the current thermostat reading
        // Currently returns a fixed temperature (15)
        // In a real scenario, temperature is read from a sensor
        public void getCurrentThermostatReading(RequestSource request, StreamObserver<ThermostatReadingInformation> responseObserver) {
            double temperature = 15;

            ThermostatReadingInformation reading = ThermostatReadingInformation.newBuilder()
                    .setTemperature(temperature)
                    .build();
            responseObserver.onNext(reading);
            responseObserver.onCompleted();
        }

        @Override
        // RPC method to stream thermostat readings
        public void streamThermostatReadings(RequestSource request, StreamObserver<ThermostatReadingInformation> responseObserver) {

            try {
                // Loop through the list of thermostat readings
                for (ThermostatReading reading : thermostatReadings) {
                    // Send the reading to the client
                    ThermostatReadingInformation thermostatReadingInformation = ThermostatReadingInformation.newBuilder().setTemperature(reading.getTemperature()).build();
                    responseObserver.onNext(thermostatReadingInformation);

                    // Sleep for 5 seconds
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                // Handle interruptions if any
            } finally {
                // Complete the RPC call
                responseObserver.onCompleted();
            }
        }

        ;


    }
}
