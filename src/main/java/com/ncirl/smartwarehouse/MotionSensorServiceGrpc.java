package com.ncirl.smartwarehouse;

import io.grpc.stub.StreamObserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: MotionSensorService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MotionSensorServiceGrpc {

  private MotionSensorServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.ncirl.smartwarehouse.MotionSensorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ncirl.smartwarehouse.DetectMotionStatusRequest,
      com.ncirl.smartwarehouse.DetectMotionResponse> getDetectMotionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "detectMotion",
      requestType = com.ncirl.smartwarehouse.DetectMotionStatusRequest.class,
      responseType = com.ncirl.smartwarehouse.DetectMotionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.ncirl.smartwarehouse.DetectMotionStatusRequest,
      com.ncirl.smartwarehouse.DetectMotionResponse> getDetectMotionMethod() {
    io.grpc.MethodDescriptor<com.ncirl.smartwarehouse.DetectMotionStatusRequest, com.ncirl.smartwarehouse.DetectMotionResponse> getDetectMotionMethod;
    if ((getDetectMotionMethod = MotionSensorServiceGrpc.getDetectMotionMethod) == null) {
      synchronized (MotionSensorServiceGrpc.class) {
        if ((getDetectMotionMethod = MotionSensorServiceGrpc.getDetectMotionMethod) == null) {
          MotionSensorServiceGrpc.getDetectMotionMethod = getDetectMotionMethod =
              io.grpc.MethodDescriptor.<com.ncirl.smartwarehouse.DetectMotionStatusRequest, com.ncirl.smartwarehouse.DetectMotionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "detectMotion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.smartwarehouse.DetectMotionStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.smartwarehouse.DetectMotionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MotionSensorServiceMethodDescriptorSupplier("detectMotion"))
              .build();
        }
      }
    }
    return getDetectMotionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MotionSensorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MotionSensorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MotionSensorServiceStub>() {
        @java.lang.Override
        public MotionSensorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MotionSensorServiceStub(channel, callOptions);
        }
      };
    return MotionSensorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MotionSensorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MotionSensorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MotionSensorServiceBlockingStub>() {
        @java.lang.Override
        public MotionSensorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MotionSensorServiceBlockingStub(channel, callOptions);
        }
      };
    return MotionSensorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MotionSensorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MotionSensorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MotionSensorServiceFutureStub>() {
        @java.lang.Override
        public MotionSensorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MotionSensorServiceFutureStub(channel, callOptions);
        }
      };
    return MotionSensorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Server-side streaming RPC to receive motion detection updates
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.DetectMotionStatusRequest> detectMotion(
        io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.DetectMotionResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getDetectMotionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MotionSensorService.
   */
  public static abstract class MotionSensorServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MotionSensorServiceGrpc.bindService(this);
    }

      public abstract void detectMotion(DetectMotionStatusRequest request, StreamObserver<DetectMotionResponse> responseObserver);
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MotionSensorService.
   */
  public static final class MotionSensorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MotionSensorServiceStub> {
    private MotionSensorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MotionSensorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MotionSensorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server-side streaming RPC to receive motion detection updates
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.DetectMotionStatusRequest> detectMotion(
        io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.DetectMotionResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getDetectMotionMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MotionSensorService.
   */
  public static final class MotionSensorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MotionSensorServiceBlockingStub> {
    private MotionSensorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MotionSensorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MotionSensorServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MotionSensorService.
   */
  public static final class MotionSensorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MotionSensorServiceFutureStub> {
    private MotionSensorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MotionSensorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MotionSensorServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_DETECT_MOTION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DETECT_MOTION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.detectMotion(
              (io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.DetectMotionResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getDetectMotionMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.ncirl.smartwarehouse.DetectMotionStatusRequest,
              com.ncirl.smartwarehouse.DetectMotionResponse>(
                service, METHODID_DETECT_MOTION)))
        .build();
  }

  private static abstract class MotionSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MotionSensorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ncirl.smartwarehouse.MotionSensorServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MotionSensorService");
    }
  }

  private static final class MotionSensorServiceFileDescriptorSupplier
      extends MotionSensorServiceBaseDescriptorSupplier {
    MotionSensorServiceFileDescriptorSupplier() {}
  }

  private static final class MotionSensorServiceMethodDescriptorSupplier
      extends MotionSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MotionSensorServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MotionSensorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MotionSensorServiceFileDescriptorSupplier())
              .addMethod(getDetectMotionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
