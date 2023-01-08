<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Quên mật khẩu</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />
  <link rel="stylesheet" href="/templates/styles/Login.css">
  <link rel="stylesheet" href="/templates/styles/Header.css">
  <link rel="stylesheet" href="/templates/styles/Footer.css">

</head>

<body>
<!-- -----------phần header----------------  -->
<%@include file="/common/web/header.jsp"%>

<!--------- end header---------- -->
<!--------- forgotPassword form---------- -->
<div class="forgotPassword">
  <div class="forgotPassword-title">Quên mật khẩu</div>
  <c:if test="${not empty message}">
    <div class="alert alert-${alert}" role="alert">
        ${message}
    </div>
  </c:if>
  <form action="/forgotPassword" class="form_forgotPassword" id="form_forgotPassword" method="post">
    <div class="input ">
      <label>Email</label>
      <input type="text" placeholder="Nhập vào email của bạn" id="email" name="email">
      <i class="fa-solid fa-circle-check"></i>
      <i class="fa-solid fa-circle-xmark"></i>
      <small>Error</small>
    </div>
    <button type="submit" class="btn-forgotPassword">Gửi yêu cầu</button>
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
<script src="/templates/scripts/forgotPassword.js"></script>
<script src="/templates/scripts/header.js"></script>
</body>

</html>
