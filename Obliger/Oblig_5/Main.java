import java.io.File;
import java.util.HashMap;

public class Main implements GlobalConstant{
    private final String path;

    public Main(String path) {
        this.path = path; }
    
    public static void main (String[] args) {
        Main obl5 = new Main("TestMappe");
        obl5.kjor(); }


    public void kjor() {

        Monitor1 monitor = new Monitor1();
        File[] testDataFiler = new File[MAX_ANT_FILER];
        Thread[] traader = new Thread[MAX_ANT_FILER];
        Thread[] fletteTraader = new Thread[MAX_ANT_FLETTETRADER];

        for (int i = 0; i < MAX_ANT_FILER; i++) {
            testDataFiler[i] = new File(path + "/TestData/fil" + (i+1) + ".csv"); }

        
        // INITIERING (1) AV ALLE FILLESING TRÅDER:
        for (int i = 0; i < MAX_ANT_FILER; i++) {
            traader[i] = new Thread(new LeseTrad(monitor, testDataFiler[i]));
            traader[i].start(); }

        // VENT PÅ FULLFØRING...
        for (Thread traad : traader) {
            try {
                traad.join(); } 
            catch (InterruptedException e) {
                System.out.println(e); } }

        // INITIERING (2) AV ALLE FLETTETRÅDER:
        for (int i = 0; i < MAX_ANT_FLETTETRADER; i++) {;
            fletteTraader[i] = new Thread(new FletteTrad(monitor));
            fletteTraader[i].start(); }
        
        // VENT PÅ FULLFØRING...
        for (Thread traad : fletteTraader) {
            try {
                traad.join(); }
            catch (InterruptedException e) {
                System.out.println(e); } }
        
        // PRINT HØYEST ANTALL FOREKOMMEDE:
        Subsekvens hoyest = new Subsekvens("", 0);
        for (int i = 0; i < monitor.register.size(); i++) {
            HashMap<String,Subsekvens> hashMap = monitor.register.get(i);
            for (String sekvens : hashMap.keySet()) {
                if (hashMap.get(sekvens).hentAntall() > hoyest.hentAntall()) {
                    hoyest = hashMap.get(sekvens); } } }

        System.out.println("= Subsekvens med hoyest antall i /TestData: " + hoyest);
        System.out.println("=== Program HLT ===");
    }
}