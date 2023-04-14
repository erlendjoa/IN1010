

public class Mp3 {

    private final String title;
    private final NodeList<Artist> artist;
    private final int duration;

    public Mp3(String title, NodeList<Artist> artist, int duration) {
        this.title = title;
        this.duration = duration;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist.get(0);
    }

    public int getDuration() {
        return duration;
    }

}
