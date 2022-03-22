package rps;

import javax.swing.*;

public class rpsMain extends JFrame {
    rpsMain() {
        this.setTitle("가위바위보");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(400, 400);
        this.setVisible(true);
    }

    private void formDesign() {

    }

    private void eventHandler() {

    }

    public static void main(String[] args) {
        new rpsMain();
    }
}
