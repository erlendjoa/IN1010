

public class Person implements Comparable<Person> {

    private String navn;
    public int fodselsaar;
    private Person mor;
    private Person far;

    public Person(int fodselsaar, String navn, Person mor, Person far) {
        this.navn = navn;
        this.fodselsaar = fodselsaar;
        this.mor = mor;
        this.far = far;
    }
    public Person hentMor() {
        return this.mor;
    }
    public Person hentFar() {
        return this.far;
    }

    @Override
    public int compareTo(Person person) {
        if (person.fodselsaar > fodselsaar) return 1;
        else if (person.fodselsaar < fodselsaar) return -1;
        else return 0;
    }

    public String toString() {
        return "";
    }


    public Person finnEldsteKjenteForfader() {
        Person farSideEldst = null;
        Person morSideEldst = null;

        if (hentFar() == null && hentMor() == null) return this;

        if (hentFar() != null) {
            farSideEldst = hentFar().finnEldsteKjenteForfader(); 
        }
        if (hentMor() != null) {
            morSideEldst = hentMor().finnEldsteKjenteForfader();
        }
        
        if (hentFar() == null) return hentMor();
        if (hentMor() == null) return hentFar();

        if (farSideEldst.compareTo(morSideEldst) == 1) {
            return farSideEldst;
        } else {
            return morSideEldst;
        }
    }

}