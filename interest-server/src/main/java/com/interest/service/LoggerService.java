package com.interest.service;

import com.interest.annotation.handler.InterestException;
import com.interest.model.utils.PageResult;

public interface LoggerService {
    PageResult<InterestException> getLogs(Integer pageIndex, Integer pageSize);
}
