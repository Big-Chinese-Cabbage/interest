package com.interest.model;

/**
 * @author wanghuan
 *
 */
public class InterestEntity {
	private Integer id;
	
	private String title;
	
	private String info;
	
	private String content;
	
	private String image;

	private Integer sort;

	private Integer banner;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getSort() {
		return sort;
	}

	public Integer getBanner() {
		return banner;
	}

	public void setBanner(Integer banner) {
		this.banner = banner;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
