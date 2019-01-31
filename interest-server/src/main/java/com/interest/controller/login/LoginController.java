package com.interest.controller.login;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.interest.controller.authentication.MyAuthentication;
import com.interest.controller.authentication.MyAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	private LoginSuccessHandler loginSuccessHandler;

	@Resource(name = "gitHubAuthentication")
	private MyAuthentication gitHubAuthentication;

	@Resource(name = "qQAuthentication")
	private MyAuthentication qQAuthentication;

	@PostMapping("/authentication/github")
	public OAuth2AccessToken loginForGithHub(HttpServletRequest request, HttpServletResponse response, @RequestParam("code") String code)
			throws IOException {

		return login(request,response,code,gitHubAuthentication);
	}

	@PostMapping("/authentication/qq")
	public OAuth2AccessToken loginForQQ(HttpServletRequest request, HttpServletResponse response, @RequestParam("code") String code)
			throws IOException {

		return login(request,response,code,qQAuthentication);
	}

	public OAuth2AccessToken login(HttpServletRequest request, HttpServletResponse response,String code,MyAuthentication myAuthentication) throws IOException {
		if (code == null) {
			code = "";
		}

		code = code.trim();

		String id = myAuthentication.getUserId(code);

		MyAuthenticationToken authRequest = new MyAuthenticationToken(id);

		authRequest.setDetails(new OAuth2AuthenticationDetails(request));

		return loginSuccessHandler.getAccessToken(request, response, authRequest);
	}

}
