## Table of contents
* [Problem description](#problem-description)
* [Discussion about the implementation](#discussion-about-the-implementation)
* [Example of the program in action](#example-of-the-program-in-action)
* [Improvements](#improvements)

## Problem description

In this social network, each user has friends. </br>
A chain of friends between two users, user A and user B, is a sequence of users starting with A and ending with B, 
such that for each user in the chain, ua, the subsequent user, ua + 1, are friends. <br>
Given a social network and two users, user A and user B, please write a function that computes the length of the shortest chain of friends between A and B. <br>

## Discussion about the implementation

:white_circle: How did you represent the social network? Why did you choose this representation? </br>

:heavy_check_mark: I represented the network as a graph: the vertices are the users and the edges are the friend bonds between two users, the network becoming only an adjacency list of the nodes. 
I chose this specific implementation as it was the most efficient and effective way to store the data and manipulate it.
The solution is in Java and I used two classes besides the main one: 
the user class which stores the name and a unique id of the user and a network class with an adjacency list for the connections. </br></br>

:white_circle:	What algorithm did you use to compute the shortest chain of friends? What alternatives did you consider? 
Why did you choose this algorithm over the alternatives? </br>

:heavy_check_mark: The algorithm chosen is a slightly changed BFS. When we make the traversal of the graph by applying bread first search, 
we also store the distance between every visited node and the source node and the predecessor of every vertex. 
I also considered using the Dijkstra algorithm for finding the shortest path between two vertices,
but because the graph is unweighted, this option would have complicated the problem in hand.
As the BFS traversal has a complexity of O(E+V), comparing to the one of O(V^2) of Dijkstra, this one seemed the better choice. </br></br>

:white_circle: Please enumerate the test cases you considered and explain their relevance. </br>

:heavy_check_mark: The test cases made: </br>
   Happy path: 
 - a normal instance with users that have common friends
 - when there are two shortest paths, it will choose one of these two, but the program won't crash </br></br>
Unhappy path: </br>
 - when the two users are friends -> to see whether the algorithm will identify this case and not give a chain
 - when the network doesn't have users
 - when it is asked to get the chain between an user and a non-user
 - when we check the chain between the same user
 - when the users don't belong to the network

## Improvements 
- the equals method and the hashCode one were overwritten
- the tests were done using JUnit in a Maven project






