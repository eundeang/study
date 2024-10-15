package java_project_with_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardRepositoryMysql implements BoardRepository {
//    private static final String INSERT_SQL = "INSERT INTO BORAD_TB(TITLE,WRITER,CONTENT,REG_DATE) VALUES (?, ?,?,NOW())";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private static BoardRepositoryMysql instance = new BoardRepositoryMysql();
    public static BoardRepositoryMysql getInstance() {
        return instance;
    }

    @Override
    public int insert(BoardDTO board) throws SQLException {
        int result = 0;
        try {
            String INSERT_SQL = " INSERT INTO BOARD_TB(TITLE,WRITER,CONTENT,REG_DATE) VALUES (?,?,?,NOW()) ";
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(INSERT_SQL);
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getWriter());
            pstmt.setString(3, board.getContent());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insert error");
            throw e;
        } finally {
            DBUtil.close(conn, pstmt);
        }
        return result;
    }

    @Override
    public int update(BoardDTO board) throws SQLException {
        int result = 0;
        try {
            String sql = "update board_tb set ";
//             제목에 변경하고자 하는 값이 정확히 있는지 체크
            if (board.getTitle() != null && board.getTitle().length() > 0) {
                sql = "TITLE = "+board.getTitle()+", ";
            }
            if (board.getWriter() != null && board.getWriter().length() > 0) {
                sql = "WRITER = "+board.getWriter()+", ";
            }
            if (board.getContent() != null &&board.getContent().length() > 0) {
                sql = "CONTENT = "+board.getContent()+", ";
            }
            sql = sql.substring(0, sql.length()-2);

            sql = "WHERE NO = "+board.getNo();
            conn = DBUtil.getConnection();

        }catch (SQLException e) {
            System.out.println("insert error");
            throw e;
        } finally {
            DBUtil.close(conn, pstmt);
        }
        return result;
    }

    @Override
    public int update(BoardDTO board, String category) throws SQLException {
        int result = 0;
        try {
            String sql = "update board_tb set ";
            //이런 식으로 작성하면 category가 null 값이 들어와 발생하는 NPE를 피할 수 있음
            //category.equals("title")은 category가 null일시 NPE 발생!

            if ("title".equals(category)) {
                sql += "TITLE = "+board.getTitle(); //' 없어도 문자열 잘 돌아가는지 확인할것!!
            }else if ("writer".equals(category)) {
                sql += "WRITER = "+board.getWriter();
            }else if ("content".equals(category)) {
                sql += "CONTENT = "+board.getContent();
            }
            sql = "WHERE NO = "+board.getNo();
            conn = DBUtil.getConnection();

        }catch (SQLException e) {
            System.out.println("insert error");
            throw e;
        } finally {
            DBUtil.close(conn, pstmt);
        }
        return result;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<BoardDTO> search(BoardDTO boardDTO) {
        return List.of();
    }

    @Override
    public BoardDTO findById(int id) {
        return null;
    }

    @Override
    public List<BoardDTO> selectAll() throws SQLException {
        List<BoardDTO> resultSet = new ArrayList<>();
        String sql = "SELECT * FROM BOARD_TB";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
//        while (rs.next()) {
//            resultSet.add(new BoardDTO(rs));
//        }

        return List.of();
    }

    @Override
    public BoardDTO selectOne(int id) {
        return null;
    }

}
