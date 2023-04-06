import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Monitor1 implements GlobalConstant{

    private final ReentrantLock laas = new ReentrantLock();
    private final Condition cond = laas.newCondition();

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

    public HashMap <String,Subsekvens> settSammen(HashMap<String,Subsekvens> prevHashMap, HashMap<String,Subsekvens> nextHashMap) throws InterruptedException {
        laas.lock();
        try {
            return subRegister.settSammen(prevHashMap, nextHashMap); }

        catch (NullPointerException e) {
            return null; }

        finally {
            laas.unlock(); }
    }
}
