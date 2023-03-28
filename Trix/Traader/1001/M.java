public class M implements Runnable{
    
    Monitor monitor;
    int value;

    public M(Monitor monitor, int value) {
        this.monitor = monitor;
        this.value = value;
    }

    @Override
    public void run() {
        while(monitor.settMinste()) {

        }
    }
}
