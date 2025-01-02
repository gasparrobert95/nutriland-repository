package mvc.exceptions;

public class ExceptionInvalidAccount extends RuntimeException {
    public ExceptionInvalidAccount() {
        super("The account was not found!");
    }
}
