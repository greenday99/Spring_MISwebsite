package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.dao.LoginDAO;
import com.practice.webapp.entity.login.Account;
import com.practice.webapp.entity.news.Bulletin;

public class LoginDAOImpl implements LoginDAO {

	private DataSource dataSource;
	private Connection conn ;
	private ResultSet rs ;
	private PreparedStatement smt ;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean checkLogin(Account login) {
		boolean flag = false;
		String sql = "select user, pwd from login where user = ? and pwd = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1,login.getUserName());
			smt.setString(2, login.getPassword());
			rs = smt.executeQuery();
			if(rs.next()){
				flag = true;
			}
			rs.close();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return flag;
	}

	/*Homepage³Ì·s®ø®§list*/
	public List<Bulletin> getHomeNews(){
		List<Bulletin> getNewsList = new ArrayList<Bulletin>();
		String sql = "select * from speak_type, bulletin "
				+ "where speak_type.S_CODE = bulletin.BU_S_CODE "
				+ "order by PUBLISH_TIME desc "
				+ "LIMIT 5";
			
		try{
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Bulletin bulletin = new Bulletin();
				bulletin.setBuCont(rs.getString("BU_CONT"));
				bulletin.setBuSCode(rs.getString("BU_S_CODE"));
				bulletin.setBuTitle(rs.getString("BU_TITLE"));
				bulletin.setPublishTime(rs.getDate("PUBLISH_TIME"));
				bulletin.setsCode(rs.getString("S_CODE"));
				bulletin.setsName(rs.getString("S_NAME"));
				bulletin.setBuCode(rs.getString("BU_CODE"));
				getNewsList.add(bulletin);
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
		return getNewsList;
	}

}
