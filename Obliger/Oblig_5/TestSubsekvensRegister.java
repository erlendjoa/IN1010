import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class TestSubsekvensRegister {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        SubsekvensRegister subRegister = new SubsekvensRegister();
        
        File fil = new File("testsub.csv");

        HashMap <String,Subsekvens> nyHashMap = SubsekvensRegister.lesFil(fil);
        subRegister.settInn(nyHashMap);

        for (HashMap <String,Subsekvens> map : subRegister.register) {
            for (int i = 0; i < map.keySet().size(); i++) {
                System.out.println(map.get(i));
            }
        }
    }
}
