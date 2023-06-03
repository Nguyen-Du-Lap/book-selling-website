<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
  <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="/templates/images/avatar-admin.jpg" width="50px"
                                      alt="User Image">
    <div>
      <p class="app-sidebar__user-name"><b>Mod</b></p>
      <p class="app-sidebar__user-designation">Chào mừng bạn trở lại</p>
    </div>
  </div>
  <hr>
  <ul class="app-menu">
    <c:if test="${title.equals('Bảng điều khiển')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-home" />"><i class='app-menu__icon bx bx-tachometer'></i><span
              class="app-menu__label">Bảng điều khiển</span></a></li>
    </c:if>
    <c:if test="${!title.equals('Bảng điều khiển')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-home" />"><i class='app-menu__icon bx bx-tachometer'></i><span
              class="app-menu__label">Bảng điều khiển</span></a></li>
    </c:if>

    <c:if test="${title.equals('Danh Sách Khách Hàng')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-table-customer" />"><i class='app-menu__icon bx bx-user-voice'></i><span
              class="app-menu__label">Quản lý khách hàng</span></a></li>
    </c:if>
    <c:if test="${!title.equals('Danh Sách Khách Hàng')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-table-customer" />"><i class='app-menu__icon bx bx-user-voice'></i><span
              class="app-menu__label">Quản lý khách hàng</span></a></li>
    </c:if>

    <c:if test="${title.equals('Danh Sách Sản Phẩm')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-table-product" />"><i
              class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
      </li>
    </c:if>
    <c:if test="${!title.equals('Danh Sách Sản Phẩm')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-table-product" />"><i
              class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
      </li>
    </c:if>

    <c:if test="${title.equals('Danh Sách Đơn Hàng')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-table-order" />"><i class='app-menu__icon bx bx-task'></i><span
              class="app-menu__label">Quản lý đơn hàng</span></a></li>
    </c:if>
    <c:if test="${!title.equals('Danh Sách Đơn Hàng')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-table-order" />"><i class='app-menu__icon bx bx-task'></i><span
              class="app-menu__label">Quản lý đơn hàng</span></a></li>
    </c:if>


    <c:if test="${title.equals('Danh Sách Bài Viết')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-table-news" />"><i class='app-menu__icon bx bx-task'></i><span
              class="app-menu__label">Quản lý bài viết</span></a></li>
    </c:if>
    <c:if test="${!title.equals('Danh Sách Bài Viết')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-table-news" />"><i class='app-menu__icon bx bx-task'></i><span
              class="app-menu__label">Quản lý bài viết</span></a></li>
    </c:if>

    <c:if test="${title.equals('Danh Sách Slider')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-table-slider" />"><i class='app-menu__icon bx bx-task'></i><span
              class="app-menu__label">Quản lý slider</span></a></li>
    </c:if>
    <c:if test="${!title.equals('Danh Sách Slider')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-table-slider" />"><i class='app-menu__icon bx bx-task'></i><span
              class="app-menu__label">Quản lý slider</span></a></li>
    </c:if>

    <c:if test="${title.equals('Danh sách đánh giá, bình luận')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-manage-rate"/>">
        <i class="app-menu__icon  fa-regular fa-user"></i><span class="app-menu__label">Quản lý đánh giá, bình luận</span></a>
      </li>
    </c:if>
    <c:if test="${!title.equals('Danh sách đánh giá, bình luận')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-manage-rate" />">
        <i class="app-menu__icon  fa-regular fa-user"></i><span class="app-menu__label">Quản lý đánh giá, bình luận</span></a>
      </li>
    </c:if>

    <c:if test="${title.equals('Danh sách liên hệ')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-management-contact" />"><i class='app-menu__icon bx bx-calendar-check'></i><span
              class="app-menu__label">Quản lý contact</span></a></li>
    </c:if>
    <c:if test="${!title.equals('Danh sách liên hệ')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-management-contact" />"><i class='app-menu__icon bx bx-calendar-check'></i><span
              class="app-menu__label">Quản lý contact</span></a></li>
    </c:if>

  </ul>
</aside>