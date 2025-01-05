import mvc.DatabaseConnection;
import mvc.controllers.LoginController;
import mvc.controllers.ShopController;
import mvc.models.ClientModel;
import mvc.models.UserModel;
import mvc.views.LoginView;
import mvc.views.ShopView;

public class Main {
    public static void main(String[] args) throws Exception {
        //LoginView loginView = new LoginView();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        //LoginController loginController = new LoginController(loginView, databaseConnection);

        ShopView shopView = new ShopView();
        UserModel user = new UserModel("a", "a", "a", 1);
        ClientModel client = new ClientModel(user);
        ShopController ShopController = new ShopController(shopView, client, databaseConnection);
    }
}