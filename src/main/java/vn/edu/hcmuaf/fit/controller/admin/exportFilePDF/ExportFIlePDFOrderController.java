package vn.edu.hcmuaf.fit.controller.admin.exportFilePDF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.html2pdf.HtmlConverter;
import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.dao.impl.CartDao;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.Bill;
import vn.edu.hcmuaf.fit.model.CartModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.PriceFormatUtil;


@WebServlet(name = "exportFIlePDFOrderController", value = "/exportFIlePDFOrder")
public class ExportFIlePDFOrderController extends HttpServlet {
    CartDao cartDao = new CartDao();
    BillDAO billDAO = new BillDAO();
    CustomerDAO customerDAO = new CustomerDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        CartModel cartModel = cartDao.getCartById(idInt);
        CustomerModel customerModel = customerDAO.findById(cartModel.getIdUser());
        Bill bill = billDAO.find1BillByIdCart(cartModel.getId());
        List<Bill> listBill = billDAO.findAllBillByIdCart(cartModel.getId());

        // Thiết lập thông tin phản hồi
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"don_hang-"+bill.getIdCart()+".pdf\"");

        // Tạo một đối tượng Document từ mã HTML
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(toStringHtml(customerModel, bill, listBill), outputStream);

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
    public String toStringHtml(CustomerModel customerModel, Bill bill, List<Bill> listBill){
        String htmlCode = "<!DOCTYPE html>\n" +
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
                "            <td>"+customerModel.getFirstName()+" "+customerModel.getLastName()+"</td>\n" +
                "            <td>"+customerModel.getAddress()+"</td>\n" +
                "            <td>"+customerModel.getPhone()+"</td>\n" +
                "            <td>"+customerModel.getEmail()+"</td>\n" +
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
                "        </tr>\n";
                for(Bill b: listBill) {
                    int idOder = b.getIdOrder();
                    int quantity = b.getQuantity();
                    String nameProduct = b.getName();
                    String information = b.getInfo() != null ? b.getInfo() : "";

                    htmlCode += "<tr>\n" +
                            "<td>"+idOder+"</td>\n" +
                            "<td>"+quantity+"</td>\n" +
                            "<td>"+nameProduct+"</td>\n" +
                            "<td>"+information+"</td>\n" +
                            "</tr>\n";
                }

                htmlCode += "<!-- Thêm các hàng đơn hàng khác vào đây -->\n"+
                "    </table>\n" +
                 "<h2>Tổng tiền: "+ PriceFormatUtil.formatPrice(bill.getTotalPrice())+"</h2>\n" +
                "</body>\n" +
                "</html>\n";

                return htmlCode;
    }
}
