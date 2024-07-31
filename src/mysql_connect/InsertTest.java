package mysql_connect;

import java.sql.*;

public class InsertTest {
    public static void main(String[] args) {
        Connection connection = null;
        String SQL = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 1. 커넥션 생성
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/workshop","root","abcd1234@");
            //2. SQL 작성
            SQL = "insert into book_tb(title, writer, price, publisher) values('강사님 너무 조아요~!', '우하하', 30000, 'grep')";
            //3. PreparedStatement or Statement에 명령어 담기
            pstmt = connection.prepareStatement(SQL); //Statement는 이렇게 미리 SQL을 넣지 않고 execute 하는 시점에 넣는 차이가 있음
            //4. 실행하기
            //4.1 insert/ update/ delete : int
            //4.2 select : ResultSet
            int result = pstmt.executeUpdate();
            //5. 결과값 처리
            System.out.println("SQL 실행이 완료되었습니다."+result);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            //6. 사용 완료된 리소스 반납(생성한 순서의 역순으로)
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException();
                }
            }
        }
    }
}