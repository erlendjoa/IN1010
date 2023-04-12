import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Monitor2 implements GlobalConstant{
    private final ReentrantLock laas = new ReentrantLock();
    private final Condition cond = laas.newCondition();

    SubsekvensRegister subRegister = new SubsekvensRegister();
    public ArrayList <HashMap<String,Subsekvens> > monitorRegister = new ArrayList<>();


    public void settInn(HashMap<String,Subsekvens> hashMap) {
        laas.lock();
        try {
            monitorRegister.add(hashMap); }
        finally {
            laas.unlock(); } 
    }

    public HashMap<String,Subsekvens> fjern(int i) {
        laas.lock();
        try {
            return monitorRegister.remove(i); }
        finally {
            laas.unlock(); }
    }

    public int hentAnt() {
        return monitorRegister.size(); }  

    
    public HashMap<String,Subsekvens> lesFil(File fil) {
        laas.lock();
        try {
            return SubsekvensRegister.lesFil(fil); }
        finally {
            laas.unlock(); }
    }

    public Subsekvens hentHoyest() {
        System.out.println("Register size() etter merge: " + monitorRegister.size());
        
        Subsekvens hoyest = new Subsekvens("", 0);
        HashMap<String,Subsekvens> hashMap = monitorRegister.get(0);

        for (String sekvens : hashMap.keySet()) {
            if (hashMap.get(sekvens).hentAntall() > hoyest.hentAntall()) {
                hoyest = hashMap.get(sekvens); } } 

        return hoyest; }


    public void settSammen(HashMap<String,Subsekvens> hM1, HashMap<String,Subsekvens> hM2) throws InterruptedException {
            settInn(subRegister.settSammen(hM1, hM2)); }
}
