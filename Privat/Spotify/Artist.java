public class Artist {
    
    String name;

    NodeList<Album> tracks;

    NodeList<Album> popularTracks;
    NodeList<Album> albums;
    NodeList<Album> singlesAndEps;
    NodeList<Album> compilations;

    public NodeList<Album> getTracks() {
        return tracks;
    }
}
