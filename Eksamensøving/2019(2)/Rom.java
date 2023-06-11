import java.util.ArrayList;

public class Rom {

    public int gulvplass;
    public int veggplass;
    public ArrayList<Inventar> alleInventar = new ArrayList<>();

    public Rom(int kmGulvplass, int mVeggplass) {
        gulvplass = kmGulvplass;
        veggplass = mVeggplass;
    }

    public void leggTil(Inventar inv) throws IkkeNokBredde, IkkeNokAreal {
        try {

        }
    }
}
