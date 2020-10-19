package gradle_spring_webmvc_study.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import gradle_spring_webmvc_study.dto.Member;

@Component
public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// ����� 1���� ���
	public Member selectByEmail(String email) {
		String sql = "SELECT ID, EMAIL, PASSWORD, NAME, REGDATE FROM MEMBER WHERE EMAIL = ?";
		return jdbcTemplate.queryForObject(sql, new MemberRowMapper(), email);
	}

	public void insert(Member member) {
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO MEMBER(EMAIL, PASSWORD, NAME, REGDATE) VALUES(?, ?, ?, ?)");
				
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				return pstmt;
			}
		};
		
	}

	public void update(Member member) {
		String sql = "UPDATE MEMBER SET NAME=?, PASSWORD=? WHERE EMAIL=?";
		jdbcTemplate.update(sql, member.getName(), member.getPassword(), member.getEmail());
	}

	public List<Member> selectAll() {
		String sql = "SELECT ID, EMAIL, PASSWORD, NAME, REGDATE FROM MEMBER";
		return jdbcTemplate.query(sql, new MemberRowMapper());
	}
	
	public void delete(Member member) {
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM MEMBER WHERE EMAIL=?");
				pstmt.setString(1, member.getEmail());
				return pstmt;
			}
		};
	}

}
