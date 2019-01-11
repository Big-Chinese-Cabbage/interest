package com.interest.controller.template;

import com.interest.model.PageResult;
import com.interest.model.utils.ResponseStatus;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.MsgRecordsService;
import com.interest.utils.SecurityAuthenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MsgRecordsController {

    @Autowired
    private MsgRecordsService msgRecordsService;


    @GetMapping("/msgrecords/unreadnum")
    public ResponseWrapper<Integer> getUnreadMsgCount() {
        return new ResponseWrapper<>(msgRecordsService.getUnreadMsgCount(SecurityAuthenUtil.getId()));
    }

    @GetMapping("/msgrecords/user")
    public ResponseWrapper<PageResult> userMesRecordsGet(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
        PageResult pageResult = msgRecordsService.getUserMegsResult(pageSize, page * pageSize);
        return new ResponseWrapper<>(pageResult);
    }

    @PutMapping("/msgrecords/read")
    public ResponseWrapper<Integer> userReadMes(@RequestParam("msgRecordId") Integer msgRecordId) {
        msgRecordsService.updateMsgRecordIsread(msgRecordId, 1);
        return new ResponseWrapper<Integer>(msgRecordId);
    }

}
