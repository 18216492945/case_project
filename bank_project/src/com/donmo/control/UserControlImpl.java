package com.donmo.control;

import java.security.Provider.Service;
import java.util.Map;
import java.util.Scanner;

import com.donmo.pojo.Bank;
import com.donmo.pojo.User;
import com.donmo.service.UserService;
import com.donmo.service.UserServiceImpl;

/**
 *@author donmo
 *@date 2020年7月15日
 *@Description TODO
 */

public class UserControlImpl implements UserControl{
	private Bank bank = new Bank();
	private UserService service = new UserServiceImpl();
	User user = null;

	//登陆
	@Override
	public boolean login() {
		Map login_map = bank.login();
		
		//与数据库对比
		user = service.query((String) login_map.get("username"));
		//判断
		if(user!=null){
			if (login_map.get("password").equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}

	//菜单栏
	@Override
	public void showMenu() {
		if(login()) {
			while(true) {
				String userChoose = bank.showMenu();
				businessChoose(userChoose);
			}
			
			
		}else {
			errorChoose();
		}
		
	}
	
	/**
	 * 用户业务选择
	 * 
	 */
	public void businessChoose(String flag) {
		switch (flag) {
		case "1":
			//存款
			bank.save(service, user);
			break;
		case "2":
			//取款
			bank.withDraw(service, user);
			break;
		case "3":
			//转账
			bank.trans(service, user);
			
			break;
		case "4":
			//查询余额
			bank.query(service, user);
			break;
		case "5":
			//修改密码
			bank.modifyPassword(service, user);
			user = null;
			showMenu();
			break;
		case "0":
			//退出程序
			bank.exit();
			
			break;
		default:
			System.out.print("输入有误，请重新输入！");
			
			businessChoose(new Scanner(System.in).next());
			break;
		}
	}

	/**
	 * 登陆错误选择
	 */
	public void errorChoose() {
		System.out.println("===============ERROR=================");
		System.out.println("|---你的用户名或密码错误！");
		System.out.println("|---注册新用户，请按  1");
		System.out.println("|---重新输入，请按  2");
		
		System.out.print("你的选择：");
		
		String choose = new Scanner(System.in).next();
		
		switch (choose) {
		case "1":
			bank.register(service);
			showMenu();
			break;

		case "2":
			showMenu();
			break;
		default:
			System.out.println("输入有误请重新输入！");
			errorChoose();
			break;
		}
	}

	
	/**
	 *注册 
	 */
}
