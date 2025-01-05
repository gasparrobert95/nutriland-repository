package mvc.controllers;

import mvc.DatabaseConnection;
import mvc.models.ClientModel;
import mvc.models.CartProductModel;
import mvc.models.ProductModel;
import mvc.views.CartView;
import mvc.views.ShopView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

public class CartController {
    private CartView cartView;
    private ClientModel client;
    private DatabaseConnection databaseConnection;
    private ArrayList<CartProductModel> cart;

    public CartController (CartView cartView, ClientModel client, DatabaseConnection databaseConnection) throws Exception {
        this.cartView = cartView;
        this.client = client;
        this.databaseConnection = databaseConnection;
        this.cart = client.getCart();
        this.cartView.addShopButtonListener(new ShopButtonListener());
        this.cartView.addOrderButtonListener(new OrderButtonListener());
        transferInCartProducts();
        this.cartView.showProducts();
    }

    class ShopButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ShopView shopView = new ShopView();
                ShopController ShopController = new ShopController(shopView, client, databaseConnection);
                cartView.closeWindow();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    class OrderButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                cartView.showSuccessfulMessage("Thank you for your order!");
                Connection connection = databaseConnection.getConnection();
                Statement statement = connection.createStatement();
                double totalPrice = 0;
                for (var product : cart) {
                    String query = String.format("select price from \"Products\" where id = %d", product.getId());
                    ResultSet resultSet = statement.executeQuery(query);
                    resultSet.next();
                    totalPrice += resultSet.getDouble("price") * product.getQuantity();
                    query = String.format("update \"Products\" set quantity = quantity - %d where id = %s;", product.getQuantity(), product.getId());
                    statement.executeUpdate(query);
                }
                String query = String.format(Locale.US, "insert into \"Orders\" (username, order_value) values ('%s',%.2f);", client.getUser().getUsername(), totalPrice);
                statement.executeUpdate(query);
                client.setCart(new ArrayList<>());
                ShopView shopView = new ShopView();
                ShopController ShopController = new ShopController(shopView, client, databaseConnection);
                cartView.closeWindow();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void transferInCartProducts() throws Exception {
        //get products from database
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ArrayList<ProductModel> products = new ArrayList<>();

        for (var product : cart) {
            String query = "select * from \"Products\" where id = " + product.getId() + ";";
            ResultSet result = statement.executeQuery(query);
            result.next();
            int id = result.getInt(1);
            String name = result.getString(2);
            double price = result.getDouble(3);
            int quantity = product.getQuantity();
            String imageName = result.getString(5);
            products.add(new ProductModel(id, name, price * quantity, quantity, imageName));
        }
        cartView.setProducts(products);
        connection.close();
    }
}
