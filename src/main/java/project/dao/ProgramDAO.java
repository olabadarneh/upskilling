package project.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.bean.Program;
import project.database.Database;

public class ProgramDAO {
////////////////////////////////////////////////////////////////////////////////////
	private project.database.Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<Program> programTable;
	private int row;

	///////////////////////////////////////////////////////////////////////////////////////
	// Select All
	public List<Program> selectAll() {
		programTable = new ArrayList<Program>();
		try {
			db = new project.database.Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select program_id, program_aname, program_ename,school_id from program  order by school_id,program_id");
			rs = ps.executeQuery();
			while (rs.next()) {
				Program program = new Program(rs.getInt("program_id"), rs.getString("program_ename"));
				program.setProgramAname(rs.getString("program_aname"));
				SchoolDAO schooldao = new SchoolDAO();
				program.setSchool(schooldao.selectById(rs.getInt("school_id")));

				programTable.add(program);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return programTable;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Select By ID
	public Program selectById(int id) {
		Program program = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select program_id, program_aname, program_ename from program where program_id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				program = new Program(rs.getInt("program_id"), rs.getString("program_aname"),
						rs.getString("program_ename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return program;
	}

	/////////////////////////////////////////////////////////////////////////////////////////

	public List<String> selectProgAname() {

		List<String> programTable = new ArrayList<String>();
		try {
			db = new Database();
			programTable = new ArrayList<String>();
			connection = db.getConnection();
			ps = connection.prepareStatement("select distinct PROGRAM_ANAME from program order BY 1  ");
			rs = ps.executeQuery();
			while (rs.next()) {

				programTable.add(rs.getString("PROGRAM_ANAME"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return programTable;
	}

	///////////////////////////////////////////////////////////////////////////////////////

	public int selectMaxID() {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select nvl (max(PROGRAM_ID),0) AS PROGRAM_ID from PROGRAM ");
			rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt("PROGRAM_ID");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return 0;

	}

	/////////////////////////////////////////////////////////////////////////////////////////
	// Insert
	public int insert(Program program) {

		int maxId = selectMaxID();
		System.out.println(maxId);

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into program (program_id, program_aname, program_ename,school_id) values(?, ?, ?, ?)");
			int counter = 1;
			// ps.setInt(counter++, program.getProgramID());
			ps.setInt(counter++, maxId + 1);
			ps.setString(counter++, program.getProgramAname());
			ps.setString(counter++, program.getProgramEname());
			ps.setInt(counter++, program.getSchool().getSchoolID());
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	// Update
	public int update(Program program) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update program set program_aname = ?, program_ename = ?, school_id=? where program_id = ?");
			int counter = 1;
			ps.setString(counter++, program.getProgramAname());
			ps.setString(counter++, program.getProgramEname());
			ps.setInt(counter++, program.getSchool().getSchoolID());
			ps.setInt(counter++, program.getProgramID());
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	// Delete
	public int delete(int id) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete from program where program_id = ?");
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
