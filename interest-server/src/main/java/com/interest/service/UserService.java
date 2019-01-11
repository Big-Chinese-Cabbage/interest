package com.interest.service;

import java.util.List;

import com.interest.model.UserEntity;

public interface UserService {
	void insert(UserEntity userEntity);

	void del(UserEntity userEntity);

	/**
	 * 通过登录名得到用户信息
	 * @param loginName
	 * @return
	 */
	UserEntity getUserEntityByLoginName(String loginName);

	/**
	 * 获取user列表
	 * @param name
	 * @param pageSize
	 * @param start
	 * @return
	 */
	List<UserEntity> usersList(String name, int pageSize, int start);

	/**
	 * 获取user列表的总量
	 * @param name
	 * @param pageSize
	 * @param start
	 * @return
	 */
	Integer usersSize(String name, int pageSize, int start);

	/**
	 * 新建用户信息
	 * @param userEntity
	 */
	void insertUser(UserEntity userEntity);

	/**
	 * 更新用户信息
	 * @param userEntity
	 */
	void updateUser(UserEntity userEntity);

	/**
	 * 删除用户信息
	 * @param groupId
	 */
	void deleteUsers(List<String> groupId);

	void updateUsertype(UserEntity userEntity);

    UserEntity getEntityById(int userid);
}
