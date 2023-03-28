public class AvbrytTraaden {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread traad = new Thread(myRunnable) {
            traad.start();
            traad.interrupt();
        }
    }
}
