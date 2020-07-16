package com.donmo.service;

import java.sql.SQLException;

import com.donmo.dao.UserDao;
import com.donmo.dao.UserDaoImpl;
import com.donmo.pojo.User;

/**
 *@author donmo
 *@date 2020年7月15日
 *@Description TODO
 */

public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();

	//注册
	@Override
	public int register(User user) {
		//调用UserDao层
		int row=0;
		try {
			row = userDao.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	
	//用户存款
	@Override
	public int save(String cardno, double money) {
		int row = 0;
		try {
			row = userDao.updateMoney(cardno, money);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}


	//用户取款
	@Override
	public int withdraw(String cardno, double money) {
		int row = 0;
		try {
			row = userDao.updateMoney(cardno, money);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}


	
	//转账   cardno1  ====》 转给    cardno2
	@Override
	public int trans(String cardno1, String cardno2, double money) {
		int row = 0;
		try {
			row = userDao.trans(cardno1, cardno2, money);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}


	//查询余额
	@Override
	public double queryMoney(String cardno) {
		User user = null;
		try {
			user = userDao.query(cardno);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user.getBalance();
	}


	
	//修改密码
	@Override
	public int updatePwd(String cardno, String pwd) {
		int row = 0;
		try {
			row = userDao.updatePwd(cardno, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}


	//查询用户
	@Override
	public User query(String username) {
		User user = null;
		try {
			user = userDao.query(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


	/* (non-Javadoc)
	 * @see com.donmo.service.UserService#queryCardNo(java.lang.String)
	 */
	@Override
	public boolean queryCardNo(String cardNo) {
		boolean flag =false;
		try {
			flag = userDao.queryCardNo(cardNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
