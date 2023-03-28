import java.util.*;
import java.util.concurrent.*;

public class NteTall extends Thread{

    public static void main(String[] args) {

        NteTall ntetall = new NteTall();
        ntetall.start();
    }
    
    @Override
    public void run() {
        for (int i = 5; i <= 1000; i+=5) {
            System.out.println(i);
        }
    }
}