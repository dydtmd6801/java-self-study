package loginRegi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame implements ActionListener {
    Login login = new Login();
    Register regi = new Register();

    mainFrame() {
        this.setTitle("mainPage");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(400, 360);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void formDesign() {
        this.setLayout(new CardLayout());
        this.add(login.loginPage);
        this.add(regi.regiPage);
    }

    private void eventHandler() {
        login.regiBtn.addActionListener(this);
        login.loginBtn.addActionListener(this);

        regi.cancel.addActionListener(this);
    }

    public static void main(String[] args) {
        new mainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login.regiBtn){
            login.loginPage.setVisible(false);
            regi.regiPage.setVisible(true);
        }
        if(e.getSource() == regi.cancel){
            login.loginPage.setVisible(true);
            regi.regiPage.setVisible(false);
        }
    }
}
