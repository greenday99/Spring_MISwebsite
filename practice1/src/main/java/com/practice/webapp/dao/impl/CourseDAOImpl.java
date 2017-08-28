package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.dao.CourseDAO;
import com.practice.webapp.entity.course.Course;

public class CourseDAOImpl implements CourseDAO {
	private DataSource dataSource;
	private Connection conn ;
	private ResultSet rs ;
	private PreparedStatement smt ;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Course> getCourseListU11() {
		// TODO Auto-generated method stub
		List<Course> courseListU11 = new ArrayList<Course>();
		String sqlU11 = "SELECT * FROM schedule_time, division_class WHERE schedule_time.DC_CODE = division_class.DC_CODE AND schedule_time.DC_CODE = 'U11'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlU11);
			rs = smt.executeQuery();
			while (rs.next()) {
				Course courseU11 = new Course();
				courseU11.setDc_code(rs.getString("DC_CODE"));
				courseU11.setDc_class(rs.getString("DC_CLASS"));
				courseU11.setClass_sche(rs.getString("CLASS_SCHE"));
				courseU11.setDiv_code(rs.getString("DIV_CODE"));
				courseListU11.add(courseU11);
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
		return courseListU11;

	}

	public List<Course> getCourseListU12() {
		// TODO Auto-generated method stub
		List<Course> courseListU12 = new ArrayList<Course>();
		String sqlU12 = "SELECT * FROM schedule_time, division_class WHERE schedule_time.DC_CODE = division_class.DC_CODE AND schedule_time.DC_CODE = 'U12'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlU12);
			rs = smt.executeQuery();
			while (rs.next()) {
				Course courseU12 = new Course();
				courseU12.setDc_code(rs.getString("DC_CODE"));
				courseU12.setDc_class(rs.getString("DC_CLASS"));
				courseU12.setClass_sche(rs.getString("CLASS_SCHE"));
				courseU12.setDiv_code(rs.getString("DIV_CODE"));
				courseListU12.add(courseU12);
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
		return courseListU12;

	}

	public List<Course> getCourseListU21() {
		// TODO Auto-generated method stub
		List<Course> courseListU21 = new ArrayList<Course>();
		String sqlU21 = "SELECT * FROM schedule_time, division_class WHERE schedule_time.DC_CODE = division_class.DC_CODE AND schedule_time.DC_CODE = 'U21'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlU21);
			rs = smt.executeQuery();
			while (rs.next()) {
				Course courseU21 = new Course();
				courseU21.setDc_code(rs.getString("DC_CODE"));
				courseU21.setDc_class(rs.getString("DC_CLASS"));
				courseU21.setClass_sche(rs.getString("CLASS_SCHE"));
				courseU21.setDiv_code(rs.getString("DIV_CODE"));
				courseListU21.add(courseU21);
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
		return courseListU21;

	}

	public List<Course> getCourseListU22() {
		// TODO Auto-generated method stub
		List<Course> courseListU22 = new ArrayList<Course>();
		String sqlU22 = "SELECT * FROM schedule_time, division_class WHERE schedule_time.DC_CODE = division_class.DC_CODE AND schedule_time.DC_CODE = 'U22'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlU22);
			rs = smt.executeQuery();
			while (rs.next()) {
				Course courseU22 = new Course();
				courseU22.setDc_code(rs.getString("DC_CODE"));
				courseU22.setDc_class(rs.getString("DC_CLASS"));
				courseU22.setClass_sche(rs.getString("CLASS_SCHE"));
				courseU22.setDiv_code(rs.getString("DIV_CODE"));
				courseListU22.add(courseU22);
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
		return courseListU22;

	}

	public List<Course> getCourseListU31() {
		// TODO Auto-generated method stub
		List<Course> courseListU31 = new ArrayList<Course>();
		String sqlU31 = "SELECT * FROM schedule_time, division_class WHERE schedule_time.DC_CODE = division_class.DC_CODE AND schedule_time.DC_CODE = 'U31'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlU31);
			rs = smt.executeQuery();
			while (rs.next()) {
				Course courseU31 = new Course();
				courseU31.setDc_code(rs.getString("DC_CODE"));
				courseU31.setDc_class(rs.getString("DC_CLASS"));
				courseU31.setClass_sche(rs.getString("CLASS_SCHE"));
				courseU31.setDiv_code(rs.getString("DIV_CODE"));
				courseListU31.add(courseU31);
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
		return courseListU31;

	}

	public List<Course> getCourseListU32() {
		// TODO Auto-generated method stub
		List<Course> courseListU32 = new ArrayList<Course>();
		String sqlU32 = "SELECT * FROM schedule_time, division_class WHERE schedule_time.DC_CODE = division_class.DC_CODE AND schedule_time.DC_CODE = 'U32'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlU32);
			rs = smt.executeQuery();
			while (rs.next()) {
				Course courseU32 = new Course();
				courseU32.setDc_code(rs.getString("DC_CODE"));
				courseU32.setDc_class(rs.getString("DC_CLASS"));
				courseU32.setClass_sche(rs.getString("CLASS_SCHE"));
				courseU32.setDiv_code(rs.getString("DIV_CODE"));
				courseListU32.add(courseU32);
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
		return courseListU32;

	}

	public List<Course> getCourseListU41() {
		// TODO Auto-generated method stub
		List<Course> courseListU41 = new ArrayList<Course>();
		String sqlU41 = "SELECT * FROM schedule_time, division_class WHERE schedule_time.DC_CODE = division_class.DC_CODE AND schedule_time.DC_CODE = 'U41'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlU41);
			rs = smt.executeQuery();
			while (rs.next()) {
				Course courseU41 = new Course();
				courseU41.setDc_code(rs.getString("DC_CODE"));
				courseU41.setDc_class(rs.getString("DC_CLASS"));
				courseU41.setClass_sche(rs.getString("CLASS_SCHE"));
				courseU41.setDiv_code(rs.getString("DIV_CODE"));
				courseListU41.add(courseU41);
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
		return courseListU41;

	}

	public List<Course> getCourseListM1() {
		// TODO Auto-generated method stub
		List<Course> courseListM1 = new ArrayList<Course>();
		String sqlM1 = "SELECT * FROM schedule_time, division_class WHERE schedule_time.DC_CODE = division_class.DC_CODE AND schedule_time.DC_CODE = 'M1'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlM1);
			rs = smt.executeQuery();
			while (rs.next()) {
				Course courseM1 = new Course();
				courseM1.setDc_code(rs.getString("DC_CODE"));
				courseM1.setDc_class(rs.getString("DC_CLASS"));
				courseM1.setClass_sche(rs.getString("CLASS_SCHE"));
				courseM1.setDiv_code(rs.getString("DIV_CODE"));
				courseListM1.add(courseM1);
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
		return courseListM1;

	}

	public List<Course> getCourseListE1() {
		// TODO Auto-generated method stub
		List<Course> courseListE1 = new ArrayList<Course>();
		String sqlE1 = "SELECT * FROM schedule_time, division_class WHERE schedule_time.DC_CODE = division_class.DC_CODE AND schedule_time.DC_CODE = 'E1'";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlE1);
			rs = smt.executeQuery();
			while (rs.next()) {
				Course courseE1 = new Course();
				courseE1.setDc_code(rs.getString("DC_CODE"));
				courseE1.setDc_class(rs.getString("DC_CLASS"));
				courseE1.setClass_sche(rs.getString("CLASS_SCHE"));
				courseE1.setDiv_code(rs.getString("DIV_CODE"));
				courseListE1.add(courseE1);
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
		return courseListE1;

	}

	public void update(Course course) {
		// TODO Auto-generated method stub
		String sqlup = "UPDATE schedule_time SET CLASS_SCHE=? WHERE DC_CODE=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sqlup);
			smt.setString(2, course.getDc_code());
			// smt.setString(2, course.getDc_class());
			smt.setString(1, course.getClass_sche());
			// smt.setString(4, course.getDiv_code());
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
}
