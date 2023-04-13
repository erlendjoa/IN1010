

public abstract class Album {

    Mp3 mp3;
    String title;
    String year;

    public Album(Mp3 mp3) {
        this.mp3 = mp3;
        this.title = mp3.getTitle();
    }
}