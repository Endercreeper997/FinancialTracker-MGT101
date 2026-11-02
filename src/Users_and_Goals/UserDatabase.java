package Users_and_Goals;

import java.util.ArrayList;
import java.util.List;



public class UserDatabase {

    List<User> users;

    public UserDatabase() {
        setUsers(new ArrayList<>());
    }

    //region Get and Set
    public List<User> getUsers() {
        return this.users;
    }
    private void setUsers(List<User> users) {
        this.users = users;
    }
    //endregion

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public User findUser(User user) {
        User foundUser = null;
        for (User u : users) {
            if (u.equals(user)) {
                System.out.println(u);
                foundUser = u;
            }
        }
        return foundUser;
    }

    public void addTestUsers(){
        System.out.println("Adding test users: John User, Gnome Johnson, Agatha the Smelly");
        User testUser = new User("John User", "BestUs3r", 10000);
        this.addUser(testUser);

        testUser = new User("Gnome Johnson", "whimsy", 10);
        this.addUser(testUser);

        testUser = new User("Agatha the Smelly", "devinLaughEnjoyer", -30);
        this.addUser(testUser);
        System.out.println("Test users successfully added");

    }

    public User checkAllUsersLogin(String uInput, String pInput) {
        for (User user : users) {
            boolean returnUser = user.userVerify(uInput, pInput);
            if (returnUser) {
                return user;
            }
        }

        return null;
    }

}
