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

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridBagLayout());
        frame.add(panel, BorderLayout.CENTER);

        panel.add(new JLabel("Username"), createGbc(0, 0));

        usernameText = new JTextField(10);
        panel.add(usernameText, createGbc(1, 0));

        panel.add(new JLabel("Password"), createGbc(0, 1));

        passwordText = new JPasswordField(10);
        panel.add(passwordText, createGbc(1, 1));

        loginButton = new JButton("Login");
        panel.add(loginButton, createGbc(0, 2));

        JPanel footer = new JPanel(new FlowLayout());
        footer.setBackground(Color.WHITE);
        frame.add(footer, BorderLayout.SOUTH);

        JLabel registerLabel = new JLabel("Not a member yet?  -> ");
        registerLabel.setForeground(Color.BLUE);
        footer.add(registerLabel);

        registerButton = new JButton("Register");
        footer.add(registerButton);

        frame.setVisible(true);
    }

    private static GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        //int gap = 3;
        //gbc.insets = new Insets(gap, gap + 2 * gap * x, gap, gap);
        return gbc;
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
