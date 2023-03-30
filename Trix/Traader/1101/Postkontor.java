import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Postkontor {
    
    private final ReentrantLock laas = new ReentrantLock();
    private final Condition ikkeFull = laas.newCondition();
    private final Condition ikkeTom = laas.newCondition();
    
    private Post[] postArr = new Post[10];

    public int storrelse() {
        int storrelse = 0;
        for (int i = 0; i < postArr.length; i++) {
            if (postArr[i] != null) {
                storrelse++;
            } 
        }
        return storrelse;
    }

    public void leverPost(Post p) {
        laas.lock();
        try {
            if (storrelse() == 10) {
                ikkeFull.await();
            }
            for (Post post : postArr) {
                if (post == null) {
                    post = p;
                    ikkeTom.signal();
                }
            }
        }
        catch (InterruptedException e) {
        }
        finally { laas.unlock(); }
        
    }

    public Post hentPost(String mottaker) {
        laas.lock();
        try {
            for (Post post : postArr) {
                if (post != null && post.mottaker == mottaker) {
                    return post;
                }
            }
            return null;
        }
        finally { laas.unlock(); }
        
    }
}
