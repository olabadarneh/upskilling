package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.Interviews;
import project.bean.Student;
import project.dao.InterviewsDAO;
import project.email.Email;

@ViewScoped
@ManagedBean(name = "mbInterviews")
public class MBInterviews {
	private Interviews interviews;
	private List<Interviews> interviewsTable;
	private InterviewsDAO interviewsDAO;
	private Student student;
	private List<Student> stdTable;

	@PostConstruct
	public void init() {
		interviewsDAO = new InterviewsDAO();
		interviewsTable = interviewsDAO.sellectAll();
		interviews = new Interviews();

		student = new Student();
	}

	public void sendEmail() {
		for (int i = 0; i < interviewsTable.size(); i++) {
			Email.sendEmail(interviewsTable.get(i).getStudentID().getStudentEmail(),
					interviewsTable.get(i).getStudentID().getMessage());
		}
		System.out.println("All email sent successfully");
	}

	public Interviews getInterviews() {
		return interviews;
	}

	public void setInterviews(Interviews interviews) {
		this.interviews = interviews;
	}

	public List<Interviews> getInterviewsTable() {
		return interviewsTable;
	}

	public void setInterviewsTable(List<Interviews> interviewsTable) {
		this.interviewsTable = interviewsTable;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStdTable() {
		return stdTable;
	}

	public void setStdTable(List<Student> stdTable) {
		this.stdTable = stdTable;
	}
}
