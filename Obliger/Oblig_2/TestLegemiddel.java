public class TestLegemiddel {
    
    public static void main(String[] args) {

        Narkotika mid1 = new Narkotika("speed", 1000, 0, 0, 0);
        Vanedannede mid2 = new Vanedannede("vanedannede", 1000, 0, 1, 0);
        Vanlig mid3 = new Vanlig("vanlig", 1000, 0, 2);
        Legemiddel mid4 = new Narkotika("legemiddel", 1000, 0, 3, 0);
        
        assert mid1.pris == 1000;
        assert mid2.styrke == 0;
        assert mid3.navn == "vanlig";


        assert mid1.id == 0;
        System.out.println(mid1.id + ": " + mid1.navn);

        assert mid2.id == 1;
        System.out.println(mid2.id + ": " + mid2.navn);

        assert mid3.id == 2;
        System.out.println(mid3.id + ": " + mid3.navn);

        assert mid4.id == 3;
        System.out.println(mid4.id + ": " + mid4.navn);

        System.out.println();
        System.out.println(mid1);
        System.out.println(mid2);
        System.out.println(mid3);
        System.out.println(mid4);

    }
}
