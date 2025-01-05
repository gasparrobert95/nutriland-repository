package mvc.exceptions;

public class ExceptionEmptyCart extends Exception {
    public ExceptionEmptyCart() {
        super("Empty Cart!");
    }
}
