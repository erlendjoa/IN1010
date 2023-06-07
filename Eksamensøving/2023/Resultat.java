//5B:
public class Resultat implements Runnable {
    
    Monitor monitor;
    
    public Resultat(Monitor monitor) {
        this.monitor = monitor;
    }
    
    @Override
    public void run() {
        while (true) {
            // tråden vil kjøre i loop til erFerdige == True
            if (monitor.erFerdige) {
                Skinnegaaende sg = monitor.hentNeste();
                if (sg != null) {
                    System.out.println(sg.hentId());
                } else {
                    break;
                }    
            }
            
        }
    }
}