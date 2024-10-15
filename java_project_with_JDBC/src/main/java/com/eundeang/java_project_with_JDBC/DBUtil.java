package java_project_with_JDBC;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/workshop";
    public static final String USER = "root";
    public static final String PASSWORD = "abcd1234@";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            System.out.println("커넥션 생성 오류");
            e.printStackTrace();
        }
        return conn;
    }
    // 동적 매개변수 활용, 개수 재한없이 매개변수 받아아옴 (잘 안쓰임)
    public static void close(AutoCloseable... closeables) {
        for (AutoCloseable closeable : closeables) {
            if (closeable != null) {
                try{
                    closeable.close();
                }catch (Exception e) {
                    System.out.println("close 하다가 에러 발생");
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
