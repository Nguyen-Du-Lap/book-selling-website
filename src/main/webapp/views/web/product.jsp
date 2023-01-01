<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh mục sản phẩm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link
            href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet">

    <link rel="stylesheet" href="<c:url value='/templates/styles/Product.css'/> "/>
    <link rel="stylesheet" href="<c:url value='/templates/styles/HeaderProduct.css'/> "/>
    <link rel="stylesheet" href="<c:url value='/templates/styles/Footer.css'/> "/>
</head>
<body>
<!----------------------------------------HEADER--------------------------------------->
<%@include file="/common/web/header.jsp"%>
<!--------- end header---------- -->

<!-- ----------breadcrumb ------------ -->
<nav id="breadcrumbbar">
    <div class="container">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a class="chang_font" href="/home">Trang chủ</a></li>
            <li class="breadcrumb-item active"><a href="vanhocnuocngoai.html">Văn học nước ngoài</a></li>
        </ul>
    </div>
</nav>
<!--  End Breadcrumb  -->


<section id="content" style="width: 100%">
    <div class="container">
        <section id="products_left">
            <div class="container1">
                <div id="accordion">
                    <div class="cap">Tác giả</div>
                    <div class="ct">
                        <label><input name="Apple" type="checkbox" class="tacgia" value="Apple">Victor Hugo</label>
                        <label><input name="OPPO" type="checkbox" class="tacgia" value="OPPO">J.K. Rowling</label>
                        <label><input name="Samsung" type="checkbox" class="tacgia" value="Samsung">Đinh Mặc</label>
                        <label><input name="Xiaomi" type="checkbox" class="tacgia" value="Xiaomi">Cố Tây Tước</label>
                        <label><input name="Vivo" type="checkbox" class="tacgia" value="Vivo">Emily Bronte</label>
                    </div>
                    <div class="cap">Giá bán</div>
                    <div class="ct">
                        <label><input type="checkbox" class="giaban" value="1">Dưới 100.000đ</label>
                        <label><input type="checkbox" class="giaban" value="2">Từ 100.000đ đến 200.000đ</label>
                        <label><input type="checkbox" class="giaban" value="3">Từ 200.000đ đến 300.000đ</label>
                        <label><input type="checkbox" class="giaban" value="4">Trên 300.000đ</label>
                    </div>
                    <div class="cap">Nhà xuất bản</div>
                    <div class="ct">
                        <label><input type="checkbox" class="nxb" value="1">NXB Phụ nữ Việt Nam</label>
                        <label><input type="checkbox" class="nxb" value="2">NXB Thông Tấn</label>
                        <label><input type="checkbox" class="nxb" value="3">Nhà xuất bản Hà Nôi</label>
                        <label><input type="checkbox" class="nxb" value="4">NXB Văn Học</label>
                    </div>
                    <div class="cap">Phát Hành</div>
                    <div class="ct">
                        <label><input type="checkbox" class="phathanh" value="1">Nhã Nam</label>
                        <label><input type="checkbox" class="phathanh" value="2">Skybooks</label>
                        <label><input type="checkbox" class="phathanh" value="3">AZ VietNam</label>
                        <label><input type="checkbox" class="phathanh" value="4">Việt Thư</label>
                    </div>
                </div>
            </div>
        </section>
        <section id="products_right" style="position: relative">
            <div class="container2">
                <div class="noidung bg-white">
                    <!--Header cua khoi san phan-->
                    <div class="header_khoi_sp">
                        <div class="products_right_title">
                            <h3>VĂN HỌC NƯỚC NGOÀI</h3>
                        </div>
                        <div class="products_right_order_left">
                            <i class="fa fa-th-large" aria-hidden="true"></i>
                            <i class="fa fa-th-list" aria-hidden="true"></i>
                        </div>
                        <div class="prodict_right_order_right">
                            <label for="sortList" class="label-select">Xem theo</label>
                            <select name="sortList" id="sortList">
                                <option value="macdinh">Mặc định</option>
                                <option value="cao-thap">Giá từ cao đến thấp</option>
                                <option value="thap-cao">Giá từ thấp đến cao</option>
                                <option value="moinhat">Mới nhất</option>
                                <option value="cunhat">Cũ nhất</option>
                            </select>
                        </div>
                    </div>
                    <!-- Cac san pham-->
                    <div class="items">
                        <div id="data-content" class="row">
                            <%--                                <div class="col-lg-3 col-md-4 col-xs-6 item victo-hugo">--%>
                            <%--                                    <div class="card">--%>
                            <%--                                        <a href="Product_detail.html" class="motsanpham"--%>
                            <%--                                           data-toggle="tooltip" data-placement="bottom" title="Những người khốn khổ">--%>
                            <%--                                            <img class="card-img-top anh"--%>
                            <%--                                                 src="/templates/images/vanhocnuocngoai/nhungnguoikhonkho1.jpeg"--%>
                            <%--                                                 alt="Những người khốn khổ">--%>
                            <%--                                            <div class="card-body noidungsp mt-3">--%>
                            <%--                                                <h6 class="card-title ten">Những người khốn khổ</h6>--%>
                            <%--                                                <small class="tacgia text-muted" style="font-weight: bold">Victo--%>
                            <%--                                                    Hugo</small>--%>
                            <%--                                                <div class="card-price d-flex align-items-baseline">--%>
                            <%--                                                    <div class="giamoi">273.000đ <br></div>--%>
                            <%--                                                    <div class="giacu text-muted"> 390.000đ</div>--%>
                            <%--                                                </div>--%>
                            <%--                                            </div>--%>
                            <%--                                            <div class="danhgia">--%>
                            <%--                                                <ul class="d-flex" style="list-style: none">--%>
                            <%--                                                    <li class="active"><i class="fa fa-star"></i></li>--%>
                            <%--                                                    <li class="active"><i class="fa fa-star"></i></li>--%>
                            <%--                                                    <li class="active"><i class="fa fa-star"></i></li>--%>
                            <%--                                                    <li class="active"><i class="fa fa-star"></i></li>--%>
                            <%--                                                    <li class="active"><i class="fa fa-star"></i></li>--%>
                            <%--                                                    <li><span class="text-muted">  20 nhận xét</span></li>--%>
                            <%--                                                </ul>--%>
                            <%--                                            </div>--%>
                            <%--                                        </a>--%>
                            <%--                                    </div>--%>
                            <%--                                </div>--%>


                        </div>
                    </div>

                </div>
            </div>
            <div style="position: absolute; bottom: -100px; width: 100%;">
                <nav aria-label="Page navigation">
                    <ul style="margin-left: 20%; text-align: center"  class="pagination" id="pagination"></ul>
                </nav>
            </div>
        </section>
    <%--navigation--%>
    </div>
</section>
<!--</div>-->

<%@include file="/common/web/footer.jsp"%>

<!--    footer-->

<!-- ----js phần header -->
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
<!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>-->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="/templates/twbsPagination/jquery.twbsPagination.js"></script>
<script src="/templates/scripts/header.js"></script>
<script src="/templates/scripts/product_type.js"></script>

<script>
    //số lượng thẻ card
    let limit = 3;
    let currentPage = 1;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: 5,
            visiblePages: 3,
            startPage: 1,
            onPageClick: function (event, page) {
                currentPage = page;
                $.ajax({
                    url: "/paging-load",
                    type: 'get',
                    dataType: 'html',
                    data: {
                        page: page,
                        limit: limit
                    },
                    success: function (data) {
                        var dataContent = document.getElementById("data-content");
                        dataContent.innerHTML = data;
                    }
                });
            }
        });
    });
    // xu ly sap xep
    const sort = document.getElementById("sortList");
    console.log(sort)
    sort.addEventListener("change", function () {
        console.log('Changed option value ' + this.value);
        $(document).ready(function () {
            // $('#data-content').load('/sort-load')
            console.log("hi")
            $('#data-content').load('/sort-load', {"valueSort": this.value}, {"limit": 3}, {"page": 2})
        })
    });
</script>
</body>
</html>
