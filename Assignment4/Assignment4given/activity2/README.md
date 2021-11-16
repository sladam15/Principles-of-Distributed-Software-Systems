#### Purpose:
Demonstrate simple Client and Server communication using `SocketServer` and `Socket`classes.

Here a simple protocol is defined which uses protobuf. The client reads in a json file and then creates a protobuf object from it to send it to the server. The server reads it and sends back the calculated result. 

The response is also a protobuf but only with a result string. 

To see the proto file see: src/main/proto which is the default location for proto files. 

Gradle is already setup to compile the proto files. 

### Protocol
You will see a response.proto and a request.proto file. You should implement these in your program. 
Some constraints on them:
Request:
- NAME: a name is sent to the server
	- name
	Response: GREETING
			- message
- LEADER: client wants to get leader board
	- no further data
	Response: LEADER
			- leader
- NEW: client wants to enter a game
	- no further data
	Response: TASK
			- image
			- task
- ANSWER: client sent an answer to a server task
	- answer
	Response: TASK
			- image
			- task
			- eval
	OR
	Response: WON
			- image
- QUIT: clients wants to quit connection
	- no further data
	Response: BYE
		- message

Response ERROR: anytime there is an error you should send the ERROR response and give an appropriate message. Client should act appropriately
	- message

### How to run it (optional)
The proto file can be compiled using

``gradle generateProto``

This will also be done when building the project. 

You should see the compiled proto file in Java under build/generated/source/proto/main/java/buffers

Now you can run the client and server 

#### Default 
Server is Java
Per default on 9099
runServer

You have one example client in Java using the Protobuf protocol

Clients runs per default on 
host localhost, port 9099
Run Java:
	runClient


### Terminal
Base Code, please use the following commands:

` gradle runServer -Pport=9099 `
Above command will create a Server while socket waits for messages.

` gradle runClient -Pport=9099 -Phost='localhost' -Pfile='data.json' `
Above command will create a client socket to send messages to the server


## Additional Comments
I struggled a lot more with this activity. I couldn't get the hang of the leaderboard, so I know that didn't come 
out 100% accurate. I feel I did relatively well on everything else. There may be some specific issues with multiple 
connections I may have missed. I ran out of time on this activity and had to live with how it turned out.