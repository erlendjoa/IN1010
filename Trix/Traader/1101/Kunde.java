public class Kunde implements Runnable{
    
    Postkontor postKontor;
    String navn;

    public Kunde(Postkontor postKontor, String navn) {
        this.postKontor = postKontor;
        this.navn = navn;
    }

    @Override
    public void run() {
        while(true) {
            Post post = postKontor.hentPost(navn);
            if (post != null) {
                System.out.println(post);
            }
        } 
    }
}
