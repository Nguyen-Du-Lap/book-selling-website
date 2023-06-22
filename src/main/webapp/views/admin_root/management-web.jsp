<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <title> Quản lý trang web | Quản trị Admin</title>
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
  <div class="app-title">
    <ul class="app-breadcrumb breadcrumb side">
      <li class="breadcrumb-item active"><a href="#"><b>Quản lý trang web</b></a></li>
    </ul>
    <div id="clock"></div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="tile">
        <div class="tile-body">
          <div class="row element-button">
            <div class="col-sm-2">

              <a class="btn btn-add btn-sm" href="${pageContext.request.contextPath}/admin-root-add-management-web" title="Thêm"><i class="fas fa-plus"></i>
                Thêm công ty sở hữu</a>
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
              <th>Id</th>
              <th>Tên công ty sở hữu</th>
              <th>Tên website</th>
              <th>Thời gian bắt đầu sở hữu</th>
              <th>Thời gian hết hạn sỡ hữu</th>
              <th>Thông tin về công ty</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td width="10"><input type="checkbox" name="check1" value="1"></td>
              <td>00001</td>
              <td>Công ty Văn hóa và Truyền thông YMK</td>
              <td>YMK</td>
              <td>13/09/2013</td>
              <td>09/12/2015</td>
              <td>Công ty YMK chuyên kinh doanh: sách quốc văn, ngoại văn, văn hóa phẩm, văn phòng phẩm, dụng cụ học tập, quà lưu niệm, đồ chơi dành cho trẻ em… Một số Nhà sách trực thuộc Công ty FAHASA còn kinh doanh các mặt hàng siêu thị như: hàng tiêu dùng, hàng gia dụng, hóa  mỹ phẩm…

                Sách quốc văn với nhiều thể loại đa dạng như sách giáo khoa – tham khảo, giáo trình, sách học ngữ, từ điển, sách tham khảo thuộc nhiều chuyên ngành phong phú: văn học, tâm lý – giáo dục, khoa học kỹ thuật, khoa học kinh tế - xã hội, khoa học thường thức, sách phong thủy, nghệ thuật sống, danh ngôn, sách thiếu nhi, truyện tranh, truyện đọc, từ điển, công nghệ thông tin, khoa học – kỹ thuật, nấu ăn, làm đẹp...  của nhiều Nhà xuất bản, nhà cung cấp sách có uy tín như: NXB Trẻ, Giáo Dục, Kim Đồng, Văn hóa -Văn Nghệ, Tổng hợp TP.HCM, Chính Trị Quốc Gia; Công ty Đông A, Nhã Nam, Bách Việt, Alphabook, Thái Hà, Minh Lâm, Đinh Tị, Minh Long, TGM, Sáng Tạo Trí Việt, Khang Việt, Toàn Phúc…

                Sách ngoại văn bao gồm: từ điển, giáo trình, tham khảo, truyện tranh thiếu nhi , sách học ngữ, từ vựng, ngữ pháp, luyện thi TOEFL, TOEIC, IELS…được nhập từ các NXB nước ngoài như: Cambridge, Mc Graw-Hill, Pearson Education, Oxford, Macmillan, Cengage Learning…

                Văn phòng phẩm, dụng cụ học tập, đồ chơi dành cho trẻ em, hàng lưu niệm… đa dạng, phong phú, mẫu mã đẹp, chất lượng tốt, được cung ứng bởi các công ty, nhà cung cấp uy tín như: Thiên Long, XNK Bình Tây, Hạnh Thuận, Ngô Quang, Việt Văn, Trương Vui, Hương Mi, Phương Nga, Việt Tinh Anh, Chăm sóc trẻ em Việt, Mẹ và em bé…

                Cùng với việc phát hành độc quyền nhiều ấn bản các loại của các Nhà xuất bản là năng lực in ấn, sản xuất cung ứng nguồn hàng của Xí nghiệp in WMK, đã giúp Công ty luôn chủ động được nguồn hàng, nhất là các mặt hàng độc quyền như: lịch bloc, tập học sinh, sổ tay cao cấp, agenda, văn phòng phẩm, dụng cụ học tập…</td>
              <td>
                <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" id="show-emp" data-toggle="modal"
                        data-target="#ModalUP"><i class="fas fa-edit"></i></button>

              </td>
            </tr>
            <tr>
              <td width="10"><input type="checkbox" name="check1" value="1"></td>
              <td>00002</td>
              <td>Công ty Văn hóa, Dịch vụ và Truyền thông Shmily</td>
              <td>SHMILY</td>
              <td>10/12/2015</td>
              <td>19/10/2020</td>
              <td>Công ty YMK chuyên kinh doanh: sách quốc văn, ngoại văn, văn hóa phẩm, văn phòng phẩm, dụng cụ học tập, quà lưu niệm, đồ chơi dành cho trẻ em… Một số Nhà sách trực thuộc Công ty FAHASA còn kinh doanh các mặt hàng siêu thị như: hàng tiêu dùng, hàng gia dụng, hóa  mỹ phẩm…

                Sách quốc văn với nhiều thể loại đa dạng như sách giáo khoa – tham khảo, giáo trình, sách học ngữ, từ điển, sách tham khảo thuộc nhiều chuyên ngành phong phú: văn học, tâm lý – giáo dục, khoa học kỹ thuật, khoa học kinh tế - xã hội, khoa học thường thức, sách phong thủy, nghệ thuật sống, danh ngôn, sách thiếu nhi, truyện tranh, truyện đọc, từ điển, công nghệ thông tin, khoa học – kỹ thuật, nấu ăn, làm đẹp...  của nhiều Nhà xuất bản, nhà cung cấp sách có uy tín như: NXB Trẻ, Giáo Dục, Kim Đồng, Văn hóa -Văn Nghệ, Tổng hợp TP.HCM, Chính Trị Quốc Gia; Công ty Đông A, Nhã Nam, Bách Việt, Alphabook, Thái Hà, Minh Lâm, Đinh Tị, Minh Long, TGM, Sáng Tạo Trí Việt, Khang Việt, Toàn Phúc…

                Sách ngoại văn bao gồm: từ điển, giáo trình, tham khảo, truyện tranh thiếu nhi , sách học ngữ, từ vựng, ngữ pháp, luyện thi TOEFL, TOEIC, IELS…được nhập từ các NXB nước ngoài như: Cambridge, Mc Graw-Hill, Pearson Education, Oxford, Macmillan, Cengage Learning…

                Văn phòng phẩm, dụng cụ học tập, đồ chơi dành cho trẻ em, hàng lưu niệm… đa dạng, phong phú, mẫu mã đẹp, chất lượng tốt, được cung ứng bởi các công ty, nhà cung cấp uy tín như: Thiên Long, XNK Bình Tây, Hạnh Thuận, Ngô Quang, Việt Văn, Trương Vui, Hương Mi, Phương Nga, Việt Tinh Anh, Chăm sóc trẻ em Việt, Mẹ và em bé…

                Cùng với việc phát hành độc quyền nhiều ấn bản các loại của các Nhà xuất bản là năng lực in ấn, sản xuất cung ứng nguồn hàng của Xí nghiệp in WMK, đã giúp Công ty luôn chủ động được nguồn hàng, nhất là các mặt hàng độc quyền như: lịch bloc, tập học sinh, sổ tay cao cấp, agenda, văn phòng phẩm, dụng cụ học tập…</td>
              </td>
              <td>
                <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" id="show-emp" data-toggle="modal"
                        data-target="#ModalUP"><i class="fas fa-edit"></i></button>

              </td>
            </tr>
            <tr>
              <td width="10"><input type="checkbox" name="check1" value="1"></td>
              <td>00003</td>
              <td>Công ty TNHH Văn hóa và Truyền Thông ORIN</td>
              <td>Doraemon</td>
              <td>01/01/2021</td>
              <td>----</td>
              <td>Công ty YMK chuyên kinh doanh: sách quốc văn, ngoại văn, văn hóa phẩm, văn phòng phẩm, dụng cụ học tập, quà lưu niệm, đồ chơi dành cho trẻ em… Một số Nhà sách trực thuộc Công ty FAHASA còn kinh doanh các mặt hàng siêu thị như: hàng tiêu dùng, hàng gia dụng, hóa  mỹ phẩm…

                Sách quốc văn với nhiều thể loại đa dạng như sách giáo khoa – tham khảo, giáo trình, sách học ngữ, từ điển, sách tham khảo thuộc nhiều chuyên ngành phong phú: văn học, tâm lý – giáo dục, khoa học kỹ thuật, khoa học kinh tế - xã hội, khoa học thường thức, sách phong thủy, nghệ thuật sống, danh ngôn, sách thiếu nhi, truyện tranh, truyện đọc, từ điển, công nghệ thông tin, khoa học – kỹ thuật, nấu ăn, làm đẹp...  của nhiều Nhà xuất bản, nhà cung cấp sách có uy tín như: NXB Trẻ, Giáo Dục, Kim Đồng, Văn hóa -Văn Nghệ, Tổng hợp TP.HCM, Chính Trị Quốc Gia; Công ty Đông A, Nhã Nam, Bách Việt, Alphabook, Thái Hà, Minh Lâm, Đinh Tị, Minh Long, TGM, Sáng Tạo Trí Việt, Khang Việt, Toàn Phúc…

                Sách ngoại văn bao gồm: từ điển, giáo trình, tham khảo, truyện tranh thiếu nhi , sách học ngữ, từ vựng, ngữ pháp, luyện thi TOEFL, TOEIC, IELS…được nhập từ các NXB nước ngoài như: Cambridge, Mc Graw-Hill, Pearson Education, Oxford, Macmillan, Cengage Learning…

                Văn phòng phẩm, dụng cụ học tập, đồ chơi dành cho trẻ em, hàng lưu niệm… đa dạng, phong phú, mẫu mã đẹp, chất lượng tốt, được cung ứng bởi các công ty, nhà cung cấp uy tín như: Thiên Long, XNK Bình Tây, Hạnh Thuận, Ngô Quang, Việt Văn, Trương Vui, Hương Mi, Phương Nga, Việt Tinh Anh, Chăm sóc trẻ em Việt, Mẹ và em bé…

                Cùng với việc phát hành độc quyền nhiều ấn bản các loại của các Nhà xuất bản là năng lực in ấn, sản xuất cung ứng nguồn hàng của Xí nghiệp in WMK, đã giúp Công ty luôn chủ động được nguồn hàng, nhất là các mặt hàng độc quyền như: lịch bloc, tập học sinh, sổ tay cao cấp, agenda, văn phòng phẩm, dụng cụ học tập…</td>
              </td>
              <td>
                <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" id="show-emp" data-toggle="modal"
                        data-target="#ModalUP"><i class="fas fa-edit"></i></button>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</main>

<!--
  MODAL
-->
<div class="modal fade" id="ModalUP" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static"
     data-keyboard="false">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">

      <div class="modal-body">
        <div class="row">
          <div class="form-group  col-md-12">
          <span class="thong-tin-thanh-toan">
            <h5>Chỉnh sửa thông tin website</h5>
          </span>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-6">
            <label class="control-label">Mã công ty </label>
            <input class="form-control" type="number" value="000001">
          </div>
          <div class="form-group col-md-6">
            <label class="control-label">Tên công ty</label>
            <input class="form-control" type="text" required value="Công ty TNHH Văn Hóa và Truyền thông ORIN">
          </div>
          <div class="form-group  col-md-6">
            <label class="control-label">Tên Website</label>
            <input class="form-control" type="text" required value="Doraemon">
          </div>
          <div class="form-group col-md-6">
            <label class="control-label">Thời gian bắt đầu sở hữu</label>
            <input class="form-control" type="time" value="01/01/2021" disabled>
          </div>
          <div class="form-group col-md-6">
            <label class="control-label">Thời gian kết thúc sở hữu</label>
            <input class="form-control" type="time" value="Null">
          </div>

        </div>
        <BR>
        <a href="#" style="    float: right;
    font-weight: 600;
    color: #ea0000;">Chỉnh sửa thông tin website nâng cao</a>
        <BR>
        <BR>
        <button class="btn btn-save" type="button">Lưu lại</button>
        <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
        <BR>
      </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
<!--
MODAL
-->

<!-- Essential javascripts for application to work-->
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="src/jquery.table2excel.js"></script>
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<!-- Data table plugin-->
<script type="text/javascript" src="${pageContext.request.contextPath}/templates/admin/doc/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/templates/admin/doc/js/plugins/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">
  $('#sampleTable').DataTable();
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
</script>
<script>
  function deleteRow(r) {
    var i = r.parentNode.parentNode.rowIndex;
    document.getElementById("myTable").deleteRow(i);
  }
  jQuery(function () {
    jQuery(".trash").click(function () {
      swal({
        title: "Cảnh báo",
        text: "Bạn có chắc chắn là muốn xóa sản phẩm này?",
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
</script>
</body>

</html>