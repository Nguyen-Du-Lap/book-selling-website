package vn.edu.hcmuaf.fit.controller.admin.managementSlider;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.IBookManagementDAO;
import vn.edu.hcmuaf.fit.dao.impl.BookManagementDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.IBookManagementService;
import vn.edu.hcmuaf.fit.services.ISliderManagementService;
import vn.edu.hcmuaf.fit.services.impl.BookManagementService;
import vn.edu.hcmuaf.fit.services.impl.SliderManagementService;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.net.InetAddress;

@MultipartConfig
@WebServlet(name = "/admin-add-slide", value = "/admin-add-slide")
public class AddSlideController extends HttpServlet {

    ISliderManagementService iSliderManagementService = new SliderManagementService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");
        if( message != null && alert != null) {
            request.setAttribute("message", message);
            request.setAttribute("alert", alert);
        }
        request.getRequestDispatcher("views/admin/form-add-slide.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            String name = request.getParameter("name");
            String starTime = request.getParameter("timeStart");
            String finsishTime = request.getParameter("timeFinish");
            Part part1 = request.getPart("image1");
            CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
            InetAddress myIP=InetAddress.getLocalHost();
            String ip= myIP.getHostAddress();

            if(name != null &&  starTime != null && finsishTime != null) {
                if(part1 != null)  {
                    iSliderManagementService.addImage(request,response,name,part1,starTime,finsishTime);
                    Log log = new Log(Log.INFO,ip,"Quản lý slide",cus.getIdUser(),"Thêm slide thành công",1);
                    log.insert();
                    response.sendRedirect("/admin-add-slide?message=Them thanh cong&alert=success");
                }
            }else {
                response.sendRedirect("/admin-add-slide?message=Them that bai&alert=danger");
            }



        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/admin-add-slide?message=Vui long nhap thong tin can thiet&alert=warning");
        }

    }
}
