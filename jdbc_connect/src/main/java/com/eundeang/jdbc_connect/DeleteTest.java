package com.eundeang.jdbc_connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class DeleteTest {
    public static void main(String[] args) {
        Connection con = null;
        String updateSQL = null;
        String selectSQL = null;
        int id = 0;
        PreparedStatement ps1 = null;
        ResultSet rs = null;
        // 1. 커넥션 연결
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/workshop", "root", "abcd1234@");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("삭제하고자 하는 id >> ");
            id = Integer.parseInt(br.readLine());

            // 2. SQL 작성
            updateSQL = "delete from book_tb where bno = ?";
            // 3. pstmt 작성
            ps1 = con.prepareStatement(updateSQL);
            // 4. pstmt에 있는 sql 구문 완성
            ps1.setInt(1, id);
            // 5. 실행(executeUpdate: int)
            int result = ps1.executeUpdate();
            // 6. 결과값 처리
            System.out.println(result);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //6. 사용 완료된 리소스 반납(생성한 순서의 역순으로)
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException();
                }
            }
            if (ps1 != null) {
                try {
                    ps1.close();
                } catch (SQLException e) {
                    throw new RuntimeException();
                }
            }
        }
    }

}
