package model;

public class Student {
    private int studentId;
	private String sName;
	private String sPhone;
	private String sCity;
	
	public Student(String sName, String sPhone, String sCity) {
		super();
		this.sName = sName;
		this.sPhone = sPhone;
		this.sCity = sCity;
	}

	

	public Student(int studentId, String sName, String sPhone, String sCity) {
		super();
		this.studentId = studentId;
		this.sName = sName;
		this.sPhone = sPhone;
		this.sCity = sCity;
	}



	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPhone() {
		return sPhone;
	}

	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", sName=" + sName + ", sPhone=" + sPhone + ", sCity=" + sCity + "]";
	}
}
