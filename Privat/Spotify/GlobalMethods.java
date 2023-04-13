

public class GlobalMethods {
    
    
    public static NodeList<Playlist> findFeaturedTracks(Artist artist, NodeList<Playlist> allPlaylists) {
        NodeList<Playlist> featuringThis = new NodeList<>();

        for (Playlist currentPlaylist : allPlaylists) {
            for (Mp3 track : currentPlaylist.tracks) {
                if (track.getArtist() == artist) {
                    if (!featuringThis.contains(currentPlaylist)) {
                        featuringThis.add(currentPlaylist);
                    }
                }
            }
        }
        return featuringThis;
    }
}
