package TCP;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TCPClient {
	Timer timer;

    public TCPClient(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
	}

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Your time has run out and you have lost the game!");
			System.out.println("[LOSER IMAGE DISPLAYS]");
            timer.cancel();
			System.exit(0);
        }
    }
	
	public static void main (String args[]) throws Exception {
		String message, message2 = "";
		Integer number, question = 0;
		Scanner scanner = new Scanner(System.in);
		int correctAnswers = 0;
		
		try {
		  String host = "localhost";
		  // open the connection
		  Socket server = new Socket(host, 8080); // connect to host and socket on port 8080
		  // get output channel
		  OutputStream out = server.getOutputStream();
		  // create an object output writer (Java only)
		  ObjectOutputStream os = new ObjectOutputStream(out);
		  ObjectInputStream in = new ObjectInputStream(server.getInputStream());

		  while (true) {
			System.out.println("What is your name? (Type 'exit' to quit)");
			message = scanner.nextLine();
			os.writeObject(message);

			if (message.equalsIgnoreCase("exit")) {
			  break;
			} else {
			  System.out.println("How many questions would you like, " + message + "? (Must be 5 or fewer)");
			  number = scanner.nextInt();
			  scanner.nextLine();
			}
			
			if (number > 5) {
				while (number > 5) {
					System.out.println("How many questions would you like, " + message + "? (MUST BE 5 OR FEWER)");
					number = scanner.nextInt();
					scanner.nextLine();
				}
			}	
			os.writeObject(number);
			
			int seconds = 30 * number; // calculates timer 
						
			System.out.println("We are now ready to play!");
			
			System.out.println("Type 'start' to Start the Game. Type 'exit' to Exit the Game.");
			System.out.println("You will have " + seconds + " seconds to complete " + number + " questions");
			message2 = scanner.nextLine();
			os.writeObject(message2);
			
			if (message2.equalsIgnoreCase("start")) {
			  System.out.println("The game has begun! Your timer will start now.");
			} else if(message2.equalsIgnoreCase("exit")) {
				break;
			}
			
			// Set Up Timer
			new TCPClient(seconds);
			
			// START OF GAME
			
			// Question 1
			if (question < number) {
				System.out.println("[NEW IMAGE DISPLAYS]");
				System.out.println("Spell your name backwards. ('next' for another question)");	
				String solution = scanner.nextLine();
				os.writeObject(solution);
				
				if (solution.equalsIgnoreCase("naes")) {
					System.out.println("Correct"); 
					correctAnswers = correctAnswers + 1;
					System.out.println("Correct Answers: " + correctAnswers);
				} else if(solution.equalsIgnoreCase("exit")) {
					break;
				} else if(solution.equalsIgnoreCase("next")) {
					System.out.println("[NEW IMAGE DISPLAYS]");
					System.out.println("True or False. There are 52 cards in a deck.");
					
					String solution1 = scanner.nextLine();
					os.writeObject(solution1);
					
					if (solution1.equalsIgnoreCase("true")) {
						System.out.println("Correct"); 
						correctAnswers = correctAnswers + 1;
						System.out.println("Correct Answers: " + correctAnswers);
					} else if(solution1.equalsIgnoreCase("exit")) {
						break;
					} else {
						System.out.println("Incorrect");
					}
				} else { 
					System.out.println("Incorrect");
				}
				question = question + 1;
				
				// Win Condition
				if (correctAnswers == number) {
					System.out.println("You have won the game with " + correctAnswers + " correct answers!");
					System.out.println("[WINNER IMAGE DISPLAYS]");
				}
				
				if (number == question && correctAnswers != number) {
					System.out.println("You have lost the game. Too many incorrect answers.");
					System.out.println("[LOSER IMAGE DISPLAYS]");
				}
			}		  
			
			// Question 2
			if (question < number) {
				System.out.println("[NEW IMAGE DISPLAYS]");
				System.out.println("What color is the sky, blue or red? ('next' for another question)");
				String solution2 = scanner.nextLine();
				os.writeObject(solution2);
				
				if (solution2.equalsIgnoreCase("blue")) {
					System.out.println("Correct"); 
					correctAnswers = correctAnswers + 1;
					System.out.println("Correct Answers: " + correctAnswers);
				} else if(solution2.equalsIgnoreCase("exit")) {
					break;
				} else if(solution2.equalsIgnoreCase("next")) {
					System.out.println("[NEW IMAGE DISPLAYS]");
					System.out.println("What color is the grass, green or yellow?");
					
					String secondSolution = scanner.nextLine();
					os.writeObject(secondSolution);
					
					if (secondSolution.equalsIgnoreCase("green")) {
						System.out.println("Correct"); 
						correctAnswers = correctAnswers + 1;
						System.out.println("Correct Answers: " + correctAnswers);
					} else if(secondSolution.equalsIgnoreCase("exit")) {
						break;
					} else {
						System.out.println("Incorrect");
					}
				} else { 
					System.out.println("Incorrect");
				}
				question = question + 1;
				
				// Win Condition
				if (correctAnswers == number) {
					System.out.println("You have won the game with " + correctAnswers + " correct answers!");
					System.out.println("[WINNER IMAGE DISPLAYS]");
				}
				
				if (number == question && correctAnswers != number) {
					System.out.println("You have lost the game. Too many incorrect answers.");
					System.out.println("[LOSER IMAGE DISPLAYS]");
				}
			}
			
			// Question 3
			if (question < number) {
				System.out.println("[NEW IMAGE DISPLAYS]");
				System.out.println("Who won the Super Bowl last year (2020)? ('next' for another question)");
				String solution3 = scanner.nextLine();
				os.writeObject(solution3);

				if (solution3.equalsIgnoreCase("buccaneers")) {
					System.out.println("Correct"); 
					correctAnswers = correctAnswers + 1;
					System.out.println("Correct Answers: " + correctAnswers);
				} else if(solution3.equalsIgnoreCase("exit")) {
					break;
				} else if(solution3.equalsIgnoreCase("next")) {
					System.out.println("[NEW IMAGE DISPLAYS]");
					System.out.println("The Phoenix Suns colors are orange and __________");
					
					String thirdSolution = scanner.nextLine();
					os.writeObject(thirdSolution);
					
					if (thirdSolution.equalsIgnoreCase("purple")) {
						System.out.println("Correct"); 
						correctAnswers = correctAnswers + 1;
						System.out.println("Correct Answers: " + correctAnswers);
					} else if(thirdSolution.equalsIgnoreCase("exit")) {
						break;
					} else {
						System.out.println("Incorrect");
					}
				} else { 
					System.out.println("Incorrect");
				}
				question = question + 1;
				
				// Win Condition
				if (correctAnswers == number) {
					System.out.println("You have won the game with " + correctAnswers + " correct answers!");
					System.out.println("[WINNER IMAGE DISPLAYS]");
				}
				
				if (number == question && correctAnswers != number) {
					System.out.println("You have lost the game. Too many incorrect answers.");
					System.out.println("[LOSER IMAGE DISPLAYS]");
				}
			}
			
			// Question 4
			if (question < number) {
				System.out.println("[NEW IMAGE DISPLAYS]");
				System.out.println("Spell out 100. ('next' for another question)");
				String solution4 = scanner.nextLine();
				os.writeObject(solution4);
				
				if (solution4.equalsIgnoreCase("hundred")) {
					System.out.println("Correct"); 
					correctAnswers = correctAnswers + 1;
					System.out.println("Correct Answers: " + correctAnswers);
				} else if(solution4.equalsIgnoreCase("exit")) {
					break;
				} else if(solution4.equalsIgnoreCase("next")) {
					System.out.println("[NEW IMAGE DISPLAYS]");
					System.out.println("True or False. Jeff Bezos is a billionaire.");
					
					String fourthSolution = scanner.nextLine();
					os.writeObject(fourthSolution);
					
					if (fourthSolution.equalsIgnoreCase("true")) {
						System.out.println("Correct"); 
						correctAnswers = correctAnswers + 1;
						System.out.println("Correct Answers: " + correctAnswers);
					} else if(fourthSolution.equalsIgnoreCase("exit")) {
						break;
					} else {
						System.out.println("Incorrect");
					}
				} else { 
					System.out.println("Incorrect");
				}
				question = question + 1;
				
				// Win Condition
				if (correctAnswers == number) {
					System.out.println("You have won the game with " + correctAnswers + " correct answers!");
					System.out.println("[WINNER IMAGE DISPLAYS]");
				}
				
				if (number == question && correctAnswers != number) {
					System.out.println("You have lost the game. Too many incorrect answers.");
					System.out.println("[LOSER IMAGE DISPLAYS]");
				}
			}
			
			// Question 5
			if (question < number) {
				System.out.println("[NEW IMAGE DISPLAYS]");
				System.out.println("Halloween just passed. Which holiday is next? ('next' for another question)");
				String solution5 = scanner.nextLine();
				os.writeObject(solution5);
				
				if (solution5.equalsIgnoreCase("thanksgiving")) {
					System.out.println("Correct"); 
					correctAnswers = correctAnswers + 1;
					System.out.println("Correct Answers: " + correctAnswers);
				} else if(solution5.equalsIgnoreCase("exit")) {
					break;
				} else if(solution5.equalsIgnoreCase("next")) {
					System.out.println("[NEW IMAGE DISPLAYS]");
					System.out.println("Is Joe Biden the current president, yes or no?");
					
					String fifthSolution = scanner.nextLine();
					os.writeObject(fifthSolution);
					
					if (fifthSolution.equalsIgnoreCase("yes")) {
						System.out.println("Correct"); 
						correctAnswers = correctAnswers + 1;
						System.out.println("Correct Answers: " + correctAnswers);
					} else if(fifthSolution.equalsIgnoreCase("exit")) {
						break;
					} else {
						System.out.println("Incorrect");
					}
				} else { 
					System.out.println("Incorrect");
				}
				question = question + 1;
				
				// Win Condition
				if (correctAnswers == number) {
					System.out.println("You have won the game with " + correctAnswers + " correct answers!");
					System.out.println("[WINNER IMAGE DISPLAYS]");
				}
				
				if (number == question && correctAnswers != number) {
					System.out.println("You have lost the game. Too many incorrect answers.");
					System.out.println("[LOSER IMAGE DISPLAYS]");
				}
			}
			
			System.out.println("Current game has ended. New game will begin.");
		  }
		  
		  //close resources
		  scanner.close();
		  os.close();
		  in.close();
		  server.close();
		} catch(ConnectException e){
		  System.out.println("Connection Error");
		}catch (Exception e) {
		  e.printStackTrace();
		}
	  }
	}