public class Godsvogn extends Vogn {
    
    public double maksLast;
    
    public Godsvogn(String id, int sporvidde, int lengde, double maksLast) {
        super(id, sporvidde, lengde);
        this.maksLast = maksLast;
    }
}
