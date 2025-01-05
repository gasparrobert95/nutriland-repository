package mvc.controllers;

import mvc.DatabaseConnection;
import mvc.exceptions.ExceptionInexistentProduct;
import mvc.views.AdminView;
import mvc.views.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;

public class AdminController {
    private AdminView adminView;
    private DatabaseConnection databaseConnection;

    public AdminController(AdminView adminView, DatabaseConnection databaseConnection) {
        this.adminView = adminView;
        this.databaseConnection = databaseConnection;
        this.adminView.addExitButtonListener(new ExitListener());
        this.adminView.addAddProductButtonListener(new AddListener());
        this.adminView.addUpdateButtonListener(new UpdateListener());
    }

    class UpdateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int productId = adminView.getUpdateId();
                int quantity = adminView.getUpdateQuantity();
                Connection connection = databaseConnection.getConnection();
                Statement statement = connection.createStatement();
                String query = String.format("select * from \"Products\" where id = %d;", productId);
                ResultSet resultSet = statement.executeQuery(query);
                if (!resultSet.next())
                    throw new ExceptionInexistentProduct();
                query = String.format("update \"Products\" set quantity = %d where id = %d;", quantity, productId);
                statement.executeUpdate(query);
                adminView.showSuccessfulMessage("Update successful");
                connection.close();
            } catch (ExceptionInexistentProduct exception) {
                adminView.showErrorMessage(exception.getMessage());
                exception.printStackTrace();
            } catch (Exception exception) {
                adminView.showErrorMessage("Something went wrong");
                exception.printStackTrace();
            }
        }
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String name = adminView.getAddProductName();
                double price = adminView.getAddPrice();
                int quantity = adminView.getAddQuantity();
                String imageName = adminView.getAddImage();
                Connection connection = databaseConnection.getConnection();
                Statement statement = connection.createStatement();
                    String query = String.format(Locale.US, "insert into \"Products\" (name, price, quantity, image_name) " +
                        "values ('%s', %.2f, %d, '%s');", name, price, quantity, imageName);
                System.out.println(query);
                statement.executeUpdate(query);
                adminView.showSuccessfulMessage("Product added successfully");
                connection.close();
            } catch (Exception exception) {
                adminView.showErrorMessage("Something went wrong");
                exception.printStackTrace();
            }
        }
    }

    class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LoginView loginView = new LoginView();
            LoginController loginController = new LoginController(loginView, databaseConnection);
            adminView.closeWindow();
        }
    }
}

