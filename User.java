
package model;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private boolean voted;

    public User(int id, String name, String email, String password, boolean voted) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.voted = voted;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public boolean hasVoted() { return voted; }
}
