package com.interest;

import org.junit.Test;

import com.interest.utils.DateUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class WhSpringBootApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(new BCryptPasswordEncoder().encode("admin"));
	}

}
