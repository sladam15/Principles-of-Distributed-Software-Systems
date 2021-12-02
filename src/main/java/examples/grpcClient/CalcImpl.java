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


// Implement the calc service. It has four services, add, subtract, multiply, and divide.
class CalcImpl extends CalcGrpc.CalcImplBase {
    
    // having a global set of numbers
    Stack<Double> numbers = new Stack<Double>();
    
    public CalcImpl(){
        super();
        // copying some numbers
        numbers.add(5.0);
        numbers.add(2.5);
        numbers.add(2.2);
        numbers.add(1.0);
		numbers.add(5.7);
        numbers.add(8.2);
		numbers.add(3.4);
        numbers.add(9.1);
        
    }
    
    
    @Override
    public void add(CalcRequest req, StreamObserver<CalcResponse> responseObserver) {
		double total = 0.0;
        
        System.out.println("Received from client: " + req.getNumCount());
        CalcResponse.Builder response = CalcResponse.newBuilder();
        for (int i=0; i < 3; i++){
            if(!numbers.empty()) {
                response.setIsSuccess(true);
				System.out.println("Number used: " + numbers);
				total = total + numbers.get(i);
				response.setSolution(total);
				
            }
            else {
                response.setIsSuccess(false); 
                break;
            }
        }
        CalcResponse resp = response.build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
	
	@Override
    public void subtract(CalcRequest req, StreamObserver<CalcResponse> responseObserver) {
		double total = 0.0;
        
        System.out.println("Received from client: " + req.getNumCount());
        CalcResponse.Builder response = CalcResponse.newBuilder();
        for (int i=0; i < 3; i++){
            if(!numbers.empty()) {
                response.setIsSuccess(true);
				System.out.println("Number used: " + numbers);
				total = total - numbers.get(i);
				response.setSolution(total);
            }
            else {
                response.setIsSuccess(false); 
                break;
            }
        }
        CalcResponse resp = response.build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
	
	@Override
    public void multiply(CalcRequest req, StreamObserver<CalcResponse> responseObserver) {
		double total = 1.0;
        
        System.out.println("Received from client: " + req.getNumCount());
        CalcResponse.Builder response = CalcResponse.newBuilder();
        for (int i=0; i < 3; i++){
            if(!numbers.empty()) {
                response.setIsSuccess(true);
				System.out.println("Number used: " + numbers);
				total = total * numbers.get(i);
				response.setSolution(total);
            }
            else {
                response.setIsSuccess(false); 
                break;
            }
        }
        CalcResponse resp = response.build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
	
	@Override
    public void divide(CalcRequest req, StreamObserver<CalcResponse> responseObserver) {
		double total = 1.0;
        
        System.out.println("Received from client: " + req.getNumCount());
        CalcResponse.Builder response = CalcResponse.newBuilder();
        for (int i=0; i < 3; i++){
            if(!numbers.empty()) {
                response.setIsSuccess(true);
				System.out.println("Number used: " + numbers);
				total = total/numbers.get(i);
				response.setSolution(total);
            }
            else {
                response.setIsSuccess(false); 
                break;
            }
        }
        CalcResponse resp = response.build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
    
    
}