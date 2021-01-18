package com.example.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {

	private static String user;
	private static String password;
	private static String driverClass;
	private static String jdbcUrl;

	static {
		user = "root";
		password = "root";
//		driverClass = "org.mariadb.jdbc.Driver";
		driverClass = "com.mysql.cj.jdbc.Driver";
//		driverClass = "oracle.jdbc.driver.OracleDriver";
//		driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		jdbcUrl = "jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
//		jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
//		jdbcUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test";
	}

	/**
	 * @return 获取一个Connection数据库连接实例
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConn() {
		Connection connection = null;
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(jdbcUrl, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 关闭一个数据库连接
	 * 
	 * @param 需要关闭的连接实例 Connection conn
	 * @throws SQLException
	 */
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭ResultSet
	 * 
	 * @param resultSet
	 */
	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭Statement
	 * 
	 * @param statement
	 */
	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭PreparedStatement
	 * 
	 * @param statement
	 */
	public static void closeStatement(PreparedStatement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
