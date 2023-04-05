import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class TestSubsekvensRegister {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        SubsekvensRegister register = new SubsekvensRegister();
        
        File fil = new File("C:/Users/erlen/IN1010/Obliger/Oblig_5/testsub.csv");

        HashMap <String,Subsekvens> nyHashMap = SubsekvensRegister.lesFil(fil);
        register.settInn(nyHashMap);
    }

}
