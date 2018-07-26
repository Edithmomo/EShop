package org.ccunix.eshop.model;

public class MemberModel {
	/**
	 * 会员id
	 */
	private int id;
	/**
	 * 会员等级
	 */
	private int memberlevel;
	/**
	 * 登录用户名
	 */
	private String loginName;
	/**
	 * 登录密码
	 */
	private String loginPwd;
	/**
	 * 真实姓名
	 */
	private String memberName;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 家庭住址
	 */
	private String address;
	/**
	 * 邮编
	 */
	private String zip;
	/**
	 * 注册时间
	 */
	private String regDate;
	/**
	 * 最后一次登录时间
	 */
	private String lastDate;
	/**
	 * 登录时常
	 */
	private int loginTimes;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 会员等级
	 */
	private String levelName;
	/**
	 * 打折折扣
	 */
	private int favourable;
	
	public MemberModel(){}
	
	public MemberModel(int id, int memberlevel, String loginName,
			String loginPwd, String memberName, String phone, String address,
			String zip, String regDate, String lastDate, int loginTimes,
			String email) {
		this.id = id;
		this.memberlevel = memberlevel;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.memberName = memberName;
		this.phone = phone;
		this.address = address;
		this.zip = zip;
		this.regDate = regDate;
		this.lastDate = lastDate;
		this.loginTimes = loginTimes;
		this.email = email;
	}
	
	public MemberModel(int id, int memberlevel, String loginName,
			String loginPwd, String memberName, String phone, String address,
			String zip, String regDate, String lastDate, int loginTimes,
			String email, String levelName, int favourable) {
		this.id = id;
		this.memberlevel = memberlevel;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.memberName = memberName;
		this.phone = phone;
		this.address = address;
		this.zip = zip;
		this.regDate = regDate;
		this.lastDate = lastDate;
		this.loginTimes = loginTimes;
		this.email = email;
		this.levelName = levelName;
		this.favourable = favourable;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMemberlevel() {
		return memberlevel;
	}
	public void setMemberlevel(int memberlevel) {
		this.memberlevel = memberlevel;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public int getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public int getFavourable() {
		return favourable;
	}
	public void setFavourable(int favourable) {
		this.favourable = favourable;
	}
}
