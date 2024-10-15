package com.eundeang.jdbc_connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class UpdateTest {
    public static void main(String[] args) {
        Connection con = null;
        String updateSQL = null;
        String selectSQL = null;
        int id = 0;
        ResultSet rs = null;
        // 1. 커넥션 연결
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/workshop", "root", "abcd1234@");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("수정하고자 하는 id >> ");
            id = Integer.parseInt(br.readLine());

            System.out.print("제목 : ");
            String title = br.readLine();
            System.out.print("출판사 : ");
            String pub = br.readLine();
            System.out.print("저자 : ");
            String wri = br.readLine();
            System.out.print("가격 : ");
            int price = Integer.parseInt(br.readLine());
            // 2. SQL 작성
            updateSQL = "update book_tb set title = ?, publisher = ?, writer = ? , price = ? where bno = ?";
            // 3. pstmt 작성
            PreparedStatement ps1 = con.prepareStatement(updateSQL);
            // 4. pstmt에 있는 sql 구문 완성
            ps1.setString(1, title);
            ps1.setString(2, pub);
            ps1.setString(3, wri);
            ps1.setInt(4, price);
            ps1.setInt(5, id);
            // 5. 실행(executeUpdate: int)
            int result = ps1.executeUpdate();
            // 6. 결과값 처리
            System.out.println(result);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 7. 사용한 자원 반납
}
