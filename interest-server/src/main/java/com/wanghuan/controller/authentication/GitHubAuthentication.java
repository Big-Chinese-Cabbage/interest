package com.wanghuan.controller.authentication;

import com.wanghuan.controller.login.LoginFailureExcepiton;
import com.wanghuan.dao.UserDao;
import com.wanghuan.model.UserEntity;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@Service
public class GitHubAuthentication implements MyAuthentication {

    @Autowired
    private UserDao userDao;

    private RestTemplate restTemplate = new RestTemplate();

    private static final String CLIENT_ID = "bbb5cc2034eb62484c1c";

    private static final String CLIENT_SECRET = "75ea363df8765fcf4ea88f07eb7418ea23172b8b";

    private static final String GITHUB_ACCESSS_TOKEN_URL = "https://github.com/login/oauth/access_token";

    private static final String GITHUB_USER_URL = "https://api.github.com/user";

    @Override
    public String getUserId(String code) {

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("client_id", CLIENT_ID);
        requestEntity.add("client_secret", CLIENT_SECRET);
        requestEntity.add("code", code);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(GITHUB_ACCESSS_TOKEN_URL, requestEntity, String.class);

        String message = responseEntity.getBody().trim();

        String access_token = message.split("&")[0].split("=")[1];

        if(access_token == null || "".equals(access_token)){
            throw new LoginFailureExcepiton(message);
        }

        String url = GITHUB_USER_URL + "?access_token=" + access_token;

        responseEntity = restTemplate.getForEntity(url, String.class);

        UserEntity userEntity = null;

        try {

            JSONObject githubUserInfo = new JSONObject(responseEntity.getBody().trim());

            String loginName = githubUserInfo.getString("login");

            if (loginName == null) {
                throw new LoginFailureExcepiton(githubUserInfo.toString());
            }

            userEntity = userDao.getUserEntityByLoginName(loginName);

            if (userEntity == null) {
                return insertUser(githubUserInfo);
            } else {
                return userEntity.getLoginName();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String insertUser(JSONObject githubToken) throws JSONException {
        UserEntity userEntity = new UserEntity();

        userEntity.setEmail(githubToken.getString("email"));
        userEntity.setHeadimg(githubToken.getString("avatar_url"));
        userEntity.setLoginName(githubToken.getString("login"));
        userEntity.setUrl(githubToken.getString("html_url"));
        userEntity.setUsertype(0);

        userDao.insertUser(userEntity);


        return userEntity.getLoginName();
    }
}
