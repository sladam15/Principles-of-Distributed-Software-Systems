// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/weather.proto

package service;

public final class WeatherProto {
  private WeatherProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_WeatherCoordinateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_WeatherCoordinateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_WeatherCityRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_WeatherCityRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_WeatherResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_WeatherResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_CitiesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_CitiesResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026services/weather.proto\022\010services\032\024serv" +
      "ices/story.proto\"?\n\030WeatherCoordinateReq" +
      "uest\022\020\n\010latitude\030\001 \001(\001\022\021\n\tlongitude\030\002 \001(" +
      "\001\"&\n\022WeatherCityRequest\022\020\n\010cityName\030\001 \001(" +
      "\t\"w\n\017WeatherResponse\022\021\n\tisSuccess\030\001 \001(\010\022" +
      "\r\n\005error\030\002 \001(\t\022\023\n\013currentTemp\030\003 \001(\001\022\031\n\021c" +
      "urrentConditions\030\004 \001(\t\022\022\n\ndailyHighs\030\005 \003" +
      "(\001\"D\n\016CitiesResponse\022\021\n\tisSuccess\030\001 \001(\010\022" +
      "\r\n\005error\030\002 \001(\t\022\020\n\010cityName\030\003 \003(\t2\333\001\n\007Wea" +
      "ther\022P\n\ratCoordinates\022\".services.Weather" +
      "CoordinateRequest\032\031.services.WeatherResp" +
      "onse\"\000\022C\n\006inCity\022\034.services.WeatherCityR" +
      "equest\032\031.services.WeatherResponse\"\000\0229\n\nl" +
      "istCities\022\017.services.Empty\032\030.services.Ci" +
      "tiesResponse\"\000B\031\n\007serviceB\014WeatherProtoP" +
      "\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          service.StoryProto.getDescriptor(),
        });
    internal_static_services_WeatherCoordinateRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_services_WeatherCoordinateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_WeatherCoordinateRequest_descriptor,
        new java.lang.String[] { "Latitude", "Longitude", });
    internal_static_services_WeatherCityRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_services_WeatherCityRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_WeatherCityRequest_descriptor,
        new java.lang.String[] { "CityName", });
    internal_static_services_WeatherResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_services_WeatherResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_WeatherResponse_descriptor,
        new java.lang.String[] { "IsSuccess", "Error", "CurrentTemp", "CurrentConditions", "DailyHighs", });
    internal_static_services_CitiesResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_services_CitiesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_CitiesResponse_descriptor,
        new java.lang.String[] { "IsSuccess", "Error", "CityName", });
    service.StoryProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}