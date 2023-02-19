package vn.edu.hcmuaf.fit.controller.web;

import vn.edu.hcmuaf.fit.constant.SystemConstant;
import vn.edu.hcmuaf.fit.dao.IBookDAO;
import vn.edu.hcmuaf.fit.dao.ISlidePr;
import vn.edu.hcmuaf.fit.dao.impl.BLockUserDao;
import vn.edu.hcmuaf.fit.dao.impl.BookDAO;
import vn.edu.hcmuaf.fit.dao.impl.SlidePrDAO;
import vn.edu.hcmuaf.fit.db.MessageProperties;
import vn.edu.hcmuaf.fit.model.AuthorModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.IAuthorService;
import vn.edu.hcmuaf.fit.services.ICatalogService;
import vn.edu.hcmuaf.fit.services.ICustomerService;
import vn.edu.hcmuaf.fit.services.impl.AuthorService;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

@WebServlet(urlPatterns = { "/home", "/login", "/logout"})
//@WebServlet(name = "home", value = "/home")
public class HomeController extends HttpServlet {
    @Inject
    private ICustomerService customerService;
    ISlidePr slidePr = new SlidePrDAO();
    IBookDAO iBookDAO = new BookDAO();

    private int index = 0;

    IAuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        // neu url :/login?action=login thi toi trang login
        if (action != null && action.equals("login")) {

            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            // neu url :login?action=login thi toi trang logout
        } else if (action != null && action.equals("logout")) {
            SessionUtil.getInstance().removeValue(req, "USERMODEL");
            resp.sendRedirect(req.getContextPath() + "/home");
        }
        else {
            req.setAttribute("listSlide", slidePr.findAll());
            req.setAttribute("listBookPayTop", iBookDAO.listBookPayTop());
            req.setAttribute("listBookMoiPhatHanh", iBookDAO.listBookNewReissue());
            req.setAttribute("listBookSachPhatHanh", iBookDAO.listBookReissue());
            req.setAttribute("listAuthor", authorService.find10Author());
            req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action != null && action.equals("login")) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            if (email != null && password != null && !password.equals("")) {

                CustomerModel customer = customerService.findByUsernameAndPasswordAndStatus(email, password, 1);
                if (customer != null) {
                    SessionUtil.getInstance().putValue(req, "USERMODEL", customer);
                    if (customer.getRole().equalsIgnoreCase("user")) {

                        resp.sendRedirect(req.getContextPath() + "/home");
//                        req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);

                    } else if (customer.getRole().equalsIgnoreCase("admin")) {

                        resp.sendRedirect(req.getContextPath() + "/admin-root-management-user");

                    } else if (customer.getRole().equalsIgnoreCase("mod")) {

                        resp.sendRedirect(req.getContextPath() + "/admin-home");

                    }
                } else {

                    CustomerModel account = customerService.findByUsername(email);

                        if ((account != null) && BLockUserDao.Attempts(email).equals("Updated")) {
                            req.setAttribute("message", MessageProperties.getUsername_password_invalid());
                            req.setAttribute("alert", "danger");
                            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
                        } else {
                            if ((account != null) && BLockUserDao.Attempts(email).equals("block")) {
                                req.setAttribute("message", "Your account has been locked please contact your administrator to unlock it");
                                req.setAttribute("alert", "danger");
                                req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
                            }

                            else {
                                req.setAttribute("message", MessageProperties.getUsername_password_invalid());
                                req.setAttribute("alert", "danger");
                                req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
                            }
                        }
                    }
//                    resp.sendRedirect(req.getContextPath()+"/login?action=login&message=username_password_invalid&alert=danger")
                }
            }
        }

    }
