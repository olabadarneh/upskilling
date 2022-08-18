package project.test;

import java.util.ArrayList;
import java.util.List;
import project.bean.Student;
import project.bean.StudentTrainingCourse;
import project.bean.TrainingCourse;
import project.dao.StudentTrainingCourseDAO;

public class TestStudentTrainingCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentTrainingCourseDAO studentTrainingCoursDAO = new StudentTrainingCourseDAO();
		List<StudentTrainingCourse> studentTrainingCourseTable = new ArrayList<StudentTrainingCourse>();
		int row;

		// insertTable
//		StudentTrainingCourse studentTrainingCourse = new StudentTrainingCourse();
//		studentTrainingCourse.setStudent(new Student(11));
//		studentTrainingCourse.setTrainingCourseID(new TrainingCourse(13));
//		studentTrainingCourse.setPriority(1);
//		studentTrainingCourse.setCourse("cnwahfe;ga.e");
//		row = studentTrainingCoursDAO.insert(studentTrainingCourse);
//		System.out.println("inserted " + row);

		// update
		StudentTrainingCourse studentTrainingCourse = new StudentTrainingCourse();
		studentTrainingCourse.setStudent(new Student(11));
		studentTrainingCourse.setTrainingCourseID(new TrainingCourse(13));
		studentTrainingCourse.setPriority(1);
		row = studentTrainingCoursDAO.update(studentTrainingCourse);
		System.out.println("updated " + row);

		// delete
//		row = studentTrainingCoursDAO.delete(7);
//		System.out.println("daleted" + row);

		// selectTable
		studentTrainingCourseTable = studentTrainingCoursDAO.selectAll();
		System.out.println(studentTrainingCourseTable);

	}

}
