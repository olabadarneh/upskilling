package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.bean.TrainingCourse;
import project.database.Database;

public class TrainingCourseDAO {

	private project.database.Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<TrainingCourse> courseTable;
	private int row;

	/////////////////////////////////////////////////////////////////////////////////////

	public List<TrainingCourse> selectAll() {
		courseTable = new ArrayList<TrainingCourse>();
		try {
			db = new project.database.Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select course_id, course_aname, course_ename, max_students, short_desc, detailed_desc from Training_Course  order by course_id");
			rs = ps.executeQuery();
			while (rs.next()) {
				TrainingCourse course = new TrainingCourse(rs.getInt("course_id"), rs.getString("course_aname"),
						rs.getString("course_ename"), rs.getInt("max_students"), rs.getString("short_desc"),
						rs.getString("detailed_desc"));

				courseTable.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return courseTable;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////

	public TrainingCourse selectById(int id) {
		TrainingCourse course = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select course_id, course_aname, course_ename, max_students, short_desc, detailed_desc from Training_Course where course_id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				course = new TrainingCourse(rs.getInt("course_id"), rs.getString("course_aname"),
						rs.getString("course_ename"), rs.getInt("max_students"), rs.getString("short_desc"),
						rs.getString("detailed_desc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return course;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	public int insert(TrainingCourse course) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into Training_Course(course_id, course_aname, course_ename, max_students, short_desc, detailed_desc) values(?, ?, ?, ?, ?, ?)");
			int counter = 1;
			ps.setInt(counter++, course.getCourseID());
			ps.setString(counter++, course.getCourseAname());
			ps.setString(counter++, course.getCourseEname());
			ps.setInt(counter++, course.getMaxStudent());
			ps.setString(counter++, course.getShortDesc());
			ps.setString(counter++, course.getDetailedDesc());
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public int update(TrainingCourse course) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update Training_Course set course_aname = ?, course_ename = ? , max_students = ?, short_desc = ? , detailed_desc = ? where course_id = ?");

			int counter = 1;
			ps.setString(counter++, course.getCourseAname());
			ps.setString(counter++, course.getCourseEname());
			ps.setInt(counter++, course.getMaxStudent());
			ps.setString(counter++, course.getShortDesc());
			ps.setString(counter++, course.getDetailedDesc());
			ps.setInt(counter++, course.getCourseID());
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public int delete(int id) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete from Training_Course where course_id = ?");
			ps.setInt(1, id);
			row = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

}
