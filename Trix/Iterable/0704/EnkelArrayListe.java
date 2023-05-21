import java.util.Iterator;

public class EnkelArrayListe implements Iterable<String> {

    private String[] arr;
    private int maksStorrelse;
    private int storrelse = 0;

    public EnkelArrayListe(int maksStorrelse) {
        this.maksStorrelse = maksStorrelse;
        arr = new String[maksStorrelse];
    }

    private class ListeIterator implements Iterator<String> {
        private int i = 0;
        
        @Override
        public  boolean hasNext() {
            return i < storrelse;
        }
        @Override
        public String next() {
            String s = arr[i];
            i++;
            return s;
        }
    }
    
    @Override
    public Iterator<String> iterator() {
        return new ListeIterator();
    }

    public void leggTil(String s) {
        if (storrelse >= maksStorrelse) {
            throw new IllegalStateException();
        }
        arr[storrelse] = s;
        storrelse++;
    }



    public static void main(String[] args) {
        EnkelArrayListe eal = new EnkelArrayListe(10);
        eal.leggTil("nr1");
        eal.leggTil("nr2");
        eal.leggTil("nr3");
        for (String s : eal) {
            System.out.println(s);
        }
    }
}