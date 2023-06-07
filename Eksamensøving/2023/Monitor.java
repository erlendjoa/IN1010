import java.util.concurrent.locks.*;
import java.util.ArrayList;

//5C:
public class Monitor {
    
    private final ReentrantLock laas = new ReentrantLock();
    private ArrayList<Skinnegaaende> register = new ArrayList<>();
    private final int antLeteTrader;
    
    public boolean erFerdige = false;   // avgjør om resultatrad kjører hentNeste().
    private int letetradTeller = 0; // ++ når en letetraad er ferdig.
    private int resultatTeller = 0; // ++ for å holde styr på hentNeste().
    
    public Monitor(int antLeteTrader) {
        this.antLeteTrader = antLeteTrader;
    }
    
    public void leggTil(Skinnegaaende sg) {
        laas.lock();
        try {
            register.add(sg);    
        }
        finally {
            laas.unlock();
        }
    }
    
    public void ferdigLeting() {
        laas.lock();
        try {
            letetradTeller++;
            if (letetradTeller == antLeteTrader) {
                erFerdige = true;
            }   
        }
        finally {
            laas.unlock();
        }        
    }
    
    public Skinnegaaende hentNeste() {
        // om vi har nådd enden av register:
        if (resultatTeller == register.size()) {
            return null;
        }
        // henter skinne ved plassen til resultatTeller i register:
        Skinnegaaende sg = register.get(resultatTeller);
        resultatTeller++;
        return sg;
    }
}