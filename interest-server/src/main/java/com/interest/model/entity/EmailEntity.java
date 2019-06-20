package com.interest.model.entity;

import lombok.Data;

/**
 * @author wanghuan
 *
 */
@Data
public class EmailEntity {
	private Integer id;
	
	private String title;
	
	private String email;
	
	private String name;
	
	private String content;
	
	private String createtime;

	private Integer userid;

}
