import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Monitor2 extends Monitor1 {

    private final ReentrantLock laas = new ReentrantLock();
    private final Condition cond = laas.newCondition();

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
