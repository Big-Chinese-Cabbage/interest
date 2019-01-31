package com.interest.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interest.model.utils.ResponseStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class InterestAuthenticationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException)
            throws ServletException {

        Map<String,String> map = new HashMap<>();
        map.put("status", ResponseStatus.FAIL_4001.getValue());
        map.put("message", ResponseStatus.FAIL_4001.getReasonPhrase());
        map.put("error", authException.toString());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), map);
        } catch (Exception e) {
            throw new ServletException();
        }
    }
}