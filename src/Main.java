import mvc.DatabaseConnection;
import mvc.controllers.LoginController;
import mvc.views.LoginView;

public class Main {
    public static void main(String[] args)  {
        LoginView loginView = new LoginView();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        LoginController loginController = new LoginController(loginView, databaseConnection);
    }
}