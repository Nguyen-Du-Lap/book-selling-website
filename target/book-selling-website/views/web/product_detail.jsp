<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/5/2022
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:set var="context" value="${pageContext.request.contextPath}"/>--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${bookModel.name}</title>
  <link rel="stylesheet" href="/css/bootstrap.css">
  <link rel="stylesheet" href="/css/bootstrap-grid.css">
  <link rel="stylesheet" href="/css/bootstrap-reboot.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <link
          href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700&display=swap"
          rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer"/>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet">
  <link rel="stylesheet" href="<c:url value='/templates/styles/Header.css'/> " />
  <link rel="stylesheet" href="<c:url value='/templates/styles/ProductDetail.css'/> " />
  <link rel="stylesheet" href="<c:url value='/templates/styles/Footer.css'/> " />

  <style>
    .sao .active {
      color: #F5A623;
    }
  </style>
</head>
<body>

<%@include file="/common/web/header.jsp"%>

<!-------------------------Product----------------------->
<section class="product">
  <div class="container">
    <nav id="breadcrumbbar">
      <ul class="breadcrumb">
        <li class="breadcrumb-item"><a class="chang_font" href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
        <li class="breadcrumb-item"><a href="#">SACH Kinh Te</a></li>
        <li class="breadcrumb-item active">${bookModel.name}</li>
      </ul>
    </nav>
    <div class="product-content row">
      <div class="product-content-left">
        <div class="product-content-left-big-img">
          <img src="${pageContext.request.contextPath}/${bookModel.image}" alt="">
        </div>
        <div class="product-content-left-small-img d-flex">
          <c:forEach var="img" items="${listImage}">
            <img src="${pageContext.request.contextPath}/${img}" alt="" style="margin-top: 10px">
          </c:forEach>
        </div>
      </div>
      <div class="product-content-right">
        <div class="product-content-right-product-name">
          <h1>${bookModel.name}</h1>
          <p>MSP: ${bookModel.idBook}</p>
        </div>
        <div class="product-content-right-product-rate">
          <c:if test="${bookModel.quantityStart == 5}">
            <i class="fa fa-star active"></i>
            <i class="fa fa-star active"></i>
            <i class="fa fa-star active"></i>
            <i class="fa fa-star active"></i>
            <i class="fa fa-star active"></i>
          </c:if>
          <c:if test="${bookModel.quantityStart == 4}">
            <i class="fa fa-star active"></i>
            <i class="fa fa-star active"></i>
            <i class="fa fa-star active"></i>
            <i class="fa fa-star active"></i>
            <i class="fa fa-star"></i>
          </c:if>

          <c:if test="${bookModel.quantityStart == 3}">
            <i class="fa fa-star active"></i>
            <i class="fa fa-star active"></i>
            <i class="fa fa-star active"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
          </c:if>

          <c:if test="${bookModel.quantityStart == 2}">
            <i class="fa fa-star active"></i>
            <i class="fa fa-star active"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
          </c:if>

          <c:if test="${bookModel.quantityStart == 1}">
            <i class="fa fa-star active"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
          </c:if>
          <c:if test="${bookModel.quantityStart == 0}">
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
          </c:if>
        </div>
        <hr>
        <div class="product-content-right-product-price">
          <div class="giabia">Giá:<span class="giacu ml-2">${bookModel.priceDiscount} ₫</span></div>
          <div class="giaban">Giá bán tại Doraemon: <span class="giamoi font-weight-bold">${bookModel.price} đ</span></div>
          <div class="tietkiem">Tiết kiệm: <b>20.000 ₫</b>
          </div>
            <c:if test="${quantityRemain != 0}">
              <div class="tietkiem">Số lượng còn lại: <b>${quantityRemain}</b>
            </c:if>
        </div>
        <div class="product-content-right-uudai">
          <h6 class="header font-weight-bold">Khuyến mãi & Ưu đãi tại Doraemon:</h6>
          <ul>
            <li><b>Miễn phí giao hàng </b>cho đơn hàng từ 150.000đ ở TP.HCM và 300.000đ ở
              Tỉnh/Thành khác <a href="${pageContext.request.contextPath}/home">>> Chi tiết</a></li>
            <li><b>Combo sách hot - CHÁY HÀNG </b><a href="home.html">>>Xem ngay</a></li>
            <li>Tặng kèm bìa bao sách</li>
            <li>Miễn phí 5 stickers</li>
            <li>Miễn phí đổi trả nếu sách bị lỗi hoặc hỏng</li>
          </ul>
        </div>

        <c:if test="${quantityRemain == 0}">

           <div class="h2">Đã Hết Hàng</div>
        </c:if>
        <c:if test="${quantityRemain != 0}">
          <div class="product-content-right-soluong d-flex">
            <label class="font-weight-bold">Số lượng: </label>
            <div class="input-number input-group md-3 quantity">
              <div class="input-group-prepend">
                <span class="input-group-text btn-spin btn-dec" onclick="changeQuantity(-1)">-</span>
              </div>
              <input id="soluongsp" type="text" value="1" class="soluongsp text-center input-quantity">
              <div class="input-group-append">
                <span class="input-group-text btn-spin btn-inc" onclick="changeQuantity(+1)">+</span>
              </div>
            </div>
          </div>
          <div class="product-content-right-product-button row">
                    <%--          <button><i class="fas fa-shopping-cart"></i><p>THÊM VÀO GIỎ HÀNG</p></button>--%>
                <div class="add-to-cart">
                    <a href="#">
                        <button type="button"><i class="fas fa-shopping-cart"></i><p>THÊM VÀO GIỎ HÀNG</p></button>
                    </a>
                </div>

                <button class="muangay buy-now"><p>MUA NGAY</p></button>
            </div>
        </c:if>


        <div class="product-content-right-product-icon d-flex">
          <div class="product-content-right-product-icon-item">
            <i class="fas fa-phone-alt"></i><p>Hotline</p>
          </div>
          <div class="product-content-right-product-icon-item">
            <i class="far fa-comment"></i> <p>Chat</p>
          </div>
          <div class="product-content-right-product-icon-item">
            <i class="far fa-envelope"></i> <p>Mail</p>

          </div>
        </div>
        <div class="product-content-right-product-bottom">
          <div class="product-content-right-product-bottom-top">
            &#8744;
          </div>
          <div class="product-content-right-product-bottom-content-big">
            <div class="product-content-right-product-bottom-content-title row">
              <div class="product-content-right-product-bottom-content-title-item mota">
                <p>Mô tả</p>
              </div>
              <div class="product-content-right-product-bottom-content-title-item danhgia">
                <p>Đánh giá, bình luận</p>
              </div>
            </div>
            <div class="product-content-right-product-bottom-content">
              <div class="product-content-right-bottom-content-mota">
                <div class="product-content-right-product-bottom-content-thongtinsp">
                  <table>
                    <thead>
                    </thead>
                    <tbody>
                    <tr>
                      <td class="themmau">Mã hàng</td>
                      <td>${bookDetail.id}</td>
                    </tr>
                    <tr>
                      <td class="themmau">Mã ISBN</td>
                      <td>${bookDetail.isbn}</td>
                    </tr>
                    <tr>
                      <td class="themmau">Ngôn ngữ</td>
                      <td>${bookDetail.language}</td>
                    </tr>
                    <tr>
                      <td class="themmau">Tác giả</td>
                      <td>${bookDetail.nameAuthor}</td>
                    </tr>
                    <tr>
                      <td class="themmau">NXB</td>
                      <td>${bookDetail.name}</td>
                    </tr>
                    <tr>
                      <td class="themmau">Năm XB</td>
                      <td>${bookDetail.year}</td>
                    </tr>
                    <tr>
                      <td class="themmau">Trọng Lượng (gr)</td>
                      <td>${bookDetail.weight}</td>
                    </tr>
                    <tr>
                      <td class="themmau">Kích Thước Bao Bì</td>
                      <td>${bookDetail.size} cm</td>
                    </tr>
                    <tr>
                      <td class="themmau">Số trang</td>
                      <td>${bookDetail.page}</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <div class="product-content-right-product-bottom-content-chitiet">
                  ${bookDetail.description}
                </div>
              </div>

              <div class="product-content-right-product-bottom-content-danhgia">
                <div class="product-content-right-product-bottom-content-rate d-fex">
                  <div class="text-center danhgia">
                    <p class="tieude">Đánh giá trung bình</p>
                    <div class="diem">${bookModel.quantityStart}/5</div>
                    <div class="sao">
                      <c:if test="${bookModel.quantityStart == 5}">
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                      </c:if>
                      <c:if test="${bookModel.quantityStart == 4}">
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star"></i>
                      </c:if>

                      <c:if test="${bookModel.quantityStart == 3}">
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                      </c:if>

                      <c:if test="${bookModel.quantityStart == 2}">
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                      </c:if>

                      <c:if test="${bookModel.quantityStart == 1}">
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                      </c:if>
                      <c:if test="${bookModel.quantityStart == 0}">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                      </c:if>
                    </div>
                    <p class="sonhanxet text-muted">(${bookModel.quantityComment} nhận xét)</p>
                  </div>
                </div>
                <div class="content_danhgia">
                  <c:forEach var="rateDG" items="${rates}">
                    <div style="font-weight: 600">${rateDG.nameUser}</div>
                    <div class="product-content-right-product-rate">
                      <c:if test="${rateDG.startRate == 5}">
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                      </c:if>
                      <c:if test="${rateDG.startRate == 4}">
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star"></i>
                      </c:if>

                      <c:if test="${rateDG.startRate == 3}">
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                      </c:if>

                      <c:if test="${rateDG.startRate == 2}">
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                      </c:if>

                      <c:if test="${rateDG.startRate == 1}">
                        <i class="fa fa-star active"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                      </c:if>
                      <c:if test="${rateDG.startRate == 0}">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                      </c:if>
                    </div>
                    <span style="margin-bottom: 8px">${rateDG.rate_time}</span>
                    <br/>
                    <span style="margin-bottom: 24px">${rateDG.comment}</span>
                    <hr/>
                  </c:forEach>

                </div>
              </div>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<%@include file="/common/web/footer.jsp"%>

<!--    footer-->

<!-- ----js phần header -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js" integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
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
<script src="js/bootstrap.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/templates/scripts/product_type.js"></script>

<script src="${pageContext.request.contextPath}/templates/scripts/product.js"></script>
<script>
  $('.add-to-cart a').on('click', function () {
    const remainQuantity = Number(${quantityRemain}), quantity = $('.quantity .input-quantity').val()
    if (remainQuantity === 0 || remainQuantity < quantity) {
      $.alert({
        title: 'Hết hàng',
        content: 'Số lượng sản phẩm không đủ.',
        closeIcon: true,
        animateFromElement: false,
        theme: 'material'
      })
    } else {
      window.location.href =
              '${pageContext.request.contextPath}/add-to-cart?product_id=${bookModel.idBook}' + '&action=add' + '&quantity=' + quantity
    }

    return false
  })

  $('.buy-now').on('click', function () {
    const remainQuantity = Number(${quantityRemain}), quantity = $('.quantity .input-quantity').val()
    if (remainQuantity === 0 || remainQuantity < quantity) {
      $.alert({
        title: 'Hết hàng',
        content: 'Số lượng sản phẩm không đủ.',
        closeIcon: true,
        animateFromElement: false,
        theme: 'material'
      })
    } else {
      window.location.href =
              '${pageContext.request.contextPath}/orderBuyNowControlller?product_id=${bookModel.idBook}' + '&quantity=' + quantity
    }

    return false
  })
</script>
</body>
</html>
