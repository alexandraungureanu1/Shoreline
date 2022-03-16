## Table of contents
* [Problem description](#problem-description)
* [Discussion about the implementation](#discussion)
* [Example of program in action](#example)

## Problem description

In this social network, each user has friends. </br>
A chain of friends between two users, user A and user B, is a sequence of users starting with A and ending with B, 
such that for each user in the chain, ua, the subsequent user, ua + 1, are friends. <br>
Given a social network and two users, user A and user B, please write a function that computes the length of the shortest chain of friends between A and B. <br>

## Discussion about the implementation

:white_circle: How did you represent the social network? Why did you choose this representation? </br>

:heavy_check_mark: I represented the network as a graph:  
the vertices are the users and the edges are the friend bonds between two users, the network becoming only an adjacency list of the nodes. 
I chose this specific implementation as it was the most efficient and effective way to store the data and manipulate it.  </br>
The solution is in Java and I used two classes besides the main one: 
the user class which stores the name and a unique id of the user and a network class with an adjacency list for the connections. </br></br>

:white_circle: 2.	What algorithm did you use to compute the shortest chain of friends? What alternatives did you consider? 
Why did you choose this algorithm over the alternatives? </br>

:heavy_check_mark: The algorithm chosen is a slightly changed BFS. When we make the traversal of the graph by applying bread first search, 
we also store the distance between every visited node and the source node and the predecessor of every vertex.  </br>
I also considered using the Dijkstra algorithm for finding the shortest path between two vertices,
but because the graph is unweighted, this option would have complicated the problem in hand. </br>
As the BFS traversal has a complexity of O(E+V), comparing to the one of O(V^2) of Dijkstra, this one seemed the better choice. </br></br>

:white_circle: Please enumerate the test cases you considered and explain their relevance. </br>

:heavy_check_mark: The test cases made: computing the shortest path between a connected vertex and an unconnected one. 
In that case the algorithm shows that the two users don’t have common friends. </br>
I also tried to find the chain between the same users, but the program recognizes this fact.  
I tried to make a friend connection with same user, but it also doesn’t allow me to do such a
thing because the network is a hashmap with a set on the second position, which is a collection that doesn’t allow duplicates. </br></br>



















