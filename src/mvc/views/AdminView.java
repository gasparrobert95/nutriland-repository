package mvc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdminView extends JFrame {
    private JFrame frame;
    private JButton exitButton;
    private JButton addProductButton;
    private JButton updateButton;
    private JTextField idField;
    private JTextField quantityField;
    private JTextField productNameField;
    private JTextField productPriceField;
    private JTextField productQuantityField;
    private JTextField imageNameField;

    public AdminView() {
        frame = new JFrame();
        frame.setTitle("NUTRILAND - ADMIN");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel header = new JPanel(new FlowLayout());
        header.setBackground(Color.WHITE);
        frame.add(header, BorderLayout.NORTH);

        ImageIcon imageIcon = new ImageIcon("/Users/gasparrobert95/IdeaProjects/NUTRILAND/images/adminLogo.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(imageIcon, JLabel.CENTER);
        header.add(imageLabel);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(panel, BorderLayout.CENTER);

        JLabel updateLabel = new JLabel("Update stock");
        panel.add(updateLabel);

        idField = new JTextField(15);
        idField.setText("Product Id");
        panel.add(idField);

        quantityField = new JTextField(10);
        quantityField.setText("New quantity");
        panel.add(quantityField);

        updateButton = new JButton("Update");
        panel.add(updateButton);

        JLabel emptyLine = new JLabel("");
        emptyLine.setPreferredSize(new Dimension(3000, 15));
        panel.add(emptyLine);

        JLabel newProductLabel = new JLabel("Add new product");
        panel.add(newProductLabel);

        productNameField = new JTextField(15);
        productNameField.setText("Product name");
        panel.add(productNameField);

        productPriceField = new JTextField(5);
        productPriceField.setText("Price");
        panel.add(productPriceField);

        productQuantityField = new JTextField(10);
        productQuantityField.setText("Quantity");
        panel.add(productQuantityField);

        imageNameField = new JTextField(10);
        imageNameField.setText("Image name");
        panel.add(imageNameField);

        addProductButton = new JButton("Add Product");
        panel.add(addProductButton);

        JPanel footer = new JPanel(new FlowLayout());
        footer.setBackground(Color.BLACK);
        frame.add(footer, BorderLayout.SOUTH);

        exitButton = new JButton("Exit");
        footer.add(exitButton);

        frame.setVisible(true);
    }

    public void addExitButtonListener(ActionListener exitButtonListener) {
        exitButton.addActionListener(exitButtonListener);
    }

    public void addUpdateButtonListener(ActionListener updateButtonListener) {
        updateButton.addActionListener(updateButtonListener);
    }

    public void addAddProductButtonListener(ActionListener addProductButtonListener) {
        addProductButton.addActionListener(addProductButtonListener);
    }

    public int getUpdateId() {return Integer.parseInt(idField.getText());}

    public int getUpdateQuantity() {return Integer.parseInt(quantityField.getText());}

    public String getAddProductName() {return productNameField.getText();}

    public double getAddPrice() {return Double.parseDouble(productPriceField.getText());}

    public int getAddQuantity() {return Integer.parseInt(productQuantityField.getText());}

    public String getAddImage() {return imageNameField.getText();}

    public void showSuccessfulMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "INFO", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    }

    public void closeWindow() {
        frame.setVisible(false);
    }
}
