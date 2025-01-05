package mvc.views;

import mvc.models.ProductModel;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CartView extends JFrame {
    private JFrame frame;
    private JPanel header;
    private JPanel footer;
    private JButton shopButton;
    private JButton orderButton;
    private JTable table;
    private JLabel totalPriceLabel;
    private ArrayList<ProductModel> products;
    private double totalPrice = 0;

    public CartView() {
        frame = new JFrame();
        frame.setTitle("NUTRILAND - CART");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        header = new JPanel(new BorderLayout());
        header.setBackground(Color.BLACK);
        frame.add(header, BorderLayout.NORTH);

        ImageIcon imageIcon = new ImageIcon("/Users/gasparrobert95/IdeaProjects/NUTRILAND/images/whiteLogo.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(290, 70, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(imageIcon, JLabel.CENTER);
        header.add(imageLabel, BorderLayout.CENTER);

        shopButton = new JButton();
        shopButton.setOpaque(true);
        shopButton.setContentAreaFilled(true);
        shopButton.setBorderPainted(false);
        shopButton.setFocusPainted(false);
        shopButton.setBackground(Color.BLACK);
        ImageIcon shopIcon = new ImageIcon("/Users/gasparrobert95/IdeaProjects/NUTRILAND/images/shopIcon.png");
        shopIcon.setImage(shopIcon.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
        shopButton.setIcon(shopIcon);
        header.add(shopButton, BorderLayout.EAST);

        footer = new JPanel();
        footer.setBackground(Color.BLACK);
        frame.add(footer, BorderLayout.SOUTH);

        totalPriceLabel = new JLabel("Total Price: " + totalPrice + " RON");
        totalPriceLabel.setForeground(Color.WHITE);
        footer.add(totalPriceLabel);

        orderButton = new JButton("Order");
        footer.add(orderButton);

    }

    public void showProducts() {
        String[] columns = {"Product", "Quantity", "Price"};
        String[][] data = new String[products.size()][columns.length];
        int line = 0;
        for (var product : products) {
            data[line][0] = product.getName();
            data[line][1] = "1";
            data[line][2] = String.valueOf(product.getPrice());
            totalPrice += product.getPrice();
            ++line;
        }
        totalPriceLabel.setText(String.format("Total Price: %.2f RON", totalPrice));
        table = new JTable(data, columns) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                component.setBackground(Color.WHITE);
                if (isCellSelected(row, column))
                    component.setBackground(Color.GRAY);
                return component;
            }
        };
        table.setPreferredScrollableViewportSize(new Dimension(800, 600));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void addOrderButtonListener(ActionListener actionListener) {
        orderButton.addActionListener(actionListener);
    }

    public void showSuccessfulMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "INFO", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setProducts(ArrayList<ProductModel> products) {this.products = products;}

    public void addShopButtonListener(ActionListener actionListener) {
        shopButton.addActionListener(actionListener);
    }

    public void closeWindow() {
        frame.setVisible(false);
    }
}
