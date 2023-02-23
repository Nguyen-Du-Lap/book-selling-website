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
  <link rel="stylesheet" href="<c:url value='/templates/styles/Order.css'/> " />
  <link rel="stylesheet" href="<c:url value='/templates/styles/Footer.css'/> " />
  <title>Order</title>
</head>

<body>
<!-- -----------phần header----------------  -->
<%@include file="/common/web/header.jsp"%>
<!--------- end header---------- -->
<div class="container content">
  <h1 class="header_top">ĐẶT HÀNG</h1>
  <c:forEach items="${list}" var="item">
    <h1>${item}</h1>
  </c:forEach>
  <div class="container_left">
    <div class="cross"></div>
    <h2 class="header_center">THÔNG TIN ĐƠN HÀNG</h2>
    <form id="submit_form" action="order/pay">
      <div class="form-group input">
        <label for="name">Họ và tên: <span class="obligatory">(*)</span></label>
        <input type="text" class="form-control" id="name" placeholder="Họ và tên" value="${customer.firstName} ${customer.lastName}" onchange="nameOnChange(this.value)" disabled>
        <i class="fa-solid fa-circle-check"></i>
        <i class="fa-solid fa-circle-xmark"></i>
        <small>Error</small>
      </div>
      <div class="form-group input">
        <label for="phone">Điện thoại: <span class="obligatory">(*)</span></label>
        <input type="text" class="form-control" id="phone" placeholder="Số điện thoại" value="${customer.phone}" onchange="phoneOnChange(this.value)" disabled>
        <i class="fa-solid fa-circle-check"></i>
        <i class="fa-solid fa-circle-xmark"></i>
        <small>Error</small>
      </div>
      <div class="form-group input">
        <label for="email">Email: <span class="obligatory">(*)</span></label>
        <input type="text" class="form-control" id="email" placeholder="Email" value="${customer.email}" onchange="emailOnChange(this.value)" disabled>
        <i class="fa-solid fa-circle-check"></i>
        <i class="fa-solid fa-circle-xmark"></i>
        <small>Error</small>
      </div>
      <div class="form-group input">
        <label for="address">Địa chỉ nhận: <span class="obligatory">(*)</span></label>
        <input type="text" class="form-control" id="address" placeholder="Địa chỉ nhận" onchange="addressOnChange(this.value)">
        <i class="fa-solid fa-circle-check"></i>
        <i class="fa-solid fa-circle-xmark"></i>
        <small>Error</small>
      </div>
      <div class="form-group input">
        <label for="city">Tỉnh/Thành: <span class="obligatory">(*)</span></label>
        <select class="form-control form-select form-select-sm mb-3" id="city" aria-label=".form-select-sm">
          <option value="" selected>Chọn tỉnh thành</option>
        </select>
        <i class="fa-solid fa-circle-check"></i>
        <i class="fa-solid fa-circle-xmark"></i>
        <small>Error</small>
      </div>
      <div class="form-group input">
        <label for="district">Quận/Huyện: <span class="obligatory">(*)</span></label>
        <select class="form-control form-select form-select-sm mb-3" id="district"
                aria-label=".form-select-sm">
          <option value="" selected>Chọn quận huyện</option>
        </select>
        <i class="fa-solid fa-circle-check"></i>
        <i class="fa-solid fa-circle-xmark"></i>
        <small>Error</small>
      </div>
      <div class="form-group input">
        <label for="ward">Phường/Xã: <span class="obligatory">(*)</span></label>
        <select class="form-control form-select form-select-sm" id="ward" aria-label=".form-select-sm">
          <option value="" selected>Chọn phường xã</option>
        </select>
        <i class="fa-solid fa-circle-check"></i>
        <i class="fa-solid fa-circle-xmark"></i>
        <small>Error</small>
      </div>
      <div class="form-group input">
        <label for="pack">Đóng gói: <span class="obligatory">(*)</span></label>
        <select class="form-control" id="pack" aria-label=".form-select-sm">
          <option value="" selected>Chọn quy cách đóng gói</option>
          <option value="1">Bọc Blatic</option>
          <option value="2">Để nguyên seal</option>
        </select>
        <i class="fa-solid fa-circle-check"></i>
        <i class="fa-solid fa-circle-xmark"></i>
        <small>Error</small>
      </div>
      <div class="form-group input">
        <label for="pay">Hình thức thanh toán: <span class="obligatory">(*)</span></label>
        <select class="form-control" id="pay" aria-label=".form-select-sm">
          <option value="" selected>Chọn hình thức</option>
          <option value="Chuyển khoản">Chuyển khoản</option>
          <option value="Cod: Giao hàng nhận tiền">Cod: Giao hàng nhận tiền</option>
        </select>
        <i class="fa-solid fa-circle-check"></i>
        <i class="fa-solid fa-circle-xmark"></i>
        <small>Error</small>
      </div>
      <div class="form-group input">
        <label for="note">Ghi chú:</label>
        <textarea class="form-control" name="note" rows="3" cols="20" id="note"
                  placeholder="Ghi chú về đơn hàng"></textarea>
      </div>
      <button type="submit" id="" class="bnt_sumit">ĐẶT HÀNG</button>
    </form>
  </div>
  <div class="container_right">
    <h4 class="header-code_sale">Áp dụng mã giảm giá</h4>
    <div class="form-group">
      <label style="font-size: 13px; margin-bottom: 2px; color: #1C1C1C;" for="code_sale">Nhập mã giảm giá tại đây</label>
      <input type="text" class="form-control" id="code_sale" placeholder="Mã giảm giá">
    </div>
    <input id="btnUserCoupon" class="dr_button" type="button" value="ÁP DỤNG" onclick="check_code_sale();">

    <h4 class="order_header">Chi tiết đơn hàng</h4>
    <div class="container_order">

        <div class="wrap_oder">
          <c:forEach var="item" items="${cartOrder.map}">
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
              <div class="ml" id="sum_price"> ${totalPrice} đ</div>
            </div>
            <div class="wrap mt">
              <span class="sum_transport">Phí vận chuyển:</span>
              <div class="ml" id="sum_transport"> ${transportFee} đ</div>
            </div>
            <div class="wrap mt">
              <span class="sum_order">Thanh toán:</span>
              <div class="ml" style="font-weight: 600; color: rgb(217, 11, 11);" id="sum_order"> ${totalPrice + transportFee} đ</div>
            </div>
          </div>
          <input id="bt-update_order" type="button" value="CHỈNH SỬA ĐƠN HÀNG">
        </div>


    </div>

  </div>
</div>
<!-- --------footer ------------->
<footer>
  <section class="abovefooter text-white" style="background-color: #1a94ff;">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 col-sm-6">
          <div class="dichvu d-flex align-items-center">
            <img src="images/footers/iconphone.png" alt="icon-books" style="border-radius: 100%;">
            <div class="noidung">
              <h6 class="tieude font-weight-bold">HƠN 10000 LOẠI SÁCH </h6>
              <p class="detail">Tuyển chọn bởi Doraemon</p>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-sm-6">
          <div class="dichvu d-flex align-items-center">
            <img src="images/footers/icon-ship.png" alt="icon-ship">
            <div class="noidung">
              <h6 class="tieude font-weight-bold">MIỄN PHÍ GIAO HÀNG</h6>
              <p class="detail">Từ 150.000đ ở TP.HCM</p>
              <p class="detail">Từ 300.000đ ở tỉnh thành khác</p>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-sm-6">
          <div class="dichvu d-flex align-items-center">
            <img src="images/footers/icon-gift.png" alt="icon-gift">
            <div class="noidung">
              <h6 class="tieude font-weight-bold">QUÀ TẶNG MIỄN PHÍ</h6>
              <p class="detail">Tặng kèm bìa bao sách</p>
              <p class="detail">Miễn phí 5 stickers</p>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-sm-6">
          <div class="dichvu d-flex align-items-center">
            <img src="images/footers/icon-return.png" alt="icon-return">
            <div class="noidung">
              <h6 class="tieude font-weight-bold">ĐỔI TRẢ NHANH CHÓNG</h6>
              <p class="detail">Hàng bị lỗi được đổi trả nhanh chóng</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <div class="container py-4">
    <div class="row">
      <div class="col-md-3 col-xs-6">
        <div class="gioithieu">
          <h6 class="header text-uppercase font-weight-bold">Về Doraemon</h6>
          <a href="#">Giới thiệu về Doraemon</a>
          <a href="#">Tuyển dụng</a>
          <div class="fb-like" data-href="https://www.facebook.com/DealBook-110745443947730/"
               data-width="300px" data-layout="button" data-action="like" data-size="small"
               data-share="true"></div>
        </div>
      </div>
      <div class="col-md-3 col-xs-6">
        <div class="hotrokh">
          <h6 class="header text-uppercase font-weight-bold">HỖ TRỢ KHÁCH HÀNG</h6>
          <a href="#">Hướng dẫn đặt hàng</a>
          <a href="#">Phương thức thanh toán</a>
          <a href="#">Phương thức vận chuyển</a>
          <a href="#">Chính sách đổi trả</a>
        </div>
      </div>
      <div class="col-md-3 col-xs-6">
        <div class="lienket">
          <h6 class="header text-uppercase font-weight-bold">HỢP TÁC VÀ LIÊN KẾT</h6>
          <img src="images/footers/dang-ky-bo-cong-thuong.png" alt="dang-ky-bo-cong-thuong">
        </div>
      </div>
      <div class="col-md-3 col-xs-6">
        <div class="ptthanhtoan">
          <h6 class="header text-uppercase font-weight-bold">Phương thức thanh toán</h6>
          <img src="images/footers/visa-payment.jpg" alt="visa-payment">
          <img src="images/footers/master-card-payment.jpg" alt="master-card-payment">
          <img src="images/footers/jcb-payment.jpg" alt="jcb-payment">
          <img src="images/footers/atm-payment.jpg" alt="atm-payment">
          <img src="images/footers/cod-payment.jpg" alt="cod-payment">
          <img src="images/footers/payoo-payment.jpg" alt="payoo-payment">
        </div>
      </div>
    </div>
  </div>

</footer>
<!-- nut cuon len dau trang -->
<%@include file="/common/web/footer.jsp"%>

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
<script src="/templates/scripts/header.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script src="/templates/scripts/order.js"></script>
</body>

</html>
