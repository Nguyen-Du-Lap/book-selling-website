<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Chi tiết đơn hàng</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"/>
    <link rel="stylesheet" href="<c:url value='/templates/styles/Header.css'/> " />
    <link rel="stylesheet" href="<c:url value='/templates/styles/AccountPage.css'/> " />
    <link rel="stylesheet" href="<c:url value='/templates/styles/Footer.css'/> " />
</head>

<body>
<%@include file="/common/web/header.jsp"%>
<div class="container" style="min-height: 600px">
    <h1 class="text-center my-4">Chi tiết đơn hàng</h1>
    <div class="row">
        <div class="col-md-6">
            <h2>Thông tin khách hàng</h2>
            <table class="table">
                <tbody>
                <tr>
                    <td>Tên khách hàng:</td>
                    <td>${CUSTOMER.firstName} ${CUSTOMER.lastName}</td>
                </tr>
                <tr>
                    <td>Địa chỉ:</td>
                    <td>${BILLDETAIL.address}</td>
                </tr>
                <tr>
                    <td>Số điện thoại:</td>
                    <td>${CUSTOMER.phone}</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>${CUSTOMER.email}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-md-6">
            <h2>Thông tin đơn hàng</h2>
            <table class="table">
                <tbody>
                <tr>
                    <td>Mã đơn hàng:</td>
                    <td>${BILLDETAIL.idOrder}</td>
                </tr>
                <tr>
                    <td>Ngày đặt hàng:</td>
                    <td>${BILLDETAIL.ship_time}</td>
                </tr>
                <tr>
                    <td>Ngày giao đến:</td>
                    <td>${BILLDETAIL.receive_time}</td>
                </tr>
                <tr>
                    <td>Tổng giá trị:</td>
                    <td>${BILLDETAIL.totalPrice} VNĐ</td>
                </tr>
                <tr>
                    <td>Tình trạng:</td>
                    <td>${BILLDETAIL.shippingInfo}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h2>Danh sách sản phẩm</h2>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Mã đơn hàng</th>
                    <th scope="col">Tên sản phẩm</th>
                    <th scope="col">Ảnh</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Tổng tiền</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="1">${BILLDETAIL.idOrder}</th>
                        <td>${BILLDETAIL.name}</td>
                        <td><img style="height: 50px" src="${BILLDETAIL.image}"></td>
                        <td>${BILLDETAIL.quantity}</td>
                        <td>${BILLDETAIL.totalPrice}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="/common/web/footer.jsp"%>
<script src="/templates/scripts/header.js"></script>
</body>

</html>
