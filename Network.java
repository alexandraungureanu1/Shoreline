package com.company;

import java.util.*;

public class Network {

    /**
     * This data member is an adjacency list for every user(node) in the social
     * network. Using a HashMap for storing the friends connections between users
     * there won't be situations with the same user put twice in the network.
     * Using a set, this also takes care that a user cannot befriend itself or have
     * in his friends list the same person twice.
     */
    private HashMap<User, Set<User>> listConnections;

    Network() {
        listConnections = new HashMap<>();
    }

    public void addUser(User user) {
        listConnections.put(user, new HashSet<>());
    }

    /**
     * This function adds an edge to the adjacency list.
     *
     * @param firstUser  - a user of the network
     * @param secondUser - a user of the network
     */
    public void addConnection(User firstUser, User secondUser) {
        listConnections.get(firstUser).add(secondUser);
        listConnections.get(secondUser).add(firstUser);
    }

    /**
     * This function is used for printing every user
     * along its list of friends.
     */
    public void printNetwork() {
        for (User i : listConnections.keySet()) {
            System.out.println("User: " + i.getName());
            System.out.print("Friends: ");
            for (User value : listConnections.get(i)) {
                System.out.print(value.getName() + " ");
            }
            System.out.println();
        }
    }

    /**
     * This function is used to find the shortest path between
     * two given users.
     *
     * @param A - the source vertex
     * @param B - the destination  vertex
     */
    public void findChain(User A, User B) {

        if (A.equals(B)) {
            System.out.println("These are the same users!");
            return;
        }

        /**
         * The predecessor of every node in the network.
         */
        HashMap<User, User> predecessor = new HashMap<>();
        /**
         * For every node, we store the distance between him and the node A.
         */
        HashMap<User, Integer> distance = new HashMap<>();

        if (bfs(A, B, predecessor, distance) == false) {
            System.out.println("There is no chain of friends between these two users.");
            return;
        }

        /**
         * We start from the destination vertex and go through
         * the predecessor of every vertex to get to the source.
         */
        LinkedList<User> path = new LinkedList<>();
        User fromEndToStart = B;
        path.add(fromEndToStart);
        while (predecessor.get(fromEndToStart).getId() != -1) {
            path.add(predecessor.get(fromEndToStart));
            fromEndToStart = predecessor.get(fromEndToStart);
        }

        System.out.println("Chain of friends between " + A.getName() + " and " + B.getName() + " is: ");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i).getName() + " ");
        }

    }

    private boolean bfs(User A, User B, HashMap<User, User> predecessor, HashMap<User, Integer> distance) {
        /**
         * We make a queue in which we put a vertex when
         * we visit it for the first time.
         */
        LinkedList<User> queue = new LinkedList<>();

        /**
         * For every user in the network we need to know
         * whether it was visited or not in the traversal.
         */
        HashMap<User, Boolean> visited = new HashMap<>();

        /**
         * We make a user that has no implications in the network
         * to know which nodes in the end don't have a predecessor.
         */
        User fakeUser = new User("Fake User");
        fakeUser.setId(-1);

        for (User i : listConnections.keySet()) {
            /**
             * In the beginning, there is no vertex visited.
             */
            visited.put(i, false);
            predecessor.put(i, fakeUser);
            distance.put(i, Integer.MAX_VALUE);
        }

        /**
         * We visit the first user, and we add him in the queue
         * to visit his friends.
         */
        visited.put(A, true);
        distance.put(A, 0);
        queue.add(A);

        while (!queue.isEmpty()) {
            User u = queue.remove();
            for (User value : listConnections.get(u)) {
                if (visited.get(value) == false) {
                    visited.put(value, true);
                    int initialDist = distance.get(value);
                    distance.put(value, initialDist + 1);
                    predecessor.put(value, u);
                    queue.add(value);

                    /**
                     * If we find the user B, we stop the BFS.
                     */
                    if (value.equals(B))
                        return true;
                }
            }
        }
        return false;
    }
}
