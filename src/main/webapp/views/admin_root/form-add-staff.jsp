<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Thêm sản phẩm | Quản trị Admin</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/templates/admin/doc/css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <!-- or -->
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
          integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
    <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
</head>

<body class="app sidebar-mini rtl">

<!-- Navbar-->
<%@include file="/common/admin_root/header.jsp"%>
<%@include file="/common/admin_root/aside.jsp"%>>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item">Danh sách nhân viên</li>
            <li class="breadcrumb-item"><a href="#">Thêm nhân viên</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <h3 class="tile-title">Tạo mới nhân viên</h3>
                <div class="tile-body">

                    <div class="col-sm-6">
                        <c:if test="${not empty message}">
                            <div class="alert alert-${alert}" role="alert">
                                    ${message}
                            </div>
                        </c:if>
                    </div>

                    <form action="/admin-root-add-staff" method="post" class="row">

                        <div class="form-group col-md-3">
                            <label class="control-label">Họ</label>
                            <input name="nameLast" class="form-control" type="text">
                        </div>
                        <div class="form-group  col-md-3">
                            <label class="control-label">Tên</label>
                            <input name="nameFirst" class="form-control" type="text">
                        </div>

                        <div class="form-group col-md-3">
                            <label class="control-label">Email</label>
                            <input name="email" class="form-control" type="text">
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Mật khẩu</label>
                            <input name="password" class="form-control" type="text">
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Số điện thoại</label>
                            <input name="numberPhone" class="form-control" type="text">
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Địa chỉ</label>
                            <input name="addess" class="form-control"  type="text">
                        </div>
                        <div class="form-group col-md-9">
                            <button class="btn btn-save" type="submit">Lưu lại</button>
                            <a class="btn btn-cancel" href="${pageContext.request.contextPath}/admin-root-management-user">Hủy bỏ</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>



<script src="${pageContext.request.contextPath}/templates/admin/doc/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/main.js"></script>
<script src="${pageContext.request.contextPath}/templates/admin/doc/js/plugins/pace.min.js"></script>
<script>
    const inpFile = document.getElementById("inpFile");
    const loadFile = document.getElementById("loadFile");
    const previewContainer = document.getElementById("imagePreview");
    const previewImage = previewContainer.querySelector(".image-preview__image");
    const previewDefaultText = previewContainer.querySelector(".image-preview__default-text");
    inpFile.addEventListener("change", function () {
        const file = this.files[0];
        if (file) {
            const reader = new FileReader();
            previewDefaultText.style.display = "none";
            previewImage.style.display = "block";
            reader.addEventListener("load", function () {
                previewImage.setAttribute("src", this.result);
            });
            reader.readAsDataURL(file);
        }
    });

</script>
</body>

</html>
