package mvc.controllers;

import mvc.views.LoginView;
import mvc.views.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.loginView.addRegisterButtonListener(new RegisterListener());
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginView.setVisible(false);
            RegisterView registerView = new RegisterView();
            //RegisterController registerController = new RegisterController(RegisterView);
        }
    }
}
