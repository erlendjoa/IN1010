public class Person {

    private int alder;
    private String navn;

    public Person(String navn, int alder){
        this.navn = navn;
        this.alder = alder;
    }

    public int hentAlder(){
        return alder;
    }
    public void bursdag(){
        alder++;
    }
}