package com.interest.model;

/**
 * @author wanghuan
 *
 */
public class RelationEntity {
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 角色ID
	 */
	private Integer roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "RelationEntity [userId=" + userId + ", roleId=" + roleId + "]";
	}

}
