import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selfEx01 extends JFrame {
    private JPanel main = new JPanel();
    private JButton btn = new JButton("OK");

    selfEx01() {
        this.setTitle("프레임 공부");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(500, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        // 창이 가운데 나오게함
    };

    public void formDesign() {
        this.add(main);
        main.setBackground(Color.CYAN);
        main.add(btn);
    };

    public void eventHandler() {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btn.getText().equals("OK")){
                    btn.setText("클릭");
                } else {
                    btn.setText("OK");
                }
            }
        });
    };

    public static void main(String[] args) {
        new selfEx01();
    }
}
