package mvc.controllers;

import mvc.DatabaseConnection;
import mvc.exceptions.ExceptionInvalidAccount;
import mvc.exceptions.ExceptionMissingDetail;
import mvc.models.UserModel;
import mvc.views.LoginView;
import mvc.views.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {
    private LoginView loginView;
    private DatabaseConnection databaseConnection;

    public LoginController(LoginView loginView, DatabaseConnection databaseConnection) {
        this.loginView = loginView;
        this.loginView.addRegisterButtonListener(new RegisterListener());
        this.loginView.addLoginButtonListener(new LoginListener());
        this.databaseConnection = databaseConnection;
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                Statement statement = connection.createStatement();
                String query = String.format("select * from \"Users\" where username = '%s' and password = '%s';", loginView.getUsername(), loginView.getPassword());
                loginView.checkValidAccount();
                ResultSet result = statement.executeQuery(query);
                if (!result.next()) {
                    loginView.clearData();
                    throw new ExceptionInvalidAccount();
                }
                int id = result.getInt(1);
                String name = result.getString(2);
                String username = result.getString(3);
                String password = result.getString(4);
                int userType = result.getInt(5);
                UserModel user = new UserModel(id, name, username, password, userType);
                //enter shop
                loginView.closeWindow();
            } catch (ExceptionMissingDetail exception) {
                loginView.showErrorMessage(exception.getMessage());
                exception.printStackTrace();
            } catch (ExceptionInvalidAccount exception) {
                loginView.showErrorMessage(exception.getMessage());
                exception.printStackTrace();
            } catch (Exception exception) {
                loginView.showErrorMessage("Something went wrong!");
                exception.printStackTrace();
            }
        }
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RegisterView registerView = new RegisterView();
            RegisterController registerController = new RegisterController(registerView, databaseConnection);
            loginView.closeWindow();
        }
    }
}
