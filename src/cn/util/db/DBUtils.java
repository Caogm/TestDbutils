package cn.util.db;
/*
 * 数据库操作工具类
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtils {
	// 数据库连接地址
	public static String URL;
	// 数据库用户名
	public static String USERNAME;
	// 数据库密码
	public static String PASSWORD;
	// MySQL的驱动类
	public static String DRIVER;

	private static ResourceBundle rb = ResourceBundle.getBundle("cn.util.db.db-config");

	private DBUtils() {

	}

	// 使用静态代码块加载驱动程序
	static {
		URL = rb.getString("jdbc.url");
		USERNAME = rb.getString("jdbc.username");
		PASSWORD = rb.getString("jdbc.password");
		DRIVER = rb.getString("jdbc.driver");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 定义一个获取数据库连接的方法
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		return connection;
	}

	// 关闭数据库连接
	public static void close(ResultSet rs, Statement stat, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stat != null)
				stat.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
