package com.interest;

import com.interest.model.entity.EmailEntity;
import com.interest.model.entity.MenuEntity;
import com.interest.model.entity.UserEntity;
import com.interest.service.EmailService;
import com.interest.service.MenuService;
import com.interest.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {

    @Autowired
    private EmailService emailService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @Test
    public void testInsertEmailService(){
        EmailEntity emailEntity = new EmailEntity();
        emailEntity.setUserid(50);
        emailEntity.setTitle("VP");
        emailEntity.setEmail("abc@a.com");
        emailEntity.setName("abc");
        emailEntity.setContent("this is abc");
        emailEntity.setCreatetime(Calendar.getInstance().toString());
        emailService.insertEntity(emailEntity);
    }

    @Test
    public void testInsertMenuService(){
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setIcon("abc");
        menuEntity.setName("testMenu");
        menuEntity.setRemark("remarks");
        menuEntity.setUrl("/test");
        menuService.insertMenu(menuEntity);
    }

    @Test
    public void testUserService_1(){
        UserEntity userEntity = new UserEntity();
        userEntity.setLoginName("jobs");
        userEntity.setEmail("jobs@apple.com");
        userEntity.setPassword("jobs");
        userEntity.setUsertype(0);
        userService.insert(userEntity);

        UserEntity temp = userService.getUserEntityByLoginName("jobs");
        Assert.assertEquals(temp.getLoginName(),userEntity.getLoginName());
        Assert.assertEquals(temp.getEmail(),userEntity.getEmail());
        Assert.assertEquals(temp.getUsertype(),userEntity.getUsertype());

        userService.del(userEntity);
        Assert.assertNull(userService.getUserEntityByLoginName("jobs"));
    }

}
