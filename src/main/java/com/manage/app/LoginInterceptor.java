package com.manage.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.member.Member;

public class LoginInterceptor implements HandlerInterceptor{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		
		System.out.println("request.getContextPath() : " + request.getContextPath()); 
		
		if (member == null) {
			logger.info("로그인 interceptor 처리 - session 없음");
			response.sendRedirect(request.getContextPath() );
			return false;
		}
		
		logger.info("로그인 interceptor 처리 - session 있음");
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}
	

}