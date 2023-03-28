
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MinRun implements Runnable{
  private final int SLUTT;
  private final int START;
  private final int N;
  private int teller = 0;
  private final Monitor monitor;

  private final Lock lock = new ReentrantLock();

  public MinRun(int n, int start, int slutt, Monitor m){
    this.SLUTT = slutt;
    this.START = start;
    this.N = n;
    this.monitor = m;
  }

  public void run(){
    lock.lock();
    try{
      while(teller < SLUTT){
        if(teller % 10 == N){
          monitor.skrivUtTall(teller);
        }
        teller++;
        }
      }finally{
        lock.unlock();
      }
    }
  }

