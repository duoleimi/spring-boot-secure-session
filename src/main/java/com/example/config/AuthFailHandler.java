package com.example.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.example.base.utils.SecureUtil;

/**
 * 认证失败处理
 * @author lll 2016年8月22日
 */
public class AuthFailHandler extends SimpleUrlAuthenticationFailureHandler {

	public AuthFailHandler(String defaultFailureUrl) {
		super(defaultFailureUrl);
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		// api  401
		if (SecureUtil.isApi(request)) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"Authentication Failed: " + exception.getMessage());
		}
		else {
			super.onAuthenticationFailure(request, response, exception);
		}
	}
	
}
