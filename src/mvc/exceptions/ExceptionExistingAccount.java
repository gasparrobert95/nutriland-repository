package mvc.exceptions;

public class ExceptionExistingAccount extends Exception {
    public ExceptionExistingAccount() {
        super("The account already exists!");
  }
}
