

public class Postmann implements Runnable{

    Postkontor postKontor;

    public Postmann(Postkontor postKontor) {
        this.postKontor = postKontor;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Post post = new Post("Abbey Road Vinylplate", "Hans Olav");
            postKontor.leverPost(post);
        }
    }
}
