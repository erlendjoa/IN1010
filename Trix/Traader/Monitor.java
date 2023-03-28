import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {

    Lock lock;
    
    public Monitor() {
        lock = new ReentrantLock();
    }

    public void skrivUtTall(int nyttTall) {
        lock.lock();
        try {
            System.out.println(nyttTall);
        }
        finally {
            lock.unlock();
        }
    }
}
