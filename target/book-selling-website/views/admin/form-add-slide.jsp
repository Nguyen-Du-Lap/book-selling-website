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
<%@include file="/common/admin/header.jsp" %>
<%@include file="/common/admin/aside.jsp" %>
<main class="app-content">
  <div class="app-title">
    <ul class="app-breadcrumb breadcrumb">
      <li class="breadcrumb-item">Danh sách slided</li>
      <li class="breadcrumb-item"><a href="#">Thêm slide</a></li>
    </ul>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="tile">
        <h3 class="tile-title">Tạo mới slide</h3>
        <div class="tile-body">
          <div class="row element-button">
          </div>
          <div class="col-sm-6">
            <c:if test="${not empty message}">
              <div class="alert alert-${alert}" role="alert">
                  ${message}
              </div>
            </c:if>
          </div>

          <form action="/admin-add-slide" enctype="multipart/form-data" method="post" class="row">
            <div class="form-group col-md-3">
              <label class="control-label">Tên slide</label>
              <input name="name" class="form-control" type="text">
            </div>

            <div class="form-group col-md-3">
              <label class="control-label">Thời gian bắt đầu</label>
              <input name="timeStart" class="form-control" type="date">
            </div>
            <div class="form-group col-md-3">
              <label class="control-label">Thời gian kết thúc</label>
              <input name="timeFinish" class="form-control" type="date">
            </div>

            <div class="form-group col-md-12">
              <label class="control-label">Ảnh 1</label>
              <input name="image1" type="file">
            </div>
            <div>
              <button class="btn btn-save" type="submit">Lưu lại</button>
              <a class="btn btn-cancel" href="${pageContext.request.contextPath}/admin-table-slider">Hủy bỏ</a>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</main>


<!--
MODAL CHỨC VỤ
-->
<div class="modal fade" id="addcungcap" tabindex="-1" role="dialog" aria-labelledby="addcungcap"
     data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <form method="post" action="/admin-add-publisher-company">
        <div class="modal-body">
          <div class="row">
            <div class="form-group col-md-12">
                        <span class="thong-tin-thanh-toan">
                        <h5>Thêm mới nhà xuất bản</h5>
                        </span>
              <label class="control-label">Nhập nhà cung cấp mới</label>
              <input name="publisherCompany" class="form-control" type="text" required>

            </div>
            <div class="form-group col-md-12">
            </div>
            <div class="form-group col-md-12">
              <label class="control-label">Nhà cung cấp hiện đang có</label>
              <ul style="padding-left: 20px;">
                <c:forEach items="${listPublisherCompany}" var="publisherCompany">
                  <li>${publisherCompany}</li>
                </c:forEach>
              </ul>
            </div>
          </div>
          <BR>
          <button class="btn btn-save" type="submit">Lưu lại</button>
          <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
          <BR>
        </div>
      </form>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
<!--
MODAL
-->

<div class="modal fade" id="addnhaxuatban" tabindex="-1" role="dialog" aria-labelledby="addnhaxuatban"
     data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <form action="/admin-add-publisher" method="post">
        <div class="modal-body">
          <div class="row">
            <div class="form-group  col-md-12">
              <span class="thong-tin-thanh-toan">
                <h5>Thêm mới nhà xuất bản</h5>
              </span>
            </div>
            <div class="form-group col-md-12">
              <label class="control-label">Nhập tên nhà xuất bản mới</label>
              <input name="publisher" class="form-control" type="text" required>
            </div>
            <div class="form-group col-md-12">
              <label class="control-label">Nhà xuất bản hiện đang có</label>
              <ul style="padding-left: 20px;">
                <c:forEach items="${listPublisher}" var="publisher">
                  <li>${publisher}</li>
                </c:forEach>
              </ul>
            </div>
          </div>
          <BR>
          <button class="btn btn-save" type="submit">Lưu lại</button>
          <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
          <BR>
        </div>

      </form>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>

<!--
MODAL DANH MỤC
-->
<div class="modal fade" id="adddanhmuc" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <form action="/admin-add-catalog" method="post" >
        <div class="modal-body">
          <div class="row">
            <div class="form-group  col-md-12">
              <span class="thong-tin-thanh-toan">
                <h5>Thêm mới danh mục </h5>
              </span>
            </div>
            <div class="form-group col-md-12">
              <label class="control-label">Nhập tên danh mục mới</label>
              <input name="catalog" class="form-control" type="text" required>
            </div>
            <div class="form-group col-md-12">
              <label class="control-label">Danh mục sản phẩm hiện đang có</label>
              <ul style="padding-left: 20px;">
                <c:forEach items="${listCatalog}" var="catalog">
                  <li>${catalog}</li>
                </c:forEach>
              </ul>
            </div>
          </div>
          <BR>
          <button class="btn btn-save" type="submit">Lưu lại</button>
          <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
          <BR>
        </div>
      </form>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
<!--
MODAL
-->


<!--
MODAL TÌNH TRẠNG
-->
<div class="modal fade" id="addtinhtrang" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">

      <div class="modal-body">
        <div class="row">
          <div class="form-group  col-md-12">
              <span class="thong-tin-thanh-toan">
                <h5>Thêm mới tình trạng</h5>
              </span>
          </div>
          <div class="form-group col-md-12">
            <label class="control-label">Nhập tình trạng mới</label>
            <input class="form-control" type="text" required>
          </div>
          <div class="form-group col-md-12">
            <label class="control-label">Tình trạng hiện có</label>
            <ul style="padding-left: 20px;">
              <li>Mở bán</li>
              <li>Sắp phát hành</li>
            </ul>
          </div>
        </div>
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
