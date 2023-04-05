import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SubsekvensRegister {
    
    public ArrayList <HashMap<String,Subsekvens> > register = new ArrayList<>();


    public void settInn(HashMap<String,Subsekvens> hashMap) {
        register.add(hashMap); }
    
    public HashMap <String,Subsekvens> hentMap(String sekvens) {
        for (HashMap <String,Subsekvens> map : register) {
            for (String string : map.keySet()) {
                if (string == sekvens) {
                    return map; } } }
        return null; }

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
                    /*
                    for (int i = 0; i < hashMap.size(); i++) {
                        if (hashMap.get(i).subskv == sekString) {
                            int nyAntall = hashMap.get(i).hentAntall() + 1;
                            hashMap.get(i).settAntall(nyAntall); 
                            break; } }
                    */
                    Subsekvens sekvens = new Subsekvens(sekString, 1);
                    hashMap.put(sekString, sekvens);
                    start++; end++; } }

            scanner.close();
            return hashMap; }

        catch (FileNotFoundException e) {
            return null; } }

        
    public HashMap <String,Subsekvens> settSammen(HashMap<String,Subsekvens> hM1, HashMap<String,Subsekvens> hM2) {
        HashMap <String,Subsekvens> nyHashMap = new HashMap<>();
        
        for (String key1 : hM1.keySet()) {  //legg til og hvis mulig kombiner sekvenser.
            for (String key2 : hM2.keySet()) {
                if (key1 == key2) {
                    int antall = hM1.get(key1).hentAntall() + hM2.get(key2).hentAntall();
                    hM1.get(key1).settAntall(antall); } }
            nyHashMap.put(key1, hM1.get(key1)); }
        
        for (String key2 : hM2.keySet()) {  //legg til resterende sekvenser.
            if (!nyHashMap.containsKey(key2)) {
                nyHashMap.put(key2, hM2.get(key2)); } }
        
        return nyHashMap; }
}