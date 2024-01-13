package shin.com.show_voucher.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.*;
import java.io.IOException;

@Component
public class WebFilter implements Filter {

	private Logger L = LoggerFactory.getLogger(this.getClass());
	

	@Override
	public void destroy()
	{
	}

	@Override
	public void init(FilterConfig fc) throws ServletException
	{
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//request.getServletContext().

		
//		if(request instanceof HttpServletRequest) {
//
//	         HttpServletRequest httpRequest = (HttpServletRequest)request;  // class casting
//	         HttpServletResponse httpResponse = (HttpServletResponse)response;  // class casting
//
//	         //String userAgent = httpRequest.getHeader("user-agent").toUpperCase();
//	         
//	         //L.error("userAgent = " + userAgent);
//	         
//	         //L.error("Remote url:"+httpRequest.getRequestURL());
//	         //L.error("Remote Address:"+httpRequest.getRemoteAddr());
//	         
//	         String ip = httpRequest.getHeader("X-Forwarded-For");
//	         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	             ip = httpRequest.getHeader("Proxy-Client-IP"); 
//	         } 
//	         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	             ip = httpRequest.getHeader("WL-Proxy-Client-IP"); 
//	         } 
//	         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	             ip = httpRequest.getHeader("HTTP_CLIENT_IP"); 
//	         } 
//	         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	             ip = httpRequest.getHeader("HTTP_X_FORWARDED_FOR"); 
//	         } 
//	         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	             ip = httpRequest.getRemoteAddr(); 
//	         }
//
//	         L.error("Remote url:"+httpRequest.getRequestURL());
//	         L.error("Remote Address:"+ip);
//	         
//	     }

	      chain.doFilter(request, response);
	}
}
