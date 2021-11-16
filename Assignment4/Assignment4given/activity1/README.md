# Assignment 4 Activity 1
## Description
The initial Performer code only has one function for adding strings to an array: 

## Protocol

Client sends different assortments of strings/integers depending on how they would like
to interact with a created ArrayList.


### Requests
request: { "selected": <int: 1=add, 2=remove, 3=display, 4=count, 5=reverse,
0=quit>, "data": <thing to send>}

  add: data <string>
  remove: data <int>
  display: no data
  count: no data
  reverse: data <int>
  quit: no data

### Responses

sucess response: {"type": <"add",
"remove", "display", "count", "reverse", "quit"> "data": <thing to return> }

type <String>: echoes original selected from request (e.g. if request was "add", type will be "add")
data <string>: add = new list, remove = removed element, display = current list, count = num elements, reverse = new list


error response: {"type": "error", "message"": <error string> }
Should give good error message if something goes wrong which explains what went wrong


## How to run the program
### Terminal
Base Code, please use the following commands:

` gradle runTask1 -Pport=9099 -q --console=plain `
Above command will create a Server while socket waits for messages.

A basic program with my implemented code featured in Performer.java and StringList.java mostly 
focused around methods such as pop, count, reverse, and display. ArrayList should be updated
depending on the choices from the Client.

` gradle runTask2 -Pport=9099 -q --console=plain `
Above command will creates a Server (multi-threaded) while socket waits for messages. 

The only difference with this task is the Server will now accept multiple clients (with no limit).

` gradle runTask3 -Pport=9099 -q --console=plain `
Above command will create a Server (bounded multi-threaded) while socket waits for messages.

The only difference with this task is the Server will still be multi-threaded but there will be a
limit on how many clients can connect (bounded).

` gradle extraCredit -Pport=9099 -q --console=plain `
Above command will create a  Server (multi-threaded w/ locks) while socket waits for messages.

The program will now feature mutex locks which start when a thread has begun. Locks will release
when a client disconnects/closes the terminal and the next thread will now lock.


` gradle runClient `   
` gradle runClient -Phost=localhost -Pport=9099 -q --console=plain `
Above commands will create a client socket to send messages to the server


## Additional Comments
I was confused on task3 for the bounded server for how many active connections we could have
with the server. I chose to have no more than two active at one time.

I feel like I fulfilled all requirements on this Activity. This activity seems fairly straight
forward and most of it was already completed for us. I added a few methods and changed a few
things to get it to do compile. All in all, fun assignment.



