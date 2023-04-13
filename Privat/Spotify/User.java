

public abstract class User {
    
    public String username;
    protected String password;
    private final int id;

    NodeList<Mp3> favourites;
    NodeList<Mp3> discoverWeekly;
    NodeList<Playlist> playlists;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
