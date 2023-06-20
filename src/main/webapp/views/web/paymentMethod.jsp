<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/11/2022
  Time: 8:48 AM
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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/PayMethod.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Footer.css">
  <title>Phương thức thanh toán</title>
</head>

<body>
<!-- -----------phần header----------------  -->
<%@include file="/common/web/header.jsp"%>
<!--------- end header---------- -->
<div id="content">
  <div class="container">
    <nav id="breadcrumbbar">
      <ul class="breadcrumb">
        <li class="breadcrumb-item"><a class="chang_font" href="home.html">Trang chủ</a></li>
        <li class="breadcrumb-item active"><a href="vanhocnuocngoai.html">Phương thức thanh toán</a></li>
      </ul>
    </nav>
    <div class="wrapper">
      <h1>PHƯƠNG THỨC THANH TOÁN</h1>
    </div>
    <div class="content_container">
      <p><span style="font-size:16px"><strong>1. Chuyển khoản qua ngân hàng</strong></span></p>
      <p><span style="font-size:16px">Xin vui lòng chuyển tiền vào tài khoản của nhà sách Doraemon&nbsp;theo
                        số tài khoản sau:</span><br><span style="font-size:16px">Chủ tài khoản: Công ty TNHH Sách &amp;
                        Lịch Đại Nam</span></p>
      <p><span style="font-size:16px">Số tài khoản:&nbsp;</span><span style="font-size:12.0pt"><span
              style="color:black">115000095671</span></span></p>
      <p><span style="font-size:16px">Ngân hàng:&nbsp;</span><span style="font-size:12.0pt"><span
              style="color:black">Ngân hàng VietinBank - chi nhánh 11 Hồ Chí Minh</span></span></p>
      <p><span style="font-size:16px">(Quý khách vui lòng ghi thông tin theo cú pháp sau trên phần ghi chú CK:
                        Họ tên + mã đơn hàng VD: Nguyen Van A 0235786)</span></p>
      <p><span style="font-size:16px">Ngay sau khi nhận được thông tin về thanh toán chúng tôi sẽ tiến hành
                        chuyển hàng.</span></p>
      <h2><span style="font-size:16px"><strong>2. Thanh toán tiền mặt khi nhận hàng:</strong></span></h2>
      <p><span style="font-size:16px">Thanh toán khi nhận hàng - COD, áp dụng toàn quốc.<br>Khách hàng thanh
                        toán cho nhân viên giao nhận hàng hoá ngay tại thời điểm nhận hàng. Khách hàng vui lòng kiểm tra
                        kỹ sản phẩm trước khi nhận hàng. Trong trường hợp Quý khách nhờ người nhận giúp, vui lòng thông
                        báo số tiền thanh toán cho người nhà.</span></p>
      <p><br><span style="font-size:16px"><strong>Khi cần hỗ trợ hoặc giải đáp thắc mắc, quý khách&nbsp;vui
                            lòng liên hệ:</strong></span></p>
      <p><span style="font-size:16px">Hotline:&nbsp;024.39947159</span></p>
      <p> </p>
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
<script src="${pageContext.request.contextPath}/templates/scripts/header.js"></script>

</body>

</html>
