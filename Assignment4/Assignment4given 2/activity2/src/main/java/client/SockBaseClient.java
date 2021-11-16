package client;

import java.net.*;
import java.io.*;
import org.json.*;
import java.util.Random;

import buffers.RequestProtos.Request;
import buffers.ResponseProtos.Response;
import buffers.ResponseProtos.Entry;

import java.util.*;
import java.util.stream.Collectors;

class SockBaseClient {

    public static void main (String args[]) throws Exception {
        Socket serverSock = null;
        OutputStream out = null;
        InputStream in = null;
        int i1=0, i2=0;
        int port = 9099; // default port
		
		Scanner scanner = new Scanner(System.in);
	
		
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
		battle1[3][6] = "x"; battle1[4][1] = "x"; battle1[5][1] = "x"; battle1[6][1] = "x";
		
		
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
		
		battle2[0][0] = "x"; battle2[0][1] = "x"; battle2[0][2] = "x"; battle2[0][3] = "x";
		battle2[2][0] = "x"; battle2[3][0] = "x"; battle2[3][5] = "x"; battle2[3][6] = "x";
		battle2[4][0] = "x"; battle2[6][1] = "x"; battle2[6][2] = "x"; battle2[6][3] = "x"; 
	
	
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

 
        // Make sure two arguments are given
        if (args.length != 2) {
            System.out.println("Expected arguments: <host(String)> <port(int)>");
            System.exit(1);
        }
        String host = args[0];
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException nfe) {
            System.out.println("[Port] must be integer");
            System.exit(2);
        }

		while (true) {
			
			Random num = new Random();
			final int res = 1 + num.nextInt(3);
			boolean win = false;
			
			// Ask user for username
			System.out.println("Please provide your name for the server.");
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			String strToSend = stdin.readLine();

			// Name request object
			Request op = Request.newBuilder()
					.setOperationType(Request.OperationType.NAME)
					.setName(strToSend)
					.build();
			Response response;
			
			// Leader request object
			Request opLeader = Request.newBuilder()
					.setOperationType(Request.OperationType.LEADER)
					.build();
			Response responseLeader;
					
			// New game request object
			Request opNewGame = Request.newBuilder()
					.setOperationType(Request.OperationType.NEW)
					.setVersion(res)
					.build();
			Response responseGame;
			
			// Won request object
			Request opWon = Request.newBuilder()
					.build();
			Response responseWon;
			
			// Quit request object
			Request opQuit = Request.newBuilder()
					.setOperationType(Request.OperationType.QUIT)
					.build();
			Response responseQuit;
			
			// Error request object
			Request opError = Request.newBuilder()
					.build();
			Response responseError;
				
			try {
				// connect to the server
				serverSock = new Socket(host, port);

				// write to the server
				out = serverSock.getOutputStream();
				in = serverSock.getInputStream();

				op.writeDelimitedTo(out);

				// read from the server
				response = Response.parseDelimitedFrom(in);

				// print the server response. 
				System.out.println(response.getMessage());
				
				System.out.println("* \nWhat would you like to do? \n 1 - to see the leader board \n 2 - to enter a game \n 3 - quit the game");
				
				// menu choices
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				int choice = Integer.parseInt(reader.readLine());		
				
				if (choice == 1) {
						
					System.out.println("Leaderboard \n");
					opLeader.writeDelimitedTo(out);
					responseLeader = Response.parseDelimitedFrom(in);
											
				} else if (choice == 2) {
					System.out.println("Let's begin your new game, " + strToSend + "!" + "\n");
					
					
					
					System.out.println("Current Image:");
					
						for (int i = 0; i < gameBoard.length; i++) {
							for (int j = 0; j < gameBoard.length; j++) {
								System.out.print(gameBoard[i][j] + "");
							}
							System.out.println();
						}
					
					
					while (true && win == false) {
					System.out.println("\n" + "Select a row and column");
							
					opNewGame.writeDelimitedTo(out);
					
					// ROWS
					System.out.print("Enter row:" + "\n");
					int r = scanner.nextInt();
					String exit = Integer.toString(r);
					if (exit.equalsIgnoreCase("exit")) {
						System.out.println("User has chosen to exit the program");
						break;
					} else {
						while (r > 6 || r < 0) {
							opError.writeDelimitedTo(out);
							System.out.println("User input error");
							
							System.out.print("Enter row: (must be between 0-6)" + "\n");
							r = Integer.parseInt(reader.readLine());
						}
					}
					
					// COLUMNS
					System.out.print("Enter column:" + "\n");
					int c = scanner.nextInt();
					String exit2 = Integer.toString(c);
					if (exit2.equalsIgnoreCase("exit")) {
						System.out.println("User has chosen to exit the program");
						break;
					} else {
						while (c > 6 || c < 0) {
							opError.writeDelimitedTo(out);
							System.out.println("User input error");
							
							System.out.print("Enter column: (must be between 0-6)" + "\n");
							c = Integer.parseInt(reader.readLine());
						}
					}

					System.out.println("\n" + "Row Chosen: " + r + "\n" + "Column Chosen: " + c + "\n");
					
					// Rowcol request object
					Request opRowCol = Request.newBuilder()
							.setOperationType(Request.OperationType.ROWCOL)
							.setRow(r)
							.setColumn(c)
							.setVersion(res)
							.build();
					Response responseRowCol;
					
					opRowCol.writeDelimitedTo(out);
					responseRowCol = Response.parseDelimitedFrom(in);
					//System.out.println(responseRowCol.getMessage());
					
					if (res == 1) {
						if (battle1[r][c] == "x") { 
							System.out.println("A hit has been made!" + "\n");
							gameBoard[r][c] = "x";	
						} else {
							System.out.println("You have missed the target!" + "\n");
						}
					} else if (res == 2) {
						if (battle2[r][c] == "x") { 
							System.out.println("A hit has been made!" + "\n");
							gameBoard[r][c] = "x";
						} else {
							System.out.println("You have missed the target!" + "\n");
						}
					} else if (res == 3) {
						if (battle3[r][c] == "x") { 
							System.out.println("A hit has been made!" + "\n");
							gameBoard[r][c] = "x";
						} else {
							System.out.println("You have missed the target!" + "\n");
						}
					}
					
					System.out.println("Current Image:");
					
						for (int i = 0; i < gameBoard.length; i++) {
							for (int j = 0; j < gameBoard.length; j++) {
								System.out.print(gameBoard[i][j] + "");
							}
							System.out.println();
						}
					
					// win situation
					if (res == 1) {
						if (gameBoard[0][3] == "x" && gameBoard[0][4] == "x" && gameBoard[0][5] == "x" && 
						gameBoard[0][6] == "x" && gameBoard[1][0] == "x" && gameBoard[2][0] == "x" &&
						gameBoard[3][0] == "x" && gameBoard[3][5] == "x" && gameBoard[3][6] == "x" && 
						gameBoard[4][1] == "x" && gameBoard[5][1] == "x" && gameBoard[6][1] == "x") {						
							System.out.println("YOU HAVE WON THE GAME");
							win = true;
							System.out.println("Your name has been added to leaderboard!");
							System.out.println("You will now be brought to the main menu" + "\n");
						}							
					} else if (res == 2) {
						if (gameBoard[0][0] == "x" && gameBoard[0][1] == "x" && gameBoard[0][2] == "x" &&
						gameBoard[0][3] == "x" && gameBoard[2][0] == "x" && gameBoard[3][0] == "x" && 
						gameBoard[3][5] == "x" && gameBoard[3][6] == "x" && gameBoard[4][0] == "x" && 
						gameBoard[6][1] == "x" && gameBoard[6][2] == "x" && gameBoard[6][3] == "x") {
							System.out.println("YOU HAVE WON THE GAME");
							win = true;
							System.out.println("Your name has been added to leaderboard!");
							System.out.println("You will now be brought to the main menu" + "\n");
						}
					} else if (res == 3) {
						if (gameBoard[1][0] == "x" && gameBoard[1][1] == "x" && gameBoard[1][2] == "x" && 
						gameBoard[1][3] == "x" && gameBoard[2][5] == "x" && gameBoard[2][6] == "x" && 
						gameBoard[3][0] == "x" && gameBoard[3][1] == "x"&& gameBoard[4][1] == "x" && 
						gameBoard[4][2] == "x" && gameBoard[4][3] == "x" && gameBoard[4][4] == "x") {
							System.out.println("YOU HAVE WON THE GAME");
							win = true;
							System.out.println("Your name has been added to leaderboard!");
							System.out.println("You will now be brought to the main menu" + "\n");
						}
					}
					
					}				
						
				} else if (choice == 3) {
					
					System.out.println("The current game has ended");
					
					opQuit.writeDelimitedTo(out);
					responseQuit = Response.parseDelimitedFrom(in);
					System.out.println(responseQuit.getMessage());
						
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (in != null)   in.close();
				if (out != null)  out.close();
				if (serverSock != null) serverSock.close();
			}
		}
    }
}


