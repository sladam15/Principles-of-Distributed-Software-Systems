package server;

import java.net.*;
import java.io.*;
import java.util.*;
import org.json.*;
import java.lang.*;


import buffers.RequestProtos.Request;
import buffers.RequestProtos.Logs;
import buffers.RequestProtos.Message;
import buffers.ResponseProtos.Response;
import buffers.ResponseProtos.Entry;

class SockBaseServer {
    static String logFilename = "logs.txt";

    ServerSocket serv = null;
    InputStream in = null;
    OutputStream out = null;
    Socket clientSocket = null;
    int port = 9099; // default port
    Game game;
	

    public SockBaseServer(Socket sock, Game game){
        this.clientSocket = sock;
        this.game = game;
        try {
            in = clientSocket.getInputStream();
            out = clientSocket.getOutputStream();
        } catch (Exception e){
            System.out.println("Error in constructor: " + e);
        }
    }

    // Handles the communication right now it just accepts one input and then is done you should make sure the server stays open
    // can handle multiple requests and does not crash when the server crashes
    // you can use this server as based or start a new one if you prefer. 
    public void start() throws IOException {
        String name = "";
		int row1, column1 = 0;
        System.out.println("Ready...");
		
		String batt1 = "...xxxx" + "\n" + "x......" + "\n" + "x......" + "\n" 
		+ "x....xx" + "\n" + ".x....." + "\n" + ".x....." + "\n" + ".x.....";
		
		String batt2 = "xxxx..." + "\n" + "......." + "\n" + "x......" + "\n" 
		+ "x....xx" + "\n" + "x......" + "\n" + "......." + "\n" + ".xxx...";
		
		String batt3 = "......." + "\n" + "xxxx..." + "\n" + ".....xx" + "\n"
		+ "xx....." + "\n" + ".xxxx.." + "\n" + "......." + "\n" + ".......";
		
		// battle 1 X's (hits and non-hits)		
		String[][] battle1 = new String[7][7];
		battle1[0][0] = "."; battle1[0][1] = "."; battle1[0][2] = "."; battle1[1][1] = ".";
		battle1[1][2] = "."; battle1[1][3] = "."; battle1[1][4] = "."; battle1[1][5] = ".";
		battle1[1][6] = "."; battle1[2][6] = "."; battle1[3][1] = "."; battle1[3][2] = ".";
		battle1[3][3] = "."; battle1[3][4] = "."; battle1[4][0] = "."; battle1[4][2] = ".";
		battle1[4][3] = "."; battle1[4][4] = "."; battle1[4][5] = "."; battle1[4][6] = ".";
		battle1[5][0] = "."; battle1[5][2] = "."; battle1[5][3] = "."; battle1[5][4] = ".";
		battle1[5][5] = "."; battle1[5][6] = "."; battle1[6][0] = "."; battle1[6][2] = ".";
		battle1[6][3] = "."; battle1[6][4] = "."; battle1[6][5] = "."; battle1[6][6] = ".";
		
		battle1[0][3] = "x"; battle1[0][4] = "x"; battle1[0][5] = "x"; battle1[0][6] = "x";
		battle1[1][0] = "x"; battle1[2][0] = "x"; battle1[3][0] = "x"; battle1[3][5] = "x";
		battle1[3][6] = "x"; battle1[4][1] = "x"; battle1[5][1] = "x"; battle1[5][1] = "x";
		
		
		// battle 2 X's (hits and non-hits)	
		String[][] battle2 = new String[7][7];
		battle2[0][4] = "."; battle2[0][5] = "."; battle2[0][6] = "."; battle2[1][0] = ".";
		battle2[1][1] = "."; battle2[1][2] = "."; battle2[1][3] = "."; battle2[1][4] = ".";
		battle2[1][5] = "."; battle2[1][6] = "."; battle2[2][1] = "."; battle2[2][2] = "."; 
		battle2[2][3] = "."; battle2[2][4] = "."; battle2[2][5] = "."; battle2[2][6] = ".";
		battle2[3][1] = "."; battle2[3][2] = "."; battle2[3][3] = "."; battle2[3][4] = ".";
		battle2[4][1] = "."; battle2[4][2] = "."; battle2[4][3] = "."; battle2[4][4] = "."; 
		battle2[4][5] = "."; battle2[4][6] = "."; battle2[5][0] = "."; battle2[5][1] = "."; 
		battle2[5][2] = "."; battle2[5][3] = "."; battle2[5][4] = "."; battle2[5][5] = ".";
		battle2[5][6] = "."; battle2[6][0] = "."; battle2[6][4] = "."; battle2[6][5] = ".";
		battle2[6][6] = "."; 		
		
		battle2[0][0] = "x"; battle2[0][1] = "x"; battle2[0][3] = "x"; battle2[0][4] = "x";
		battle2[2][0] = "x"; battle2[3][0] = "x"; battle2[3][5] = "x"; battle2[3][6] = "x";
		battle2[4][0] = "x"; battle2[6][1] = "x"; battle2[6][2] = "x"; battle2[6][2] = "x"; 
	
	
		// battle 3 X's (hits and non-hits)		
		String[][] battle3 = new String[7][7];
		battle3[0][0] = "."; battle3[0][1] = "."; battle3[0][2] = "."; battle3[0][3] = "."; 
		battle3[0][4] = "."; battle3[0][5] = "."; battle3[0][6] = "."; battle3[1][4] = "."; 
		battle3[1][5] = "."; battle3[1][6] = "."; battle3[2][0] = "."; battle3[2][1] = "."; 
		battle3[2][2] = "."; battle3[2][3] = "."; battle3[2][4] = "."; battle3[3][2] = "."; 
		battle3[3][3] = "."; battle3[3][4] = "."; battle3[3][5] = "."; battle3[3][6] = "."; 
		battle3[4][0] = "."; battle3[4][5] = "."; battle3[4][6] = "."; battle3[5][0] = "."; 
		battle3[5][1] = "."; battle3[5][2] = "."; battle3[5][3] = "."; battle3[5][4] = ".";
		battle3[5][5] = "."; battle3[5][6] = "."; battle3[6][0] = "."; battle3[6][1] = "."; 
		battle3[6][2] = "."; battle3[6][3] = "."; battle3[6][4] = "."; battle3[6][5] = "."; 
		battle3[6][6] = "."; 
		
		battle3[1][0] = "x"; battle3[1][1] = "x"; battle3[1][2] = "x"; battle3[1][3] = "x"; 
		battle3[2][5] = "x"; battle3[2][6] = "x"; battle3[3][0] = "x"; battle3[3][1] = "x"; 
		battle3[4][1] = "x"; battle3[4][2] = "x"; battle3[4][3] = "x"; battle3[4][4] = "x";
		
		// empty board
		String[][] gameBoard = new String[7][7];
		
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard.length; j++) {
				gameBoard[i][j] = ".";
			}
		}
			
			try {
				while (true) {
					// read the proto object and put into new objct
					Request op = Request.parseDelimitedFrom(in);
					
					// NAME
					if (op.getOperationType() == Request.OperationType.NAME) {
						// get name from proto object
						name = op.getName();

						// writing a connect message to the log with name and CONNENCT
						writeToLog(name, Message.CONNECT);
						
						System.out.println("Got a connection and a name: " + name);
						
						Response response = Response.newBuilder()
							.setResponseType(Response.ResponseType.GREETING)
							.setMessage("Hello " + name + " and welcome. Welcome to a simple game of battleship. ")
							.build();
						response.writeDelimitedTo(out);
					}
					
					// LEADERBOARD
					if (op.getOperationType() == Request.OperationType.LEADER) {
						// Creating Entry and Leader response
						Response.Builder responseLeader = Response.newBuilder()
							.setResponseType(Response.ResponseType.LEADER);

						// building and Entry
						Entry leader = Entry.newBuilder()
							.setName(name)
							.setWins(+1)
							.setLogins(+1)
							.build();

						responseLeader.addLeader(leader);

						Response response3 = responseLeader.build();

						for (Entry lead: response3.getLeaderList()){
							System.out.println(lead.getName() + ": " + lead.getWins());
						}
					}
					
					// NEW GAME
					if (op.getOperationType() == Request.OperationType.NEW) {
						
						game.newGame();
						
						Response responseGame = Response.newBuilder()
							.setResponseType(Response.ResponseType.TASK)
							.setImage(game.getImage())
							.setTask("Waiting for user to select a row and column.")
							.build();
							
						System.out.println("\n" + "Task: " + responseGame.getResponseType());
						
						int v =  op.getVersion();
						

						if (v == 1) {
							System.out.println("Image Chosen: battle1.txt" +  "\n" + batt1 + "\n");
						} else if (v == 2) {
							System.out.println("Image Chosen: battle2.txt" + "\n" + batt2 + "\n");
						} else if (v == 3) {
							System.out.println("Image Chosen: battle3.txt" +  "\n" + batt3 + "\n");
						}
		
						System.out.println("Task: \n" + responseGame.getTask());
						
					}
					
					// ROWCOL
					if (op.getOperationType() == Request.OperationType.ROWCOL) {
						System.out.println(name + " has chosen a row and column");
						row1 = op.getRow();
						column1 = op.getColumn();
						
						
							Response responseRowCol = Response.newBuilder()
								.setResponseType(Response.ResponseType.TASK)
								.setImage(game.getImage())
								.build();
							responseRowCol.writeDelimitedTo(out);
						
						int version = op.getVersion();
							
						System.out.println("Row: " + row1 + " \n" + "Column: " + column1 + "\n");
						
						if (version == 1) {
							if (battle1[row1][column1] == "x") { 
								System.out.println("A hit has been made!");
								gameBoard[row1][column1] = "x";
								
							} else {
							System.out.println("You have missed the target!");
							}
						} else if (version == 2) {
							if (battle2[row1][column1] == "x") { 
								System.out.println("A hit has been made!");
								gameBoard[row1][column1] = "x";
							} else {
							System.out.println("You have missed the target!");
							}
						} else if (version == 3) {
							if (battle3[row1][column1] == "x") { 
								System.out.println("A hit has been made!");
								gameBoard[row1][column1] = "x";
							} else {
							System.out.println("You have missed the target!");
							}
						}
						
						
						// win situation
					if (version == 1) {
						if (gameBoard[0][3] == "x" && gameBoard[0][4] == "x" && gameBoard[0][5] == "x" && 
						gameBoard[0][6] == "x" && gameBoard[1][0] == "x" && gameBoard[2][0] == "x" &&
						gameBoard[3][0] == "x" && gameBoard[3][5] == "x" && gameBoard[3][6] == "x" && 
						gameBoard[4][1] == "x" && gameBoard[5][1] == "x" && gameBoard[5][1] == "x") {						
							System.out.println("The user has won the game");
							System.out.println("A new cycle of the game will now begin");
							
							// Creating Entry and Leader response
							Response.Builder responseLeader = Response.newBuilder()
								.setResponseType(Response.ResponseType.LEADER);

							// building and Entry
							Entry leader = Entry.newBuilder()
								.setName(name)
								.setWins(+1)
								.setLogins(+1)
								.build();

							responseLeader.addLeader(leader);

							Response response3 = responseLeader.build();
						}							
					} else if (version == 2) {
						if (gameBoard[0][0] == "x" && gameBoard[0][1] == "x" && gameBoard[0][3] == "x" &&
						gameBoard[0][4] == "x" && gameBoard[2][0] == "x" && gameBoard[3][0] == "x" && 
						gameBoard[3][5] == "x" && gameBoard[3][6] == "x" && gameBoard[4][0] == "x" && 
						gameBoard[6][1] == "x" && gameBoard[6][2] == "x" && gameBoard[6][2] == "x") {
							System.out.println("The user has won the game");
							System.out.println("A new cycle of the game will now begin");
							
							// Creating Entry and Leader response
							Response.Builder responseLeader = Response.newBuilder()
								.setResponseType(Response.ResponseType.LEADER);

							// building and Entry
							Entry leader = Entry.newBuilder()
								.setName(name)
								.setWins(+1)
								.setLogins(+1)
								.build();

							responseLeader.addLeader(leader);

							Response response3 = responseLeader.build();
						}
					} else if (version == 3) {
						if (gameBoard[1][0] == "x" && gameBoard[1][1] == "x" && gameBoard[1][2] == "x" && 
						gameBoard[1][3] == "x" && gameBoard[2][5] == "x" && gameBoard[2][6] == "x" && 
						gameBoard[3][0] == "x" && gameBoard[3][1] == "x"&& gameBoard[4][1] == "x" && 
						gameBoard[4][2] == "x" && gameBoard[4][3] == "x" && gameBoard[4][4] == "x") {
							System.out.println("The user has won the game");
							System.out.println("A new cycle of the game will now begin");
							
							// Creating Entry and Leader response
							Response.Builder responseLeader = Response.newBuilder()
								.setResponseType(Response.ResponseType.LEADER);

							// building and Entry
							Entry leader = Entry.newBuilder()
								.setName(name)
								.setWins(+1)
								.setLogins(+1)
								.build();

							responseLeader.addLeader(leader);

							Response response3 = responseLeader.build();
						}
					}
							
					}
					

					// QUIT GAME
					if (op.getOperationType() == Request.OperationType.QUIT) {
						System.out.println(name + " has chosen to end the game.");
						
							Response responseQuit = Response.newBuilder()
								.setResponseType(Response.ResponseType.BYE)
								.setMessage("Thanks for playing " + name + "!")
								.build();
							responseQuit.writeDelimitedTo(out);
					}
					
					
				}
			
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (out != null)  out.close();
				if (in != null)   in.close();
				if (clientSocket != null) clientSocket.close();
			}
    }


    /**
     * Writing a new entry to our log
     * @param name - Name of the person logging in
     * @param message - type Message from Protobuf which is the message to be written in the log (e.g. Connect) 
     * @return String of the new hidden image
     */
    public static void writeToLog(String name, Message message){
        try {
            // read old log file 
            Logs.Builder logs = readLogFile();

            // get current time and data
            Date date = java.util.Calendar.getInstance().getTime();
            System.out.println(date);

            // we are writing a new log entry to our log
            // add a new log entry to the log list of the Protobuf object
            logs.addLog(date.toString() + ": " +  name + " - " + message);

            // open log file
            FileOutputStream output = new FileOutputStream(logFilename);
            Logs logsObj = logs.build();

            // This is only to show how you can iterate through a Logs object which is a protobuf object
            // which has a repeated field "log"

            for (String log: logsObj.getLogList()){

                System.out.println(log);
            }

            // write to log file
            logsObj.writeTo(output);
        }catch(Exception e){
            System.out.println("Issue while trying to save");
        }
    }

    /**
     * Reading the current log file
     * @return Logs.Builder a builder of a logs entry from protobuf
     */
    public static Logs.Builder readLogFile() throws Exception{
        Logs.Builder logs = Logs.newBuilder();

        try {
            // just read the file and put what is in it into the logs object
            return logs.mergeFrom(new FileInputStream(logFilename));
        } catch (FileNotFoundException e) {
            System.out.println(logFilename + ": File not found.  Creating a new file.");
            return logs;
        }
    }


    public static void main (String args[]) throws Exception {
        Game game = new Game();

        if (args.length != 2) {
            System.out.println("Expected arguments: <port(int)> <delay(int)>");
            System.exit(1);
        }
        int port = 9099; // default port
        int sleepDelay = 10000; // default delay
        Socket clientSocket = null;
        ServerSocket serv = null;

        try {
            port = Integer.parseInt(args[0]);
            sleepDelay = Integer.parseInt(args[1]);
        } catch (NumberFormatException nfe) {
            System.out.println("[Port|sleepDelay] must be an integer");
            System.exit(2);
        }
        try {
            serv = new ServerSocket(port);
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(2);
        }

		while (true) {
			clientSocket = serv.accept();
			System.out.println("New Client has connected to Server");
			SockBaseServer server = new SockBaseServer(clientSocket, game);
			server.start();
		}

    }
}