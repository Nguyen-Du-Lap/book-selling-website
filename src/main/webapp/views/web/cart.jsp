<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/5/2022
  Time: 9:57 PM
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
  <link rel="stylesheet" href="<c:url value='/templates/styles/Cart.css'/> " />
  <link rel="stylesheet" href="<c:url value='/templates/styles/Footer.css'/> " />
  <title>Cart</title>
</head>

<body>
<!-- -----------phần header----------------  -->
<%@include file="/common/web/header.jsp"%>
<!--------- end header---------- -->
<div id="content">
  <div class="container">
    <h1 class="header_title">GIỎ HÀNG</h1>
    <c:if test="${not empty message}">
      <div class="alert alert-${alert}" role="alert">
          ${message}
      </div>
    </c:if>
    <c:if test="${!sessionScope.containsKey('cart') || sessionScope.cart.map.size() == 0}">
      <div class="no-data text-center my-5 in-cart">
        <img src="/templates/images/empty_cart.jpg" alt="No data">
        <a style="font-size: 24px; font-weight: 600;" href="/home" id="btn-cart-buy">Mua ngay</a>
      </div>
    </c:if>

    <c:if test="${sessionScope.cart.map.size() > 0}">
      <table style="width: 100%; border: 1px solid #ccc;" class="table">
        <thead>
        <tr>
          <th>#</th>
          <th style="width: 65%;" scope="col">Sản phẩm</th>
          <th style="width: 12%;" scope="col">Số lượng</th>
          <th style="width: 13%;" scope="col">Thành tiền</th>
          <th style="width: 10%;" scope="col">Xóa</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${sessionScope.cart.map}">
            <tr data-product-id="${item.key}">
              <td>
                <label>
                  <input type="checkbox" name="settings" value="${item.key}">
                </label>
              </td>
              <td class="container_img">
                <div class="col_img"><img src="${item.value.product.image}" alt=""></div>
                <div class="col-container_content">
                  <a data-product-name="${item.value.product.name}"></a>
                  <h2 class="title">${item.value.product.name}</h2>
                  <div class="wrap_id">
                    <span class="id">Mã SP</span>
                    <div id="id">${item.key}</div>
                  </div>
                  <div class="wrap_price">
                      <div class="price active">${item.value.product.priceDiscount} đ</div>
                      <div class="price_sale">${item.value.product.price} đ</div>
                  </div>
                </div>
              </td>
              <td>
                <div class="d-flex quantity">
                  <div class="input-group-prepend minus">
                    <span class="input-group-text btn-spin btn-dec btn-number" style="cursor: pointer; background-color: #FFFFFF; border: 1px solid #cacaca">-</span>
                  </div>
                  <input type="text" value="${item.value.quantity}" style="width: 60px; background-color: #FFFFFF; border: 1px solid #cacaca" class="soluongsp text-center input-quantity" />
                  <div class="input-group-append plus">
                    <span class="input-group-text btn-spin btn-inc btn-number" style="cursor: pointer; background-color: #FFFFFF; border: 1px solid #cacaca">+</span>
                  </div>
                </div>
              </td>
              <td><span class="col-sum_price">${item.value.product.priceDiscount * item.value.quantity}đ</span></td>
              <td class="action text-center" data-title="Remove">
                <a href="#"><i class="col_delete fa-solid fa-trash-can"></i></a>
              </td>
            </tr>
        </c:forEach>
        </tbody>
      </table>
      <div class="container_right">
        <div class="container_price">
          <span class="provisional">Tạm tính</span>
          <span class="sum_money">${sessionScope.cart.totalPrice}đ</span>
        </div>
        <div class="order">ĐẶT HÀNG</div>
        <a href="/home"><div class="add_product">CHỌN THÊM SẢN PHẨM</div></a>
      </div>
    </c:if>

  </div>
</div>
<!-----footer------>

<%@include file="/common/web/footer.jsp"%>
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

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
  $('.minus .btn-number').on('click', function () {
    const pId = $(this).closest('tr').attr('data-product-id')
    window.location.href = '${context}/add-to-cart?product_id=' + pId + '&action=remove'
  })

  $('.plus .btn-number').on('click', function () {
    const pId = $(this).closest('tr').attr('data-product-id')
    window.location.href = '${context}/add-to-cart?product_id=' + pId + '&action=add'
  })

  $('.action a').on('click', function () {
    swal({
      title: "Xác nhận xóa?",
      text: "Sau khi xóa bạn sẽ không thể khôi phục!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    }).then((willDelete) => {
      if (willDelete) {
        const pId = $(this).closest('tr').attr('data-product-id')
        window.location.href = '${context}/add-to-cart?product_id=' + pId + '&action=delete'
      } else {
        return false
      }
    });

  })
</script>
// chon san pham trong gio hang de mua hang
<script>
  let checkboxes = $("input[type=checkbox][name=settings]")
  let enabledSettings = [];

  // Attach a change event handler to the checkboxes.
  checkboxes.change(function () {
    enabledSettings = checkboxes
            .filter(":checked") // Filter out unchecked boxes.
            .map(function () { // Extract values using jQuery map.
              return this.value;
            })
            .get() // Get array.

  });

  $('.order').on('click', function () {
    window.location.href = '${context}/orderAddVoucher?list_id=' + enabledSettings
  })
</script>

</body>

</html>
