package com.practice.webapp.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import com.practice.webapp.dao.ImintroDAO;
import com.practice.webapp.entity.introduction.Assitant;
import com.practice.webapp.entity.introduction.AssitantWork;
import com.practice.webapp.entity.introduction.Award;
import com.practice.webapp.entity.introduction.Imintro;
import com.practice.webapp.entity.introduction.NewInfoGu;




public class ImintroDAOImpl implements ImintroDAO{
	private DataSource dataSource;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement smt;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}



	public List<Imintro> getList(Imintro imintro) {
		List<Imintro> imintroList = new ArrayList<Imintro>();
		String sql = "SELECT * from department_introduction_class where DI_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, imintro.getDi_code());
			rs = smt.executeQuery();
			while(rs.next()){
				Imintro imintro2 = new Imintro();
				imintro2.setDi_code(rs.getString("DI_CODE"));
				imintro2.setDic_code(rs.getString("DIC_CODE"));
				imintro2.setDic_name(rs.getString("DIC_NAME"));
				imintro2.setDic_cont(rs.getString("DIC_CONT"));
				imintroList.add(imintro2);
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
		return imintroList;
	}
		


	public Imintro get(Imintro imintro) {
		String sql = "SELECT DI_CODE, DIC_CODE, DIC_NAME, DIC_CONT from department_introduction_class where DI_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, imintro.getDi_code());
			rs = smt.executeQuery();
			if(rs.next()){
				imintro.setDi_code(rs.getString("DI_CODE"));
				imintro.setDic_code(rs.getString("DIC_CODE"));
				imintro.setDic_name(rs.getString("DIC_NAME"));
				imintro.setDic_cont(rs.getString("DIC_CONT"));
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
		return imintro;
	}



	public Imintro gettwo(Imintro imintro, String dic_code) {
		Imintro imintro2 = new Imintro();
		String sql = "SELECT * FROM department_introduction_class where DI_CODE = ? AND DIC_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, imintro.getDi_code());
			smt.setString(2, dic_code);
			rs = smt.executeQuery();
			while(rs.next()){ 				
				imintro2.setDi_code(rs.getString("DI_CODE"));
				imintro2.setDic_code(rs.getString("DIC_CODE"));
				imintro2.setDic_name(rs.getString("DIC_NAME"));
				imintro2.setDic_cont(rs.getString("DIC_CONT"));
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
		return imintro2;
	}
	
	public Imintro getthree(Imintro imintro, String dic_code) {
		String sql = "SELECT * from department_introduction_class where DI_CODE = ? AND DIC_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, imintro.getDi_code());
			smt.setString(2, dic_code);
			rs = smt.executeQuery();
			if(rs.next()){ 
				imintro.setDi_code(rs.getString("DI_CODE"));
				imintro.setDic_code(rs.getString("DIC_CODE"));
				imintro.setDic_name(rs.getString("DIC_NAME"));
				imintro.setDic_cont(rs.getString("DIC_CONT"));
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
		return imintro;
	}

	
	public List<Assitant> getassitantList() {
		List<Assitant> assitantList = new ArrayList<Assitant>();
		String sql = "SELECT teacher.TEA_LDAP,teacher.TEA_CODE,teacher.TEA_PHOTO,teacher.TEA_EN_NAME,members.M_NAME,class_post.POST_NAME,members.M_LDAP,members.M_PHONE,members.M_EMAIL,teacher.Location,members.M_DEP_CODE,teacher.TEA_SORT,teacher.TeacherType FROM teacher,members,class_post,members_class WHERE"
				+ " teacher.TEA_LDAP = members.M_LDAP"
				+ " AND members.M_LDAP = members_class.M_LDAP"
				+ " AND members_class.M_POST_CODE = class_post.POST_CODE"
				//+ " AND teacher.TEA_CODE = asistantwork.TeacherCode"
				+ " AND class_post.POST_CODE NOT LIKE 'DQ'"
				+ " AND class_post.POST_CODE NOT LIKE 'DD'"
				+ " AND class_post.POST_CODE NOT LIKE 'DZ'"
				+ " AND class_post.POST_CODE NOT LIKE 'DR'"
				+ " AND class_post.POST_CODE NOT LIKE 'DA'"
				+ " AND class_post.POST_CODE NOT LIKE 'DS'"
				+ " AND class_post.POST_CODE NOT LIKE 'DT'"	
				+ " AND teacher.TeacherType LIKE 'C'"
				+ " ORDER BY teacher.TEA_SORT";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();

			while(rs.next()){
				Assitant assitant = new Assitant();
				assitant.setM_name(rs.getString("M_NAME"));
				assitant.setTea_en_name(rs.getString("TEA_EN_NAME"));
				assitant.setM_phone(rs.getString("members.M_PHONE"));
				assitant.setM_email(rs.getString("M_EMAIL"));
				assitant.setLocation(rs.getString("Location"));
				assitant.setTea_photo(rs.getString("TEA_PHOTO"));
				assitant.setPost_name(rs.getString("POST_NAME"));
				assitant.setTea_code(rs.getInt("TEA_CODE"));
				assitant.setM_ldap(rs.getString("teacher.TEA_LDAP"));
				
				String sql2 = "SELECT * FROM asistantwork WHERE TeacherCode = ?";
				PreparedStatement smt2 = conn.prepareStatement(sql2);
				smt2.setInt(1, assitant.getTea_code());
				ResultSet rs2 = smt2.executeQuery();				
				List<AssitantWork> work2 = new ArrayList<AssitantWork>();
				while(rs2.next()){			
					AssitantWork work = new AssitantWork();
					work.setTeachercode(rs2.getInt("TeacherCode"));
					work.setWorkContent(rs2.getString("AsistantWorkContent"));					
					work2.add(work);
	
				}
				
				assitant.setAssitantworkList(work2);				
				assitantList.add(assitant);
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
		return assitantList;
	}
	
	public List<Imintro> getAll() {
		List<Imintro> imintroList = new ArrayList<Imintro>();
		String sql = "SELECT * from department_introduction_class, department_introduction where department_introduction_class.DI_CODE = department_introduction.DI_CODE ORDER BY department_introduction.DI_CODE";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Imintro imintro = new Imintro();
				imintro.setDi_code(rs.getString("DI_CODE"));
				imintro.setDi_name(rs.getString("DI_NAME"));
				imintro.setDic_code(rs.getString("DIC_CODE"));
				imintro.setDic_name(rs.getString("DIC_NAME"));
				imintro.setDic_cont(rs.getString("DIC_CONT"));
				imintroList.add(imintro);
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
		return imintroList;
	}
	
	public List<AssitantWork> getassitantWorkList(Assitant assitant) {
		List<AssitantWork> assitantWorkList = new ArrayList<AssitantWork>();
		String sql = "SELECT * FROM asistantwork WHERE TeacherCode = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, assitant.getTea_code());
			rs = smt.executeQuery();
			
			while(rs.next()){
				AssitantWork assitantWork = new AssitantWork();
				assitantWork.setTeachercode(rs.getInt("TeacherCode"));
				assitantWork.setWorkContent(rs.getString("AsistantWorkContent"));
				assitantWork.setAsistantWorkID(rs.getInt("AsistantWorkID"));
				assitantWorkList.add(assitantWork);
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
		return assitantWorkList;
	}


	public List<Award> getawardList() {
		List<Award> awardList = new ArrayList<Award>();
		String sql = "SELECT * FROM award_cont, award_record WHERE award_cont.AR_CODE = award_record.AR_CODE";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Award award = new Award();
				award.setAr_code(rs.getString("award_cont.AR_CODE"));
				award.setAr_title(rs.getString("AR_TITLE"));
				award.setAward_cont(rs.getString("AWARD_CONT"));				
				awardList.add(award);
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
		return awardList;
	}
	
	public List<Imintro> getfile(Imintro imintro) {
		List<Imintro> getfileList = new ArrayList();
		String sql = "SELECT * from department_introduction_file where DI_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, imintro.getDi_code());
			rs = smt.executeQuery();
			while(rs.next()){
				Imintro imintro5 = new Imintro();
				imintro5.setFile_code(rs.getInt("FILE_CODE"));
				imintro5.setFile_url(rs.getString("FILE_URL"));
				imintro5.setDi_code(rs.getString("DI_CODE"));
				getfileList.add(imintro5);
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
		return getfileList;
	}
	
	public List<Imintro> getDeptIntro() {
		List<Imintro> deptIntroList = new ArrayList<Imintro>();
		String sql = "SELECT * from department_introduction";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Imintro imintro = new Imintro();
				imintro.setDi_code(rs.getString("DI_CODE"));
				imintro.setDi_name(rs.getString("DI_NAME"));
				deptIntroList.add(imintro);
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
		return deptIntroList;
	}
	
	public Imintro getdiccont(Imintro imintro) {
		Imintro imintro5 = new Imintro();
		String sql = "SELECT * from department_introduction_class where DI_CODE = ? AND DIC_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, imintro.getDi_code());
			smt.setString(2, imintro.getDic_code());
			rs = smt.executeQuery();
			while(rs.next()){				
				imintro5.setDi_code(rs.getString("DI_CODE"));
				imintro5.setDic_name(rs.getString("DIC_NAME"));
				imintro5.setDic_cont(rs.getString("DIC_CONT"));
				imintro5.setDic_code(rs.getString("DIC_CODE"));
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
		return imintro5;
	}
	
	public void update(Imintro imintro) {
		String sql = "UPDATE department_introduction_class SET DIC_CONT=? WHERE DI_CODE = ? AND DIC_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, imintro.getDic_cont());
			smt.setString(2, imintro.getDi_code());
			smt.setString(3, imintro.getDic_code());
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
	
	public void delete(Imintro imintro) {
		String sql = "DELETE FROM department_introduction_class WHERE DI_CODE = ? AND DIC_CODE = ?";
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, imintro.getDi_code());
			smt.setString(2, imintro.getDic_code());
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
	
	public void insert(Imintro imintro) {
		String sql = "INSERT department_introduction_class(DI_CODE,DIC_CODE,DIC_NAME,DIC_CONT,DIC_CONT_EN)"
				+ "VALUES(?,?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, imintro.getDi_code());
			smt.setString(2, imintro.getDic_code());
			smt.setString(3, imintro.getDic_name());
			smt.setString(4, imintro.getDic_cont());
			smt.setString(5, imintro.getDic_cont_en());
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
	
	public void updateaward(Award award) {
		String sql = "UPDATE award_cont SET AWARD_CONT = ? WHERE AR_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, award.getAward_cont());
			smt.setString(2, award.getAr_code());
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
	
	public Award getaward(Award award) {
		Award award1 = new Award();
		String sql = "SELECT * FROM award_cont, award_record WHERE award_cont.AR_CODE = award_record.AR_CODE AND award_cont.AR_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, award.getAr_code());
			rs = smt.executeQuery();
			while(rs.next()){
				award1.setAward_cont(rs.getString("AWARD_CONT"));
				award1.setAr_title(rs.getString("AR_TITLE"));
				award1.setAr_code(rs.getString("AR_CODE"));
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
		return award1;
	}
	
	public void updateass(Assitant assitant) {
		String sql = "UPDATE members SET M_EMAIL=?, M_PHONE=?, M_NAME=? WHERE M_LDAP = ?";
		String sql2 = "UPDATE members_class SET M_POST_CODE = ? WHERE M_LDAP = ?";
		String sql3 = "UPDATE teacher SET Location = ? WHERE TEA_LDAP = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, assitant.getM_email());
			smt.setString(2, assitant.getM_phone());
			smt.setString(3, assitant.getM_name());
			smt.setString(4, assitant.getM_ldap());
			smt.executeUpdate();			
			smt.close();
			
			PreparedStatement smt2 = null ;
			smt2 = conn.prepareStatement(sql2);
			smt2.setString(1, assitant.getPost_name());
			smt2.setString(2, assitant.getM_ldap());
			smt2.executeUpdate();			
			smt2.close();
			
			PreparedStatement smt3 = null ;
			smt3 = conn.prepareStatement(sql3);
			smt3.setString(1, assitant.getLocation());
			smt3.setString(2, assitant.getM_ldap());
			smt3.executeUpdate();			
			smt3.close();
			
 
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
	
	public Assitant getass(Assitant assitant) {
		Assitant assitant1 = new Assitant();
		String sql = "SELECT teacher.TEA_LDAP,teacher.TEA_CODE,teacher.TEA_PHOTO,teacher.TEA_EN_NAME,members.M_NAME,class_post.POST_NAME,members.M_LDAP,members.M_PHONE,members.M_EMAIL,teacher.Location,members.M_DEP_CODE,teacher.TEA_SORT,teacher.TeacherType FROM teacher,members,class_post,members_class WHERE"
				+ " teacher.TEA_LDAP = members.M_LDAP"
				+ " AND members.M_LDAP = members_class.M_LDAP"
				+ " AND members_class.M_POST_CODE = class_post.POST_CODE"
				//+ " AND teacher.TEA_CODE = asistantwork.TeacherCode"
				+ " AND class_post.POST_CODE NOT LIKE 'DQ'"
				+ " AND class_post.POST_CODE NOT LIKE 'DD'"
				+ " AND class_post.POST_CODE NOT LIKE 'DZ'"
				+ " AND class_post.POST_CODE NOT LIKE 'DR'"
				+ " AND class_post.POST_CODE NOT LIKE 'DA'"
				+ " AND class_post.POST_CODE NOT LIKE 'DS'"
				+ " AND class_post.POST_CODE NOT LIKE 'DT'"	
				+ " AND teacher.TeacherType LIKE 'C'"
				+ " AND members.M_LDAP = ?"
				+ " ORDER BY teacher.TEA_SORT";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, assitant.getM_ldap());
			rs = smt.executeQuery();
			while(rs.next()){

				assitant1.setM_name(rs.getString("M_NAME"));
				assitant1.setM_phone(rs.getString("members.M_PHONE"));
				assitant1.setM_email(rs.getString("M_EMAIL"));
				assitant1.setLocation(rs.getString("Location"));
				assitant1.setTea_photo(rs.getString("TEA_PHOTO"));
				assitant1.setPost_name(rs.getString("POST_NAME"));
				assitant1.setTea_code(rs.getInt("TEA_CODE"));
				assitant1.setM_ldap(rs.getString("teacher.TEA_LDAP"));

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
		return assitant1;
	}
	
	public void updateworkcontent(AssitantWork assitantWork) {
		String sql = "UPDATE asistantwork SET AsistantWorkContent = ? WHERE AsistantWorkID = ? AND TeacherCode = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);			
			smt.setString(1, assitantWork.getWorkContent());
			smt.setInt(3, assitantWork.getTeachercode());
			smt.setInt(2, assitantWork.getAsistantWorkID());
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
	
	public AssitantWork getassitantWork(Assitant assitant) {
		int teacode = assitant.getTea_code();
		AssitantWork assitantwork2 = new AssitantWork();
		assitantwork2.setTeachercode(teacode);
		return assitantwork2;
	}
	
	public void insertworkcontent(AssitantWork assitantWork) {
		String sql = "INSERT asistantwork(TeacherCode, AsistantWorkContent, AsistantWorkID)"
				+ "VALUES(?,?,?)";
		int id = newAssID();

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, assitantWork.getTeachercode());
			smt.setString(2, assitantWork.getWorkContent());
			smt.setInt(3, id);
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
	
	public void insertass(List<String> fileNames,NewInfoGu newInfo) {
		String sql1 = "insert into teacher(TEA_CODE, TeacherType, TEA_EN_NAME, TEA_PHOTO, "
				+ "TEA_LDAP, TEA_SORT, TEA_ABLE, Location) values(?,?,?,?,?,?,?,?)";
		String sql2 = "insert into members(M_LDAP, M_PASSWORD, M_NAME, M_DEP_CODE, M_PHONE, M_EMAIL) "
				+ "values(?,'test',?,'1',?,?)";
		String sql3 = "insert into members_class(M_LDAP, M_POST_CODE) values(?,?)";

		String teaCode = newTeaCode();
		String teaSort = newTeaSort(newInfo);

		try {
			PreparedStatement smt1 = null;
			PreparedStatement smt2 = null;
			PreparedStatement smt3 = null;
			conn = dataSource.getConnection();
			smt1 = conn.prepareStatement(sql1);
			smt1.setString(1, teaCode);
			smt1.setString(2, newInfo.getTeaType());
			smt1.setString(3, newInfo.getTeaENName());
			smt1.setString(4, (String)fileNames.get(0));
			smt1.setString(5, newInfo.getTeaLDAP());
			smt1.setString(6, teaSort);
			smt1.setString(7, "1");
			smt1.setString(8, newInfo.getTeaLoc());
			smt1.executeUpdate();
			smt1.close();

			smt2 = conn.prepareStatement(sql2);
			smt2.setString(1, newInfo.getTeaLDAP());
			smt2.setString(2, newInfo.getTeaName());
			smt2.setString(3, newInfo.getTeaTel());
			smt2.setString(4, newInfo.getTeaEmail());
			smt2.executeUpdate();
			smt2.close();

			smt3 = conn.prepareStatement(sql3);
			smt3.setString(1, newInfo.getTeaLDAP());
			smt3.setString(2, newInfo.getTeaPos());
			smt3.executeUpdate();
			smt3.close();


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
	
	// 自動產生一個新的教師編號
	private String newTeaCode() {
		String teaCode = "";
		String sql = "select max(TEA_CODE) as TEA_CODE from teacher";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				int i = rs.getInt("TEA_CODE");
				i++;
				teaCode = Integer.toString(i);
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
		return teaCode;
	}

	// 自動產生一個新的教師排序編號，先統一生成該教師類別中的最大值，再通過“更改排序”按鈕進行修改
	private String newTeaSort(NewInfoGu newInfo) {
		String teaSort = "";
		String sql = "select max(TEA_SORT) as TEA_SORT from teacher, members_class where Teachertype=?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, newInfo.getTeaType());
			rs = smt.executeQuery();
			if (rs.next()) {
				int i = rs.getInt("TEA_SORT");
				i++;
				teaSort = Integer.toString(i);
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

		return teaSort;
	}
		
	// 自動產生一個新的AsistantID編號
	private int newAssID() {
		int assID = 0;
		String sql = "select max(AsistantWorkID) as AsistantWorkID from asistantwork";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				int i = rs.getInt("AsistantWorkID");
				i++;
				assID = i;
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
		return assID;
	}
				
	public void updatepic(List<String> fileNames, Assitant assitant){			
		String sql = "UPDATE teacher SET TEA_PHOTO = ? WHERE TEA_LDAP = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, fileNames.get(0));
			smt.setString(2, assitant.getM_ldap());
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
	
	public void updatexidafile(List<String> fileNames, Imintro imintro){			
		String sql = "UPDATE department_introduction_file SET FIlE_URL = ? WHERE DI_CODE = ? AND FILE_CODE =?";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);			
			smt.setString(1, fileNames.get(0));
			smt.setString(2, imintro.getDi_code());
			smt.setInt(3, imintro.getFile_code());
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
	
	public void uploadfile(List<String> fileNames, Imintro imintro){			
		String sql = "INSERT department_introduction_file VALUES(?,?,?,?,1)";		
		int newFileCode = newFileCode(); 		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, imintro.getDi_code());
			smt.setString(2, imintro.getDic_code());
			smt.setInt(3, newFileCode);
			smt.setString(4, fileNames.get(0));
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
	
	// 自動產生一個新的檔案編號
	private int newFileCode() {
		String code = "";
		int intcode = 0;
		String sql = "select max(FILE_CODE) as FILE_CODE from department_introduction_file";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				int i = rs.getInt("FILE_CODE");
				i++;
				code = Integer.toString(i);
				intcode += Integer.parseInt(code); //將字串轉int
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
		return intcode;
	}
}
