package com.practice.webapp.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;;


public class Interceptor0417 implements HandlerInterceptor{
	//Logger logger = LoggerFactory.getLogger(Interceptor0417.class);
	public final static String SEESION_MEMBER = "seesion_member";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//logger.info("Before handler is executed");
//		System.out.println("Before handler is executed");
        //请求的路径
        String contextPath=request.getContextPath();
        //String  url=request.getServletPath().toString();
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute(SEESION_MEMBER);
        
//        System.out.println(contextPath);
//        System.out.println(url);
//        System.out.println(user);
        
        if(StringUtils.isEmpty(user))
        {
        	response.sendRedirect(contextPath+"/login");
        	return false;
        }
        
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		//logger.info("After request has finished");
//		System.out.println("After request has finished");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		//logger.info("After handler is executed");
//		System.out.println("After handler is executed");
	}

}
