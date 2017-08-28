package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.dao.NewsDAO;
import com.practice.webapp.entity.news.Bulletin;

public class NewsDAOImpl implements NewsDAO{
	private DataSource dataSource;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement smt;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/*最新消息list*/
	public List<Bulletin> getNewsList(){
		List<Bulletin> getNewsList = new ArrayList<Bulletin>();
		String sql = "select * from speak_type, bulletin "
				+ "where speak_type.S_CODE = bulletin.BU_S_CODE "
				+ "order by PUBLISH_TIME desc";			
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
	
	/*細項最新消息list*/
	public List<Bulletin> getNewsBranchList(Bulletin bulletin){
		List<Bulletin> getNewsList = new ArrayList<Bulletin>();
		String sql = "select * from speak_type, bulletin "
				+ "where speak_type.S_CODE = bulletin.BU_S_CODE and S_CODE=?"
				+ "order by PUBLISH_TIME desc";			
		try{
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, bulletin.getsCode());
			rs = smt.executeQuery();
			while(rs.next()){
				Bulletin bulletintmp = new Bulletin();
				bulletintmp.setBuCont(rs.getString("BU_CONT"));
				bulletintmp.setBuSCode(rs.getString("BU_S_CODE"));
				bulletintmp.setBuTitle(rs.getString("BU_TITLE"));
				bulletintmp.setPublishTime(rs.getDate("PUBLISH_TIME"));
				bulletintmp.setsCode(rs.getString("S_CODE"));
				bulletintmp.setsName(rs.getString("S_NAME"));
				bulletintmp.setBuCode(rs.getString("BU_CODE"));
				getNewsList.add(bulletintmp);
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
	
	/*附件list*/
	public List<Bulletin> getFileList(Bulletin bulletin){
		List<Bulletin> getFileList = new ArrayList<Bulletin>();
		String sql = "select * from bulletin, upload "
				+ "where bulletin.BU_CODE = upload.UPLOAD_CODE "
				+ "and BU_CODE=?";		
		try{
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, bulletin.getBuCode());
			rs = smt.executeQuery();
			while(rs.next()){
				Bulletin bulletintmp = new Bulletin();
				bulletintmp.setFileCode(rs.getString("FILE_CODE"));
				bulletintmp.setUpload(rs.getString("UPLOAD"));
				getFileList.add(bulletintmp);
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
		return getFileList;
	}
	
	/*消息細節*/
	public Bulletin getNewsDetail(Bulletin bulletin){
		Bulletin bulletintmp = new Bulletin();
		String sql = "select * from speak_type, bulletin "
				+ "where speak_type.S_CODE = bulletin.BU_S_CODE and BU_CODE = ? ";
		try{
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, bulletin.getBuCode());
			rs = smt.executeQuery();
			while(rs.next()){			
				bulletintmp.setBuCont(rs.getString("BU_CONT"));
				bulletintmp.setBuSCode(rs.getString("BU_S_CODE"));
				bulletintmp.setBuTitle(rs.getString("BU_TITLE"));
				bulletintmp.setPublishTime(rs.getDate("PUBLISH_TIME"));
				bulletintmp.setsCode(rs.getString("S_CODE"));
				bulletintmp.setsName(rs.getString("S_NAME"));
				bulletintmp.setBuCode(rs.getString("BU_CODE"));
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
		return bulletintmp;
	}
	
	/*修改公告*/
	public void newsUpdate(Bulletin bulletin){
		String sql = "update bulletin set BU_TITLE=?, BU_CONT=?, BU_S_CODE=? where BU_CODE=?";
		try{
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, bulletin.getBuTitle());
			smt.setString(2, bulletin.getBuCont());
			smt.setString(3, bulletin.getsCode());
			smt.setString(4, bulletin.getBuCode());
			smt.executeUpdate();			
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
	}
	
	/*新增公告*/
	public void newsInsert(Bulletin bulletin){
		String sql = "insert into bulletin(BU_CODE,BU_CLASS_CODE,BU_TITLE,LDAP,PUBLISH_TIME,BU_CONT,BU_S_CODE) "
				+ "values(now(),'D',?,'admin',now(),?,?)";

		try{
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, bulletin.getBuTitle());
			smt.setString(2, bulletin.getBuCont());
			smt.setString(3, bulletin.getsCode());
			smt.executeUpdate();			
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
	}
	
	/*刪除公告*/
	public void newsDelete(Bulletin bulletin){
		String sql = "delete b, u from bulletin b inner join upload u on BU_CODE=UPLOAD_CODE "
				+ "where BU_CODE=?";
		String sql2 = "delete from bulletin where BU_CODE=?";
		try{
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, bulletin.getBuCode());
			smt.executeUpdate();			
			smt.close();
			
			PreparedStatement smt2 = null ;
			smt2 = conn.prepareStatement(sql2);
			smt2.setString(1, bulletin.getBuCode());
			smt2.executeUpdate();			
			smt2.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}	
	}
	
	/*新增附件*/
	public void fileInsert(List<String> fileNames){			
		int size = fileNames.size();
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
				for(int i=0; i<size; i++){
					String sql = "INSERT INTO  upload(UPLOAD_CODE,FILE_CODE,UPLOAD,UPLOAD_CLASS,FILE_CLASS) "
							+ "values(now(),?,?,1,1)";
					smt = conn.prepareStatement(sql);
					smt.setString(1, Integer.toString(i+1));
					smt.setString(2, fileNames.get(i));
					smt.executeUpdate();
					smt.close();
				}	
			conn.commit();
		}  catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public boolean fileNameCheck(List<String> fileNames){
		boolean flag = true;
		String sql = "select * from upload";		
		try{
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				for(int i=0; i<fileNames.size(); i++)
					if( fileNames.get(i).equals(rs.getString("UPLOAD")))
						flag = false;
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
		return flag;
	}
}
