package vn.edu.hcmuaf.fit.controller.admin.managementSlider;

import vn.edu.hcmuaf.fit.services.ISliderManagementService;
import vn.edu.hcmuaf.fit.services.impl.SliderManagementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "admin-table-slider", value = "/admin-table-slider")
public class TableSliderController extends HttpServlet {
        ISliderManagementService iSliderManagementService = new SliderManagementService();
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // title dung de active aside
            request.setAttribute("title", "Danh Sách Slider");
            request.setAttribute("listSlide", iSliderManagementService.getAll());

            String message = request.getParameter("message");
            String alert = request.getParameter("alert");

            if(message != null & alert != null) {
                request.setAttribute("message", message);
                request.setAttribute("alert", alert);
            }
            request.getRequestDispatcher("views/admin/table-data-slider.jsp").forward(request, response);

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
    }

