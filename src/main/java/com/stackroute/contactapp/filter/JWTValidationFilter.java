package com.stackroute.contactapp.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTValidationFilter extends GenericFilterBean{
	
	public static final String BEARER = "Bearer";
	public static final String AUTHORIZATION = "Authorization";

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		final String authorization = request.getHeader(AUTHORIZATION);
		if(authorization == null || !authorization.startsWith(BEARER)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().println("Auth Header is missing");
		}
		
		else {
		// Bearer tokenValue
		String token = authorization.substring(7);
		try {
			final Claims claims = Jwts.parser().setSigningKey("testsecretkey")
					.parseClaimsJws(token)
					.getBody();
			request.setAttribute("claims", claims);
			System.out.println(claims.getSubject());
			chain.doFilter(request, response);
			
		}
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().println("Invalid Token");
		}
		}
		
	}
	
	

}














