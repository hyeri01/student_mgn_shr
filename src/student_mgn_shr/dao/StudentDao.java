package student_mgn_shr.dao;

import java.util.ArrayList;

import student_mgn_shr.dto.Student;

public interface StudentDao {
	ArrayList<Student> selectStudentByAll();
	Student selectStudentByNo(Student student);
	
	int insertStudnet(Student student);
	int updateStudent(Student student);
	int deleteStudent(Student student);

}
