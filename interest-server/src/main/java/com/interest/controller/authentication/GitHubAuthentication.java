package com.interest.controller.authentication;

import com.interest.dao.UserDao;
import com.interest.model.UserEntity;
import com.interest.controller.login.LoginFailureExcepiton;
import com.interest.model.UserGithubEntity;
import com.interest.properties.GithubProperties;
import com.interest.service.UserGithubService;
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


@Service(value = "gitHubAuthentication")
public class GitHubAuthentication implements MyAuthentication {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserGithubService userGithubService;

    @Autowired
    private GithubProperties githubProperties;

    private RestTemplate restTemplate = new RestTemplate();

    private static final String GITHUB_ACCESSS_TOKEN_URL = "https://github.com/login/oauth/access_token";

    private static final String GITHUB_USER_URL = "https://api.github.com/user";

    @Override
    @Transactional
    public String getUserId(String code) {

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("client_id", githubProperties.getClientId());
        requestEntity.add("client_secret", githubProperties.getClientSecret());
        requestEntity.add("code", code);

        logger.info("**********client_id:"+requestEntity.get("client_id")+";client_secret:"+requestEntity.get("client_secret")+"**********");

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

            String login = githubUserInfo.getString("login");

            if (login == null) {
                throw new LoginFailureExcepiton(githubUserInfo.toString());
            }

            userEntity = userDao.getEntityByGithubid(login);

            if (userEntity == null) {
                return insertUser(githubUserInfo);
            } else {
                return String.valueOf(userEntity.getId());
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
//        userEntity.setLoginName(githubToken.getString("login"));
        userEntity.setName(githubToken.getString("login"));
        userEntity.setUrl(githubToken.getString("html_url"));
        userEntity.setGithubid(githubToken.getString("login"));
        userEntity.setUsertype(0);
        userEntity.setCreateTime(DateUtil.currentTimestamp());
        userDao.insertUser(userEntity);

        UserGithubEntity userGithubEntity = new UserGithubEntity();
        userGithubEntity.setLogin(githubToken.getString("login"));
        userGithubEntity.setAvatarUrl(githubToken.getString("avatar_url"));
        userGithubEntity.setHtmlUrl(githubToken.getString("html_url"));
        userGithubEntity.setEmail(githubToken.getString("email"));
        userGithubEntity.setUserid(userEntity.getId());
        userGithubService.insertEntity(userGithubEntity);

        return String.valueOf(userEntity.getId());
    }
}
