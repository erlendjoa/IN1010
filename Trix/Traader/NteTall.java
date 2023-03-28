import java.util.*;
import java.util.concurrent.*;

// a = løst
// b = ikke løst
// c = løst

public class NteTall implements Runnable{

    int start;
    int max;

    public NteTall(int start, int max) {
        this.start = start;
        this.max = max;
    }

    public static void main(String[] args) {

        NteTall ntetall = new NteTall();
        Thread nyTraad1 = new Thread(ntetall);
        nyTraad1.start();

        for (int i = 0; i < 10; i++) {
            Thread nyTraad3 = new Thread(ntetall);
            nyTraad3.start();
        }
    }
    
    @Override
    public void run() {
        for (int i = 5; i <= 10000; i+=10) {
            System.out.println(i);
        }
    }
}