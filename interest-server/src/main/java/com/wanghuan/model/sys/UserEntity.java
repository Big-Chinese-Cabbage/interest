package com.wanghuan.model.sys;

/**
 * @author wanghuan
 *
 */
public class UserEntity {
	/**
	 * id
	 */
	private int id;
	/**
	 * 姓名
	 */
	private String loginName;
	/**
	 * 登录名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
	
	private String sex;
	
	private String age;
	
	private String college;
	
	private String info;
	
	private Integer usertype;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}
	
}
