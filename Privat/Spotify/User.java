

public abstract class User {
    
    protected String username;
    protected String password;
    private final int id;
    private static int idCounter = 0;

    NodeList<Mp3> favourites;
    NodeList<Mp3> discoverWeekly;
    NodeList<Playlist> playlists;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        id = idCounter;
        idCounter++;
    }
}
