import java.io.File;
import java.util.HashMap;

public class Main implements GlobalInt{
    private final String path;

    public Main(String path) {
        this.path = path; }
    
    public static void main (String[] args) {
        Main obl5 = new Main("TestMappe");
        obl5.kjor(); }


    public void kjor() {

        File[] testDataFiler = new File[MAX_ANT_FILER];
        for (int i = 0; i < MAX_ANT_FILER; i++) {
            testDataFiler[i] = new File(path + "/TestData/fil" + (i+1) + ".csv"); }
        
        Monitor1 monitor = new Monitor1();

        for (int i = 0; i < MAX_ANT_FILER; i++) {
            LeseTrad leseTraad = new LeseTrad(monitor, testDataFiler[i]);
            Thread traad = new Thread(leseTraad);
            traad.start(); }





    
        System.out.println("=== Program HLT ===");
    }
}
