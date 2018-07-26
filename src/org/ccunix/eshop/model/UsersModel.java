package org.ccunix.eshop.model;

/**
 * ��ݿ�����
 * �û���Ϣ�� tom 123456 1 tom steven 123456 2 κ����
 * 
 * @author Administrator
 * 
 */
public class UsersModel {
	private String username;// �û���
	private String password;// ����
	private int limits;// Ȩ��
	private String name;// ��ʵ����
	private String email;
	private String sex;
	private String photo;
	private String phone;
	private String[] hobby;
	public UsersModel() {
	}
	
	public UsersModel(String username, String password, int limits, String name) {
		this.username = username;
		this.password = password;
		this.limits = limits;
		this.name = name;
	}
	public UsersModel(String username, String password, int limits,
			String name, String email, String sex, String photo, String phone,
			String[] hobby) {
		this.username = username;
		this.password = password;
		this.limits = limits;
		this.name = name;
		this.email = email;
		this.sex = sex;
		this.photo = photo;
		this.phone = phone;
		this.hobby = hobby;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLimits() {
		return limits;
	}

	public void setLimits(int limits) {
		this.limits = limits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
