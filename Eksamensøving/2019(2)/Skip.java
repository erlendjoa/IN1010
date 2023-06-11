import java.util.HashMap;

public class Skip {
    Inventar hode;
    HashMap<Integer, Rom> alleRom = new HashMap<>();

    public void settInn(Inventar inventar, int romnr) {
        // Sett inn i lenkeliste til Skip fra hode:
        if (hode == null) {
            hode = inventar;
        } else {
            Inventar tempInventar = hode;
            while (tempInventar.neste != null) {
                tempInventar = tempInventar.neste;
            } 
            tempInventar.neste = inventar;
        }

        // Legg inn i nytt eller eksisterende rom:
        Integer intGer = romnr;
        if (!alleRom.containsKey(intGer)) {
            Rom nyttRom = new Rom(200, 60);
            nyttRom.alleInventar.add(inventar);
            alleRom.put(intGer, nyttRom);
        } else {
            alleRom.get(intGer).alleInventar.add(inventar);
        }
    }

    public void settInn2(Inventar inv, int romnr) {
        Integer intGer = romnr;
        alleRom.get(intGer).leggTil(inv);
    }
}
