package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Login;

/**
 * Servlet Filter implementation class loginAuth
 */
@WebFilter(
		description = "login filter auth", 
		urlPatterns = { 
				"/loginAuth", 
				"/security/login.jsf"
		})
public class loginAuth implements Filter {

    /**
     * Default constructor. 
     */
    public loginAuth() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = (HttpSession)req.getSession();
		
		Login login = (Login) session.getAttribute("usuario");
		
		if(login == null){
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}else{
			res.sendRedirect(req.getContextPath() + "/app/main.jsf");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
