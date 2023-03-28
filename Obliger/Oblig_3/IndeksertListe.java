public class IndeksertListe<E> extends Lenkeliste<E>{
    

    public void leggTil(int pos, E x) {
        if (pos < 0 || pos > stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        }

        Node nyNode = new Node(x);

        if (start == null) {
            start = nyNode;
            slutt = nyNode;
            return;

        } else if (pos == 0) {
            nyNode.neste = start;
            start.forrige = nyNode;
            start = nyNode;
            return;

        } else if (pos == stoerrelse()) {
            super.leggTil(x);
            return;
        }

        Node peker = start;
        for (int i = 0; i < pos-1; i++) {
            peker = peker.neste;
        }
        nyNode.neste = peker.neste;
        nyNode.forrige = peker;

        peker.neste.forrige = nyNode;
        peker.neste = nyNode;

        return;
    }

    public void sett(int pos, E x) {
        if (pos < 0 || pos >= stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        }

        Node nyNode = new Node(x);

        if (pos == 0 && stoerrelse() == 1) {
            start = nyNode;
            slutt = nyNode;
            return;
        }

        Node peker = start;
        for (int i = 0; i < pos; i++) {
            peker = peker.neste;
        }
        peker.element = nyNode.element;
    }


    public E hent(int pos) {
        if (pos < 0 || pos >= stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        }

        Node peker = start;

        if (pos == 0) {
            return peker.element;
        }

        for (int i = 0; i < stoerrelse()-1; i++) {
            peker = peker.neste;
        }
        return peker.element;
    }


    public E fjern(int pos) {
        if (pos < 0 || pos >= stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        }

        if (pos == stoerrelse()-1) {
            E valgtE = slutt.element;
            slutt.forrige.neste = null;
            slutt.forrige = slutt;
            return valgtE;
        }

        Node peker = start;
        
        while(peker.element != hent(pos)) {
            peker = peker.neste;
        }
        peker.forrige.neste = peker.neste;
        peker.neste.forrige = peker.forrige;
        return peker.element;
    }
}