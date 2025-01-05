package mvc.views;

import mvc.exceptions.ExceptionDifferentPasswords;
import mvc.exceptions.ExceptionMissingDetail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {
    private JFrame frame;
    private JButton registerButton;
    private JButton backButton;
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
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        frame.add(panel, BorderLayout.CENTER);

        JLabel emptyLine1 = new JLabel("");
        emptyLine1.setPreferredSize(new Dimension(3000,15));
        JLabel emptyLine2 = new JLabel("");
        emptyLine2.setPreferredSize(new Dimension(3000,15));
        JLabel emptyLine3 = new JLabel("");
        emptyLine3.setPreferredSize(new Dimension(3000,15));
        JLabel emptyLine4 = new JLabel("");
        emptyLine4.setPreferredSize(new Dimension(3000,15));
        JLabel emptyLine5 = new JLabel("");
        emptyLine5.setPreferredSize(new Dimension(3000,45));

        JLabel nameLabel = new JLabel("Full Name           ");
        panel.add(nameLabel);

        nameText = new JTextField(10);
        panel.add(nameText);

        panel.add(emptyLine1);

        JLabel usernameLabel = new JLabel("Username           ");
        panel.add(usernameLabel);

        usernameText = new JTextField(10);
        panel.add(usernameText);

        panel.add(emptyLine2);

        JLabel passwordLabel = new JLabel("Password           ");
        panel.add(passwordLabel);

        passwordText = new JPasswordField(10);
        panel.add(passwordText);

        panel.add(emptyLine3);

        JLabel repeatPasswordLabel = new JLabel("Repeat Password");
        panel.add(repeatPasswordLabel);

        repeatPasswordText = new JPasswordField(10);
        panel.add(repeatPasswordText);

        panel.add(emptyLine4);

        JLabel userTypeText = new JLabel("User Type");
        panel.add(userTypeText);

        clientButton = new JRadioButton("Client");
        panel.add(clientButton);

        affiliateButton = new JRadioButton("Affiliate");
        panel.add(affiliateButton);

        ButtonGroup group = new ButtonGroup();
        group.add(clientButton);
        group.add(affiliateButton);

        panel.add(emptyLine5);

        registerButton = new JButton("Sign Up");
        panel.add(registerButton);

        backButton = new JButton("Back");
        panel.add(backButton);

        JPanel footer = new JPanel(new FlowLayout());
        footer.setBackground(Color.BLACK);
        frame.add(footer, BorderLayout.SOUTH);

        JLabel welcomeText = new JLabel("WELCOME TO NUTRILAND!");
        welcomeText.setForeground(Color.WHITE);
        footer.add(welcomeText);

        frame.setVisible(true);
    }

    public void closeWindow() {
        frame.setVisible(false);
    }

    public void addRegisterButtonListener(ActionListener actionListener) {
        registerButton.addActionListener(actionListener);
    }

    public void addBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
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
