
public class Passasjervogn extends Vogn {
    
    public int maksAnt;
    
    public Passasjervogn(String id, int sporvidde, int lengde, int maksAnt) {
        super(id, sporvidde, lengde);
        this.maksAnt = maksAnt;
    }
}
