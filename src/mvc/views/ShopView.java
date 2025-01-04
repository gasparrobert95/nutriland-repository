package mvc.views;

import mvc.models.ProductModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShopView extends JFrame {
    private JFrame frame;
    private JPanel header;
    private JPanel panel;
    ArrayList<ProductModel> products;

    public ShopView() {
        products = new ArrayList<>();

        frame = new JFrame();
        frame.setTitle("NUTRILAND - SHOP");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        header = new JPanel(new FlowLayout());
        header.setBackground(Color.BLACK);
        frame.add(header, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane, BorderLayout.CENTER);

        showImage(290, 70,  "NORTH","/Users/gasparrobert95/IdeaProjects/NUTRILAND/images/whiteLogo.png");
    }

    public void showImage(int w, int h, String pos, String path) {
        ImageIcon imageIcon = new ImageIcon(path);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(imageIcon, JLabel.CENTER);
        if (pos.equals("NORTH"))
            header.add(imageLabel);
        else {
            panel.add(Box.createRigidArea(new Dimension(70, 50)));
            panel.add(imageLabel);
        }
    }

    public void showProducts() {
        for (var product : products) {
            String url = "/Users/gasparrobert95/IdeaProjects/NUTRILAND/images/" + product.getImageName();
            showImage(200, 200, "CENTER", url);

            JLabel nameLabel = new JLabel(product.getName());
            panel.add(Box.createRigidArea(new Dimension(70, 15)));
            panel.add(nameLabel);

            JLabel priceLabel = new JLabel(String.valueOf(product.getPrice()) + "  RON");
            panel.add(Box.createRigidArea(new Dimension(70, 15)));
            panel.add(priceLabel);

            JLabel stockLabel = new JLabel();
            if (product.getQuantity() > 3) {
                stockLabel.setText("In stock");
                stockLabel.setForeground(new Color(80, 200, 120));
            }
            else if (product.getQuantity() > 1) {
                stockLabel.setText(String.valueOf(product.getQuantity()) + " left");
                stockLabel.setForeground(Color.ORANGE);
            }
            else {
                stockLabel.setText("Out of stock");
                stockLabel.setForeground(Color.RED);
            }
            panel.add(Box.createRigidArea(new Dimension(70, 15)));
            panel.add(stockLabel);
        }
        panel.add(Box.createRigidArea(new Dimension(70, 60)));
        frame.setVisible(true);
    }

    public void setProducts(ArrayList<ProductModel> products) {this.products = products;}

    public void closeWindow() {
        frame.setVisible(false);
    }
}
