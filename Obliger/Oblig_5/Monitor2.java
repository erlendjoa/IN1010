import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Monitor2 {
    private final ReentrantLock laas = new ReentrantLock();
    public final Condition cond = laas.newCondition();

    public SubsekvensRegister subRegister = new SubsekvensRegister();


    public void settInn(HashMap<String,Subsekvens> hashMap) {
        laas.lock();
        try {
            subRegister.settInn(hashMap); 
            cond.signalAll(); }
        finally {
            laas.unlock(); } 
    }

    public ArrayList<HashMap<String,Subsekvens>> hentTo() throws InterruptedException {
        laas.lock();
        try { 
            if (subRegister.hentAnt() >= 2) {
                return subRegister.taUtTo(); 
            } else {
                cond.await(); 
            }
        }
        finally {
            laas.unlock(); }
        return null;
    }

    public int hentAnt() {
        return subRegister.hentAnt(); }  

    
    public HashMap<String,Subsekvens> lesFil(File fil) {
            return SubsekvensRegister.lesFil(fil); }

    public Subsekvens hentHoyest() {        
        Subsekvens hoyest = new Subsekvens("", 0);
        HashMap<String,Subsekvens> hashMap = subRegister.register.get(0);

        for (String sekvens : hashMap.keySet()) {
            if (hashMap.get(sekvens).hentAntall() > hoyest.hentAntall()) {
                hoyest = hashMap.get(sekvens); } } 

        return hoyest; }
}
