import java.io.File;
import java.util.HashMap;

public class Oblig5Del1 {
    String path;

    public Oblig5Del1(String path) {
        this.path = path; }
    
    public static void main (String[] args) {
        Oblig5Del1 obl5 = new Oblig5Del1("TestMappe");
        obl5.kjor(); }


    public void kjor() {
        File[] testDataFiler = new File[9];
        File[] testDataLikeFiler = new File[9];
        for (int i = 0; i < 9; i++) {
            testDataFiler[i] = new File(path + "/TestData/fil" + (i+1) + ".csv"); 
            testDataLikeFiler[i] = new File(path + "/TestDataLike/fil" + (i+1) + ".csv"); }

        SubsekvensRegister subRegister1 = new SubsekvensRegister();
        SubsekvensRegister subRegister2 = new SubsekvensRegister();

        for (File fil : testDataFiler) {
            subRegister1.settInn(SubsekvensRegister.lesFil(fil)); }
        for (File fil : testDataLikeFiler) {
            subRegister2.settInn((SubsekvensRegister.lesFil(fil))); }

        HashMap<String,Subsekvens> nyHashMap1 = new HashMap<>();
        for (HashMap<String,Subsekvens> hashMap : subRegister1.register) {
            nyHashMap1 = subRegister1.settSammen(nyHashMap1, hashMap); }

        HashMap<String,Subsekvens> nyHashMap2 = new HashMap<>();
        for (HashMap<String,Subsekvens> hashMap : subRegister2.register) {
            nyHashMap2 = subRegister2.settSammen(nyHashMap2, hashMap); }
        
        Subsekvens hoyest = new Subsekvens("", 0);
        for (String sekvens : nyHashMap1.keySet()) {
            if (nyHashMap1.get(sekvens).hentAntall() > hoyest.hentAntall()) {
                hoyest = nyHashMap1.get(sekvens); } }


        System.out.println("Subsekvens med hoyest antall: " + hoyest);
        System.out.println("=== Program HLT ===");
    }
}
