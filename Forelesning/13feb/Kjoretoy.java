

abstract class Kjoretoy {
    
    protected String regNr; //synlig i sin mappe (objekt)
    protected String merke;
    protected String modell;
    protected double hastighet;

    public Kjoretoy(String regNr_, String merke_, String modell_, double hastighet_) {
        regNr = regNr_;
        merke = merke_;
        modell = modell_;
        hastighet = hastighet_;
    }

    public void beregn_kjoretid(double avstand) {
        double tid = (avstand / hastighet) * 60;
        System.out.println(tid);
    }

    abstract public void skrivUt();
}
