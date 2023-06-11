

public class MestStoyANT {

    Maaling[] maalinger;
    
    public MestStoyANT(int ant) {
        maalinger = new Maaling[ant];
    }

    public void settInnAnt(Maaling m) {
        for (int i = 0; i < maalinger.length; i++) {
            if (maalinger[i] == null) {
                maalinger[i] = m;
                break;
            }
        }
    }

    public Maaling[] hentUtAnt() {
        int nyAnt = 0;
        for (Maaling m : maalinger) {
            if (m != null) {
                nyAnt++;
            }
        }
        Maaling[] nyMaalinger = new Maaling[nyAnt];
        for (int i = 0; i < nyMaalinger.length; i++) {
            maalinger[i] = nyMaalinger[i];
        }
        return nyMaalinger;
    }
}
