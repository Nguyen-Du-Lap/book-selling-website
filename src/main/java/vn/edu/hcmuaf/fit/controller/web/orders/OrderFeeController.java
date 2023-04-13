package vn.edu.hcmuaf.fit.controller.web.orders;

import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.model.*;
import vn.edu.hcmuaf.fit.services.IBillDetailsService;
import vn.edu.hcmuaf.fit.services.IBillService;
import vn.edu.hcmuaf.fit.services.impl.BillService;
import vn.edu.hcmuaf.fit.utils.FeeGHNUtils;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

@WebServlet(name = "order/fee", value = "/orderFee")
public class OrderFeeController extends HttpServlet {
    IBillService billService = new BillService();
    IBillDAO iBillDAO = new BillDAO();

    public ArrayList<String> feeDeliver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameDistrict = request.getParameter("exits");
        StringTokenizer tokenizer1 = new StringTokenizer(nameDistrict,"/");
        String quan = tokenizer1.nextToken();
        String xa = tokenizer1.nextToken();
        //1463 quận thủ đức , 21808 linh trung
        ArrayList<String> result = new ArrayList<>();
        ArrayList<CartItem> p = new ArrayList<>();
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cartOrder");
//        Map<Integer, CartItem> mapSP = cart.getMap();
//        p.addAll(mapSP.values());
//        int weght =0;
//        int x1 = 0;
//        int x2 = 0;
//        double x3 = p.size() *0.5;
//        for(int i =0 ;i < p.size(); i++) {
//            BookDetails bookDetails = iBillDAO.findByIdBook(p.get(i).getProduct().getIdBook());
//            StringTokenizer tokenizer = new StringTokenizer(bookDetails.getSize(),"x");
//            String tr1 = tokenizer.nextToken().trim();
//            String tr2 = tokenizer.nextToken().trim();
//            if(x1 < Integer.parseInt(tr1)) {
//                x1 = Integer.parseInt(tr1);
//            }
//            if(x2 < Integer.parseInt(tr2)) {
//                x2 = Integer.parseInt(tr2);
//            }
//            weght += bookDetails.getWeight();
//        }
        result = FeeGHNUtils.feeAPIAndDate("10","20","10","200",1463,21808,quan, xa);
        cart.setShip((int) Double.parseDouble(result.get(1)));

        return result;

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(feeDeliver(request,response));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cartOrder");
        feeDeliver(request,response);
        PrintWriter out = response.getWriter();
        out.println(cart.getTotalPriceShip());
    }
}
