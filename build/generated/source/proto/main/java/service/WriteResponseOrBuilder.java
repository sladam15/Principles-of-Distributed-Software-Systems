// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/story.proto

package service;

public interface WriteResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:services.WriteResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool isSuccess = 1;</code>
   * @return The isSuccess.
   */
  boolean getIsSuccess();

  /**
   * <pre>
   * The new storyline
   * </pre>
   *
   * <code>string story = 2;</code>
   * @return The story.
   */
  java.lang.String getStory();
  /**
   * <pre>
   * The new storyline
   * </pre>
   *
   * <code>string story = 2;</code>
   * @return The bytes for story.
   */
  com.google.protobuf.ByteString
      getStoryBytes();

  /**
   * <pre>
   * Error message, a String of your choice to show what went wrong
   * </pre>
   *
   * <code>string error = 3;</code>
   * @return The error.
   */
  java.lang.String getError();
  /**
   * <pre>
   * Error message, a String of your choice to show what went wrong
   * </pre>
   *
   * <code>string error = 3;</code>
   * @return The bytes for error.
   */
  com.google.protobuf.ByteString
      getErrorBytes();
}
