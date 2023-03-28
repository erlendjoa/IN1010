public class N implements Runnable{
    
    Monitor monitor;
    int value;

    public N(Monitor monitor, int value) {
        this.monitor = monitor;
        this.value = value;
    }

    @Override
    public void run() {
        while(monitor.settStorste(value)) {
            value--;
        }
        System.out.println("Tallet " + value + " er ikke lenger stoerst.");
    }
}
