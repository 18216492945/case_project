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
 *@date 2020��7��15��
 *@Description TODO
 */

public class UserControlImpl implements UserControl{
	private Bank bank = new Bank();
	private UserService service = new UserServiceImpl();
	User user = null;

	//��½
	@Override
	public boolean login() {
		Map login_map = bank.login();
		
		//�����ݿ�Ա�
		user = service.query((String) login_map.get("username"));
		//�ж�
		if(user!=null){
			if (login_map.get("password").equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}

	//�˵���
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
	 * �û�ҵ��ѡ��
	 * 
	 */
	public void businessChoose(String flag) {
		switch (flag) {
		case "1":
			//���
			bank.save(service, user);
			break;
		case "2":
			//ȡ��
			bank.withDraw(service, user);
			break;
		case "3":
			//ת��
			bank.trans(service, user);
			
			break;
		case "4":
			//��ѯ���
			bank.query(service, user);
			break;
		case "5":
			//�޸�����
			bank.modifyPassword(service, user);
			user = null;
			showMenu();
			break;
		case "0":
			//�˳�����
			bank.exit();
			
			break;
		default:
			System.out.print("�����������������룡");
			
			businessChoose(new Scanner(System.in).next());
			break;
		}
	}

	/**
	 * ��½����ѡ��
	 */
	public void errorChoose() {
		System.out.println("===============ERROR=================");
		System.out.println("|---����û������������");
		System.out.println("|---ע�����û����밴  1");
		System.out.println("|---�������룬�밴  2");
		
		System.out.print("���ѡ��");
		
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
			System.out.println("�����������������룡");
			errorChoose();
			break;
		}
	}

	
	/**
	 *ע�� 
	 */
}
