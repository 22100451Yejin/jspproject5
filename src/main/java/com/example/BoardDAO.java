package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
//	Connection conn = null;
//	PreparedStatement stmt = null;
//	ResultSet rs = null;

	@Autowired
	SqlSession sqlSession;

//	private final String BOARD_INSERT = "insert into BOARD (category,title, writer, content) values (?,?,?,?)";
//	private final String BOARD_UPDATE = "update BOARD set category=?, title=?, writer=?, content=? where seq=?";
//	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
//	private final String BOARD_GET = "select * from BOARD  where seq=?";
//	private final String BOARD_LIST = "select * from BOARD order by seq desc";

	public int insertBoard(BoardVO vo) {
		int count=sqlSession.insert("Board.insertBoard",vo);
		return count;
	}

	public BoardVO getBoard(int seq){
		BoardVO one=sqlSession.selectOne("Board.getBoard",seq);
		return one;
	}

	public List<BoardVO> getBoardList(){
		List<BoardVO> list=sqlSession.selectList("Board.getBoardList");
		return list;
	}

	public int updateBoard(BoardVO vo) {
		int count=sqlSession.update("Board.updateBoard",vo);
		return count;
	}

	public int deleteBoard(int seq){
		int result=sqlSession.delete("Board.deleteBoard",seq);
		return result;
	}

//	public int deleteBoard(int id) {
//		return template.update(BOARD_DELETE, new Object[]{id});
//	}
//
//	public int updateBoard(BoardVO vo) {
//		return template.update(BOARD_UPDATE, new Object[]{vo.getCategory(),vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getSeq()});
//	}
//
//	public BoardVO getBoard(int seq) {
//		return template.queryForObject(BOARD_GET,
//				new Object[] {seq},
//				new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
//		}
//
//	public List<BoardVO> getBoardList(){
//	return template.query(BOARD_LIST, new RowMapper<BoardVO>() {
//		@Override
//		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//			BoardVO data=new BoardVO();
//			data.setSeq(rs.getInt("seq"));
//			data.setCategory(rs.getString("category"));
//			data.setContent(rs.getString("content"));
//			data.setTitle((rs.getString("title")));
//			data.setRegdate(rs.getDate("regdate"));
//			data.setWriter(rs.getString("writer"));
//			return data;
//		}
//	});
//	}
}


