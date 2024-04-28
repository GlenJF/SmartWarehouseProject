import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

import com.ncirl.smartwarehouse.LightRequest;
import com.ncirl.smartwarehouse.LightResponse;
import com.ncirl.smartwarehouse.LightSensorServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class LightSensorServer {


    private Server server;

    // Main Method to start Server
    public static void main(String[] args) throws IOException, InterruptedException {
        final LightSensorServer server = new LightSensorServer();
        server.start();
        server.blockUntilShutdown();
    }
    //Start Server
    public void start() throws IOException {
        int port = 50053;
        server = ServerBuilder.forPort(port)
                .addService(new LightSensorServiceImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        //Register Server on consul
        registerToConsul();

        // add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.shutdown();
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            LightSensorServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    // Register server to Consul for service discovery
    private void registerToConsul() {
        System.out.println("Registering server to Consul...");

        //Load Consul configuration
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/lightsensor.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        // Extract Consul configuration properties
        String consulHost = props.getProperty("consul.host");
        int consulPort = Integer.parseInt(props.getProperty("consul.port"));

        String serviceName = props.getProperty("lightsensor.service.name");
        int servicePort = Integer.parseInt(props.getProperty("lightsensor.service.port"));

        //Get Host Address
        String hostAddress;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }
        //Create Consul Client
        ConsulClient consulClient = new ConsulClient(consulHost, consulPort);
        //Define Service Details
        NewService newService = new NewService();
        newService.setName(serviceName);
        newService.setPort(servicePort);
        newService.setAddress(hostAddress);

        // Register with Consul
        consulClient.agentServiceRegister(newService);

        //Print Success Message
        System.out.println("Server registered to Consul successfully. Host: " + hostAddress);
    }

    // Stop Server
    void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    //Block until server shuts down
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    // Implementation of gRPC service
    static class LightSensorServiceImpl extends LightSensorServiceGrpc.LightSensorServiceImplBase {
        @Override
        public StreamObserver<LightRequest> adjustBrightness(final StreamObserver<LightResponse> responseObserver) {
            return new StreamObserver<LightRequest>() {
                @Override
                public void onNext(LightRequest request) {
                    // Get the luminous intesity from the request
                    int luminousIntensity = request.getLuminousIntensity();
                    // Initialize variables to indicate brightness adjustment
                    boolean increaseBrightness = false;
                    boolean decreaseBrightness = false;
                    // Check luminous intensity and set brightness
                    if (luminousIntensity > 30) {
                        increaseBrightness = true;
                    } else if (luminousIntensity < 50) {
                        decreaseBrightness = true;
                    }
                    // Create Response
                    LightResponse response = LightResponse.newBuilder()
                            .setIncreaseBrightness(increaseBrightness)
                            .setDecreaseBrightness(decreaseBrightness)
                            .build();
                    // Send the response to the client
                    responseObserver.onNext(response);
                }

                @Override
                // Handel Errors
                public void onError(Throwable t) {
                    System.err.println("Error from client: " + t.getMessage());
                }

                @Override
                // Complete the response Stream
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
