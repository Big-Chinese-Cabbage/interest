package com.interest.exception.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interest.model.utils.ResponseStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class InterestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.setContentType("application/json;charset=UTF-8");

        Map resultMap = new HashMap();
        resultMap.put("status",ResponseStatus.FAIL_4003.getValue());
        resultMap.put("message",ResponseStatus.FAIL_4003.getReasonPhrase());
        resultMap.put("error",e.toString());
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(httpServletResponse.getOutputStream(), resultMap);
        } catch (Exception ex) {
            throw new ServletException();
        }

    }
}
