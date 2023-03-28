

public class LearnThread implements Runnable{
    
    // Learn Threads!
    
    public static void main(String[] args) {

        LearnThread lt1 = new LearnThread();
        LearnThread lt2 = new LearnThread();
        Thread t1 = new Thread(lt1);
        Thread t2 = new Thread(lt2);

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {}
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Document: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}