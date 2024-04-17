package com.ncirl.smartwarehouse;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: ThermostatService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ThermostatServiceGrpc {

  private ThermostatServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.ncirl.smartwarehouse.ThermostatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ncirl.smartwarehouse.RequestSource,
      com.ncirl.smartwarehouse.ThermostatReadingInformation> getGetCurrentThermostatReadingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCurrentThermostatReading",
      requestType = com.ncirl.smartwarehouse.RequestSource.class,
      responseType = com.ncirl.smartwarehouse.ThermostatReadingInformation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ncirl.smartwarehouse.RequestSource,
      com.ncirl.smartwarehouse.ThermostatReadingInformation> getGetCurrentThermostatReadingMethod() {
    io.grpc.MethodDescriptor<com.ncirl.smartwarehouse.RequestSource, com.ncirl.smartwarehouse.ThermostatReadingInformation> getGetCurrentThermostatReadingMethod;
    if ((getGetCurrentThermostatReadingMethod = ThermostatServiceGrpc.getGetCurrentThermostatReadingMethod) == null) {
      synchronized (ThermostatServiceGrpc.class) {
        if ((getGetCurrentThermostatReadingMethod = ThermostatServiceGrpc.getGetCurrentThermostatReadingMethod) == null) {
          ThermostatServiceGrpc.getGetCurrentThermostatReadingMethod = getGetCurrentThermostatReadingMethod =
              io.grpc.MethodDescriptor.<com.ncirl.smartwarehouse.RequestSource, com.ncirl.smartwarehouse.ThermostatReadingInformation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCurrentThermostatReading"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.smartwarehouse.RequestSource.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.smartwarehouse.ThermostatReadingInformation.getDefaultInstance()))
              .setSchemaDescriptor(new ThermostatServiceMethodDescriptorSupplier("getCurrentThermostatReading"))
              .build();
        }
      }
    }
    return getGetCurrentThermostatReadingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ncirl.smartwarehouse.RequestSource,
      com.ncirl.smartwarehouse.ThermostatReadingInformation> getStreamThermostatReadingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamThermostatReadings",
      requestType = com.ncirl.smartwarehouse.RequestSource.class,
      responseType = com.ncirl.smartwarehouse.ThermostatReadingInformation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.ncirl.smartwarehouse.RequestSource,
      com.ncirl.smartwarehouse.ThermostatReadingInformation> getStreamThermostatReadingsMethod() {
    io.grpc.MethodDescriptor<com.ncirl.smartwarehouse.RequestSource, com.ncirl.smartwarehouse.ThermostatReadingInformation> getStreamThermostatReadingsMethod;
    if ((getStreamThermostatReadingsMethod = ThermostatServiceGrpc.getStreamThermostatReadingsMethod) == null) {
      synchronized (ThermostatServiceGrpc.class) {
        if ((getStreamThermostatReadingsMethod = ThermostatServiceGrpc.getStreamThermostatReadingsMethod) == null) {
          ThermostatServiceGrpc.getStreamThermostatReadingsMethod = getStreamThermostatReadingsMethod =
              io.grpc.MethodDescriptor.<com.ncirl.smartwarehouse.RequestSource, com.ncirl.smartwarehouse.ThermostatReadingInformation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamThermostatReadings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.smartwarehouse.RequestSource.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.smartwarehouse.ThermostatReadingInformation.getDefaultInstance()))
              .setSchemaDescriptor(new ThermostatServiceMethodDescriptorSupplier("streamThermostatReadings"))
              .build();
        }
      }
    }
    return getStreamThermostatReadingsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ThermostatServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ThermostatServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ThermostatServiceStub>() {
        @java.lang.Override
        public ThermostatServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ThermostatServiceStub(channel, callOptions);
        }
      };
    return ThermostatServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ThermostatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ThermostatServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ThermostatServiceBlockingStub>() {
        @java.lang.Override
        public ThermostatServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ThermostatServiceBlockingStub(channel, callOptions);
        }
      };
    return ThermostatServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ThermostatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ThermostatServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ThermostatServiceFutureStub>() {
        @java.lang.Override
        public ThermostatServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ThermostatServiceFutureStub(channel, callOptions);
        }
      };
    return ThermostatServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    default void getCurrentThermostatReading(com.ncirl.smartwarehouse.RequestSource request,
        io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.ThermostatReadingInformation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCurrentThermostatReadingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC for health check
     * </pre>
     */
    default void streamThermostatReadings(com.ncirl.smartwarehouse.RequestSource request,
        io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.ThermostatReadingInformation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamThermostatReadingsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ThermostatService.
   */
  public static abstract class ThermostatServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ThermostatServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ThermostatService.
   */
  public static final class ThermostatServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ThermostatServiceStub> {
    private ThermostatServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ThermostatServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public void getCurrentThermostatReading(com.ncirl.smartwarehouse.RequestSource request,
        io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.ThermostatReadingInformation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCurrentThermostatReadingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC for health check
     * </pre>
     */
    public void streamThermostatReadings(com.ncirl.smartwarehouse.RequestSource request,
        io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.ThermostatReadingInformation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamThermostatReadingsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ThermostatService.
   */
  public static final class ThermostatServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ThermostatServiceBlockingStub> {
    private ThermostatServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ThermostatServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.ncirl.smartwarehouse.ThermostatReadingInformation getCurrentThermostatReading(com.ncirl.smartwarehouse.RequestSource request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCurrentThermostatReadingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server-side streaming RPC for health check
     * </pre>
     */
    public java.util.Iterator<com.ncirl.smartwarehouse.ThermostatReadingInformation> streamThermostatReadings(
        com.ncirl.smartwarehouse.RequestSource request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamThermostatReadingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ThermostatService.
   */
  public static final class ThermostatServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ThermostatServiceFutureStub> {
    private ThermostatServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ThermostatServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ncirl.smartwarehouse.ThermostatReadingInformation> getCurrentThermostatReading(
        com.ncirl.smartwarehouse.RequestSource request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCurrentThermostatReadingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_THERMOSTAT_READING = 0;
  private static final int METHODID_STREAM_THERMOSTAT_READINGS = 1;

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
        case METHODID_GET_CURRENT_THERMOSTAT_READING:
          serviceImpl.getCurrentThermostatReading((com.ncirl.smartwarehouse.RequestSource) request,
              (io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.ThermostatReadingInformation>) responseObserver);
          break;
        case METHODID_STREAM_THERMOSTAT_READINGS:
          serviceImpl.streamThermostatReadings((com.ncirl.smartwarehouse.RequestSource) request,
              (io.grpc.stub.StreamObserver<com.ncirl.smartwarehouse.ThermostatReadingInformation>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetCurrentThermostatReadingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.ncirl.smartwarehouse.RequestSource,
              com.ncirl.smartwarehouse.ThermostatReadingInformation>(
                service, METHODID_GET_CURRENT_THERMOSTAT_READING)))
        .addMethod(
          getStreamThermostatReadingsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.ncirl.smartwarehouse.RequestSource,
              com.ncirl.smartwarehouse.ThermostatReadingInformation>(
                service, METHODID_STREAM_THERMOSTAT_READINGS)))
        .build();
  }

  private static abstract class ThermostatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ThermostatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ncirl.smartwarehouse.ThermostatServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ThermostatService");
    }
  }

  private static final class ThermostatServiceFileDescriptorSupplier
      extends ThermostatServiceBaseDescriptorSupplier {
    ThermostatServiceFileDescriptorSupplier() {}
  }

  private static final class ThermostatServiceMethodDescriptorSupplier
      extends ThermostatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ThermostatServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ThermostatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ThermostatServiceFileDescriptorSupplier())
              .addMethod(getGetCurrentThermostatReadingMethod())
              .addMethod(getStreamThermostatReadingsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
