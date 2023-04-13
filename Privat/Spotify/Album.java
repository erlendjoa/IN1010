

public abstract class Album {
    protected NodeList<Mp3> tracks;

    private String type;
    private String title;
    private int year;

    public Album(String type, String title, int year) {
        this.type = type;
        this.title = title;
        this.year = year;
    }
}