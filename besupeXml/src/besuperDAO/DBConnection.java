package besuperDAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	public static String getProperty(String key){
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("jdbc.properties"));
			return prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	public static void loadDriverClass() throws ClassNotFoundException{
			Class.forName(getProperty("db.driver"));
	}
	public static Connection getConnection() throws SQLException{
		String url = getProperty("db.url");
		String username = getProperty("db.username");
		String password = getProperty("db.password");
		return DriverManager.getConnection(url,username,password);
	}
	public static void cleanup(Connection conn,PreparedStatement pstmt , ResultSet rs){
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		if(pstmt !=null)
			try {
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
