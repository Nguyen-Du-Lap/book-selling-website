<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/11/2022
  Time: 8:54 AM
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Transport.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Footer.css">
    <title>Phương thức vận chuyển</title>
</head>

<body>
<!-- -----------phần header----------------  -->
<%@include file="/common/web/header.jsp"%>
<!--------- end header---------- -->
<div id="content">
    <div class="container">
        <nav id="breadcrumbbar">
            <ul class="breadcrumb">
                <li class="breadcrumb-item"><a class="chang_font" href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                <li class="breadcrumb-item active"><a>Phương thức vận chuyển</a></li>
            </ul>
        </nav>
        <div class="wrapper">
            <h1>Mã giảm giá</h1>
        </div>
        <div class="content_container">
            <h1 style="background-color: #ed4d2b; padding: 18px 24px; color: #fff; width: 500px; border-radius: 5px;margin-top: 42px">Các voucher</h1>
            <c:forEach var="voucher" items="${listVoucher}">
                <div style="display: flex; justify-content: space-between;border-radius: 5px; border: 1px solid #ccc; width: 450px; align-items: center; text-align: center;margin-top: 24px;">
                    <div style="background-color: #0b78d6; font-size: 20px;color: #FFFFFF;padding: 24px;">
                        ${voucher.name}
                    </div>
                    <span style="padding: 0 6px">${voucher.diktat}</span>
                    <a href="${pageContext.request.contextPath}/saveVoucher?id=${voucher.idVoucher}" style="background-color: #ed4d2b; padding: 16px 24px; border-radius: 5px; color: #fff">Lưu</a>

                </div>
            </c:forEach>
            <button style="border: none; padding: 4px 8px; margin-top: 12px" onclick="goBack()">Trở lại</button>
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
<script src="${pageContext.request.contextPath}/templates/scripts/header.js"></script>
<script>
    function goBack() {
        history.back();
    }
</script>
</body>

</html>