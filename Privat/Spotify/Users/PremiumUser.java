

public class PremiumUser extends User {
    
    public PremiumUser(int id, String username, String password) {
        super(id, username, username);
    }

    public void changeUsername(String newUsername, String newPassword) {
            username = newUsername;
            password = newPassword;
        }
    }