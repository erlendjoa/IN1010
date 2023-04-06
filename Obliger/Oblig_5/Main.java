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
        for (int i = 0; i < MAX_ANT_FILER; i++) {
            testDataFiler[i] = new File(path + "/TestData/fil" + (i+1) + ".csv"); }

        
        // INITIERING AV ALLE TRÅDER:
        for (int i = 0; i < MAX_ANT_FILER; i++) {
            LeseTrad leseTraad = new LeseTrad(monitor, testDataFiler[i]);
            Thread traad = new Thread(leseTraad);
            traader[i] = traad;
            traad.start(); }

        // VENT PÅ FULLFØRING AV TRÅDER:
        for (Thread traad : traader) {
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

        System.out.println(monitor.register);
        System.out.println("= Subsekvens med hoyest antall i /TestData: " + hoyest);
        System.out.println("=== Program HLT ===");
    }
}