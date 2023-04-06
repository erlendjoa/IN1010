import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor1 implements GlobalConstant{

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

}
