package project.test;

import java.util.ArrayList;
import java.util.List;

import project.bean.University;
import project.dao.UniversityDAO;

public class TestUniversity {

	public static void main(String[] args) {

		UniversityDAO universitydao = new UniversityDAO();
		List<University> UniversityTable = new ArrayList<University>();
		int row;

		// delete
		row = universitydao.delete(23);
		System.out.println("daleted  " + row);

		// insertTable
		row = universitydao
				.insert(new University(1, "الجامعة الأردنية", "The Univsersity of Jordan", "http://www.ju.edu.jo"));
		System.out.println("inserted  " + row);

		// insertTable
		row = universitydao.insert(new University(20, "جامعة الزيتونة الأردنية", "Al-Zaytoonah University(ZUJ)",
				"https://www.zuj.edu.jo"));
		System.out.println("inserted  " + row);

		// update
		row = universitydao.update(
				new University(20, "جامعة الزيتونة الأردنية", "Al-Zaytoonah University", "https://www.zuj.edu.jo"));
		System.out.println("updated  " + row);

		// selectTable
		UniversityTable = universitydao.selectAll();
		System.out.println(UniversityTable);

	}

}
