import java.util.HashMap;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Monitor2 implements GlobalConstant{
    private final ReentrantLock laas = new ReentrantLock();
    private final Condition ikkeTom = laas.newCondition();

    public SubsekvensRegister subRegister = new SubsekvensRegister();


    public void settInn(HashMap<String,Subsekvens> hashMap) {
        laas.lock();
        try {
            subRegister.settInn(hashMap); 
            ikkeTom.signalAll(); }
        finally {
            laas.unlock(); } 
    }

    public HashMap<String,Subsekvens> fjern() throws InterruptedException {
        laas.lock();
        try {
            while (subRegister.hentAnt() < 1) {
                ikkeTom.await(); }
            return subRegister.taUt(); }
        finally {
            laas.unlock(); }
    }

    public int hentAnt() {
        return subRegister.hentAnt(); }  

    
    public HashMap<String,Subsekvens> lesFil(File fil) {
        laas.lock();
        try {
            return SubsekvensRegister.lesFil(fil); }
        finally {
            laas.unlock(); }
    }

    public Subsekvens hentHoyest() {
        System.out.println("Register size() etter merge: " + subRegister.hentAnt());
        
        Subsekvens hoyest = new Subsekvens("", 0);
        HashMap<String,Subsekvens> hashMap = subRegister.register.get(0);

        for (String sekvens : hashMap.keySet()) {
            if (hashMap.get(sekvens).hentAntall() > hoyest.hentAntall()) {
                hoyest = hashMap.get(sekvens); } } 

        return hoyest; }
}