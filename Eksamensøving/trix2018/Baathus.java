class Baathus {
    private Baat[] baathus;

    public Baathus(int antallPlasser) {
        baathus = new Baat[antallPlasser];
    }

    public void settInn(Baat enBaat) {
        for (int i=0; i<baathus.length; i++) {
            if (baathus[i] == null) {
                baathus[i] = enBaat;
                return;
            }
        }
        System.out.println("Det er ikke plass til felre baater!");
    }

    public void skrivBaater() {
        for (int i = 0; i < baathus.length; i++) {
            if (baathus[i] != null){
                System.out.println(baathus[i].hentInfo());
            }
        }
    }
}