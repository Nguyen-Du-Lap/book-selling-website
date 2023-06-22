<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/10/2022
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sign Up</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Login.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Footer.css">

</head>

<body>
<!-- -----------phần header----------------  -->
<%@include file="/common/web/header.jsp"%>
<!--------- end header---------- -->
<!--------- sign up form---------- -->
<div class="signUp">
  <div class="signUp-title">Đăng ký</div>
  <c:if test="${not empty message}">
    <div class="alert alert-${alert}" role="alert">
        ${message}
    </div>
  </c:if>
  <form action="${pageContext.request.contextPath}/signup" class="form_signUp" id="form_signUp" method="post">
    <div class="info-title">*Thông tin đăng nhập:</div>
    <div class="input ">
      <label>Email</label>
      <input type="text" placeholder="Nhập vào email" id="email" name="email" onchange="emailOnChange(this.value)">
      <i class="fa-solid fa-circle-check"></i>
      <i class="fa-solid fa-circle-xmark"></i>
      <small>Error</small>
    </div>
    <div class="input ">
      <label>Mật khẩu <span style="font-size: 12px">(chứa ít nhất 1 kí tự in hoa, số và kí tự đặt biệt)</span></label>
      <input type="password" placeholder="Nhập vào mật khẩu" id="password" name="password" onchange="passwordOnChange(this.value)">
      <i class="fa-solid fa-circle-check"></i>
      <i class="fa-solid fa-circle-xmark"></i>
      <small>Error</small>
    </div>
    <div class="input ">
      <label>Xác nhận mật khẩu</label>
      <input type="password" placeholder="Nhập lại mật khẩu" id="password2" name="password2" onchange="passwordAOnChange(this.value)">
      <i class="fa-solid fa-circle-check"></i>
      <i class="fa-solid fa-circle-xmark"></i>
      <small>Error</small>
    </div>

    <div class="info-title">*Thông tin cá nhân:</div>
    <div class="compul-info">
      <div class="input fname">
        <label>Họ</label>
        <input placeholder="Họ" type="text" id="fname" name="fname" onchange="namefOnChange(this.value)">
        <i class="fa-solid fa-circle-check"></i>
        <i class="fa-solid fa-circle-xmark"></i>
        <small>Error</small>
      </div>
      <div class="input lname">
        <label>Tên</label>
        <input placeholder="Tên" type="text" id="lname" name="lname" onchange="namelOnChange(this.value)">
        <i class="fa-solid fa-circle-check"></i>
        <i class="fa-solid fa-circle-xmark"></i>
        <small>Error</small>
      </div>
    </div>
    <div class="input ">
      <label>Số điện thoại</label>
      <input placeholder="SĐT" type="tel" id="phoneNumber" name="phoneNumber" onchange="phoneOnChange(this.value)">
      <i class="fa-solid fa-circle-check"></i>
      <i class="fa-solid fa-circle-xmark"></i>
      <small>Error</small>
    </div>
    <div class="input ">
      <label>Địa chỉ</label>
      <input placeholder="Số nhà, tên đường, tỉnh/ thành phố ..." type="text" id="address" name="address">
      <i class="fa-solid fa-circle-check"></i>
      <i class="fa-solid fa-circle-xmark"></i>
      <small>Error</small>
    </div>
    <button type="submit" id="btn-signUp" class="btn-signUp">Đăng ký</button>
    <p style="margin-top: 30px; padding-bottom: 20px; color: #aaaaaa; text-align: center; font-size: 14px;">
      Bằng việc đăng kí, bạn đã đồng ý với <a href="#" class="red-link">Điều khoản dịch vụ</a> & <a href="#" class="red-link">
      Chính sách bảo mật</a> của chúng tôi</p>
    <p style="margin-top: 20px; margin-bottom: 20px; color: #aaaaaa; text-align: center;">Bạn đã có tài khoản? <a href="${pageContext.request.contextPath}/login?action=login" class="login-link">Đăng nhập</a></p>

  </form>
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
<script src="${pageContext.request.contextPath}/templates/scripts/signUp.js"></script>
<script src="${pageContext.request.contextPath}/templates/scripts/header.js"></script>
</body>

</html>
