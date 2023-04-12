import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Oblig5Hele implements GlobalConstant {

    public static void main(String[] args) {
        
        Monitor2 monitorMedSykdom = new Monitor2();
        Monitor2 monitorUtenSykdom = new Monitor2();

        ArrayList<Thread> leseArr = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(args[0] + "/metadata.csv"));
            while (scanner.hasNext()) {
                String[] list = scanner.nextLine().split(",");
                if (list[1].equals("True")) { 
                    Thread traad = new Thread(new LeseTrad(monitorMedSykdom, new File(args[0] + "/" + list[0])));
                    leseArr.add(traad);
                    traad.start();
                } else {
                    Thread traad = new Thread(new LeseTrad(monitorUtenSykdom, new File(args[0] + "/" + list[0]))); 
                    leseArr.add(traad);
                    traad.start(); 
                }
            } 
            scanner.close();
        } catch (FileNotFoundException | NullPointerException e) {};
        
        for (Thread traad : leseArr) {
            try {
                traad.join();
            }
            catch (InterruptedException e) {}
        }

        System.out.println("=== ant HashMap med sykdom: " + monitorMedSykdom.subRegister.register.size() + "  ===  ant HashMap uten sykdom " + monitorUtenSykdom.subRegister.register.size());

        ArrayList<Thread> fletteArr = new ArrayList<>();
        for (int i = 0; i < MAX_ANT_FLETTETRADER; i++) {
            Thread traadM = new Thread(new FletteTrad(monitorMedSykdom));
            Thread traadU = new Thread(new FletteTrad(monitorUtenSykdom));
            fletteArr.add(traadM);
            fletteArr.add(traadM);
            traadM.start();
            traadU.start();
        }
        
        for (Thread traad : fletteArr) {
            try {
                traad.join();
            }
            catch (InterruptedException e) {} 
        }
        
        //System.out.println("= Subsekvens med hoyest antall med sykdom: " + monitorUtenSykdom.hentHoyest());
        //System.out.println("= Subsekvens med hoyest antall uten sykdom: " + monitorMedSykdom.hentHoyest());

        System.out.println(SubsekvensRegister.finnDominante(monitorMedSykdom.subRegister.register.get(0), monitorUtenSykdom.subRegister.register.get(0)));
    }
}