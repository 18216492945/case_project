package com.donmo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *@author donmo
 *@date 2020��7��15��
 *@Description TODO
 */

public class JDBCUtils {
	private static String driver = null;
	private static String url = null;
	private static String name = null;
	private static String pw = null;
	
	
	static {
		
		try {
			//��ȡ�����ļ�
			InputStream rs = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
			Properties properties = new Properties();
			properties.load(rs);
			
			
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			pw = properties.getProperty("pw");
			
			Class.forName(driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//�������ݿ�
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,name,pw);
	}
	
	//�ͷ�����
	public static void close(Connection con,Statement pst,ResultSet rst) {
		if(rst!=null) {
			try {
				rst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pst!=null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
