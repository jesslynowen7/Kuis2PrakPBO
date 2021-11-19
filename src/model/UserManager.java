package model;

public class UserManager {
    //Lazy Instantiation
    private static UserManager instance;
    private User user;


    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void logOut() {
        instance = null;
    }


}
