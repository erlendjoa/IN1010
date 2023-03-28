import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Monitor {
    
    Lock laas = new ReentrantLock();
    Condition condition = laas.newCondition();

    int detMinste;
    int detStorste;

    public boolean settMinste(int t) {
        laas.lock();

        try {
            if (!(t > detStorste)) {
                detMinste = t;
                return true; }
            return false;
        } finally {
            laas.unlock();
        }
    }

    public boolean settStorste(int t) {
        if (!(t < detMinste)) {
            detStorste = t;
            return true; }
        return false;
    }


}
