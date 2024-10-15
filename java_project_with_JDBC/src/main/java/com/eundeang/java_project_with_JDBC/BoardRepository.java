package java_project_with_JDBC;

import java.sql.SQLException;
import java.util.List;

public interface BoardRepository {
    int insert(BoardDTO boardDTO) throws SQLException;
    int update(BoardDTO boardDTO, String category) throws SQLException;
    int update(BoardDTO boardDTO) throws SQLException;
    int delete(int id);
    List<BoardDTO> search(BoardDTO boardDTO);
    BoardDTO findById(int id);
    List<BoardDTO> selectAll() throws SQLException;
    BoardDTO selectOne(int id);
}
