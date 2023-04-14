import java.io.File;
import java.io.FileNotFoundException;

public class StartThreads {
    
    public static void main() {
        DataBase dataBase = new DataBase();

        Thread[] threads = new Thread[6];
        File[] files = { new File("Csv/1000 gecs.csv"), 
        new File("Csv/10000 gecs.csv"), new File("Csv/CALL ME IF YOU GET LOST.csv"),
        new File("Csv/IGOR.csv"), new File("Csv/Norman Fucking Rockwell!.csv"),
        new File("Csv/Random.csv") };

        /*
        for (int i = 1; i < 6; i++) {
            Thread readingThread = new Thread(new ReadingThread(dataBase, files[i]));
            threads[i] = readingThread;
            threads[i].start();
        }  */
        
        Thread testThread = new Thread(new ReadingThread(dataBase, files[0]));
        testThread.start();
    }
}
