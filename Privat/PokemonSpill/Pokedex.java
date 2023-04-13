import java.util.Iterator;

public class Pokedex {

    int totalMax;
    int currentMax = 0;
    int[] dex;
    

    public Pokedex(int totalMax) {
        this.totalMax = totalMax;
        dex = new int[totalMax];
    }

    private class DexIterable implements Iterable {

        public Pokemon iterator() {

        }
    }
}