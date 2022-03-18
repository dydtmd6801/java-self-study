package cliDBConnect;

import java.sql.*;
import java.util.ArrayList;

class student {
    String name;
    int age;
    int grade;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ClassSelect {
    public static void main(String[] args) {
        Connection conn = null;

        String server = "jdbc:mysql://localhost:3306/db_study?useSSL=false"; //서버 주소
        String user_name = "root"; //  접속자 id
        String password = "abc123"; // 접속자 pw

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(server, user_name, password);

            String sql = "select * from selectex";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<student> arraylist = new ArrayList<student>();

            while(rs.next()){
                student stu_info = new student();
                stu_info.setName(rs.getString("name"));
                stu_info.setAge(rs.getInt("age"));
                stu_info.setGrade(rs.getInt("grade"));
                arraylist.add(stu_info);
            }

            for(int i = 0; i < arraylist.size(); i++){
                System.out.print("name : " + arraylist.get(i).getName());
                System.out.print(" age : " + arraylist.get(i).getAge());
                System.out.println(" grade : " + arraylist.get(i).getGrade());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}