<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ include file="styles"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link
            href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css"
          integrity="sha512-17EgCFERpgZKcm0j0fEq1YCJuyAWdz9KUtv1EjVuaOz8pDnh/0nZxmU6BBXwaaxqoi9PQXnRWqlcDB027hgv9A=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"
          integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="<c:url value='/templates/styles/Header.css'/> " />
    <link rel="stylesheet" href="<c:url value='/templates/styles/Footer.css'/> " />
    <link rel="stylesheet" href="<c:url value='/templates/styles/Home.css'/> " />
    <title>Home</title>
</head>

<body>
<!-- -----------phần header----------------  -->

<%@include file="/common/web/header.jsp"%>
<!--------- end header---------- -->
<div id="section1">
    <div class="container d-flex">
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
        <div id="carouselExampleIndicators" class="carousel slide section1_slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="/templates/images/slide1.jpg" class="d-block w-100" alt="img slide1">
                </div>
                <div class="carousel-item">
                    <img src="/templates/images/slide2.jpg" class="d-block w-100" alt="img slide2">
                </div>
                <div class="carousel-item">
                    <img src="/templates/images/slide3.jpg" class="d-block w-100" alt="img slide3">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-target="#carouselExampleIndicators"
                    data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-target="#carouselExampleIndicators"
                    data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </button>
        </div>
    </div>
</div>

<div id="section2" style="margin-top: 24px;">
    <div class="container">
        <div class="category">
            <a class="category_left" href="/product?type=allBookTop">
                Sách bán chạy
                <span class="category_arrow"></span>
            </a>
            <a class="category_right" href="">Xem tất cả</a>
        </div>
        <div class="category_carousel" style="height: 402px">
            <div class="container">
                <div class="row slick">
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-20%</span>
                                <img src="/templates/images/vanhocnuocngoai/nhungnguoikhonkho1.jpeg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">Những Người Khốn Khổ - Trọn bộ 3 cuốn</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">Victor Hugo</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">370.000đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">390.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">20 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-20%</span>
                                <img src="/templates/images/sachbanchay/toi-ve-phuong-phap-ve.jpeg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">Tôi vẽ - Phương pháp tự học vẽ truyện tranh</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">TacGia</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">80.000đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">100.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">20 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-10%</span>
                                <img src="/templates/images/sachbanchay/ctbt.jpeg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">Can Trường Bước Tiếp (Tái Bản 2021)</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">Tuệ Nghi</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">80.100đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">89.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">60 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-15%</span>
                                <img src="/templates/images/sachbanchay/storytelling.jpeg" class="card-img-top" alt="Storytelling with data - Kể chuyện thông qua dữ liệu">
                                <div class="card-body">
                                    <h5 class="card-title title_book">Storytelling with data - Kể chuyện thông qua dữ liệu</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">TacGia</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">271.150đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">319.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">17 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-20%</span>
                                <img src="/templates/images/sachbanchay/vnsuluoc.jpeg" class="card-img-top" alt="Việt Nam sử lược (ấn bản kỉ niệm 100 năm xuất bản lần đầu)">
                                <div class="card-body">
                                    <h5 class="card-title title_book">Việt Nam sử lược (ấn bản kỉ niệm 100 năm xuất bản lần đầu)</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">Cole Nussbaumer Knaflic</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">360.000đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">450.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">20 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-10%</span>
                                <img src="/templates/images/sachbanchay/digitalmarketing.jpeg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">Digital Marketing - Từ chiến lược đến thực thi</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">Vinalink</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">198.000đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">220.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">20 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-20%</span>
                                <img src="/templates/images/sachbanchay/90-20-30-90-bai-hoc-vo-long-ve-y-tuong-va-cau-chu_b927bfcdefca4b94b2bd16901450f490_master.webp" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">90-20-30 90 Bài Học Vỡ Lòng Về Ý Tưởng Và Câu Chữ (Bản Đen Trắng) - Tái Bản</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">Huỳnh Vĩnh Sơn</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">175.500đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">195.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">20 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="section3" style="margin-top: 24px;">
    <div class="container">
        <div class="category">
            <a class="category_left" href="/product?type=allBookNew">
                Sách mới phát hành
                <span class="category_arrow"></span>
            </a>
            <a class="category_right" href="">Xem tất cả</a>
        </div>
        <div class="category_carousel" style="height: 402px">
            <div class="container">
                <div class="row slick">
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-10%</span>
                                <img src="/templates/images/sachmoi/1nambang10nam.webp" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">1 Năm Bằng 10 Năm - Bí Quyết Nâng Cấp Của Cải Và Sức ảNh Hưởng Của Mỗi Người</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">Miêu Thúc</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">112.500đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">125.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">20 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-15%</span>
                                <img src="/templates/images/sachmoi/100-cach-song-hanh-phuc-cam-nang-danh-cho-nguoi-ban-ron-tai-ban-2022_d510175afa7741e19392e911d359cf93_master.webp" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">100 Cách Sống Hạnh Phúc - Cẩm Nang Dành Cho Người Bận Rộn(Tái Bản 2022)</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">DR. Timothy J. Sharp</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">108.800đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">128.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">20 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-15%</span>
                                <img src="/templates/images/sachmoi/21phamchat.webp" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">21 Phẩm Chất Vàng Của Nhà Lãnh Đạo (Tái Bản)</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">John C Maxwell</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">101.500đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">119.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">20 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-15%</span>
                                <img src="/templates/images/sachmoi/25thuatdacnhantam.webp" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">25 Thuật Đắc Nhân Tâm (Tái Bản 2022)</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">John C Maxwell</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">101.500đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">119.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">20 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-20%</span>
                                <img src="/templates/images/sachmoi/30congthucmonnhat.webp" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">30 Công Thức Nấu Ăn Của Yanny Đặng - Món Ăn Nhật Đậm Vị Việt</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">Yanny Đặng</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">501.000đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">169.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">20 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-20%</span>
                                <img src="/templates/images/sachmoi/30congthucbuffetchay.webp" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">30 Công Thức Nấu Ăn Của Yanny Đặng - Bufet Chay, Ngon, Dễ Làm</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">Yanny Đặng</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">46.750đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">55.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                            <li class="active"><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">20 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="section4" style="margin-top: 24px;">
    <div class="container">
        <div class="category">
            <a class="category_left" href="/product?type=allUpcoming">
                Sách sắp phát hành
                <span class="category_arrow"></span>
            </a>
            <a class="category_right" href="">Xem tất cả</a>
        </div>
        <div class="category_carousel" style="height: 402px">
            <div class="container">
                <div class="row slick">
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-7%</span>
                                <img src="/templates/images/sapphathanh/motchotrongdoi.jpeg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">Một Chỗ Trong Đời</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">Annie Ernaux</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">64.170đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">69.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">0 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-7%</span>
                                <img src="/templates/images/sapphathanh/quantricamxuc.jpeg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">Quản Trị Cảm Xúc</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">Naz Beheshti</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">176.700đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">190.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">0 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-7%</span>
                                <img src="/templates/images/sapphathanh/giaiphongbonao.jpeg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">Giải Phóng Bộ Não Khỏi Tư Duy Độc Hại</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">	Steven Schuster</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">147.870đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">159.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">0 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-7%</span>
                                <img src="/templates/images/sapphathanh/tuquanlydenlanhdao.jpeg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">Từ Quản Lý Đến Lãnh Đạo - Sứ Mệnh Dẫn Đầu</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">Michael Hyatt</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">232.500đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">150.000đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">0 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60">
                            <a href="Product_detail.html">
                                <span class="card_sale active_sale">-70%</span>
                                <img src="/templates/images/sapphathanh/lichsuvn.jpeg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_book">Lịch Sử Việt Nam Bằng Tranh : Lý Thánh Tông Và Nước Đại Việt (Bản Màu)</h5>
                                    <small class="tacgia text-muted" style="font-weight: bold">Trần Bạch Đằng, Tôn Nữ Quỳnh Trân, Nguyễn Quang Cảnh, Nguyễn Thùy Linh</small>
                                    <p class="card-text">
                                    <div class="container_price">
                                        <p class="card-text_price">130.200đ</p>
                                        <p style="text-decoration: line-through;" class="card-text_price--sale">140.200đ
                                        </p>
                                    </div>
                                    </p>
                                    <div class="danhgia">
                                        <ul class="d-flex" style="list-style: none; margin: 0px;">
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                            <li class=""><i class="fa fa-star"></i></li>
                                        </ul>
                                        <span class="text-muted">0 nhận xét</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="section5" style="margin-top: 24px;">
    <div class="container">
        <div class="category">
            <a class="category_left" href="/product?type=allAuthor">
                Tác giả
                <span class="category_arrow"></span>
            </a>
            <a class="category_right" href="">Xem tất cả</a>
        </div>
        <div class="authors_carousel" style="height: 330px;">
            <div class="container">
                <div class="row slick">
                    <div class="col-md-12">
                        <div class="card h-60 card_author">
                            <a href="">
                                <img src="/templates/images/author/nguyennhatanh-compressed.jpg" class="card-img-top img_author" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_author">Nguyễn Nhật Ánh</h5>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60 card_author">
                            <a href="">
                                <img src="/templates/images/author/j-compressed.jpg" class="card-img-top img_author" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_author">J.K. Rowling</h5>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60 card_author">
                            <a href="">
                                <img src="/templates/images/author/Victor_Hugo_by_Étienne_Carjat_1876_-_full-compressed.jpg" class="card-img-top img_author" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_author">Victor Hugo</h5>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60 card_author">
                            <a href="">
                                <img src="/templates/images/author/dinhmac.jpg" class="card-img-top img_author" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_author">Đinh Mặc</h5>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60 card_author">
                            <a href="">
                                <img src="/templates/images/author/Ilya_Efimovich_Repin_(1844-1930)_-_Portrait_of_Leo_Tolstoy_(1887).jpg" class="card-img-top img_author" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_author">Leo Tolstoy</h5>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60 card_author">
                            <a href="">
                                <img src="/templates/images/author/tohoai-compressed.jpg" class="card-img-top img_author" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_author">Tô Hoài</h5>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card h-60 card_author">
                            <a href="">
                                <img src="/templates/images/author/nguyenngoctu-compressed.jpg" class="card-img-top img_author" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title title_author">Nguyễn Ngọc Tư</h5>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- footer -->
<%@include file="/common/web/footer.jsp"%>


<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
        integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
        integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"
        integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script type="text/javascript">
    $('.slick').slick({
        dots: false,
        infinite: true,
        speed: 300,
        slidesToShow: 5,
        slidesToScroll: 1,
        responsive: [
            {
                breakpoint: 1200,
                settings: {
                    slidesToShow: 4,
                    slidesToScroll: 1,
                    infinite: true,
                    dots: true
                }
            },
            {
                breakpoint: 992,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 1
                }
            },
            {
                breakpoint: 800,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 1
                }
            },
            {
                breakpoint: 720,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 1
                }
            }
            // You can unslick at a given breakpoint now by adding:
            // settings: "unslick"
            // instead of a settings object
        ]
    });

</script>
<script src="/templates/scripts/header.js"></script>
</body>

</html>
