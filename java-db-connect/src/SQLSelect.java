import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLSelect {
    public static void main(String[] args) {
        Connection conn = null;

        String server = "jdbc:mysql://localhost:3306/db_study?useSSL=false";
        String userId = "root";
        String passwd = "abc123";

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 에러");
            e.printStackTrace();
        }

        try{
            conn = (Connection) DriverManager.getConnection(server, userId, passwd);
            System.out.println("연결성공");
        } catch (SQLException e) {
            System.out.println("연결실패");
            e.printStackTrace();
        }

        try{
            if(conn != null)
                conn.close();
        } catch (SQLException e) {}
    }
}
