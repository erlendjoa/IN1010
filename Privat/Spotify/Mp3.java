

public class Mp3 {

    private final String title;
    private final Artist artist;
    private final int duration;

    public Mp3(NodeList content) {
        title = content.get(0);
        artist = content.get(1);
        duration = content.get(2);
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

}
