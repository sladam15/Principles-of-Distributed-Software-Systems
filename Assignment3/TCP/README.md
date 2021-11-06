## Description

TCPServer/TCPClient Server waits for and accepts connections.

When Client connects, Server confirms connection and asks user for name.

When Client enters name, Server sends back name and asks how many questions 
they would like to answer.

A timer is calculated for a total of 30 seconds multiplied by the number of questions.

Client can enter `start` to start a new game or `quit` to exit.

All information is recorded into Server when Client selects.

If Client answers enough questions correct and the timer doesn't run out, the game ends
and the Client is sent an image with a Winner image. If the Client loses, a Loser image is
displayed.


# TCP

## Running the example

`gradle runServer`

`gradle runServer -Pport=8080`

`gradle runClient`

`gradle runClient -Pport=8080 -Phost='localhost'`


### Simple protocol

Client sends different assortments of strings and integers depending on the question.

This includes name, number of questions, start, answer, etc. The communication is done
back and forth through the Server and confirmed if correct input as well as the correct
answer (during the game).

UML in TCP Folder
   
   
## Issues in the code that were not included on purpose
I had struggles working with the images we were supposed to display for certain conditions
between the Server and Client. 

Rather, I chose to keep things in the terminal (because the 
instructions stated we could skip this step). I put a [Image Display] message in the 
terminal to represent one.

With lack of direction on how to deal without an image choice, I chose to ask my own 
questions (instead of guessing an image).

I also didn't include the 'more' option as no images were actually displayed.