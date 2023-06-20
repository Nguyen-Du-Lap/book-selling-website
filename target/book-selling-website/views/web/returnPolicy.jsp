<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/11/2022
  Time: 8:51 AM
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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/ReturnPolicy.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Footer.css">
  <title>Chính sách đổi trả</title>
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
        <li class="breadcrumb-item active"><a href="vanhocnuocngoai.html">Chính sách đổi trả</a></li>
      </ul>
    </nav>
    <div class="wrapper">
      <h1>CHÍNH SÁCH ĐỔI TRẢ</h1>
    </div>
    <div class="content_container">
      <p><span style="font-size:16px"><strong>1. Điều kiện đổi trả</strong></span></p>
      <p><span style="font-size:16px">Quý Khách hàng cần kiểm tra tình trạng hàng hóa và có thể đổi hàng/ trả
                        lại hàng&nbsp;ngay tại thời điểm giao/nhận hàng&nbsp;trong những trường hợp sau:</span></p>
      <ul>
        <li>-<span style="font-size:16px">Hàng không đúng chủng loại, mẫu mã trong đơn hàng đã đặt hoặc như
                            trên website tại thời điểm đặt hàng.</span></li>
        <li>-<span style="font-size:16px">Không đủ số lượng, không đủ bộ như trong đơn hàng.</span></li>
        <li>-<span style="font-size:16px">Tình trạng bên ngoài bị ảnh hưởng như rách bao bì, bong tróc, bể
                            vỡ…</span></li>
      </ul>
      <p><span style="font-size:16px">Khách hàng có trách nhiệm trình giấy tờ liên quan chứng minh sự thiếu
                        sót trên để hoàn thành việc&nbsp;hoàn trả/đổi trả hàng hóa.&nbsp;</span></p>
      <p><span style="font-size:16px"><strong>2. Quy định về thời gian thông báo và gửi sản phẩm đổi
                            trả</strong></span></p>
      <ul>
        <li>-<span style="font-size:16px"><strong>Thời gian thông báo đổi trả</strong>:&nbsp;trong vòng 48h
                            kể từ khi nhận sản phẩm đối với trường hợp sản phẩm thiếu phụ kiện, quà tặng hoặc bể
                            vỡ.</span></li>
        <li>-<span style="font-size:16px"><strong>Thời gian gửi chuyển trả sản phẩm</strong>: trong vòng 14
                            ngày kể từ khi nhận sản phẩm.</span></li>
        <li>-<span style="font-size:16px"><strong>Địa điểm đổi trả sản phẩm</strong>: Khách hàng có thể mang
                            hàng trực tiếp đến văn phòng/ cửa hàng của chúng tôi hoặc chuyển qua đường bưu điện.</span>
        </li>
      </ul>
      <div><strong><span style="font-size:16px">3. Hoàn tiền</span></strong></div>
      <div><span style="font-size:16px">Trong trường hợp mặt hàng quý khách đặt mua tại Cachep.vn đã hết và
                        đơn hàng đã được thanh toán trước bằng chuyển khoản và các phương thức khác,&nbsp;Cachep.vn sẽ
                        hoàn tiền cho quý khách thông qua chuyển khoản ngân hàng trong vòng từ 2 - 7 ngày làm
                        việc.</span></div>
      <div> </div>
      <p><span style="font-size:16px;">Trong trường hợp Quý Khách hàng có ý kiến đóng góp/khiếu nại liên quan
                        đến chất lượng sản phẩm, Quý Khách hàng vui lòng liên hệ đường dây chăm sóc khách hàng&nbsp;của
                        chúng tôi. Hotline liên hệ: 024.39947159</span></p>
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
