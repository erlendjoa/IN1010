import java.io.File;

public class Main implements GlobalConstant{
    private final String path;

    public Main(String path) {
        this.path = path; }
    
    public static void main (String[] args) {
        for (int i = 0; i < 1000; i++) {
            Main main = new Main("TestMappe");
            main.kjor();
        }
    }

    public void kjor() {

        Monitor2 monitor = new Monitor2();
        File[] testDataFiler = new File[MAX_ANT_FILER];
        Thread[] traader = new Thread[MAX_ANT_FILER];
        Thread[] fletteTraader = new Thread[MAX_ANT_FLETTETRADER];

        for (int i = 0; i < MAX_ANT_FILER; i++) {
            testDataFiler[i] = new File(path + "/TestDataLike/fil" + (i+1) + ".csv"); }

        
        // INITIERING (1) AV ALLE FILLESING TRÅDER:
        for (int i = 0; i < MAX_ANT_FILER; i++) {
            traader[i] = new Thread(new LeseTrad(monitor, testDataFiler[i]));
            traader[i].start(); }

        // VENT PÅ FULLFØRING...
        for (Thread traad : traader) {
            try {
                traad.join(); } 
            catch (InterruptedException e) {} }

        // INITIERING (2) AV ALLE FLETTETRÅDER:
        for (int i = 0; i < MAX_ANT_FLETTETRADER; i++) {;
            fletteTraader[i] = new Thread(new FletteTrad(monitor));
            fletteTraader[i].start(); }
        
        // VENT PÅ FULLFØRING...
        for (Thread traad : fletteTraader) {
            try {
                traad.join(); }
            catch (InterruptedException e) {} }
            

        System.out.println("= Subsekvens med hoyest antall i TestDataLike: " + monitor.hentHoyest());    }
}