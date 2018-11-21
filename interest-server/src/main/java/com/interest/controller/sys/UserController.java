package com.interest.controller.sys;

import com.interest.model.PageResult;
import com.interest.model.UserEntity;
import com.interest.service.UserService;
import com.interest.utils.SecurityAuthenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
/*@PreAuthorize("hasRole('ADMI')")*/
public class UserController {

	private Logger log = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "userServiceImpl")
	private UserService userService;

	@GetMapping("/public/user")
	public UserEntity userGet() {
		int userid = SecurityAuthenUtil.getIdWithoutException();
		UserEntity userEntity = userService.getEntityById(userid);
		log.debug("The method is ending");
		return userEntity;
	}

	/**
	 * 获取user表数据
	 * 
	 * @param name
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@GetMapping("/users")
	public PageResult usersList(@RequestParam(value = "name",required = false) String name, @RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
		PageResult pageResult = new PageResult();
		pageResult.setData(userService.usersList(name, pageSize, page * pageSize));
		pageResult.setTotalCount(userService.usersSize(name, pageSize, page * pageSize));
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
