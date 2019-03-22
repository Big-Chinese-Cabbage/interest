package com.interest.service.impl;

import com.interest.dao.RelationDao;
import com.interest.dao.UserDao;
import com.interest.model.entity.RelationEntity;
import com.interest.model.entity.UserEntity;
import com.interest.model.ordinary.UserIdHeadImg;
import com.interest.model.request.UserInfoRequest;
import com.interest.model.response.UserInfoResponse;
import com.interest.picture.PictureService;
import com.interest.properties.PathsProperties;
import com.interest.service.UserDetailService;
import com.interest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao userDao;

    @Autowired
    private RelationDao relationDao;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private PathsProperties pathsProperties;

    @Override
    public void insert(UserEntity userEntity) {
        userDao.insert(userEntity);
    }

    @Override
    public void del(UserEntity userEntity) {
        userDao.del(userEntity);
    }

    @Override
    public UserEntity getUserEntityByLoginName(String loginName) {
        return userDao.getUserEntityByLoginName(loginName);
    }

    @Override
    public List<UserEntity> usersList(String name, int pageSize, int start) {
        return userDao.usersList(name, pageSize, start);
    }

    @Override
    public Integer usersSize(String name, int pageSize, int start) {
        return userDao.usersSize(name, pageSize, start);
    }

    @Override
    public void insertUser(UserEntity userEntity) {
		/*String password = null;
		try {
			password = MD5Util.encrypt(userEntity.getPassword());
			userEntity.setPassword(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}*/
        //userEntity.setPassword(new Md5PasswordEncoder().encodePassword(userEntity.getPassword(), null));
        userEntity.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(userEntity.getPassword()));
        userDao.insertUser(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        //userEntity.setPassword(new Md5PasswordEncoder().encodePassword(userEntity.getPassword(), null));
        if (userEntity.getId() != 8888) {
            userEntity.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(userEntity.getPassword()));
        }
        userDao.updateUser(userEntity);
    }

    @Override
    public void deleteUsers(List<String> groupId) {
        userDao.deleteUsers(groupId);
    }

    @Override
    @Transactional
    public void updateUsertype(UserEntity userEntity) {
        if (userEntity.getUsertype() == 0) {
            relationDao.delById(userEntity.getId());
        } else if (userEntity.getUsertype() == 1) {
            RelationEntity relationEntity = new RelationEntity();
            relationEntity.setUserId(userEntity.getId());
            relationEntity.setRoleId(1);
            List<RelationEntity> list = new ArrayList<RelationEntity>();
            list.add(relationEntity);
            relationDao.insertRelations(list);
        }
        //userDao.updateUsertype(userEntity.getLoginName(),userEntity.getUsertype());
        userDao.updateUsertypeById(userEntity.getId(), userEntity.getUsertype());
    }

    @Override
    public UserEntity getEntityById(int userid) {
        return userDao.getUserEntityById(userid);
    }

    @Override
    public UserInfoResponse getUserInfoById(int userId) {
        return userDao.getUserInfoById(userId);
    }

    @Override
    public void updateUserInfoByUserId(int userId, UserInfoRequest userInfoRequest) {
        userDao.updateUserInfo(userId, userInfoRequest.getName(), userInfoRequest.getUrl(), userInfoRequest.getEmail());
        userDetailService.updateUserInfo(userId, userInfoRequest.getInfo(), userInfoRequest.getLocation(), userInfoRequest.getSkill());
    }

    @Override
    public void updateUserHeadImageToLocation() {
        List<UserIdHeadImg> githubUserId = userDao.allGithubUserId();
        List<UserIdHeadImg> qqUserId = userDao.allQQUserId();
        threadPoolTaskExecutor.execute(() -> {
            for (UserIdHeadImg userIdHeadImg : githubUserId) {
                String headImg = pictureService.saveImage(userIdHeadImg.getHeadImage(), "head", "png");

                userDao.updateHeadImg(userIdHeadImg.getId(), headImg);
            }
        });
        threadPoolTaskExecutor.execute(() -> {
            for (UserIdHeadImg userIdHeadImg : qqUserId) {
                StringBuilder qqImg = new StringBuilder(userIdHeadImg.getHeadImage());
                qqImg.delete(qqImg.length() - 2, qqImg.length());
                qqImg.append("100");

                String headImg = pictureService.saveImage(qqImg.toString(), "head", "jpg");
                userDao.updateHeadImg(userIdHeadImg.getId(), headImg);
            }
        });
    }

    @Override
    public void updateUserHeadImg(int userId, String headImg) {
        String oldHeadImg = userDao.getUserEntityById(userId).getHeadimg();
        userDao.updateHeadImg(userId, headImg);
        threadPoolTaskExecutor.execute(()->{
            if(pictureService.deleteImage(oldHeadImg)){
                log.info("picture: {} delete successfully",oldHeadImg);
            }else {
                log.error("picture: {} delete unsuccessfully",oldHeadImg);
            }

        });
    }

    @Override
    public void updateUserUrl(int id) {
        String url = pathsProperties.getDomainName()+"/page/user/"+id;
        userDao.updateUserUrlById(id,url);
    }

}
