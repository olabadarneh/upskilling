package project.test;

import java.util.ArrayList;
import java.util.List;
import project.bean.Student;
import project.bean.StudentResult;
import project.bean.TrainingCourse;
import project.dao.StudentResultDAO;

public class TestStudentResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentResultDAO resultDAO = new StudentResultDAO();
		List<StudentResult> studentResultTable = new ArrayList<StudentResult>();
		int row;

		// insertTable
		StudentResult studentResult = new StudentResult();
		studentResult.setStudentID(new Student(8));
		studentResult.setTrainingCourseID(new TrainingCourse(15));
		studentResult.setEnglishMark(30);
		studentResult.setInterviewMark(30);
		studentResult.setAcceptedFlag(true);
		studentResult.setNotes("fewrgyyy");
		row = resultDAO.insert(studentResult);

		System.out.println("inserted " + row);

		// update
//		StudentResult studentResult = new StudentResult();
//		studentResult.setStudentID(new Student(9));
//		studentResult.setTrainingCourseID(new TrainingCourse(10));
//		studentResult.setEnglishMark(9);
//		row = resultDAO.update(studentResult);
//		System.out.println("updated " + row);

		// delete
//		row = resultDAO.delete(9);
//		System.out.println("daleted" + row);

		// selectTable
		studentResultTable = resultDAO.selectAll();
		System.out.println(studentResultTable);

	}

}
