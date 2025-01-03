package mvc.controllers;

import mvc.DatabaseConnection;
import mvc.exceptions.ExceptionDifferentPasswords;
import mvc.exceptions.ExceptionExistingAccount;
import mvc.exceptions.ExceptionMissingDetail;
import mvc.models.ClientModel;
import mvc.models.UserModel;
import mvc.views.RegisterView;
import mvc.views.ShopView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterController {
    private RegisterView registerView;
    private DatabaseConnection databaseConnection;

    public RegisterController(RegisterView registerView, DatabaseConnection databaseConnection) {
        this.registerView = registerView;
        this.registerView.addRegisterButtonListener(new RegisterListener());
        this.databaseConnection = databaseConnection;
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                String query = String.format("select * from \"Users\" where username = '%s';", registerView.getUsername());
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                if(result.next()) {
                    registerView.clearData();
                    throw new ExceptionExistingAccount();
                }
                query = String.format("insert into \"Users\" (name, username, password, user_type) values ('%s','%s','%s',%d);",
                        registerView.getName(), registerView.getUsername(), registerView.getPassword(), registerView.getUserType());
                registerView.checkValidAccount();
                registerView.checkPasswords();
                statement.execute(query);
                connection.close();
                registerView.showSuccessfulMessage("The account was successfully created!");
                UserModel user = new UserModel(registerView.getName(), registerView.getUsername(), registerView.getPassword(), registerView.getUserType());
                //enter shop
                if (registerView.getUserType() == 1) {
                    ShopView shopView = new ShopView();
                    ClientModel client = new ClientModel(user);
                    ShopController ShopController = new ShopController(shopView, client, databaseConnection);
                } else {
                    /*AffiliateView affiliateView = new AffiliateView();
                    AffiliateModel affiliate = new AffiliateModel(user);
                    AffiliateController affiliateController = new AffiliateController(affiliateView, affiliate, databaseConnection);*/
                }
                registerView.closeWindow();
            } catch (ExceptionMissingDetail exception) {
                registerView.showErrorMessage(exception.getMessage());
                exception.printStackTrace();
            } catch (ExceptionExistingAccount exception) {
                registerView.showErrorMessage(exception.getMessage());
                exception.printStackTrace();
            } catch (ExceptionDifferentPasswords exception) {
                registerView.showErrorMessage(exception.getMessage());
                exception.printStackTrace();
            } catch (Exception exception) {
                registerView.showErrorMessage("Something went wrong!");
                exception.printStackTrace();
            }
        }
    }
}
