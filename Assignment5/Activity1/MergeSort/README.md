## Description

Two Sorters are started on different ports.

A Branch class is then started.

A Starter class is then started.

When enterred in this order, there is a given array in the Starter class
which will be displayed through JSON with values of the array in the newly
sorted order.


# TCP

## Running the example

`gradle Sorter --args=8000`

`gradle Sorter --args=8001`

`gradle Branch`

`gradle Starter`


### Simple protocol

In the terminal, user starts four gradle commands. Two are Sorters on 2 different ports, 
8000 and 8001. The other two are a Branch command and a Starter command.

No user input is required for this program. When the four gradle commands are enterred 
correctly, the program runs and terminates.
   
   
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
process. Tried a couple different sizes of arrays for the experiment and the times varied
for each. Again, I believe this is because the latency and the possible failing of nodes.

4. After running the given array, I receive about 700 frames/packets to complete the entire
sorting process. I believe the only way of reducing it is if we adjust the size/numbers in 
the array or change the current tree setup for each node. As far as I can tell, sorting with 
two ports is going to receive this much activity. Maybe if it wasn't set up for TCP, we may
receive a lot less traffic if it were UDP and there were no three-way handshakes.


## Questions (Task 2)
Preface: I ran Branch on AWS, and Sorters and Starter on my local computer.

Total time to run given array (since extra traffic): 0.024948 seconds

1. I do expect a faster change in runtimes, because one computer isn't having to run all 
processes for this program. Having the sorters/starter on local computer and branch on AWS 
should prove better results than that from Task 1.

2. On localhost our time was 0.06812 seconds and through AWS is 0.024948. This is a difference
of 0.043172 seconds. The same experiment was much faster through AWS. I would expect more 
traffic to cause some latency in time but it seems to be opposite. Maybe this is influenced 
by running Branch through AWS rather than the Sorter gradle commands. However, the main 
difference in time is contributed by the fact that one machine isn't having to complete all
processes and this will always help limit the amount of runtime. If the system components
are located different locations, this will help lower the amount of work on one machine.


## Questions (Task 3)
1. While looking at the wireshark capture, the most time lost could again be the fact that 
it's a TCP connection. A UDP connection could make this more efficient in time if there 
weren't as many three-way handshakes with the multiple ports. Less nodes could also improve
our program.

2. I think it does make sense to run the algorithm as a distributed algorithm. It makes it 
quicker/more efficient since the processes are done seperately. The nodes communicate with 
one another which also helps if one fails and to work concurrently. I would much rather 
have work split between multiple processes rather than one process to carry the heavy 
workload. 