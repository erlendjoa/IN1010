import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadingThread implements Runnable {

    DataBase dataBase;
    File file;

    public ReadingThread(DataBase dataBase, File file) {
        this.dataBase = dataBase;
        this.file = file;
    }
    
    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().split(";");
        
                NodeList<Artist> tempArtists = new NodeList<>();
                String[] artistArr = line[1].split("|");

                for (String content : artistArr) {
                    Artist tempArtist = new Artist(content);
                    tempArtists.add(tempArtist);

                    Boolean existsInAllArtists = false;
                    for (Artist currentArtist : dataBase.allArtists) {
                        if (currentArtist.getName() == tempArtist.getName()) {
                            existsInAllArtists = true;
                        }
                    }
                    if (!existsInAllArtists) {
                        dataBase.allArtists.add(tempArtist);    // add artist to allArtists if it doest already exist.
                    }
                }

                String[] durationArr = line[2].split(":");
                int duration = Integer.parseInt(durationArr[0])*60 + Integer.parseInt(durationArr[1]);

                
                Mp3 mp3 = new Mp3(line[0], tempArtists, duration);
                Boolean existsInAllTracks = false;
                for (Mp3 currentMp3 : dataBase.allTracks) {
                    if (currentMp3.getTitle() == mp3.getTitle()) {
                        existsInAllTracks = true;
                    }
                }
                if (!existsInAllTracks) {
                    dataBase.allTracks.add(mp3);
                }
                
            }   
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
