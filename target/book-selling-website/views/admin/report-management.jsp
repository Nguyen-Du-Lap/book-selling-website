<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Danh sách doanh thu | Quản trị Admin</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Main CSS-->
  <link rel="stylesheet" type="text/css" href="/templates/admin/doc/css/main.css">
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
<%@include file="/common/admin/header.jsp"%>
<%@include file="/common/admin/aside.jsp"%>
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
          <p><b>8580 sản phẩm</b></p>
        </div>
      </div>
    </div>
    <div class="col-md-6 col-lg-3">
      <div class="widget-small warning coloured-icon"><i class='icon fa-3x bx bxs-shopping-bag-alt'></i>
        <div class="info">
          <h4>Tổng đơn hàng</h4>
          <p><b>457 đơn hàng</b></p>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-6 col-lg-3">
      <div class="widget-small primary coloured-icon"><i class='icon fa-3x bx bxs-chart' ></i>
        <div class="info">
          <h4>Tổng thu nhập</h4>
          <p><b>104.890.000 đ</b></p>
        </div>
      </div>
    </div>
    <div class="col-md-6 col-lg-3">
      <div class="widget-small info coloured-icon"><i class='icon fa-3x bx bxs-user-badge' ></i>
        <div class="info">
          <h4>Khách hàng mới</h4>
          <p><b>3 khách hàng</b></p>
        </div>
      </div>
    </div>
    <div class="col-md-6 col-lg-3">
      <div class="widget-small warning coloured-icon"><i class='icon fa-3x bx bxs-tag-x' ></i>
        <div class="info">
          <h4>Hết hàng</h4>
          <p><b>1 sản phẩm</b></p>
        </div>
      </div>
    </div>
    <div class="col-md-6 col-lg-3">
      <div class="widget-small danger coloured-icon"><i class='icon fa-3x bx bxs-receipt' ></i>
        <div class="info">
          <h4>Đơn hàng hủy</h4>
          <p><b>2 đơn hàng</b></p>
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
            <tr>
              <td>8936071672704</td>
              <td>Tôi vẽ - Phương pháp tự học vẽ truyện tranh</td>
              <td>80.000 đ</td>
              <td>Sách tâm lý - kỹ năng sống</td>
            </tr>
            <tr>
              <td>8936203360776</td>
              <td>Việt Nam sử lược (ấn bản kỉ niệm 100 năm xuất bản lần đầu)</td>
              <td>360.000 đ</td>
              <td>Lịch sử - địa lý - tôn giáo</td>
            </tr>
            <tr>
              <td>8938535959000</td>
              <td>Storytelling with data - Kể chuyện thông qua dữ liệu</td>
              <td>271.150 đ</td>
              <td>Khoa học kỹ thuật</td>
            </tr>
            <tr>
              <td>8936170870049</td>
              <td>Digital Marketing - Từ chiến lược đến thực thi</td>
              <td>198.000 đ</td>
              <td>Sách Kinh tế</td>
            </tr>
            <tr>
              <td>9786043654868</td>
              <td>Can Trường Bước Tiếp (Tái bản 2021)</td>
              <td>80.100 đ</td>
              <td>Sách văn học trong nước</td>
            </tr>
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
              <th>Đơn hàng</th>
              <th>Số lượng</th>
              <th>Tổng tiền</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>MD0837</td>
              <td>Triệu Thanh Phú</td>
              <td>Tôi vẽ - Phương pháp tự học vẽ truyện tranh, Storytelling with data - Kể chuyện thông qua dữ liệu</td>
              <td>2 sản phẩm</td>
              <td>360.000 đ</td>
            </tr>
            <tr>
              <td>MĐ8265</td>
              <td>Nguyễn Thị Ngọc Cẩm</td>
              <td>25++ Hoạt Động Rèn Luyện Trí Sáng Tạo Và Tư Duy Cho Trẻ (Cuốn Lẻ Và Combo)</td>
              <td>1 sản phẩm</td>
              <td>80.000 đ</td>
            </tr>
            <tr>
              <td>MT9835</td>
              <td>Đặng Hoàng Phúc</td>
              <td>Án mạng mười một chữ, Ấn ức trắng, 81 án Tây Du - Tây Vực Liệt Vương ký - tập 3</td>
              <td>3 sản phẩm</td>
              <td>650.000 đ</td>
            </tr>
            <tr>
              <td>ER3835</td>
              <td>Nguyễn Thị Mỹ Yến</td>
              <td>Khỏi bệnh không cần thuốc</td>
              <td>1 sản phẩm</td>
              <td>190.000 đ</td>
            </tr>
            <tr>
              <td>AL3947</td>
              <td>Phạm Thị Ngọc</td>
              <td>Infographics - Bách khoa tri thức bằng đồ họa cho trẻ em, Vườn ươm trí tuệ (Bộ 4 cuốn)</td>
              <td>2 sản phẩm</td>
              <td>170.000 đ</td>
            </tr>
            <tr>
              <td>QY8723</td>
              <td>Ngô Thái An</td>
              <td>Hãy nhắm mắt khi anh đến</td>
              <td>1 sản phẩm</td>
              <td>500.000 đ</td>
            </tr>
            <tr>
              <th colspan="4">Tổng cộng:</th>
              <td>1.950.000 đ</td>
            </tr>
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
              <th>Ảnh</th>
              <th>Số lượng</th>
              <th>Tình trạng</th>
              <th>Giá tiền</th>
              <th>Danh mục</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>8934974181200</td>
              <td>Xa Ngoài Kia Nơi Loài Tôm Hát - Where The Crawdads Sing (Bìa Phim)</td>
              <td><img src="/img-sanpham/tu.jpg" alt="" width="100px;"></td>
              <td>0</td>
              <td><span class="badge bg-danger">Hết hàng</span></td>
              <td>148.500 đ</td>
              <td>Sách văn học nước ngoài</td>
            </tr>
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
<script src="/templates/admin/doc/js/jquery-3.2.1.min.js"></script>
<script src="/templates/admin/doc/js/popper.min.js"></script>
<script src="/templates/admin/doc/js/bootstrap.min.js"></script>
<script src="/templates/admin/doc/js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="/templates/admin/doc/js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script type="text/javascript" src="/templates/admin/doc/js/plugins/chart.js"></script>
<script type="text/javascript">
  var data = {
    labels: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
    datasets: [{
      label: "Dữ liệu đầu tiên",
      fillColor: "rgba(255, 255, 255, 0.158)",
      strokeColor: "black",
      pointColor: "rgb(220, 64, 59)",
      pointStrokeColor: "#fff",
      pointHighlightFill: "#fff",
      pointHighlightStroke: "green",
      data: [20, 59, 90, 51, 56, 100, 40, 60, 78, 53, 33, 81]
    },
      {
        label: "Dữ liệu kế tiếp",
        fillColor: "rgba(255, 255, 255, 0.158)",
        strokeColor: "rgb(220, 64, 59)",
        pointColor: "black",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "green",
        data: [48, 48, 49, 39, 86, 10, 50, 70, 60, 70, 75, 90]
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
