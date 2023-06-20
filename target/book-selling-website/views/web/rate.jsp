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
                            <a id="account" title="Thông tin tài khoản" href="${pageContext.request.contextPath}/account?action=account">Thông tin tài
                                khoản</a></li>
                        <li class="first">
                            <a id="changePassword" title="Đổi mật khẩu" href="${pageContext.request.contextPath}/account?action=changePassword">Đổi
                                mật khẩu</a></li>
                        <li class="first active">
                            <a id="reviewOrders" title="Xem lại đơn hàng" href="${pageContext.request.contextPath}/account?action=reviewOrders">Xem
                                lại đơn hàng</a></li>
                        <li class="first">
                            <a id="logout" title="Đăng xuất" href="${pageContext.request.contextPath}/logout?action=logout">Đăng xuất</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col_1_1">

                <div id="login" class="frm_content">

                    <h3>Gửi đánh giá của bạn</h3>
                    <div class="container">
                        <label>Chọn Ảnh</label>
                        <input type="file" value="Chọn Ảnh">
                        <label>Chọn Video</label>
                        <input type="file" value="Chọn Video">
                    </div>
                    <form id="form" action="${pageContext.request.contextPath}/rate" method="post">
                        <div>
                            <i class="fa fa-star active" id="disable_1"></i>
                            <i class="fa fa-star active" id="disable_2"></i>
                            <i class="fa fa-star active" id="disable_3"></i>
                            <i class="fa fa-star active" id="disable_4"></i>
                            <i class="fa fa-star active" id="disable_5"></i>
                            <p class="active"  id="text_rate">Xuất sắc</p>
                            <input name="numberStar" id="numberStar" type="hidden" value="5">
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
<script src="${pageContext.request.contextPath}/templates/scripts/changePassword1.js"></script>
<script src="${pageContext.request.contextPath}/templates/scripts/header.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script>
    const disable_1 = document.getElementById("disable_1");
    const disable_2 = document.getElementById("disable_2")
    const disable_3 = document.getElementById("disable_3")
    const disable_4 = document.getElementById("disable_4")
    const disable_5 = document.getElementById("disable_5")
    const text = document.getElementById("text_rate")
    let giaTri = document.getElementById("numberStar")
    disable_1.addEventListener("click", function() {
        disable_1.classList.add("active");
        disable_2.classList.remove("active");
        disable_3.classList.remove("active");
        disable_4.classList.remove("active");
        disable_5.classList.remove("active");
        text.innerText = "Tệ"
        giaTri.value = "1"

    });
    disable_2.addEventListener("click", function() {
        disable_1.classList.add("active");
        disable_2.classList.add("active");
        disable_3.classList.remove("active");
        disable_4.classList.remove("active");
        disable_5.classList.remove("active");
        text.innerText = "Không hài lòng"
        giaTri.value = "2"

    });
    disable_3.addEventListener("click", function() {
        disable_1.classList.add("active");
        disable_2.classList.add("active");
        disable_3.classList.add("active");
        disable_4.classList.remove("active");
        disable_5.classList.remove("active");
        text.innerText = "Bình thường"
        giaTri.value = "3"

    });
    disable_4.addEventListener("click", function() {
        disable_1.classList.add("active");
        disable_2.classList.add("active");
        disable_3.classList.add("active");
        disable_4.classList.add("active");
        disable_5.classList.remove("active");
        text.innerText = "Hài lòng"
        giaTri.value = "4"

    });
    disable_5.addEventListener("click", function() {
        disable_1.classList.add("active");
        disable_2.classList.add("active");
        disable_3.classList.add("active");
        disable_4.classList.add("active");
        disable_5.classList.add("active");
        text.innerText = "Tuyệt vời"
        giaTri.value = "5"
    });




</script>
</body>
</html>
