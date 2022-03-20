import java.util.Objects;

/**
 * A class for storing the information of a user.
 */

public class User {

    /**
     * I used a static variable for associating
     * a unique id to every user in the network.
     */
    private String name;
    private static int numberOfUsers = 0;
    private int id;

    public User(String name) {
        this.name = name;
        numberOfUsers++;
        id = numberOfUsers;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && getName().equals(user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }
}
