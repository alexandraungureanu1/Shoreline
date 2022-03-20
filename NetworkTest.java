import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class NetworkTest {

    @Test
    void twoConnectedComponentsShouldEqualZero() {
        Network network = new Network();

        List<User> listOfNodes = IntStream.rangeClosed(0, 14)
                .mapToObj(i -> new User("user_" + i))
                .collect(Collectors.toList());

        for (User i : listOfNodes) {
            network.addUser(i);
        }

        network.addConnection(listOfNodes.get(0), listOfNodes.get(1));
        network.addConnection(listOfNodes.get(1), listOfNodes.get(2));
        network.addConnection(listOfNodes.get(0), listOfNodes.get(0));
        network.addConnection(listOfNodes.get(2), listOfNodes.get(8));
        network.addConnection(listOfNodes.get(2), listOfNodes.get(6));
        network.addConnection(listOfNodes.get(0), listOfNodes.get(7));

        network.addConnection(listOfNodes.get(3), listOfNodes.get(5));
        network.addConnection(listOfNodes.get(0), listOfNodes.get(0));

        network.addConnection(listOfNodes.get(9), listOfNodes.get(10));
        network.addConnection(listOfNodes.get(10), listOfNodes.get(11));

        assertEquals(-1, network.findChain(listOfNodes.get(6), listOfNodes.get(10)));
    }

    @Test
    void twoUsersWhoAreFriends() {
        Network network = new Network();

        List<User> listOfNodes = IntStream.rangeClosed(0, 14)
                .mapToObj(i -> new User("user_" + i))
                .collect(Collectors.toList());

        for (User i : listOfNodes) {
            network.addUser(i);
        }

        network.addConnection(listOfNodes.get(0), listOfNodes.get(1));
        network.addConnection(listOfNodes.get(1), listOfNodes.get(2));
        network.addConnection(listOfNodes.get(0), listOfNodes.get(0));
        network.addConnection(listOfNodes.get(2), listOfNodes.get(8));
        network.addConnection(listOfNodes.get(2), listOfNodes.get(6));
        network.addConnection(listOfNodes.get(0), listOfNodes.get(7));

        assertEquals(0, network.findChain(listOfNodes.get(1), listOfNodes.get(2)));
    }

    @Test
    void networkWithoutUsers() {

        Network network = new Network();

        User u1 = new User("user_1");
        User u2 = new User("user_2");

        assertEquals(-1, network.findChain(u1, u2));
    }

    @Test
    void theUsersDontBelongToNetwork() {
        Network network = new Network();

        User u1 = new User("user_1");
        User u2 = new User("user_2");
        network.addUser(u1);
    }

    @Test
    void happyFlow() {
        Network network = new Network();

        List<User> listOfNodes = IntStream.rangeClosed(0, 14)
                .mapToObj(i -> new User("user_" + i))
                .collect(Collectors.toList());

        for (User i : listOfNodes) {
            network.addUser(i);
        }

        network.addConnection(listOfNodes.get(0), listOfNodes.get(1));
        network.addConnection(listOfNodes.get(1), listOfNodes.get(2));
        network.addConnection(listOfNodes.get(2), listOfNodes.get(8));
        network.addConnection(listOfNodes.get(2), listOfNodes.get(6));
        network.addConnection(listOfNodes.get(0), listOfNodes.get(7));
        network.addConnection(listOfNodes.get(0), listOfNodes.get(3));
        network.addConnection(listOfNodes.get(3), listOfNodes.get(5));

        network.addConnection(listOfNodes.get(9), listOfNodes.get(10));
        network.addConnection(listOfNodes.get(10), listOfNodes.get(11));
        network.addConnection(listOfNodes.get(2), listOfNodes.get(10));

        assertEquals(6, network.findChain(listOfNodes.get(3), listOfNodes.get(11)));
    }

    @Test
    void moreShortestPaths() {
        Network network = new Network();

        List<User> listOfNodes = IntStream.rangeClosed(0, 14)
                .mapToObj(i -> new User("user_" + i))
                .collect(Collectors.toList());

        for (User i : listOfNodes) {
            network.addUser(i);
        }

        network.addConnection(listOfNodes.get(0), listOfNodes.get(1));
        network.addConnection(listOfNodes.get(1), listOfNodes.get(2));
        network.addConnection(listOfNodes.get(2), listOfNodes.get(8));
        network.addConnection(listOfNodes.get(2), listOfNodes.get(6));
        network.addConnection(listOfNodes.get(0), listOfNodes.get(7));
        network.addConnection(listOfNodes.get(0), listOfNodes.get(3));
        network.addConnection(listOfNodes.get(3), listOfNodes.get(5));

        network.addConnection(listOfNodes.get(9), listOfNodes.get(10));
        network.addConnection(listOfNodes.get(10), listOfNodes.get(11));
        network.addConnection(listOfNodes.get(9), listOfNodes.get(6));

        network.addConnection(listOfNodes.get(10), listOfNodes.get(5));
        network.addConnection(listOfNodes.get(8), listOfNodes.get(11));

        assertEquals(4, network.findChain(listOfNodes.get(10), listOfNodes.get(2)));
    }

    @Test
    void theSameUser() {
        Network network = new Network();

        List<User> listOfNodes = IntStream.rangeClosed(0, 14)
                .mapToObj(i -> new User("user_" + i))
                .collect(Collectors.toList());

        for (User i : listOfNodes) {
            network.addUser(i);
        }

        network.addConnection(listOfNodes.get(0), listOfNodes.get(1));
        network.addConnection(listOfNodes.get(1), listOfNodes.get(2));
        network.addConnection(listOfNodes.get(2), listOfNodes.get(8));
        network.addConnection(listOfNodes.get(2), listOfNodes.get(6));
        network.addConnection(listOfNodes.get(0), listOfNodes.get(7));
        network.addConnection(listOfNodes.get(0), listOfNodes.get(3));
        network.addConnection(listOfNodes.get(3), listOfNodes.get(5));

        network.addConnection(listOfNodes.get(9), listOfNodes.get(10));
        network.addConnection(listOfNodes.get(10), listOfNodes.get(11));

        assertEquals(-1, network.findChain(listOfNodes.get(10), listOfNodes.get(10)));
    }


}