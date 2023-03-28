public class TestResepter {

    public static void main(String[] args) {

        Narkotika mid1 = new Narkotika("speed", 1000, 0, 0, 0);
        Vanedannede mid2 = new Vanedannede("vanedannede", 1000, 0, 1, 0);
        Vanlig mid3 = new Vanlig("vanlig", 1000, 0, 2);
        Legemiddel mid4 = new Narkotika("legemiddel", 1000, 0, 3, 0);

        Lege yoshi = new Lege("yoshi");
        Lege tone = new Lege("tone");

        MiiResept militaerResept1 = new MiiResept(mid1, yoshi, 1);
        MiiResept militaerResept2 = new MiiResept(mid2, tone, 2);
        Blaa blaaResept1 = new Blaa(mid3, yoshi, 3, 5);
        Blaa blaaResept2 = new Blaa(mid4, tone, 4, 5);

        System.out.println(militaerResept1.farge());
        System.out.println(militaerResept1.prisAaBetale());

        System.out.println(blaaResept1.farge());
        System.out.println(blaaResept1.prisAaBetale());

        System.out.println(militaerResept1);
        System.out.println(militaerResept2);
        System.out.println(blaaResept1);
        System.out.println(blaaResept2);
    }
}

