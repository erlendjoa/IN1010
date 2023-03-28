public class Integrasjonstest {
    
    public static void main(String[] args) {
        
        Lege davidBowie = new Lege("David Bowie"); 
        Spesialist frankZappa = new Spesialist("Frank Zappa", "ABC420");

        Narkotika weed = new Narkotika("weed", 500, 100, 1, 0);
        Vanedannede nesespray = new Vanedannede("nesespray", 1000, 50, 2, 0);
        Vanlig sukkerpille = new Vanlig("sukkerpille", 1500, 0, 3);

        Blaa blaaResept = new Blaa(weed, frankZappa, 01, 5);
        MiiResept militaerResept = new MiiResept(nesespray, davidBowie, 02);
        Presept pResept = new Presept(sukkerpille, davidBowie, 03, 5);


        System.out.println(davidBowie);
        System.out.println(frankZappa);

        System.out.println(blaaResept);
        System.out.println(militaerResept);
        System.out.println(pResept);
    }
}