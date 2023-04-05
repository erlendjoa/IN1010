import java.io.File;

public class Oblig5Del1 {
    String path;

    public Oblig5Del1(String path) {
        this.path = path; }

    public void kjor() {
        File[] testDataFiler = new File[9];
        File[] testDataLikeFiler = new File[9];
        for (int i = 0; i < 9; i++) {
            testDataFiler[i] = new File(path + "/TestData/fil" + i+1); 
            testDataLikeFiler[i] = new File(path + "/TestDataLike/fil" + i+1);
        }
        SubsekvensRegister subRegister = new SubsekvensRegister();

    }
}
