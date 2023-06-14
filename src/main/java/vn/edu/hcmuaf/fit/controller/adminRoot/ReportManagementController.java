package vn.edu.hcmuaf.fit.controller.adminRoot;

import vn.edu.hcmuaf.fit.dao.impl.CartDao;
import vn.edu.hcmuaf.fit.dao.impl.StatisticalDao;
import vn.edu.hcmuaf.fit.model.BookModel;
import vn.edu.hcmuaf.fit.model.CartModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "admin-report-management", value = "/admin-root-report-management")
public class ReportManagementController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartDao dao = new CartDao();
        StatisticalDao thongKeDao = new StatisticalDao();
        ArrayList<CartModel> listDonHang = new ArrayList<>();
        ArrayList<CartModel> listDonHangDaHuy = new ArrayList<>();
        ArrayList<BookModel> sanPhamBanChay = dao.top5BookBanChay();
        ArrayList<BookModel> sanPhamDaHetHang = dao.bookHetHang();
        double tongThuNhap =0.0;
        for(int i =0 ; i< dao.getAllCart().size();i++) {
            if(dao.getAllCart().get(i).getInShip() == 2 || dao.getAllCart().get(i).getInShip() == 3) {
                tongThuNhap += dao.getAllCart().get(i).getTotalPriceFromCart()- dao.getAllCart().get(i).getShip() - dao.chiPhiDonHang(dao.getAllCart().get(i).getId());

                listDonHang.add(dao.getAllCart().get(i));

            } else {
                if(dao.getAllCart().get(i).getInShip() == 4) {
                    listDonHangDaHuy.add(dao.getAllCart().get(i));
                }
            }
        }
        int khachHangMoi = dao.soLuongKhachMoi();
        int tongSoSanPham = dao.getAllSanPham();
        int tongDonHang = dao.getAllCart().size();

        request.setAttribute("donHangDaHuy", listDonHangDaHuy.size());
        request.setAttribute("sanPhamHetHang", sanPhamDaHetHang.size());
        request.setAttribute("khachHangMoi", khachHangMoi);
        request.setAttribute("tongThuNhap", tongThuNhap);
        request.setAttribute("tongSanPham", tongSoSanPham);
        request.setAttribute("tongDonHang",tongDonHang);
        request.setAttribute("listSanPhamBanChay",sanPhamBanChay);
        request.setAttribute("listTongDonHang",listDonHang);
        request.setAttribute("listSanPhamHetHang",sanPhamDaHetHang);
        request.setAttribute("nhapHang", thongKeDao.nhapHang());
        request.setAttribute("xuatHang", thongKeDao.xuatHang());
       
        // title dung de active aside
        request.setAttribute("title", "Báo Cáo Doanh Thu");
        request.getRequestDispatcher("views/admin_root/report-management.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
