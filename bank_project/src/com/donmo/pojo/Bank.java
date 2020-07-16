package com.donmo.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.donmo.service.UserService;

/**
 *@author donmo
 *@date 2020年7月15日
 *@Description : 银行类
 */

public class Bank {
	public Map login() {
		System.out.println("==============登陆===================");
		Map<String, String> login_map = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		System.out.print("用户名：");
		
		login_map.put("username", scanner.next());
		
		System.out.print("密码：");
		login_map.put("password", scanner.next());
		
		return login_map;
	}
	
	public String showMenu() {
		System.out.println("=============请选择你的业务==============");
		System.out.println("|---1.存款（save）");
		System.out.println("|---2.取款（withDraw）");
		System.out.println("|---3.转账（trans）");
		System.out.println("|---4.查询余额（query）");
		System.out.println("|---5.修改密码（modifyPassword）");
		System.out.println("|---0.退出（exit）");
		
		System.out.print("|---请输入你的选择：");
		return new Scanner(System.in).next();
		
	}
	
	public void save(UserService service,User user) {
		System.out.print("请输入你要存款的金额：");
		double money1 = new Scanner(System.in).nextDouble();
		service.save(user.getCardNo(), money1);
		System.out.println("存款成功，请查看您的余额！");
	}
	public void withDraw(UserService service,User user) {
		System.out.print("请输入你要取款的金额：");
		double money2 = new Scanner(System.in).nextDouble();
		service.withdraw(user.getCardNo(), -money2);
		System.out.println("取款成功，请查看您的余额！");
	}
	public void trans(UserService service,User user) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入你要转账的金额：");
		double money3 = scanner.nextDouble();
		System.out.print("请输入你要转账的账户：");
		String cardno3 = scanner.next();
		if (service.queryCardNo(cardno3)) {
			service.trans(user.getCardNo(), cardno3, money3);
			System.out.println("转账成功，请查看您的余额！");
		}else {
			System.out.println("转账失败，你输入的账户不存在！");
		}
	}
	public void query(UserService service,User user) {
		double money4 = service.queryMoney(user.getUsername());
		System.out.println("您当前的余额为:￥"+money4);
	}
	public void modifyPassword(UserService service,User user) {
		System.out.print("请输入你要修改的密码：");
		String pwd = new Scanner(System.in).next();
		service.updatePwd(user.getCardNo(), pwd);
		System.out.println("修改密码成功，请重新登陆！");
	}
	public void exit() {
		System.out.println("系统安全退出！感谢你的使用！");
		System.out.println("===================================");
		System.exit(0);
	}
	
	public void register(UserService service) {
		System.out.println("=================注册=================");
		Scanner scanner = new Scanner(System.in);
		User new_user = new User();
		System.out.print("请输入你的cardNo:");
		new_user.setCardNo(scanner.next());
		System.out.print("请输入你的identify:");
		new_user.setIdentity(scanner.next());
		System.out.print("请输入你的username:");
		new_user.setUsername(scanner.next());
		System.out.print("请输入你的password:");
		new_user.setPassword(scanner.next());
		System.out.print("请输入你的phone:");
		new_user.setPhone(scanner.next());
		new_user.setBalance(0);
		
		int res = service.register(new_user);
		if(res>0) {
			System.out.println("注册成功！");
		}else {
			System.out.println("注册失败！");
		}
	}
}
