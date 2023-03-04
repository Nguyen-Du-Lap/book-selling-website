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
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link
            href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css"
          integrity="sha512-17EgCFERpgZKcm0j0fEq1YCJuyAWdz9KUtv1EjVuaOz8pDnh/0nZxmU6BBXwaaxqoi9PQXnRWqlcDB027hgv9A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"
          integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="<c:url value='/templates/styles/Header.css'/> "/>
    <link rel="stylesheet" href="<c:url value='/templates/styles/Footer.css'/> "/>
    <link rel="stylesheet" href="<c:url value='/templates/styles/Home.css'/> "/>
    <title>Home</title>
</head>

<body>
<!-- -----------phần header----------------  -->

<%@include file="/common/web/header.jsp" %>
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

            <c:forEach var="catalog" items="<%=listCatalog%>">
                <li class="type_products-item"><a href="/products/catalogs?id=<c:out value ="${catalog.idCatalog}"/>">
                    <span><c:out value="${catalog.name}"/></span>
                </a></li>
            </c:forEach>
            <li class="type_products-item type_companys">
                <a href="">
                        <span class="container_type-arrow">
                            <div>Công Ty Phát Hành</div><i class="fa-solid fa-chevron-right"></i>
                        </span>
                </a>
                <ul class="type_companys-child" style="font-size: 10px">
                    <c:forEach var="publisherCompany" items="<%=listPublisherCompany%>">
                        <li><a href="/products/publisherCompany?id=<c:out value ="${publisherCompany.idPc}"/>">
                            <p><c:out value="${publisherCompany.name}"/></p>
                        </a></li>
                    </c:forEach>
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

                <c:forEach var="slide" items="${listSlide}">
                    <c:if test="${slide.idPr == 1}">
                        <div class="carousel-item active">
                            <a href="${slide.link}">
                                <img src="${slide.img}" class="d-block w-100" alt="${slide.namePr}">
                            </a>
                        </div>
                    </c:if>
                    <c:if test="${slide.idPr != 1}">
                        <div class="carousel-item">
                            <a href="${slide.link}">
                                <img src="${slide.img}" class="d-block w-100" alt="${slide.namePr}">
                            </a>
                        </div>
                    </c:if>
                </c:forEach>

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
            <a class="category_left" href="/productList?type=allBookTop">
                Sách bán chạy
                <span class="category_arrow"></span>
            </a>
            <a class="category_right" href="/productList?type=allBookTop">Xem tất cả</a>
        </div>
        <div class="category_carousel" style="height: 402px">
            <div class="container">
                <div class="row slick">
                    <c:forEach var="bookPayTop" items="${listBookPayTop}">
                        <div class="col-md-12">
                            <div class="card h-60">
                                <a href="/products/product-detail?id=${bookPayTop.idBook}">
                                    <c:if test="${bookPayTop.discount != 0}">
                                        <span class="card_sale active_sale">-${bookPayTop.discount}%</span>
                                    </c:if>
                                    <img src="${bookPayTop.image}"
                                         class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title title_book">${bookPayTop.name}</h5>
                                        <small class="tacgia text-muted" style="font-weight: bold">${bookPayTop.nameAuthor}</small>
                                        <p class="card-text">
                                        <div class="container_price">
                                            <p class="card-text_price">${bookPayTop.price}đ</p>
                                            <c:if test="${bookPayTop.discount != 0}">
                                                <p style="text-decoration: line-through;" class="card-text_price--sale">${bookPayTop.priceDiscount}đ
                                                </p>
                                            </c:if>

                                        </div>
                                        </p>
                                        <div class="danhgia">
                                            <ul class="d-flex" style="list-style: none; margin: 0px;">
                                                <c:if test="${bookPayTop.quantityStart == 5}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                </c:if>
                                                <c:if test="${bookPayTop.quantityStart == 4}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>

                                                <c:if test="${bookPayTop.quantityStart == 3}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>

                                                <c:if test="${bookPayTop.quantityStart == 2}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>

                                                <c:if test="${bookPayTop.quantityStart == 1}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>
                                                <c:if test="${bookPayTop.quantityStart == 0}">
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>
                                            </ul>
                                            <span class="text-muted">${bookPayTop.quantityComment} nhận xét</span>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
    </div>
</div>
<div id="section3" style="margin-top: 24px;">
    <div class="container">
        <div class="category">
            <a class="category_left" href="/productList?type=allBookNew">
                Sách mới phát hành
                <span class="category_arrow"></span>
            </a>
            <a class="category_right" href="/productList?type=allBookNew">Xem tất cả</a>
        </div>
        <div class="category_carousel" style="height: 402px">
            <div class="container">
                <div class="row slick">
                    <c:forEach var="bookNew" items="${listBookMoiPhatHanh}">
                        <div class="col-md-12">
                            <div class="card h-60">
                                <a href="/products/product-detail?id=${bookNew.idBook}">
                                    <c:if test="${bookNew.discount != 0}">
                                        <span class="card_sale active_sale">-${bookNew.discount}%</span>
                                    </c:if>
                                    <img src="${bookNew.image}"
                                         class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title title_book">${bookNew.name}</h5>
                                        <small class="tacgia text-muted" style="font-weight: bold">${bookNew.nameAuthor}</small>
                                        <p class="card-text">
                                        <div class="container_price">
                                            <p class="card-text_price">${bookNew.price}đ</p>
                                            <c:if test="${bookNew.discount != 0}">
                                                <p style="text-decoration: line-through;" class="card-text_price--sale">${bookNew.priceDiscount}đ
                                                </p>
                                            </c:if>
                                        </div>
                                        </p>
                                        <div class="danhgia">
                                            <ul class="d-flex" style="list-style: none; margin: 0px;">
                                                <c:if test="${bookNew.quantityStart == 5}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                </c:if>
                                                <c:if test="${bookNew.quantityStart == 4}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>

                                                <c:if test="${bookNew.quantityStart == 3}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>

                                                <c:if test="${bookNew.quantityStart == 2}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>

                                                <c:if test="${bookNew.quantityStart == 1}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>
                                                <c:if test="${bookNew.quantityStart == 0}">
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>
                                            </ul>
                                            <span class="text-muted">${bookNew.quantityComment} nhận xét</span>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="section4" style="margin-top: 24px;">
    <div class="container">
        <div class="category">
            <a class="category_left" href="/productList?type=allUpcoming">
                Sách sắp phát hành
                <span class="category_arrow"></span>
            </a>
            <a class="category_right" href="/productList?type=allUpcoming">Xem tất cả</a>
        </div>
        <div class="category_carousel" style="height: 402px">
            <div class="container">
                <div class="row slick">
                    <c:forEach var="bookSap" items="${listBookSachPhatHanh}">
                        <div class="col-md-12">
                            <div class="card h-60">
                                <a href="/products/product-detail?id=${bookSap.idBook}">
                                    <c:if test="${bookSap.discount != 0}">
                                        <span class="card_sale active_sale">-${bookSap.discount}%</span>
                                    </c:if>

                                    <img src="${bookSap.image}"
                                         class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title title_book">${bookSap.name}</h5>
                                        <small class="tacgia text-muted" style="font-weight: bold">${bookSap.nameAuthor}</small>
                                        <p class="card-text">
                                        <div class="container_price">
                                            <p class="card-text_price">${bookSap.price}đ</p>
                                            <c:if test="${bookSap.discount != 0}">
                                                <p style="text-decoration: line-through;" class="card-text_price--sale">${bookSap.priceDiscount}đ
                                                </p>
                                            </c:if>
                                        </div>
                                        </p>
                                        <div class="danhgia">
                                            <ul class="d-flex" style="list-style: none; margin: 0px;">
                                                <c:if test="${bookSap.quantityStart == 5}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                </c:if>
                                                <c:if test="${bookSap.quantityStart == 4}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>

                                                <c:if test="${bookSap.quantityStart == 3}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>

                                                <c:if test="${bookSap.quantityStart == 2}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>

                                                <c:if test="${bookSap.quantityStart == 1}">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>
                                                <c:if test="${bookSap.quantityStart == 0}">
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                    <li class=""><i class="fa fa-star"></i></li>
                                                </c:if>
                                            </ul>
                                            <span class="text-muted">${bookSap.quantityComment} nhận xét</span>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="section5" style="margin-top: 24px;">
    <div class="container">
        <div class="category">
            <a class="category_left" href="/authors">
                Tác giả
                <span class="category_arrow"></span>
            </a>
            <a class="category_right" href="">Xem tất cả</a>
        </div>
        <div class="authors_carousel" style="height: 330px;">
            <div class="container">
                <div class="row slick">
                    <c:forEach var="author" items="${listAuthor}" >
                        <div class="col-md-12">
                            <div class="card h-60 card_author">
                                <a href="/author?id=${author.idAuthor}">
                                    <img src="${author.img}"
                                         class="card-img-top img_author" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title title_author">${author.name}</h5>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- footer -->
<%@include file="/common/web/footer.jsp" %>


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
