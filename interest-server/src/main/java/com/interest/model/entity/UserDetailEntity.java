package com.interest.model.entity;

/**
 * @author wanghuan
 *
 */
public class UserDetailEntity {
	private int id;

	private int userid;

	private int articleSign;

	private String info;

	private String location;

	private String skill;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getArticleSign() {
		return articleSign;
	}

	public void setArticleSign(int articleSign) {
		this.articleSign = articleSign;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
}
