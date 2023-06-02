package vn.edu.hcmuaf.fit.controller.admin.exportFilePDF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import com.itextpdf.html2pdf.HtmlConverter;



@WebServlet(name = "exportFIlePDFOrderController", value = "/exportFIlePDFOrder")
public class ExportFIlePDFOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Thiết lập thông tin phản hồi
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"example.pdf\"");

        // Tạo một đối tượng Document từ mã HTML
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(" <table class=\"table\">\n" +
                "                                    <tbody>\n" +
                "                                    <tr>\n" +
                "                                        <td>Tên khách hàng:</td>\n" +
                "                                        <td>${CUSTOMER.firstName} ${CUSTOMER.lastName}</td>\n" +
                "                                    </tr>\n" +
                "                                    <tr>\n" +
                "                                        <td>Địa chỉ:</td>\n" +
                "                                        <td>${BILLDETAIL.address}</td>\n" +
                "                                    </tr>\n" +
                "                                    <tr>\n" +
                "                                        <td>Số điện thoại:</td>\n" +
                "                                        <td>${CUSTOMER.phone}</td>\n" +
                "                                    </tr>\n" +
                "                                    <tr>\n" +
                "                                        <td>Email:</td>\n" +
                "                                        <td>${CUSTOMER.email}</td>\n" +
                "                                    </tr>\n" +
                "                                    </tbody>\n" +
                "                                </table>", outputStream);

        // Ghi dữ liệu PDF đã tạo vào phản hồi
        response.setContentLength(outputStream.size());
        ServletOutputStream servletOutputStream = response.getOutputStream();
        outputStream.writeTo(servletOutputStream);
        servletOutputStream.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
