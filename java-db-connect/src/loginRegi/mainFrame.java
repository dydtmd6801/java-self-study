package loginRegi;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class mainFrame extends JFrame implements ActionListener {
    Connection conn = null;

    boolean checkDupl = false;

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
        regi.check.addActionListener(this);
        regi.register.addActionListener(this);
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
        if(e.getSource() == regi.check){
            String regiIdData = regi.idTextField.getText();
            String duplSQL = "select id from userInfo where id='" + regiIdData + "'";

            duplFunc(duplSQL);
        }
        if(e.getSource() == regi.register){
            String username = regi.idTextField.getText();

            StringBuffer pwData = new StringBuffer();
            char[] pwCharData = regi.pwTextField.getPassword();
            for(int i = 0; i < pwCharData.length; i++){
                pwData.append(pwCharData[i]);
            }

            StringBuffer confirmPw = new StringBuffer();
            char[] confirmPwCharData = regi.cfTextField.getPassword();
            for(int i = 0; i < confirmPwCharData.length; i++){
                confirmPw.append(confirmPwCharData[i]);
            }

            String pwDataString = pwData.toString();
            String confirmPwDataString = confirmPw.toString();

            if(pwDataString.equals(confirmPwDataString)) {
                if(checkDupl == true) {
                    String sql = "insert into userInfo values ('" + username + "','" + pwData + "')";
                    regiFunc(sql);

                    JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다");

                    regi.regiPage.setVisible(false);
                    login.loginPage.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"중복확인을 해주세요", "", JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,"비밀번호가 맞지 않습니다","",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public Statement dbConnection() throws SQLException {
        conn = DriverManager.getConnection(server, username, password);

        Statement stmt = conn.createStatement();

        return stmt;
    }

    public void loginFunc(String sql) {
        try{
            Statement stmt = dbConnection();

            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                JOptionPane.showMessageDialog(null, "로그인 되었습니다", "", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "로그인 정보가 맞지않습니다", "", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void regiFunc(String sql) {
        try {
            Statement stmt = dbConnection();
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void duplFunc(String sql) {
        try {
            Statement stmt = dbConnection();

            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                checkDupl = false;
                JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.", "중복확인", JOptionPane.PLAIN_MESSAGE);
            } else {
                checkDupl = true;
                JOptionPane.showMessageDialog(null, "사용 가능 아이디 입니다.", "중복 확인", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
