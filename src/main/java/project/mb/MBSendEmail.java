package project.mb;

import javax.faces.bean.ManagedBean;

import project.bean.Student;
import project.email.email;

@ManagedBean(name = "mbSendEmail")
public class MBSendEmail {

	private Student student;

	public void sendEmail() {
		for (int i = 0; i <= student.getStudentID(); i++) {
			email.sendEmail(student.getStudentEmail(), student.getMessage());
		}
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
