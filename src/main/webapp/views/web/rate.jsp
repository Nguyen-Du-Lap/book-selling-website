<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/10/2022
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Đánh giá</title>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"/>
    <link rel="stylesheet" href="<c:url value='/templates/styles/Header.css'/> " />
    <link rel="stylesheet" href="<c:url value='/templates/styles/AccountPage.css'/> " />
    <link rel="stylesheet" href="<c:url value='/templates/styles/Footer.css'/> " />

    <style>
        .active {
            color: #F7A623;
        }
    </style>
</head>

<body>
<!-- -----------phần header----------------  -->

<%@include file="/common/web/header.jsp"%>

<!--------- end header---------- -->
<div id="content">
    <div class="wrapper">
        <div class="form_ctrl">
            <div class="acc_ctrl m_r12">
                <h2>
                    Tài khoản</h2>
                <div class="list_ctrl">
                    <ul>
                        <li class="first">
                            <a id="account" title="Thông tin tài khoản" href="/account?action=account">Thông tin tài
                                khoản</a></li>
                        <li class="first active">
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
                    <h3>Gửi đánh giá của bạn</h3>
                    <div class="container">
                        <label>Chọn Ảnh</label>
                        <input type="file" value="Chọn Ảnh">
                        <label>Chọn Video</label>
                        <input type="file" value="Chọn Video">
                    </div>
                    <form id="form" action="/rate" method="post">
                        <div>
                            <i class="fa fa-star active"></i>
                            <i class="fa fa-star active"></i>
                            <i class="fa fa-star active"></i>
                            <i class="fa fa-star active"></i>
                            <i class="fa fa-star active"></i>
                            <p class="active">Xuất sắc</p>
                        </div>

                        <div class="input">
                            <label>
                                <span class="req">*</span>Nội dung:
                            </label>
                            <input name="idBill" type="hidden" value="${idOrder}">
                            <input name="idBook" type="hidden" value="${idBook}">
                            <textarea name="comment" type="textarea" placeholder="Trải nghiệm của bạn với sản phẩm như thế nào?" rows="6" cols="80"></textarea>
                            <small>error</small>
                        </div>
                        <button class="button">Gửi</button>
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
<script src="/templates/scripts/changePassword1.js"></script>
<script src="/templates/scripts/header.js"></script>
</body>
</html>
