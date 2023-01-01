<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/11/2022
  Time: 8:54 AM
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
  <link rel="stylesheet" href="/templates/styles/Transport.css">
  <link rel="stylesheet" href="/templates/styles/Footer.css">
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
        <li class="breadcrumb-item"><a class="chang_font" href="home.html">Trang chủ</a></li>
        <li class="breadcrumb-item active"><a href="vanhocnuocngoai.html">Phương thức vận chuyển</a></li>
      </ul>
    </nav>
    <div class="wrapper">
      <h1>PHƯƠNG THỨC VẬN CHUYỂN</h1>
    </div>
    <div class="content_container">
      <p><span style="font-size:16px">1. Trách nhiệm xử lý đơn hàng và vận chuyển sản phẩm đến khách hàng
                        do&nbsp;<strong>doraemon.vn</strong>&nbsp;đảm nhận và phụ thuộc vào hình thức thanh toán và vận
                        chuyển cho các sản phẩm mà khách hàng khai báo khi tạo đơn hàng.</span></p>
      <p><span style="font-size:16px">&nbsp;2.&nbsp;<strong>doraemon.vn</strong>&nbsp;sẽ chịu trách nhiệm đảm
                        bảo khách hàng nhận được hàng hóa đúng như đã đặt mua trong thờigian giao hàng như cam kết.
                        Trường hợp hàng hóa bị lỗi, hư hại trong quá trình vận
                        chuyển,&nbsp;<strong>doraemon.vn</strong>&nbsp;sẽ chấp nhận việc đổi hàng mới cho khách.</span>
      </p>
      <p><span style="font-size:16px">&nbsp;3. Trong trường hợp khách hàng tự ý hủy đơn hàng hoặc đơn hàng
                        hoàn thành nhưng không giao cho khách hàng được vì lý do thông tin liên lạc không chính
                        xác,&nbsp;<strong>doraemon.vn</strong>&nbsp;sẽ hủy đơn hàng đó.</span></p>
      <p><span style="font-size:16px">&nbsp;4. Với những đơn hàng trả thanh toán trước:
                        <strong>doraemon.vn</strong>&nbsp;sẽ xác nhận và tiến hành gửi hàng đi sau khi nhận được thanh
                        toán từ phía quý khách. Vì vậy để sớm nhận được hàng, quý khách vui lòng tiến hành thủ tục
                        chuyển tiền sớm.</span></p>
      <p><span style="font-size:16px">&nbsp;5. Trong trường hợp vì lý do bất khả kháng, thời gian giao hàng bị
                        chậm so với thời gian quy định,&nbsp;<strong>doraemon.vn</strong>&nbsp;sẽ thông báo đến khách
                        hàng.&nbsp;</span></p>
      <p><span style="font-size:16px">6. <strong>doraemon.vn </strong>giao hàng qua đơn vị vận chuyển GHN, GHTK,
                        Viettel Post, Grab Express</span></p>
      <p><span style="font-size:16px"><strong>&nbsp;*&nbsp;Thời gian vận chuyển:</strong></span></p>
      <p><span style="font-size:16px"><strong>- Khu vực nội thành Hà Nội và thành phố Hồ Chí Minh
                            :</strong>&nbsp;</span><span style="font-size:16px">Thời gian giao hàng dự kiến là 24 - 48h
                        giờ làm việc tính từ thời điểm đơn hàng được xác nhận (qua email) đối với các đơn vị GHN, GHTK
                        và Viettel Post.&nbsp;</span></p>
      <p><span style="font-size:16px"><strong>- Khu vực khác:</strong>&nbsp;Thời gian dự kiến chậm nhất 72 giờ
                        làm việc.</span></p>
      <p><span style="font-size:16px">&nbsp;(<em>Đối với các đơn hàng có địa chỉ nhận hàng nằm ngoài trung
                            tâm, tỉnh, thị xã, thị trấn vui lòng cộng thêm 2-3 ngày so với thời gian quy định tính theo
                            khu vực)</em><strong>&nbsp;</strong></span></p>
      <p><span style="font-size:16px">7. Phí vận chuyển: Phí vận chuyển được tính theo bảng giá của từng đơn
                        vị vận chuyển</span></p>
      <p> </p>
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