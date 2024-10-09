package entities;

public abstract class User {
    protected String name;
    protected String ID;
    protected String email;
    protected String role;

    public User(String name, String ID, String email) {
        this.name = name;
        this.ID = ID;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return this.ID;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return this.role;
    }

    public abstract int getMaxLoan();
    public abstract void printUserInfo();
}
