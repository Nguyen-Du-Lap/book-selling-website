<%@ page import="vn.edu.hcmuaf.fit.model.CatalogModel" %>
<%@ page import="vn.edu.hcmuaf.fit.dao.ICatalogDAO" %>
<%@ page import="vn.edu.hcmuaf.fit.dao.impl.CatalogDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.hcmuaf.fit.dao.IPublisherCompany" %>
<%@ page import="vn.edu.hcmuaf.fit.dao.impl.PublisherCompanyDAO" %>
<%@ page import="vn.edu.hcmuaf.fit.model.PublisherCompanyModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- -----------phần header----------------  -->

<header>
    <div id="header">
        <div class="top-header">
            <div class="container top-header-content">
                <a class="logo" href="/home">DORAEMON</a>
                <form action="/products/search" method="post">
                    <div class="top-header_search">
                        <input type="text" name="key" placeholder="Tìm kiếm">
                        <button style="border: none"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </form>
                <div class="top-header-left">
                    <div class="top-header_cart">Giỏ hàng
                        <c:if test="${sessionScope.cart.map.size() != 0}">
                            <span class="top-header_cart-quantity">(${sessionScope.cart.map.size()})</span>
                        </c:if>

                        <i class="fa-solid fa-caret-down"></i>
                        <div class="top-header_cart--item">
                            <h4 class="cart--item_title">Giỏ hàng</h4>
                            <hr>
                            <a href="/cart" class="cart--item_link">
                                <span>Xem giỏ hàng <i class="fa-solid fa-caret-right"></i></span>
                            </a>
                        </div>
                    </div>

                    <c:if test="${empty USERMODEL}">
                        <div class="top-header_account">Tài khoản của bạn
                            <i class="fa-solid fa-caret-down"></i>
                            <div class="top-header_account--item">
                                <a href="" class="account--item_top">
                                    <i class="fa-brands fa-facebook-f"></i>
                                    <span style="font-size: 13px;">Tài khoản Facebook</span>
                                </a>
                                <a href="<c:url value="/login?action=login"/> " class="account--item_center"><span>Đăng nhập</span></a>
                                <div class="account--item_bottom">
                                    <span>Khách hàng mới?</span>
                                    <a class="register" href="/signup">Tạo tài khoản</a>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty USERMODEL}">
                        <a href="/account" style="display: flex">
                            <i style="padding: 4px; border-radius: 50%; color: #fff;font-size: 13px" class="fa-solid fa-user"></i>
                            <p style="color: #FFFFFF; font-size: 13px">${USERMODEL.firstName}</p>
                        </a>
                    </c:if>
                </div>
                <div class="top-header-left_media">
                    <a href="/cart">
                        <div class="container-icon_cart">
                            <i class="fa-solid fa-cart-shopping"></i>
                            <div class="sticker">0</div>
                        </div>
                    </a>
                    <i onclick="openSearch()"
                       class="top-header-left_media--search fa-solid fa-magnifying-glass"></i>
                    <i onclick="openNav()" class="top-header-left_media--menu fa-solid fa-bars"></i>
                </div>
            </div>
        </div>
        <div id="container_bg-search" class="container_bg-search">
            <div class="container">
                <div class="top-header_search-media">
                    <input type="text" placeholder="Tìm kiếm">
                    <span>Tìm kiếm</span>
                </div>
            </div>
        </div>
        <div class="center-header">
            <div class="center-header_div container">
                <div class="menu_products f_left">
                    <i class="fa-solid fa-bars"></i>
                    Danh mục sản phẩm
                    <nav class="menu_item">
                        <ul class="type_products">
                            <li class="type_products-item type_hots">
                                    <span class="container_type-arrow">
                                        <div>Nổi bật</div>
                                        <i class="fa-solid fa-chevron-right"></i>
                                    </span>
                                <ul class="type_hot-child">
                                    <li><a href="/products?hot=1">
                                        <p>Sách bán chạy</p>
                                    </a></li>
                                    <li><a href="/products?hot=2">
                                        <p>Sách mới</p>
                                    </a></li>
                                    <li><a href="/products?hot=3">
                                        <p>Sắp phát hành</p>
                                    </a></li>
                                    <li><a href="/products?hot=4">
                                        <p>Sách giảm giá</p>
                                    </a></li>
                                </ul>
                            </li>
                            <%
                                ICatalogDAO catalogDAO = new CatalogDAO();
                                List<CatalogModel> listCatalog = catalogDAO.findAll();
                            %>
                                <c:forEach var="catalog" items="<%=listCatalog%>">
                                    <li class="type_products-item"><a href="/products/catalogs?id=<c:out value ="${catalog.idCatalog}"/>">
                                        <span><c:out value ="${catalog.name}"/></span></a>
                                    </li>
                                </c:forEach>

                            <li class="type_products-item type_companys">
                                <a>
                                        <span class="container_type-arrow">
                                            <div>Công Ty Phát Hành</div><i class="fa-solid fa-chevron-right"></i>
                                        </span>
                                </a>
                                <ul class="type_companys-child" style="font-size: 10px">
                                    <%
                                        IPublisherCompany iPublisherCompany = new PublisherCompanyDAO();
                                        List<PublisherCompanyModel> listPublisherCompany = iPublisherCompany.findAll();
                                    %>
                                    <c:forEach var="publisherCompany" items="<%=listPublisherCompany%>">
                                        <li><a href="/products/publisherCompany?id=<c:out value ="${publisherCompany.idPc}"/>">
                                            <p><c:out value ="${publisherCompany.name}"/></p>
                                        </a></li>
                                    </c:forEach>
                                    <li><a class="type_company-all" href="/products?publisherCompany?id=0">
                                        <p style="font-width: 600;">Tất cả công ty phát hành</p>
                                    </a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
                <div class="f_right" style="display: flex">
                    <a style="background-color: #ed4d2b; padding: 5px; color: #FFFFFF;border-radius: 5px"  href="/voucher">Săn mã giảm giá</a>
                    <a href="" class="hotline d-flex">
                        <i class="fa-solid fa-phone"></i>
                        <h4>Hotline: </h4>
                        <span>0867 415 853</span>
                    </a>
                </div>


            </div>
        </div>

    </div>
    <!-- open sidenav -->
    <div id="mySidenav" class="sidenav" style="overflow: hidden;">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <button class="dropdown-btn">Tài khoản
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-container">
            <a href="/login?action=login">Đăng ký</a>
            <a href="/login?action=login">Đăng nhập</a>
        </div>
        <button class="dropdown-btn">Nổi bật
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-container">
            <a href="#">Sách bán chạy</a>
            <a href="#">Sách mới</a>
            <a href="#">Sắp phát hành</a>
            <a href="#">Sách giảm giá</a>
        </div>
        <a href="#">Sách Văn Học Nước Ngoài</a>
        <a href="#">Sách Văn Học Trong Nước</a>
        <a href="#">Sách Tâm Lý Kĩ Năng Sống</a>
        <a href="#">Sách Thiếu Nhi</a>
        <a href="#">Sách Kinh Tế</a>
        <a href="#">Lịch Sử - Địa Lý - Tôn Giáo</a>
        <a href="#">Khoa Học Kỹ Thuật</a>
        <a href="#">Truyện Tranh</a>
        <a href="#">Tập Chí - Báo</a>
    </div>
</header>
<!--------- end header---------- -->