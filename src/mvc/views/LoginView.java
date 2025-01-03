package mvc.views;

import mvc.exceptions.ExceptionMissingDetail;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JFrame frame = new JFrame();
    private JButton loginButton;
    private JButton registerButton;
    private JTextField usernameText;
    private JPasswordField passwordText;

    public LoginView() {
        frame = new JFrame();
        frame.setTitle("NUTRILAND - LOG IN");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        usernameText = new JTextField(20);
        usernameText.setBounds(100, 20, 165, 25);
        panel.add(usernameText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(70, 90, 80, 25);
        panel.add(loginButton);

        JLabel registerLabel = new JLabel("Not a member yet? -> ");
        registerLabel.setBounds(10, 130, 180, 25);
        panel.add(registerLabel);

        registerButton = new JButton("Register");
        registerButton.setBounds(155, 130, 80, 25);
        panel.add(registerButton);

        frame.setVisible(true);
    }

    public void closeWindow() {
        frame.setVisible(false);
    }

    public String getUsername() {return usernameText.getText();}

    public String getPassword() {return passwordText.getText();}

    public void checkValidAccount() throws ExceptionMissingDetail {
        if (getUsername().equals("") || getPassword().equals("")) {
            throw new ExceptionMissingDetail();
        }
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    }

    public void addLoginButtonListener(ActionListener actionListener) {
        loginButton.addActionListener(actionListener);
    }

    public void addRegisterButtonListener(ActionListener actionListener) {
        registerButton.addActionListener(actionListener);
    }

    public void clearData() {
        usernameText.setText("");
        passwordText.setText("");
    }
}
