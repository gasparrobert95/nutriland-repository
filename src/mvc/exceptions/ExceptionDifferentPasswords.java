package mvc.exceptions;

public class ExceptionDifferentPasswords extends RuntimeException {
    public ExceptionDifferentPasswords() {
        super("Passwords do not match!");
    }
}
