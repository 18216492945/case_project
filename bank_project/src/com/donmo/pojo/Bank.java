package com.donmo.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.donmo.service.UserService;

/**
 *@author donmo
 *@date 2020��7��15��
 *@Description : ������
 */

public class Bank {
	public Map login() {
		System.out.println("==============��½===================");
		Map<String, String> login_map = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		System.out.print("�û�����");
		
		login_map.put("username", scanner.next());
		
		System.out.print("���룺");
		login_map.put("password", scanner.next());
		
		return login_map;
	}
	
	public String showMenu() {
		System.out.println("=============��ѡ�����ҵ��==============");
		System.out.println("|---1.��save��");
		System.out.println("|---2.ȡ�withDraw��");
		System.out.println("|---3.ת�ˣ�trans��");
		System.out.println("|---4.��ѯ��query��");
		System.out.println("|---5.�޸����루modifyPassword��");
		System.out.println("|---0.�˳���exit��");
		
		System.out.print("|---���������ѡ��");
		return new Scanner(System.in).next();
		
	}
	
	public void save(UserService service,User user) {
		System.out.print("��������Ҫ���Ľ�");
		double money1 = new Scanner(System.in).nextDouble();
		service.save(user.getCardNo(), money1);
		System.out.println("���ɹ�����鿴������");
	}
	public void withDraw(UserService service,User user) {
		System.out.print("��������Ҫȡ��Ľ�");
		double money2 = new Scanner(System.in).nextDouble();
		service.withdraw(user.getCardNo(), -money2);
		System.out.println("ȡ��ɹ�����鿴������");
	}
	public void trans(UserService service,User user) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("��������Ҫת�˵Ľ�");
		double money3 = scanner.nextDouble();
		System.out.print("��������Ҫת�˵��˻���");
		String cardno3 = scanner.next();
		if (service.queryCardNo(cardno3)) {
			service.trans(user.getCardNo(), cardno3, money3);
			System.out.println("ת�˳ɹ�����鿴������");
		}else {
			System.out.println("ת��ʧ�ܣ���������˻������ڣ�");
		}
	}
	public void query(UserService service,User user) {
		double money4 = service.queryMoney(user.getUsername());
		System.out.println("����ǰ�����Ϊ:��"+money4);
	}
	public void modifyPassword(UserService service,User user) {
		System.out.print("��������Ҫ�޸ĵ����룺");
		String pwd = new Scanner(System.in).next();
		service.updatePwd(user.getCardNo(), pwd);
		System.out.println("�޸�����ɹ��������µ�½��");
	}
	public void exit() {
		System.out.println("ϵͳ��ȫ�˳�����л���ʹ�ã�");
		System.out.println("===================================");
		System.exit(0);
	}
	
	public void register(UserService service) {
		System.out.println("=================ע��=================");
		Scanner scanner = new Scanner(System.in);
		User new_user = new User();
		System.out.print("���������cardNo:");
		new_user.setCardNo(scanner.next());
		System.out.print("���������identify:");
		new_user.setIdentity(scanner.next());
		System.out.print("���������username:");
		new_user.setUsername(scanner.next());
		System.out.print("���������password:");
		new_user.setPassword(scanner.next());
		System.out.print("���������phone:");
		new_user.setPhone(scanner.next());
		new_user.setBalance(0);
		
		int res = service.register(new_user);
		if(res>0) {
			System.out.println("ע��ɹ���");
		}else {
			System.out.println("ע��ʧ�ܣ�");
		}
	}
}
