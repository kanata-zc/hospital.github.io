package cdu.edu.hospital.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cdu.edu.hospital.entity.User;
import cdu.edu.hospital.util.BaseUtils;

//拦截器
public class CommonInterceptor implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest)req;
			HttpServletResponse response = (HttpServletResponse)res;
			User user = BaseUtils.getUser(request);
			String path=request.getRequestURI();
			System.out.println(path);
			path = path.substring( path.indexOf('/', 1));
			
			System.out.println("trim path:"+path);
			if(path.matches(".*/user\\.html$")){
				checkLogin(request,response,chain);
				return;
			}
			chain.doFilter(request, response); 
	}
	
	/**
	 * 过滤器初始化代码
	 */
	@Override
	public void init(FilterConfig cfg) throws ServletException {
	} 
	
	private void checkDotDo(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
	throws IOException, ServletException {
			User user = BaseUtils.getUser(request);
			if(user!=null){
				chain.doFilter(request, response);
				return;
			}	
			//没有登录时候，返回JSON错误消息
			String json="{\"state\":1,\"message\":\"必须登录！\"}";
			response.setCharacterEncoding("utf-8");
			response.setContentType(
			"application/json;charset=UTF-8");
			response.getWriter().println(json);
		}
	
	private void checkLogin(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
	throws IOException, ServletException {
			//如果没有， 就重定向到login.jsp
			User user = BaseUtils.getUser(request);
			if(user!=null){
				if(!("".equals(user.getId()))&&(user.getId()!=null)){
					chain.doFilter(request, response);
					return;
				}
			}
			//重定向到 login.jsp
			String path=request.getContextPath()+"/login.jsp";
			System.out.println("path:"+path);
			response.sendRedirect(path);
	}
}
