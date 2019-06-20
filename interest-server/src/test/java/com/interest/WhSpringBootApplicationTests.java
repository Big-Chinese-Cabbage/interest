package com.interest;

import com.interest.dao.PostCardDao;
import com.interest.dao.UserDao;
import com.interest.dao.UserDetailDao;
import com.interest.dao.UserGithubDao;
import com.interest.model.entity.UserDetailEntity;
import com.interest.model.entity.UserEntity;
import com.interest.model.entity.UserGithubEntity;
import com.interest.service.UserDetailService;
import com.interest.picture.ImageUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhSpringBootApplicationTests {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private UserDetailDao userDetailDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void testUserDetail() {
        List<UserEntity> list = userDao.getALl();
        for (UserEntity userEntity : list) {
            UserDetailEntity userDetailEntity = new UserDetailEntity();
            userDetailEntity.setUserid(userEntity.getId());
            userDetailDao.insert(userDetailEntity);
        }

    }


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PostCardDao postCardDao;


    @Autowired
    private UserGithubDao userGithubDao;


    @Test
    public void QQOauth2Test() {
        try {
            String s = "callback( {\"client_id\":\"YOUR_APPID\",\"openid\":\"YOUR_OPENID\"} );";
            s = s.split("\\(")[1].split("\\)")[0];
            System.out.println(new JSONObject(s).get("openid"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void urlPictureTest() throws IOException {

        //ImageUtil.imgJPEGEncode("https://www.lovemtt.com/interest/interest/20190304/36576e98-70d9-4a19-b3b2-e68551ef5e6f.PNG", "D:/interest/file/image");

        ImageUtil.imgJPEGEncode("https://thirdqq.qlogo.cn/qqapp/101512648/3F57E5B8E59F834C811DE1EB470FD5A6/100", "D:/interest/file/image");

        ImageUtil.imgJPEGEncode("https://avatars1.githubusercontent.com/u/9424535?v=4", "D:/interest/file/image");

        //ImageUtil.saveImg("https://thirdqq.qlogo.cn/qqapp/101512648/3F57E5B8E59F834C811DE1EB470FD5A6/100","D:/interest/file/image","jpg");
        //ImageUtil.saveImg("https://avatars1.githubusercontent.com/u/9424535?v=4","D:/interest/file/image","png");
    }

    @Test
    public void pictureUrl(){
        String url1 = "http://127.0.0.1:8080/interest/interest/head/20190319/bbae1a8c-7b04-4daa-83c7-1f99399ba8fd.png";
        String url2 = "https://www.lovemtt.com/interest/interest/head/20190319/e019d05c-7811-479d-ba09-927348970479.png";

        System.out.println(url1.lastIndexOf("/interest"));
        System.out.println(url2.lastIndexOf("/interest"));

        String fileName = url1.substring(url1.lastIndexOf("/interest"));
        System.out.println(fileName);
        fileName = url2.substring(url2.lastIndexOf("/interest"));
        System.out.println(fileName);
    }

}
