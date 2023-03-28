public abstract class Form {
    protected String type;
    protected int omkrets;

    public abstract void skrivUtOmkrets();

    public void skrivUtType() {
        System.out.println(type);
    }
}
