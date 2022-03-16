package com.company;

/**
 * @author Alexandra Ungureanu
 */

public class Main {

    public static void main(String[] args) {

        Network network = new Network();

        /**
         * We firstly create the users.
         */
        User u1 = new User("user_1");
        User u2 = new User("user_2");
        User u3 = new User("user_3");
        User u4 = new User("user_4");
        User u5 = new User("user_5");
        User u6 = new User("user_6");
        User u7 = new User("user_7");
        User u8 = new User("user_8");
        User u9 = new User("user_9");
        User u10 = new User("user_10");
        User u11 = new User("user_11");

        /**
         * We then add them to the network.
         */

        network.addUser(u1);
        network.addUser(u2);
        network.addUser(u3);
        network.addUser(u4);
        network.addUser(u5);
        network.addUser(u1);
        network.addUser(u6);
        network.addUser(u7);
        network.addUser(u8);
        network.addUser(u9);
        network.addUser(u10);
        network.addUser(u11);

        /**
         * We add the connections between two users (the edges of the graph).
         */
        network.addConnection(u1, u2);
        network.addConnection(u1, u3);
        network.addConnection(u1, u6);
        network.addConnection(u6, u3);
        network.addConnection(u2, u6);
        network.addConnection(u2, u4);
        network.addConnection(u4, u6);
        network.addConnection(u6, u5);
        network.addConnection(u2, u10);
        network.addConnection(u5, u3);
        network.addConnection(u2, u8);
        network.addConnection(u5, u8);
        network.addConnection(u3, u7);
        network.addConnection(u10, u9);

        network.printNetwork();

        network.findChain(u5, u11);
    }
}
