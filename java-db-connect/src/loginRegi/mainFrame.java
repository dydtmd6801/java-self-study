package loginRegi;

import javax.swing.*;

public class mainFrame extends JFrame {
    Login login = new Login();
    Register regi = new Register();

    mainFrame() {
        this.setTitle("mainPage");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(400, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void formDesign() {
        this.add(login.loginPage);
    }

    private void eventHandler() {

    }

    public static void main(String[] args) {
        new mainFrame();
    }
}
