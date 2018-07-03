package com.interest.controller.sys;

import java.util.List;

import javax.annotation.Resource;

import com.interest.model.PageResult;
import com.interest.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interest.service.UserService;
import com.interest.utils.SecurityAuthenUtil;

@RestController
/*@PreAuthorize("hasRole('ADMI')")*/
public class UserController {

	private Logger log = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "userServiceImpl")
	private UserService userService;

	@GetMapping("/public/user")
	public UserEntity userGet() {
		String loginName = null;
		try {
			loginName = SecurityAuthenUtil.getLoginName();
		}catch (Exception ex){
			System.out.println("exception");
			return null;
		}
		UserEntity userEntity = userService.getUserEntityByLoginName(loginName);
		log.debug("The method is ending");
		return userEntity;
	}

	/**
	 * 获取user表数据
	 * 
	 * @param loginName
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@GetMapping("/users")
	public PageResult usersList(String loginName, int pageSize, int page) {
		PageResult pageResult = new PageResult();
		pageResult.setData(userService.usersList(loginName, pageSize, page * pageSize));
		pageResult.setTotalCount(userService.usersSize(loginName, pageSize, page * pageSize));
		log.debug("The method is ending");
		return pageResult;
	}

	/**
	 * 新建用户信息
	 * 
	 * @param userEntity
	 * @return
	 */
	@PostMapping("/users/user")
	public UserEntity insertUser(@RequestBody UserEntity userEntity) {
		userService.insertUser(userEntity);
		log.debug("The method is ending");
		return userEntity;
	}
	
	/**
	 * 新建用户信息
	 * 
	 * @param userEntity
	 * @return
	 */
	@PostMapping("/register")
	public UserEntity register(@RequestBody UserEntity userEntity) {
		userService.insertUser(userEntity);
		log.debug("The method is ending");
		return userEntity;
	}

	/**
	 * 更新用户信息
	 * @param userEntity
	 * @return
	 */
	@PutMapping("/user")
	public UserEntity updateUser(@RequestBody UserEntity userEntity) {
		userService.updateUser(userEntity);
		log.debug("The method is ending");
		return userEntity;
	}

	@PutMapping("/users/user")
	public UserEntity updateUsertype(@RequestBody UserEntity userEntity) {
		userService.updateUsertype(userEntity);
		log.debug("The method is ending");
		return userEntity;
	}
	
	/**
	 * 删除用户信息
	 * 
	 * @param groupId
	 * @return
	 */
	@DeleteMapping("/users")
	public List<String> deleteUsers(@RequestBody List<String> groupId) {
		userService.deleteUsers(groupId);
		return groupId;
	}
}
