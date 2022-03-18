package guiDBConect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

class studentData{
    String name;
    int age;
    int grade;

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

public class guiDBConnect extends JFrame implements ActionListener {
    Connection conn = null;

    private String server = "jdbc:mysql://localhost:3306/db_study?useSSL=false";
    private String userId = "root";
    private String userWd = "abc123";

    private Font font = new Font("Noto sans KR", Font.PLAIN, 14);
    private Font btn_font = new Font("Noto sans KR", Font.BOLD, 18);

    private JPanel select = new JPanel();
    private JPanel display = new JPanel();

    private JButton btn_name = new JButton("이름 정렬");
    private JButton btn_age = new JButton("나이 정렬");
    private JButton btn_grade = new JButton("학년 정렬");
    private JButton exit = new JButton("종료");

    String sql = "select * from selectex";

    guiDBConnect() {
        this.setTitle("DB연결");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(500,500);
        this.setVisible(true);
    }

    private void formDesign() {
        this.setLayout(new BorderLayout());
        this.add(select, BorderLayout.NORTH);
        this.add(display, BorderLayout.CENTER);

        select.setLayout(new GridLayout(0,4));
        btn_name.setFont(btn_font);
        btn_age.setFont(btn_font);
        btn_grade.setFont(btn_font);
        exit.setFont(btn_font);
        select.add(btn_name);
        select.add(btn_age);
        select.add(btn_grade);
        select.add(exit);

        display.setLayout(new BoxLayout(display, BoxLayout.Y_AXIS));

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 에러");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(server, userId, userWd);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<studentData> sD = new ArrayList<studentData>();

            while(rs.next()){
                studentData studentdata = new studentData();
                studentdata.setName(rs.getString("name"));
                studentdata.setAge(rs.getInt("age"));
                studentdata.setGrade(rs.getInt("grade"));
                sD.add(studentdata);
            }

            JLabel lname = new JLabel();
            JLabel lage = new JLabel();
            JLabel lgrade = new JLabel();
            JLabel total;

            for(int i = 0; i < sD.size(); i++){
                lname.setText("이름 : " + sD.get(i).getName());
                lage.setText(", 나이 : " + sD.get(i).getAge());
                lgrade.setText(", 학년 : " + sD.get(i).getGrade());
                total = new JLabel(lname.getText() + lage.getText() + lgrade.getText());
                total.setFont(font);
                display.add(total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void eventHandler() {
        exit.addActionListener(this);
        btn_name.addActionListener(this);
        btn_age.addActionListener(this);
        btn_grade.addActionListener(this);
    }

    public static void main(String[] args) {
        new guiDBConnect();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(exit.getText().equals("종료")){
            System.exit(0);
        }
    }
}
