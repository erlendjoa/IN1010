import java.util.Iterator;

public class Butikk implements Iterable<Person> {

    Person hode;

    private class ButikkIterator implements Iterator<Person> {
        private Person tempP = hode;

        @Override
        public boolean hasNext() {
            return tempP != null;
        }
        @Override
        public Person next() {
            Person p = tempP;
            tempP = tempP.neste;
            return p;
        }
    }

    @Override
    public Iterator<Person> iterator() {
        return new ButikkIterator();
    }

    public void entreButikk(Person p) {
        if (hode == null) {
            hode = p;
            return;
        }
        Person tempP = hode;
        while (tempP.neste != null)  {
            tempP = tempP.neste;
        }
        tempP.neste = p;
    }

    public void kassa() {
        while (hode != null) {
            System.out.println(hode.navn + " kjøper " + hode.gjenstand + ".");
            System.out.println("Hade bra!");
            hode = hode.neste;
        }
    }
}