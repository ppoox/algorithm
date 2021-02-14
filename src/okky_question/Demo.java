package okky_question;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        String driver = "oracle.jdbc.driver.OracleDriver";

        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        String sql = "SELECT COUNT(NAME) FROM MEMBER WHERE NAME = ? GROUP BY NAME";
        Connection con = null;

        PreparedStatement pstmt = null;

        Class.forName(driver);

        con = DriverManager.getConnection(url,"admin","1234");
        pstmt = con.prepareStatement(sql);

        System.out.printf("중복성을 확인할 이름을 입력해주세요.");

        String name = scan.next();
        pstmt.setString(1,  name);

        System.out.println(pstmt);

    }


}
