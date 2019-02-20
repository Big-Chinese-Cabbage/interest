package com.interest.service;

import com.interest.model.entity.UserDetailEntity;

public interface UserDetailService {

	void updatedDaily();

    UserDetailEntity getEntityByUserid(int userid);

    void updateArticleSign(int articleSign, int userid);

    void updateUserInfo(int userId, String info, String location, String skill);
}
