## Description

UDPServer/UDPClient Server waits for and accepts connections.

When Client connects, Server confirms connection and asks user for name.

When Client enters name, Server sends back name and asks how many questions 
they would like to answer.

Client can enter `start` to start a new game or `quit` to exit.

Program will exit after above command (per the instructions were to not go 
any further with UDP example).

Data necessary for our UDP example (and not our TCP example) includes the 
sending of Datagram packets. We must first setup our packet before we are
able to send and receive. We did not use this kind of method in the TCP 
example. This also includes a DatagramSocket() and InetAddress IPAddress. 
Some methods are different here compared to UDP.

# UDP

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

UML in UDP Folder
   
   
## Issues in the code that were not included on purpose

The following UDP example is much more simplistic than our TCP example 
(based upon assignment's instructions).

Again, I had trouble with the sending an image over the Server to the Client.
Rather, I put a [Image Display] message in the terminal to represent one.