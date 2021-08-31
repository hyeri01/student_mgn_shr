package student_mgn_shr.dao;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import student_mgn_shr.dao.Impl.StudentDaoImpl;
import student_mgn_shr.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentDaoTest {

	private StudentDao dao;

	@Before
	public void setUp() throws Exception {
		dao = StudentDaoImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
		dao = null;
	}

	@Test
	public void test01SelectStudentByAll() {
		System.out.println("testSelectStudentByAll()");
		ArrayList<Student> list = dao.selectStudentByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectStudentByNo() {
		System.out.println("testSelectStudentByNo()");
		Student selectStd = dao.selectStudentByNo(new Student(2101));
		Assert.assertNotNull(selectStd);
		System.out.println(selectStd);
	}

	@Test
	public void test03InsertStudnet() {
		System.out.println("testInsertStudnet()");
		Student newStd = new Student(2103, "다라마", 88, 72, 100);
		
		int res = dao.insertStudnet(newStd);
		Assert.assertEquals(1, res);
		
		test01SelectStudentByAll();
	}

	@Test
	public void test04UpdateStudent() {
		System.out.println("testUpdateStudent()");
		Student std2013 = new Student(2103, "다라마", 88, 72, 100);
		
		std2013.setKor(90);
		std2013.setEng(90);
		std2013.setMath(90);
		int res = dao.updateStudent(std2013);
		Assert.assertEquals(1, res);
		
		test01SelectStudentByAll();
		
	}

	@Test
	public void test05DeleteStudent() {
		System.out.println("testDeleteStudent()");
		
		// 삭제 
		int res = dao.deleteStudent(new Student(2103, "다라마", 88, 72, 100));
		Assert.assertEquals(1, res);
		
		test01SelectStudentByAll();
	}

}
