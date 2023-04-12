import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor1 {

    private final ReentrantLock laas = new ReentrantLock();

    SubsekvensRegister subRegister = new SubsekvensRegister();
    public ArrayList <HashMap<String,Subsekvens> > register = new ArrayList<>();


    public void settInn(HashMap<String,Subsekvens> hashMap) {
        laas.lock();
        try {
            register.add(hashMap); }
        finally {
            laas.unlock(); }
    }

    public int hentAnt() {
        return register.size(); }   
    
    public HashMap<String,Subsekvens> lesFil(File fil) {
        laas.lock();
        try {
            return SubsekvensRegister.lesFil(fil); }
        finally {
            laas.unlock(); }
    }

    public Subsekvens hentHoyest() {
        Subsekvens hoyest = new Subsekvens("", 0);
        HashMap<String,Subsekvens> hashMap = register.get(0);

        for (String sekvens : hashMap.keySet()) {
            if (hashMap.get(sekvens).hentAntall() > hoyest.hentAntall()) {
                hoyest = hashMap.get(sekvens); } } 

        System.out.println(register.size());
        return hoyest; }
}