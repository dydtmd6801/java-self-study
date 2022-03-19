package cliDBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInsert {
    public static void main(String[] args) {

        Connection conn = null;

        String server = "jdbc:mysql://localhost:3306/db_study?useSSL=false";
        String userId = "root";
        String passWd = "abc123";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 에러");
            e.printStackTrace();
        }

        try{
            conn = DriverManager.getConnection(server, userId, passWd);

            String sql = "insert into test values ('d', 6)";

            Statement stmt = conn.createStatement();
            stmt.execute(sql);

            System.out.println("insert 성공");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
