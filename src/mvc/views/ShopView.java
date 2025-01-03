package mvc.views;

import mvc.models.ProductModel;

import javax.swing.*;
import java.util.ArrayList;

public class ShopView {
    private JFrame frame;
    private JPanel panel;
    ArrayList<ProductModel> products;

    public ShopView() {
        products = new ArrayList<>();

        frame = new JFrame();
        frame.setTitle("NUTRILAND - SHOP");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("NUTRILAND");
        userLabel.setBounds(50, 20, 80, 25);
        panel.add(userLabel);

        frame.setVisible(true);
    }

    public void showProducts(int x, int y) {
        for (var product : products) {
            JLabel nameLabel = new JLabel(product.getName());
            nameLabel.setBounds(x, y, 80, 25);
            panel.add(nameLabel);

            JLabel priceLabel = new JLabel(String.valueOf(product.getPrice()));
            priceLabel.setBounds(x + 100, y, 80, 25);
            panel.add(priceLabel);
            y += 30;
        }
    }

    public void setProducts(ArrayList<ProductModel> products) {this.products = products;}

    public void closeWindow() {
        frame.setVisible(false);
    }
}
