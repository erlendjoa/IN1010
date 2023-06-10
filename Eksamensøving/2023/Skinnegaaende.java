public abstract class Skinnegaaende {
    
    public String id;
    public int sporvidde;
    public Skinnegaaende neste = null; // referanse til neste i lenkelisten
    public Skinnegaaende forrige = null; // referanse til forrige i lenkelisten
    
    public Skinnegaaende(String id, int sporvidde) {
        this.id = id;
        this.sporvidde = sporvidde;
    }
    
    public String hentId() {
        return id;
    }
    
    public int hentSporvidde() {
        return sporvidde;
    }
}