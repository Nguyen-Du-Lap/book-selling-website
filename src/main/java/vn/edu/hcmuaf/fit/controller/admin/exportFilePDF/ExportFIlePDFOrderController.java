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
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
//         getParmeters includes the nameUser, address, phone, email, idOder, quantity, nameProduct, information
        String nameUser = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String idOder = request.getParameter("idOder");
        String quantity = request.getParameter("quantity");
        String nameProduct = request.getParameter("nameProduct");
        String information = request.getParameter("information");


        // Thiết lập thông tin phản hồi
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"don_hang-"+idOder+".pdf\"");

        // Tạo một đối tượng Document từ mã HTML
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(toStringHtml(nameUser, address, phone, email, idOder, quantity, nameProduct, information), outputStream);

        // Ghi dữ liệu PDF đã tạo vào phản hồi
        response.setContentLength(outputStream.size());
        ServletOutputStream servletOutputStream = response.getOutputStream();
        outputStream.writeTo(servletOutputStream);
        servletOutputStream.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //toStringHtml nameUser, address, phone, email, idOder, quantity, nameProduct, information
    public String toStringHtml(String nameUser, String address, String phone, String email, String idOder, String quantity, String nameProduct , String information) {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Đơn hàng</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            margin: 20px;\n" +
                "        }\n" +
                "\n" +
                "        h1 {\n" +
                "            margin-bottom: 10px;\n" +
                "        }\n" +
                "\n" +
                "        table {\n" +
                "            width: 100%;\n" +
                "            border-collapse: collapse;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "\n" +
                "        th, td {\n" +
                "            border: 1px solid #ccc;\n" +
                "            padding: 8px;\n" +
                "            text-align: center; /* Canh giữa dữ liệu */\n" +
                "        }\n" +
                "\n" +
                "        th {\n" +
                "            background-color: #f2f2f2;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "\n" +
                "        tr:nth-child(even) {\n" +
                "            background-color: #f9f9f9;\n" +
                "        }\n" +
                "\n" +
                "        tr:hover {\n" +
                "            background-color: #e6e6e6;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h2>Thông tin khách hàng</h2>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>Tên khách hàng</th>\n" +
                "            <th>Địa chỉ</th>\n" +
                "            <th>Số điện thoại</th>\n" +
                "            <th>Email</th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>"+nameUser+"</td>\n" +
                "            <td>"+address+"</td>\n" +
                "            <td>"+phone+"</td>\n" +
                "            <td>"+email+"</td>\n" +
                "        </tr>\n" +
                "        <!-- Thêm các hàng khách hàng khác vào đây -->\n" +
                "    </table>\n" +
                "\n" +
                "    <h2>Thông tin người giao</h2>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>Tên người giao</th>\n" +
                "            <th>Số điện thoại</th>\n" +
                "            <th>Tên công ty</th>\n" +
                "            <th>Địa chỉ</th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Nguyễn Dư Lập</td>\n" +
                "            <td>0867415853</td>\n" +
                "            <td>Doraemon</td>\n" +
                "            <td>Đại Học Nông Lâm tp.HCM</td>\n" +
                "        </tr>\n" +
                "        <!-- Thêm các hàng người giao khác vào đây -->\n" +
                "    </table>\n" +
                "\n" +
                "    <h2>Thông tin đơn hàng</h2>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>Mã sản phẩm</th>\n" +
                "            <th>Số lượng</th>\n" +
                "            <th>Tên sản phẩm</th>\n" +
                "            <th>Ghi chú</th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>"+idOder+"</td>\n" +
                "            <td>"+quantity+"</td>\n" +
                "            <td>"+nameProduct+"</td>\n" +
                "            <td>"+information+"</td>\n" +
                "        </tr>\n" +
                "        <!-- Thêm các hàng đơn hàng khác vào đây -->\n" +
                "    </table>\n" +
                "</body>\n" +
                "</html>\n";
    }
}
