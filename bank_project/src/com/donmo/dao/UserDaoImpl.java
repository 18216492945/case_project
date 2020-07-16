package com.donmo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.donmo.pojo.User;
import com.donmo.utils.JDBCUtils;

/**
 *@author donmo
 *@date 2020年7月15日
 *@Description TODO
 */

public class UserDaoImpl implements UserDao{

	//添加用户
	@Override
	public int addUser(User user) throws SQLException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "insert into user(`cardno`,`identity`,`username`,`password`,`phone`,`balance`) values(?,?,?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user.getCardNo());
		pst.setString(2, user.getIdentity());
		pst.setString(3, user.getUsername());
		pst.setString(4, user.getPassword());
		pst.setString(5, user.getPhone());
		pst.setDouble(6, user.getBalance());
		
		int row = pst.executeUpdate();
		JDBCUtils.close(connection, pst, null);
		
		return row;
	}

	
	//存款 or 取款
	@Override
	public int updateMoney(String cardno, double money) throws SQLException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "update user set balance = balance + ? where cardno = ?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setDouble(1, money);
		pst.setString(2, cardno);
		
		int row = pst.executeUpdate();
		JDBCUtils.close(connection, pst, null);
		return row;
	}


	//转账
	@Override
	public int trans(String cardno1, String cardno2, double money) throws SQLException {
		Connection connection = JDBCUtils.getConnection();
		String sql1 = "update user set balance = balance-? where cardno = ?";
		String sql2 = "update user set balance = balance+? where cardno = ?";
		
		int row1 = 0;
		int row2 = 0;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		
		try {
			//开启事务
			connection.setAutoCommit(false);
			
			pst1= connection.prepareStatement(sql1);
			pst1.setDouble(1, money);
			pst1.setString(2, cardno1);
			
			pst2 = connection.prepareStatement(sql2);
			pst2.setDouble(1, money);
			pst2.setString(2, cardno2);
			
			row1 = pst1.executeUpdate();
			row2 = pst2.executeUpdate();
			
			connection.commit();
		}catch (Exception e) {
			//回滚
			connection.rollback();
		}finally {
			JDBCUtils.close(connection, pst1, null);
			JDBCUtils.close(connection, pst2, null);
		}
		
		return row1+row2;
	}


	//查询
	@Override
	public User query(String username) throws SQLException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "select * from user where username = ?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rst = pst.executeQuery();
		User user = new User();
		while(rst.next()) {
			user.setId(rst.getInt(1));
			user.setCardNo(rst.getString(2));
			user.setIdentity(rst.getString(3));
			user.setUsername(rst.getString(4));
			user.setPassword(rst.getString(5));
			user.setPhone(rst.getString(6));
			user.setBalance(rst.getDouble(7));
			break;
		}
		
		JDBCUtils.close(connection, pst, rst);
		return user;
	}


	
	//修改密码
	@Override
	public int updatePwd(String cardno, String pwd) throws SQLException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "update user set password = ? where cardno = ?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, pwd);
		pst.setString(2, cardno);
		int row = pst.executeUpdate();
		JDBCUtils.close(connection, pst, null);
		return row;
	}


	//查询账户
	@Override
	public boolean queryCardNo(String cardno) throws SQLException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "select * from user where cardno = ?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, cardno);
		ResultSet rst = pst.executeQuery();
		
		
		if(rst.next()) {
			JDBCUtils.close(connection, pst, null);
			return true;
		}
		
		return false;
	}

}
