<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Danh sách sản phẩm | Quản trị Admin</title>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
          integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
</head>

<body onload="time()" class="app sidebar-mini rtl">
<!-- Navbar-->
<%@include file="/common/admin/header.jsp" %>
<%@include file="/common/admin/aside.jsp" %>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb side">
            <li class="breadcrumb-item active"><a href="#"><b>Danh sách liên hệ</b></a></li>
        </ul>
        <div id="clock"></div>
    </div>
</main>

<!--
  MODAL
-->
<div class="modal show fade" style="display: block; padding-right: 17px;" id="" tabindex="-1" role="dialog"
     aria-hidden="true" data-backdrop="static"
     data-keyboard="false">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">

            <div class="modal-body">
                <form action="/update-contact" method="post">
                    <div class="row">
                        <div class="form-group  col-md-12">
                          <span class="thong-tin-thanh-toan">
                            <h5>Chỉnh sửa tình trạng xử lý liên hệ</h5>
                          </span>
                        </div>
                    </div>
                    <BR>
                    <div class="row">

                        <c:forEach var="contact" items="${contactUpdate}">
                            <div class="form-group col-md-6">
                                <label class="control-label">Mã liên hệ</label>
                                <input name="id" class="form-control" type="text" value="${contact.id}">
                            </div>
                            <div class="form-group col-md-6">
                                <label  class="control-label">Tình trạng xử lý liên hệ</label>
                                <select name="status" class="form-control" id="exampleSel1">
                                    <c:if test="${contact.status == 1}">
                                        <option>Đã đọc</option>
                                        <option>Chưa đọc</option>
                                    </c:if>
                                    <c:if test="${contact.status == 0}">
                                        <option>Chưa đọc</option>
                                        <option>Đã đọc</option>
                                    </c:if>
                                </select>
                            </div>
                        </c:forEach>
                    </div>
                    <BR>
                    <button class="btn btn-save" type="submit">Lưu lại</button>
                    <a class="btn btn-cancel" data-dismiss="modal" href="/admin-management-contact">Hủy bỏ</a>
                    <BR>
                </form>

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
<script src="/templates/admin/doc/js/jquery-3.2.1.min.js"></script>
<script src="/templates/admin/doc/js/popper.min.js"></script>
<script src="/templates/admin/doc/js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="src/jquery.table2excel.js"></script>
<script src="/templates/admin/doc/js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="/templates/admin/doc/js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<!-- Data table plugin-->
<script type="text/javascript" src="/templates/admin/doc/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/templates/admin/doc/js/plugins/dataTables.bootstrap.min.js"></script>
<script src="/templates/scripts/crud.js"></script>
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
    // function deleteRow(r) {
    //   var i = r.parentNode.parentNode.rowIndex;
    //   document.getElementById("myTable").deleteRow(i);
    // }
    // jQuery(function () {
    //   jQuery(".trash").click(function () {
    //     swal({
    //       title: "Cảnh báo",
    //       text: "Bạn có chắc chắn là muốn xóa sản phẩm này?",
    //       buttons: ["Hủy bỏ", "Đồng ý"],
    //     })
    //             .then((willDelete) => {
    //               if (willDelete) {
    //                 swal("Đã xóa thành công.!", {
    //
    //                 });
    //               }
    //             });
    //   });
    // });
    // oTable = $('#sampleTable').dataTable();
    // $('#all').click(function (e) {
    //   $('#sampleTable tbody :checkbox').prop('checked', $(this).is(':checked'));
    //   e.stopImmediatePropagation();
    // });
</script>
</body>

</html>
