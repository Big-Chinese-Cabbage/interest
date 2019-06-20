package com.interest.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class MenuEntity {
	/**
	 * id
	 */
	private int id;
	/**
	 * 菜单名
	 */
	private String name;
	/**
	 * url
	 */
	private String url;
	/**
	 * 父类id
	 */
	private int parentId;
	/**
	 * 排序
	 */
	private int sort;
	/**
	 * 描述
	 */
	private String remark;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 二级菜单
	 */
	private List<MenuEntity> children;

}
