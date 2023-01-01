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
    <table style="width: 100%; border: 1px solid #ccc;" class="table">
      <thead>
      <tr>
        <th style="width: 65%;" scope="col">Sản phẩm</th>
        <th style="width: 12%;" scope="col">Số lượng</th>
        <th style="width: 13%;" scope="col">Thành tiền</th>
        <th style="width: 10%;" scope="col">Xóa</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td class="container_img">
          <div class="col_img"><img src="/templates/images/img-carousel.jpg" alt=""></div>
          <div class="col-container_content">
            <h2 class="title">Đồng Vọng Dân Gian - Tập 1 - Bản Đặc Biệt - Tặng Kèm Sticker +
              Postcard Bồi Cứng</h2>
            <div class="wrap_id">
              <span class="id">Mã SP</span>
              <div id="id">123</div>
            </div>
            <div class="wrap_price">
              <div class="price">125.200đ</div>
              <div class="price_sale active">125.200đ</div>
            </div>
          </div>
        </td>
        <td>
          <select name="" id="col_quantity">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
          </select>
        </td>
        <td><span class="col-sum_price">125.000đ</span></td>
        <td><i class="col_delete fa-solid fa-trash-can"></i></td>
      </tr>
      <tr>
        <td class="container_img">
          <div class="col_img"><img src="/templates/images/vanhocnuocngoai/hay_nham_mat_khi_anh_den___tap_1_tai_ban_2019_1_2020_06_19_17_07_25.jpeg" alt=""></div>
          <div class="col-container_content">
            <h2 class="title">Hãy Nhắm Mắt Khi Anh Đến - Tập 1 (Tái bản 2019)</h2>
            <div class="wrap_id">
              <span class="id">Mã SP</span>
              <div id="id">12345654</div>
            </div>
            <div class="wrap_price">
              <div class="price">122.000đ</div>
              <div class="price_sale active">154.000đ</div>
            </div>
          </div>
        </td>
        <td>
          <select name="" id="col_quantity">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
          </select>
        </td>
        <td><span class="col-sum_price">122.000đ</span></td>
        <td><i class="col_delete fa-solid fa-trash-can"></i></td>
      </tr>
      </tbody>
    </table>
    <div class="container_right">
      <div class="container_price">
        <span class="provisional">Tạm tính</span>
        <span class="sum_money">247.000đ</span>
      </div>
      <div class="order"><a href="./order.html">ĐẶT HÀNG</a></div>
      <div class="add_product"><a href="./vanhocnuocngoai.html">CHỌN THÊM SẢN PHẨM</a></div>
    </div>
  </div>
</div>
<!-----footer------>

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
<script src="/templates/scripts/header.js"></script>

</body>

</html>
