

public class PremiumUser extends User {
    
    public PremiumUser(String username, String password) {
        super(username, username);
    }

    public void changeUsername(String newUsername, String newPassword) {
            username = newUsername;
            password = newPassword;
            
        }
    }