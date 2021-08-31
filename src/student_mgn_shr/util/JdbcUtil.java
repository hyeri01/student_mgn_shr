package student_mgn_shr.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	public static Connection getConnection() {
		Connection con = null;
		String proPath = "mysql_db.properties";
		Properties props = new Properties();
		
		try(InputStream is = ClassLoader.getSystemResourceAsStream(proPath);){
			props.load(is);
			String url = props.getProperty("url");
			con = DriverManager.getConnection(url, props);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("url 혹은 user, password 확인하세요.");
			e.printStackTrace();
		}

		return con;
	}

}
