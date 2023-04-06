import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Monitor1 implements GlobalInt{

    private final ReentrantLock laas = new ReentrantLock();
    private final Condition cond = laas.newCondition();

    SubsekvensRegister subRegister = new SubsekvensRegister();
    public ArrayList <HashMap<String,Subsekvens> > register = new ArrayList<>();


    public void settInn(HashMap<String,Subsekvens> hashMap) {
        laas.lock();
        try {
            register.add(hashMap); }
        finally {
            laas.unlock(); } }

    public int hentAnt() {
        return register.size(); }   
    
    public HashMap<String,Subsekvens> lesFil(File fil) {
        laas.lock();
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
            System.out.println(e);
            return null; }
        
        finally {
            laas.unlock();
            if (register.size() == MAX_ANT_FILER) {
                cond.signalAll(); } }
    }

    
    public HashMap <String,Subsekvens> settSammen(HashMap<String,Subsekvens> prevHashMap, HashMap<String,Subsekvens> nextHashMap) throws InterruptedException {
        laas.lock();
        try {
            if (register.size() < MAX_ANT_FILER) {  // kanskje while lokke
                cond.await(); }

            for (String nKey : nextHashMap.keySet()) {
                if (prevHashMap.containsKey(nKey)) {
                    int antall = prevHashMap.get(nKey).hentAntall() + nextHashMap.get(nKey).hentAntall();
                    prevHashMap.get(nKey).settAntall(antall);
                } else {
                    prevHashMap.put(nKey, nextHashMap.get(nKey)); } }
            return prevHashMap;  }

        finally {
            laas.unlock(); }
    }
}
