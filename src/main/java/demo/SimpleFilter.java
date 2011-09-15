package demo;

import javax.servlet.*;
import java.io.IOException;
import java.net.URL;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
public class SimpleFilter implements Filter{
    FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getServletContext().getContextPath());
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        URL resource = filterConfig.getServletContext().getResource("/");
        System.out.println("Filtering with resource: " + resource);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
