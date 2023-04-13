

public abstract class User {
    
    public String username;
    private String password;

    protected void setinfo(String newUsername, String newPassword) {
        username = newUsername;
        password = newPassword;
    }
}
