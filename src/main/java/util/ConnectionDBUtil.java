package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDBUtil {

	public static Connection gecConnection() {
		Connection conn = null;
		try {
			String sqlDriver = "oracle.jdbc.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "bruno3";
			String password = "123456";

			Class.forName(sqlDriver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
