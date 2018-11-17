package com.interest;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.interest.utils.DateUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class WhSpringBootApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(new BCryptPasswordEncoder().encode("wanghuan0105"));
	}

	public class Person{
		public void a(){
			System.out.println("这是人类");
		}
	}

	public class Chainese extends Person{
		public void b(){
			super.a();
			this.c();
		}

		public void c(){
			System.out.println("这是中国人");
		}
	}

	@Test
	public void test(){
		new Chainese().b();
	}

	@Test
	public void QQOauth2Test(){
		try {
			String s = "callback( {\"client_id\":\"YOUR_APPID\",\"openid\":\"YOUR_OPENID\"} );";
			s = s.split("\\(")[1].split("\\)")[0];
			System.out.println(new JSONObject(s).get("openid"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
