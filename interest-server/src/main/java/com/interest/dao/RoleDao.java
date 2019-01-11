package com.interest.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.interest.model.RoleEntity;

@Mapper
public interface RoleDao {
    /**
     * 获取role列表
     *
     * @param pageSize
     * @param start
     * @return
     */
    ArrayList<RoleEntity> rolesList(@Param("pageSize") int pageSize, @Param("start") int start);

    /**
     * 获取role列表的总量
     *
     * @param pageSize
     * @param start
     * @return
     */
    Integer rolesSize(@Param("pageSize") int pageSize, @Param("start") int start);

    /**
     * 新建角色信息
     *
     * @param roleEntity
     */
    void insertRole(@Param("roleEntity") RoleEntity roleEntity);

    /**
     * 更新角色信息
     *
     * @param roleEntity
     */
    void updateRole(@Param("roleEntity") RoleEntity roleEntity);

    /**
     * 删除角色信息
     *
     * @param groupId
     */
    void deleteRoles(@Param("groupId") List<String> groupId);

    /**
     * 通过id得到Modules集合
     *
     * @param id
     * @return
     */
    List<String> getModulesById(@Param("id") int id);

    /**
     * 得到角色全部数据
     *
     * @return
     */
    List<RoleEntity> allRoles();

    /**
     * 通过UserId得到对应的role
     *
     * @param id
     * @return
     */
    List<String> getRolesByUserId(int id);
}
