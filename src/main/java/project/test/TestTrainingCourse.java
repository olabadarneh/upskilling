package project.test;

import java.util.ArrayList;
import java.util.List;

import project.bean.TrainingCourse;
import project.dao.TrainingCourseDAO;

public class TestTrainingCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrainingCourseDAO coursedao = new TrainingCourseDAO();
		List<TrainingCourse> courseTable = new ArrayList<TrainingCourse>();
		int row;

		// insertTable
		row = coursedao.insert(new TrainingCourse(19, "nameTrainingCourse", 15));
		System.out.println("inserted " + row);

		// update
//		row = coursedao.update(new TrainingCourse(23, "testNameTrainingCourse", 17));
//		System.out.println("updated " + row);

		// delete
//		row = coursedao.delete(23);
//		System.out.println("daleted" + row);

		// selectTable
		courseTable = coursedao.selectAll();
		System.out.println(courseTable);

	}

}
