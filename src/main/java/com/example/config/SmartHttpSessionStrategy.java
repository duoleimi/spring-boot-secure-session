package com.example.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.accept.ContentNegotiationStrategy;

/**
 * 同时支持header session 和 cookie session
 * @author lee 2016年8月20日
 */
@Component
public class SmartHttpSessionStrategy implements HttpSessionStrategy {
	private HttpSessionStrategy browser;

	private HttpSessionStrategy api;

	@Autowired
	public SmartHttpSessionStrategy(ContentNegotiationStrategy contentNegotiationStrategy) {
		this(new CookieHttpSessionStrategy(), new HeaderHttpSessionStrategy());
	}

	public SmartHttpSessionStrategy(HttpSessionStrategy browser, HttpSessionStrategy api) {
		this.browser = browser;
		this.api = api;
	}

	@Override
	public String getRequestedSessionId(HttpServletRequest request) {
		return getStrategy(request).getRequestedSessionId(request);
	}

	@Override
	public void onNewSession(Session session, HttpServletRequest request, HttpServletResponse response) {
		getStrategy(request).onNewSession(session, request, response);
	}

	@Override
	public void onInvalidateSession(HttpServletRequest request, HttpServletResponse response) {
		getStrategy(request).onInvalidateSession(request, response);
	}

	private HttpSessionStrategy getStrategy(HttpServletRequest request) {
		if (request.getServletPath().startsWith("/api")) {
			return this.api;
		}
		return this.browser;
	}
}
