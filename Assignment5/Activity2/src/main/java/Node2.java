package Activity2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Node2  {
  public static void main (String args[]) throws Exception {
	  String message = "";
		
		try {
		  String host = "localhost";
		  Scanner scanner = new Scanner(System.in);
		  // open the connection
		  Socket server = new Socket(host, 8000); // connect to host and socket on port 8000
		  // get output channel
		  OutputStream out = server.getOutputStream();
		  // create an object output writer (Java only)
		  ObjectOutputStream os = new ObjectOutputStream(out);
		  ObjectInputStream in = new ObjectInputStream(server.getInputStream());

		  while (true) {
			System.out.println("node1 connected to TC");
			message = scanner.next();
			os.writeObject(message);
			
		  }
		  
		} catch(ConnectException e){
		  System.out.println("Connection Error");
		} catch (Exception e) {
		  e.printStackTrace();
		}
	  }
	}