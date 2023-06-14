<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/5/2022
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Account</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"/>
  <link rel="stylesheet" href="<c:url value='/templates/styles/Header.css'/> " />
  <link rel="stylesheet" href="<c:url value='/templates/styles/AccountPage.css'/> " />
  <link rel="stylesheet" href="<c:url value='/templates/styles/Footer.css'/> " />

</head>
<body>
<!-- -----------phần header----------------  -->
<%@include file="/common/web/header.jsp"%>
<!--------- end header---------- -->

<!--------- account page -------->
<div id="content">
  <div class="wrapper">
    <div class="form_ctrl">
      <div class="acc_ctrl m_r12">
        <h2>
          Tài khoản</h2>
        <div class="list_ctrl">
          <ul>
            <li class="first active">
              <a id="account" title="Thông tin tài khoản" href="/account?action=account">Thông tin tài
                khoản</a></li>
            <li class="first">
              <a id="changePassword" title="Đổi mật khẩu" href="/account?action=changePassword">Đổi
                mật khẩu</a></li>
            <li class="first">
              <a id="reviewOrders" title="Xem lại đơn hàng" href="/account?action=reviewOrders">Xem
                lại đơn hàng</a></li>
            <li class="first">
              <a id="logout" title="Đăng xuất" href="/logout?action=logout">Đăng xuất</a>
            </li>
          </ul>
        </div>
      </div>
      <div class="col_1_1">
        <div id="login" class="frm_content"
             onkeypress="javascript:return WebForm_FireDefaultButton(event, 'acc_save')">
          <h2>
            Cập nhật thông tin tài khoản
          </h2>
          <form id="form">
            <div class="input ">
              <label>
                <span class="req">*</span>Email của bạn:
              </label>
              <input name="email" type="text" value="${cus.email}" maxlength="150" id="acc_email">
              <small>error</small>
            </div>
            <div class="input ">
              <label for="acc_fname">
                <span class="req">*</span>Họ:</label>
              <input name="fname" type="text" value="${cus.lastName}" maxlength="150" id="acc_fname">
              <small>error</small>
            </div>
            <div class="input ">
              <label for="acc_lname">
                <span class="req">*</span>Tên:</label>
              <input name="lname" type="text" value="${cus.firstName}" maxlength="150" id="acc_lname">
              <small>error</small>
            </div>
            <div class="input ">
              <label for="acc_phoneNumber">
                <span class="req">*</span>Điện thoại:</label>
              <input name="phoneNumber" type="tel" id="acc_phoneNumber" value="${cus.phone}">
              <small>error</small>
            </div>
            <div>
              <label for="acc_address">
                Địa chỉ:</label>
              <input name="address" type="text" maxlength="250" id="acc_address" value="${cus.address}">
            </div>
            <div>
              <label>
                Tỉnh/Thành phố:</label>
              <select class="form-select form-select-sm" id="city" aria-label=".form-select-sm">
                <option value="" selected>Chọn tỉnh thành</option>
              </select>
              <label>
                Quận/Huyện:</label>
              <select class="form-select form-select-sm" id="district" aria-label=".form-select-sm">
                <option value="" selected>Chọn quận huyện</option>
              </select>
              <label>
                Phường/Xã:</label>
              <select class="form-select form-select-sm" id="ward" aria-label=".form-select-sm">
                <option value="" selected>Chọn phường xã</option>
              </select>
            </div>
            <button class="button">Lưu</button>
          </form>
        </div>
      </div>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script src="/templates/scripts/account.js"></script>
<script src="/templates/scripts/header.js"></script>
</body>
</html>
