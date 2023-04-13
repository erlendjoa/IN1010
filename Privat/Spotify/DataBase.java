import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class DataBase {

    ReentrantLock lock = new ReentrantLock();
    Condition cond = lock.newCondition();

    NodeList<Mp3> allTracks;
    NodeList<Artist> allArtists;
    NodeList<Playlist> allPlaylists;

    public void addMp3(Mp3 mp3) {
        lock.lock();
        try {
            allTracks.add(mp3);
        }
        finally {
            lock.unlock();
        }
    }

    public void addArtist(Artist artist) {
        lock.lock();
        try {
            allArtists.add(artist);
        }
        finally {
            lock.unlock();
        }
    }

    public void addPlaylist(Playlist playlist) {
        lock.lock();
        try {
            allPlaylists.add(playlist);
        }
        finally {
            lock.unlock();
        }
    }


    public NodeList<Playlist> findFeaturedTracks(Artist artist) {
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

    public NodeList<Artist> findFeaturedArtists(Artist artist) {
        NodeList<Artist> featuredArtists = new NodeList<>();
        for (Artist currentArtist : allArtists) {
            for (User user : currentArtist.monthlyListeners) {
                if (artist.monthlyListeners.contains(user)) {
                    featuredArtists.add(currentArtist);
                }
            }
        }
        return featuredArtists;
    }

}