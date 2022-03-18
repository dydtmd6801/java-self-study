package cliDBConnect;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLSelect {
    public static class DB_data {
        String a;
        int b;

        public DB_data(){}

        public void setA(String a){
            this.a = a;
        }

        public void setB(int b){
            this.b = b;
        }

        public String getA(){
            return a;
        }

        public int getB(){
            return b;
        }
    }

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

            String sql = "select * from test";

            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery(sql);

            ArrayList<DB_data> data = new ArrayList<DB_data>();

            while(rs.next()){
                DB_data data_detail = new DB_data();
                data_detail.setA(rs.getString("a"));
                data_detail.setB(rs.getInt("b"));
                data.add(data_detail);
            }

            for(int i = 0; i < data.size(); i++){
                System.out.println(data.get(i).getA());
                System.out.println(data.get(i).getB());
            }

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
