package Activity2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Client {
	public static void main (String args[]) throws Exception {
		String message, message2 = "";
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		List<String> strings = new ArrayList<String>();
		
		try {
		  String host = "localhost";
		  // open the connection
		  Socket server = new Socket(host, 8000); // connect to host and socket on port 8000
		  // get output channel
		  OutputStream out = server.getOutputStream();
		  // create an object output writer (Java only)
		  ObjectOutputStream os = new ObjectOutputStream(out);
		  ObjectInputStream in = new ObjectInputStream(server.getInputStream());

		  while (true) {
			System.out.println("Enter 'yes' to send a request to Transaction Coordinator. (or 'exit' to quit)");
			message = scanner.nextLine();
			os.writeObject(message);

			if (message.equalsIgnoreCase("exit")) {
			  break;
			} else {
				while (true) {
					System.out.println("Main Menu");
					System.out.println("1. Ask for current tip list");
					System.out.println("2. Add a new item to list" + "\n");
					  
					System.out.println("Which would you like to do?");
					choice = scanner.nextInt();
					os.writeObject(choice);
					
					if (choice == 1) {
						
						for (int i = 0; i < strings.size(); i++) {
						  System.out.println("List item #" + (i+1) + ": " + strings.get(i) + "\n");
						}
						
					} else if (choice == 2) {					
						System.out.println("What tip would you like to add to list?");
						message2 = scanner.next();
						os.writeObject(message2);
						
						System.out.println("Waiting on permission from node1");			
						System.out.println("Waiting on permission from node2" + "\n");
						
						strings.add(message2);
						
						System.out.println(message2 + " now added to tip list" + "\n");
						
					}
				}
			}
		  }
		  
		  //close resources
		  scanner.close();
		  os.close();
		  in.close();
		  server.close();
		} catch(ConnectException e){
		  System.out.println("Connection Error");
		} catch (Exception e) {
		  e.printStackTrace();
		}
	  }
	}