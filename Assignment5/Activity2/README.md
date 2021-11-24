## Description

TCP Server waits for and accepts connections.

When Client connects, TC (Server) confirms connection and asks user for string input.

This is when `gradle node1` and `gradle node2` can be enterred into separate terminals
to be connected to the TC.

Client can enter `yes` to send a request to the Transaction Coordinator or `exit`
to quit.

String registered is displayed on TC (Server) side and confirms choice.

If user input is `yes`, a menu will be displayed to the Client to either ask for current
tip list OR add a new item to list. Choices are listed as integers, 1 and 2.

If 1 is entered as user input, the program will display the current items on the list.

If 2 is entered as user input, the program will ask the user what string they would like
to add to the array list. Waiting on permission from node1 and node2 will now display.

Either integer inputs will be displayed on the TC (Server) side.

If 2 is selected, the string entered will be displayed on the TC (Server) side and TC
will also receive permission from node1 and node2 to do the given command.

All information is recorded into Server when Client selects.


# TCP

## Running the example

`gradle TC`

`gradle TC -Pport=8000`

`gradle Client`

`gradle Client -Pport=8000 -Phost='localhost'`

`gradle node1`

`gradle node2`


### Simple protocol

Client sends different assortments of strings and integers depending on the question.

This includes menu choice (integer), and tips to add to an array list (strings). The 
communication is done back and forth through the Server and confirmed if correct input 
as well as the correct answer (during the game).

Screencast Link: https://www.youtube.com/watch?v=CHR8j1N88OY
   
   
## Issues in the code that were not included on purpose
I had many struggles with the given assignment. No examples were given and it was 
expected of us to know how to do a 2 phase commitment without actually seeing how
one is done. I wish the teacher filled us in a bit more on how to go about doing
the coding for this assignment because I was quite confused how to do something 
I've never done before.