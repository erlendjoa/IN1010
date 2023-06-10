import java.util.Iterator;

//3A:
public class Tog implements Iterable<Skinnegaaende> {
    
    public Skinnegaaende hode = null; // start av lenkeliste
    public Skinnegaaende hale = null; // slutt av lenkeliste
    
    public Tog() {
    }
    
    //3F:
    private class TogIterator implements Iterator<Skinnegaaende> {
        Skinnegaaende peker = hode;
        
        public boolean hasNext() {
            return peker != null;
        }
        
        public Skinnegaaende next() {
            Skinnegaaende ut = peker;
            peker = peker.neste;
            return ut;
        }
    }
    
    //3B:
    public void leggTil(Skinnegaaende sG) {
        if (hode == null) {
            hode = sG;
            hale = sG;
        } else if (hode == hale) {
            hode.neste = sG;
            sG.forrige = hode;
            hale = sG;
        } else {
            hale.neste = sG;
            sG.forrige = hale;
            hale = sG;
        }
    }
    
    //3C:
    public Skinnegaaende taUt(Skinnegaaende sG) {
        // finner riktig objekt i lenkelisten:
        Skinnegaaende tempSG = hode;
        while (tempSG != sG) {
            tempSG = tempSG.neste;
        }
        // om det kun er 1 element i lenkelisten:
        if (hode == hale) {
            hode = null;
            hale = null;
        }
        // om det kun er 2 elementer i lenkelisten:
        else if (hode.neste == hale) {
            if (tempSG == hode) {
                hale.forrige = null;
                hode = hale;
            } else {
                hode.neste = null;
                hale = hode;
            }
        }
        // om det er 3+ men vi vil ta ut hode:
        else if (tempSG == hode) {
            hode = hode.neste;
            hode.forrige = null;
        }
        // om det er 3+ men vi vil ta ut hale:
        else if (tempSG == hale) {
            hale = hale.forrige;
        }
        
        else {
            tempSG.neste.forrige = tempSG.forrige;
            tempSG.forrige.neste = tempSG.neste;
        }
        
        // til slutt returnere valgt objekt:
        return tempSG;
    }
    
    //3D:
    // Jeg antar at id'en finnes i et av objektene i lenkelisten:
    public Skinnegaaende finnOgTaUt(String parID) {
        Skinnegaaende tempSG = hode;
        while (!tempSG.id.equals(parID)) {
            tempSG = tempSG.neste;
        }
        return taUt(tempSG);
    }
    
    //3E:
    public void leggTilForan(Skinnegaaende eksistSG, Skinnegaaende nySG) {
        Skinnegaaende tempSG = hode;
        while (tempSG != eksistSG) {
            tempSG = tempSG.neste;
        }
        // om det er 1 element i lenkelisten:
        if (hode == hale) {
            nySG.neste = hode;
            hode.forrige = nySG;
            hode = nySG;
        }
        // om det er 2 elementer i lenkelisten:
        else if (hode.neste == hale) {
            if (tempSG == hode) {
                tempSG.forrige = nySG;
                nySG.neste = tempSG;
                hode = nySG;
            } else {
                hode.neste = nySG;
                hale.forrige = nySG;
                nySG.forrige = hode;
                nySG.neste = hale;
            }
        }
        // om det er 3+ men tempSG er hode:
        else if (tempSG == hode) {
            hode.forrige = nySG;
            nySG.neste = hode;
            hode = nySG;
        }
        
        else {
            tempSG.forrige.neste = nySG;
            nySG.forrige = tempSG.forrige;
            nySG.neste = tempSG;
            tempSG.forrige = nySG;
        }
    }
    
    @Override
    public Iterator<Skinnegaaende> iterator() {
        return new TogIterator();
    }
    
    //3G:
    public Passasjervogn[] hentPassasjervogner() {
        int teller = 0;
        
        // gå gjennom alle skinnegaaende i lenkelisten:
        Skinnegaaende tempSG = hode;
        while (true) {
            if (tempSG instanceof Passasjervogn) {
                teller++;
            }
            // om vi er på siste skinnegaaende:
            if (tempSG == hale) {
                break;
            }
            tempSG = tempSG.neste;
        }
        
        Passasjervogn[] passArr = new Passasjervogn[teller];
        
        // gå gjennom igjen, men legg til i array:
        teller = 0;
        tempSG = hode;
        while (true) {
            if (tempSG instanceof Passasjervogn) {
                passArr[teller] = (Passasjervogn) tempSG;
                teller++;
            }
            // om vi er på siste skinnegaaende:
            if (tempSG == hale) {
                break;
            }
            tempSG = tempSG.neste;
        }
        
        return passArr;
    }
    
    //4B:
    public void sjekkSporvidde() throws FeilSporvidde {
        Skinnegaaende tempSG = hode;
        int valgtSporvidde = hode.hentSporvidde();
        
        while (true) {
            if (tempSG.hentSporvidde() != valgtSporvidde) {
                throw new FeilSporvidde();
            }
            if (tempSG == hale) {
                break;
            }
            tempSG = tempSG.neste;
        }
    }
    
    //4C:
    public void leggTilSikker(Skinnegaaende nySG) throws FeilSporvidde {
        // om lenkelisten er tom har vi ikke et utgangspunkt for sjekkSporvidde():
        if (hode == null) {
            leggTil(nySG);
        } 
        // om 1+ i lenkeliste, legger vi til vanlig og deretter sjekker alle elementene med sjekkSporvidde():
        else {
            leggTil(nySG);
            sjekkSporvidde();
        }
    }
    
    //4D:
    public void sjekkRekursivt() throws FeilSporvidde {
        sjekkSporviddeRekursivt(hode);
    }
    public void sjekkSporviddeRekursivt(Skinnegaaende sG) throws FeilSporvidde {
        if (sG.hentSporvidde() != hode.hentSporvidde()) {
            throw new FeilSporvidde();
        } else if (sG != hale) {
            sjekkSporviddeRekursivt(sG.neste);    
        }
        // sG.neste vil ikke være null, fordi vi sjekke om sG er hale.
        // else if'en stopper metoden å fortsette når det er funnet en feil.
    }
}
