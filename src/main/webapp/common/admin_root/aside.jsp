<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
  <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="/templates/images/avatar.webp" width="50px"
                                      alt="User Image">
    <div>
      <p class="app-sidebar__user-name"><b>Quỳnh Hương</b></p>
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

    <c:if test="${title.equals('Danh Sách Nhân Viên')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-table-user" />"><i class='app-menu__icon bx bx-user-voice'></i><span
              class="app-menu__label">Quản lý nhân viên</span></a></li>
    </c:if>
    <c:if test="${!title.equals('Danh Sách Nhân Viên')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-table-user" />"><i class='app-menu__icon bx bx-user-voice'></i><span
              class="app-menu__label">Quản lý nhân viên</span></a></li>
    </c:if>

    <c:if test="${title.equals('Danh Sách Đối Tác')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-table-partner" />"><i
              class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý đối tác</span></a>
      </li>
    </c:if>
    <c:if test="${!title.equals('Danh Sách Đối Tác')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-table-partner" />"><i
              class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý đối tác</span></a>
      </li>
    </c:if>

    <c:if test="${title.equals('Danh Sách Khuyến Mãi')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-table-sales" />"><i class='app-menu__icon bx bx-task'></i><span
              class="app-menu__label">Quản lý khuyến mãi</span></a></li>
    </c:if>
    <c:if test="${!title.equals('Danh Sách Khuyến Mãi')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-table-sales" />"><i class='app-menu__icon bx bx-task'></i><span
              class="app-menu__label">Quản lý khuyến mãi</span></a></li>
    </c:if>

    <c:if test="${title.equals('Giới Thiệu Về Doraemon')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-management-web"/>">
        <i class="app-menu__icon  fa-regular fa-user"></i><span class="app-menu__label">Quản lý trang web</span></a>
      </li>
    </c:if>
    <c:if test="${!title.equals('Giới Thiệu Về Doraemon')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-management-web" />">
        <i class="app-menu__icon  fa-regular fa-user"></i><span class="app-menu__label">Quản lý trang web</span></a>
      </li>
    </c:if>

    <c:if test="${title.equals('Báo Cáo Doanh Thu')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-report-management" />"><i
              class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
      </li>
    </c:if>
    <c:if test="${!title.equals('Báo Cáo Doanh Thu')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-report-management" />"><i
              class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
      </li>
    </c:if>

    <c:if test="${title.equals('Kích Hoạt Bảo Trì')}">
      <li><a class="app-menu__item active" href="<c:url value="/admin-enable-maintenance" />">
        <i class='app-menu__icon bx bx-calendar-check'></i><span
              class="app-menu__label">Kích hoạt bảo trì</span></a></li>
    </c:if>
    <c:if test="${!title.equals('Kích Hoạt Bảo Trì')}">
      <li><a class="app-menu__item" href="<c:url value="/admin-enable-maintenance" />"><i class='app-menu__icon bx bx-calendar-check'></i><span
              class="app-menu__label">Kích hoạt bảo trì</span></a></li>
    </c:if>

  </ul>
</aside>
