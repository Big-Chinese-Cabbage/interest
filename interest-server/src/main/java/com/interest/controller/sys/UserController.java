package com.interest.controller.sys;

import com.interest.annotation.InterestLog;
import com.interest.model.utils.PageResult;
import com.interest.model.entity.UserEntity;
import com.interest.model.request.UserInfoRequest;
import com.interest.model.response.UserInfoResponse;
import com.interest.model.utils.ResponseWrapper;
import com.interest.picture.PictureService;
import com.interest.service.UserService;
import com.interest.utils.SecurityAuthenUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
/*@PreAuthorize("hasRole('ADMI')")*/
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @Autowired
    private PictureService pictureService;

    @InterestLog
    @GetMapping("/public/user")
    public ResponseWrapper<UserEntity> userGet() {
        int userid = SecurityAuthenUtil.getIdWithoutException();
        UserEntity userEntity = userService.getEntityById(userid);
        log.debug("The method is ending");
        return new ResponseWrapper<>(userEntity);
    }

    /**
     * 获取user表数据
     *
     * @param name
     * @param pageSize
     * @param page
     * @return
     */
    @InterestLog
    @GetMapping("/users")
    public ResponseWrapper<PageResult> usersList(@RequestParam(value = "name", required = false) String name, @RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
        PageResult<UserEntity> pageResult = new PageResult<>();
        pageResult.setData(userService.usersList(name, pageSize, page * pageSize));
        pageResult.setTotalCount(userService.usersSize(name, pageSize, page * pageSize));
        log.debug("The method is ending");
        return new ResponseWrapper<>(pageResult);
    }

    /**
     * 新建用户信息
     *
     * @param userEntity
     * @return
     */
    @InterestLog
    @PostMapping("/users/user")
    public ResponseWrapper<UserEntity> insertUser(@RequestBody UserEntity userEntity) {
        userService.insertUser(userEntity);
        log.debug("The method is ending");
        return new ResponseWrapper<>(userEntity);
    }

    /**
     * 新建用户信息
     *
     * @param userEntity
     * @return
     */
    @InterestLog
    @PostMapping("/register")
    public ResponseWrapper<UserEntity> register(@RequestBody UserEntity userEntity) {
        userService.insertUser(userEntity);
        log.debug("The method is ending");
        return new ResponseWrapper<>(userEntity);
    }

    /**
     * 更新用户信息
     *
     * @param userEntity
     * @return
     */
    @InterestLog
    @PutMapping("/user")
    public ResponseWrapper<UserEntity> updateUser(@RequestBody UserEntity userEntity) {
        userService.updateUser(userEntity);
        log.debug("The method is ending");
        return new ResponseWrapper<>(userEntity);
    }

    @InterestLog
    @PutMapping("/users/user")
    public ResponseWrapper<UserEntity> updateUsertype(@RequestBody UserEntity userEntity) {
        userService.updateUsertype(userEntity);
        log.debug("The method is ending");
        return new ResponseWrapper<>(userEntity);
    }

    /**
     * 删除用户信息
     *
     * @param groupId
     * @return
     */
    @InterestLog
    @DeleteMapping("/users")
    public ResponseWrapper<List<String>> deleteUsers(@RequestBody List<String> groupId) {
        userService.deleteUsers(groupId);
        return new ResponseWrapper<>(groupId);
    }

    @InterestLog
    @GetMapping("/general/users/user/info")
    @ApiOperation("获取用户详情")
    public ResponseWrapper<UserInfoResponse> getUserInfo() {
        int userId = SecurityAuthenUtil.getId();
        UserInfoResponse userInfoResponse = userService.getUserInfoById(userId);
        return new ResponseWrapper<>(userInfoResponse);
    }

    @InterestLog
    @GetMapping("/public/users/user/info")
    @ApiOperation("通过用户id来获取用户详情")
    public ResponseWrapper<UserInfoResponse> getUserInfoById(@RequestParam("userId") int userId) {
        UserInfoResponse userInfoResponse = userService.getUserInfoById(userId);
        return new ResponseWrapper<>(userInfoResponse);
    }

    @InterestLog
    @PutMapping("/general/users/user/info")
    @ApiOperation("修改用户详情")
    public ResponseWrapper<UserInfoResponse> updateUserInfo(@RequestBody UserInfoRequest userInfoRequest) {
        int userId = SecurityAuthenUtil.getId();
        userService.updateUserInfoByUserId(userId, userInfoRequest);
        return new ResponseWrapper<>(userInfoRequest);
    }

    @InterestLog
    @PatchMapping("/general/users/user/headImg")
    public ResponseWrapper<String> updateUserHeadImg(@RequestParam("headImg") String headImg) {
        int userId = SecurityAuthenUtil.getId();
        userService.updateUserHeadImg(userId, headImg);
        return new ResponseWrapper<>(headImg);
    }

    @InterestLog
    @PostMapping("/general/users/user/head-img/upload")
    public ResponseWrapper<String> uploadUserHeadImg(@RequestParam("picture") MultipartFile picture) {
        String pictureUrl = pictureService.saveImage(picture,"/head");
        return new ResponseWrapper<>(pictureUrl);
    }

}
