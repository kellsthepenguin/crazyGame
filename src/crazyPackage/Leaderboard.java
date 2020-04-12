package crazyPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Leaderboard {
	
	static Connection conn;
	static Statement stmt;
	static String username;
	static String password;
	
	public void setUserInfo(String UN, String PW) {
		this.username = UN;
		this.password = PW;
	}
	
	public static int insertLeaderBoard(String scoreuser, int score) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CrazyGame?serverTimezone=UTC", username, password);
			stmt = conn.createStatement();
			
			String query = "INSERT INTO leaderboard VALUES ('" + scoreuser + "','" + Integer.toString(score) + "')";
			
			int res = stmt.executeUpdate(query);
			
			return res;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -2;
		} catch (SQLException e) {
			e.printStackTrace();
			return -2;
		}
	}

}
