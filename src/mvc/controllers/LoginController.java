package mvc.controllers;

import mvc.DatabaseConnection;
import mvc.views.LoginView;
import mvc.views.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginView loginView;
    private DatabaseConnection databaseConnection;

    public LoginController(LoginView loginView, DatabaseConnection databaseConnection) {
        this.loginView = loginView;
        this.loginView.addRegisterButtonListener(new RegisterListener());
        this.databaseConnection = databaseConnection;
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RegisterView registerView = new RegisterView();
            RegisterController registerController = new RegisterController(registerView, databaseConnection);
        }
    }
}
