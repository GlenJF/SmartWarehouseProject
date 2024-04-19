package com.ncirl.smartwarehouse;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: LightSensorService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LightSensorServiceGrpc {

  private LightSensorServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.ncirl.smartwarehouse.LightSensorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ncirl.smartwarehouse.LightRequest,
      com.ncirl.smartwarehouse.LightResponse> getAdjustBrightnessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AdjustBrightness",
      requestType = com.ncirl.smartwarehouse.LightRequest.class,
      responseType = com.ncirl.smartwarehouse.LightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.ncirl.smartwarehouse.LightRequest,
      com.ncirl.smartwarehouse.LightResponse> getAdjustBrightnessMethod() {
    io.grpc.MethodDescriptor<com.ncirl.smartwarehouse.LightRequest, com.ncirl.smartwarehouse.LightResponse> getAdjustBrightnessMethod;
    if ((getAdjustBrightnessMethod = LightSensorServiceGrpc.getAdjustBrightnessMethod) == null) {
      synchronized (LightSensorServiceGrpc.class) {
        if ((getAdjustBrightnessMethod = LightSensorServiceGrpc.getAdjustBrightnessMethod) == null) {
          LightSensorServiceGrpc.getAdjustBrightnessMethod = getAdjustBrightnessMethod =
              io.grpc.MethodDescriptor.<com.ncirl.smartwarehouse.LightRequest, com.ncirl.smartwarehouse.LightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AdjustBrightness"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.smartwarehouse.LightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.smartwarehouse.LightResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LightSensorServiceMethodDescriptorSupplier("AdjustBrightness"))
              .build();
        }
      }
    }
    return getAdjustBrightnessMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightSensorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightSensorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightSensorServiceStub>() {
        @java.lang.Override
        public LightSensorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightSensorServiceStub(channel, callOptions);
        }
      };
    return LightSensorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightSensorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightSensorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightSensorServiceBlockingStub>() {
        @java.lang.Override
        public LightSensorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightSensorServiceBlockingStub(channel, callOptions);
        }
      };
    return LightSensorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightSensorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightSensorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightSensorServiceFutureStub>() {
        @java.lang.Override
        public LightSensorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightSensorServiceFutureStub(channel, callOptions);
        }
      };
    return LightSensorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.LightRequest> adjustBrightness(
        io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.LightResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAdjustBrightnessMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LightSensorService.
   */
  public static abstract class LightSensorServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LightSensorServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LightSensorService.
   */
  public static final class LightSensorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LightSensorServiceStub> {
    private LightSensorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightSensorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightSensorServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.LightRequest> adjustBrightness(
        io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.LightResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getAdjustBrightnessMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LightSensorService.
   */
  public static final class LightSensorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LightSensorServiceBlockingStub> {
    private LightSensorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightSensorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightSensorServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LightSensorService.
   */
  public static final class LightSensorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LightSensorServiceFutureStub> {
    private LightSensorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightSensorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightSensorServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ADJUST_BRIGHTNESS = 0;

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
        case METHODID_ADJUST_BRIGHTNESS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.adjustBrightness(
              (io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.LightResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAdjustBrightnessMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.ncirl.smartwarehouse.LightRequest,
              com.ncirl.smartwarehouse.LightResponse>(
                service, METHODID_ADJUST_BRIGHTNESS)))
        .build();
  }

  private static abstract class LightSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightSensorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ncirl.smartwarehouse.LightSensorServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightSensorService");
    }
  }

  private static final class LightSensorServiceFileDescriptorSupplier
      extends LightSensorServiceBaseDescriptorSupplier {
    LightSensorServiceFileDescriptorSupplier() {}
  }

  private static final class LightSensorServiceMethodDescriptorSupplier
      extends LightSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LightSensorServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LightSensorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightSensorServiceFileDescriptorSupplier())
              .addMethod(getAdjustBrightnessMethod())
              .build();
        }
      }
    }
    return result;
  }
}
