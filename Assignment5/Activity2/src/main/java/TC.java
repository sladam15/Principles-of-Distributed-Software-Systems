package Activity2;

import java.net.*;
import java.io.*;
import java.util.*;
import org.json.*;
import java.lang.*;

public class TC {
	public static void main (String args[])throws Exception {
		Boolean connected = false;
		ObjectInputStream in = null;
		OutputStream out = null;
		ObjectOutputStream os = null;
		String receivedString = "";
		String receivedString2 = "";
		Integer receivedInt = 0;
		ServerSocket sock = null;
		
		try {
			
			// Opens socket
			Socket serv = null;

			sock = new ServerSocket(8000); // create server socket on port 8000
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
						System.out.println("Server received connection from client/node");
					}

					if (in != null){
						
						receivedString = (String) in.readObject();
						System.out.println("Client entered string: "+ receivedString);
						
						if (receivedString.equalsIgnoreCase("exit")) {
							System.out.println("Client has chosen to quit");
							System.exit(0);
						} else if (receivedString.equalsIgnoreCase("yes")) {
							System.out.println("Client has chosen to send a request to TC");
							
							while (true) {
							
							receivedInt = (Integer) in.readObject();
							System.out.println("Client entered integer: "+ receivedInt);
							
								if (receivedInt == 1) {
									System.out.println("Client has chosen to display current tip list");
								} else if (receivedInt == 2) {
									System.out.println("Client has chosen to add a new list item");
									System.out.println("Waiting on Client to add new list item");
									
									receivedString2 = (String) in.readObject();
									System.out.println("Client entered new list item: "+ receivedString2);
									
									System.out.println("Receiving permission from node1");
									System.out.println("Receiving permission from node2");
											
								}
							}
						}	
					}	

					if (out != null && os != null){
						if(receivedString.equalsIgnoreCase("exit")){
						
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