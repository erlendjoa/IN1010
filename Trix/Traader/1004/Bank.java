import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    ReentrantLock laas;
    int saldo;

    public Bank(int saldo) {
        this.saldo = saldo;
        laas = new ReentrantLock();
    }
    
    public void gi(int n) {
        laas.lock();
        try {
            saldo += n;
        }
            finally { laas.unlock(); }
    }

    public int ta(int n) {
        laas.lock();
        try {
            saldo -= n;
            return n;
        }
        finally { laas.unlock(); }
    }

    public int saldo() {
        laas.lock();
        try {
            return saldo;
        }
        finally { laas.unlock(); }
    }
}
