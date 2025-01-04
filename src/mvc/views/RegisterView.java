package mvc.views;

import mvc.exceptions.ExceptionDifferentPasswords;
import mvc.exceptions.ExceptionMissingDetail;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {
    private JFrame frame = new JFrame();
    private JButton registerButton;
    private JTextField nameText;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JPasswordField repeatPasswordText;
    private JRadioButton clientButton;
    private JRadioButton affiliateButton;

    public RegisterView() {
        frame = new JFrame();
        frame.setTitle("NUTRILAND - REGISTER");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 50, 80, 25);
        panel.add(usernameLabel);

        usernameText = new JTextField(20);
        usernameText.setBounds(100, 50, 165, 25);
        panel.add(usernameText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 80, 165, 25);
        panel.add(passwordText);

        JLabel repeatPasswordLabel = new JLabel("Repeat Password");
        repeatPasswordLabel.setBounds(10, 110, 80, 25);
        panel.add(repeatPasswordLabel);

        repeatPasswordText = new JPasswordField();
        repeatPasswordText.setBounds(100, 110, 165, 25);
        panel.add(repeatPasswordText);

        JLabel userTypeText = new JLabel("User Type");
        userTypeText.setBounds(15, 150, 165, 25);
        panel.add(userTypeText);

        clientButton = new JRadioButton("Client");
        clientButton.setBounds(85,150,70,25);
        panel.add(clientButton);

        affiliateButton = new JRadioButton("Affiliate");
        affiliateButton.setBounds(155,150,85,25);
        panel.add(affiliateButton);

        ButtonGroup group = new ButtonGroup();
        group.add(clientButton);
        group.add(affiliateButton);

        registerButton = new JButton("Sign Up");
        registerButton.setBounds(85, 190, 80, 25);
        panel.add(registerButton);

        frame.setVisible(true);
    }

    public void closeWindow() {
        frame.setVisible(false);
    }

    public void addRegisterButtonListener(ActionListener actionListener) {
        registerButton.addActionListener(actionListener);
    }

    public String getName() {return nameText.getText();}

    public String getUsername() {return usernameText.getText();}

    public String getPassword() {return passwordText.getText();}

    public String getRepeatPassword() {return repeatPasswordText.getText();}

    public int getUserType() {
        if (!clientButton.isSelected() && !affiliateButton.isSelected())
            return -1;
        return clientButton.isSelected() ? 1 : 2;
    }

    public void showSuccessfulMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "SUCCESSFULLY CREATED ACCOUNT", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    }

    public void checkValidAccount() throws ExceptionMissingDetail {
        if (getName().equals("") || getUsername().equals("") || getPassword().equals("") || getRepeatPassword().equals("") || getUserType() == -1) {
            throw new ExceptionMissingDetail();
        }
    }

    public void checkPasswords() throws ExceptionDifferentPasswords {
        if (!getPassword().equals(getRepeatPassword())) {
            throw new ExceptionDifferentPasswords();
        }
    }

    public void clearData() {
        nameText.setText("");
        usernameText.setText("");
        passwordText.setText("");
        repeatPasswordText.setText("");
        clientButton.setSelected(false);
        affiliateButton.setSelected(false);
    }

}
