/**
  File: ThreadedServerSolution2.java
  Author: Student in Fall 2020B
  Description: ThreadedServerSolution2 class in package taskone.
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
import java.util.concurrent.locks.*;

/**
 * Class: ThreadedServerSolution2
 * Description: ThreadedServerSolution2 tasks.
 */
public class ThreadedServerSolution2 extends Thread {
	private Socket conn;
	private int id;
    protected Lock mutex;
    StringList strings = new StringList();
	
	public ThreadedServerSolution2(Socket sock, int id, Lock mutex){
		this.conn = sock;
		this.id = id;
		this.mutex = mutex;
	}

    public static void main(String[] args) throws Exception {
		Lock mutex = new ReentrantLock();
		Socket sock = null;
		int port = 9099;
		
        if (args.length != 1) {
            // gradle extraCredit -Pport=9099 -q --console=plain
            System.out.println("Usage: gradle extraCredit -Pport=9099 -q --console=plain");
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
				
				ThreadedServerSolution2 myServerThread = new ThreadedServerSolution2(sock, id++, mutex); // create new thread
				myServerThread.start(); // start new thread
			}
			
		} catch (Exception e) { 
		e.printStackTrace();
		} finally {
			if (sock != null) sock.close();
		}
	}
	
	public void run() {
		mutex.lock();
		try {
			System.out.println("Thread" + id + " has lock");
			Performer performer = new Performer(conn, strings);
			performer.doPerform();

			conn.close();
		} catch (Exception e) {
		} finally {
            System.out.println("Thread" + id + " releasing lock");
            mutex.unlock();
	    }
	}
	
}
	
	
