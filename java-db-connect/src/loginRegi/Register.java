package loginRegi;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Register extends JFrame {
    JPanel regiPage = new JPanel();

    JLabel title = new JLabel("REGISTER", SwingConstants.CENTER);
    JLabel idText = new JLabel("Username");
    JLabel pwText = new JLabel("Password");
    JLabel confirm = new JLabel("Confirm");

    JTextField idTextField = new JTextField(15);
    JPasswordField pwTextField = new JPasswordField(15);
    JPasswordField cfTextField = new JPasswordField(15);

    JButton check = new JButton("Duplicate");
    JButton register = new JButton("Register");
    JButton cancel = new JButton("Cancel");

    Font font = new Font("", Font.PLAIN, 16);
    Font btnFont = new Font("", Font.PLAIN, 12);
    Font titleFont = new Font("", Font.BOLD, 24);

    EmptyBorder emptyBorder = new EmptyBorder(1,1,1,1);

    Register() {
        regiPage.setLayout(null);

        title.setFont(titleFont);
        title.setBounds(100,20,200,20);

        idText.setFont(font);
        idText.setBounds(100, 60, 200, 20);

        idTextField.setBounds(100, 85, 140, 26);

        check.setBounds(240, 85, 60, 25);
        check.setFont(btnFont);
        check.setBorder(emptyBorder);
        check.setBackground(Color.black);
        check.setForeground(Color.white);

        pwText.setFont(font);
        pwText.setBounds(100, 120, 200, 20);

        pwTextField.setBounds(100, 145, 200, 26);

        confirm.setFont(font);
        confirm.setBounds(100, 180, 200, 20);

        cfTextField.setBounds(100, 205, 200, 26);

        register.setFont(btnFont);
        register.setBounds(100, 250, 90, 30);
        register.setBorder(emptyBorder);
        register.setBackground(Color.black);
        register.setForeground(Color.white);

        cancel.setFont(btnFont);
        cancel.setBounds(210, 250, 90, 30);
        cancel.setBorder(emptyBorder);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);


        regiPage.add(title);
        regiPage.add(idText);
        regiPage.add(idTextField);
        regiPage.add(check);
        regiPage.add(pwText);
        regiPage.add(pwTextField);
        regiPage.add(confirm);
        regiPage.add(cfTextField);
        regiPage.add(register);
        regiPage.add(cancel);
    }
}
