import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Monitor {

    private final Lock lock;
    private final Condition condition;
    
    public Monitor() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void skrivUtTall(int nyttTall) throws InterruptedException {
        lock.lock();
        try {

            while(nyttTall != 10) {
                condition.await();
            }

            System.out.println(nyttTall);
        }
        finally {
            lock.unlock();
        }
    }
}
