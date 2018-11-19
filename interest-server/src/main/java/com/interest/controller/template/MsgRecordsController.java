package com.interest.controller.template;

import com.interest.model.PageResult;
import com.interest.service.MsgRecordsService;
import com.interest.utils.SecurityAuthenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRecordsController {

    @Autowired
    private MsgRecordsService msgRecordsService;


    @GetMapping("/msgrecords/unreadnum")
    public int getUnreadMsgCount() {
       return msgRecordsService.getUnreadMsgCount(SecurityAuthenUtil.getId());
    }

    @GetMapping("/msgrecords/user")
    public PageResult userMesRecordsGet(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page){
        PageResult pageResult = msgRecordsService.getUserMegsResult(pageSize, page * pageSize);
        return pageResult;
    }


}
