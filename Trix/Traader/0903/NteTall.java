public class NteTall implements Runnable{

    int start;
    int max;

    public NteTall(int start, int max) {
        this.start = start;
        this.max = max;
    }
    
    // b)

    @Override
    public void run() {
        for (int i = start; i < max; i++) {
            System.out.println(i);
        }
    }

    /* a)

    @Override
    public void run() {
        for (int i = 5; i <= 10000; i+=10) {
            System.out.println(i);
        }
    }
    */
}