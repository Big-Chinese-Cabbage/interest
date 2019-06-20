package com.interest.login.authentication;

import com.interest.dao.UserDao;
import com.interest.dao.UserDetailDao;
import com.interest.login.exception.LoginFailureExcepiton;
import com.interest.model.entity.UserDetailEntity;
import com.interest.model.entity.UserEntity;
import com.interest.model.entity.UserGithubEntity;
import com.interest.picture.PictureService;
import com.interest.properties.GithubProperties;
import com.interest.service.UserGithubService;
import com.interest.service.UserService;
import com.interest.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
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
    private UserDetailDao userDetailDao;

    @Autowired
    private UserGithubService userGithubService;

    @Autowired
    private GithubProperties githubProperties;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private UserService userService;

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

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(GITHUB_ACCESSS_TOKEN_URL, requestEntity, String.class);

        String message = responseEntity.getBody().trim();

        String access_token = message.split("&")[0].split("=")[1];

        if (access_token == null || "".equals(access_token)) {
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
        String headImg = githubToken.getString("avatar_url");

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(githubToken.getString("email"));
        userEntity.setHeadimg(headImg);
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

        UserDetailEntity userDetailEntity = new UserDetailEntity();
        userDetailEntity.setUserid(userEntity.getId());
        userDetailDao.insert(userDetailEntity);

        // 异步将网络资源下载到本地，并且更新数据库
        threadPoolTaskExecutor.execute(() -> {
            userService.updateUserHeadImg(userEntity.getId(), pictureService.saveImage(headImg, "/head", "png"));
            //userService.updateUserUrl(userEntity.getId());
        });
        return String.valueOf(userEntity.getId());
    }

}
