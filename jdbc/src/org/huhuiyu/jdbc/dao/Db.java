package org.huhuiyu.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
	public static final String CONN_STRING = "jdbc:sqlserver://127.0.0.1:1433;database=jdbc;user=sa;password=abc123";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CONN_STRING);
	}

}
