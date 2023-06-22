<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/5/2022
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link
          href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700&display=swap"
          rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"
        integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="<c:url value='/templates/styles/Header.css'/> " />
  <link rel="stylesheet" href="<c:url value='/templates/styles/AddVoucher.css'/> " />
  <link rel="stylesheet" href="<c:url value='/templates/styles/Footer.css'/> " />
  <title>Order</title>
  <style>
    .btn_bt:hover {
      opacity: 0.8;
    }
  </style>
</head>

<body>
<!-- -----------phần header----------------  -->
<%@include file="/common/web/header.jsp"%>
<!--------- end header---------- -->
<div class="container content">
  <h1 class="header_top">ĐẶT HÀNG</h1>
  <c:if test="${not empty message}">
    <div class="alert alert-${alert}" role="alert">
        ${message}
    </div>
  </c:if>
  <c:forEach items="${list}" var="item">
    <h1>${item}</h1>
  </c:forEach>
  <div class="container_left">
    <h4 class="header-code_sale">Áp dụng mã giảm giá</h4>
    <div class="form-group">
      <c:if test="${listDiscount != null}">
        <c:forEach var="voucher" items="${listDiscount}">
          <div style="display: flex; justify-content: space-between;border-radius: 5px; border: 1px solid #ccc; width: 330px; align-items: center; text-align: center;margin-top: 24px;">
            <div style="background-color: #0b78d6; font-size: 12px;color: #FFFFFF;padding: 12px;">
                ${voucher.name}
            </div>
            <span style="padding: 0 4px; font-size: 12px">${voucher.diktat}</span>
            <label style="padding: 12px; cursor: pointer">
              <input type="radio" name="idDiscount" value="${voucher.idDiscount}">
            </label>
          </div>
        </c:forEach>
      </c:if>
    </div>
    <a href="${pageContext.request.contextPath}/voucher" style="margin-top: 24px">
      <h2>Thêm voucher</h2>
    </a>
    <button class="btn_bt" id="next"
            style="float: left;background-color: #ed4d2b; padding: 12px 36px;
            border-radius: 5px; color: #fff; border: none; margin-top: 24px;text-align: center; width: 60%">
      Đồng ý
    </button>
  </div>
  <div class="container_right">

    <h4 class="order_header">Chi tiết đơn hàng</h4>
    <div class="container_order">
        <div class="wrap_oder">
          <c:forEach var="item" items="${sessionScope.cartOrder.map}">
            <h2 class="title"> ${item.value.product.name}</h2>
            <div class="wrap">
              <span class="id fs_s">Mã SP: </span>
              <div class="fs_s" id="id"> ${item.key}</div>
            </div>
            <div class="wrap" style="margin-bottom: 12px">
              <span class="quantity fs_s">Số lượng:</span>
              <div class="fs_s" id="quantity"> ${item.value.quantity}</div>
            </div>
            <hr>
          </c:forEach>
          <div class="wrap_left">
            <div style="margin-top: 12px;" class="wrap mt">
              <span class="sum_price">Tổng tiền:</span>
              <div class="ml" id="sum_price"> ${sessionScope.cartOrder.totalPrice} đ</div>
            </div>

          </div>
          <a href="${pageContext.request.contextPath}/cart">
            <input class="btn_bt" id="bt-update_order"  type="button" value="CHỈNH SỬA ĐƠN HÀNG">
          </a>
        </div>


    </div>
  </div>
</div>
<!-- --------footer ------------->
<!-- nut cuon len dau trang -->
<%@include file="/common/web/footer.jsp"%>

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
<script src="/templates/scripts/header.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<%--<script src="/templates/scripts/order.js"></script>--%>
<script>
  $('#next').on('click', function () {
    let idVoucher = $("input[name='idDiscount']:checked").val();
    if (typeof(idVoucher) != "undefined"){
      window.location.href = '${pageContext.request.contextPath}/order?idVoucher='+idVoucher
    }else {
      window.location.href = '${pageContext.request.contextPath}/order?idVoucher='+1000000
    }
  })
</script>

</body>

</html>
