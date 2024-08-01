package jdbc_connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class InsertByConsole {
    public static void main(String[] args) {
        Connection connection = null;
        String SQL = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 1. 커넥션 생성
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/workshop","root","abcd1234@");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("제목 : ");
            String title = br.readLine();
            System.out.print("출판사 : ");
            String pub = br.readLine();
            System.out.print("저자 : ");
            String wri = br.readLine();
            System.out.print("가격 : ");
            int price = Integer.parseInt(br.readLine());
            //2. SQL 작성 (Statement는 변수를 집어넣을 떄 아래와 같이 복잡하게 이어붙여 넣기 해야함)
            //SQL = "insert into book_tb(title, writer, price, publisher) values('"+title+"'"+"'"+wri+"'"+ price+ "'"+pub+"')";

            SQL = "insert into book_tb(title, writer, price, publisher) values (?,?,?,?)";
            //3. PreparedStatement or Statement에 명령어 담기
            pstmt = connection.prepareStatement(SQL); //PrepareStatement는 이렇게 SQL을 미리 넣지 않고 execute하는 시점에 넣는 차이가 있음
            pstmt.setString(1, title);
            pstmt.setString(2, wri);
            pstmt.setInt(3, price);
            pstmt.setString(4, pub);

            //4. 실행하기
            //4.1 insert/ update/ delete : int
            //4.2 select : ResultSet
            int result = pstmt.executeUpdate();
            //5. 결과값 처리
            System.out.println("SQL 실행이 완료되었습니다."+result);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
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
