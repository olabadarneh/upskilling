package project.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.bean.Program;
import project.bean.School;
import project.bean.Student;
import project.bean.University;
import project.dao.StudentDAO;

public class TestStudent {

	public static void main(String[] args) {

		StudentDAO studentdao = new StudentDAO();
		List<Student> studentTable = new ArrayList<Student>();
		int row;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		System.out.println(sdf.format(now));

		// insertTable
		Student student = new Student();
		student.setStudentAname("ريما ");
		student.setStudentSchool(new School(8));
		student.setStudentUniversity(new University(10));
		student.setStudentProgram(new Program(14));
		student.setStudentBirthDate(new Date());
		row = studentdao.insert(student);
		System.out.println("inserted " + row);

//		// delete
//		row = studentdao.delete(9);
//		System.out.println("daleted" + row);

		// update
//		Student student = new Student();
//		student.setStudentID(9);
//		student.setStudentAname("عبير احمد");
//		student.setStudentEname("Abeer Ahmad");
//		student.setStudentSchool(new School(1));
//		student.setStudentProg(new Program(2));
//		student.setStudentUni(new University(10));
//		student.setStudentBirthDate(new Date());
//		student.setStudentPhoneNo("07985773904");
//		student.setStudentEmail("abeer@yahoo.com");
//		student.setStudentSex("Female");
//		student.setStudentFinalAverage(67.4);
//		student.setStudentMaxAverage(32.0);
//		student.setStudentRate(2);
//		student.setStudentGradYear(2022);
//		student.setStudentGradSum(1);
//		row = studentdao.update(student);
//		System.out.println("updated " + row);

		// selectTable
		studentTable = studentdao.selectAll();
		System.out.println(studentTable);

	}

}
