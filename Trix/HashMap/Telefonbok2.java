import java.util.ArrayList;
import java.util.HashMap;

public class Telefonbok2 {
    
    public static void main(String[] args) {
        Person p1 = new Person("Marius", "94141698", "Kringsjaa");
        Person p2 = new Person("Linn", "123456789", "Rosenhoff");
        Person p3 = new Person("Markus", "987654321", "Carl Berner");

    /*
        Person[] personArr = {p1, p2, p3, null, null, null, null, null, null, null};
        for (int i = 0; i < personArr.length; i++) {
            if (personArr[i] != null) {
                personArr[i].skrivInfo();
            }
        }
    */

    /*
        ArrayList <Person> personArrLi = new ArrayList<>();
        personArrLi.add(p1);
        personArrLi.add(p2);
        personArrLi.add(p3);

        for (Person person : personArrLi) {
            if (person != null) {
                person.skrivInfo();
            }
        }
    */

        HashMap <String, Person> personHM = new HashMap<>();

        personHM.put(p1.hentNavn(), p1);
        personHM.put(p2.hentNavn(), p2);
        personHM.put(p3.hentNavn(), p3);

        for (String navn : personHM.keySet()) {
            personHM.get(navn).skrivInfo();
        }
        System.out.println(finnNavn(personHM, "Erlend"));
    }

    public static boolean finnNavn(HashMap <String, Person> personHM, String navn) {
        return personHM.containsKey(navn);
    } 
}
