package com.interest;

import com.interest.dao.PostCardDao;
import com.interest.dao.UserDao;
import com.interest.dao.UserGithubDao;
import com.interest.model.PostCardEntity;
import com.interest.model.UserEntity;
import com.interest.model.UserGithubEntity;
import net.bytebuddy.asm.Advice;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhSpringBootApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private PostCardDao postCardDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserGithubDao userGithubDao;

    @Test
    public void testRedis(){

		List<UserEntity> list = userDao.getALl();
		for (UserEntity userEntity:list){
			UserGithubEntity userGithubEntity = new UserGithubEntity();
			userGithubEntity.setLogin(userEntity.getName());
			userGithubEntity.setUserid(userEntity.getId());
			userGithubEntity.setEmail(userEntity.getEmail());
			userGithubEntity.setHtmlUrl(userEntity.getUrl());
			userGithubEntity.setAvatarUrl(userEntity.getHeadimg());
			userGithubDao.insertEntity(userGithubEntity);
		}
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
