package com.donmo.service;

import com.donmo.pojo.User;

/**
 *@author donmo
 *@date 2020��7��15��
 *@Description ���û�ҵ���
 *
 */

public interface UserService {
	int register(User user);
	
	int save(String cardno,double money);
	
	int withdraw(String cardno,double money);
	
	int trans(String cardno1,String cardno2,double money);
	
	double queryMoney(String cardno);
	
	int updatePwd(String cardno,String pwd);
	
	User query(String username);
	
	boolean queryCardNo(String cardNo);
}
