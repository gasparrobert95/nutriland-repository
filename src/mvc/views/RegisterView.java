package mvc.views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {
    private JButton registerButton;

    public RegisterView() {
        JFrame frame = new JFrame();
        frame.setTitle("NUTRILAND");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 50, 80, 25);
        panel.add(usernameLabel);

        JTextField usernameText = new JTextField(20);
        usernameText.setBounds(100, 50, 165, 25);
        panel.add(usernameText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 80, 165, 25);
        panel.add(passwordText);

        JLabel repeatPasswordLabel = new JLabel("Repeat Password");
        repeatPasswordLabel.setBounds(10, 110, 80, 25);
        panel.add(repeatPasswordLabel);

        JPasswordField repeatPasswordText = new JPasswordField();
        repeatPasswordText.setBounds(100, 110, 165, 25);
        panel.add(repeatPasswordText);

        JLabel genderText = new JLabel("User Type");
        genderText.setBounds(15, 150, 165, 25);
        panel.add(genderText);

        JRadioButton clientButton = new JRadioButton("Client");
        clientButton.setBounds(85,150,70,25);
        panel.add(clientButton);

        JRadioButton affiliateButton = new JRadioButton("Affiliate");
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

    public void registerButtonListener(ActionListener actionListener) {
        registerButton.addActionListener(actionListener);
    }
}
