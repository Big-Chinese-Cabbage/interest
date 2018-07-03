package com.interest.controller.login;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.interest.controller.authentication.MyAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.stereotype.Component;


@Component
public class LoginSuccessHandler {

	@Resource(name = "myUserDetailsService")
	private UserDetailsService userDetailsService;

	@Autowired
	private ClientDetailsService clientDetailsService;

	@Autowired
	private AuthorizationServerTokenServices authorizationServerTokenServices;

	/*
	 * @Autowired private ObjectMapper objectMapper;
	 */

	public OAuth2AccessToken getAccessToken(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {

		OAuth2Request auth2Request = getOAuth2Request(request, response, authentication);
		
		UserDetails user = getUserDetails(authentication);

		MyAuthenticationToken authenticationTokenResult = new MyAuthenticationToken(user,
				user.getAuthorities());

		authenticationTokenResult.setDetails(authentication.getDetails());

		OAuth2Authentication auth2Authentication = new OAuth2Authentication(auth2Request, authenticationTokenResult);

		OAuth2AccessToken token = authorizationServerTokenServices.createAccessToken(auth2Authentication);

		return token;
	}

	public OAuth2Request getOAuth2Request(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		String header = request.getHeader("Authorization");

		if (header == null || !header.startsWith("Basic ")) {
			throw new UnapprovedClientAuthenticationException("请求头中无client信息");
		}

		String[] tokens = extractAndDecodeHeader(header, request);
		assert tokens.length == 2;

		String clientId = tokens[0];
		String clientSecret = tokens[1];

		ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);


		if (clientDetails == null) {
			throw new UnapprovedClientAuthenticationException("clientId对应的配置信息不存在：" + clientId);
		} else if (clientSecret != null && !clientSecret.equals(clientDetails.getClientSecret().substring(6,12))) {
			throw new UnapprovedClientAuthenticationException("clientSecret不匹配：" + clientId);
		}

		TokenRequest tokenRequest = new TokenRequest(new HashMap<String, String>(), clientId, clientDetails.getScope(),
				"custom");

		OAuth2Request auth2Request = tokenRequest.createOAuth2Request(clientDetails);

		return auth2Request;
	}

	public UserDetails getUserDetails(Authentication authentication) {

		/*
		 * Collection<SimpleGrantedAuthority> collection = new
		 * HashSet<SimpleGrantedAuthority>(); collection.add(new
		 * SimpleGrantedAuthority("ROLE_ADMIN"));
		 */
		/*
		 * Authentication userAuth = new
		 * UsernamePasswordAuthenticationToken(userEntity.getLoginName(),
		 * userEntity.getPassword(), collection);
		 */

		/*
		 * SmsCodeAuthenticationToken smsCodeAuthenticationToken =
		 * (SmsCodeAuthenticationToken) authentication;
		 */

		UserDetails user = userDetailsService.loadUserByUsername((String) authentication.getPrincipal());

		if (user == null) {
			throw new InternalAuthenticationServiceException("无法获取用户信息");
		}

		return user;
	}

	private String[] extractAndDecodeHeader(String header, HttpServletRequest request) throws IOException {

		byte[] base64Token = header.substring(6).getBytes("UTF-8");
		byte[] decoded;
		try {
			decoded = Base64.getDecoder().decode(base64Token);
		} catch (IllegalArgumentException e) {
			throw new BadCredentialsException("Failed to decode basic authentication token");
		}

		String token = new String(decoded, "UTF-8");

		int delim = token.indexOf(":");

		if (delim == -1) {
			throw new BadCredentialsException("Invalid basic authentication token");
		}
		return new String[] { token.substring(0, delim), token.substring(delim + 1) };
	}

	/*
	 * @Override public void onAuthenticationSuccess(HttpServletRequest request,
	 * HttpServletResponse response, Authentication authentication) throws
	 * IOException, ServletException {
	 * 
	 * String header = request.getHeader("Authorization");
	 * 
	 * if (header == null || !header.startsWith("Basic ")) { throw new
	 * UnapprovedClientAuthenticationException("请求头中无client信息"); }
	 * 
	 * String[] tokens = extractAndDecodeHeader(header, request); assert
	 * tokens.length == 2;
	 * 
	 * String clientId = tokens[0]; String clientSecret = tokens[1];
	 * 
	 * ClientDetails clientDetails =
	 * clientDetailsService.loadClientByClientId(clientId);
	 * 
	 * if (clientDetails == null) { throw new
	 * UnapprovedClientAuthenticationException("clientId对应的配置信息不存在：" + clientId); }
	 * else if (clientSecret != null &&
	 * clientSecret.equals(clientDetails.getClientSecret())) { throw new
	 * UnapprovedClientAuthenticationException("clientSecret不匹配：" + clientId); }
	 * 
	 * TokenRequest tokenRequest = new TokenRequest(new HashMap<String, String>(),
	 * clientId, clientDetails.getScope(), "custom");
	 * 
	 * OAuth2Request auth2Request = tokenRequest.createOAuth2Request(clientDetails);
	 * 
	 * Collection<SimpleGrantedAuthority> collection = new
	 * HashSet<SimpleGrantedAuthority>(); collection.add(new
	 * SimpleGrantedAuthority("ROLE_ADMIN"));
	 * 
	 * Authentication userAuth = new
	 * UsernamePasswordAuthenticationToken(userEntity.getLoginName(),
	 * userEntity.getPassword(), collection);
	 * 
	 * 
	 * OAuth2Authentication auth2Authentication = new
	 * OAuth2Authentication(auth2Request, authentication);
	 * 
	 * OAuth2AccessToken token =
	 * authorizationServerTokenServices.createAccessToken(auth2Authentication);
	 * 
	 * response.setContentType("application/json;charset-UTF-8");
	 * response.getWriter().write(objectMapper.writeValueAsString(token)); }
	 */

}
