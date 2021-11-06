package UDP;

import java.io.*;
import java.net.*;

public class UDPServer {
	public static void main(String args[]) {
		DatagramSocket sock = null;
		
		try {
			sock = new DatagramSocket(8080);
			System.out.println("Server waiting for connections.");
			
			byte[] buffer = new byte[65536];
			DatagramPacket receive = new DatagramPacket(buffer, buffer.length);
			
			while(true) {
				sock.receive(receive);
				System.out.println("Client has connected to server.");
				byte[] data = receive.getData();
				String userName = new String(data, 0, receive.getLength());
				
				System.out.println("Received string of " + userName);
				DatagramPacket sent = new DatagramPacket(userName.getBytes() , userName.getBytes().length , receive.getAddress() , receive.getPort());
				sock.send(sent);
				
				// NUMBER OF QUESTIONS
				byte[] buffer2 = new byte[65536];
				DatagramPacket receive2 = new DatagramPacket(buffer2, buffer2.length);
				sock.receive(receive2);
				byte[] data2 = receive2.getData();
				String numQuestions = new String(data2, 0, receive2.getLength());
				
				System.out.println("Received an integer of " + numQuestions);
				DatagramPacket sent2 = new DatagramPacket(numQuestions.getBytes(), numQuestions.getBytes().length , receive2.getAddress() , receive2.getPort());
				sock.send(sent2);
				
				// String of 'start' or 'exit'
				byte[] buffer3 = new byte[65536];
				DatagramPacket receive3 = new DatagramPacket(buffer3, buffer3.length);
				sock.receive(receive3);
				byte[] data3 = receive3.getData();
				String message = new String(data3, 0, receive3.getLength());
				
				System.out.println("Received a String of " + message);
				DatagramPacket sent3 = new DatagramPacket(message.getBytes(), message.getBytes().length , receive2.getAddress() , receive2.getPort());
				sock.send(sent3);
				
			}
		}
		
		catch(IOException e){
			System.err.println("IOException " + e);
		}
	}
}
