<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/10/2022
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Review Orders</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"/>
  <link rel="stylesheet" href="<c:url value='/templates/styles/Header.css'/> " />
  <link rel="stylesheet" href="<c:url value='/templates/styles/AccountPage.css'/> " />
  <link rel="stylesheet" href="<c:url value='/templates/styles/Footer.css'/> " />

  <style>
    .tab {
      overflow-y: hidden;
      border: 1px solid #ccc;
      background-color: #f1f1f1;
    }

    /* Style the buttons inside the tab */
    .tab button {
      background-color: inherit;
      float: left;
      border: none;
      outline: none;
      cursor: pointer;
      padding: 14px 16px;
      transition: 0.3s;
      font-size: 17px;
    }

    /* Change background color of buttons on hover */
    .tab button:hover {
      background-color: #1a94ff;
      color: #FFFFFF;
    }

    /* Create an active/current tablink class */
    .tab button.active {
      background-color: #ccc;
    }

    /* Style the tab content */
    .tabcontent {
      display: none;
      padding: 6px 12px;
      border: 1px solid #ccc;
      border-top: none;
    }

    .btn_blue {
      background-color: #d74545;
      padding: 12px 2px;
      width: 60px;
      border-radius: 5px;
      color: #FFFFFF;
    }

    .btn_blue:hover {
      opacity: 0.8;
    }
  </style>
</head>
<body>
<%@include file="/common/web/header.jsp"%>

<!--------- end header---------- -->
<!---------reviewOrders----------->
<div id="content">
  <div class="wrapper">
    <div class="form_ctrl">
      <div class="acc_ctrl m_r12">
        <h2>
          T??i kho???n</h2>
        <div class="list_ctrl">
          <ul>
            <li class="first">
              <a id="account" title="Th??ng tin t??i kho???n" href="/account?action=account">Th??ng tin t??i
                kho???n</a></li>
            <li class="first">
              <a id="changePassword" title="?????i m???t kh???u" href="/account?action=changePassword">?????i
                m???t kh???u</a></li>
            <li class="first active">
              <a id="reviewOrders" title="Xem l???i ????n h??ng" href="/account?action=reviewOrders">Xem
                l???i ????n h??ng</a></li>
            <li class="first">
              <a id="logout" title="????ng xu???t" href="/logout?action=logout">????ng xu???t</a>
            </li>
          </ul>
        </div>
      </div>
      <div class="col_1_1">
        <div class="order-box">
          <div class="order-box-header">
            <div class="order-box-header-left">
              Th??ng tin ????n h??ng
            </div>
<%--            <div class="clear">--%>
<%--              C??c h??a ????n--%>
<%--            </div>--%>
          </div>
          <div class="paging">
            <div class="tab">
              <button class="tablinks" onclick="openCity(event, 'ChoXacNhan')">Ch??? x??c nh???n</button>
              <button class="tablinks" onclick="openCity(event, 'ChoLayHang')">Ch??? l???y h??ng</button>
              <button class="tablinks" onclick="openCity(event, 'DangGiao')">??ang giao</button>
              <button class="tablinks" onclick="openCity(event, 'DanhGia')">????nh gi??</button>
              <button class="tablinks" onclick="openCity(event, 'DonHangDaMua')">????n h??ng ???? mua</button>
            </div>

            <c:if test="${not empty message}">
              <div class="alert alert-${alert}" role="alert">
                  ${message}
              </div>
            </c:if>
            <c:if test="${orderSuccess == '1'}">
              <div class="alert alert-success" role="alert">
                  ?????t h??ng th??nh c??ng
              </div>
            </c:if>
            <div id="ChoXacNhan" class="tabcontent">
              <table class="table">
                <thead>
                <tr>
                  <th scope="col">M?? ????n h??ng</th>
                  <th scope="col">T??n s???n ph???m</th>
                  <th scope="col">???nh</th>
                  <th scope="col">S??? l?????ng</th>
                  <th scope="col">T???ng ti???n</th>
                  <th scope="col">T??nh tr???ng</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="billD" items="${listBillDeliverByIdOrder}">
                  <tr>
                    <th scope="1">${billD.idOrder}</th>
                    <td>${billD.name}</td>
                    <td><img style="height: 50px" src="${billD.image}"></td>
                    <td>${billD.quantity}</td>
                    <td>${billD.totalPrice}</td>
                    <td><a class="btn_blue" href="/cancelOrder?id=${billD.idOrder}">H???y ????n</a></td>
                  </tr>
                </c:forEach>


                </tbody>
              </table>
            </div>

            <div id="ChoLayHang" class="tabcontent">

              <table class="table">
              <thead>
              <tr>
                <th scope="col">M?? ????n h??ng</th>
                <th scope="col">T??n s???n ph???m</th>
                <th scope="col">???nh</th>
                <th scope="col">S??? l?????ng</th>
                <th scope="col">T???ng ti???n</th>
                <th scope="col">T??nh tr???ng</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="billW" items="${listBillWarByIdOrder}">
                <tr>
                  <th scope="1">${billW.idOrder}</th>
                  <td>${billW.name}</td>
                  <td><img style="height: 50px" src="${billW.image}"></td>
                  <td>${billW.quantity}</td>
                  <td>${billW.totalPrice}</td>
                  <td><a class="btn_blue" href="/cancelOrder?id=${billW.idOrder}">H???y ????n</a></td>
                </tr>
              </c:forEach>

              </tbody>
            </table>
            </div>

            <div id="DangGiao" class="tabcontent">

              <table class="table">
                <thead>
                <tr>
                  <th scope="col">M?? ????n h??ng</th>
                  <th scope="col">T??n s???n ph???m</th>
                  <th scope="col">???nh</th>
                  <th scope="col">S??? l?????ng</th>
                  <th scope="col">T???ng ti???n</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="billL" items="${listBillDelivByIdOrder}">
                  <tr>
                    <th scope="1">${billL.idOrder}</th>
                    <td>${billL.name}</td>
                    <td><img style="height: 50px" src="${billL.image}"></td>
                    <td>${billL.quantity}</td>
                    <td>${billL.totalPrice}</td>
                  </tr>
                </c:forEach>

                </tbody>
              </table>
            </div>
            <div id="DanhGia" class="tabcontent">
              <table class="table">
                <thead>
                <tr>
                  <th scope="col">M?? ????n h??ng</th>
                  <th scope="col">T??n s???n ph???m</th>
                  <th scope="col">???nh</th>
                  <th scope="col">S??? l?????ng</th>
                  <th scope="col">T???ng ti???n</th>
                  <th scope="col">T??nh tr???ng</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="billR" items="${listBillRateByIdOrder}">
                  <tr>
                    <th scope="1">${billR.idOrder}</th>
                    <td>${billR.name}</td>
                    <td><img style="height: 50px" src="${billR.image}"></td>
                    <td>${billR.quantity}</td>
                    <td>${billR.totalPrice}</td>
                    <td><a class="btn_blue" href="/rate?id=${billR.idOrder}&idBook=${billR.idBook}">????nh gi??</a></td>
                  </tr>
                </c:forEach>

                </tbody>
              </table>
            </div>
            <div id="DonHangDaMua" class="tabcontent">
              <table class="table">
                <thead>
                <tr>
                  <th scope="col">M?? ????n h??ng</th>
                  <th scope="col">T??n s???n ph???m</th>
                  <th scope="col">???nh</th>
                  <th scope="col">S??? l?????ng</th>
                  <th scope="col">T???ng ti???n</th>
                  <th scope="col">T??nh tr???ng</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="billH" items="${listBillByIdOrder}">
                  <tr>
                    <th scope="1">${billH.idOrder}</th>
                    <td>${billH.name}</td>
                    <td><img style="height: 50px" src="${billH.image}"></td>
                    <td>${billH.quantity}</td>
                    <td>${billH.totalPrice}</td>
                    <td><a class="btn_blue" href="/products/product-detail?id=${billH.idBook}">Mua l???i</a></td>
                  </tr>
                </c:forEach>

                </tbody>
              </table>
            </div>
          </div>
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
<script src="/templates/scripts/.js"></script>
<script src="/templates/scripts/header.js"></script>
<script>
  function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
  }
</script>
</body>
</html>
