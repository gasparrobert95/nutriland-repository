package mvc.exceptions;

public class ExceptionInvalidAccount extends Exception {
    public ExceptionInvalidAccount() {
        super("The account was not found!");
    }
}
