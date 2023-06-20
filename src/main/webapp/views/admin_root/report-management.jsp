<%@ include file="/common/taglib.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Danh sách doanh thu | Quản trị Admin</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Main CSS-->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/templates/admin/doc/css/main.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
  <!-- or -->
  <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
  <!-- Font-icon css-->
  <link rel="stylesheet" type="text/css"
        href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

</head>

<body onload="time()" class="app sidebar-mini rtl">
<!-- Navbar-->
<%@include file="/common/admin_root/header.jsp"%>
<%@include file="/common/admin_root/aside.jsp"%>
<main class="app-content">
  <div class="row">
    <div class="col-md-12">
      <div class="app-title">
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><a href="#"><b>Báo cáo doanh thu    </b></a></li>
        </ul>
        <div id="clock"></div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-6 col-lg-3">
      <div class="widget-small info coloured-icon"><i class='icon bx bxs-purchase-tag-alt fa-3x' ></i>
        <div class="info">
          <h4>Tổng sản phẩm</h4>
          <p><b>${tongSanPham}</b></p>
        </div>
      </div>
    </div>
    <div class="col-md-6 col-lg-3">
      <div class="widget-small warning coloured-icon"><i class='icon fa-3x bx bxs-shopping-bag-alt'></i>
        <div class="info">
          <h4>Tổng đơn hàng</h4>
          <p><b>${tongDonHang}</b></p>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-6 col-lg-3">
      <div class="widget-small primary coloured-icon"><i class='icon fa-3x bx bxs-chart' ></i>
        <div class="info">
          <h4>Tổng thu nhập</h4>
          <p><b>${tongThuNhap} đ</b></p>
        </div>
      </div>
    </div>
    <div class="col-md-6 col-lg-3">
      <div class="widget-small info coloured-icon"><i class='icon fa-3x bx bxs-user-badge' ></i>
        <div class="info">
          <h4>Khách hàng mới</h4>
          <p><b>${khachHangMoi} khách hàng</b></p>
        </div>
      </div>
    </div>
    <div class="col-md-6 col-lg-3">
      <div class="widget-small warning coloured-icon"><i class='icon fa-3x bx bxs-tag-x' ></i>
        <div class="info">
          <h4>Hết hàng</h4>
          <p><b>${sanPhamHetHang} sản phẩm</b></p>
        </div>
      </div>
    </div>
    <div class="col-md-6 col-lg-3">
      <div class="widget-small danger coloured-icon"><i class='icon fa-3x bx bxs-receipt' ></i>
        <div class="info">
          <h4>Đơn hàng hủy</h4>
          <p><b>${donHangDaHuy} đơn hàng</b></p>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="tile">
        <div>
          <h3 class="tile-title">SẢN PHẨM BÁN CHẠY</h3>
        </div>
        <div class="tile-body">
          <table class="table table-hover table-bordered" id="sampleTable">
            <thead>
            <tr>
              <th>Mã sản phẩm</th>
              <th>Tên sản phẩm</th>
              <th>Giá tiền</th>
              <th>Danh mục</th>
            </tr>
            </thead>
            <tbody>
            <C:forEach var="book" items="${listSanPhamBanChay}">
              <tr>
                <td>${book.getIdBook()}</td>
                <td>${book.getName()}</td>
                <td>${book.getPrice()} đ</td>
                <td>${book.getCatalog()}</td>
              </tr>
            </C:forEach>


            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="tile">
        <div>
          <h3 class="tile-title">TỔNG ĐƠN HÀNG</h3>
        </div>
        <div class="tile-body">
          <table class="table table-hover table-bordered" id="sampleTable">
            <thead>
            <tr>
              <th>ID đơn hàng</th>
              <th>Khách hàng</th>
              <th>Thời gian đặt hàng</th>
              <th>Tiền giao hàng</th>
              <th>Tổng tiền</th>
            </tr>
            </thead>
            <tbody>
            <C:forEach var="cart" items="${listTongDonHang}">
              <tr>
                <td>${cart.id}</td>
                <td>${cart.idUser}</td>
                <td>${cart.createTime} đ</td>
                <td>${cart.ship}</td>
                <td>${cart.getTotalPriceFromCart()}</td>
              </tr>
            </C:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="tile">
        <div>
          <h3 class="tile-title">SẢN PHẨM ĐÃ HẾT</h3>
        </div>
        <div class="tile-body">
          <table class="table table-hover table-bordered" id="sampleTable">
            <thead>
            <tr>
              <th>Mã sản phẩm</th>
              <th>Tên sản phẩm</th>
              <th>Tình trạng</th>
              <th>Giá tiền</th>
              <th>Danh mục</th>
            </tr>
            </thead>
            <tbody>
            <C:forEach var="book" items="${listSanPhamHetHang}">
              <tr>
                <td>${book.getIdBook()}</td>
                <td>${book.getName()}</td>
                <td>Hết hàng</td>
                <td>${book.getPrice()} đ</td>
                <td>${book.getCatalog()}</td>
              </tr>
            </C:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-6">
      <div class="tile">
        <h3 class="tile-title">DỮ LIỆU HÀNG THÁNG</h3>
        <div class="embed-responsive embed-responsive-16by9">
          <canvas class="embed-responsive-item" id="lineChartDemo"></canvas>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="tile">
        <h3 class="tile-title">THỐNG KÊ DOANH SỐ</h3>
        <div class="embed-responsive embed-responsive-16by9">
          <canvas class="embed-responsive-item" id="barChartDemo"></canvas>
        </div>
      </div>
    </div>
  </div>

  <div class="text-right" style="font-size: 12px">
    <p><b>Hệ thống quản lý V2.0 | Code by Trường</b></p>
  </div>
</main>
<!-- Essential javascripts for application to work-->
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script type="text/javascript" src="${pageContext.request.contextPath}/templates/admin/doc/js/plugins/chart.js"></script>
<script type="text/javascript">
  var data = {
    labels: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
    datasets: [{
      label: "Số tiền chi tiêu",
      fillColor: "rgba(255, 255, 255, 0.158)",
      strokeColor: "black",
      pointColor: "rgb(220, 64, 59)",
      pointStrokeColor: "#fff",
      pointHighlightFill: "#fff",
      pointHighlightStroke: "green",
      data: [${nhapHang.getT1()}, ${nhapHang.getT2()}, ${nhapHang.getT3()}, ${nhapHang.getT4()}, ${nhapHang.getT5()}, ${nhapHang.getT6()}, ${nhapHang.getT7()},
        ${nhapHang.getT8()}, ${nhapHang.getT9()}, ${nhapHang.getT10()}, ${nhapHang.getT11()}, ${nhapHang.getT12()}]
    },
      {
        label: "Số tiền bán ra",
        fillColor: "rgba(255, 255, 255, 0.158)",
        strokeColor: "rgb(220, 64, 59)",
        pointColor: "black",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "green",
        data: [${xuatHang.getT1()}, ${xuatHang.getT2()}, ${xuatHang.getT3()}, ${xuatHang.getT4()}, ${xuatHang.getT5()}, ${xuatHang.getT6()}, ${xuatHang.getT7()},
          ${xuatHang.getT8()}, ${xuatHang.getT9()}, ${xuatHang.getT10()}, ${xuatHang.getT11()}, ${xuatHang.getT12()}]
      }
    ]
  };


  var ctxl = $("#lineChartDemo").get(0).getContext("2d");
  var lineChart = new Chart(ctxl).Line(data);

  var ctxb = $("#barChartDemo").get(0).getContext("2d");
  var barChart = new Chart(ctxb).Bar(data);
</script>
<!-- Google analytics script-->
<script type="text/javascript">
  if (document.location.hostname == 'pratikborsadiya.in') {
    (function (i, s, o, g, r, a, m) {
      i['GoogleAnalyticsObject'] = r;
      i[r] = i[r] || function () {
        (i[r].q = i[r].q || []).push(arguments)
      }, i[r].l = 1 * new Date();
      a = s.createElement(o),
              m = s.getElementsByTagName(o)[0];
      a.async = 1;
      a.src = g;
      m.parentNode.insertBefore(a, m)
    })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
    ga('create', 'UA-72504830-1', 'auto');
    ga('send', 'pageview');
  }
</script>
</body>

</html>