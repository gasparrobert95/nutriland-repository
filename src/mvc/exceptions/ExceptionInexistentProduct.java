package mvc.exceptions;

public class ExceptionInexistentProduct extends Exception {
    public ExceptionInexistentProduct() {
        super("Inexistent product");
    }
}
