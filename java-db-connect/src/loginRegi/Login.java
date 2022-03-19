package loginRegi;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    JLabel idText = new JLabel("Username");
    JLabel pwText = new JLabel("Password");

    JButton loginBtn = new JButton("Login");
    JButton regiBtn = new JButton("Register");

    JTextField userName = new JTextField(15);
    JTextField passWord = new JTextField(15);

    JPanel loginPage = new JPanel();

    Font font = new Font("", Font.BOLD, 16);

    Login() {
        loginPage.setLayout(null);

        idText.setFont(font);
        idText.setBounds(100, 40, 200, 20);

        userName.setBounds(100, 65, 200, 26);

        pwText.setFont(font);
        pwText.setBounds(100, 100, 200, 20);

        passWord.setBounds(100, 125, 200, 26);

        loginBtn.setBounds(100, 170, 90, 30);
        loginBtn.setBackground(Color.black);
        loginBtn.setForeground(Color.white);

        regiBtn.setBounds(210, 170, 90, 30);
        regiBtn.setBackground(Color.black);
        regiBtn.setForeground(Color.white);

        loginPage.add(idText);
        loginPage.add(userName);
        loginPage.add(pwText);
        loginPage.add(passWord);
        loginPage.add(loginBtn);
        loginPage.add(regiBtn);
    }
}
