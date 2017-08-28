package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.dao.TeacherInfoDAO;
import com.practice.webapp.entity.teacher.TeacherAwardInfo;
import com.practice.webapp.entity.teacher.TeacherBasicInfo;
import com.practice.webapp.entity.teacher.TeacherEduInfo;
import com.practice.webapp.entity.teacher.TeacherExpInfo;
import com.practice.webapp.entity.teacher.TeacherOtherInfo;
import com.practice.webapp.entity.teacher.TeacherPlanInfo;
import com.practice.webapp.entity.teacher.TeacherSpeInfo;
import com.practice.webapp.entity.teacher.TeacherStuPaper;
import com.practice.webapp.entity.teacher.TeacherStuTopic;

public class TeacherInfoDAOImpl implements TeacherInfoDAO {

	private DataSource dataSource;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement smt;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	// 展示專任教師
	public List<TeacherBasicInfo> getProTeacherInfoList() {
		String sql = "select teacher.TEA_PHOTO, teacher.TEA_CODE, teacher.TEA_LDAP, "
				+ "members.M_NAME, teacher.TEA_EN_NAME, class_post.POST_NAME, "
				+ "members.M_PHONE, members.M_EMAIL, teacher.Location "
				+ "from teacher, members, class_post, members_class " + "where "
				+ "teacher.TEA_LDAP = members.M_LDAP and " + "members.M_LDAP = members_class.M_LDAP and "
				+ "members_class.M_POST_CODE = class_post.POST_CODE and " + "class_post.POST_CODE not like 'DB' and "
				+ "class_post.POST_CODE not like 'DC' and " + "class_post.POST_CODE not like 'DZ' and "
				+ "class_post.POST_CODE not like 'AA' and " + "teacher.TeacherType like 'T' and "
				+ "teacher.TEA_ABLE = '1' " + "order by teacher.TEA_SORT";
		return getList(sql);
	}

	@Override
	// 展示兼任教師
	public List<TeacherBasicInfo> getPartTeacherInfoList() {
		String sql = "select teacher.TEA_PHOTO, teacher.TEA_CODE, teacher.TEA_LDAP, "
				+ "members.M_NAME, teacher.TEA_EN_NAME, class_post.POST_NAME, "
				+ "members.M_PHONE, members.M_EMAIL, teacher.Location "
				+ "from teacher, members, class_post, members_class " + "where "
				+ "teacher.TEA_LDAP = members.M_LDAP and " + "members.M_LDAP = members_class.M_LDAP and "
				+ "members_class.M_POST_CODE = class_post.POST_CODE and " + "class_post.POST_CODE not like 'DB' and "
				+ "class_post.POST_CODE not like 'DC' and " + "class_post.POST_CODE not like 'DZ' and "
				+ "class_post.POST_CODE not like 'AA' and " + "teacher.TeacherType like 'B' and "
				+ "teacher.TEA_ABLE = '1' " + "order by teacher.TEA_SORT";
		return getList(sql);
	}

	public List<TeacherBasicInfo> getList(String sql) {
		List<TeacherBasicInfo> infoList = new ArrayList<TeacherBasicInfo>();

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherBasicInfo info = new TeacherBasicInfo();
				info.setTeaPic(rs.getString("TEA_PHOTO"));
				info.setTeaCode(rs.getString("TEA_CODE"));
				info.setTeaLDAP(rs.getString("TEA_LDAP"));
				info.setTeaName(rs.getString("M_NAME"));
				info.setTeaENName(rs.getString("TEA_EN_NAME"));
				info.setTeaPos(rs.getString("POST_NAME"));
				info.setTeaTel(rs.getString("M_PHONE"));
				info.setTeaEmail(rs.getString("M_EMAIL"));
				info.setTeaLoc(rs.getString("Location"));
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

	@Override
	public TeacherBasicInfo get(TeacherBasicInfo info) {

		String sql = "select teacher.TEA_PHOTO, teacher.TEA_CODE, teacher.TEA_LDAP, members.M_NAME, "
				+ "teacher.TEA_EN_NAME, class_post.POST_NAME, members.M_PHONE, members.M_EMAIL, "
				+ "teacher.Location from teacher, members, class_post, members_class "
				+ "where teacher.TEA_CODE = ? and teacher.TEA_LDAP = members.M_LDAP and "
				+ "members.M_LDAP = members_class.M_LDAP and " + "members_class.M_POST_CODE = class_post.POST_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			if (rs.next()) {
				info.setTeaPic(rs.getString("TEA_PHOTO"));
				info.setTeaCode(rs.getString("TEA_CODE"));
				info.setTeaLDAP(rs.getString("TEA_LDAP"));
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
	public List<TeacherEduInfo> getTeacherEduInfo(TeacherBasicInfo info) {
		List<TeacherEduInfo> out = new ArrayList<TeacherEduInfo>();
		String sql = "select TEA_SCH, TEA_DEP, TEA_DEG from tea_edu where TEA_CODE = ? " + "order by TEA_EDU_CODE desc";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherEduInfo teacherEduInfo = new TeacherEduInfo();
				teacherEduInfo.setName("學歷");
				teacherEduInfo.setFlag(true);
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
	public List<TeacherExpInfo> getTeacherExpInfo(TeacherBasicInfo info) {
		List<TeacherExpInfo> out = new ArrayList<TeacherExpInfo>();
		String sql = "select TEA_EXP_PER, TEA_EXP_UNIT, TEA_EXP_DEP, TEA_EXP_TITLE from tea_exp "
				+ "where TEA_CODE = ? order by TEA_EXP_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherExpInfo teacherExpInfo = new TeacherExpInfo();
				teacherExpInfo.setName("經歷");
				teacherExpInfo.setFlag(true);
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
	public List<TeacherSpeInfo> getTeacherSpeInfo(TeacherBasicInfo info) {
		List<TeacherSpeInfo> out = new ArrayList<TeacherSpeInfo>();
		String sql = "select TEA_SPE from tea_spe where TEA_CODE = ? group by TEA_SPE_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherSpeInfo teacherSpeInfo = new TeacherSpeInfo();
				teacherSpeInfo.setName("專長");
				teacherSpeInfo.setFlag(true);
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
	public List<TeacherAwardInfo> getTeacherAwardInfo(TeacherBasicInfo info) {
		List<TeacherAwardInfo> out = new ArrayList<TeacherAwardInfo>();
		String sql = "select TEA_AWA_YEAR, TEA_AWA_DEP, TEA_AWA from tea_award "
				+ "where TEA_CODE = ? group by TEA_AWA_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherAwardInfo teacherAwardInfo = new TeacherAwardInfo();
				teacherAwardInfo.setName("研究獎勵");
				teacherAwardInfo.setFlag(true);
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
	public List<TeacherPlanInfo> getTeacherPlanInfo(TeacherBasicInfo info) {
		List<TeacherPlanInfo> out = new ArrayList<TeacherPlanInfo>();
		String sql = "select TEA_PLAN_PER, TEA_PLAN_LEADER, TEA_PLAN_NAME, TEA_PLAN_SPON, TEA_PLAN_MON, TEA_PLAN_POS "
				+ "from tea_plan where TEA_CODE = ? and TEA_PLAN_NAME != '' order by TEA_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherPlanInfo teacherPlanInfo = new TeacherPlanInfo();
				teacherPlanInfo.setName("研究計劃");
				teacherPlanInfo.setFlag(true);
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
	public List<TeacherStuPaper> getTeacherStuPaper(TeacherBasicInfo info) {
		List<TeacherStuPaper> out = new ArrayList<TeacherStuPaper>();
		String sql = "select TEA_STU_YEAR, TEA_STU_NAME, TEA_STU_PAPER_NAME "
				+ "from tea_stu_paper where TEA_CODE = ? group by PaperID";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherStuPaper teacherStuPaper = new TeacherStuPaper();
				teacherStuPaper.setName("研究所論文指導");
				teacherStuPaper.setFlag(true);
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
	public List<TeacherStuTopic> getTeacherStuTopic(TeacherBasicInfo info) {
		List<TeacherStuTopic> out = new ArrayList<TeacherStuTopic>();
		String sql = "select TEA_STU_YEAR, TEA_STU_NAME from tea_stu_topic " + "where TEA_CODE = ? group by TopicID";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherStuTopic teacherStuTopic = new TeacherStuTopic();
				teacherStuTopic.setName("大學專題指導");
				teacherStuTopic.setFlag(true);
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
	public List<TeacherOtherInfo> getIssuePaper(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAA' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("期刊論文");
				teacherOtherInfo.setFlag(true);
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
	public List<TeacherOtherInfo> getMeetingPaper(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAB' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("研討會論文");
				teacherOtherInfo.setFlag(true);
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
	public List<TeacherOtherInfo> getBooks(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAC' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("書籍");
				teacherOtherInfo.setFlag(true);
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
	public List<TeacherOtherInfo> getTechReport(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAD' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("技術報告");
				teacherOtherInfo.setFlag(true);
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
	public List<TeacherOtherInfo> getTecherPaper(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAE' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("畢業論文");
				teacherOtherInfo.setFlag(true);
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
	public List<TeacherOtherInfo> getMagazinePaper(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAF' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("在資訊相關雜誌上近幾年發表之文章");
				teacherOtherInfo.setFlag(true);
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
	public List<TeacherOtherInfo> getWaitingPaper(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAG' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("期刊審查中論文");
				teacherOtherInfo.setFlag(true);
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
	public List<TeacherOtherInfo> getScholarPaper(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BAH' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("學術著作");
				teacherOtherInfo.setFlag(true);
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
	public List<TeacherOtherInfo> getPracticeReach(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'BDA' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("實務研究內容");
				teacherOtherInfo.setFlag(true);
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
	public List<TeacherOtherInfo> getOtherExp(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'CCA' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("其他教學經驗");
				teacherOtherInfo.setFlag(true);
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
	public List<TeacherOtherInfo> getInSchService(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'DAA' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("校內服務內容");
				teacherOtherInfo.setFlag(true);
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
	public List<TeacherOtherInfo> getOutSchService(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'DBA' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("校外服務內容");
				teacherOtherInfo.setFlag(true);
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
	public List<TeacherOtherInfo> getAsCommitMem(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'DCA' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("擔任委員內容");
				teacherOtherInfo.setFlag(true);
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
	public List<TeacherOtherInfo> getScholarExp(TeacherBasicInfo info) {
		List<TeacherOtherInfo> out = new ArrayList<TeacherOtherInfo>();
		String sql = "select TEA_DATA_CONT, TEA_DATA_PER from tea_data_per_cont "
				+ "where TEA_CODE = ? and TEA_DATA_SUB_CODE = 'DDA' group by TEA_DATA_CONT_CODE";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, info.getTeaCode());
			rs = smt.executeQuery();
			while (rs.next()) {
				TeacherOtherInfo teacherOtherInfo = new TeacherOtherInfo();
				teacherOtherInfo.setName("學術經驗內容");
				teacherOtherInfo.setFlag(true);
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

}
