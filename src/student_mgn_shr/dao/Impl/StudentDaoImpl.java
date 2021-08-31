package student_mgn_shr.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import student_mgn_shr.dao.StudentDao;
import student_mgn_shr.dto.Student;
import student_mgn_shr.util.JdbcUtil;

public class StudentDaoImpl implements StudentDao {
	private static final StudentDaoImpl instance = new StudentDaoImpl();
	

	public static StudentDaoImpl getInstance() {
		return instance;
	}

	@Override
	public ArrayList<Student> selectStudentByAll() {
		String sql = "SELECT stdno, stdname, kor, eng, math from student";
		ArrayList<Student> list = null;
		
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			list = new ArrayList<Student>();
			while(rs.next()) {
				list.add(getStudent(rs));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("!sql문 오류! sql문 확인 요망");	
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Student selectStudentByNo(Student student) {
		String sql = "SELECT stdno, stdname, kor, eng, math from student WHERE stdno = ?";
		
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, student.getStdNo());
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					return getStudent(rs);
				}
			}
		} catch (SQLException e) {
			System.out.println("!sql문 오류! sql문 확인 요망");	
			e.printStackTrace();
		}
		
		return null;
	}
	
	private Student getStudent(ResultSet rs) throws SQLException {
		// stdNo, stdName, kor, eng, math, getTotal, getAvg
		int stdNo = rs.getInt("stdno");
		String stdName = rs.getString("stdname");
		int kor = rs.getInt("kor");
		int eng = rs.getInt("eng");
		int math = rs.getInt("math");
	
		
		return new Student(stdNo, stdName, kor, eng, math);
	}

	@Override
	public int insertStudnet(Student student) {
		// stdNo, stdName, kor, eng, math
		String sql = "INSERT into student values(?, ?, ?, ?, ?);";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, student.getStdNo());
			pstmt.setString(2, student.getStdName());
			pstmt.setInt(3, student.getKor());
			pstmt.setInt(4, student.getEng());
			pstmt.setInt(5, student.getMath());
			
			System.out.println(pstmt);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("!sql문 오류! sql문 확인 요망");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		String sql = "UPDATE student set kor = ?, eng = ?, math = ? where stdno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, student.getKor());
			pstmt.setInt(2, student.getEng());
			pstmt.setInt(3, student.getMath());
			pstmt.setInt(4, student.getStdNo());
			
			System.out.println(pstmt);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("!sql문 오류! sql문 확인 요망");	
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudent(Student student) {
		String sql = "DELETE from student where stdno = ?";
		try(Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, student.getStdNo());
			
			System.out.println(pstmt);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("!sql문 오류! sql문 확인 요망");	
			e.printStackTrace();
		}
		return 0;
	}

}
