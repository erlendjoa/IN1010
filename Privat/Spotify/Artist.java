

public abstract class Artist implements GlobalConstants {
    
    private final String name;

    private NodeList<Album> tracks;

    private NodeList<Album> popularTracks;
    private NodeList<Album> albums;
    private NodeList<Album> singlesAndEps;
    private NodeList<Album> compilations;

    // TODO: make these relevant:
    private NodeList<Artist> similarArtists;    // list of similar artists.
    private NodeList<NodeList<Mp3>> featuringThis;  // playlists where artist is featured.

    public Artist(String name) {
        this.name = name;
    }
 
    public void addAlbum(Album newAlbum) {
        tracks.add(newAlbum);
        if (newAlbum.type == "album") {
            albums.add(newAlbum);
        } else if (newAlbum.type == "single") {
            singlesAndEps.add(newAlbum);
        } else if (newAlbum.type == "ep") {
            singlesAndEps.add(newAlbum);
        } else if (newAlbum.type == "compilation") {
            compilations.add(newAlbum);
        }
        // TODO: get max listeners for an album and add to popularTracks.
    }

    protected NodeList<Album> getTracks() {
        return tracks;
    }
}
