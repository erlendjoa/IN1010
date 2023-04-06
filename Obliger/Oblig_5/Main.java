import java.io.File;
import java.util.HashMap;

public class Main {
    String path;

    public Main(String path) {
        this.path = path; }
    
    public static void main (String[] args) {
        Main obl5 = new Main("TestMappe");
        obl5.kjor(); }


    public void kjor() {
        int antallFiler = 9;

        File[] testDataFiler = new File[antallFiler];
        File[] testDataLikeFiler = new File[antallFiler];
        for (int i = 0; i < antallFiler; i++) {
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
        

    
        Subsekvens hoyest1 = new Subsekvens("", 0);
        for (String sekvens : nyHashMap1.keySet()) {
            if (nyHashMap1.get(sekvens).hentAntall() > hoyest1.hentAntall()) {
                hoyest1 = nyHashMap1.get(sekvens); } }
        System.out.println("= Subsekvens med hoyest antall i /TestData: " + hoyest1);

        Subsekvens hoyest2 = new Subsekvens("", 0);
        for (String sekvens : nyHashMap2.keySet()) {
            if (nyHashMap2.get(sekvens).hentAntall() > hoyest2.hentAntall()) {
                hoyest2 = nyHashMap2.get(sekvens); } }
        System.out.println("= Subsekvens med hoyest antall i /TestDataLike: " + hoyest2);
            
        System.out.println("=== Program HLT ===");
    }
}
