import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

public class SaksMonitor {
    
    ArrayList<Saks> sakser = new ArrayList<>();
    ReentrantLock laas = new ReentrantLock();

    public void settInnSaks(Saks saks) {
        laas.lock();
        try {
            sakser.add(saks);
        }
        finally {
            laas.unlock();
        }
    }

    public int hentAntSakser() {
        laas.lock();
        try {
            return sakser.size();
        }
        finally {
            laas.unlock();
        }
    }
}
