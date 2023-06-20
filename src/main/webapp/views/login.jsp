<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <title>Login</title>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <link
          href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700&display=swap"
          rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Login.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Footer.css">
  <style>
    ._4z_d ._4z_f {
      font-size: 16px!important;
      line-height: 14px;
      padding: 2px 6px;
    }
  </style>
</head>

<body>
<%@include file="/common/web/header.jsp"%>

<!--------- end header---------- -->
<!--------- login form---------- -->
<div class="login">
  <div class="login-title">Đăng nhập</div>
  <c:if test="${not empty message}">
    <div class="alert alert-${alert}" role="alert">
        ${message}
    </div>
  </c:if>
  <%--  <form action="/login?action=login" class="form_login" id="form_login" method="post">--%>
  <form action="${pageContext.request.contextPath}/login?action=login" class="form_login"  method="post">
    <div class="input ">
      <label>Email</label>
      <input type="text" name="email" placeholder="Nhập vào email" id="email" onchange="emailOnChange(this.value)">
      <i class="fa-solid fa-circle-check"></i>
      <i class="fa-solid fa-circle-xmark"></i>
      <small>Error</small>
    </div>
    <div class="input ">
      <label>Mật khẩu</label>
      <input type="password" name="password" placeholder="Nhập vào mật khẩu" id="password"
             onchange="passwordOnChange(this.value)">
      <i class="fa-solid fa-circle-check"></i>
      <i class="fa-solid fa-circle-xmark"></i>
      <small>Error</small>
    </div>
    <a href="/forgotPassword" class="forgotPassword-link">Quên mật khẩu?</a>
    <input type="hidden" name="action" value="login" >
    <button type="submit" class="btn-login">Đăng nhập</button>
    <fb:login-button class="social-button" id="facebook-login"  scope="public_profile,email" onlogin="checkLoginState();">
      <div>
        <span>Đăng nhập bằng Facebook</span>
        <i class="fa-brands fa-facebook-f" style="margin-left: 5px;"></i>
      </div>
    </fb:login-button>

    <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid &redirect_uri=http://localhost:8080/book_selling_website/login-google&response_type=code
    &client_id=190006557334-854148cd78ttffl1gh6fdtfkjpo5fi52.apps.googleusercontent.com&approval_prompt=force" class="social-button" id="google-login">
      <span>Đăng nhập bằng Google</span>
      <i class="fa-brands fa-google-plus-g" style="margin-left: 5px;"></i>
    </a>
    <p style="margin-top: 50px; margin-bottom: 20px; padding-bottom: 20px; color: #aaaaaa; text-align: center;">
      Bạn chưa có tài khoản? <a href="${pageContext.request.contextPath}/signup" class="signUp-link">Đăng ký ngay</a></p>
  </form>
</div>
<!-----end login---->
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
<script src="/templates/scripts/login.js"></script>
<script src="/templates/scripts/header.js"></script>
<script>
  // Get the modal
  var modal = document.getElementById('id01');
  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
</script>
<!-- script dang nhap bang facebook -->
<script>
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    if (response.status === 'connected') {
      testAPI();
    } else {
      document.getElementById('status').innerHTML = 'Please log ' +
              'into this app.';
    }
  }

  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
    FB.api('/me',{fields: ' name, email'}, function(response) {
      window.location.href = 'loginFacebookController?action=Face&name='+response.name+'&email='+response.email+'&id='+response.id;
    });
  }

  window.fbAsyncInit = function() {
    FB.init({
      appId      : '136481452727730',
      cookie     : true,
      xfbml      : true,
      version    : 'v2.9'
    });


    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });

  };

  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
              'Thanks for logging in, ' + response.name + '!';
    });
  }
</script>
</body>

</html>