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
                    <td>${orderReviewDetail.fullName}</td>
                </tr>
                <tr>
                    <td>Địa chỉ:</td>
                    <td>${orderReviewDetail.address}</td>
                </tr>
                <tr>
                    <td>Số điện thoại:</td>
                    <td>${orderReviewDetail.phone}</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>${orderReviewDetail.email}</td>
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
                    <td>${orderReviewDetail.idcart}</td>
                </tr>
                <tr>
                    <td>Ngày đặt hàng:</td>
                    <td>${orderReviewDetail.create_order_time}</td>
                </tr>
                <tr>
                    <td>Ngày giao đến:</td>
                    <td>${orderReviewDetail.timeShip}</td>
                </tr>
                <tr>
                    <td>Tổng giá trị:</td>
                    <td>${orderReviewDetail.totolPrice} VNĐ</td>
                </tr>
                <tr>
                    <td>Tình trạng:</td>
                    <td>${orderReviewDetail.trangThai}</td>
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

                    <th scope="col">Tên sản phẩm</th>
                    <th scope="col">Ảnh</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Tổng tiền</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${cartReviewDetail}">

                        <tr>
                            <td>${item.nameSach}</td>
                            <td><img style="height: 50px" src="${pageContext.request.contextPath}/${item.image}"></td>
                            <td>${item.quantity}</td>
                            <td>${item.totalPrice}</td>
                        </tr>

                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
<%@include file="/common/web/footer.jsp"%>
<script src="${pageContext.request.contextPath}/templates/scripts/header.js"></script>
</body>

</html>
