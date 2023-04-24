import java.util.Iterator;

public class EnkelArrayListe {

    private String[] arr;
    private int maksStorrelse;
    private int storrelse = 0;

    public EnkelArrayListe(int maksStorrelse) {
        this.maksStorrelse = maksStorrelse;
        arr = new String[maksStorrelse];
    }

    public void leggTil(String s) {
        if (storrelse >= maksStorrelse) {
            throw new IllegalStateException();
        }
        arr[storrelse] = s;
    }

    public Iterator<String> iterator() {
        return new ListeIterator();
    }

    
    private class ListeIterator implements Iterator<String> {
        private int index = 0;
        
        public String next() {
            return arr[index++];
        }

        public  boolean hasNext() {
            return index < storrelse;
        }
    }
}