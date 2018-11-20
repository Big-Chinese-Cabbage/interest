package com.interest;

import net.bytebuddy.asm.Advice;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhSpringBootApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

    @Test
    public void testRedis(){

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
