package com.donmo.dao;

import java.sql.SQLException;

import com.donmo.pojo.User;

/**
 *@author donmo
 *@date 2020年7月15日
 *@Description TODO
 */

public interface UserDao {
	//添加用户
	int addUser(User user) throws SQLException;
	
	//存款 or 取款
	int updateMoney(String cardno,double money) throws SQLException;
	
	//转账
	int trans(String cardno1,String cardno2,double money) throws SQLException;
	
	//查询
	User query(String username) throws SQLException;
	
	boolean queryCardNo(String cardno) throws SQLException;
	
	//修改密码
	int updatePwd(String cardno,String pwd) throws SQLException;
	
}
