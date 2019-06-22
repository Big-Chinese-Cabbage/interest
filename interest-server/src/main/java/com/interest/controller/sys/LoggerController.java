package com.interest.controller.sys;

import com.interest.annotation.InterestLog;
import com.interest.annotation.handler.InterestException;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.LoggerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Api("日志")
public class LoggerController {

    @Autowired
    private LoggerService loggerService;

    @InterestLog
    @GetMapping("/public/logs")
    @ApiOperation("获取日志（分页）")
    public ResponseWrapper<PageResult<InterestException>> getLogs(@RequestParam("pageIndex") Integer pageIndex,
                                                                  @RequestParam("pageSize") Integer pageSize) {
        return new ResponseWrapper<PageResult<InterestException>>(loggerService.getLogs(pageIndex, pageSize));
    }

    @InterestLog
    @GetMapping("/public/logs/test")
    public ResponseWrapper test(@RequestParam("id") Integer id) {

        if(id == 1){
            throw new RuntimeException("RuntimeException");
        }else if(id == 2){
            throw new NullPointerException("null");
        }

        return new ResponseWrapper<>("success");
    }
}
