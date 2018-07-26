package org.ccunix.eshop.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUserFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
       System.out.println("这里是过滤器。。。。。。。。。。。。。");
       HttpServletRequest request = (HttpServletRequest) arg0;
       HttpServletResponse response = (HttpServletResponse) arg1;
       HttpSession session = request.getSession(false);
       Object userInfo = session.getAttribute("userInfo");
       if(session!=null && userInfo != null){
    	   arg2.doFilter(arg0, arg1);
       }else{
    	   response.sendRedirect("../logOut.html");
       }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
