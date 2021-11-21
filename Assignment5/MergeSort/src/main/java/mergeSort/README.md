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
   
   
## Questions (Task 1)
1. Some advantages of a distributed algorithm is it helps distributes workload and RAM 
needed. This can contribute to higher performance in the code and faster calculation 
speed. However, this algorithm may be more difficult to understand and there is now 
overhead in communication and through latency.

2. The given array was {5,1,6,2,3,4,10,634,34,23,653,23,2,6}. After each gradle command 
was performed, the timing for my wireshark capture started at 31.381450 seconds. After 
about 700 frames, the time finished at 31.44957 seconds. This concludes a time of 
0.06812 seconds for the program to run.

My first experiement was to add a longer array (double the size to 28 numbers instead of
the given 14). The array I created was {5,1,6,2,3,4,10,634,34,23,653,23,2,6,32,684,100081,
100082,900000,1314,	14,3,262,90,4,3,3000,777}. From the wireshark capture, the time of my
first packet began at 3.072158 and finished at 3.152569. This gives us a finish time of 
about 0.080411 seconds which was about 0.012291 seconds more than our given array. Doubling
the array size needed more time to complete the process.

My second experiment will be to try one number in the array to see how quick it can be. The
array I concluded with was {0}. The timer started at 3.354885 and concluded at 3.371549 
which gives a total of 0.01664 seconds. Referring to our given array, adding 13 more numbers
gives us an extra time of about 0.052 seconds. I thought it may be a bit quicker but that
may be the best this distributed algorithm can do.

My last experiment was to add a super long array with plenty of size to give us an idea of
the amount of time vs size of the array. I changed the given array to {5,1,6,2,3,4,10,634,34,
23,653,23,2,6,32,684,100081,100082,900000,1314,14,3,262,90,4,3,3000,777,36,38,8,999,91,0,11,
441,442,7,82,80,81,45,412,413,444,12,13,888,919,333333333,33333349,909,90,19,111,141,156,
888888,909999,10321}. The timer started its first packet on the wireshark capture at 1.823345
and completed its last packet at 2.027857. This gives us a total time of 0.204512 seconds.
This was the longest time of all the experiments which makes sense as the program is having
to work harder, even while distributing. I noticed I received a lot more black frames with red
font color on this experiment and am unsure why. This may have made the timing results longer
if I had included them as well.

In conclusion to my experiments, I do believe the distribution has helped with the speed
in completing the process in a very effective way. A distributing algorithm separates the
workoad and essentially makes the program not work as hard. Granted, there may be some 
latency but it is very minimal as my code has completed running in under 0.25 seconds in 
each experiment. 

3. I referred my array back to the given values for this experiment. Less nodes will give 
more efficient performance. Adding nodes results in a longer progression for the program 
(latency). Distribution does make things quicker, but some nodes may have failed in the 
process. Tried a couple different sizes of arrays for the experiment and the times varied. 
Again, I believe this is because the latency and the possible failing of nodes.

4. After running the given array, I receive about 700 frames/packets to complete the entire
sorting process. I believe the only way of reducing it is if we adjust the size/numbers in 
the array or change the current tree setup for each node. As far as I can tell, sorting with 
two ports is going to receive this much activity. Maybe if it wasn't set up for TCP, we may
receive a lot less traffic if it were UDP and there were no three-way handshakes.



## Questions (Task 2)
1. 


2. 



## Questions (Task 1)
1. 

2. 