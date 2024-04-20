/*import com.ecwid.consul.v1.ConsulClient;
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

    private void start() throws IOException {
        /* The port on which the server should run
        int port = 50053;
        server = ServerBuilder.forPort(port)
                .addService(new LightSensorServiceImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        // Register server to Consul
        registerToConsul();

        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            LightSensorServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private void registerToConsul() {
        System.out.println("Registering server to Consul...");

        // Load Consul configuration from consul.properties file
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
        String healthCheckInterval = props.getProperty("lightsensor.service.healthCheckInterval");

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

    public static void main(String[] args) throws IOException, InterruptedException {
        final LightSensorServer server = new LightSensorServer();
        server.start();
        server.blockUntilShutdown();
    }

    // Static inner class
    static class LightSensorServiceImpl extends LightSensorServiceGrpc.LightSensorServiceImplBase {

        @Override
        public StreamObserver<LightRequest> adjustBrightness(StreamObserver<LightResponse> responseObserver) {
            // put in your code here to make the grpc request and handle the response
            return new StreamObserver<LightRequest>() {
                @Override
                public void onNext(LightRequest lightRequest) {

                }

                @Override
                public void onError(Throwable throwable) {

                }

                @Override
                public void onCompleted() {

                }


    }

*/