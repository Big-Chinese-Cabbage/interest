package com.interest.dao;

import java.util.ArrayList;
import java.util.List;

import com.interest.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

	public ArrayList<UserEntity> select(@Param("userEntity") UserEntity userEntity);
	
	public void del(@Param("userEntity") UserEntity userEntity);
	
	public void update(@Param("userEntity") UserEntity userEntity);
	
	public void insert(@Param("userEntity") UserEntity userEntity);
	
	/**
	 * 通过登录名拿到用户信息
	 * @return
	 */
	public UserEntity getUserEntityByLoginName(@Param("loginName") String loginName);

	/**
	 * 获取user列表
	 * @param name
	 * @param pageSize
	 * @param start
	 * @return
	 */
	public ArrayList<UserEntity> usersList(@Param("name")String name,@Param("pageSize") int pageSize,@Param("start") int start);

	/**
	 * 获取user列表的总量
	 * @param name
	 * @param pageSize
	 * @param start
	 * @return
	 */
	public Integer usersSize(@Param("name")String name,@Param("pageSize") int pageSize,@Param("start") int start);

	/**
	 * 新建用户信息
	 * @param userEntity
	 */
	public void insertUser(UserEntity userEntity);

	/**
	 * 更新用户信息
	 * @param userEntity
	 */
	public void updateUser(UserEntity userEntity);

	/**
	 * 删除用户信息
	 * @param groupId
	 */
	public void deleteUsers(@Param("groupId") List<String> groupId);

	public void updateUsertype(@Param("loginName")String loginName,@Param("usertype") Integer usertype);

    public UserEntity getUserEntityById(@Param("id")Integer id);

    UserEntity getEntityByGithubid(@Param("githubid") String login);

    UserEntity getEntityByQqid(@Param("qqid") String openid);

	void insertUserByQq(UserEntity userEntity);

    List<UserEntity> getALl();

	void updateUsertypeById(@Param("id") int id,@Param("usertype") Integer usertype);
}
