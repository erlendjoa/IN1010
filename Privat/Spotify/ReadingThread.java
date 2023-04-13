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
                System.out.println(line);
            }   
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
