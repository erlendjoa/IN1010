

public class Mp3 {

    private final String title;
    private final NodeList<Artist> artists;
    private final int duration;

    public Mp3(String title, NodeList<Artist> artists, int duration) {
        this.title = title;
        this.duration = duration;
        this.artists = artists;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artists.get(0);
    }

    public int getDuration() {
        return duration;
    }

    public String toString() {
        return "'" + getTitle() + "' by " + getArtist().getName() + ": " + getDuration();
    }
}
