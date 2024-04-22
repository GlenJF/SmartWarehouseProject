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

    private void start() throws IOException {
        int port = 5005;
        server = ServerBuilder.forPort(port)
                .addService(new LightSensorServiceImpl())
                .build()
                .start();

        registerToConsul();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.shutdown();
        }));
    }

    private void registerToConsul() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/consul.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String consulHost = props.getProperty("consul.host");
        int consulPort = Integer.parseInt(props.getProperty("consul.port"));

        String serviceName = props.getProperty("lightsensor.service.name");
        int servicePort = Integer.parseInt(props.getProperty("lightsensor.service.port"));

        String hostAddress;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }

        ConsulClient consulClient = new ConsulClient(consulHost, consulPort);

        NewService newService = new NewService();
        newService.setName(serviceName);
        newService.setPort(servicePort);
        newService.setAddress(hostAddress);

        consulClient.agentServiceRegister(newService);
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

    public static void main(String[] args) throws IOException, InterruptedException {
        final LightSensorServer server = new LightSensorServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class LightSensorServiceImpl extends LightSensorServiceGrpc.LightSensorServiceImplBase {
        @Override
        public StreamObserver<LightRequest> adjustBrightness(final StreamObserver<LightResponse> responseObserver) {
            return new StreamObserver<LightRequest>() {
                @Override
                public void onNext(LightRequest request) {
                    int luminousIntensity = request.getLuminousIntensity();

                    boolean increaseBrightness = false;
                    boolean decreaseBrightness = false;

                    if (luminousIntensity > 50) {
                        increaseBrightness = true;
                    } else if (luminousIntensity < 20) {
                        decreaseBrightness = true;
                    }

                    LightResponse response = LightResponse.newBuilder()
                            .setIncreaseBrightness(increaseBrightness)
                            .setDecreaseBrightness(decreaseBrightness)
                            .build();
                    responseObserver.onNext(response);
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error from client: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
