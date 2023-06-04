package vn.edu.hcmuaf.fit.filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceFilter implements Filter {
    public static boolean maintenanceMode = false; // Đặt trạng thái chế độ bảo trì ban đầu là false
    // list url không chặn
    List<String> listUrl = new ArrayList();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        listUrl.add("/admin-root");
        listUrl.add("/admin");
        listUrl.add("/login");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String url = httpRequest.getRequestURI();
        if (maintenanceMode) {
            if (checkStartWith(listUrl, url)) {
                chain.doFilter(request, response); // Tiếp tục xử lý yêu cầu bình thường
                return;
            }else {
                // Chuyển hướng đến trang bảo trì
                request.getRequestDispatcher("/views/web/maintenance.jsp").forward(request, response);
                return;
            }
        }
        chain.doFilter(request, response); // Tiếp tục xử lý yêu cầu bình thường

    }

    @Override
    public void destroy() {
        // Mã dọn dẹp, nếu cần
    }

    public void setMaintenanceMode(boolean maintenanceMode) {
        this.maintenanceMode = maintenanceMode;
    }

    public boolean checkStartWith(List<String> listSW, String url) {
        for (String sw : listSW) {
            if (url.startsWith(sw)) {
                return true;
            }
        }
        return false;
    }
}
