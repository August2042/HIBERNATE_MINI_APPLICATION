package javaBeans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long student_id;
	private String student_name;
	private String student_gender;
	private String student_email;
	private String student_mobileNo;
	private String student_address;
	private String student_age;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String student_name, String student_gender, String student_email, String student_mobileNo,
			String student_address, String student_age) {
		super();
		this.student_name = student_name;
		this.student_gender = student_gender;
		this.student_email = student_email;
		this.student_mobileNo = student_mobileNo;
		this.student_address = student_address;
		this.student_age = student_age;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_gender() {
		return student_gender;
	}

	public void setStudent_gender(String student_gender) {
		this.student_gender = student_gender;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getStudent_mobileNo() {
		return student_mobileNo;
	}

	public void setStudent_mobileNo(String student_mobileNo) {
		this.student_mobileNo = student_mobileNo;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public String getStudent_age() {
		return student_age;
	}

	public void setStudent_age(String student_age) {
		this.student_age = student_age;
	}

	public Long getStudent_id() {
		return student_id;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_gender="
				+ student_gender + ", student_email=" + student_email + ", student_mobileNo=" + student_mobileNo
				+ ", student_address=" + student_address + ", student_age=" + student_age + "]";
	}

}
