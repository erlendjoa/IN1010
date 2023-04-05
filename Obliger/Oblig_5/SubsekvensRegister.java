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
                int start = 0; int end = 2;

                while (end != line.length() && line.length() > 3) {
                    String sekString = line.substring(start, end);
                    /*
                    for (int i = 0; i < hashMap.size(); i++) {
                        if (hashMap.get(i).subskv == sekString) {
                            int nyAntall = hashMap.get(i).hentAntall() + 1;
                            hashMap.get(i).settAntall(nyAntall); 
                            break; } }
                    */
                    Subsekvens sekvens = new Subsekvens(sekString, 1);
                    System.out.println(sekvens);
                    hashMap.put(sekString, sekvens);
                    start++; end++; } }

            scanner.close();
            return hashMap; }

        catch (FileNotFoundException e) {
            System.out.println("Fant ikke fil.");
            return null; } }
}
