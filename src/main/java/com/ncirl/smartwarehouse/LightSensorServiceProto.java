// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LightSensorService.proto

package com.ncirl.smartwarehouse;

public final class LightSensorServiceProto {
  private LightSensorServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_smartwarehouse_LightRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_smartwarehouse_LightRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_smartwarehouse_LightResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_smartwarehouse_LightResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\030LightSensorService.proto\022\030com.ncirl.sm" +
      "artwarehouse\")\n\014LightRequest\022\031\n\021luminous" +
      "Intensity\030\001 \001(\005\"G\n\rLightResponse\022\032\n\022incr" +
      "easeBrightness\030\001 \001(\010\022\032\n\022decreaseBrightne" +
      "ss\030\002 \001(\0102\177\n\022LightSensorService\022i\n\020Adjust" +
      "Brightness\022&.com.ncirl.smartwarehouse.Li" +
      "ghtRequest\032\'.com.ncirl.smartwarehouse.Li" +
      "ghtResponse\"\000(\0010\001B5\n\030com.ncirl.smartware" +
      "houseB\027LightSensorServiceProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_ncirl_smartwarehouse_LightRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_ncirl_smartwarehouse_LightRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_smartwarehouse_LightRequest_descriptor,
        new java.lang.String[] { "LuminousIntensity", });
    internal_static_com_ncirl_smartwarehouse_LightResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_ncirl_smartwarehouse_LightResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_smartwarehouse_LightResponse_descriptor,
        new java.lang.String[] { "IncreaseBrightness", "DecreaseBrightness", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}