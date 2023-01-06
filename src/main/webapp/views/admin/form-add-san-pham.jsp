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
    <link rel="stylesheet" type="text/css" href="/templates/admin/doc/css/main.css">
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
            <li class="breadcrumb-item">Danh sách sản phẩm</li>
            <li class="breadcrumb-item"><a href="#">Thêm sản phẩm</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <h3 class="tile-title">Tạo mới sản phẩm</h3>
                <div class="tile-body">
                    <div class="row element-button">
                        <div class="col-sm-2">
                            <a class="btn btn-add btn-sm" data-toggle="modal" data-target="#addcungcap"><i
                                    class="fas fa-folder-plus"></i> Thêm nhà cung cấp</a>
                        </div>
                        <div class="col-sm-2">
                            <a class="btn btn-add btn-sm" data-toggle="modal" data-target="#adddanhmuc"><i
                                    class="fas fa-folder-plus"></i> Thêm danh mục</a>
                        </div>
                        <div class="col-sm-2">
                            <a class="btn btn-add btn-sm" data-toggle="modal" data-target="#addnhaxuatban"><i
                                    class="fas fa-folder-plus"></i> Thêm nhà xuất bản</a>
                        </div>
                        <div class="col-sm-2">
                            <a class="btn btn-add btn-sm" data-toggle="modal" data-target="#addtinhtrang"><i
                                    class="fas fa-folder-plus"></i> Thêm tình trạng</a>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <c:if test="${not empty message}">
                            <div class="alert alert-${alert}" role="alert">
                                    ${message}
                            </div>
                        </c:if>
                    </div>

                    <form action="/admin-add-san-pham" enctype="multipart/form-data" method="post" class="row">
                        <div class="form-group col-md-3">
                            <label class="control-label">Tên sản phẩm</label>
                            <input name="name" class="form-control" type="text">
                        </div>
                        <div class="form-group  col-md-3">
                            <label class="control-label">Số lượng</label>
                            <input name="quantity" class="form-control" type="number">
                        </div>
                        <div class="form-group col-md-3 ">
                            <label for="exampleSelect1" class="control-label">Tình trạng</label>
                            <select name="status" class="form-control">
                                <option>Mở bán</option>
                                <option>Sắp phát hành</option>
                            </select>
                        </div>
                        <div class="form-group col-md-3 ">
                            <label for="exampleSelect1" class="control-label">Sách mới</label>
                            <select name="isNew" class="form-control">
                                <option>Sách mới</option>
                                <option>Sách đã phát hành</option>
                            </select>
                        </div>
                        <div class="form-group col-md-3">
                            <label for="exampleSelect1" class="control-label">Danh mục</label>
                            <select name="catalog" class="form-control" id="exampleSelect1">
                                <c:forEach items="${listCatalog}" var="catalog">
                                    <option>${catalog}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3 ">
                            <label for="exampleSelect1" class="control-label">Nhà cung cấp</label>
                            <select name="publisherCompany" class="form-control">

                                <c:forEach items="${listPublisherCompany}" var="publisherPC">
                                    <option>${publisherPC}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3 ">
                            <label for="exampleSelect1" class="control-label">Nhà xuất bản</label>
                            <select name="publisher" class="form-control">

                                <c:forEach items="${listPublisher}" var="publisher">
                                    <option>${publisher}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Giá bán</label>
                            <input name="primeCost" class="form-control" type="number">
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Giá vốn</label>
                            <input name="price" class="form-control" type="number">
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Mã ISBN</label>
                            <input name="isbn" class="form-control" type="text">
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Năm xuất bản</label>
                            <input name="year" class="form-control" value="2022" type="number">
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Khối lượng</label>
                            <input name="weight" class="form-control" type="number">
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Kích thước</label>
                            <input name="size" class="form-control" type="text">
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Tổng số trang</label>
                            <input name="page" class="form-control" type="number">
                        </div>
                        <div class="form-group col-md-3 ">
                            <label for="exampleSelect1" class="control-label">Ngôn ngữ</label>
                            <select name="language" class="form-control">
                                <option>Tiếng Việt</option>
                                <option>English</option>
                            </select>
                        </div>
                        <div class="form-group col-md-12">
                            <label class="control-label">Ảnh 1</label>
                            <input name="image1" type="file">
                        </div>
                        <div class="form-group col-md-12">
                            <label class="control-label">Ảnh 2</label>
                            <input name="image2" type="file">
                        </div>
                        <div class="form-group col-md-12">
                            <label class="control-label">Ảnh 3</label>
                            <input name="image3" type="file">
                        </div>
                        <div class="form-group col-md-12">
                            <label class="control-label">Ảnh 4</label>
                            <input name="image4" type="file">
                        </div>
                        <div class="form-group col-md-12">
                            <label class="control-label">Mô tả sản phẩm</label>
                            <textarea class="form-control" name="description"></textarea>
                        </div>

                        <div>
                            <button class="btn btn-save" type="submit">Lưu lại</button>
                            <a class="btn btn-cancel" href="/admin-table-product">Hủy bỏ</a>
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


<script src="/templates/admin/doc/js/jquery-3.2.1.min.js"></script>
<script src="/templates/admin/doc/js/popper.min.js"></script>
<script src="/templates/admin/doc/js/bootstrap.min.js"></script>
<script src="/templates/admin/doc/js/main.js"></script>
<script src="/templates/admin/doc/js/plugins/pace.min.js"></script>
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
