import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SubsekvensRegister {
    
    public ArrayList <HashMap<String,Subsekvens> > register = new ArrayList<>();


    public void settInn(HashMap<String,Subsekvens> hashMap) {
        register.add(hashMap); }

    public int hentAnt() {
        return register.size(); }


    public static HashMap <String,Subsekvens> lesFil(File fil) {
        try {
            Scanner scanner = new Scanner(fil);
            HashMap <String,Subsekvens> hashMap = new HashMap<>();

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                int start = 0; int end = 3;

                while (end != line.length()+1 && line.length() >= 3) {
                    String sekString = line.substring(start, end);

                    Subsekvens sekvens = new Subsekvens(sekString, 1);
                    hashMap.put(sekString, sekvens);
                    start++; end++; } }

            scanner.close();
            return hashMap; }

        catch (FileNotFoundException e) {
            System.out.println("Fant ikke fil.");
            return null; } }

    
    public HashMap <String,Subsekvens> settSammen(HashMap<String,Subsekvens> hM1, HashMap<String,Subsekvens> hM2) {
        for (String sekvens : hM2.keySet()) {
            if (hM1.containsKey(sekvens)) {
                int antall = hM1.get(sekvens).hentAntall() + hM2.get(sekvens).hentAntall();
                hM1.get(sekvens).settAntall(antall);
            } else {
                hM1.put(sekvens, hM2.get(sekvens)); } }
        return hM1;  }
}