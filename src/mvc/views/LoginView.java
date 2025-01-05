package mvc.views;

import mvc.exceptions.ExceptionMissingDetail;

import javax.swing.*;
import java.awt.*;
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
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel header = new JPanel(new FlowLayout());
        header.setBackground(Color.WHITE);
        frame.add(header, BorderLayout.NORTH);

        ImageIcon imageIcon = new ImageIcon("/Users/gasparrobert95/IdeaProjects/NUTRILAND/images/logo.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(imageIcon, JLabel.CENTER);
        header.add(imageLabel);

        JPanel center = new JPanel();
        center.setBackground(Color.WHITE);
        center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
        frame.add(center, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        center.add(panel);

        JLabel emptyLine = new JLabel("");
        emptyLine.setPreferredSize(new Dimension(3000,15));

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        center.add(panel2);

        panel.add(new JLabel("Username"));

        usernameText = new JTextField(10);
        panel.add(usernameText);

        panel.add(emptyLine);

        panel.add(new JLabel("Password"));

        passwordText = new JPasswordField(10);
        panel.add(passwordText);

        loginButton = new JButton("Login");
        panel2.add(loginButton);

        JPanel footer = new JPanel(new FlowLayout());
        footer.setBackground(Color.BLACK);
        frame.add(footer, BorderLayout.SOUTH);

        JLabel registerLabel = new JLabel("Not a member yet?  -> ");
        registerLabel.setForeground(Color.WHITE);
        footer.add(registerLabel);

        registerButton = new JButton("Register");
        footer.add(registerButton);

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
