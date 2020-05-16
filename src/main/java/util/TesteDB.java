package util;
import java.sql.Connection;
import java.sql.DriverManager;

public class TesteDB {

	public static void main(String[] args) {
		try {
			String sqlDriver = "oracle.jdbc.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "bruno2";
			String password = "123456";

			Class.forName(sqlDriver);
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			conn.close();
			// return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// return null;
		}
	}

}
