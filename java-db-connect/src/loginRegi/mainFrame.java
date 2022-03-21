package loginRegi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class mainFrame extends JFrame implements ActionListener {
    Connection conn = null;

    Login login = new Login();
    Register regi = new Register();

    String server = "jdbc:mysql://localhost:3306/loginregi?useSSL=false";
    String username = "root";
    String password = "abc123";

    mainFrame() {
        this.setTitle("mainPage");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(400, 360);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void formDesign() {
        this.setLayout(new CardLayout());
        this.add(login.loginPage);
        this.add(regi.regiPage);

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 에러");
            e.printStackTrace();
        }
    }

    private void eventHandler() {
        login.regiBtn.addActionListener(this);
        login.loginBtn.addActionListener(this);

        regi.cancel.addActionListener(this);
    }

    public static void main(String[] args) {
        new mainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login.regiBtn){
            login.loginPage.setVisible(false);
            regi.regiPage.setVisible(true);
        }
        if(e.getSource() == login.loginBtn){
            String idData = login.userName.getText();
            StringBuffer pwData = new StringBuffer();
            char[] pwCharData = login.passWord.getPassword();
            for(int i = 0; i < pwCharData.length; i++){
                pwData.append(pwCharData[i]);
            }
            String loginSQL = "select * from userInfo where id='" + idData + "' and pw='" + pwData + "'";

            loginFunc(loginSQL);
        }
        if(e.getSource() == regi.cancel){
            login.loginPage.setVisible(true);
            regi.regiPage.setVisible(false);
        }
    }

    public void loginFunc(String sql) {
        try{
            conn = DriverManager.getConnection(server, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                JOptionPane.showMessageDialog(null, "로그인 되었습니다.", "로그인 상태", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "로그인 정보가 맞지않습니다.", "로그인 상태", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
