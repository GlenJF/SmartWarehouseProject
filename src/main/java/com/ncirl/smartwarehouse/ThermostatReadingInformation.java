// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ThermostatService.proto

package com.ncirl.smartwarehouse;

/**
 * Protobuf type {@code com.ncirl.smartwarehouse.ThermostatReadingInformation}
 */
public  final class ThermostatReadingInformation extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ncirl.smartwarehouse.ThermostatReadingInformation)
    ThermostatReadingInformationOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ThermostatReadingInformation.newBuilder() to construct.
  private ThermostatReadingInformation(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ThermostatReadingInformation() {
    temperature_ = 0D;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ThermostatReadingInformation(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 9: {

            temperature_ = input.readDouble();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ncirl.smartwarehouse.ThermostatServiceProto.internal_static_com_ncirl_smartwarehouse_ThermostatReadingInformation_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ncirl.smartwarehouse.ThermostatServiceProto.internal_static_com_ncirl_smartwarehouse_ThermostatReadingInformation_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ncirl.smartwarehouse.ThermostatReadingInformation.class, com.ncirl.smartwarehouse.ThermostatReadingInformation.Builder.class);
  }

  public static final int TEMPERATURE_FIELD_NUMBER = 1;
  private double temperature_;
  /**
   * <code>double temperature = 1;</code>
   */
  public double getTemperature() {
    return temperature_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (temperature_ != 0D) {
      output.writeDouble(1, temperature_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (temperature_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, temperature_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.ncirl.smartwarehouse.ThermostatReadingInformation)) {
      return super.equals(obj);
    }
    com.ncirl.smartwarehouse.ThermostatReadingInformation other = (com.ncirl.smartwarehouse.ThermostatReadingInformation) obj;

    boolean result = true;
    result = result && (
        java.lang.Double.doubleToLongBits(getTemperature())
        == java.lang.Double.doubleToLongBits(
            other.getTemperature()));
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TEMPERATURE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getTemperature()));
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ncirl.smartwarehouse.ThermostatReadingInformation parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ncirl.smartwarehouse.ThermostatReadingInformation parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ncirl.smartwarehouse.ThermostatReadingInformation parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ncirl.smartwarehouse.ThermostatReadingInformation parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ncirl.smartwarehouse.ThermostatReadingInformation parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ncirl.smartwarehouse.ThermostatReadingInformation parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ncirl.smartwarehouse.ThermostatReadingInformation parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ncirl.smartwarehouse.ThermostatReadingInformation parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ncirl.smartwarehouse.ThermostatReadingInformation parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ncirl.smartwarehouse.ThermostatReadingInformation parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ncirl.smartwarehouse.ThermostatReadingInformation parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ncirl.smartwarehouse.ThermostatReadingInformation parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.ncirl.smartwarehouse.ThermostatReadingInformation prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.ncirl.smartwarehouse.ThermostatReadingInformation}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ncirl.smartwarehouse.ThermostatReadingInformation)
      com.ncirl.smartwarehouse.ThermostatReadingInformationOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ncirl.smartwarehouse.ThermostatServiceProto.internal_static_com_ncirl_smartwarehouse_ThermostatReadingInformation_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ncirl.smartwarehouse.ThermostatServiceProto.internal_static_com_ncirl_smartwarehouse_ThermostatReadingInformation_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ncirl.smartwarehouse.ThermostatReadingInformation.class, com.ncirl.smartwarehouse.ThermostatReadingInformation.Builder.class);
    }

    // Construct using com.ncirl.smartwarehouse.ThermostatReadingInformation.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      temperature_ = 0D;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ncirl.smartwarehouse.ThermostatServiceProto.internal_static_com_ncirl_smartwarehouse_ThermostatReadingInformation_descriptor;
    }

    @java.lang.Override
    public com.ncirl.smartwarehouse.ThermostatReadingInformation getDefaultInstanceForType() {
      return com.ncirl.smartwarehouse.ThermostatReadingInformation.getDefaultInstance();
    }

    @java.lang.Override
    public com.ncirl.smartwarehouse.ThermostatReadingInformation build() {
      com.ncirl.smartwarehouse.ThermostatReadingInformation result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ncirl.smartwarehouse.ThermostatReadingInformation buildPartial() {
      com.ncirl.smartwarehouse.ThermostatReadingInformation result = new com.ncirl.smartwarehouse.ThermostatReadingInformation(this);
      result.temperature_ = temperature_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.ncirl.smartwarehouse.ThermostatReadingInformation) {
        return mergeFrom((com.ncirl.smartwarehouse.ThermostatReadingInformation)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ncirl.smartwarehouse.ThermostatReadingInformation other) {
      if (other == com.ncirl.smartwarehouse.ThermostatReadingInformation.getDefaultInstance()) return this;
      if (other.getTemperature() != 0D) {
        setTemperature(other.getTemperature());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.ncirl.smartwarehouse.ThermostatReadingInformation parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.ncirl.smartwarehouse.ThermostatReadingInformation) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private double temperature_ ;
    /**
     * <code>double temperature = 1;</code>
     */
    public double getTemperature() {
      return temperature_;
    }
    /**
     * <code>double temperature = 1;</code>
     */
    public Builder setTemperature(double value) {
      
      temperature_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double temperature = 1;</code>
     */
    public Builder clearTemperature() {
      
      temperature_ = 0D;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.ncirl.smartwarehouse.ThermostatReadingInformation)
  }

  // @@protoc_insertion_point(class_scope:com.ncirl.smartwarehouse.ThermostatReadingInformation)
  private static final com.ncirl.smartwarehouse.ThermostatReadingInformation DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ncirl.smartwarehouse.ThermostatReadingInformation();
  }

  public static com.ncirl.smartwarehouse.ThermostatReadingInformation getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ThermostatReadingInformation>
      PARSER = new com.google.protobuf.AbstractParser<ThermostatReadingInformation>() {
    @java.lang.Override
    public ThermostatReadingInformation parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ThermostatReadingInformation(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ThermostatReadingInformation> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ThermostatReadingInformation> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ncirl.smartwarehouse.ThermostatReadingInformation getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

