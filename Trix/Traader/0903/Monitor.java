import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Monitor {

    private final Lock laas;
    private final Condition cond;
    
    public Monitor() {
        laas = new ReentrantLock();
        cond = laas.newCondition();
    }

    public void skrivUtTall(int nyttTall) throws InterruptedException {
        laas.lock();
        try {
            System.out.println(nyttTall);
        }
        finally {
            laas.unlock();
        }
    }
}
