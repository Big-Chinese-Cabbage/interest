package com.wanghuan.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.wanghuan.dao.RoleDao;
import com.wanghuan.dao.UserDao;
import com.wanghuan.model.sys.UserEntity;

@Component
public class MyUserDetailsService implements UserDetailsService {
	Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userDao.getUserEntityByLoginName(username);
		if(userEntity == null) {
			throw new UsernameNotFoundException("用户名："+ username + "不存在！");
		}
		String password = userEntity.getPassword();
		log.info(password);
		
		
		Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        Iterator<String> iterator =  roleDao.getRolesByUserId(userEntity.getId()).iterator();
        while (iterator.hasNext()){
            collection.add(new SimpleGrantedAuthority(iterator.next()));
        }
		
		/*return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));*/
		return new User(username, password, collection);
	}

}
