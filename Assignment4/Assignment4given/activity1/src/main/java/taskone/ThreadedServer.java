/**
  File: ThreadedServer.java
  Author: Student in Fall 2020B
  Description: ThreadedServer class in package taskone.
*/

package taskone;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONObject;
import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Class: ThreadedServer
 * Description: ThreadedServer tasks.
 */
public class ThreadedServer extends Thread {
	private Socket conn;
	private int id;
    StringList strings = new StringList();
	
	public ThreadedServer(Socket sock, int id){
		this.conn = sock;
		this.id = id;
	}

    public static void main(String[] args) throws Exception {
		Socket sock = null;
		int port = 9099;
		
        if (args.length != 1) {
            // gradle runTask2 -Pport=9099 -q --console=plain
            System.out.println("Usage: gradle runTask2 -Pport=9099 -q --console=plain");
            System.exit(1);
        }
        port = -1;
        try {
            port = Integer.parseInt(args[0]);

			ServerSocket server = new ServerSocket(port);
			System.out.println("Server Started...");
			
			int id = 0;
			
			while (true) {
				System.out.println("Accepting a Request...");
				sock = server.accept();
				System.out.println("Thread " + id + " has connected to the Server!");
				
				ThreadedServer myServerThread = new ThreadedServer(sock, id++); // create new thread
				myServerThread.start(); // start new thread
			}
			
		} catch (Exception e) { 
		e.printStackTrace();
		} finally {
			if (sock != null) sock.close();
		}
	}
	
	public void run() {
		try {
		
			Performer performer = new Performer(conn, strings);
			performer.doPerform();

			conn.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
	
}
	
	
