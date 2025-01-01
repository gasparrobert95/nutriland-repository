package mvc.controllers;

import mvc.DatabaseConnection;
import mvc.models.UserModel;
import mvc.views.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegisterController {
    private RegisterView registerView;
    private DatabaseConnection databaseConnection;
    private List<UserModel> userModels;

    public RegisterController(RegisterView registerView, DatabaseConnection databaseConnection) {
        this.registerView = registerView;
        this.registerView.addRegisterButtonListener(new RegisterListener());
        this.databaseConnection = databaseConnection;
        this.userModels = new ArrayList<>();
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                userModels.add(new UserModel(registerView.getUserType(), registerView.getName(), registerView.getUsername(), registerView.getPassword()));
                String query = String.format("insert into \"Users\" (name, username, password, user_type) values ('%s','%s','%s',%d);",
                        registerView.getName(), registerView.getUsername(), registerView.getPassword(), registerView.getUserType());
                Statement statement = connection.createStatement();
                statement.execute(query);
                connection.close();
                registerView.showSuccessfulMessage("The account was successfully created!");
                registerView.clearData();
            } catch (Exception ex) {
                registerView.showErrorMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }
}
