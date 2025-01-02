package mvc.models;

public class UserModel {
    private int id;
    private int userType;
    private String name;
    private String username;
    private String password;

    public UserModel(int id, String name, String username, String password, int userType) {
        this.id = id;
        this.userType = userType;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserType() {return userType;}

    public void setUserType(int userType) {this.userType = userType;}

    public String getName() {
        return name;
    }

    public void setName(String firstName) {this.name = name;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = this.username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
