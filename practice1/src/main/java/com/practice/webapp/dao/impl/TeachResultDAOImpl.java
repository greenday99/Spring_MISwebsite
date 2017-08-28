package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.dao.Teach_ResultDAO;
import com.practice.webapp.entity.teachresult.*;

public class TeachResultDAOImpl implements Teach_ResultDAO {
	private DataSource dataSource;
	private Connection conn ;
	private ResultSet rs ;
	private PreparedStatement smt ;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Sym> getSymList() {
		List<Sym> symList = new ArrayList<Sym>();

		String sql = "SELECT * FROM symposium";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();

			while (rs.next()) {
				Sym sym = new Sym();
				sym.setSym_code(rs.getInt("SYM_CODE"));
				sym.setSym_name(rs.getString("SYM_NAME"));
				sym.setSym_time(rs.getDate("SYM_TIME"));
				sym.setSym_url(rs.getString("SYM_URL"));

				symList.add(sym);
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
		return symList;
	}

	public List<String> getGraYearList() {
		List<String> graYearList = new ArrayList<String>();

		String sql = "select distinct GRA_YEAR from graduation order by GRA_YEAR desc";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();

			while (rs.next()) {
				String year = rs.getString("GRA_YEAR");
				graYearList.add(year);
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
		return graYearList;
	}

	public List<Graduation> getGraduationList() {
		List<Graduation> graduationList = new ArrayList<Graduation>();

		String sql = "SELECT members.M_NAME, graduation.GRA_CODE, graduation.GRA_TITLE, "
				+ "graduation.GRA_YEAR, graduation.GRA_STUDENT, graduation.GRA_PATH, "
				+ "graduation.SecondTeacher FROM members, graduation "
				+ "where graduation.GRA_CODE LIKE '%IM%' AND members.M_LDAP = graduation.GRA_TEACHER "
				+ "ORDER BY graduation.GRA_YEAR DESC";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();

			while (rs.next()) {
				Graduation graduation = new Graduation();
				graduation.setGra_code(rs.getString("GRA_CODE"));
				graduation.setGra_year(rs.getString("GRA_YEAR"));
				graduation.setGra_title(rs.getString("GRA_TITLE"));
				graduation.setGra_teacher(rs.getString("M_NAME"));
				graduation.setGra_student(rs.getString("GRA_STUDENT"));

				graduationList.add(graduation);
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
		return graduationList;
	}

	public List<Graduation> getMasterPaperList() {
		List<Graduation> masterPaperList = new ArrayList<Graduation>();

		String sql = "SELECT members.M_NAME, graduation.GRA_CODE, graduation.GRA_TITLE, "
				+ "graduation.GRA_YEAR, graduation.GRA_STUDENT FROM members, graduation "
				+ "where graduation.GRA_CODE LIKE 'MB%' AND members.M_LDAP = graduation.GRA_TEACHER "
				+ "ORDER BY graduation.GRA_YEAR DESC;";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();

			while (rs.next()) {
				Graduation masterPaper = new Graduation();
				masterPaper.setGra_teacher(rs.getString("M_NAME"));
				masterPaper.setGra_code(rs.getString("GRA_CODE"));
				masterPaper.setGra_title(rs.getString("GRA_TITLE"));
				masterPaper.setGra_year(rs.getString("GRA_YEAR"));
				masterPaper.setGra_student(rs.getString("GRA_STUDENT"));

				masterPaperList.add(masterPaper);
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
		return masterPaperList;
	}

	public List<Graduation> getEMasterPaperList() {
		List<Graduation> eMasterPaperList = new ArrayList<Graduation>();

		String sql = "SELECT members.M_NAME, graduation.GRA_CODE, graduation.GRA_TITLE, "
				+ "graduation.GRA_YEAR, graduation.GRA_STUDENT FROM members, graduation "
				+ "where graduation.GRA_CODE LIKE 'EM%' AND members.M_LDAP = graduation.GRA_TEACHER "
				+ "ORDER BY graduation.GRA_YEAR DESC;";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();

			while (rs.next()) {
				Graduation eMasterPaper = new Graduation();
				eMasterPaper.setGra_teacher(rs.getString("M_NAME"));
				eMasterPaper.setGra_code(rs.getString("GRA_CODE"));
				eMasterPaper.setGra_title(rs.getString("GRA_TITLE"));
				eMasterPaper.setGra_year(rs.getString("GRA_YEAR"));
				eMasterPaper.setGra_student(rs.getString("GRA_STUDENT"));

				eMasterPaperList.add(eMasterPaper);
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
		return eMasterPaperList;
	}

	public List<Category> getMasterCategory() {
		List<Category> masterCategory = new ArrayList<Category>();

		String sql = "SELECT DC_CODE, DC_CLASS FROM division_class WHERE DIV_CODE='M'OR DIV_CODE='E'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setDcCode(rs.getString("DC_CODE"));
				category.setDcClass(rs.getString("DC_CLASS"));
				masterCategory.add(category);
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
		return masterCategory;
	}

	public List<String> getMasterPaperYear() {
		List<String> masterPaperYear = new ArrayList<String>();

		String sql = "select DISTINCT GRA_YEAR from graduation where "
				+ "graduation.GRA_CODE LIKE '%MB%' order by GRA_YEAR DESC";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				String year = rs.getString("GRA_YEAR");
				masterPaperYear.add(year);
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
		return masterPaperYear;
	}

	public List<String> getEMasterPaperYear() {
		List<String> eMasterPaperYear = new ArrayList<String>();

		String sql = "select DISTINCT GRA_YEAR from graduation where "
				+ "graduation.GRA_CODE LIKE '%EM%' order by GRA_YEAR DESC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				String year = rs.getString("GRA_YEAR");
				eMasterPaperYear.add(year);
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
		return eMasterPaperYear;
	}

	public List<Award> getAwardList() {
		List<Award> awardList = new ArrayList<Award>();

		String sql = "SELECT * FROM article WHERE ArticleID>0";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();

			while (rs.next()) {
				Award award = new Award();
				award.setArticleid(rs.getInt("ArticleID"));
				award.setArticlecontent(rs.getString("ArticleContent"));
				award.setArticleenglishcontent(rs.getString("ArticleEnglishContent"));
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
				} catch (SQLException e) {
				}
			}
		}
		return awardList;
	}

	public void insertSym(Sym sym) {
		// TODO Auto-generated method stub
		String sql = "INSERT symposium(SYM_CODE,SYM_NAME,SYM_TIME,SYM_URL) " + "VALUES(?,?,NOW(),?)";

		// String sql2 = "SELECT MAX(SYM_CODE) FROM symposium";
		// conn = dataSource.getConnection();
		// smt = conn.prepareStatement(sql2);
		// rs = smt.executeQuery();
		// int max = rs.getInt("SYM_CODE");

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, sym.getSym_code());
			smt.setString(2, sym.getSym_name());
			// smt.setDate(3, (Date) sym.getSym_time());
			smt.setString(3, sym.getSym_url());
			smt.executeUpdate();
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
	}

	@Override
	public void insertGraduation(Graduation graduation) {
		// TODO Auto-generated method stub
		String sql = "INSERT graduation(GRA_CODE,GRA_YEAR,GRA_TITLE,GRA_TEACHER,GRA_STUDENT,GRA_PATH,SecondTeacher) "
				+ "VALUES(?,?,?,?,?,?,?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, graduation.getGra_code());
			smt.setString(2, graduation.getGra_year());
			smt.setString(3, graduation.getGra_title());
			smt.setString(4, graduation.getGra_teacher());
			smt.setString(5, graduation.getGra_student());
			smt.setString(6, graduation.getGra_path());
			smt.setString(7, graduation.getSecondteacher());
			smt.executeUpdate();
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

	}

	@Override
	public void insertTea_stu_paper(Graduation paperInfo) {
		String sql = "INSERT graduation(GRA_CODE,GRA_YEAR,GRA_TITLE,GRA_TEACHER,GRA_STUDENT) " + "VALUES(?,?,?,?,?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, paperInfo.getGra_code());
			smt.setString(2, paperInfo.getGra_year());
			smt.setString(3, paperInfo.getGra_title());
			smt.setString(4, paperInfo.getGra_teacher());
			smt.setString(5, paperInfo.getGra_student());
			smt.executeUpdate();
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

	}

	@Override
	public void insertAward(Award award) {
		// TODO Auto-generated method stub
		String sql = "INSERT into article(ArticleID,ArticleContent,ArticleEnglishContent) VALUES(?,?,?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, award.getArticleid());
			smt.setString(2, award.getArticlecontent());
			smt.setString(3, award.getArticleenglishcontent());

			smt.executeUpdate();
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
	}

	@Override
	public void deleteSym(Sym sym) {
		String sql = "DELETE FROM symposium WHERE SYM_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, sym.getSym_code());
			smt.executeUpdate();
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

	}

	@Override
	public void deleteGraduation(Graduation graduation) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM graduation WHERE GRA_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, graduation.getGra_code());
			smt.executeUpdate();
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

	}

	@Override
	public void deleteTea_stu_paper(String paperid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM graduation WHERE GRA_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, paperid);
			smt.executeUpdate();
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
	}

	@Override
	public void deleteAward(Award award) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM article WHERE ArticleID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, award.getArticleid());
			smt.executeUpdate();
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
	}

	@Override
	public void updateSym(Sym sym) {
		// TODO Auto-generated method stub
		String sql = "UPDATE symposium SET SYM_CODE=?, SYM_NAME=?, SYM_TIME=now(), SYM_URL=? " + "WHERE SYM_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, sym.getSym_code());
			smt.setString(2, sym.getSym_name());
			smt.setString(3, sym.getSym_url());
			smt.setInt(4, (int) sym.getSym_code());
			smt.executeUpdate();
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

	}

	@Override
	public void updateGraduation(Graduation graduation) {
		// TODO Auto-generated method stub
		String sql = "UPDATE graduation SET GRA_CODE=?,GRA_YEAR=?,GRA_TITLE=?,GRA_TEACHER=?,GRA_STUDENT=?,GRA_PATH=?,SecondTeacher=? "
				+ "WHERE GRA_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, graduation.getGra_code());
			smt.setString(2, graduation.getGra_year());
			smt.setString(3, graduation.getGra_title());
			smt.setString(4, graduation.getGra_teacher());
			smt.setString(5, graduation.getGra_student());
			smt.setString(6, graduation.getGra_path());
			smt.setString(7, graduation.getSecondteacher());
			smt.setString(8, graduation.getGra_code());
			smt.executeUpdate();
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

	}

	@Override
	public void updateTea_stu_paper(Graduation info) {
		// TODO Auto-generated method stub
		String sql = "UPDATE graduation SET GRA_CODE = ?,GRA_YEAR = ?,GRA_TITLE = ?,GRA_TEACHER = ?,GRA_STUDENT =?"
				+ "WHERE GRA_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getGra_code());
			smt.setString(2, info.getGra_year());
			smt.setString(3, info.getGra_title());
			smt.setString(4, info.getGra_teacher());
			smt.setString(5, info.getGra_student());
			smt.setString(6, info.getGra_code());
			smt.executeUpdate();
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

	}

	@Override
	public void updateAward(Award award) {
		// TODO Auto-generated method stub
		String sql = "UPDATE article SET ArticleID=?,ArticleContent=?,ArticleEnglishContent=?  WHERE ArticleID = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, award.getArticleid());
			smt.setString(2, award.getArticlecontent());
			smt.setString(3, award.getArticleenglishcontent());
			smt.setInt(4, award.getArticleid());

			smt.executeUpdate();
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

	}

	@Override
	public Sym get(Sym sym) {
		String sql = "SELECT * FROM symposium WHERE SYM_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, sym.getSym_code());
			rs = smt.executeQuery();
			if (rs.next()) {
				sym.setSym_code(rs.getInt("SYM_CODE"));
				sym.setSym_name(rs.getString("SYM_NAME"));
				sym.setSym_url(rs.getString("SYM_URL"));
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

		return sym;
	}

	@Override
	public Graduation get(Graduation graduation) {
		String sql = "SELECT * FROM graduation WHERE GRA_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, graduation.getGra_code());
			rs = smt.executeQuery();
			if (rs.next()) {
				graduation.setGra_code(rs.getString("GRA_CODE"));
				graduation.setGra_year(rs.getString("GRA_YEAR"));
				graduation.setGra_title(rs.getString("GRA_TITLE"));
				graduation.setGra_teacher(rs.getString("GRA_TEACHER"));
				graduation.setGra_student(rs.getString("GRA_STUDENT"));
				graduation.setGra_path(rs.getString("GRA_PATH"));
				graduation.setSecondteacher(rs.getString("SecondTeacher"));
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

		return graduation;
	}

	@Override
	public Tea_stu_paper get(Tea_stu_paper tea_stu_paper) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tea_stu_paper WHERE PaperID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, tea_stu_paper.getPaperid());
			rs = smt.executeQuery();
			if (rs.next()) {
				tea_stu_paper.setPaperid(rs.getInt("PaperID"));
				tea_stu_paper.setTea_code(rs.getInt("TEA_CODE"));
				tea_stu_paper.setTea_stu_year(rs.getInt("TEA_STU_YEAR"));
				tea_stu_paper.setTea_stu_name(rs.getString("TEA_STU_NAME"));
				tea_stu_paper.setTea_stu_paper_name(rs.getString("TEA_STU_PAPER_NAME"));
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
		return tea_stu_paper;
	}

	@Override
	public Award get(Award award) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM article WHERE ArticleID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, award.getArticleid());
			rs = smt.executeQuery();
			if (rs.next()) {
				award.setArticleid(rs.getInt("ArticleID"));
				award.setArticlecontent(rs.getString("ArticleContent"));
				award.setArticleenglishcontent(rs.getString("ArticleEnglishContent"));
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
		return award;
	}

	@Override
	public Sym getSym(int sym_code) {
		Sym out = new Sym();

		String sql = "SELECT * FROM symposium where SYM_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, sym_code);
			rs = smt.executeQuery();
			if (rs.next()) {
				out.setSym_code(rs.getInt("SYM_CODE"));
				out.setSym_name(rs.getString("SYM_NAME"));
				// out.setSym_time(rs.getDate("SYM_TIME"));
				out.setSym_url(rs.getString("SYM_URL"));
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
		return out;
	}

	@Override
	public Graduation getGraduation(String gra_code) {
		Graduation out = new Graduation();
		String sql = "SELECT * FROM graduation where GRA_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, gra_code);
			rs = smt.executeQuery();
			if (rs.next()) {
				out.setGra_code(rs.getString("GRA_CODE"));
				out.setGra_year(rs.getString("GRA_YEAR"));
				out.setGra_title(rs.getString("GRA_TITLE"));
				out.setGra_teacher(rs.getString("GRA_TEACHER"));
				out.setGra_student(rs.getString("GRA_STUDENT"));
				out.setGra_path(rs.getString("GRA_PATH"));
				out.setSecondteacher(rs.getString("SecondTeacher"));
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
		return out;
	}

	@Override
	public Graduation getTea_stu_paper(String paperid) {
		Graduation out = new Graduation();
		String sql = "SELECT * FROM graduation where GRA_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, paperid);
			rs = smt.executeQuery();
			if (rs.next()) {
				out.setGra_code(rs.getString("GRA_CODE"));
				out.setGra_student(rs.getString("GRA_STUDENT"));
				out.setGra_year(rs.getString("GRA_YEAR"));
				out.setGra_teacher(rs.getString("GRA_TEACHER"));
				out.setGra_title(rs.getString("GRA_TITLE"));
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
		return out;
	}

	@Override
	public Award getAward(int articleid) {
		Award out = new Award();
		String sql = "SELECT * FROM article where ArticleID = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, articleid);
			rs = smt.executeQuery();
			if (rs.next()) {
				out.setArticleid(rs.getInt("ArticleID"));
				out.setArticlecontent(rs.getString("ArticleContent"));
				out.setArticleenglishcontent(rs.getString("ArticleEnglishContent"));
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
		return out;
	}

}
