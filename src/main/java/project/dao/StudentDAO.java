package project.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import project.bean.Student;
import project.database.Database;

public class StudentDAO {

	private project.database.Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<Student> studentTable;
	private int row;

	///////////////////////////////////////////////////////////////////////////////////

	public List<Student> selectAll() {
		studentTable = new ArrayList<Student>();
		try {
			db = new project.database.Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select student_id, student_aname, student_ename, mobile, birthdate, sex, email, final_average, max_average ,"
							+ " rate, graduate_year, graduate_sum , university_id, school_id, program_id ,message from student  order by  student_id");
			rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student(rs.getInt("student_id"), rs.getString("student_ename"),
						rs.getString("mobile"));
				student.setStudentAname(rs.getString("student_aname"));
				student.setStudentBirthDate(rs.getDate("birthdate"));
				student.setStudentSex(rs.getString("sex"));
				student.setStudentEmail(rs.getString("email"));
				student.setStudentFinalAverage(rs.getDouble("final_average"));
				student.setStudentMaxAverage(rs.getDouble("max_average"));
				student.setStudentRate(rs.getInt("rate"));
				student.setStudentGradYear(rs.getInt("graduate_year"));
				student.setStudentGradSum(rs.getInt("graduate_sum"));
				student.setStudentEmail(rs.getString("message"));

				UniversityDAO universitydao = new UniversityDAO();
				student.setStudentUni(universitydao.selectById(rs.getInt("university_id")));
				SchoolDAO schooldao = new SchoolDAO();
				student.setStudentSchool(schooldao.selectById(rs.getInt("school_id")));
				ProgramDAO programdao = new ProgramDAO();
				student.setStudentProg(programdao.selectById(rs.getInt("program_id")));

				studentTable.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return studentTable;
	}

	//////////////////////////////////////////////////////////////////////////////////

	public Student selectById(int id) {
		Student student = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select  student_id, student_aname, student_ename, mobile, birthdate, sex, email, final_average, max_average ,"
							+ " rate, graduate_year, graduate_sum, university_id, school_id, program_id from student where student_id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student(rs.getInt("student_id"), rs.getString("student_ename"), rs.getString("mobile"));
				student.setStudentAname(rs.getString("student_aname"));
				student.setStudentBirthDate(rs.getDate("birthdate"));
				student.setStudentSex(rs.getString("sex"));
				student.setStudentEmail(rs.getString("email"));
				student.setStudentFinalAverage(rs.getDouble("final_average"));
				student.setStudentMaxAverage(rs.getDouble("max_average"));
				student.setStudentRate(rs.getInt("rate"));
				student.setStudentGradYear(rs.getInt("graduate_year"));
				student.setStudentGradSum(rs.getInt("graduate_sum"));

				UniversityDAO universitydao = new UniversityDAO();
				student.setStudentUni(universitydao.selectById(rs.getInt("university_id")));
				SchoolDAO schooldao = new SchoolDAO();
				student.setStudentSchool(schooldao.selectById(rs.getInt("school_id")));
				ProgramDAO programdao = new ProgramDAO();
				student.setStudentProg(programdao.selectById(rs.getInt("program_id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return student;
	}

	//////////////////////////////////////////////////////////////////////////////////////

	public List<String> selectByAname() {

		List<String> stdTable = new ArrayList<String>();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select distinct STUDENT_ANAME from student order BY 1  ");
			rs = ps.executeQuery();
			if (rs.next()) {
				stdTable.add(rs.getString("student_aname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return stdTable;
	}

	///////////////////////////////////////////////////////////////////////////////////////

	public int insert(Student student) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into student ( student_id, student_aname, student_ename, mobile, birthdate, sex, email, final_average, max_average , rate, graduate_year, graduate_sum, university_id, school_id, program_id)"
							+ " values(?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?)");
			int counter = 1;
			ps.setInt(counter++, student.getStudentID());
			ps.setString(counter++, student.getStudentAname());
			ps.setString(counter++, student.getStudentEname());
			ps.setString(counter++, student.getStudentPhoneNo());
			ps.setDate(counter++, new Date(student.getStudentBirthDate().getTime()));
			ps.setString(counter++, student.getStudentSex());
			ps.setString(counter++, student.getStudentEmail());
			ps.setDouble(counter++, student.getStudentFinalAverage());
			ps.setDouble(counter++, student.getStudentMaxAverage());
			ps.setInt(counter++, student.getStudentRate());
			ps.setInt(counter++, student.getStudentGradYear());
			ps.setInt(counter++, student.getStudentGradSum());
			ps.setString(counter++, student.getMessage());
			ps.setInt(counter++, student.getStudentUniversity().getUniversityID());
			ps.setInt(counter++, student.getStudentSchool().getSchoolID());
			ps.setInt(counter++, student.getStudentProg().getProgramID());
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

	public int update(Student student) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update student set   student_aname=?, student_ename=?, mobile=?, birthdate=?, sex=?, email=?, final_average=?, max_average=? , rate=?, graduate_year=?,"
							+ " graduate_sum=?, university_id=?, school_id=?, program_id=? where student_id = ?");
			int counter = 1;
			ps.setString(counter++, student.getStudentAname());
			ps.setString(counter++, student.getStudentEname());
			ps.setString(counter++, student.getStudentPhoneNo());
			ps.setDate(counter++, new Date(student.getStudentBirthDate().getTime()));
			ps.setString(counter++, student.getStudentSex());
			ps.setString(counter++, student.getStudentEmail());
			ps.setDouble(counter++, student.getStudentFinalAverage());
			ps.setDouble(counter++, student.getStudentMaxAverage());
			ps.setInt(counter++, student.getStudentRate());
			ps.setInt(counter++, student.getStudentGradYear());
			ps.setInt(counter++, student.getStudentGradSum());
			ps.setInt(counter++, student.getStudentUniversity().getUniversityID());
			ps.setInt(counter++, student.getStudentSchool().getSchoolID());
			ps.setInt(counter++, student.getStudentProg().getProgramID());
			ps.setInt(counter++, student.getStudentID());
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

///////////////////////////////////////////////////////////////////////

	public int delete(int id) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete from student where student_id = ?");
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
