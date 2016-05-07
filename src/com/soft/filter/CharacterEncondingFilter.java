package com.soft.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class CharacterEncondingFilter implements Filter {
	private FilterConfig config;
	private String encoding = "utf-8";

	@Override
	public void destroy() {
		config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
	
		chain.doFilter(request, response);

	}
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	
		encoding = config.getInitParameter("encoding");

	}

}
