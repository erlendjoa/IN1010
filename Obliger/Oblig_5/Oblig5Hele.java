import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Oblig5Hele implements GlobalConstant {

    public static void main(String[] args) {
        
        Monitor2 monitorMedSykdom = new Monitor2();
        Monitor2 monitorUtenSykdom = new Monitor2();

        File[] testData = new File[MAX_ANT_FILER];
        Thread[] traader = new Thread[MAX_ANT_FILER];

        ArrayList<Thread> listArr = new ArrayList<>();

        try {
            File fil = new File(args[0]);
            Scanner scanner = new Scanner(fil + "/metadata.csv");
            while (scanner.hasNext()) {
                String[] list = scanner.nextLine().split(",");

                if (list[1].equals("True")) {
                    File nyFil = new File(list[0]);
                    Thread traad = new Thread(new LeseTrad(monitorMedSykdom, nyFil));
                    listArr.add(traad);
                    traad.start();
                } else {
                    File nyFil = new File(list[0]);
                    Thread traad = new Thread(new LeseTrad(monitorUtenSykdom, nyFil)); 
                    listArr.add(traad);
                    traad.start(); 
                }
            } 
        }
        catch (FileNotFoundException e) {
            System.out.println("Fant ikke fil.");
        }
        
        for (Thread traad : listArr) {
            traad.join();
        }

        Thread[] fletteTraaderLike = new Thread[]
        
        
        // INITIERING (2) AV ALLE FLETTETRÅDER:
        for (int i = 0; i < MAX_ANT_FLETTETRADER; i++) {;
            fletteTraaderLike[i] = new Thread(new FletteTrad(monitorUtenSykdom));
            fletteTraader[i] = new Thread(new FletteTrad(monitorMedSykdom));
            fletteTraaderLike[i].start(); 
            fletteTraader[i].start(); }
        
        // VENT PÅ FULLFØRING...
        for (int i = 0; i < MAX_ANT_FLETTETRADER; i++) {
            try {
                fletteTraaderLike[i].join(); 
                fletteTraader[i].join(); }
            catch (InterruptedException e) {} }
        
        System.out.println("= Subsekvens med hoyest antall i TestDataLike: " + monitorUtenSykdom.hentHoyest());
        System.out.println("= Subsekvens med hoyest antall i TestDataLike: " + monitorMedSykdom.hentHoyest());
    }
}