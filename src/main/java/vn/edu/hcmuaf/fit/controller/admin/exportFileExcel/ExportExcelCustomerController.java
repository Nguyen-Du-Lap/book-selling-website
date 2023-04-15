package vn.edu.hcmuaf.fit.controller.admin.exportFileExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vn.edu.hcmuaf.fit.dao.ICustomerDAO;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@WebServlet(name = "exportExcelCustomerController", value = "/exportExcelCustomerController")
public class ExportExcelCustomerController extends HttpServlet {
    ICustomerDAO customerDAO = new CustomerDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Thiết lập các header của response
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=customers.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();

        // Tạo sheet mới
        XSSFSheet sheet = workbook.createSheet("Sheet 1");
        List<CustomerModel> list = customerDAO.findAllCustomer();

        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd/MM/yyyy HH:mm:ss"));
        // Thêm dữ liệu vào sheet
        //1 header
        int rowNo = 0;
        Row row = sheet.createRow(rowNo++);
        int cellnum = 0;
        Cell cell = row.createCell(cellnum++);
        cell.setCellValue("Fist_Name");

        cell = row.createCell(cellnum++);
        cell.setCellValue("Last_Name");

        cell = row.createCell(cellnum++);
        cell.setCellValue("Email");

        cell = row.createCell(cellnum++);
        cell.setCellValue("Address");

        cell = row.createCell(cellnum++);
        cell.setCellValue("Phone");

        cell = row.createCell(cellnum++);
        cell.setCellValue("CreatedTime");

        for(CustomerModel c : list) {
            cellnum = 0;
            row = sheet.createRow(rowNo++);

            cell = row.createCell(cellnum++);
            cell.setCellValue(c.getFirstName());

            cell = row.createCell(cellnum++);
            cell.setCellValue(c.getLastName());

            cell = row.createCell(cellnum++);
            cell.setCellValue(c.getEmail());

            cell = row.createCell(cellnum++);
            cell.setCellValue(c.getAddress());

            cell = row.createCell(cellnum++);
            cell.setCellValue(c.getPhone());

            cell = row.createCell(cellnum++);
            cell.setCellValue(c.getCreatedTime());
            cell.setCellStyle(cellStyle);
        }

        // Ghi workbook vào response
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
