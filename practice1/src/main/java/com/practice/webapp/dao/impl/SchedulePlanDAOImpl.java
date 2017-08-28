package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.dao.SchedulePlanDAO;
import com.practice.webapp.entity.course.SchedulePlan;

public class SchedulePlanDAOImpl implements SchedulePlanDAO {
	private DataSource dataSource;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement smt;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<SchedulePlan> getSchedulePlanListU() {
		// TODO Auto-generated method stub
		List<SchedulePlan> scheduleplanlistU = new ArrayList<SchedulePlan>();
		// String sqlU = "SELECT * FROM schedule_plan, plan WHERE
		// schedule_plan.PLAN_CODE = plan.PLAN_CODE AND DIV_CODE='U' ORDER BY
		// schedule_plan.YEAR DESC";
		String sqlU = "SELECT * FROM `schedule_plan`, plan WHERE schedule_plan.PLAN_CODE = plan.PLAN_CODE AND schedule_plan.DIV_CODE ='U' ORDER BY YEAR DESC,schedule_plan.PLAN_CODE ASC, Semester ASC";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlU);
			rs = smt.executeQuery();
			while (rs.next()) {
				SchedulePlan scheduleplanU = new SchedulePlan();
				scheduleplanU.setScheduleplanid(rs.getInt("SchedulePlanID"));
				scheduleplanU.setYear(rs.getInt("YEAR"));
				scheduleplanU.setSemester(rs.getString("Semester"));
				scheduleplanU.setSche_cont(rs.getString("SCHE_CONT"));
				scheduleplanU.setDiv_code(rs.getString("DIV_CODE"));
				scheduleplanU.setPlan_code(rs.getInt("PLAN_CODE"));
				scheduleplanU.setPlan_name(rs.getString("PLAN_NAME"));
				scheduleplanlistU.add(scheduleplanU);
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
		return scheduleplanlistU;
	}

	public List<SchedulePlan> getSchedulePlanListM() {
		// TODO Auto-generated method stub
		List<SchedulePlan> scheduleplanlistM = new ArrayList<SchedulePlan>();
		String sqlM = "SELECT * FROM `schedule_plan`, plan WHERE schedule_plan.PLAN_CODE = plan.PLAN_CODE AND schedule_plan.DIV_CODE ='M' ORDER BY YEAR DESC,schedule_plan.PLAN_CODE ASC, Semester ASC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlM);
			rs = smt.executeQuery();
			while (rs.next()) {
				SchedulePlan scheduleplanM = new SchedulePlan();
				scheduleplanM.setScheduleplanid(rs.getInt("SchedulePlanID"));
				scheduleplanM.setYear(rs.getInt("YEAR"));
				scheduleplanM.setSemester(rs.getString("Semester"));
				scheduleplanM.setSche_cont(rs.getString("SCHE_CONT"));
				scheduleplanM.setDiv_code(rs.getString("DIV_CODE"));
				scheduleplanM.setPlan_code(rs.getInt("PLAN_CODE"));
				scheduleplanM.setPlan_name(rs.getString("PLAN_NAME"));
				scheduleplanlistM.add(scheduleplanM);
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
		return scheduleplanlistM;
	}

	public List<SchedulePlan> getSchedulePlanListE() {
		// TODO Auto-generated method stub
		List<SchedulePlan> scheduleplanlistE = new ArrayList<SchedulePlan>();
		// String sqlE = "SELECT * FROM schedule_plan, plan WHERE
		// schedule_plan.PLAN_CODE = plan.PLAN_CODE AND DIV_CODE='E' ORDER BY
		// schedule_plan .YEAR DESC";
		String sqlE = "SELECT * FROM `schedule_plan`, plan WHERE schedule_plan.PLAN_CODE = plan.PLAN_CODE AND schedule_plan.DIV_CODE ='E' ORDER BY YEAR DESC,schedule_plan.PLAN_CODE ASC, Semester ASC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlE);
			rs = smt.executeQuery();
			while (rs.next()) {
				SchedulePlan scheduleplanE = new SchedulePlan();
				scheduleplanE.setScheduleplanid(rs.getInt("SchedulePlanID"));
				scheduleplanE.setYear(rs.getInt("YEAR"));
				scheduleplanE.setSemester(rs.getString("Semester"));
				scheduleplanE.setSche_cont(rs.getString("SCHE_CONT"));
				scheduleplanE.setDiv_code(rs.getString("DIV_CODE"));
				scheduleplanE.setPlan_code(rs.getInt("PLAN_CODE"));
				scheduleplanE.setPlan_name(rs.getString("PLAN_NAME"));
				scheduleplanlistE.add(scheduleplanE);
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
		return scheduleplanlistE;
	}

	public List<SchedulePlan> getSchedulePlanListD() {
		// TODO Auto-generated method stub
		List<SchedulePlan> scheduleplanlistD = new ArrayList<SchedulePlan>();
		String sqlD = "SELECT * FROM `schedule_plan`, plan WHERE schedule_plan.PLAN_CODE = plan.PLAN_CODE AND schedule_plan.DIV_CODE ='D' ORDER BY YEAR DESC,schedule_plan.PLAN_CODE ASC, Semester ASC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlD);
			rs = smt.executeQuery();
			while (rs.next()) {
				SchedulePlan scheduleplanD = new SchedulePlan();
				scheduleplanD.setScheduleplanid(rs.getInt("SchedulePlanID"));
				scheduleplanD.setYear(rs.getInt("YEAR"));
				scheduleplanD.setSemester(rs.getString("Semester"));
				scheduleplanD.setSche_cont(rs.getString("SCHE_CONT"));
				scheduleplanD.setDiv_code(rs.getString("DIV_CODE"));
				scheduleplanD.setPlan_code(rs.getInt("PLAN_CODE"));
				scheduleplanD.setPlan_name(rs.getString("PLAN_NAME"));
				scheduleplanlistD.add(scheduleplanD);
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
		return scheduleplanlistD;
	}

	public List<SchedulePlan> getSchedulePlanListF() {
		// TODO Auto-generated method stub
		List<SchedulePlan> scheduleplanlistF = new ArrayList<SchedulePlan>();
		String sqlF = "SELECT * FROM `schedule_plan`, plan WHERE schedule_plan.PLAN_CODE = plan.PLAN_CODE AND schedule_plan.DIV_CODE ='F' ORDER BY YEAR DESC,schedule_plan.PLAN_CODE ASC, Semester ASC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlF);
			rs = smt.executeQuery();
			while (rs.next()) {
				SchedulePlan scheduleplanF = new SchedulePlan();
				scheduleplanF.setScheduleplanid(rs.getInt("SchedulePlanID"));
				scheduleplanF.setYear(rs.getInt("YEAR"));
				scheduleplanF.setSemester(rs.getString("Semester"));
				scheduleplanF.setSche_cont(rs.getString("SCHE_CONT"));
				scheduleplanF.setDiv_code(rs.getString("DIV_CODE"));
				scheduleplanF.setPlan_code(rs.getInt("PLAN_CODE"));
				scheduleplanF.setPlan_name(rs.getString("PLAN_NAME"));
				scheduleplanlistF.add(scheduleplanF);
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
		return scheduleplanlistF;
	}

	public void update(SchedulePlan scheduleplan) {

		String sqlup = "UPDATE schedule_plan SET YEAR=?, PLAN_CODE=?, SCHE_CONT=? WHERE SchedulePlanID=?";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlup);
			smt.setInt(1, scheduleplan.getYear());
			smt.setInt(2, scheduleplan.getPlan_code());
			// smt.setString(3,scheduleplan.getSemester());
			smt.setString(3, scheduleplan.getSche_cont());
			smt.setInt(4, scheduleplan.getScheduleplanid());
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

	public List<SchedulePlan> getPlanList() {
		// TODO Auto-generated method stub
		List<SchedulePlan> planList = new ArrayList<SchedulePlan>();
		String sqlPlan = "SELECT * FROM plan ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlPlan);
			rs = smt.executeQuery();
			while (rs.next()) {
				SchedulePlan plan = new SchedulePlan();
				plan.setPlan_code(rs.getInt("PLAN_CODE"));
				plan.setPlan_name(rs.getString("PLAN_NAME"));
				planList.add(plan);
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
		return planList;
	}
}
