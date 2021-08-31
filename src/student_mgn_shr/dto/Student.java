package student_mgn_shr.dto;

public class Student {
	private int stdNo;
	private String stdName;
	private int kor;
	private int eng;
	private int math;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int stdNo) {
		this.stdNo = stdNo;
	}
	

	public Student(int stdNo, String stdName, int kor, int eng, int math) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getTotal() {
		return kor + eng + math;
	}

	public float getAvg() {
		return (int)(getTotal() / 3f*10 + 0.5f)/10f;
	}
	

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	public void setScore(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public String toString() {
		return String.format("학번 %s, 학생 %s, 국어 %s, 수학 %s, 영어 %s, 총점 %s, 평균 %s",
				stdNo, stdName, kor, eng, math, getTotal(), getAvg());
	}


	
	

}
