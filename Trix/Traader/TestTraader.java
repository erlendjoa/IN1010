public class TestTraader {
    
    public static void main(String[] args) {

        oppgaveC();
    }

    public static void oppgaveB() {

        int start = 100;
        int max = 300;

        NteTall nteTall = new NteTall(start, max);
        Thread traad1 = new Thread(nteTall);

        traad1.start();
    }

    public static void oppgaveC() {
        
        int start = 0;
        int max = 300;

        NteTall nteTall = new NteTall(start, max);
        for (int i = 0; i < 10; i++) {
            Thread traad = new Thread(nteTall);
            traad.start();
        }
    }

    public static void oppgaveD() {
        
    }
}
    