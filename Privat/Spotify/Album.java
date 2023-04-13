

public abstract class Album {
    protected NodeList<Mp3> tracks;

    protected final String type;
    protected final String title;
    protected final int year;

    public Album(String type, String title, int year) {
        this.type = type;
        this.title = title;
        this.year = year;
    }
}