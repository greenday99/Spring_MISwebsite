package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.dao.CourseruleDAO;
import com.practice.webapp.entity.course.Courserule;

public class CourseruleDAOImpl implements CourseruleDAO{
	
	private DataSource dataSource;
	private Connection conn ;
	private ResultSet rs ;
	private PreparedStatement smt ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Courserule> getCourseruleList() {
		// TODO Auto-generated method stub
		List<Courserule> courseruleList = new ArrayList<Courserule>();
		String sql = "SELECT * FROM article WHERE ArticleID = 1";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Courserule courserule = new Courserule();
				courserule.setArticleid(rs.getInt("ArticleID"));
				courserule.setArticlecontent(rs.getString("ArticleContent"));
				courseruleList.add(courserule);
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return courseruleList;
		
	}
}
