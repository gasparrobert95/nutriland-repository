package mvc.exceptions;

public class ExceptionMissingDetail extends Exception {
    public ExceptionMissingDetail() {
        super("One or more of the details are missing!");
    }
}
