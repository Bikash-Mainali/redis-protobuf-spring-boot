// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/People.proto

package com.ecrr.fct.protobufgenerated;

public final class PeopleGeneratedClass {
  private PeopleGeneratedClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_People_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_People_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Person_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Person_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Address_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Address_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022proto/People.proto\"!\n\006People\022\027\n\006person" +
      "\030\001 \003(\0132\007.Person\"P\n\006Person\022\014\n\004name\030\001 \001(\t\022" +
      "\031\n\007address\030\002 \003(\0132\010.Address\022\016\n\006mobile\030\003 \003" +
      "(\t\022\r\n\005email\030\004 \003(\t\")\n\007Address\022\016\n\006street\030\001" +
      " \001(\t\022\016\n\006number\030\002 \001(\005B8\n\036com.ecrr.fct.pro" +
      "tobufgeneratedB\024PeopleGeneratedClassP\001b\006" +
      "proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_People_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_People_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_People_descriptor,
        new java.lang.String[] { "Person", });
    internal_static_Person_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Person_descriptor,
        new java.lang.String[] { "Name", "Address", "Mobile", "Email", });
    internal_static_Address_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Address_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Address_descriptor,
        new java.lang.String[] { "Street", "Number", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
