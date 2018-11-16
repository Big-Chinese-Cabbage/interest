package com.interest.model;

/**
 * @author wanghuan
 *
 */
public class ReplyCardEntity {
	private Integer id;

	private String content;

	private Integer postcardid;

	private String createtime;

	private Integer userid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}
