package loginRegi;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

public class Login extends JFrame {
    Register regi = new Register();

    JLabel title = new JLabel("LOGIN", SwingConstants.CENTER);
    JLabel idText = new JLabel("Username");
    JLabel pwText = new JLabel("Password");

    JButton loginBtn = new JButton("Login");
    JButton regiBtn = new JButton("Register");

    JTextField userName = new JTextField(15);
    JPasswordField passWord = new JPasswordField(15);

    JPanel loginPage = new JPanel();

    Font font = new Font("", Font.PLAIN, 16);
    Font btnFont = new Font("", Font.PLAIN, 12);
    Font titleFont = new Font("", Font.BOLD, 24);

    EmptyBorder emptyBorder = new EmptyBorder(1,1,1,1);

    Login() {
        loginPage.setLayout(null);

        title.setFont(titleFont);
        title.setBounds(100, 20, 200,20);

        idText.setFont(font);
        idText.setBounds(100, 80, 200, 20);

        userName.setBounds(100, 105, 200, 26);

        pwText.setFont(font);
        pwText.setBounds(100, 140, 200, 20);

        passWord.setBounds(100, 165, 200, 26);

        loginBtn.setBounds(100, 210, 90, 30);
        loginBtn.setFont(btnFont);
        loginBtn.setBorder(emptyBorder);
        loginBtn.setBackground(Color.black);
        loginBtn.setForeground(Color.white);

        regiBtn.setBounds(210, 210, 90, 30);
        regiBtn.setFont(btnFont);
        regiBtn.setBorder(emptyBorder);
        regiBtn.setBackground(Color.black);
        regiBtn.setForeground(Color.white);

        loginPage.add(title);
        loginPage.add(idText);
        loginPage.add(userName);
        loginPage.add(pwText);
        loginPage.add(passWord);
        loginPage.add(loginBtn);
        loginPage.add(regiBtn);
    }
}
