package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.bean.Interviews;
import project.database.Database;

public class InterviewsDAO {

	private project.database.Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<Interviews> interviewsTable;

	///////////////////////////////////////////////////////////////////////////////////////
	// Select All
	public List<Interviews> sellectAll() {
		interviewsTable = new ArrayList<Interviews>();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select interviews_id , student_id , interviews_date , interviews_time from interviews order by interviews_id , student_id");
			rs = ps.executeQuery();
			while (rs.next()) {
				Interviews interviews = new Interviews(rs.getInt("interviews_id"), rs.getDate("interviews_date"),
						rs.getTime("interviews_time"));
				StudentDAO stdDAO = new StudentDAO();
				interviews.setStudentID(stdDAO.selectById(rs.getInt("student_id")));
				interviewsTable.add(interviews);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return interviewsTable;
	}
}
