import java.io.File;

public class Oblig5Hele implements GlobalConstant {

    String path;

    public Oblig5Hele(String path) {
        this.path = path; }
    
    public static void main(String[] args) {
        Oblig5Hele main = new Oblig5Hele("TestMappe");
        main.kjor(); }

    public void kjor() {
        Monitor2 monitorMedSykdom = new Monitor2();
        Monitor2 monitorUtenSykdom = new Monitor2();

        File[] testDataLike = new File[MAX_ANT_FILER];
        File[] testData = new File[MAX_ANT_FILER];
        Thread[] traaderLike = new Thread[MAX_ANT_FILER];
        Thread[] traader = new Thread[MAX_ANT_FILER];
        Thread[] fletteTraaderLike = new Thread[MAX_ANT_FLETTETRADER];
        Thread[] fletteTraader = new Thread[MAX_ANT_FLETTETRADER];

        for (int i = 0; i < MAX_ANT_FILER; i++) {
            testDataLike[i] = new File(path + "/TestData/fil" + (i+1) + ".csv"); 
            testData[i] = new File(path + "/TestData/fil" + (i+1) + ".csv"); }

        
        // INITIERING (1) AV ALLE FILLESING TRÅDER:
        for (int i = 0; i < MAX_ANT_FILER; i++) {
            traaderLike[i] = new Thread(new LeseTrad(monitorUtenSykdom, testDataLike[i]));
            traader[i] = new Thread(new LeseTrad(monitorMedSykdom, testData[i]));
            traaderLike[i].start();
            traader[i].start(); }

        // VENT PÅ FULLFØRING...
        for (int i = 0; i < MAX_ANT_FILER; i++) {
            try {
                traaderLike[i].join(); 
                traader[i].join(); } 
            catch (InterruptedException e) {} }

        
        // INITIERING (2) AV ALLE FLETTETRÅDER:
        for (int i = 0; i < MAX_ANT_FLETTETRADER; i++) {;
            fletteTraaderLike[i] = new Thread(new FletteTrad(monitorUtenSykdom));
            fletteTraader[i] = new Thread(new FletteTrad(monitorMedSykdom));
            fletteTraaderLike[i].start(); 
            fletteTraader[i].start(); }
        
        // VENT PÅ FULLFØRING...
        for (int i = 0; i < MAX_ANT_FLETTETRADER; i++) {
            try {
                fletteTraaderLike[i].join(); 
                fletteTraader[i].join(); }
            catch (InterruptedException e) {} }
        
        System.out.println("= Subsekvens med hoyest antall i TestDataLike: " + monitorUtenSykdom.hentHoyest());
        System.out.println("= Subsekvens med hoyest antall i TestDataLike: " + monitorMedSykdom.hentHoyest());
    }
}

