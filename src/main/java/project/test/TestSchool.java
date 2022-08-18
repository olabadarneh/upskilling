package project.test;

import java.util.ArrayList;
import java.util.List;

import project.bean.School;
import project.dao.SchoolDAO;

public class TestSchool {

	public static void main(String[] args) {
		SchoolDAO schooldao = new SchoolDAO();
		List<School> SchoolTable = new ArrayList<School>();
		int row;

		// delete
		row = schooldao.delete(23);
		System.out.println("daleted " + row);

		// insertTable
		row = schooldao.insert(new School(23, "nameSchool"));
		System.out.println("inserted " + row);

		// update
		row = schooldao.update(new School(23, "testNameSchool"));
		System.out.println("updated " + row);

		row = schooldao.delete(23);
		System.out.println("daleted " + row);

		// selectTable
		SchoolTable = schooldao.selectAll();
		System.out.println(SchoolTable);
	}
}
