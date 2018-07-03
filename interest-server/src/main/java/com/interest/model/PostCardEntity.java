package com.interest.model;

/**
 * @author wanghuan
 *
 */
public class PostCardEntity {
	private Integer id;

	private String username;

	private String title;

	private String content;

	private Integer interestid;

	private String createtime;
	
	private String replytime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getInterestid() {
		return interestid;
	}

	public void setInterestid(Integer interestid) {
		this.interestid = interestid;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getReplytime() {
		return replytime;
	}

	public void setReplytime(String replytime) {
		this.replytime = replytime;
	}

}
