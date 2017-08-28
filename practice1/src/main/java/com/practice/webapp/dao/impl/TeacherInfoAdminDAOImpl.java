package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.dao.TeacherInfoAdminDAO;
import com.practice.webapp.entity.teacher.RankInfo;
import com.practice.webapp.entity.teacher.ResearchTeacher;
import com.practice.webapp.entity.teacher.TeacherAwardInfo;
import com.practice.webapp.entity.teacher.TeacherBasicInfoAdmin;
import com.practice.webapp.entity.teacher.TeacherEduInfo;
import com.practice.webapp.entity.teacher.TeacherExpInfo;
import com.practice.webapp.entity.teacher.TeacherOtherInfo;
import com.practice.webapp.entity.teacher.TeacherPlanInfo;
import com.practice.webapp.entity.teacher.TeacherSpeInfo;
import com.practice.webapp.entity.teacher.TeacherStuPaper;
import com.practice.webapp.entity.teacher.TeacherStuTopic;

public class TeacherInfoAdminDAOImpl implements TeacherInfoAdminDAO {

	private DataSource dataSource;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement smt;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// 獲取專任教師基本信息列表
	@Override
	public List<TeacherBasicInfoAdmin> getProTeacherInfoList() {
		String sql = "select teacher.TEA_PHOTO, teacher.TEA_CODE, teacher.TEA_LDAP, "
				+ "members.M_NAME, teacher.TEA_EN_NAME, class_post.POST_NAME, "
				+ "members.M_PHONE, members.M_EMAIL, teacher.Location, teacher.TEA_ABLE "
				+ "from teacher, members, class_post, members_class " + "where "
				+ "teacher.TEA_LDAP = members.M_LDAP and " + "members.M_LDAP = members_class.M_LDAP and "
				+ "members_class.M_POST_CODE = class_post.POST_CODE and " + "class_post.POST_CODE not like 'DB' and "
				+ "class_post.POST_CODE not like 'DC' and " + "class_post.POST_CODE not like 'AA' and "
				+ "teacher.TeacherType like 'T' " + "order by teacher.TEA_ABLE desc, teacher.TEA_SORT";
		return getList(sql);
	}

	// 獲取兼任教師基本信息列表
	@Override
	public List<TeacherBasicInfoAdmin> getPartTeacherInfoList() {
		String sql = "select teacher.TEA_PHOTO, teacher.TEA_CODE, teacher.TEA_LDAP, "
				+ "members.M_NAME, teacher.TEA_EN_NAME, class_post.POST_NAME, "
				+ "members.M_PHONE, members.M_EMAIL, teacher.Location, teacher.TEA_ABLE "
				+ "from teacher, members, class_post, members_class " + "where "
				+ "teacher.TEA_LDAP = members.M_LDAP and " + "members.M_LDAP = members_class.M_LDAP and "
				+ "members_class.M_POST_CODE = class_post.POST_CODE and " + "class_post.POST_CODE not like 'DB' and "
				+ "class_post.POST_CODE not like 'DC' and " + "class_post.POST_CODE not like 'AA' and "
				+ "teacher.TeacherType like 'B' " + "order by teacher.TEA_ABLE desc, teacher.TEA_SORT";
		return getList(sql);
	}

	private List<TeacherBasicInfoAdmin> getList(String sql) {
		List<TeacherBasicInfoAdmin> infoList = new ArrayList<TeacherBasicInfoAdmin>();

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherBasicInfoAdmin info = new TeacherBasicInfoAdmin();
				info.setTeaPic(rs.getString("TEA_PHOTO"));
				info.setTeaCode(rs.getString("TEA_CODE"));
				info.setTeaLDAP(rs.getString("TEA_LDAP"));
				info.setTeaName(rs.getString("M_NAME"));
				info.setTeaENName(rs.getString("TEA_EN_NAME"));
				info.setTeaPos(rs.getString("POST_NAME"));
				info.setTeaTel(rs.getString("M_PHONE"));
				info.setTeaEmail(rs.getString("M_EMAIL"));
				info.setTeaLoc(rs.getString("Location"));
				info.setTeaAble(rs.getString("TEA_ABLE"));
				infoList.add(info);
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
		return infoList;
	}

	// 獲取搜索專任教師結果列表
	@Override
	public List<TeacherBasicInfoAdmin> getSearchProTeacherInfoList(ResearchTeacher researchInfo) {
		String sql = "select teacher.TEA_PHOTO, teacher.TEA_CODE, teacher.TEA_LDAP, "
				+ "members.M_NAME, teacher.TEA_EN_NAME, class_post.POST_NAME, "
				+ "members.M_PHONE, members.M_EMAIL, teacher.Location, teacher.TEA_ABLE "
				+ "from teacher, members, class_post, members_class " + "where "
				+ "teacher.TEA_LDAP = members.M_LDAP and " + "members.M_LDAP = members_class.M_LDAP and "
				+ "members_class.M_POST_CODE = class_post.POST_CODE and teacher.TeacherType like 'T' and "
				+ researchInfo.getKey() + " like ? " + "order by teacher.TEA_ABLE desc, teacher.TEA_SORT";
		return getResearchList(sql, researchInfo);
	}

	// 獲取搜索兼任教師結果列表
	@Override
	public List<TeacherBasicInfoAdmin> getSearchPartTeacherInfoList(ResearchTeacher researchInfo) {
		String sql = "select teacher.TEA_PHOTO, teacher.TEA_CODE, teacher.TEA_LDAP, "
				+ "members.M_NAME, teacher.TEA_EN_NAME, class_post.POST_NAME, "
				+ "members.M_PHONE, members.M_EMAIL, teacher.Location, teacher.TEA_ABLE "
				+ "from teacher, members, class_post, members_class " + "where "
				+ "teacher.TEA_LDAP = members.M_LDAP and " + "members.M_LDAP = members_class.M_LDAP and "
				+ "members_class.M_POST_CODE = class_post.POST_CODE and " + "teacher.TeacherType like 'B' " + "and "
				+ researchInfo.getKey() + " like ?" + "order by teacher.TEA_ABLE desc, teacher.TEA_SORT";
		return getResearchList(sql, researchInfo);
	}

	private List<TeacherBasicInfoAdmin> getResearchList(String sql, ResearchTeacher researchInfo) {
		List<TeacherBasicInfoAdmin> infoList = new ArrayList<TeacherBasicInfoAdmin>();

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, "%" + researchInfo.getValue() + "%");
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherBasicInfoAdmin info = new TeacherBasicInfoAdmin();
				info.setTeaPic(rs.getString("TEA_PHOTO"));
				info.setTeaCode(rs.getString("TEA_CODE"));
				info.setTeaLDAP(rs.getString("TEA_LDAP"));
				info.setTeaName(rs.getString("M_NAME"));
				info.setTeaENName(rs.getString("TEA_EN_NAME"));
				info.setTeaPos(rs.getString("POST_NAME"));
				info.setTeaTel(rs.getString("M_PHONE"));
				info.setTeaEmail(rs.getString("M_EMAIL"));
				info.setTeaLoc(rs.getString("Location"));
				info.setTeaAble(rs.getString("TEA_ABLE"));
				infoList.add(info);
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
		return infoList;
	}

	// 更新教師的基本信息
	@Override
	public void update(TeacherBasicInfoAdmin updateInfo) {
		String sql1 = "Update members SET M_NAME = ?, M_PHONE = ?, M_EMAIL = ? " + "WHERE M_LDAP =?";
		String sql2 = "Update teacher SET TEA_EN_NAME = ?, Location = ?, TeacherType=? " + "WHERE TEA_LDAP =?";
		String sql3 = "Update members_class SET M_POST_CODE = ? " + "WHERE M_LDAP =?";

		try {
			PreparedStatement smt1 = null;
			PreparedStatement smt2 = null;
			PreparedStatement smt3 = null;
			conn = dataSource.getConnection();
			smt1 = conn.prepareStatement(sql1);
			smt1.setString(1, updateInfo.getTeaName());
			smt1.setString(2, updateInfo.getTeaTel());
			smt1.setString(3, updateInfo.getTeaEmail());
			smt1.setString(4, updateInfo.getTeaLDAP());
			smt1.executeUpdate();
			smt1.close();

			smt2 = conn.prepareStatement(sql2);
			smt2.setString(1, updateInfo.getTeaENName());
			smt2.setString(2, updateInfo.getTeaLoc());
			smt2.setString(3, updateInfo.getTeaType());
			smt2.setString(4, updateInfo.getTeaLDAP());
			smt2.executeUpdate();
			smt2.close();

			smt3 = conn.prepareStatement(sql3);
			smt3.setString(1, updateInfo.getTeaPos());
			smt3.setString(2, updateInfo.getTeaLDAP());
			smt3.executeUpdate();
			smt3.close();

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

	// 更新教師的顯示圖片，在修改教師基本信息和新增教師基本信息部分會使用
	@Override
	public void updateTeaPic(TeacherBasicInfoAdmin updateInfo, String picName) {
		String sql = "update teacher set TEA_PHOTO = ? where TEA_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, picName);
			smt.setString(2, updateInfo.getTeaCode());
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

	// 刪除專任教師信息：離職+不顯示
	@Override
	public void delete(TeacherBasicInfoAdmin deleteInfo) {

		String sql1 = "Update teacher, members_class SET members_class.M_POST_CODE = 'DZ' "
				+ "WHERE members_class.M_LDAP = teacher.TEA_LDAP and teacher.TEA_CODE = ?";
		String sql2 = "Update teacher, members_class SET teacher.TEA_ABLE = '0' "
				+ "WHERE members_class.M_LDAP = teacher.TEA_LDAP and teacher.TEA_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql1);
			smt.setString(1, deleteInfo.getTeaCode());
			smt.executeUpdate();
			smt.close();

			smt = conn.prepareStatement(sql2);
			smt.setString(1, deleteInfo.getTeaCode());
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
	public TeacherBasicInfoAdmin get(String teaCode) {

		TeacherBasicInfoAdmin info = new TeacherBasicInfoAdmin();

		String sql = "select teacher.TEA_PHOTO, teacher.TEA_CODE, teacher.TEA_LDAP, teacher.TeacherType, "
				+ "members.M_NAME, teacher.TEA_EN_NAME, class_post.POST_NAME, members.M_PHONE, members.M_EMAIL, "
				+ "teacher.Location " + "from teacher, members, class_post, members_class "
				+ "where teacher.TEA_CODE = ? and teacher.TEA_LDAP = members.M_LDAP and "
				+ "members.M_LDAP = members_class.M_LDAP and members_class.M_POST_CODE = class_post.POST_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			if (rs.next()) {
				info.setTeaPic(rs.getString("TEA_PHOTO"));
				info.setTeaCode(rs.getString("TEA_CODE"));
				info.setTeaLDAP(rs.getString("TEA_LDAP"));
				info.setTeaType(rs.getString("TeacherType"));
				info.setTeaName(rs.getString("M_NAME"));
				info.setTeaENName(rs.getString("TEA_EN_NAME"));
				info.setTeaPos(rs.getString("POST_NAME"));
				info.setTeaTel(rs.getString("M_PHONE"));
				info.setTeaEmail(rs.getString("M_EMAIL"));
				info.setTeaLoc(rs.getString("Location"));
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
		return info;
	}

	@Override
	public void changeView(TeacherBasicInfoAdmin changeInfo) {
		String sql = "Update teacher set TEA_ABLE = ? where TEA_LDAP= ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, changeInfo.getTeaAble());
			smt.setString(2, changeInfo.getTeaLDAP());
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
	public boolean checkLDAP(TeacherBasicInfoAdmin newInfo) {
		boolean isChecked = false;

		String sql = "select * from teacher where TEA_LDAP = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, newInfo.getTeaLDAP());
			rs = smt.executeQuery();
			if (!rs.next()) {
				isChecked = true;
			}
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

		return isChecked;
	}

	@Override
	public TeacherBasicInfoAdmin newTeacherBasicInfo(TeacherBasicInfoAdmin newInfo) {
		String sql1 = "insert into teacher(TEA_CODE, TeacherType, TEA_EN_NAME, TEA_PHOTO, "
				+ "TEA_LDAP, TEA_SORT, TEA_ABLE, Location) values(?,?,?,?,?,?,?,?)";
		String sql2 = "insert into members(M_LDAP, M_PASSWORD, M_NAME, M_DEP_CODE, M_PHONE, M_EMAIL) "
				+ "values(?,'test',?,'1',?,?)";
		String sql3 = "insert into members_class(M_LDAP, M_POST_CODE) values(?,?)";

		newInfo.setTeaPic(" ");
		newInfo.setTeaCode(newTeaCode());
		newInfo.setTeaSort(newTeaSort(newInfo));

		try {
			PreparedStatement smt1 = null;
			PreparedStatement smt2 = null;
			PreparedStatement smt3 = null;
			conn = dataSource.getConnection();

			smt1 = conn.prepareStatement(sql1);
			smt1.setString(1, newInfo.getTeaCode());
			smt1.setString(2, newInfo.getTeaType());
			smt1.setString(3, newInfo.getTeaENName());
			smt1.setString(4, newInfo.getTeaPic());
			smt1.setString(5, newInfo.getTeaLDAP());
			smt1.setString(6, newInfo.getTeaSort());
			smt1.setString(7, newInfo.getTeaAble());
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
				} catch (SQLException e) {
				}
			}
		}
		return newInfo;
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
	private String newTeaSort(TeacherBasicInfoAdmin newInfo) {
		String teaSort = "";
		String sql = "select max(TEA_SORT) as TEA_SORT from teacher where Teachertype=?";

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

	@Override
	public List<TeacherBasicInfoAdmin> teacherShowList(String teaType) {
		List<TeacherBasicInfoAdmin> info = new ArrayList<TeacherBasicInfoAdmin>();

		String sql = "select distinct teacher.TEA_CODE, teacher.TEA_SORT, members.M_NAME, class_post.POST_NAME "
				+ "from teacher, members, class_post, members_class "
				+ "where teacher.TEA_LDAP = members.M_LDAP and members.M_LDAP = members_class.M_LDAP "
				+ "and members_class.M_POST_CODE = class_post.POST_CODE and class_post.POST_CODE not like 'DB' "
				+ "and class_post.POST_CODE not like 'DC' and class_post.POST_CODE not like 'AA' and "
				+ "members_class.M_POST_CODE not like 'DZ' and teacher.TeacherType=? " + "order by teacher.TEA_SORT";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaType);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherBasicInfoAdmin inf = new TeacherBasicInfoAdmin();
				inf.setTeaCode(rs.getString("TEA_CODE"));
				inf.setTeaSort(rs.getString("TEA_SORT"));
				inf.setTeaName(rs.getString("M_NAME"));
				inf.setTeaPos(rs.getString("POST_NAME"));
				info.add(inf);
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

		return info;
	}

	@Override
	public void changeTeacherRank(List<RankInfo> rankInfo) {
		RankInfo info = null;
		try {
			conn = dataSource.getConnection();
			for (int i = 0; i < rankInfo.size(); i++) {
				info = rankInfo.get(i);

				String sql = "Update teacher set TEA_SORT = ? where TEA_CODE = ?";

				smt = conn.prepareStatement(sql);
				smt.setString(1, info.getSort());
				smt.setString(2, info.getTeaCode());
				smt.executeUpdate();
				smt.close();
			}
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
	public List<TeacherEduInfo> getTeacherEduInfo(String teaCode) {
		List<TeacherEduInfo> out = new ArrayList<TeacherEduInfo>();
		String sql = "select TEA_EDU_CODE, TEA_SCH, TEA_DEP, TEA_DEG from tea_edu where TEA_CODE = ? "
				+ "order by TEA_EDU_CODE desc";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherEduInfo teacherEduInfo = new TeacherEduInfo();
				teacherEduInfo.setName("學歷");
				teacherEduInfo.setFlag(true);
				teacherEduInfo.setTeaEduCode(rs.getString("TEA_EDU_CODE"));
				teacherEduInfo.setTeaSch(rs.getString("TEA_SCH"));
				teacherEduInfo.setTeaDep(rs.getString("TEA_DEP"));
				teacherEduInfo.setTeaDeg(rs.getString("TEA_DEG"));
				out.add(teacherEduInfo);
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
	public void deleteTeaEdu(TeacherBasicInfoAdmin teaInfo, TeacherEduInfo eduInfo) {
		String sql = "delete from tea_edu where TEA_CODE = ? and TEA_EDU_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, eduInfo.getTeaEduCode());
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
	public void updateTeaEdu(TeacherBasicInfoAdmin teaInfo, TeacherEduInfo eduInfo) {
		String sql = "update tea_edu set TEA_SCH = ?, TEA_DEP = ?, TEA_DEG = ? where TEA_CODE = ? and TEA_EDU_CODE = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, eduInfo.getTeaSch());
			smt.setString(2, eduInfo.getTeaDep());
			smt.setString(3, eduInfo.getTeaDeg());
			smt.setString(4, teaInfo.getTeaCode());
			smt.setString(5, eduInfo.getTeaEduCode());
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
	public void newTeaEdu(TeacherBasicInfoAdmin teaInfo, TeacherEduInfo eduInfo) {
		String newEduCode = newTeaEduCode(teaInfo);

		String sql = "insert into tea_edu(TEA_CODE, TEA_EDU_CODE, TEA_SCH, TEA_DEP, TEA_DEG) values(?, ?, ?, ?, ?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, newEduCode);
			smt.setString(3, eduInfo.getTeaSch());
			smt.setString(4, eduInfo.getTeaDep());
			smt.setString(5, eduInfo.getTeaDeg());
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

	private String newTeaEduCode(TeacherBasicInfoAdmin teaInfo) {
		String newEduCode = "";
		String sql = "select max(TEA_EDU_CODE) as TEA_EDU_CODE from tea_edu where TEA_CODE = ? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				int i = rs.getInt("TEA_EDU_CODE");
				i++;
				newEduCode = Integer.toString(i);
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

		return newEduCode;
	}

	@Override
	public List<TeacherExpInfo> getTeacherExpInfo(String teaCode) {
		List<TeacherExpInfo> out = new ArrayList<TeacherExpInfo>();
		String sql = "select TEA_EXP_CODE, TEA_EXP_PER, TEA_EXP_UNIT, TEA_EXP_DEP, TEA_EXP_TITLE from tea_exp "
				+ "where TEA_CODE = ? order by TEA_EXP_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherExpInfo teacherExpInfo = new TeacherExpInfo();
				teacherExpInfo.setName("經歷");
				teacherExpInfo.setFlag(true);
				teacherExpInfo.setTeaExpCode(rs.getString("TEA_EXP_CODE"));
				teacherExpInfo.setTeaExpPer(rs.getString("TEA_EXP_PER"));
				teacherExpInfo.setTeaExpUnit(rs.getString("TEA_EXP_UNIT"));
				teacherExpInfo.setTeaExpDep(rs.getString("TEA_EXP_DEP"));
				teacherExpInfo.setTeaExpTitle(rs.getString("TEA_EXP_TITLE"));
				out.add(teacherExpInfo);
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
	public void deleteTeaExp(TeacherBasicInfoAdmin teaInfo, TeacherExpInfo expInfo) {
		String sql = "delete from tea_exp where TEA_CODE = ? and TEA_EXP_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, expInfo.getTeaExpCode());
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
	public void updateTeaExp(TeacherBasicInfoAdmin teaInfo, TeacherExpInfo expInfo) {
		String sql = "update tea_exp set TEA_EXP_PER = ?, TEA_EXP_UNIT = ?, TEA_EXP_DEP = ?, "
				+ "TEA_EXP_TITLE = ? where TEA_CODE = ? and TEA_EXP_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, expInfo.getTeaExpPer());
			smt.setString(2, expInfo.getTeaExpUnit());
			smt.setString(3, expInfo.getTeaExpDep());
			smt.setString(4, expInfo.getTeaExpTitle());
			smt.setString(5, teaInfo.getTeaCode());
			smt.setString(6, expInfo.getTeaExpCode());
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
	public void newTeaExp(TeacherBasicInfoAdmin teaInfo, TeacherExpInfo expInfo) {
		refreshTeaExpCode(teaInfo);

		String sql = "insert into tea_exp(TEA_CODE, TEA_EXP_CODE, TEA_EXP_PER, TEA_EXP_UNIT, "
				+ "TEA_EXP_DEP, TEA_EXP_TITLE) values(?, '1', ?, ?, ?, ?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, expInfo.getTeaExpPer());
			smt.setString(3, expInfo.getTeaExpUnit());
			smt.setString(4, expInfo.getTeaExpDep());
			smt.setString(5, expInfo.getTeaExpTitle());
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

	private void refreshTeaExpCode(TeacherBasicInfoAdmin teaInfo) {
		// 當排序編號有1時進行刷新動作，若沒有，則直接載入1即可，下同
		String sql = "select * from tea_exp where TEA_CODE = ? and TEA_EXP_CODE = '1'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				smt.close();
				rs.close();

				sql = "select TEA_EXP_CODE from tea_exp where TEA_CODE = ? order by TEA_EXP_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_EXP_CODE");
					String newSql = "update tea_exp set TEA_EXP_CODE = ? where TEA_CODE = ? " + "and TEA_EXP_CODE = ?";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherSpeInfo> getTeacherSpeInfo(String teaCode) {
		List<TeacherSpeInfo> out = new ArrayList<TeacherSpeInfo>();
		String sql = "select TEA_SPE_CODE, TEA_SPE from tea_spe where TEA_CODE = ? order by TEA_SPE_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherSpeInfo teacherSpeInfo = new TeacherSpeInfo();
				teacherSpeInfo.setName("專長");
				teacherSpeInfo.setFlag(true);
				teacherSpeInfo.setTeaSpeCode(rs.getString("TEA_SPE_CODE"));
				teacherSpeInfo.setTeaSpe(rs.getString("TEA_SPE"));
				out.add(teacherSpeInfo);
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
	public void deleteTeaSpe(TeacherBasicInfoAdmin teaInfo, TeacherSpeInfo speInfo) {
		String sql = "delete from tea_spe where TEA_CODE = ? and TEA_SPE_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, speInfo.getTeaSpeCode());
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
	public void updateTeaSpe(TeacherBasicInfoAdmin teaInfo, TeacherSpeInfo speInfo) {
		String sql = "update tea_spe set TEA_SPE = ? where TEA_CODE = ? and TEA_SPE_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, speInfo.getTeaSpe());
			smt.setString(2, teaInfo.getTeaCode());
			smt.setString(3, speInfo.getTeaSpeCode());
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
	public void newTeaSpe(TeacherBasicInfoAdmin teaInfo, TeacherSpeInfo speInfo) {
		refreshSpeCode(teaInfo);

		String sql = "insert into tea_spe(TEA_CODE, TEA_SPE_CODE, TEA_SPE) values(?, '1', ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, speInfo.getTeaSpe());
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

	private void refreshSpeCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_spe where TEA_CODE = ? and TEA_SPE_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				smt.close();
				rs.close();

				sql = "select TEA_SPE_CODE from tea_spe where TEA_CODE = ? order by TEA_SPE_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_SPE_CODE");
					String newSql = "update tea_spe set TEA_SPE_CODE = ? where TEA_CODE = ? " + "and TEA_SPE_CODE = ?";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherAwardInfo> getTeacherAwardInfo(String teaCode) {
		List<TeacherAwardInfo> out = new ArrayList<TeacherAwardInfo>();
		String sql = "select TEA_AWA_CODE, TEA_AWA_YEAR, TEA_AWA_DEP, TEA_AWA from tea_award "
				+ "where TEA_CODE = ? order by TEA_AWA_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherAwardInfo teacherAwardInfo = new TeacherAwardInfo();
				teacherAwardInfo.setName("研究獎勵");
				teacherAwardInfo.setFlag(true);
				teacherAwardInfo.setTeaAwaCode(rs.getString("TEA_AWA_CODE"));
				teacherAwardInfo.setTeaAwaYear(rs.getString("TEA_AWA_YEAR"));
				teacherAwardInfo.setTeaAwaDep(rs.getString("TEA_AWA_DEP"));
				teacherAwardInfo.setTeaAwa(rs.getString("TEA_AWA"));
				out.add(teacherAwardInfo);
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
	public void deleteTeaAwa(TeacherBasicInfoAdmin teaInfo, TeacherAwardInfo awaInfo) {
		String sql = "delete from tea_award where TEA_CODE = ? and TEA_AWA_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, awaInfo.getTeaAwaCode());
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
	public void updateTeaAwa(TeacherBasicInfoAdmin teaInfo, TeacherAwardInfo awaInfo) {
		String sql = "update tea_award set TEA_AWA_YEAR = ?, TEA_AWA_DEP = ?, TEA_AWA = ? "
				+ "where TEA_CODE = ? and TEA_AWA_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, awaInfo.getTeaAwaYear());
			smt.setString(2, awaInfo.getTeaAwaDep());
			smt.setString(3, awaInfo.getTeaAwa());
			smt.setString(4, teaInfo.getTeaCode());
			smt.setString(5, awaInfo.getTeaAwaCode());
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
	public void newTeaAwa(TeacherBasicInfoAdmin teaInfo, TeacherAwardInfo awaInfo) {
		refreshTeaAwaCode(teaInfo);

		String sql = "insert into tea_award(TEA_CODE, TEA_AWA_CODE, TEA_AWA_YEAR, TEA_AWA_DEP, TEA_AWA) "
				+ "values(?, '1', ?, ?, ?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, awaInfo.getTeaAwaYear());
			smt.setString(3, awaInfo.getTeaAwaDep());
			smt.setString(4, awaInfo.getTeaAwa());
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

	private void refreshTeaAwaCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_award where TEA_CODE = ? and TEA_AWA_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_AWA_CODE from tea_award where TEA_CODE = ? order by TEA_AWA_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_AWA_CODE");
					String newSql = "update tea_award set TEA_AWA_CODE = ? where TEA_CODE = ? "
							+ "and TEA_AWA_CODE = ?";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}
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
	public List<TeacherPlanInfo> getTeacherPlanInfo(String teaCode) {
		List<TeacherPlanInfo> out = new ArrayList<TeacherPlanInfo>();
		String sql = "select TEA_PLAN_CODE, TEA_PLAN_PER, TEA_PLAN_LEADER, TEA_PLAN_NAME, TEA_PLAN_SPON, TEA_PLAN_MON, TEA_PLAN_POS "
				+ "from tea_plan where TEA_CODE = ? and TEA_PLAN_NAME != '' order by TEA_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherPlanInfo teacherPlanInfo = new TeacherPlanInfo();
				teacherPlanInfo.setName("研究計劃");
				teacherPlanInfo.setFlag(true);
				teacherPlanInfo.setTeaPlanCode(rs.getString("TEA_PLAN_CODE"));
				teacherPlanInfo.setTeaPlanPer(rs.getString("TEA_PLAN_PER"));
				teacherPlanInfo.setTeaPlanLeader(rs.getString("TEA_PLAN_LEADER"));
				teacherPlanInfo.setTeaPlanName(rs.getString("TEA_PLAN_NAME"));
				teacherPlanInfo.setTeaPlanSpon(rs.getString("TEA_PLAN_SPON"));
				teacherPlanInfo.setTeaPlanMon(rs.getString("TEA_PLAN_MON"));
				teacherPlanInfo.setTeaPlanPos(rs.getString("TEA_PLAN_POS"));
				out.add(teacherPlanInfo);
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
	public void deleteTeaPlan(TeacherBasicInfoAdmin teaInfo, TeacherPlanInfo planInfo) {
		String sql = "delete from tea_plan where TEA_CODE = ? AND TEA_PLAN_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, planInfo.getTeaPlanCode());
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
	public void updateTeaPlan(TeacherBasicInfoAdmin teaInfo, TeacherPlanInfo planInfo) {
		String sql = "update tea_plan set TEA_PLAN_PER = ?, TEA_PLAN_LEADER = ?, TEA_PLAN_SPON = ?, "
				+ "TEA_PLAN_MON = ?, TEA_PLAN_POS = ? where TEA_CODE = ? and TEA_PLAN_CODE = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, planInfo.getTeaPlanPer());
			smt.setString(2, planInfo.getTeaPlanLeader());
			smt.setString(3, planInfo.getTeaPlanSpon());
			smt.setString(4, planInfo.getTeaPlanMon());
			smt.setString(5, planInfo.getTeaPlanPos());
			smt.setString(6, teaInfo.getTeaCode());
			smt.setString(7, planInfo.getTeaPlanCode());
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
	public void newTeaPlan(TeacherBasicInfoAdmin teaInfo, TeacherPlanInfo planInfo) {
		refreshTeaPlanCode(teaInfo);

		String sql = "insert into tea_plan(TEA_CODE, TEA_PLAN_CODE, TEA_PLAN_PER, TEA_PLAN_LEADER, "
				+ "TEA_PLAN_NAME, TEA_PLAN_SPON, TEA_PLAN_MON, TEA_PLAN_POS) values(?,'1',?,?,?,?,?,?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, planInfo.getTeaPlanPer());
			smt.setString(3, planInfo.getTeaPlanLeader());
			smt.setString(4, planInfo.getTeaPlanName());
			smt.setString(5, planInfo.getTeaPlanSpon());
			smt.setString(6, planInfo.getTeaPlanMon());
			smt.setString(7, planInfo.getTeaPlanPos());
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

	private void refreshTeaPlanCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_plan where TEA_CODE = ? and TEA_PLAN_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_PLAN_CODE from tea_plan where TEA_CODE = ? order by TEA_PLAN_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_PLAN_CODE");
					String newSql = "update tea_plan set TEA_PLAN_CODE = ? where TEA_CODE = ? "
							+ "and TEA_PLAN_CODE = ?";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherStuPaper> getTeacherStuPaper(String teaCode) {
		List<TeacherStuPaper> out = new ArrayList<TeacherStuPaper>();
		String sql = "select PaperID, TEA_STU_YEAR, TEA_STU_NAME, TEA_STU_PAPER_NAME "
				+ "from tea_stu_paper where TEA_CODE = ? order by PaperID";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherStuPaper teacherStuPaper = new TeacherStuPaper();
				teacherStuPaper.setName("研究所論文指導");
				teacherStuPaper.setFlag(true);
				teacherStuPaper.setPaperID(rs.getString("PaperID"));
				teacherStuPaper.setTeaStuYear(rs.getString("TEA_STU_YEAR"));
				teacherStuPaper.setTeaStuName(rs.getString("TEA_STU_NAME"));
				teacherStuPaper.setTeaStuPaperName(rs.getString("TEA_STU_PAPER_NAME"));
				out.add(teacherStuPaper);
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
	public void deleteTeaStuPaper(TeacherBasicInfoAdmin teaInfo, TeacherStuPaper teaStuPaper) {
		String sql = "delete from tea_stu_paper where TEA_CODE = ? AND PaperID = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, teaStuPaper.getPaperID());
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
	public void updateTeaStuPaper(TeacherBasicInfoAdmin teaInfo, TeacherStuPaper teaStuPaper) {
		String sql = "update tea_stu_paper set TEA_STU_YEAR = ?, TEA_STU_NAME = ?, TEA_STU_PAPER_NAME = ? "
				+ "where TEA_CODE = ? and PaperID = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaStuPaper.getTeaStuYear());
			smt.setString(2, teaStuPaper.getTeaStuName());
			smt.setString(3, teaStuPaper.getTeaStuPaperName());
			smt.setString(4, teaInfo.getTeaCode());
			smt.setString(5, teaStuPaper.getPaperID());
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
	public void newTeaStuPaper(TeacherBasicInfoAdmin teaInfo, TeacherStuPaper teaStuPaper) {
		refreshTeaStuPaperID();

		String sql = "insert into tea_stu_paper(PaperID, TEA_CODE, TEA_STU_YEAR, TEA_STU_NAME, "
				+ "TEA_STU_PAPER_NAME) values ('1', ?, ?, ?, ?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, teaStuPaper.getTeaStuYear());
			smt.setString(3, teaStuPaper.getTeaStuName());
			smt.setString(4, teaStuPaper.getTeaStuPaperName());
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

	private void refreshTeaStuPaperID() {
		String sql = "select * from tea_stu_paper where PaperID = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select PaperID from tea_stu_paper order by PaperID desc";
				smt = conn.prepareStatement(sql);
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("PaperID");
					String newSql = "update tea_stu_paper set PaperID = ? where PaperID = ?";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherStuTopic> getTeacherStuTopic(String teaCode) {
		List<TeacherStuTopic> out = new ArrayList<TeacherStuTopic>();
		String sql = "select TopicID, TEA_STU_YEAR, TEA_STU_NAME from tea_stu_topic "
				+ "where TEA_CODE = ? order by TopicID";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherStuTopic teacherStuTopic = new TeacherStuTopic();
				teacherStuTopic.setName("大學專題指導");
				teacherStuTopic.setFlag(true);
				teacherStuTopic.setTopicID(rs.getString("TopicID"));
				teacherStuTopic.setTeaStuYear(rs.getString("TEA_STU_YEAR"));
				teacherStuTopic.setTeaStuName(rs.getString("TEA_STU_NAME"));
				out.add(teacherStuTopic);
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
	public void deleteTeaStuTopic(TeacherBasicInfoAdmin teaInfo, TeacherStuTopic teaStuTopic) {
		String sql = "delete from tea_stu_topic where TEA_CODE = ? and TopicID = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, teaStuTopic.getTopicID());
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
	public void updateTeaStuTopic(TeacherBasicInfoAdmin teaInfo, TeacherStuTopic teaStuTopic) {
		String sql = "update tea_stu_topic set TEA_STU_YEAR = ?, TEA_STU_NAME = ? where TEA_CODE = ? and TopicID = ?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaStuTopic.getTeaStuYear());
			smt.setString(2, teaStuTopic.getTeaStuName());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, teaStuTopic.getTopicID());
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
	public void newTeaStuTopic(TeacherBasicInfoAdmin teaInfo, TeacherStuTopic teaStuTopic) {
		refreshTeaStuTopicID();

		String sql = "insert into tea_stu_topic(TopicID, TEA_CODE, TEA_STU_YEAR, TEA_STU_NAME) " + "values('1',?,?,?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, teaStuTopic.getTeaStuYear());
			smt.setString(3, teaStuTopic.getTeaStuName());
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

	private void refreshTeaStuTopicID() {
		String sql = "select * from tea_stu_topic where TopicID = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TopicID from tea_stu_topic order by TopicID desc";
				smt = conn.prepareStatement(sql);
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TopicID");
					String newSql = "update tea_stu_topic set TopicID = ? where TopicID = ?";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getIssuePaper(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAA' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("期刊論文");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);
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
	public void deleteIssuePaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo issuePaper) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'BAA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, issuePaper.getTeaDataContCode());
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
	public void updateIssuePaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo issuePaper) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, issuePaper.getTeaDataCont());
			smt.setString(2, issuePaper.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, issuePaper.getTeaDataContCode());
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
	public void newIssuePaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo issuePaper) {
		refreshIssuePaperCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'BAA',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, issuePaper.getTeaDataCont());
			smt.setString(3, issuePaper.getTeaDataPer());
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

	private void refreshIssuePaperCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'BAA' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'BAA' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAA'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getMeetingPaper(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAB' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("研討會論文");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);

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
	public void deleteMeetingPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo meetingPaper) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'BAB'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, meetingPaper.getTeaDataContCode());
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
	public void updateMeetingPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo meetingPaper) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAB'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, meetingPaper.getTeaDataCont());
			smt.setString(2, meetingPaper.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, meetingPaper.getTeaDataContCode());
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
	public void newMeetingPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo meetingPaper) {
		refreshMeetingPaperCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'BAB',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, meetingPaper.getTeaDataCont());
			smt.setString(3, meetingPaper.getTeaDataPer());
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

	private void refreshMeetingPaperCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'BAB' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'BAB' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAB'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getBooks(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAC' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("書籍");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);
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
	public void deleteBooks(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo books) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'BAC'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, books.getTeaDataContCode());
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
	public void updateBooks(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo books) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAC'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, books.getTeaDataCont());
			smt.setString(2, books.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, books.getTeaDataContCode());
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
	public void newBooks(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo books) {
		refreshBookCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'BAC',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, books.getTeaDataCont());
			smt.setString(3, books.getTeaDataPer());
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

	private void refreshBookCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'BAC' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'BAC' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAC'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getTechReport(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAD' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("技術報告");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);
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
	public void deleteTechReport(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo techReport) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'BAD'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, techReport.getTeaDataContCode());
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
	public void updateTechReport(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo techReport) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAD'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, techReport.getTeaDataCont());
			smt.setString(2, techReport.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, techReport.getTeaDataContCode());
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
	public void newTechReport(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo techReport) {
		refreshTechReportCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'BAD',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, techReport.getTeaDataCont());
			smt.setString(3, techReport.getTeaDataPer());
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

	private void refreshTechReportCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'BAD' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'BAD' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAD'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getTecherPaper(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAE' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("畢業論文");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);
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
	public void deleteTeacherpaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo teacherPaper) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'BAE'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, teacherPaper.getTeaDataContCode());
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
	public void updateTeacherPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo teacherPaper) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAE'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teacherPaper.getTeaDataCont());
			smt.setString(2, teacherPaper.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, teacherPaper.getTeaDataContCode());
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
	public void newTeacherPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo teacherPaper) {
		refreshTecherPaperCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'BAE',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, teacherPaper.getTeaDataCont());
			smt.setString(3, teacherPaper.getTeaDataPer());
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

	private void refreshTecherPaperCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'BAE' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'BAE' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAE'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getMagazinePaper(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAF' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("在資訊相關雜誌上近幾年發表之文章");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);
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
	public void deleteMagazinePaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo magazinePaper) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'BAF'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, magazinePaper.getTeaDataContCode());
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
	public void updateMagazinePaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo magazinePaper) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAF'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, magazinePaper.getTeaDataCont());
			smt.setString(2, magazinePaper.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, magazinePaper.getTeaDataContCode());
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
	public void newMagazinePaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo magazinePaper) {
		refreshMagazinePaperCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'BAF',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, magazinePaper.getTeaDataCont());
			smt.setString(3, magazinePaper.getTeaDataPer());
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

	private void refreshMagazinePaperCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'BAF' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'BAF' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAF'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getWaitingPaper(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAG' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("期刊審查中論文");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);
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
	public void deleteWaitingPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo waitingPaper) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'BAG'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, waitingPaper.getTeaDataContCode());
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
	public void updateWaitingPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo waitingPaper) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAG'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, waitingPaper.getTeaDataCont());
			smt.setString(2, waitingPaper.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, waitingPaper.getTeaDataContCode());
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
	public void newWaitingPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo waitingPaper) {
		refreshWaitingPaperCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'BAG',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, waitingPaper.getTeaDataCont());
			smt.setString(3, waitingPaper.getTeaDataPer());
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

	private void refreshWaitingPaperCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'BAG' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'BAG' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAG'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getScholarPaper(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAH' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("學術著作");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);
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
	public void deleteScholarPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo scholarPaper) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'BAH'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, scholarPaper.getTeaDataContCode());
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
	public void updateScholarPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo scholarPaper) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAH'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, scholarPaper.getTeaDataCont());
			smt.setString(2, scholarPaper.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, scholarPaper.getTeaDataContCode());
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
	public void newScholarPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo scholarPaper) {
		refreshScholarPaperCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'BAH',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, scholarPaper.getTeaDataCont());
			smt.setString(3, scholarPaper.getTeaDataPer());
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

	private void refreshScholarPaperCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'BAH' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'BAH' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BAH'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getPracticeReach(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BDA' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("實務研究內容");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);
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
	public void deletePracticeReach(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo practiceReach) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'BDA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, practiceReach.getTeaDataContCode());
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
	public void updatePracticeReach(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo practiceReach) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BDA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, practiceReach.getTeaDataCont());
			smt.setString(2, practiceReach.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, practiceReach.getTeaDataContCode());
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
	public void newPracticeReach(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo practiceReach) {
		refreshPracticeReachCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'BDA',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, practiceReach.getTeaDataCont());
			smt.setString(3, practiceReach.getTeaDataPer());
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

	private void refreshPracticeReachCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'BDA' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'BDA' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'BDA'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getOtherExp(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'CCA' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("其他教學經驗");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);
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
	public void deleteOtherExp(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo otherExp) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'CCA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, otherExp.getTeaDataContCode());
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
	public void updateOtherExp(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo otherExp) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'CCA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, otherExp.getTeaDataCont());
			smt.setString(2, otherExp.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, otherExp.getTeaDataContCode());
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
	public void newOtherExp(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo otherExp) {
		refreshOtherExpCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'CCA',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, otherExp.getTeaDataCont());
			smt.setString(3, otherExp.getTeaDataPer());
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

	private void refreshOtherExpCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'CCA' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'CCA' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'CCA'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getInSchService(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'DAA' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("校內服務內容");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);
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
	public void deleteInSchService(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo inSchService) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'DAA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, inSchService.getTeaDataContCode());
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
	public void updateInSchService(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo inSchService) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'DAA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, inSchService.getTeaDataCont());
			smt.setString(2, inSchService.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, inSchService.getTeaDataContCode());
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
	public void newInSchService(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo inSchService) {
		refreshInSchServiceCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'DAA',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, inSchService.getTeaDataCont());
			smt.setString(3, inSchService.getTeaDataPer());
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

	private void refreshInSchServiceCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'DAA' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'DAA' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'DAA'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getOutSchService(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'DBA' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("校外服務內容");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);
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
	public void deleteOutSchService(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo outSchService) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'DBA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, outSchService.getTeaDataContCode());
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
	public void updateOutSchService(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo outSchService) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'DBA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, outSchService.getTeaDataCont());
			smt.setString(2, outSchService.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, outSchService.getTeaDataContCode());
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
	public void newOutSchService(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo outSchService) {
		refreshOutSchServiceCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'DBA',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, outSchService.getTeaDataCont());
			smt.setString(3, outSchService.getTeaDataPer());
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

	private void refreshOutSchServiceCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'DBA' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'DBA' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'DBA'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getAsCommitMem(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'DCA' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("擔任委員內容");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);
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
	public void deleteAsCommitMem(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo asCommitMem) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'DCA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, asCommitMem.getTeaDataContCode());
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
	public void updateAsCommitMem(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo asCommitMem) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'DCA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, asCommitMem.getTeaDataCont());
			smt.setString(2, asCommitMem.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, asCommitMem.getTeaDataContCode());
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
	public void newAsCommitMem(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo asCommitMem) {
		refreshAsCommitMemCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'DCA',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, asCommitMem.getTeaDataCont());
			smt.setString(3, asCommitMem.getTeaDataPer());
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

	private void refreshAsCommitMemCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'DCA' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'DCA' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'DCA'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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
	public List<TeacherOtherInfo> getScholarExp(String teaCode) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT_CODE, TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'DDA' order by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaCode);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("學術經驗內容");
				teacherOtherInfo.setFlag(true);
				teacherOtherInfo.setTeaDataContCode(rs.getString("TEA_DATA_CONT_CODE"));
				teacherOtherInfo.setTeaDataCont(rs.getString("TEA_DATA_CONT"));
				teacherOtherInfo.setTeaDataPer(rs.getString("TEA_DATA_PER"));
				out.add(teacherOtherInfo);
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
	public void deleteScholarExp(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo scholarExp) {
		String sql = "delete from tea_data_per_cont where TEA_CODE = ? and TEA_DATA_CONT_CODE = ?"
				+ "and TEA_DATA_SUB_CODE = 'DDA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, scholarExp.getTeaDataContCode());
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
	public void updateScholarExp(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo scholarExp) {
		String sql = "update tea_data_per_cont set TEA_DATA_CONT = ?, TEA_DATA_PER = ? where "
				+ "TEA_CODE = ? and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'DDA'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, scholarExp.getTeaDataCont());
			smt.setString(2, scholarExp.getTeaDataPer());
			smt.setString(3, teaInfo.getTeaCode());
			smt.setString(4, scholarExp.getTeaDataContCode());
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
	public void newScholarExp(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo scholarExp) {
		refreshScholarExpCode(teaInfo);

		String sql = "insert into tea_data_per_cont(TEA_CODE, TEA_DATA_SUB_CODE, TEA_DATA_CONT, "
				+ "TEA_DATA_CONT_CODE, TEA_DATA_PER) values(?,'DDA',?,'1',?)";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			smt.setString(2, scholarExp.getTeaDataCont());
			smt.setString(3, scholarExp.getTeaDataPer());
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

	private void refreshScholarExpCode(TeacherBasicInfoAdmin teaInfo) {
		String sql = "select * from tea_data_per_cont where TEA_CODE = ? "
				+ "and TEA_DATA_SUB_CODE = 'DDA' and TEA_DATA_CONT_CODE = '1'";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, teaInfo.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				rs.close();
				smt.close();

				sql = "select TEA_DATA_CONT_CODE from tea_data_per_cont where TEA_CODE = ? "
						+ "and TEA_DATA_SUB_CODE = 'DDA' order by TEA_DATA_CONT_CODE desc";
				smt = conn.prepareStatement(sql);
				smt.setString(1, teaInfo.getTeaCode());
				rs = smt.executeQuery();
				while (rs.next()) {
					int i = rs.getInt("TEA_DATA_CONT_CODE");
					String newSql = "update tea_data_per_cont set TEA_DATA_CONT_CODE = ? where " + "TEA_CODE = ? "
							+ "and TEA_DATA_CONT_CODE = ? and TEA_DATA_SUB_CODE = 'DDA'";
					PreparedStatement newSmt = conn.prepareStatement(newSql);
					newSmt.setString(1, Integer.toString(i + 1));
					newSmt.setString(2, teaInfo.getTeaCode());
					newSmt.setString(3, Integer.toString(i));
					newSmt.executeUpdate();
					newSmt.close();
				}
				rs.close();
				smt.close();
			}

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

}
