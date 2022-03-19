import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelChange extends JFrame implements ActionListener {

    private JPanel[] pa = new JPanel[3];
    private JButton[] ba = new JButton[7];

    PanelChange() {
        this.setTitle("패널 전환");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300,150);
        this.setVisible(true);
    }

    private void formDesign() {
        this.setLayout(new CardLayout());
        for(int i = 0; i < pa.length; i++){
            pa[i] = new JPanel();
            this.add(pa[i]);
        }
        pa[0].setBackground(Color.blue);
        pa[1].setBackground(Color.red);
        pa[2].setBackground(Color.yellow);

        ba[0] = new JButton("1");
        ba[1] = new JButton("next");

        ba[2] = new JButton("prev");
        ba[3] = new JButton("2");
        ba[4] = new JButton("next");

        ba[5] = new JButton("prev");
        ba[6] = new JButton("3");

        for(int i = 0; i < ba.length; i++){
            if(i < 2){
                pa[0].add(ba[i]);
            } else if(i < 5){
                pa[1].add(ba[i]);
            } else {
                pa[2].add(ba[i]);
            }
        }
    }

    private void eventHandler() {
        for(int i = 0; i < 7; i++){
            ba[i].addActionListener(this);
        }
    }

    public static void main(String[] args) {
        new PanelChange();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ba[0] || e.getSource() == ba[3] || e.getSource() == ba[6]){
            JOptionPane.showMessageDialog(null, "현재 페이지입니다.", "Message", JOptionPane.PLAIN_MESSAGE);
        }
        if(e.getSource() == ba[1] || e.getSource() == ba[5]){
            pa[0].setVisible(false);
            pa[1].setVisible(true);
            pa[2].setVisible(false);
        }
        if(e.getSource() == ba[2]){
            pa[0].setVisible(true);
            pa[1].setVisible(false);
            pa[2].setVisible(false);
        }
        if(e.getSource() == ba[4]){
            pa[0].setVisible(false);
            pa[1].setVisible(false);
            pa[2].setVisible(true);
        }
    }
}
