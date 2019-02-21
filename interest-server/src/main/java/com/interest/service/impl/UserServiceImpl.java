package com.interest.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.interest.dao.RelationDao;
import com.interest.dao.UserDao;
import com.interest.model.entity.RelationEntity;
import com.interest.model.entity.UserEntity;
import com.interest.model.request.UserInfoRequest;
import com.interest.model.response.UserInfoResponse;
import com.interest.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.interest.service.UserService;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RelationDao relationDao;

	@Autowired
	private UserDetailService userDetailService;
	
	@Override
	public void insert(UserEntity userEntity) {
		userDao.insert(userEntity);
	}

	@Override
	public void del(UserEntity userEntity) {
		userDao.del(userEntity);
	}

	@Override
	public UserEntity getUserEntityByLoginName(String loginName) {
		return userDao.getUserEntityByLoginName(loginName);
	}

	@Override
	public List<UserEntity> usersList(String name, int pageSize, int start) {
		return userDao.usersList( name,  pageSize,  start);
	}

	@Override
	public Integer usersSize(String name, int pageSize, int start) {
		return userDao.usersSize(name, pageSize, start);
	}

	@Override
	public void insertUser(UserEntity userEntity) {
		/*String password = null;
		try {
			password = MD5Util.encrypt(userEntity.getPassword());
			userEntity.setPassword(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}*/
		//userEntity.setPassword(new Md5PasswordEncoder().encodePassword(userEntity.getPassword(), null));
		userEntity.setPassword("{bcrypt}"+new BCryptPasswordEncoder().encode(userEntity.getPassword()));
		userDao.insertUser(userEntity);
	}

	@Override
	public void updateUser(UserEntity userEntity) {
		//userEntity.setPassword(new Md5PasswordEncoder().encodePassword(userEntity.getPassword(), null));
		if(userEntity.getId() != 8888) {
			userEntity.setPassword("{bcrypt}"+new BCryptPasswordEncoder().encode(userEntity.getPassword()));
		}
		userDao.updateUser(userEntity);
	}

	@Override
	public void deleteUsers(List<String> groupId) {
		userDao.deleteUsers(groupId);
	}

	@Override
	@Transactional
	public void updateUsertype(UserEntity userEntity) {
		if(userEntity.getUsertype() == 0) {
			relationDao.delById(userEntity.getId());
		}else if(userEntity.getUsertype() == 1) {
			RelationEntity relationEntity = new RelationEntity();
			relationEntity.setUserId(userEntity.getId());
			relationEntity.setRoleId(1);
			List<RelationEntity> list = new ArrayList<RelationEntity>();
			list.add(relationEntity);
			relationDao.insertRelations(list);
		}
		//userDao.updateUsertype(userEntity.getLoginName(),userEntity.getUsertype());
		userDao.updateUsertypeById(userEntity.getId(),userEntity.getUsertype());
	}

	@Override
	public UserEntity getEntityById(int userid) {
		return userDao.getUserEntityById(userid);
	}

	@Override
	public UserInfoResponse getUserInfoById(int userId) {
		return userDao.getUserInfoById(userId);
	}

	@Override
	public void updateUserInfoByUserId(int userId, UserInfoRequest userInfoRequest) {
		userDao.updateUserInfo(userId,userInfoRequest.getName(),userInfoRequest.getUrl(),userInfoRequest.getEmail());
		userDetailService.updateUserInfo(userId,userInfoRequest.getInfo(),userInfoRequest.getLocation(),userInfoRequest.getSkill());
	}

}
