<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- -----------phần header----------------  -->
<header>
    <div id="header">
        <div class="top-header">
            <div class="container top-header-content">
                <a class="logo" href="/home">DORAEMON</a>
                <div class="top-header_search">
                    <input type="text" placeholder="Tìm kiếm">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </div>
                <div class="top-header-left">
                    <div class="top-header_cart">Giỏ hàng
                        <span class="top-header_cart-quantity">(0)</span>
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
            <div class="container d-flex justify-content-between" style="align-items: center;">
                <div class="menu_products">
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
                                    <li><a href="">
                                        <p>Sách bán chạy</p>
                                    </a></li>
                                    <li><a href="">
                                        <p>Sách mới</p>
                                    </a></li>
                                    <li><a href="">
                                        <p>Sắp phát hành</p>
                                    </a></li>
                                    <li><a href="">
                                        <p>Sách giảm giá</p>
                                    </a></li>
                                </ul>
                            </li>
                            <li class="type_products-item"><a href="vanhocnuocngoai.html"><span>Sách Văn Học Nước Ngoài</span></a></li>
                            <li class="type_products-item"><a href="vanhocnuocngoai.html"><span>Sách Văn Học Trong Nước</span></a></li>
                            <li class="type_products-item"><a href="vanhocnuocngoai.html"><span>Sách Tâm Lý Kĩ Năng Sống</span></a></li>
                            <li class="type_products-item"><a href="vanhocnuocngoai.html"><span>Sách Thiếu Nhi</span></a></li>
                            <li class="type_products-item"><a href="vanhocnuocngoai.html"><span>Sách Kinh Tế</span></a></li>
                            <li class="type_products-item"><a href="vanhocnuocngoai.html"><span>Lịch Sử - Địa Lý - Tôn Giáo</span></a></li>
                            <li class="type_products-item"><a href="vanhocnuocngoai.html"><span>Khoa Học Kỹ Thuật</span></a></li>
                            <li class="type_products-item"><a href="vanhocnuocngoai.html"><span>Truyện Tranh</span></a></li>
                            <li class="type_products-item"><a href="vanhocnuocngoai.html"><span>Tập Chí - Báo</span></a></li>
                            <li class="type_products-item type_companys">
                                <a href="">
                                        <span class="container_type-arrow">
                                            <div>Công Ty Phát Hành</div><i class="fa-solid fa-chevron-right"></i>
                                        </span>
                                </a>
                                <ul class="type_companys-child">
                                    <li><a href="">
                                        <p>Công ty cổ phần zgroup</p>
                                    </a></li>
                                    <li><a href="">
                                        <p>Skybooks</p>
                                    </a></li>
                                    <li><a href="">
                                        <p>Chilbooks</p>
                                    </a></li>
                                    <li><a href="">
                                        <p>Thái Hà</p>
                                    </a></li>
                                    <li><a class="type_company-all" href="">
                                        <p>Tất cả công ty phát hành</p>
                                    </a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
                <a href="" class="hotline d-flex">
                    <i class="fa-solid fa-phone"></i>
                    <h4>Hotline: </h4>
                    <span>0867 415 853</span>
                </a>

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