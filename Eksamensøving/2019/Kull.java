import java.util.Iterator;

abstract public class Kull implements Iterable<Hund> {
    public Hund mor, far;

    public Kull(Hund mor, Hund far) {
        this.mor = mor;
        this.far = far;
    }

    public abstract void settInn(Hund h);
    public abstract Iterator<Hund> iterator();
}
