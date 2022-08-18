package project.bean;

public class StudentTrainingCourse {
	private Student student;
	private TrainingCourse trainingCourseID;
	private int priority;
	private String Course;

	public StudentTrainingCourse() {
		// default constructor.
	}

	public StudentTrainingCourse(Student student, TrainingCourse trainingCourseID, int priority, String course) {
		this.student = student;
		this.trainingCourseID = trainingCourseID;
		this.priority = priority;
		Course = course;
	}

	// setters & getters.
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student studentID) {
		this.student = studentID;
	}

	public TrainingCourse getTrainingCourseID() {
		return trainingCourseID;
	}

	public void setTrainingCourseID(TrainingCourse trainingCourseID) {
		this.trainingCourseID = trainingCourseID;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}

	@Override
	public String toString() {
		return "StudentTrainingCourse [studentID=" + student + ", trainingCourseID=" + trainingCourseID + ", priority="
				+ priority + "]" + "\n";
	}

}
