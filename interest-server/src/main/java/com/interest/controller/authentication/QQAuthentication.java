package com.interest.controller.authentication;

import com.interest.controller.login.LoginFailureExcepiton;
import com.interest.dao.UserDao;
import com.interest.model.UserEntity;
import com.interest.model.UserGithubEntity;
import com.interest.model.UserQQEntity;
import com.interest.properties.GithubProperties;
import com.interest.properties.QQProperties;
import com.interest.service.UserGithubService;
import com.interest.service.UserQQService;
import com.interest.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service(value = "qQAuthentication")
public class QQAuthentication implements MyAuthentication {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserQQService userQQService;

    @Autowired
    private QQProperties qqProperties;

    private RestTemplate restTemplate = new RestTemplate();

    private static final String QQ_ACCESSS_TOKEN_URL = "https://graph.qq.com/oauth2.0/token";

    private static final String QQ_OPENID_URL = "https://graph.qq.com/oauth2.0/me";

    private static final String QQ_USER_URL = "https://graph.qq.com/user/get_user_info";

    @Override
    @Transactional
    public String getUserId(String code) {

        String appid = qqProperties.getAppid();
        String appkey = qqProperties.getAppkey();

        logger.info("**********appid:"+appid+";appkey:"+appkey+"**********");

        /* 获取access_token */
        String tokenUrl = QQ_ACCESSS_TOKEN_URL+"?grant_type=authorization_code&client_id="+appid+
                "&client_secret="+appkey+"&code="+code+"&redirect_uri=http://www.lovemtt.com/qq";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(tokenUrl, String.class);
        String message = responseEntity.getBody().trim();
        String access_token = message.split("&")[0].split("=")[1];

        /* 获取openid */
        String openidUrl = QQ_OPENID_URL+"?access_token="+access_token;
        responseEntity = restTemplate.getForEntity(openidUrl, String.class);
        message = responseEntity.getBody().trim();
        message = message.split("\\(")[1].split("\\)")[0];

        UserEntity userEntity = null;

        try {
            JSONObject callback = new JSONObject(message);
            String openid = callback.getString("openid");
            if (openid == null) {
                throw new LoginFailureExcepiton(callback.toString());
            }

            userEntity = userDao.getEntityByQqid(openid);
            if (userEntity == null) {
                /* 获取qq用户信息 */
                String userInfoUrl = QQ_USER_URL+"?access_token="+access_token+
                        "&oauth_consumer_key="+appid+"&openid="+openid;
                responseEntity = restTemplate.getForEntity(userInfoUrl, String.class);
                JSONObject qqUserInfo = new JSONObject(responseEntity.getBody().trim());

                return insertUser(qqUserInfo,openid);
            } else {
                return String.valueOf(userEntity.getId());
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String insertUser(JSONObject qqUserInfo,String openid) throws JSONException {
        UserEntity userEntity = new UserEntity();
        userEntity.setHeadimg(qqUserInfo.getString("figureurl_qq_1"));
        userEntity.setName(qqUserInfo.getString("nickname"));
        userEntity.setQqid(openid);
        userEntity.setUsertype(0);
        userEntity.setCreateTime(DateUtil.currentTimestamp());
        userDao.insertUserByQq(userEntity);

        UserQQEntity userQQEntity = new UserQQEntity();
        userQQEntity.setOpenid(openid);
        userQQEntity.setNickname(userEntity.getName());
        userQQEntity.setFigureurlQq1(userEntity.getHeadimg());
        userQQEntity.setGender(qqUserInfo.getString("gender"));
        userQQEntity.setUserid(userEntity.getId());
        userQQService.insertEntity(userQQEntity);
//        UserGithubEntity userGithubEntity = new UserGithubEntity();
//        userGithubEntity.setLogin(githubToken.getString("login"));
//        userGithubEntity.setAvatarUrl(githubToken.getString("avatar_url"));
//        userGithubEntity.setHtmlUrl(githubToken.getString("html_url"));
//        userGithubEntity.setEmail(githubToken.getString("email"));
//        userGithubEntity.setUserid(userEntity.getId());
//        userGithubService.insertEntity(userGithubEntity);

        return String.valueOf(userEntity.getId());
    }
}
