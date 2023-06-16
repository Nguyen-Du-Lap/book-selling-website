<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/11/2022
  Time: 8:47 AM
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
  <link rel="stylesheet" href="/templates/styles/Contact.css">
  <link rel="stylesheet" href="/templates/styles/Footer.css">
  <title>Liên hệ</title>
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
        <li class="breadcrumb-item active"><a href="vanhocnuocngoai.html">Liên hệ</a></li>
      </ul>
    </nav>
    <div class="wrapper">
      <h1>LIÊN HỆ HỖ TRỢ</h1>
    </div>
    <div>
      <c:if test="${not empty message}">
        <div class="alert alert-${alert}" role="alert">
            ${message}
        </div>
      </c:if>
      <c:if test="${orderSuccess == '1'}">
    </div>
    <div class="content_container">
      <div class="content_left">
        <div class="contact-title">
          <h4>
            Địa chỉ: Khu Phố 6, Thủ Đức, Thành phố Hồ Chí Minh, Việt Nam
          </h4>
        </div>
        <div class="contact-info">
          Khu Phố 6, Thủ Đức, Thành phố Hồ Chí Minh, Việt Nam
        </div>
        <div class="contact-map">
          <!-- <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3919.4966014443853!2d106.68515001480874!3d10.77322576219866!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752f51d7cd3a3f%3A0xc4b3b6a249d60d10!2zTmjDoCBTw6FjaCBDw6EgQ2jDqXAgMS4!5e0!3m2!1svi!2s!4v1602663304254!5m2!1svi!2s" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe> -->
          <!-- <iframe class="gmap_iframe" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?width=600&amp;height=450&amp;hl=en&amp;q=Đại học nông lâm thành phố hồ chí minh&amp;t=&amp;z=14&amp;ie=UTF8&amp;iwloc=B&amp;output=embed"></iframe> -->
          <div class="mapouter"><div class="gmap_canvas"><iframe class="gmap_iframe" width="100%" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?width=600&amp;height=450&amp;hl=en&amp;q=Đại học nông lâm thành phố hồ chí minh&amp;t=p&amp;z=14&amp;ie=UTF8&amp;iwloc=B&amp;output=embed"></iframe><a href="https://formatjson.org/">format json</a></div><style>.mapouter{position:relative;text-align:right;width:100%;height:450px;}.gmap_canvas {overflow:hidden;background:none!important;width:100%;height:450px;}.gmap_iframe {height:450px!important;}</style></div>
        </div>
        <div class="contact-title">
          <h4>
            Số điện thoại: 032 995 2600
          </h4>
        </div>
        <div class="contact-info">
          <a href="tel:(+8424) 39947159">(+8424) 39947159</a>
        </div>
        <div class="contact-title">
          <h4>
            Email: contact@doraemon.vn
          </h4>
        </div>
        <div class="contact-info">
          <a href="mailto:contact@doraemon.vn">contact@doraemon.vn</a>
        </div>
      </div>
      <div class="content_right">
        <form form action="/contact" id="submit_form" method="post">
          <div class="form-group input">
            <input type="text" class="form-control" name="name" placeholder="Họ và tên">
          </div>
          <div class="form-group input">
            <input type="text" class="form-control" name="email" placeholder="Địa chỉ email">
          </div>
          <div class="form-group input">
            <input type="text" class="form-control" name="phone" placeholder="Số điện thoại của bạn">
          </div>
          <div class="form-group input">
                            <textarea class="form-control" name="content" rows="10" cols="20" id="note"
                                      placeholder="Nội dung"></textarea>
          </div>
          <button class="btn_submit" type="submit">Gửi</button>
        </form>
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