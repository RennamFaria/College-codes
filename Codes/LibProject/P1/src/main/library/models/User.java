package library.models;

public class User {
    private String id;
    private String name;
    private String userType;

    public User(String id, String name, String userType) {
        this.id = id;
        this.name = name;
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserType() {
        return userType;
    }
}
