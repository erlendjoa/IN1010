class TestBokhylle {

    public static void main(String[] args) {

        Bokhylle bokhylle = new Bokhylle(3);
        System.out.println("Setter inn boeker:");

        String[] titler = {"De doedes tjern", "Doppler", "Doppler", "Misery", "Gone with the Wind"};

        for (int i = 0; i < titler.length; i++) {
            try {
                bokhylle.settInn(new Bok(titler[i]));
            } catch (DuplikatException e) {
                System.out.println(e.getMessage());
            } catch (IkkeMerPlassException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nSkriver ut boeker:");
        bokhylle.skrivBoeker();
    }
}