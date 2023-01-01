<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/5/2022
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Những Người Khốn Khổ</title>
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/bootstrap-grid.css">
  <link rel="stylesheet" href="css/bootstrap-reboot.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <link
          href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700&display=swap"
          rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer"/>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet">
  <link rel="stylesheet" href="<c:url value='/templates/styles/Header.css'/> " />
  <link rel="stylesheet" href="<c:url value='/templates/styles/ProductDetail.css'/> " />
  <link rel="stylesheet" href="<c:url value='/templates/styles/Footer.css'/> " />
</head>
<body>

<%@include file="/common/web/header.jsp"%>
<!-------------------------Product----------------------->
<section class="product">
  <div class="container">
    <nav id="breadcrumbbar">
      <ul class="breadcrumb">
        <li class="breadcrumb-item"><a class="chang_font" href="/home">Trang chủ</a></li>
        <li class="breadcrumb-item"><a href="vanhocnuocngoai.html">Văn học nước ngoài</a></li>
        <li class="breadcrumb-item active"><a href="Product_detail.html">Những người khốn khổ</a></li>
      </ul>
    </nav>
    <div class="product-content row">
      <div class="product-content-left">
        <div class="product-content-left-big-img">
          <img src="/templates/images/vanhocnuocngoai/nhungnguoikhonkho1.jpeg" alt="">
        </div>
        <div class="product-content-left-small-img d-flex">
          <img src="/templates/images/vanhocnuocngoai/nhungnguoikhonkho1.jpeg" alt="" style="margin-top: 10px">
          <img src="/templates/images/vanhocnuocngoai/nhungnguoikhonkho3.jpeg" alt="" style="margin-top: 10px">
          <img src="/templates/images/vanhocnuocngoai/nhungnguoikhonkho4.jpeg" alt="" style="margin-top: 10px">
          <img src="/templates/images/vanhocnuocngoai/nnkk6.jpeg" alt="" style="margin-top: 10px">

        </div>
      </div>
      <div class="product-content-right">
        <div class="product-content-right-product-name">
          <h1>NHỮNG NGƯỜI KHỐN KHỔ (TRỌN BỘ 3 TẬP)</h1>
          <p>MSP: 8935095623938</p>
        </div>
        <div class="product-content-right-product-rate">
          <i class="fa fa-star active"></i>
          <i class="fa fa-star active"></i>
          <i class="fa fa-star active"></i>
          <i class="fa fa-star active"></i>
          <i class="fa fa-star "></i>
        </div>
        <hr>
        <div class="product-content-right-product-price">
          <div class="giabia">Giá:<span class="giacu ml-2">390.000 ₫</span></div>
          <div class="giaban">Giá bán tại Doraemon: <span class="giamoi font-weight-bold">370.000 đ</span></div>
          <div class="tietkiem">Tiết kiệm: <b>20.000 ₫</b>
          </div>
        </div>
        <div class="product-content-right-uudai">
          <h6 class="header font-weight-bold">Khuyến mãi & Ưu đãi tại Doraemon:</h6>
          <ul>
            <li><b>Miễn phí giao hàng </b>cho đơn hàng từ 150.000đ ở TP.HCM và 300.000đ ở
              Tỉnh/Thành khác <a href="/home">>> Chi tiết</a></li>
            <li><b>Combo sách hot - CHÁY HÀNG </b><a href="home.html">>>Xem ngay</a></li>
            <li>Tặng kèm bìa bao sách</li>
            <li>Miễn phí 5 stickers</li>
            <li>Miễn phí đổi trả nếu sách bị lỗi hoặc hỏng</li>
          </ul>
        </div>
        <div class="product-content-right-soluong d-flex">
          <label class="font-weight-bold">Số lượng: </label>
          <div class="input-number input-group md-3 quantity">
            <div class="input-group-prepend">
              <span class="input-group-text btn-spin btn-dec" onclick="changeQuantity(-1)">-</span>
            </div>
            <input id="soluongsp" type="text" value="1" class="soluongsp  text-center">
            <div class="input-group-append">
              <span class="input-group-text btn-spin btn-inc" onclick="changeQuantity(+1)">+</span>
            </div>
          </div>
        </div>
        <div class="product-content-right-product-button row">
          <button><i class="fas fa-shopping-cart"></i><p>THÊM VÀO GIỎ HÀNG</p></button>
          <button class="muangay"><p>MUA NGAY</p></button>
        </div>
        <div class="product-content-right-product-icon d-flex">
          <div class="product-content-right-product-icon-item">
            <i class="fas fa-phone-alt"></i><p>Hotline</p>
          </div>
          <div class="product-content-right-product-icon-item">
            <i class="far fa-comment"></i> <p>Chat</p>
          </div>
          <div class="product-content-right-product-icon-item">
            <i class="far fa-envelope"></i> <p>Mail</p>

          </div>
        </div>
        <div class="product-content-right-product-bottom">
          <div class="product-content-right-product-bottom-top">
            &#8744;
          </div>
          <div class="product-content-right-product-bottom-content-big">
            <div class="product-content-right-product-bottom-content-title row">
              <div class="product-content-right-product-bottom-content-title-item mota">
                <p>Mô tả</p>
              </div>
              <div class="product-content-right-product-bottom-content-title-item danhgia">
                <p>Đánh giá, bình luận</p>
              </div>
            </div>
            <div class="product-content-right-product-bottom-content">
              <div class="product-content-right-bottom-content-mota">
                <div class="product-content-right-product-bottom-content-thongtinsp">
                  <table>
                    <thead>
                    </thead>
                    <tbody>
                    <tr>
                      <td class="themmau">Mã hàng</td>
                      <td>8935095623938</td>
                    </tr>
                    <tr>
                      <td class="themmau">Tác giả</td>
                      <td>Victor Hugo</td>
                    </tr>
                    <tr>
                      <td class="themmau">NXB</td>
                      <td>NXB Văn Học</td>
                    </tr>
                    <tr>
                      <td class="themmau">Năm XB</td>
                      <td>2017</td>
                    </tr>
                    <tr>
                      <td class="themmau">Trọng Lượng (gr)</td>
                      <td>2220</td>
                    </tr>
                    <tr>
                      <td class="themmau">Kích Thước Bao Bì</td>
                      <td>21 x 14 x 10.5 cm</td>
                    </tr>
                    <tr>
                      <td class="themmau">Số trang</td>
                      <td>2054</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <div class="product-content-right-product-bottom-content-chitiet">
                  Trong tác phẩm NHỮNG NGƯỜI KHỐN KHỔ (Les Misérables), cuộc sống cao đẹp của Giăng Văngiăng (Jean Valjean) - người phải ngồi tù suốt 19 năm chỉ vì một chiếc bánh mỳ, tình nhân ái bao dung và tấm lòng độ lượng của đức cha Mirien, sự đeo bám dai dẳng của mật thám Giave (Javert), những mưu đồ đen tối và độc ác của vợ chồng Tênácđiê (Thenardier), sự ngây thơ trong trắng của Côdét (Cosette), cậu bé lang thang Ga-vơ-rốt (Gavroche). sự nhiệt tình hăng hái của Mariuýt (Marius)...
                  Tất cả đều được khắc họa một cách sinh động. NHỮNG NGƯỜI KHỐN KHỔ là bài hát ca ngợi tình yêu và tự do của Giăng Văngiăng - một con người tái sinh trong đau khổ và tuyệt vọng.
                </div>
              </div>

              <div class="product-content-right-product-bottom-content-danhgia">
                <div class="product-content-right-product-bottom-content-rate d-fex">
                  <div class="text-center danhgia">
                    <p class="tieude">Đánh giá trung bình</p>
                    <div class="diem">0/5</div>
                    <div class="sao">
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                    </div>
                    <p class="sonhanxet text-muted">(0 nhận xét)</p>
                  </div>
                  <div class="comment">
                    <div class="tiledanhgia text-center">
                      <div class="motthanh d-flex align-items-center">5 <i class="fa fa-star"></i>
                        <div class="progress mx-2">
                          <div class="progress-bar" role="progressbar" aria-valuenow="0"
                               aria-valuemin="0" aria-valuemax="100"></div>
                        </div> 0%
                      </div>
                      <div class="motthanh d-flex align-items-center">4 <i class="fa fa-star"></i>
                        <div class="progress mx-2">
                          <div class="progress-bar" role="progressbar" aria-valuenow="0"
                               aria-valuemin="0" aria-valuemax="100"></div>
                        </div> 0%
                      </div>
                      <div class="motthanh d-flex align-items-center">3 <i class="fa fa-star"></i>
                        <div class="progress mx-2">
                          <div class="progress-bar" role="progressbar" aria-valuenow="0"
                               aria-valuemin="0" aria-valuemax="100"></div>
                        </div> 0%
                      </div>
                      <div class="motthanh d-flex align-items-center">2 <i class="fa fa-star"></i>
                        <div class="progress mx-2">
                          <div class="progress-bar" role="progressbar" aria-valuenow="0"
                               aria-valuemin="0" aria-valuemax="100"></div>
                        </div> 0%
                      </div>
                      <div class="motthanh d-flex align-items-center">1 <i class="fa fa-star"></i>
                        <div class="progress mx-2">
                          <div class="progress-bar" role="progressbar" aria-valuenow="0"
                               aria-valuemin="0" aria-valuemax="100"></div>
                        </div> 0%
                      </div>
                      <div class="btn vietdanhgia mt-3">Viết đánh giá của bạn</div>
                    </div>
                    <!-- nội dung của form đánh giá  -->
                    <div class="formdanhgia">
                      <h6 class="tieude text-uppercase">GỬI ĐÁNH GIÁ CỦA BẠN</h6>
                      <span class="danhgiacuaban">Đánh giá của bạn về sản phẩm này:</span>
                      <div class="rating d-flex flex-row-reverse align-items-center justify-content-end">
                        <input type="radio" name="star" id="star1"><label for="star1"></label>
                        <input type="radio" name="star" id="star2"><label for="star2"></label>
                        <input type="radio" name="star" id="star3"><label for="star3"></label>
                        <input type="radio" name="star" id="star4"><label for="star4"></label>
                        <input type="radio" name="star" id="star5"><label for="star5"></label>
                      </div>
                      <div class="form-group">
                        <input type="text" class="txtFullname w-100" placeholder="Mời bạn nhập tên(Bắt buộc)">
                      </div>
                      <div class="form-group">
                        <input type="text" class="txtEmail w-100" placeholder="Mời bạn nhập email(Bắt buộc)">
                      </div>
                      <div class="form-group">
                        <input type="text" class="txtComment w-100" placeholder="Đánh giá của bạn về sản phẩm này">
                      </div>
                      <div class="btn nutguibl"><p>Gửi bình luận</p></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<%@include file="/common/web/footer.jsp"%>

<!--    footer-->

<!-- ----js phần header -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
        integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>
<script src="js/bootstrap.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="/templates/scripts/product_type.js"></script>

<script src="/templates/scripts/product.js"></script>

</body>
</html>
