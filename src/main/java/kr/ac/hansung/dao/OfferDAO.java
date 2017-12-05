package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository
public class OfferDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	// query and return a single object
	public Offer getOffer(String name) {
		String sqlStatement = "select * from offers where name=?";

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { name }, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();

				offer.setTake_year(rs.getInt("take_year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setCourseName(rs.getString("courseName"));
				offer.setDivide(rs.getString("divide"));
				offer.setCredit(rs.getInt("credit"));

				return offer;
			}

		});
	}

	// query and return multiple objects
	public List<Offer> getOffers() {
		String sqlStatement = "select * from offers";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();

				offer.setTake_year(rs.getInt("take_year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setCourseName(rs.getString("courseName"));
				offer.setDivide(rs.getString("divide"));
				offer.setCredit(rs.getInt("credit"));

				return offer;
			}

		});
	}

	public boolean insert(Offer offer) {
		
		int take_year = offer.getTake_year();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String courseName = offer.getCourseName();
		String divide = offer.getDivide();
		int credit = offer.getCredit();

		String sqlStatement = "insert into offers (take_year, semester, code, courseName, divide, credit) values(?,?,?,?,?,?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { take_year, semester, code, courseName, divide, credit }) == 1);
	}

	public boolean update(Offer offer) {

		int take_year = offer.getTake_year();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String courseName = offer.getCourseName();
		String divide = offer.getDivide();
		int credit = offer.getCredit();

		String sqlStatement = "update offers set take_year=?, semester=?, code=?, courseName=?, divide=?, credit=? where id=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { take_year, semester, code, courseName, divide, credit }) == 1);
	}

	public boolean delete(int id) {
		String sqlStatement = "delete from offers where id=?";
		return (jdbcTemplate.update(sqlStatement, new Object[] { id }) == 1);
	}
	
	public List<Offer> getYearAndSemesterList() {
		String sqlStatement = "select take_year, semester, sum(credit) from offers group by take_year, semester";
		
		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offer offer = new Offer();
				
				offer.setTake_year(rs.getInt("take_year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCredit(rs.getInt("sum(credit)"));
				
				return offer;
			}
			
		});
	}
	
	public List<Offer> getOfferBySemester(int take_year, int semester) {
		String sqlStatement = "select * from offers where take_year=? and semester=?";
		
		return jdbcTemplate.query(sqlStatement, new Object[] { take_year, semester}, new RowMapper<Offer>(){

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offer offer = new Offer();
				
				offer.setTake_year(rs.getInt("take_year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setCourseName(rs.getString("courseName"));
				offer.setDivide(rs.getString("divide"));
				offer.setCredit(rs.getInt("credit"));
				
				return offer;
			}
			
		});
	}
	
	public int getCreditBySemester(int take_year, int semester) {
		String sqlStatement = "select sum(credit) from offers where take_year=? and semester=?";
		
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {take_year, semester}, Integer.class);
	}
	
	public List<Offer> getDivideList() {
		String sqlStatement = "select distinct divide from offers";
		
		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offer offer = new Offer();

				offer.setDivide(rs.getString("divide"));
				
				return offer;
			}
		});
	}
	
	public int getCreditByDivide(String divide) {
		String sqlStatement = "select sum(credit) from offers where divide=? and take_year != 2018";
		
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {divide}, Integer.class);
	}
	
	public int getTotalCredit() {
		String sqlStatement = "select sum(credit) from offers where take_year != 2018";
		
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	public List<Offer> getRegisterOffer() {
		String sqlStatement = "select * from offers where take_year=2018 and semester=1";
		
		return jdbcTemplate.query(sqlStatement,new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offer offer = new Offer();
				
				offer.setTake_year(rs.getInt("take_year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setCourseName(rs.getString("courseName"));
				offer.setDivide(rs.getString("divide"));
				offer.setCredit(rs.getInt("credit"));
				
				return offer;
			}
		});
	}

}
