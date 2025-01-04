package mvc.controllers;

import mvc.DatabaseConnection;
import mvc.models.ClientModel;
import mvc.models.ProductModel;
import mvc.views.ShopView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ShopController {
    private ShopView shopView;
    private ClientModel client;
    private DatabaseConnection databaseConnection;

    public ShopController(ShopView shopView, ClientModel client, DatabaseConnection databaseConnection) throws Exception {
        this.shopView = shopView;
        this.client = client;
        this.databaseConnection = databaseConnection;
        transferProducts();
    }

    public void transferProducts() throws Exception {
        //get products from database
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String query = "select * from \"Products\";";
        ResultSet result = statement.executeQuery(query);

        ArrayList<ProductModel> products = new ArrayList<>();
        while (result.next()) {
            int id = result.getInt(1);
            String name = result.getString(2);
            double price = result.getDouble(3);
            int quantity = result.getInt(4);
            String imageName = result.getString(5);
            products.add(new ProductModel(id, name, price, quantity, imageName));
        }
        shopView.setProducts(products);
        shopView.showProducts();
        connection.close();
    }

}
