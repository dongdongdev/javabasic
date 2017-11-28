package cn.huhuiyu.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
	public static final String CONN_STRING = "jdbc:sqlserver://127.0.0.1:1433;database=jsp;user=sa;password=abc123";

	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CONN_STRING);
	}

	public static String getDataBase() throws SQLException {
		Connection conn = Db.getConnection();
		String database = conn.getCatalog();
		conn.close();
		return database;
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(Db.getDataBase());
	}
}
