<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/12/2022
  Time: 11:41 AM
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
  <link rel="stylesheet" href="/templates/styles/Header.css">
  <link rel="stylesheet" href="/templates/styles/GuideOrder.css">
  <link rel="stylesheet" href="/templates/styles/Footer.css">
  <title>Hướng dẫn mua hàng</title>
</head>

<body>
<!-- -----------phần header----------------  -->
<%@include file="/common/web/header.jsp"%>
<!--------- end header---------- -->
<div id="content">
  <div class="container">
    <nav id="breadcrumbbar">
      <ul class="breadcrumb">
        <li class="breadcrumb-item"><a class="chang_font" href="/home">Trang chủ</a></li>
        <li class="breadcrumb-item active"><a href="">Hướng dẫn mua hàng</a></li>
      </ul>
    </nav>
    <div class="wrapper">
      <h1>HƯỚNG DẪN MUA HÀNG</h1>
    </div>
    <div class="content_container">
      <h1>Hướng Dẫn Mua Hàng</h1>
      <div class="rte">
        <p><span style="font-size:16px">Quý Khách hàng có thể chọn một trong hai cách
                            sau:<br><br><strong>Cách thứ nhất:&nbsp;</strong></span></p>
        <p><span style="font-size:16px">Gọi điện thoại đến số hotline&nbsp;024.39947159 từ thứ 2 - thứ 6 (9h
                            -18h)&nbsp;hoặc liên hệ fanpage <a target="_blank"
                                                               href="https://www.facebook.com/cachep.vn">Nhà sách Cá Chép</a>,&nbsp;nhân viên của công
                            ty sẽ tư vấn và hỗ trợ cho khách hàng tất cả các thông tin về sản phẩm và dịch
                            vụ.<br><br><strong>Cách thứ hai:&nbsp;</strong></span></p>
        <p><span style="font-size:16px">Đặt hàng qua website:&nbsp;</span></p>
        <p><br><span style="font-size:16px">Bước 1: Bấm vào nút “Thêm vào giỏ hàng” để đưa sản phẩm vào giỏ
                            hàng sau khi đã lựa chọn sản phẩm mình muốn mua</span></p>
        <p style="text-align: center; width: 700px;"><img style="width:100%"
                src="/templates/images/huongdandathang/huong-dan-dat-hang-1.png"></p>
        <p> </p>
        <p><br><span style="font-size:16px">Bước 2: Có thể nhấm vào mua sản phẩm trực tiếp ở đây bỏ qua bước 3</span></p>
        <p style="text-align: center;width: 700px;"><img style="width:100%"
                src="/templates/images/huongdandathang/huong-dan-dat-hang-2.png"></p>
        <p><br><span style="font-size:16px">Bước 3: Vào giỏ hàng để tiếp tục bấm vào mua hàng</span></p>
        <p style="text-align: center;width: 700px;"><img style="width:100%"
                src="/templates/images/huongdandathang/huong-dan-dat-hang-3.png"></p>
        <p><span style="font-size:16px">Bước 4: Điền thông tin nhận hàng của bạn và chọn hình thức "Giao
                            hàng" hay "Nhận hàng tại cửa hàng"</span></p>
        <p style="text-align: center;width: 700px;"><img style="width:100%"
                src="/templates/images/huongdandathang/huong-dan-dat-hang-4.png"></p>
        <p><span style="font-size:16px">Bước 5: Lựa chọn Phương thức vận chuyển và Phương thức thanh
                            toán</span></p>
        <p style="text-align: center;width: 700px;"><img style="width:100%"
                src="/templates/images/huongdandathang/huong-dan-dat-hang-5.png"></p>
        <p><span style="font-size:16px">Bước 6: Nhấp "Đặt hàng"</span></p>
        <p><br><span style="font-size:16px">Đơn hàng của bạn đã hoàn tất và được chuyển tới chúng tôi. Chúng
                            tôi&nbsp;sẽ xử lý và liên lạc lại với bạn để thực hiện giao dịch.</span></p>
        <p><span style="font-size:16px">Quý khách cần hỗ trợ về đặt hàng, vui lòng liên hệ
                            hotline&nbsp;024.39947159 từ thứ 2 - thứ 6 (9h - 18h) hoặc fanpage <a target="_blank"
                                                                                                  href="/home">Nhà sách Doraemon</a>.</span></p>
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
<script src="/templates/scripts/header.js"></script>

</body>

</html>
