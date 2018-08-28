package org.ccunix.eshop.model;

public class MemberLevelModel {
	/**
	 * 会员等级编号
	 */
	private int id;
	/**
	 * 会员等级名
	 */
	private String levelName;
	/**
	 * 享受的折扣
	 */
	private String favourable;
	
	public MemberLevelModel(){}
	
	public MemberLevelModel(int id, String levelName, String favourable) {
		this.id = id;
		this.levelName = levelName;
		this.favourable = favourable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getFavourable() {
		return favourable;
	}

	public void setFavourable(String favourable) {
		this.favourable = favourable;
	}

}
