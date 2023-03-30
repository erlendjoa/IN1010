import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class KnivMonitor {

    ArrayList<Kniv> kniverArr = new ArrayList<>();
    ReentrantLock laas = new ReentrantLock();

    public void settInnKniv(Kniv kniv) {
        laas.lock();
        try {
            kniverArr.add(kniv);
        }
        finally {
            laas.unlock();
        }

    }

    public Kniv[] taUtKniver() {
        laas.lock();
        try {
            if (kniverArr.size() <= 2) {
                return null;
            }
                Kniv[] tempKniver = {kniverArr.remove(0), kniverArr.remove(1)};
                return tempKniver;
        }
        finally {
            laas.unlock();
        }
    }

    public int hentAntKniver() {
        laas.lock();
        try {
            return kniverArr.size();
        }
        finally {
            laas.unlock();
        }
    }
}