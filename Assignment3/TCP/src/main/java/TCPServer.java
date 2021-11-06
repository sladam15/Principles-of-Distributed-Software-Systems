package TCP;

import java.net.*;
import java.io.*;

public class TCPServer {
	public static void main (String args[])throws Exception {
		Boolean connected = false;
		ObjectInputStream in = null;
		OutputStream out = null;
		ObjectOutputStream os = null;
		String receviedString = "";
		Integer receivedInt = 0;
		ServerSocket sock = null;
		
		try {
			
			// Opens socket
			Socket serv = null;

			sock = new ServerSocket(8080); // create server socket on port 8080
			System.out.println("Server ready for a connection");
			
			try {
				while(true){
					
					if(!connected){
						System.out.println("Server waiting for a connection");
						serv = sock.accept(); // blocking wait					
						in = new ObjectInputStream(serv.getInputStream());
						out = serv.getOutputStream();
						os = new ObjectOutputStream(out);
						connected = true;
						System.out.println("Server connected to client");
					}

					if (in != null){
						receviedString = (String) in.readObject();
						System.out.println("Client entered name: "+ receviedString);
						
						receivedInt = (Integer) in.readObject();
						System.out.println("Client entered number of questions: "+ receivedInt);
						
						String receivedString2 = (String) in.readObject();
						System.out.println("Client entered string: " + receivedString2);
						
						// Question 1
						String receivedString3 = (String) in.readObject();
						System.out.println("Client entered string: " + receivedString3);
						
						if (receivedString3.equalsIgnoreCase("next")) {
							System.out.println("Client has chosen to skip a question");
							String receivedString4 = (String) in.readObject();
							System.out.println("Client entered string: " + receivedString4);
						}
						
						// Question 2
						String receivedString5 = (String) in.readObject();
						System.out.println("Client entered string: " + receivedString5);
						
						if (receivedString5.equalsIgnoreCase("next")) {
							System.out.println("Client has chosen to skip a question");
							String receivedString6 = (String) in.readObject();
							System.out.println("Client entered string: " + receivedString6);
						}
						
						// Question 3
						String receivedString7 = (String) in.readObject();
						System.out.println("Client entered string: " + receivedString7);
						
						if (receivedString7.equalsIgnoreCase("next")) {
							System.out.println("Client has chosen to skip a question");
							String receivedString8 = (String) in.readObject();
							System.out.println("Client entered string: " + receivedString8);
						}
						
						// Question 4
						String receivedString9 = (String) in.readObject();
						System.out.println("Client entered string: " + receivedString9);
						
						if (receivedString9.equalsIgnoreCase("next")) {
							System.out.println("Client has chosen to skip a question");
							String receivedString10 = (String) in.readObject();
							System.out.println("Client entered string: " + receivedString10);
						}
						
						// Question 5
						String receivedString11 = (String) in.readObject();
						System.out.println("Client entered string: " + receivedString11);
						
						if (receivedString11.equalsIgnoreCase("next")) {
							System.out.println("Client has chosen to skip a question");
							String receivedString12 = (String) in.readObject();
							System.out.println("Client entered string: " + receivedString12);
						}
					}

					if (out != null && os != null){
						if(receviedString.equalsIgnoreCase("exit") || receivedInt == 0){
						
						  os.writeObject("exiting");
							os.close();
							in.close();
							sock.close();
							connected = false;
						}
					}
				}
			} catch (Exception e) {
			  System.out.println("Client disconnect");
			}
			
		  } catch(Exception e) {
			e.printStackTrace();
		  } finally {
			try {
				if (sock != null)
					sock.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		  }
	  }
}