package cliDBConnect;

import java.sql.*;
import java.util.ArrayList;

public class SQLTest {
    public static class DBdata {
        String a;
        int b;

        public void setStr(String a){
            this.a = a;
        }

        public void setInt(int b){
            this.b = b;
        }

        public String getStr(){
            return a;
        }

        public int getInt(){
            return b;
        }
    }
    public static void main(String[] args) {
        Connection con = null;

        String server = "jdbc:mysql://localhost:3306/db_study?useSSL=false"; //서버 주소
        String user_name = "root"; //  접속자 id
        String password = "abc123"; // 접속자 pw

        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }

        // 접속
        try {
            con = DriverManager.getConnection(server, user_name, password);
            // DriverManager.getConnection(url, userID, password) : JDBC 연결 커넥션 생성

            //select (db 데이터 조회)
            //sql 쿼리문 생성
            String sql = "select * from test";

            //Statement 생성
            Statement statement = con.createStatement();

            //sql 실행 후 ResultSet에 결과값 담기
            ResultSet resultSet = statement.executeQuery(sql);

            //결과를 담을 ArrayList 생성
            //제네릭 이용
            ArrayList<DBdata> arrayList = new ArrayList<DBdata>();

            //ResultSet 에 담긴 결과를 ArrayList 에 담기
            //resultSet.next() : 쿼리의 다음 행 값이 있으면 true, 없으면 false
            while(resultSet.next()){
                // DBdata 를 객체화
                DBdata data = new DBdata();
                //resultSet을 행으로 가져와서
                //a라는 칼럼에 해당하는 값을 String형으로 가져와서 변수에 대입
                data.setStr(resultSet.getString("a"));
                //b라는 칼럼에 해당하는 값을 Int형으로 가져와서 변수에 대입
                data.setInt(resultSet.getInt(("b")));
                //arrayList에 계속 더해서 list를 생성
                arrayList.add(data);
            }
            // 결과값을 출력
            for(int i = 0; i < arrayList.size(); i++){
                System.out.println(i + "행 a열 의 값 : " + arrayList.get(i).getStr());
                System.out.println(i + "행 b열 의 값 : " + arrayList.get(i).getInt());
            }

        } catch(SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        }

        // 접속 종료
        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}
    }
}