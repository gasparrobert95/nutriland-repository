package mvc.controllers;

import mvc.DatabaseConnection;
import mvc.models.ClientModel;
import mvc.models.ProductModel;
import mvc.models.UserModel;
import mvc.views.CartView;
import mvc.views.ShopView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CartController {
    private CartView cartView;
    private ClientModel client;
    private DatabaseConnection databaseConnection;
    private ArrayList<Integer> cart;

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
                client.setCart(new ArrayList<>());
                ShopView shopView = new ShopView();
                ShopController ShopController = new ShopController(shopView, client, databaseConnection);
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

        for (var productId : cart) {
            String query = "select * from \"Products\" where id = " + productId + ";";
            ResultSet result = statement.executeQuery(query);
            result.next();
            int id = result.getInt(1);
            String name = result.getString(2);
            double price = result.getDouble(3);
            int quantity = result.getInt(4);
            String imageName = result.getString(5);
            products.add(new ProductModel(id, name, price, quantity, imageName));
        }
        cartView.setProducts(products);
        connection.close();
    }
}
