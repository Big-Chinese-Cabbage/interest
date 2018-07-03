package com.interest.model;

/**
 * @author wanghuan
 *
 */
public class ReplyCardEntity {
	private Integer id;

	private String username;

	private String content;

	private Integer postcardid;

	private String createtime;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPostcardid() {
		return postcardid;
	}

	public void setPostcardid(Integer postcardid) {
		this.postcardid = postcardid;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

}
