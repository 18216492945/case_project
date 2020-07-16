package com.donmo.pojo;

/**
 *@author donmo
 *@date 2020年7月15日
 *@Description TODO
 */

public class User {
	private int id;//主键
	private String cardNo;//卡号
	private String identity;//身份
	private String username;//用户名
	private String password;//用户密码
	private String phone;//手机号
	private double balance;//余额
	
	
	
	/**
	 * 
	 */
	public User() {
		super();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * @return the identity
	 */
	public String getIdentity() {
		return identity;
	}
	/**
	 * @param identity the identity to set
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", cardNo=" + cardNo + ", identity=" + identity + ", username=" + username
				+ ", password=" + password + ", phone=" + phone + ", balance=" + balance + ", getId()=" + getId()
				+ ", getCardNo()=" + getCardNo() + ", getIdentity()=" + getIdentity() + ", getUsername()="
				+ getUsername() + ", getPassword()=" + getPassword() + ", getPhone()=" + getPhone() + ", getBalance()="
				+ getBalance() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
