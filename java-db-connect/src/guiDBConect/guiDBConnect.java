package guiDBConect;

import javax.swing.*;
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

public class guiDBConnect extends JFrame {
    Connection conn = null;
    private String server = "jdbc:mysql://localhost:3306/db_study?useSSL=false";
    private String userId = "root";
    private String userWd = "abc123";

    private JPanel p = new JPanel();

    guiDBConnect() {
        this.setTitle("DB연결");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(500,500);
        this.setVisible(true);
    }

    private void formDesign() {
        this.add(p);

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 에러");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(server, userId, userWd);

            String sql = "select * from selectex";
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

            JLabel lname;
            JLabel lage;
            JLabel lgrade;
            JLabel total;


            for(int i = 0; i < sD.size(); i++){
                lname = new JLabel("이름 : " + sD.get(i).getName());
                lage = new JLabel(", 나이 : " + sD.get(i).getAge());
                lgrade = new JLabel(", 학년 : " + sD.get(i).getGrade());
                total = new JLabel("" + lname.getText() + lage.getText() + lgrade.getText() + "\n");
                p.add(total);
//                p.add();
//                lname[i].setText(""+i);
//                System.out.println("name : " + sD.get(i).getName());
//                System.out.println("age : " + sD.get(i).getAge());
//                System.out.println("grade : " + sD.get(i).getGrade());

//                lname[i].setText(sD.get(i).getName());
//                lage[i].setText(""+sD.get(i).getAge());
//                lgrade[i].setText(""+sD.get(i).getGrade());
//
//                p.add(lname[i]);
//                p.add(lage[i]);
//                p.add(lgrade[i]);
//                System.out.println(lname[i]);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void eventHandler() {

    }

    public static void main(String[] args) {
        new guiDBConnect();
    }
}
