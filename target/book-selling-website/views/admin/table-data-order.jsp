<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Danh sách đơn hàng | Quản trị Admin</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Main CSS-->
  <!--  <link rel="stylesheet" href="../css/style.css">-->
  <link rel="stylesheet" type="text/css" href="/templates/admin/doc/css/main.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
  <!-- or -->
  <!--  <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">-->

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
  <div class="app-title">
    <ul class="app-breadcrumb breadcrumb side">
      <li class="breadcrumb-item active"><a href="#"><b>Danh sách đơn hàng</b></a></li>
    </ul>
    <div id="clock"></div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="tile">
        <div class="tile-body">
          <div class="row element-button">
            <div class="col-sm-2">
              <a class="btn btn-delete btn-sm nhap-tu-file" type="button" title="Nhập" onclick="myFunction(this)"><i
                      class="fas fa-file-upload"></i> Tải từ file</a>
            </div>

            <div class="col-sm-2">
              <a class="btn btn-delete btn-sm print-file" type="button" title="In" onclick="myApp.printTable()"><i
                      class="fas fa-print"></i> In dữ liệu</a>
            </div>
            <div class="col-sm-2">
              <a class="btn btn-delete btn-sm print-file js-textareacopybtn" type="button" title="Sao chép"><i
                      class="fas fa-copy"></i> Sao chép</a>
            </div>

            <div class="col-sm-2">
              <a class="btn btn-excel btn-sm" href="" title="In"><i class="fas fa-file-excel"></i> Xuất Excel</a>
            </div>
            <div class="col-sm-2">
              <a class="btn btn-delete btn-sm pdf-file" type="button" title="In" onclick="myFunction(this)"><i
                      class="fas fa-file-pdf"></i> Xuất PDF</a>
            </div>
            <div class="col-sm-2">
              <a class="btn btn-delete btn-sm" type="button" title="Xóa" onclick="myFunction(this)"><i
                      class="fas fa-trash-alt"></i> Xóa tất cả </a>
            </div>
          </div>
          <table class="table table-hover table-bordered" id="sampleTable">
            <thead>
            <tr>
              <th width="10"><input type="checkbox" id="all"></th>
              <th>ID đơn hàng</th>
              <th>Khách hàng</th>
              <th>Đơn hàng</th>
              <th>Số lượng</th>
              <th>Tổng tiền</th>
              <th>Tình trạng</th>
              <th>Tính năng</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td width="10"><input type="checkbox" name="check1" value="1"></td>
              <td>MD0837</td>
              <td>Triệu Thanh Phú</td>
              <td>Tôi vẽ - Phương pháp tự học vẽ truyện tranh, Storytelling with data - Kể chuyện thông qua dữ liệu</td>
              <td>2</td>
              <td>360.000 đ</td>
              <td><span class="badge bg-success">Hoàn thành</span></td>
              <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa"><i class="fas fa-trash-alt"></i> </button>
                <button class="btn btn-primary btn-sm edit" type="button" title="Sửa"><i class="fa fa-edit"></i></button></td>
            </tr>
            <tr>
              <td width="10"><input type="checkbox" name="check1" value="1"></td>
              <td>MĐ8265</td>
              <td>Nguyễn Thị Ngọc Cẩm</td>
              <td>25++ Hoạt Động Rèn Luyện Trí Sáng Tạo Và Tư Duy Cho Trẻ (Cuốn Lẻ Và Combo)</td>
              <td>1</td>
              <td>80.000 đ</td>
              <td><span class="badge bg-success">Hoàn thành</span></td>
              <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa"><i class="fas fa-trash-alt"></i> </button>
                <button class="btn btn-primary btn-sm edit" type="button" title="Sửa"><i class="fa fa-edit"></i></button></td>
            </tr>
            <tr>
              <td width="10"><input type="checkbox" name="check1" value="1"></td>
              <td>MT9835</td>
              <td>Đặng Hoàng Phúc</td>
              <td>Án mạng mười một chữ, Ấn ức trắng, 81 án Tây Du - Tây Vực Liệt Vương ký - tập 3</td>
              <td>3 </td>
              <td>650.000 đ</td>
              <td><span class="badge bg-success">Hoàn thành</span></td>
              <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa"><i class="fas fa-trash-alt"></i> </button>
                <button class="btn btn-primary btn-sm edit" type="button" title="Sửa"><i class="fa fa-edit"></i></button></td>
            </tr>
            <tr>
              <td width="10"><input type="checkbox" name="check1" value="1"></td>
              <td>ER3835</td>
              <td>Nguyễn Thị Mỹ Yến</td>
              <td>Khỏi bệnh không cần thuốc</td>
              <td>1 </td>
              <td>190.000 đ</td>
              <td><span class="badge bg-info">Chờ thanh toán</span></td>
              <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa"><i class="fas fa-trash-alt"></i> </button>
                <button class="btn btn-primary btn-sm edit" type="button" title="Sửa"><i class="fa fa-edit"></i></button></td>
            </tr>
            <tr>
              <td width="10"><input type="checkbox" name="check1" value="1"></td>
              <td>AL3947</td>
              <td>Phạm Thị Ngọc</td>
              <td>Infographics - Bách khoa tri thức bằng đồ họa cho trẻ em, Vườn ươm trí tuệ (Bộ 4 cuốn)</td>
              <td>2 </td>
              <td>170.000 đ</td>
              <td><span class="badge bg-warning">Đang giao hàng</span></td>
              <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa"><i class="fas fa-trash-alt"></i> </button>
                <button class="btn btn-primary btn-sm edit" type="button" title="Sửa"><i class="fa fa-edit"></i></button></td>
            </tr>
            <tr>
              <td width="10"><input type="checkbox" name="check1" value="1"></td>
              <td>QY8723</td>
              <td>Ngô Thái An</td>
              <td>Hãy nhắm mắt khi anh đến</td>
              <td>1 </td>
              <td>500.000 đ</td>
              <td><span class="badge bg-danger">Đã hủy</span></td>
              <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa"><i class="fas fa-trash-alt"></i> </button>
                <button class="btn btn-primary btn-sm edit" type="button" title="Sửa"><i class="fa fa-edit"></i></button></td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</main>
<!-- Essential javascripts for application to work-->
<script src="/templates/admin/doc/js/jquery-3.2.1.min.js"></script>
<script src="/templates/admin/doc/js/popper.min.js"></script>
<script src="/templates/admin/doc/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="src/jquery.table2excel.js"></script>
<script src="/templates/admin/doc/js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="/templates/admin/doc/js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<!-- Data table plugin-->
<script type="text/javascript" src="/templates/admin/doc/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/templates/admin/doc/js/plugins/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">$('#sampleTable').DataTable();</script>
<script>
  function deleteRow(r) {
    var i = r.parentNode.parentNode.rowIndex;
    document.getElementById("myTable").deleteRow(i);
  }
  jQuery(function () {
    jQuery(".trash").click(function () {
      swal({
        title: "Cảnh báo",

        text: "Bạn có chắc chắn là muốn xóa đơn hàng này?",
        buttons: ["Hủy bỏ", "Đồng ý"],
      })
              .then((willDelete) => {
                if (willDelete) {
                  swal("Đã xóa thành công.!", {

                  });
                }
              });
    });
  });
  oTable = $('#sampleTable').dataTable();
  $('#all').click(function (e) {
    $('#sampleTable tbody :checkbox').prop('checked', $(this).is(':checked'));
    e.stopImmediatePropagation();
  });

  //EXCEL
  // $(document).ready(function () {
  //   $('#').DataTable({

  //     dom: 'Bfrtip',
  //     "buttons": [
  //       'excel'
  //     ]
  //   });
  // });


  //Thời Gian
  function time() {
    var today = new Date();
    var weekday = new Array(7);
    weekday[0] = "Chủ Nhật";
    weekday[1] = "Thứ Hai";
    weekday[2] = "Thứ Ba";
    weekday[3] = "Thứ Tư";
    weekday[4] = "Thứ Năm";
    weekday[5] = "Thứ Sáu";
    weekday[6] = "Thứ Bảy";
    var day = weekday[today.getDay()];
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    nowTime = h + " giờ " + m + " phút " + s + " giây";
    if (dd < 10) {
      dd = '0' + dd
    }
    if (mm < 10) {
      mm = '0' + mm
    }
    today = day + ', ' + dd + '/' + mm + '/' + yyyy;
    tmp = '<span class="date"> ' + today + ' - ' + nowTime +
            '</span>';
    document.getElementById("clock").innerHTML = tmp;
    clocktime = setTimeout("time()", "1000", "Javascript");

    function checkTime(i) {
      if (i < 10) {
        i = "0" + i;
      }
      return i;
    }
  }
  //In dữ liệu
  var myApp = new function () {
    this.printTable = function () {
      var tab = document.getElementById('sampleTable');
      var win = window.open('', '', 'height=700,width=700');
      win.document.write(tab.outerHTML);
      win.document.close();
      win.print();
    }
  }
  //     //Sao chép dữ liệu
  //     var copyTextareaBtn = document.querySelector('.js-textareacopybtn');

  // copyTextareaBtn.addEventListener('click', function(event) {
  //   var copyTextarea = document.querySelector('.js-copytextarea');
  //   copyTextarea.focus();
  //   copyTextarea.select();

  //   try {
  //     var successful = document.execCommand('copy');
  //     var msg = successful ? 'successful' : 'unsuccessful';
  //     console.log('Copying text command was ' + msg);
  //   } catch (err) {
  //     console.log('Oops, unable to copy');
  //   }
  // });


  //Modal
  $("#show-emp").on("click", function () {
    $("#ModalUP").modal({ backdrop: false, keyboard: false })
  });
</script>
</body>

</html>