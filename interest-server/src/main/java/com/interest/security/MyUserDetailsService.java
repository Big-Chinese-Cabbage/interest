package com.interest.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import com.interest.dao.RoleDao;
import com.interest.dao.UserDao;
import com.interest.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {
	Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);
	
	@Autowired
    UserDao userDao;
	
	@Autowired
    RoleDao roleDao;

	private final static String DEFAULT_PASSWORD = "interest";
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		UserEntity userEntity = null;

//		if(MyStringUtil.isInteger(id)) {
//			userEntity = userDao.getUserEntityById(Integer.valueOf(id));
//		}else {
//			userEntity = userDao.getUserEntityByLoginName(id);
//		}

		userEntity = userDao.getUserEntityByLoginName(id);

		if(userEntity == null) {
			throw new UsernameNotFoundException("用户:"+ id + "不存在！");
		}

		String password = userEntity.getPassword();

		if(password == null) {
			password = DEFAULT_PASSWORD;
		}
		/*log.info(password);*/

		Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();

		Iterator<String> iterator =  roleDao.getRolesByUserId(userEntity.getId()).iterator();
		while (iterator.hasNext()){
			collection.add(new SimpleGrantedAuthority(iterator.next()));
		}

		User user = new User(id, password, collection);
		/*return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));*/
		return user;
	}

}
