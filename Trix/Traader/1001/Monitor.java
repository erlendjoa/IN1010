import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {

    private Lock laas = new ReentrantLock();

    private int detMinste;
    private int detStorste;

    public boolean settMinste(int t) {
        laas.lock();
        try {
            if (!(detStorste < t)) {
                detMinste = t;
                return true;
            }
            return false;
        }
        finally {
            laas.unlock();
        }
    }

    public boolean settStorste(int t) {
        laas.lock(); 
        try {
            if (!(t <= detMinste)) {
                detStorste = t;
                return true;
            }
            return false;
        }
        finally {
            laas.unlock();
        }
    }
}