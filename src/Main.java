import mvc.controllers.LoginController;
import mvc.views.LoginView;
import mvc.views.RegisterView;

public class Main {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);
    }
}