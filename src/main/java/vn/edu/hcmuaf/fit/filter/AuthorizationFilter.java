package vn.edu.hcmuaf.fit.filter;

import vn.edu.hcmuaf.fit.db.MessageProperties;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AuthorizationFilter implements Filter {
    private  ServletContext context;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        if(url.startsWith("/admin-root")) {
            if(cus != null) {
                if(cus.getRole().equalsIgnoreCase("admin")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }else {
                    request.setAttribute("message", MessageProperties.getNot_login());
                    request.setAttribute("alert", "danger");
                    request.getRequestDispatcher("/views/login.jsp").forward(request, response);
                }
            }else {
                request.setAttribute("message", MessageProperties.getNot_login());
                request.setAttribute("alert", "danger");
                request.getRequestDispatcher("/views/login.jsp").forward(request, response);
            }
        }else if(url.startsWith("/admin")) {
            if(cus != null) {
                if(cus.getRole().equalsIgnoreCase("mod") || cus.getRole().equalsIgnoreCase("admin")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }else {
                    request.setAttribute("message", MessageProperties.getNot_login());
                    request.setAttribute("alert", "danger");
                    request.getRequestDispatcher("/views/login.jsp").forward(request, response);
                }
            }else {
                request.setAttribute("message", MessageProperties.getNot_login());
                request.setAttribute("alert", "danger");
                request.getRequestDispatcher("/views/login.jsp").forward(request, response);
            }
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}