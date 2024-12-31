package mvc.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JButton loginButton;
    private JButton registerButton;

    public LoginView() {
        JFrame frame = new JFrame();
        frame.setTitle("NUTRILAND");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(70, 90, 80, 25);
        panel.add(loginButton);

        JLabel registerLabel = new JLabel("Not a member yet? -> ");
        registerLabel.setBounds(10, 130, 180, 25);
        panel.add(registerLabel);

        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        registerButton.setBounds(155, 130, 80, 25);
        panel.add(registerButton);

        frame.setVisible(true);
    }

    public void addLoginButtonListener(ActionListener actionListener) {
        loginButton.addActionListener(actionListener);
    }

    public void addRegisterButtonListener(ActionListener actionListener) {
        registerButton.addActionListener(actionListener);
    }
}
