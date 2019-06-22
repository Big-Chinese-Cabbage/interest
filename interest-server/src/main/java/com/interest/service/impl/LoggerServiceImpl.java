package com.interest.service.impl;

import com.interest.annotation.handler.InterestException;
import com.interest.annotation.handler.InterestLogAspect;
import com.interest.model.utils.PageResult;
import com.interest.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LoggerServiceImpl implements LoggerService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public PageResult<InterestException> getLogs(Integer pageIndex, Integer pageSize) {

        List<InterestException> interestExceptionList = Objects.requireNonNull(redisTemplate.opsForList().range(InterestLogAspect.INTEREST_LOG_KEY, pageIndex * pageSize, pageIndex * pageSize + pageSize - 1)).stream().map(o -> (InterestException) o).collect(Collectors.toList());
        int totalCount = Objects.requireNonNull(redisTemplate.opsForList().size(InterestLogAspect.INTEREST_LOG_KEY)).intValue();

        return new PageResult<InterestException>(interestExceptionList, totalCount);
    }

}
