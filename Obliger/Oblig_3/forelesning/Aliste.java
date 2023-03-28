package forelesning;

public class Aliste<K,V>{
    private Node start, slutt;  // start, slutt er null ved opprettelse.
    private int storrelse = 0;  // storrelse satt til 0;

    protected class Node {
        Node forrige, neste;    // forrige, neste er node eller null.
        K nokkel;
        V verdi;

        public Node(K n, V v) {
            nokkel = n;
            verdi = v;
        }
    }


    public int hentStr() {
        return storrelse;
    }

    public void settInn(K nokkel, V verdi) {
        Node nyNode = new Node(nokkel, verdi);
        storrelse++;
        if (slutt == null) {
            start = nyNode;
            slutt = nyNode;
            return;
        }
        slutt.neste = nyNode;   // nyNode settes som den siste i Aliste (neste for den forrige "slutt").
        nyNode.forrige = slutt; // nyNode.forrige settes som den forrige variabelen "slutt".
        slutt = nyNode;         // slutt variabel settes nå til den nye nyNode.
    }

    public V hent(K nokkel) {
        Node peker = start;
        while (peker != null && !peker.nokkel.equals(nokkel)) { // nokkel er ikke .equals til pekers (nodes) nokkel. 
            peker = peker.neste;                                // sjekker neste node.
        }
        return peker.verdi;
    }

    public void sett(K nokkel, V verdi) {
        Node peker = start;
        while (peker != null && !peker.nokkel.equals(nokkel)) {   
            peker = peker.neste;
        }
        if (peker != null) {
            peker.verdi = verdi;
        }
    }

    public V fjern(K nokkel) {
        if (start.nokkel.equals(nokkel)) {  // hvis noden er start;
            V verdi = start.verdi;
            start = start.neste;

            if (start != null) {
                start.forrige = null;
            } else {
                slutt = null;
            }
            storrelse--;
            return verdi;
        }

        Node peker = start;
        while (peker != null && !peker.nokkel.equals(nokkel)) {   
            peker = peker.neste;
        }

        if (peker == null) return null;

        V verdi = peker.verdi;
        storrelse--;
        if (peker == slutt) {   // hvis noden er slutt:
            slutt = slutt.forrige;
            slutt.neste = null;
            return verdi;
        }

        // hvis noden ikke er start eller slutt:
        peker.forrige.neste = peker.neste;
        peker.neste.forrige = peker.forrige;
        return verdi;

    }


    @Override
    public String toString() {
        String tekst = "";
        Node peker = start;
        while (peker != null) {
            tekst += "\nNokkel: " + peker.nokkel + "\nVerdi: " + peker.verdi;
            peker = peker.neste;
        }
        return tekst;
    }
}
