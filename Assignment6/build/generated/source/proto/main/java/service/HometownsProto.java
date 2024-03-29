// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/hometowns.proto

package service;

public final class HometownsProto {
  private HometownsProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_HometownsReadResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_HometownsReadResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_HometownsSearchRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_HometownsSearchRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_HometownsWriteRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_HometownsWriteRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_HometownsWriteResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_HometownsWriteResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_Hometown_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_Hometown_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\030services/hometowns.proto\022\010services\032\024se" +
      "rvices/story.proto\"`\n\025HometownsReadRespo" +
      "nse\022\021\n\tisSuccess\030\001 \001(\010\022%\n\thometowns\030\002 \003(" +
      "\0132\022.services.Hometown\022\r\n\005error\030\003 \001(\t\"&\n\026" +
      "HometownsSearchRequest\022\014\n\004city\030\001 \001(\t\"=\n\025" +
      "HometownsWriteRequest\022$\n\010hometown\030\001 \001(\0132" +
      "\022.services.Hometown\":\n\026HometownsWriteRes" +
      "ponse\022\021\n\tisSuccess\030\001 \001(\010\022\r\n\005error\030\002 \001(\t\"" +
      "6\n\010Hometown\022\014\n\004name\030\001 \001(\t\022\014\n\004city\030\002 \001(\t\022" +
      "\016\n\006region\030\003 \001(\t2\344\001\n\tHometowns\022:\n\004read\022\017." +
      "services.Empty\032\037.services.HometownsReadR" +
      "esponse\"\000\022M\n\006search\022 .services.Hometowns" +
      "SearchRequest\032\037.services.HometownsReadRe" +
      "sponse\"\000\022L\n\005write\022\037.services.HometownsWr" +
      "iteRequest\032 .services.HometownsWriteResp" +
      "onse\"\000B\033\n\007serviceB\016HometownsProtoP\001b\006pro" +
      "to3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          service.StoryProto.getDescriptor(),
        });
    internal_static_services_HometownsReadResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_services_HometownsReadResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_HometownsReadResponse_descriptor,
        new java.lang.String[] { "IsSuccess", "Hometowns", "Error", });
    internal_static_services_HometownsSearchRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_services_HometownsSearchRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_HometownsSearchRequest_descriptor,
        new java.lang.String[] { "City", });
    internal_static_services_HometownsWriteRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_services_HometownsWriteRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_HometownsWriteRequest_descriptor,
        new java.lang.String[] { "Hometown", });
    internal_static_services_HometownsWriteResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_services_HometownsWriteResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_HometownsWriteResponse_descriptor,
        new java.lang.String[] { "IsSuccess", "Error", });
    internal_static_services_Hometown_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_services_Hometown_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_Hometown_descriptor,
        new java.lang.String[] { "Name", "City", "Region", });
    service.StoryProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
