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
    <style>
        .paginationA {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 16px;
            margin-top: 200px;
        }

        .pages {
            display: flex;
            flex-direction: row;
            gap: 20px;
        }

        .page {
            height: 40px;
            width: 40px;
            border-radius: 50%;
            cursor: pointer;

            display: flex;
            align-items: center;
            justify-content: center;
            gap: 10px;
        }

        .page:hover {
            background-color: #3992e5;;
            color: #fff;
        }

        .activePage {
            background-color: #3992e5;;
            color: #fff;
        }

        .btn {
            background-color: #fff;
            border: 1px solid #3992e5;;
            height: 40px;
            width: 40px;
            border-radius: 50%;
            cursor: pointer;

            display: flex;
            align-items: center;
            justify-content: center;
        }

        .btn:hover {
            background-color: #3992e5;;
        }

        .btn--icon {
            height: 24px;
            width: 24px;
            stroke: #3992e5;
        }

        .btn--icon:hover {
            stroke: #fff;
        }
        .disblay {
            display: none;
        }

    </style>
</head>
<body>
<!----------------------------------------HEADER--------------------------------------->
<%@include file="/common/web/header.jsp" %>
<!--------- end header---------- -->

<!-- ----------breadcrumb ------------ -->
<nav id="breadcrumbbar">
    <div class="container">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a class="chang_font" href="/home">Trang chủ</a></li>
            <c:if test="${not empty title}">
                <li class="breadcrumb-item active"><a>${title}</a></li>
            </c:if>
            <c:if test="${title == null}">
                <li class="breadcrumb-item active"><a>Sản phẩm</a></li>
            </c:if>

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
                        <label><input name="auth" onclick="check()" type="checkbox" class="tacgia" value="Victor Hugo">Victor Hugo</label>
                        <label><input name="auth" onclick="check()" type="checkbox" class="tacgia" value="J.K. Rowling">J.K. Rowling</label>
                        <label><input name="auth" onclick="check()" type="checkbox" class="tacgia" value="Đinh Mặc">Đinh Mặc</label>
                        <label><input name="auth" onclick="check()" type="checkbox" class="tacgia" value="Cố Tây Tước">Cố Tây Tước</label>
                        <label><input name="auth" onclick="check()" type="checkbox" class="tacgia" value="Emily Bronte">Emily Bronte</label>
                    </div>
                    <div class="cap">Giá bán</div>
                    <div class="ct">
                        <label><input name="price" onclick="check()" type="radio" class="giaban" value="1">Dưới 100.000đ</label>
                        <label><input name="price" onclick="check()" type="radio" class="giaban" value="2">Từ 100.000đ đến 200.000đ</label>
                        <label><input name="price" onclick="check()" type="radio" class="giaban" value="3">Từ 200.000đ đến 300.000đ</label>
                        <label><input name="price" onclick="check()" type="radio" class="giaban" value="4">Trên 300.000đ</label>
                        <label><input name="price" onclick="check()" type="radio" class="giaban" value="5" checked>Bỏ lọc</label>
                    </div>
                    <div class="cap">Nhà xuất bản</div>
                    <div class="ct">
                        <label><input name="NXB" type="checkbox" class="nxb" value="1">NXB Phụ nữ Việt Nam</label>
                        <label><input name="NXB" type="checkbox" class="nxb" value="2">NXB Thông Tấn</label>
                        <label><input name="NXB" type="checkbox" class="nxb" value="3">Nhà xuất bản Hà Nôi</label>
                        <label><input name="NXB" type="checkbox" class="nxb" value="4">NXB Văn Học</label>
                    </div>

                    <div class="cap">Phát Hành</div>
                    <div class="ct">
                        <label><input name="phatHanh" type="checkbox" class="phathanh" value="1">Nhã Nam</label>
                        <label><input name="phatHanh" type="checkbox" class="phathanh" value="2">Skybooks</label>
                        <label><input name="phatHanh" type="checkbox" class="phathanh" value="3">AZ VietNam</label>
                        <label><input name="phatHanh" type="checkbox" class="phathanh" value="4">Việt Thư</label>
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
                            <c:if test="${not empty title}">
                                <h3>${title}</h3>
                            </c:if>
                            <c:if test="${title == null}">
                                <h3>SẢN PHẨM</h3>
                            </c:if>

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
                            <c:if test="${not empty list12Book }">
                                <c:forEach  var="book" items="${list12Book}">

                                    <div class="col-lg-3 col-md-4 col-xs-6 item victo-hugo  ${book.nameAuthor} ${book.price} c${book.getIdCP()} ${book.getIdP()}">
                                        <div class="card" >
                                            <a href="/products/product-detail?id=${book.idBook}" class="motsanpham"
                                               data-toggle="tooltip" data-placement="bottom"
                                               title="${book.name}">
                                                <img class="card-img-top anh"
                                                     src="${book.image}"
                                                     alt="${book.name}">
                                                <div class="card-body noidungsp mt-3">
                                                    <h6 class="card-title ten">${book.name} </h6>
                                                    <small class="tacgia text-muted"
                                                           style="font-weight: bold">${book.nameAuthor}</small>
                                                    <div class="card-price d-flex align-items-baseline">
                                                        <div class="giamoi">${book.price}đ <br></div>
                                                        <div class="giacu text-muted">${book.priceDiscount}đ</div>
                                                    </div>
                                                </div>
                                                <div class="danhgia">
                                                    <ul class="d-flex" style="list-style: none">
                                                        <c:if test="${book.quantityStart == 5}">
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                        </c:if>
                                                        <c:if test="${book.quantityStart == 4}">
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                        </c:if>

                                                        <c:if test="${book.quantityStart == 3}">
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                        </c:if>

                                                        <c:if test="${book.quantityStart == 2}">
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                        </c:if>

                                                        <c:if test="${book.quantityStart == 1}">
                                                            <li class="active"><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                        </c:if>
                                                        <c:if test="${book.quantityStart == 0}">
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                            <li class=""><i class="fa fa-star"></i></li>
                                                        </c:if>
                                                    </ul>
                                                    <span class="text-muted">${book.quantityComment} nhận xét</span>
                                                </div>
                                            </a>
                                        </div>
                                    </div>

                                </c:forEach>
                            </c:if>

                        </div>

                        <div class="paginationA">
                            <button class="btn">
                                <svg
                                        xmlns="http://www.w3.org/2000/svg"
                                        class="btn--icon"
                                        fill="none"
                                        viewBox="0 0 24 24"
                                        stroke="currentColor"
                                        stroke-width="2"
                                >
                                    <path
                                            stroke-linecap="round"
                                            stroke-linejoin="round"
                                            d="M15 19l-7-7 7-7"
                                    />
                                </svg>
                            </button>
                            <div class="pages">
                                <c:forEach var="i" begin="1" end="${totalPage}">
                                    <c:if test="${i == currentPage}">
                                        <a href="/products?page=${i}" class="page activePage">${i}</a>
                                    </c:if>
                                    <c:if test="${i != currentPage}">
                                        <a href="/products?page=${i}" class="page">${i}</a>
                                    </c:if>
                                </c:forEach>
                                <p>${test} </p>

                            </div>
                            <button class="btn">
                                <svg
                                        xmlns="http://www.w3.org/2000/svg"
                                        class="btn--icon"
                                        fill="none"
                                        viewBox="0 0 24 24"
                                        stroke="currentColor"
                                        stroke-width="2"
                                >
                                    <path
                                            stroke-linecap="round"
                                            stroke-linejoin="round"
                                            d="M9 5l7 7-7 7"
                                    />
                                </svg>
                            </button>
                        </div>
                    </div>

                </div>
            </div>
        </section>
    </div>
</section>
<!--</div>-->

<%@include file="/common/web/footer.jsp" %>

<!--    footer-->
<script>
    function check() {
        // author
        const checkboxesAuthor = document.querySelectorAll('input[type="checkbox"][name="auth"]');
        const  authors = [];
        checkboxesAuthor.forEach(checkbox => {
            if (checkbox.checked) {
                authors.push(checkbox.value);
            }
        });
        // price
        const checkboxesPrice = document.querySelector('input[type="radio"][name="price"]:checked');
        let prices =checkboxesPrice.value;
        // NXB
        // const checkboxesNXB = document.querySelectorAll('input[type="checkbox"][name="NXB"]');
        // const  NXBs = [];
        // checkboxesNXB.forEach(checkbox => {
        //     if (checkbox.checked) {
        //         NXBs.push(checkbox.value);
        //     }
        // });
        // // phatHanh
        // const checkboxesPhatHanh = document.querySelectorAll('input[type="checkbox"][name="phatHanh"]');
        // const  phatHanhs = [];
        // checkboxesPhatHanh.forEach(checkbox => {
        //     if (checkbox.checked) {
        //         phatHanhs.push(checkbox.value);
        //     }
        // });
        const elements = document.querySelectorAll("div.item");
        for(let i =0; i< elements.length;i++) {
            elements[i].classList.remove("disblay")
        }
        for (let i = 0; i < elements.length; i++) {
            let index = 0;
            const classes = elements[i].classList;
            let a ='';
            let b =classes[classes.length-3];
            // let c = classes[classes.length-2].replace('c','');
            // let d = classes[classes.length-1];

            for(let j =5 ; j < classes.length-3; j++) {
                a += classes[j]+" ";
            }
            if(authors.length == 0 && prices == 5 ) {
                elements[i].classList.remove("disblay");
                break;
            }
            if(authors.length !=0 && prices == 5) {
                for (let j =0; j<authors.length;j++) {
                    if(a.trim() == authors[j].trim()) {
                        index++
                    }
                }
            }
            if(authors.length ==0 && prices != 5 ) {
                if(prices ==1 && b <= 100000) {
                    index++
                }
                if(prices ==2 && b >= 100000 && b <=200000) {
                    index++
                }
                if(prices ==3 && b >= 200000 && b <= 300000) {
                    index++
                }
                if(prices ==4 && b >= 300000) {
                    index++
                }
            }
            if(authors.length !=0 && prices !=5 ) {
                for (let j =0; j<authors.length;j++) {
                    if (prices == 1 && b <= 100000 && a.trim() == authors[j]) {
                        index++
                    }
                    if (prices == 2 && b >= 100000 && b <= 200000 && a.trim() == authors[j]) {
                        index++
                    }
                    if (prices == 3 && b >= 200000 && b <= 300000 && a.trim() == authors[j]) {
                        index++
                    }
                    if (prices == 4 && b >= 300000 && a.trim() == authors[j]) {
                        index++
                    }
                }


            }



            if(index == 0) {
                elements[i].classList.add("disblay");
            }
        }
    }



</script>

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

</body>
</html>
