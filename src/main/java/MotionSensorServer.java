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
import java.util.Properties;

public class MotionSensorServer {

    private Server server;

    // Start the Server
    public void start() throws IOException {
        /* The port on which the server should run */
        int port = 50052;
        // Create and start the server
        server = ServerBuilder.forPort(port)
                .addService(new MotionSensorServiceImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        // Register server to Consul
        registerToConsul();

        // Add shutdown hook to gracefully shu down the server
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            MotionSensorServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

   //Method to stop the server
    void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
// Block until the server shuts down
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    // Register server on Consul for service discovery
    private void registerToConsul() {
        System.out.println("Registering server to Consul...");

        // Load Consul configuration from .properties file
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/motionsensor.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Extract Consul configuration properties
        String consulHost = props.getProperty("consul.host");
        int consulPort = Integer.parseInt(props.getProperty("consul.port"));

        String serviceName = props.getProperty("motionsensor.service.name");
        int servicePort = Integer.parseInt(props.getProperty("motionsensor.service.port"));
        String healthCheckInterval = props.getProperty("motionsensor.service.healthCheckInterval");

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
    // Main method to start the server
    public static void main(String[] args) throws IOException, InterruptedException {
        final MotionSensorServer server = new MotionSensorServer();
        server.start();
        server.blockUntilShutdown();
    }
    // Implementation of gRPC service
    private static class MotionSensorServiceImpl extends MotionSensorServiceGrpc.MotionSensorServiceImplBase{

        @Override
        public StreamObserver<DetectMotionStatusRequest> detectMotion(StreamObserver<DetectMotionResponse> responseObserver) {
             System.out.println("Client connected for motion detection");
         // Return a stream observer to handel  motion detection requests from the client
            return new StreamObserver<DetectMotionStatusRequest>() {
                StringBuilder status = new StringBuilder();

                @Override
                // Handel motion detection requests from clients
                public void onNext(DetectMotionStatusRequest request) {

                System.out.println("Received motion detection request from client: " + request.getIsMotionDetected());
                 status.append(request.getIsMotionDetected() ? "Motion detected, " : "No motion detected, ");
                }

                @Override
                // handel errors
                public void onError(Throwable t) {
                    System.err.println("Error in receiving motion detection status: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // After receiving all messages from the client, send a single response
                    responseObserver.onNext(DetectMotionResponse.newBuilder().setMessage(status.toString()).build());
                    responseObserver.onCompleted();
                }
            };
        }
    }
}