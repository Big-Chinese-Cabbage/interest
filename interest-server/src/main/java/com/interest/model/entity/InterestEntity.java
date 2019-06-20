package com.interest.model.entity;

import lombok.Data;

/**
 * @author wanghuan
 *
 */
@Data
public class InterestEntity {
	private Integer id;
	
	private String title;
	
	private String info;
	
	private String content;
	
	private String image;

	private Integer sort;

	private Integer banner;
}
