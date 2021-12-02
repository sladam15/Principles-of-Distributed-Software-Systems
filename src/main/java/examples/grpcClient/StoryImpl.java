package example.grpcclient;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerMethodDefinition;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import service.*;
import java.util.Stack;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import buffers.RequestProtos.Request;
import buffers.RequestProtos.Request.RequestType;
import buffers.ResponseProtos.Response;


// Implement the calc service. It has two services, read and write
class StoryImpl extends StoryGrpc.StoryImplBase {
    
    // having a global set of story
    Stack<String> story = new Stack<String>();
    
    public StoryImpl(){
        super();
        // copying some story
        story.add("Story 1 - I turned on the 10:00 pm news only to see one of the biggest secrets of my life playing out before my eyes.");
        story.add("Story 2 - When I flipped on the radio that night, I couldn’t believe the voice I heard coming through the speakers.");
        story.add("Story 3 - I suddenly found out that I was heir to a throne…");
        story.add("Story 4 - She opened the letter and it said she’d won $100,000.");
        
    }
    
    //@Override
    public void read(WriteRequest req, StreamObserver<ReadResponse> responseObserver) {
        
        System.out.println("Received from client: " + req.getNewSentence());
		story.add(req.getNewSentence());
        ReadResponse.Builder response = ReadResponse.newBuilder();

        response.setIsSuccess(true);

        ReadResponse resp = response.build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
 
	//@Override
    public void write(WriteRequest req, StreamObserver<WriteResponse> responseObserver) {
        
        System.out.println("Received from client: " + req.getNewSentence());
        story.add(req.getNewSentence());
        WriteResponse.Builder response = WriteResponse.newBuilder();
        response.setIsSuccess(true);
		response.setStory(req.getNewSentence());
        
        WriteResponse resp = response.build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
	
}