package com.donmo.dao;

import java.sql.SQLException;

import com.donmo.pojo.User;

/**
 *@author donmo
 *@date 2020��7��15��
 *@Description TODO
 */

public interface UserDao {
	//����û�
	int addUser(User user) throws SQLException;
	
	//��� or ȡ��
	int updateMoney(String cardno,double money) throws SQLException;
	
	//ת��
	int trans(String cardno1,String cardno2,double money) throws SQLException;
	
	//��ѯ
	User query(String username) throws SQLException;
	
	boolean queryCardNo(String cardno) throws SQLException;
	
	//�޸�����
	int updatePwd(String cardno,String pwd) throws SQLException;
	
}
