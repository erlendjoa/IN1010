public class O implements Runnable{

    Monitor monitor;
    int value;

    public O(Monitor monitor, int value) {
        this.monitor = monitor;
        this.value = value;
    }
    
    @Override
    public void run() {
        while(monitor.settMinste(value)) {
            value++;
        }
        System.out.println("Tallet " + value + " er ikke lenger minst.");
    }
    
}
