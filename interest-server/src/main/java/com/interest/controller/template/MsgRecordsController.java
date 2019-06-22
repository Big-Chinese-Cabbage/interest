package com.interest.controller.template;

import com.interest.annotation.InterestLog;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.MsgRecordsService;
import com.interest.utils.SecurityAuthenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRecordsController {

    @Autowired
    private MsgRecordsService msgRecordsService;

    @InterestLog
    @GetMapping("/msgrecords/unreadnum")
    public ResponseWrapper<Integer> getUnreadMsgCount() {
        return new ResponseWrapper<>(msgRecordsService.getUnreadMsgCount(SecurityAuthenUtil.getId()));
    }

    @InterestLog
    @GetMapping("/msgrecords/user")
    public ResponseWrapper<PageResult> userMesRecordsGet(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
        PageResult pageResult = msgRecordsService.getUserMegsResult(pageSize, page * pageSize);
        return new ResponseWrapper<>(pageResult);
    }

    @InterestLog
    @PutMapping("/msgrecords/read")
    public ResponseWrapper<Integer> userReadMes(@RequestParam("msgRecordId") Integer msgRecordId) {
        msgRecordsService.updateMsgRecordIsread(msgRecordId, 1);
        return new ResponseWrapper<Integer>(msgRecordId);
    }

}
