package com.interest.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityAuthenUtil {

	/**
	 * 直接获取当前用户的登录账号
	 * @return
	 */
	public static int getId() {
		Authentication authenObj = SecurityContextHolder.getContext().getAuthentication();
		User authenUser = (User)authenObj.getPrincipal();
		return Integer.valueOf(authenUser.getUsername());
	}

	public static int getIdWithoutException() {
		try {
			Authentication authenObj = SecurityContextHolder.getContext().getAuthentication();
			User authenUser = (User)authenObj.getPrincipal();
			return Integer.valueOf(authenUser.getUsername());
		}catch (Exception ex){
			return 0;
		}

	}

	/**
	 * 直接获取当前用户的登录账号
	 * @return
	 */
	public static String getLoginName() {
		Authentication authenObj = SecurityContextHolder.getContext().getAuthentication();
		User authenUser = (User)authenObj.getPrincipal();
		return authenUser.getUsername();
	}
	
	/**
	 * 直接获取当前用户的认证用户信息
	 * @return
	 */
	public static User getAuthenticationUser() {
		Authentication authenObj = SecurityContextHolder.getContext().getAuthentication();
		User authenUser = (User)authenObj.getPrincipal();
		return authenUser;
	}
	

}
