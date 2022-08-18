package project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import project.bean.User;
import project.database.Database;

public class UserDAO {

	private project.database.Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private int row;
	private int counter = 1;

	public int insert(User user) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into USER_TBL (USER_ID ,  FIRST_NAME ,  LAST_NAME ,  SEX ,  BIRTHDATE, COUNTRY ,   EMAIL ,  PWD,  SAL , PHONE  )  values (? , ? , ? , ? , ? , ? , ? , ? , ?, ?) ");

			ps.setInt(counter++, 3);
			ps.setString(counter++, user.getFirstName());
			ps.setString(counter++, user.getLastName());
			ps.setInt(counter++, user.getSex());
			ps.setDate(counter++, new Date(user.getBirthDate().getTime()));
			ps.setString(counter++, user.getCountry());
			ps.setString(counter++, user.getEmailAddress());
			ps.setString(counter++, user.getPassword());
			ps.setDouble(counter++, user.getExpectedSalary());
			ps.setString(counter++, user.getPhone());

			row = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

/////////////////////////////////////////////////////////////////////////////////////////////
	public User selectbyemail(String email, String password) {

		User user = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select * from USER_TBL where EMAIL =? and PWD =?");

			ps.setString(1, email);
			ps.setString(2, password);

			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setEmailAddress(rs.getString("EMAIL"));
				user.setPassword(rs.getString("PWD"));
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
}
