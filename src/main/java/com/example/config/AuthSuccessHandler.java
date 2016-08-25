package com.example.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import com.example.base.utils.SecureUtil;

/**
 * 浏览器/Api 认证成功跳转处理 
 * @author lee 2016年8月21日
 */
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

	private final String forwardUrl;
	private final String apiForwardUrl;

	/**
	 * @param forwardUrl
	 */
	public AuthSuccessHandler(String forwardUrl, String apiForwardUrl) {
		Assert.isTrue(UrlUtils.isValidRedirectUrl(forwardUrl), "'"
				+ forwardUrl + "' is not a valid forward URL");
		this.forwardUrl = forwardUrl;
		this.apiForwardUrl = apiForwardUrl;
	}

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		String url = null;
		if (SecureUtil.isApi(request)) {
			url = this.apiForwardUrl;
		} else {
			url = this.forwardUrl;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
