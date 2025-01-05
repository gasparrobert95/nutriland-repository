package mvc.views;

import mvc.models.ProductModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShopView extends JFrame {
    private JFrame frame;
    private JPanel header;
    private JPanel panel;
    private JButton cartButton;
    private ArrayList<ProductModel> products;
    private ArrayList<Integer> cart;

    public ShopView() {
        products = new ArrayList<>();

        frame = new JFrame();
        frame.setTitle("NUTRILAND - SHOP");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        header = new JPanel(new BorderLayout());
        header.setBackground(Color.BLACK);
        frame.add(header, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane, BorderLayout.CENTER);

        showImage(290, 70,  "NORTH","/Users/gasparrobert95/IdeaProjects/NUTRILAND/images/whiteLogo.png");

        cartButton = new JButton();
        cartButton.setOpaque(true);
        cartButton.setContentAreaFilled(true);
        cartButton.setBorderPainted(false);
        cartButton.setFocusPainted(false);
        cartButton.setBackground(Color.BLACK);
        ImageIcon cartIcon = new ImageIcon("/Users/gasparrobert95/IdeaProjects/NUTRILAND/images/cart.png");
        cartIcon.setImage(cartIcon.getImage().getScaledInstance(50,42, Image.SCALE_DEFAULT));
        cartButton.setIcon(cartIcon);
        header.add(cartButton, BorderLayout.EAST);
    }

    public void showImage(int w, int h, String pos, String path) {
        ImageIcon imageIcon = new ImageIcon(path);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(imageIcon, JLabel.CENTER);
        if (pos.equals("NORTH"))
            header.add(imageLabel, BorderLayout.CENTER);
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

            String price = String.format("%.2f RON", product.getPrice());
            JLabel priceLabel = new JLabel(price);
            panel.add(Box.createRigidArea(new Dimension(70, 15)));
            panel.add(priceLabel);

            /*JSpinner quantitySpinner = new JSpinner();
            quantitySpinner.setValue(1);
            quantitySpinner.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    double q = Double.parseDouble((String) quantitySpinner.getValue());
                    priceLabel.setText(Double.toString(q * product.getPrice()) + " RON");
                    //priceLabel.setText(String.format("%.2f RON", quantitySpinner.getValue()));
                }
            });
            panel.add(quantitySpinner);*/

            //panel.add(Box.createRigidArea(new Dimension(70, 15)));

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

            if (product.getQuantity() > 0) {
                panel.add(Box.createRigidArea(new Dimension(70, 15)));
                JButton addButton = new JButton();
                if (cart.contains(product.getId()))
                    addButton.setText("In Cart");
                else
                    addButton.setText("Add Product");
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (cart.contains(product.getId())) {
                                cart.remove((Integer) product.getId());
                                addButton.setText("Add Product");
                            }
                            else {
                                cart.add(product.getId());
                                addButton.setText("In Cart");
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                panel.add(addButton);
            }
        }
        panel.add(Box.createRigidArea(new Dimension(70, 60)));
        frame.setVisible(true);
    }

    public void showSuccessfulMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "INFO", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    }

    public void setProducts(ArrayList<ProductModel> products) {this.products = products;}

    public ArrayList<Integer> getCart() {return cart;}

    public void setCart(ArrayList<Integer> cart) {this.cart = cart;}

    public void addCartButtonListener(ActionListener actionListener) {
        cartButton.addActionListener(actionListener);
    }

    public void closeWindow() {
        frame.setVisible(false);
    }
}
