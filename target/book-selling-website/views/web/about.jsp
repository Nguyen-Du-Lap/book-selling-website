<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/12/2022
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link
          href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700&display=swap"
          rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"
        integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/About.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/styles/Footer.css">
  <title>Giới thiệu</title>
</head>

<body>
<!-- -----------phần header----------------  -->
<%@include file="/common/web/header.jsp"%>
<!--------- end header---------- -->
<div id="content">
  <div class="container">
    <nav id="breadcrumbbar">
      <ul class="breadcrumb">
        <li class="breadcrumb-item"><a class="chang_font" href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
        <li class="breadcrumb-item active"><a href="">Giới thiệu nhà sách Doraemon</a></li>
      </ul>
    </nav>
    <div class="wrapper">
      <h1>GIỚI THIỆU</h1>
    </div>
    <div class="content_container">
      <h1>Giới thiệu nhà sách Doraemon</h1>
      <p style="text-align: justify;"><strong> </strong><strong>Nguồn nh&acirc;n lực</strong></p>
      <p style="text-align: justify;">Để x&acirc;y dựng Thương hiệu mạnh, một trong những định hướng quan
        trọng h&agrave;ng đầu của DORAEMON l&agrave; chiến lược ph&aacute;t triển nguồn nh&acirc;n lực - mấu
        chốt của mọi sự th&agrave;nh c&ocirc;ng.</p>
      <p style="text-align: justify;">DORAEMON c&oacute; hơn 2.200 CB-CNV, tr&igrave;nh độ chuy&ecirc;n
        m&ocirc;n giỏi, nhiệt t&igrave;nh, năng động, chuy&ecirc;n nghiệp. Lực lượng quản l&yacute; DORAEMON
        c&oacute; th&acirc;m ni&ecirc;n c&ocirc;ng t&aacute;c, giỏi nghiệp vụ nhiều kinh nghiệm, c&oacute;
        khả năng quản l&yacute; tốt v&agrave; điều h&agrave;nh đơn vị hoạt động hiệu quả.</p>
      <p style="text-align: justify;">Kết hợp tuyển dụng nguồn nh&acirc;n lực đầu v&agrave;o c&oacute; chất
        lượng v&agrave; kế hoạch bồi dưỡng kiến thức, r&egrave;n luyện bổ sung c&aacute;c kỹ năng v&agrave;
        chuẩn bị đội ngũ kế thừa theo hướng ch&iacute;nh qui th&ocirc;ng qua c&aacute;c lớp học ngắn hạn,
        d&agrave;i hạn; c&aacute;c lớp bồi dưỡng CB-CNV được tổ chức trong nước cũng như ở nước ngo&agrave;i
        đều được l&atilde;nh đạo DORAEMON đặc biệt quan t&acirc;m v&agrave; tạo điều kiện triển khai thực
        hiện. Ch&iacute;nh v&igrave; thế, tr&igrave;nh độ chuy&ecirc;n m&ocirc;n của đội ngũ CB-CNV
        ng&agrave;y c&agrave;ng được n&acirc;ng cao, đ&aacute;p ứng nhu cầu ng&agrave;y c&agrave;ng tăng của
        c&ocirc;ng việc cũng như sự ph&aacute;t triển của x&atilde; hội đang tr&ecirc;n đường hội
        nhập.<strong></strong></p>
      <p style="text-align: justify;"><strong>Về h&agrave;ng h&oacute;a </strong></p>
      <p style="text-align: justify;">C&ocirc;ng ty DORAEMON chuy&ecirc;n kinh doanh: s&aacute;ch quốc văn,
        ngoại văn, văn h&oacute;a phẩm, văn ph&ograve;ng phẩm, dụng cụ học tập, qu&agrave; lưu niệm, đồ chơi
        d&agrave;nh cho trẻ em&hellip; Một số Nh&agrave; s&aacute;ch trực thuộc C&ocirc;ng ty DORAEMON
        c&ograve;n kinh doanh c&aacute;c mặt h&agrave;ng si&ecirc;u thị như: h&agrave;ng ti&ecirc;u
        d&ugrave;ng, h&agrave;ng gia dụng, h&oacute;a&nbsp; mỹ phẩm&hellip;</p>
      <p style="text-align: justify;">S&aacute;ch quốc văn với nhiều thể loại đa dạng như s&aacute;ch
        gi&aacute;o khoa &ndash; tham khảo, gi&aacute;o tr&igrave;nh, s&aacute;ch học ngữ, từ điển,
        s&aacute;ch tham khảo thuộc nhiều chuy&ecirc;n ng&agrave;nh phong ph&uacute;: văn học, t&acirc;m
        l&yacute; &ndash; gi&aacute;o dục, khoa học kỹ thuật, khoa học kinh tế - x&atilde; hội, khoa học
        thường thức, s&aacute;ch phong thủy, nghệ thuật sống, danh ng&ocirc;n, s&aacute;ch thiếu nhi, truyện
        tranh, truyện đọc, từ điển, c&ocirc;ng nghệ th&ocirc;ng tin, khoa học &ndash; kỹ thuật, nấu ăn,
        l&agrave;m đẹp...&nbsp; của nhiều Nh&agrave; xuất bản, nh&agrave; cung cấp s&aacute;ch c&oacute; uy
        t&iacute;n như: NXB Trẻ, Gi&aacute;o Dục, Kim Đồng, Văn h&oacute;a -Văn Nghệ, Tổng hợp TP.HCM,
        Ch&iacute;nh Trị Quốc Gia; C&ocirc;ng ty Đ&ocirc;ng A, Nh&atilde; Nam, B&aacute;ch Việt, Alphabook,
        Th&aacute;i H&agrave;, Minh L&acirc;m, Đinh Tị, Minh Long, TGM, S&aacute;ng Tạo Tr&iacute; Việt,
        Khang Việt, To&agrave;n Ph&uacute;c&hellip;</p>
      <p style="text-align: justify;">S&aacute;ch ngoại văn bao gồm: từ điển, gi&aacute;o tr&igrave;nh, tham
        khảo, truyện tranh thiếu nhi , s&aacute;ch học ngữ, từ vựng, ngữ ph&aacute;p, luyện thi TOEFL,
        TOEIC, IELS&hellip;được nhập từ c&aacute;c NXB nước ngo&agrave;i như<em>: </em>Cambridge, Mc
        Graw-Hill, Pearson Education, Oxford, Macmillan, Cengage Learning&hellip;</p>
      <p style="text-align: justify;">Văn ph&ograve;ng phẩm, dụng cụ học tập, đồ chơi d&agrave;nh cho trẻ em,
        h&agrave;ng lưu niệm&hellip; đa dạng, phong ph&uacute;, mẫu m&atilde; đẹp, chất lượng tốt, được cung
        ứng bởi c&aacute;c c&ocirc;ng ty, nh&agrave; cung cấp uy t&iacute;n như: Thi&ecirc;n Long, XNK
        B&igrave;nh T&acirc;y, Hạnh Thuận, Ng&ocirc; Quang, Việt Văn, Trương Vui, Hương Mi, Phương Nga, Việt
        Tinh Anh, Chăm s&oacute;c trẻ em Việt, Mẹ v&agrave; em b&eacute;&hellip;</p>
      <p style="text-align: justify;">C&ugrave;ng với việc ph&aacute;t h&agrave;nh độc quyền nhiều ấn bản
        c&aacute;c loại của c&aacute;c Nh&agrave; xuất bản l&agrave; năng lực in ấn, sản xuất cung ứng nguồn
        h&agrave;ng của X&iacute; nghiệp in DORAEMON, đ&atilde; gi&uacute;p C&ocirc;ng ty lu&ocirc;n chủ động
        được nguồn h&agrave;ng, nhất l&agrave; c&aacute;c mặt h&agrave;ng độc quyền như: lịch bloc, tập học
        sinh, sổ tay cao cấp, agenda, văn ph&ograve;ng phẩm, dụng cụ học tập&hellip;<strong></strong></p>
      <p style="text-align: justify;"><strong></strong><strong>Hệ thống Nh&agrave; s&aacute;ch chuy&ecirc;n
        nghiệp</strong></p>
      <p style="text-align: justify;">Mạng lưới ph&aacute;t h&agrave;nh của C&ocirc;ng ty DORAEMON rộng khắp
        tr&ecirc;n to&agrave;n quốc, gồm 5 Trung t&acirc;m s&aacute;ch, 1 X&iacute; nghiệp in v&agrave; với
        gần 60 Nh&agrave; s&aacute;ch trải dọc khắp c&aacute;c tỉnh th&agrave;nh từ TP.HCM đến Thủ Đ&ocirc;
        H&agrave; Nội, miền Trung, T&acirc;y Nguy&ecirc;n, miền Đ&ocirc;ng v&agrave; T&acirc;y Nam Bộ như:
        H&agrave; Nội, Vĩnh Ph&uacute;c, Hải Ph&ograve;ng, Thanh H&oacute;a, H&agrave; Tĩnh, Huế, Đ&agrave;
        Nẵng, Quảng Nam, Quảng Ng&atilde;i, Quy Nhơn, Nha Trang, Gia Lai, Đăklăk, Bảo Lộc - L&acirc;m Đồng,
        Ninh Thuận, B&igrave;nh Thuận, B&igrave;nh Phước, B&igrave;nh Dương, Đồng Nai, Vũng T&agrave;u, Long
        An, Tiền Giang, Bến Tre, Vĩnh Long, Cần Thơ, Hậu Giang, An Giang, Ki&ecirc;n Giang, S&oacute;c
        Trăng, C&agrave; Mau.</p>
      <p style="text-align: justify;">Năm 2004 C&ocirc;ng ty đ&atilde; được Cục Sở hữu Tr&iacute; tuệ Việt Nam
        c&ocirc;ng nhận sở hữu độc quyền t&ecirc;n thương hiệu DORAEMON.</p>
      <p style="text-align: justify;">Năm 2005, C&ocirc;ng ty DORAEMON được Trung t&acirc;m s&aacute;ch kỷ lục
        Việt Nam c&ocirc;ng nhận l&agrave; đơn vị c&oacute; hệ thống Nh&agrave; s&aacute;ch nhiều nhất Việt
        Nam; được Tạp ch&iacute; The Guide c&ocirc;ng nhận Nh&agrave; s&aacute;ch Xu&acirc;n Thu - đơn vị
        trực thuộc C&ocirc;ng ty DORAEMON l&agrave; Nh&agrave; s&aacute;ch Ngoại văn đẹp nhất, lớn nhất, quy
        m&ocirc; nhất, nhiều s&aacute;ch nhất ở Th&agrave;nh phố Hồ Ch&iacute; Minh v&agrave; cả nước.</p>
      <p style="text-align: justify;">Năm 2012 DORAEMON l&agrave; Doanh nghiệp nằm trong Top 10 nh&agrave;
        b&aacute;n lẻ h&agrave;ng đầu Việt Nam. Đặc biệt năm 2006, 2009, 2012 DORAEMON đạt danh hiệu Top 500
        Nh&agrave; b&aacute;n lẻ h&agrave;ng đầu Ch&acirc;u &Aacute; Th&aacute;i B&igrave;nh Dương, giải
        thưởng được tạp ch&iacute; Retail Asia (Singapore) b&igrave;nh chọn.<strong></strong></p>
      <p style="text-align: justify;"><strong>Kinh nghiệm hoạt động </strong></p>
      <p style="text-align: justify;">L&agrave; đơn vị c&oacute; gần 40 năm kinh doanh v&agrave; phục vụ
        x&atilde; hội, n&ecirc;n DORAEMON đ&atilde; t&iacute;ch lũy được nhiều kinh nghiệm trong việc
        nghi&ecirc;n cứu thị trường, ph&acirc;n t&iacute;ch t&agrave;i ch&iacute;nh, định hướng ph&aacute;t
        triển, hoạch định chiến lược kinh doanh v&agrave; khả năng tiếp thị giỏi&hellip; Đồng thời DORAEMON
        c&ograve;n c&oacute; nhiều kinh nghiệm trong việc tổ chức c&aacute;c cuộc Hội thảo, Triển l&atilde;m
        v&agrave; giới thiệu s&aacute;ch quốc văn, ngoại văn với qui m&ocirc; lớn, ấn tượng.</p>
      <p style="text-align: justify;">DORAEMON lu&ocirc;n l&agrave; đơn vị đi ti&ecirc;n phong trong nhiều hoạt
        động x&atilde; hội, điển h&igrave;nh l&agrave; việc tham gia tổ chức c&aacute;c Hội s&aacute;ch ở
        TP.HCM như: Hội s&aacute;ch Th&agrave;nh Phố Hồ Ch&iacute; Minh, Hội s&aacute;ch Thiếu nhi ngoại
        th&agrave;nh, Hội s&aacute;ch M&ugrave;a khai trường, Hội s&aacute;ch Học đường, Hội s&aacute;ch
        Trường Quốc tế&hellip; Nổi bật nhất l&agrave; Hội s&aacute;ch Th&agrave;nh Phố Hồ Ch&iacute; Minh,
        được định kỳ tổ chức 2 năm một lần. Đ&acirc;y l&agrave; Hội s&aacute;ch c&oacute; qui m&ocirc; lớn,
        tầm ảnh hưởng rộng, đ&atilde; để lại &yacute; nghĩa kinh tế, văn h&oacute;a v&agrave; x&atilde; hội
        s&acirc;u sắc. Hội s&aacute;ch kh&ocirc;ng chỉ l&agrave; nơi hội tụ văn h&oacute;a l&yacute; tưởng
        đối với người d&acirc;n TP.HCM m&agrave; c&ograve;n l&agrave; một th&ocirc;ng điệp văn h&oacute;a
        t&ocirc;n vinh cho c&aacute;c hoạt động Xuất bản &ndash; Ph&aacute;t h&agrave;nh s&aacute;ch cả
        nước, n&acirc;ng tầm cho việc giao lưu, trao đổi văn h&oacute;a với bạn b&egrave; thế giới, đồng
        thời g&oacute;p phần đem s&aacute;ch - tri thức đến gần hơn với mọi tầng lớp nh&acirc;n d&acirc;n,
        phục vụ tốt hơn nhu cầu văn h&oacute;a tinh thần của x&atilde; hội</p>
      <p style="text-align: justify;"><strong></strong><strong>X&iacute; nghiệp in DORAEMON </strong></p>
      <p style="text-align: justify;">Gồm Ph&acirc;n xưởng in v&agrave; Ph&acirc;n xưởng th&agrave;nh phẩm:
        với nhiều m&aacute;y in hiện đại của Đức v&agrave; Nhật: Heidelberg, Komori, Akiyama, Lithrone,
        Mitsubishi&hellip; c&ugrave;ng nhiều m&aacute;y m&oacute;c, thiết bị kh&aacute;c như: m&aacute;y
        cắt, m&aacute;y v&ocirc; b&igrave;a s&aacute;ch, m&aacute;y bế hộp&hellip; &nbsp;Đội ngũ c&ocirc;ng
        nh&acirc;n tay nghề cao, đ&atilde; cho ra những sản phẩm c&oacute; chất lượng tốt, nhờ đ&oacute;,
        DORAEMON lu&ocirc;n chủ động được nguồn h&agrave;ng, sản xuất theo đ&uacute;ng nhu cầu - thị hiếu của
        kh&aacute;ch h&agrave;ng v&agrave; h&igrave;nh th&agrave;nh được quy tr&igrave;nh in &amp;
        ph&aacute;t h&agrave;nh; phương thức n&agrave;y kh&ocirc;ng chỉ cho ra những sản phẩm đảm bảo chất
        lượng m&agrave; c&ograve;n gi&uacute;p cho việc giảm gi&aacute; th&agrave;nh, tăng hiệu quả cạnh
        tranh v&agrave; kinh doanh cao hơn.</p>
      <p style="text-align: justify;">Những sản phẩm chủ yếu do X&iacute; nghiệp In DORAEMON sản xuất như: tập
        học sinh, sổ tay cao cấp, lịch, bao b&igrave;, sổ notebook, agenda, catalogue, brochure quảng
        c&aacute;o, văn ph&ograve;ng phẩm&hellip;</p>
      <p class="caption" style="text-align: justify;">DORAEMON NH&Agrave; PH&Acirc;N PHỐI S&Aacute;CH NGOẠI VĂN
        CHUY&Ecirc;N NGHIỆP</p>
      <p style="text-align: justify;">D&ugrave; l&agrave; những bạn đọc nhỏ tuổi hay những bậc cao ni&ecirc;n,
        d&ugrave; l&agrave; bạn đọc ở TP.HCM hay ở c&aacute;c tỉnh th&agrave;nh kh&aacute;c tr&ecirc;n cả
        nước th&igrave; t&ecirc;n DORAEMON đ&atilde; trở n&ecirc;n th&acirc;n quen v&agrave; tin cậy với họ
        trong những năm qua. C&oacute; thể n&oacute;i, hệ thống gần 60 Nh&agrave; s&aacute;ch của DORAEMON
        l&agrave; những điểm sinh hoạt văn h&oacute;a th&acirc;n quen d&agrave;nh cho mọi đối tượng bạn đọc.
        Trong số đ&oacute;, nh&agrave; s&aacute;ch Xu&acirc;n Thu ở địa chỉ cũ số 185, Đồng Khởi, Quận 1,
        TP.HCM, nay chuyển về 391-391A Trần Hưng Đạo, Quận 1, TP.HCM tọa lạc tại một địa điểm kh&aacute;
        l&yacute; tưởng nằm ở trung t&acirc;m Th&agrave;nh phố, từ l&acirc;u đ&atilde; l&agrave; địa chỉ
        quen thuộc của đ&ocirc;ng đảo bạn đọc trong v&agrave; ngo&agrave;i nước v&agrave; nơi đ&acirc;y được
        xem l&agrave; địa điểm ph&aacute;t h&agrave;nh s&aacute;ch ngoại văn được xếp v&agrave;o loại bậc
        nhất ở TP.HCM v&agrave; của cả nước.</p>
      <p style="text-align: justify;">C&ugrave;ng với xu thế hội nhập quốc tế đang ng&agrave;y c&agrave;ng mở
        rộng, nhu cầu t&igrave;m hiểu v&agrave; giao lưu văn ho&aacute; giữa c&aacute;c nước đang
        ng&agrave;y c&agrave;ng ph&aacute;t triển, C&ocirc;ng ty DORAEMON ng&agrave;y c&agrave;ng xứng
        đ&aacute;ng với tầm v&oacute;c l&agrave; nh&agrave; ph&aacute;t h&agrave;nh đ&aacute;ng tin cậy của
        hơn 200 NXB tr&ecirc;n Thế giới như Oxford, Cambridge, Pearson, McGraw-Hill, MacMillan, Cengage
        Learning, Reed Elsevier, Taylor &amp; Francis, Heinemann, Hachette &eacute;dition, Larousse,
        Cl&eacute; International, Bắc Kinh, Thượng Hải, Hồng K&ocirc;ng&hellip; Thế mạnh của C&ocirc;ng ty
        DORAEMON trong lĩnh vực ph&acirc;n phối s&aacute;ch ngoại văn bao gồm cả hai mảng ch&iacute;nh:
        s&aacute;ch học ngữ English language teaching (ELT) v&agrave; mảng s&aacute;ch chuy&ecirc;n
        ng&agrave;nh (Academic).</p>
      <p style="text-align: justify;">Về lĩnh vực s&aacute;ch ELT, hiện nay DORAEMON đ&atilde; v&agrave; đang
        l&agrave; nh&agrave; ph&acirc;n phối tất cả c&aacute;c loại s&aacute;ch học ngữ, từ điển, c&aacute;c
        gi&aacute;o tr&igrave;nh tiếng Anh với đủ mọi cấp độ cho c&aacute;c Trung t&acirc;m Anh ngữ,
        c&aacute;c trường Đại học ở TP.HCM n&oacute;i ri&ecirc;ng v&agrave; cả nước n&oacute;i chung
        th&ocirc;ng qua c&aacute;c loại s&aacute;ch từ những NXB danh tiếng tr&ecirc;n thế giới như Oxford,
        Cambridge, Pearson Education, Cengage Learning, McGraw-Hill&hellip; Đặc biệt, ở lĩnh vực n&agrave;y
        DORAEMON l&agrave; nh&agrave; ph&aacute;t h&agrave;nh độc quyền c&aacute;c ấn phẩm của NXB Oxford tại
        thị trường Việt Nam bộ s&aacute;ch Let&rsquo;s Go; hợp t&aacute;c với NXB Cambridge in ấn v&agrave;
        ph&aacute;t h&agrave;nh tại Việt Nam một số bộ gi&aacute;o tr&igrave;nh Anh ngữ New Interchange,
        Connect, American Primary Colors; Vocabulary in use; Grammar in use&hellip; nhằm giảm bớt gi&aacute;
        th&agrave;nh so với gi&aacute; s&aacute;ch nhập khẩu, phục vụ nhu cầu t&igrave;m hiểu n&acirc;ng cao
        vốn tiếng Anh của đ&ocirc;ng đảo độc giả.</p>
      <p style="text-align: justify;">Về lĩnh vực s&aacute;ch chuy&ecirc;n ng&agrave;nh (Academic), DORAEMON vẫn
        được xem l&agrave; nh&agrave; ph&acirc;n phối lớn nhất c&aacute;c loại s&aacute;ch chuy&ecirc;n
        ng&agrave;nh phục vụ nhu cầu học tập, nghi&ecirc;n cứu cho c&aacute;c bạn sinh vi&ecirc;n,
        c&aacute;c gi&aacute;o vi&ecirc;n, gi&aacute;o sư, những người l&agrave;m c&ocirc;ng t&aacute;c
        nghi&ecirc;n cứu v&agrave; hầu hết mọi đối tượng bạn đọc. DORAEMON lu&ocirc;n năng động v&agrave; nhạy
        b&eacute;n trong việc nắm bắt nhu cầu của kh&aacute;ch h&agrave;ng, khai th&aacute;c tối đa
        v&agrave; phục vụ kịp thời nhu cầu của bạn đọc gần xa. Hiện nay, DORAEMON đang l&agrave; nh&agrave;
        ph&aacute;t h&agrave;nh cho c&aacute;c tập đo&agrave;n xuất bản lớn của Anh, Mỹ như NXB McGraw-Hill,
        Pearson Education, Cengage Learning, John Wiley&hellip;. Đến với cửa h&agrave;ng s&aacute;ch ngoại
        văn của DORAEMON bạn đọc sẽ t&igrave;m thấy h&agrave;ng loạt c&aacute;c loại s&aacute;ch chuy&ecirc;n
        ng&agrave;nh bao gồm c&aacute;c thể loại đa dạng thuộc c&aacute;c lĩnh vực Kinh tế, Tin học, Y học,
        Kiến tr&uacute;c, Hội họa, Khoa học kỹ thuật v&agrave; c&aacute;c loại s&aacute;ch tham khảo
        kh&aacute;c.</p>
      <p style="text-align: justify;">Với phương ch&acirc;m phục vụ qu&yacute; kh&aacute;ch ng&agrave;y
        c&agrave;ng tốt hơn, C&ocirc;ng ty DORAEMON sẽ nỗ lực v&agrave; phấn đấu hơn nữa để mang đến cho bạn
        đọc nhiều s&aacute;ch hay, s&aacute;ch tốt n&ecirc;n kh&ocirc;ng chỉ ở Nh&agrave; s&aacute;ch
        Xu&acirc;n Thu, T&acirc;n Định, S&agrave;i G&ograve;n l&agrave; nơi ph&aacute;t h&agrave;nh
        s&aacute;ch đầy đủ s&aacute;ch ngoại văn m&agrave; trong một tương lai kh&ocirc;ng xa, bạn đọc
        c&oacute; thể t&igrave;m mua bất kỳ c&aacute;c tựa s&aacute;ch nước ngo&agrave;i n&agrave;o ở hầu
        hết c&aacute;c cửa h&agrave;ng trực thuộc DORAEMON.</p>
      <p class="caption" style="text-align: justify;">TẦM NH&Igrave;N V&Agrave; PHƯƠNG HƯỚNG PH&Aacute;T TRIỂN
        CỦA THƯƠNG HIỆU DORAEMON TRONG TƯƠNG LAI</p>
      <p style="text-align: justify;">Từ 2005 đến nay, DORAEMON đ&atilde; nhất qu&aacute;n v&agrave; thực hiện
        th&agrave;nh c&ocirc;ng chiến lược xuy&ecirc;n suốt l&agrave; x&acirc;y dựng, ph&aacute;t triển Hệ
        thống Nh&agrave; s&aacute;ch chuy&ecirc;n nghiệp tr&ecirc;n to&agrave;n quốc.T&iacute;nh đến nay,
        sau hơn 6 năm thực hiện chiến lược, b&ecirc;n cạnh hệ thống gần 20 Nh&agrave; s&aacute;ch được
        h&igrave;nh th&agrave;nh từ năm 1976 v&agrave; được ph&acirc;n bổ rộng khắp tr&ecirc;n phạm vi
        TP.HCM, DORAEMON đ&atilde; cơ bản ho&agrave;n thiện giai đoạn 1 trong kế hoạch ph&aacute;t triển mạng
        lưới ở khắp c&aacute;c tỉnh th&agrave;nh tr&ecirc;n to&agrave;n quốc với th&agrave;nh tựu: gần 80%
        c&aacute;c tỉnh th&agrave;nh miền Nam v&agrave; miền Trung đều c&oacute; mặt &iacute;t nhất một
        Nh&agrave; s&aacute;ch DORAEMON. Một số tỉnh th&agrave;nh lớn đ&atilde; c&oacute; mặt Nh&agrave;
        s&aacute;ch thứ 2, thứ 3 của DORAEMON như: B&igrave;nh Dương, Đồng Nai, Cần Thơ, Đ&agrave; Nẵng,
        H&agrave; Nội&hellip;</p>
      <p style="text-align: justify;">Tiếp tục định hướng hoạt động chuy&ecirc;n ng&agrave;nh v&agrave; thực
        hiện chiến lược ph&aacute;t triển mạng lưới, từ năm 2013 &ndash; 2020 DORAEMON sẽ ph&aacute;t triển
        mạnh hệ thống Nh&agrave; s&aacute;ch tại c&aacute;c tỉnh th&agrave;nh ph&iacute;a Bắc. Hiện nay,
        Nh&agrave; s&aacute;ch DORAEMON đ&atilde; c&oacute; mặt tại H&agrave; Nội, H&agrave; Tĩnh, Vĩnh
        Ph&uacute;c, Hải Ph&ograve;ng, Thanh H&oacute;a.</p>
      <p style="text-align: justify;">Dự kiến 2020, Hệ thống Nh&agrave; s&aacute;ch DORAEMON sẽ c&oacute; khoảng
        100 Nh&agrave; s&aacute;ch tr&ecirc;n to&agrave;n quốc. Tiếp tục giữ vững vị thế l&agrave; hệ thống
        Nh&agrave; s&aacute;ch h&agrave;ng đầu Việt Nam v&agrave; nằm trong Top 10 nh&agrave; b&aacute;n lẻ
        h&agrave;ng đầu Việt Nam (t&iacute;nh cho tất cả c&aacute;c ng&agrave;nh h&agrave;ng).</p>
      <p style="text-align: justify;">Dự &aacute;n x&acirc;y dựng Trung t&acirc;m s&aacute;ch tại TP.HCM với
        diện t&iacute;ch 5.000m&sup2; đến 10.000m&sup2;, gồm đầy đủ c&aacute;c loại h&igrave;nh hoạt động về
        s&aacute;ch, phấn đấu x&acirc;y dựng phong c&aacute;ch kinh doanh hiện đại, ngang tầm với c&aacute;c
        nước trong khu vực. DORAEMON sẽ l&agrave; k&ecirc;nh ti&ecirc;u thụ ch&iacute;nh của c&aacute;c
        Nh&agrave; xuất bản, c&aacute;c C&ocirc;ng ty Truyền th&ocirc;ng Văn h&oacute;a v&agrave; l&agrave;
        đối t&aacute;c tin cậy của c&aacute;c Nh&agrave; cung cấp trong v&agrave; ngo&agrave;i nước. Đồng
        thời DORAEMON giữ vũng vị tr&iacute; Nh&agrave; nhập khẩu v&agrave; kinh doanh s&aacute;ch ngoại văn
        h&agrave;ng đầu Việt Nam.</p>
      <p class="caption" style="text-align: justify;">SỨ MỆNH CỦA DORAEMON: &ldquo;MANG TRI THỨC, VĂN H&Oacute;A
        ĐỌC ĐẾN VỚI MỌI NH&Agrave;&rdquo;!</p>
      <p style="text-align: justify;">DORAEMON l&agrave; thương hiệu h&agrave;ng đầu trong ng&agrave;nh
        Ph&aacute;t h&agrave;nh s&aacute;ch Việt Nam, ngay từ thời bao cấp cho đến thời kỳ kinh tế thị
        trường, đổi mới, hội nhập quốc tế, C&ocirc;ng ty DORAEMON lu&ocirc;n khẳng định vị thế đầu
        ng&agrave;nh v&agrave; được đ&aacute;nh gi&aacute; cao trong qu&aacute; tr&igrave;nh x&acirc;y dựng
        đời sống văn h&oacute;a, trước hết l&agrave; văn h&oacute;a đọc của nước nh&agrave;. L&agrave; doanh
        nghiệp kinh doanh tr&ecirc;n lĩnh vực văn h&oacute;a, C&ocirc;ng ty DORAEMON c&oacute; vai tr&ograve;
        v&agrave; vị thế trong việc giữ vững định hướng tư tưởng văn h&oacute;a của Nh&agrave; nước,
        g&oacute;p phần t&iacute;ch cực v&agrave;o việc đ&aacute;p ứng nhu cầu đọc s&aacute;ch của
        Nh&acirc;n d&acirc;n Th&agrave;nh phố Hồ Ch&iacute; Minh v&agrave; cả nước; thể hiện to&agrave;n
        diện c&aacute;c chức năng kinh tế - văn h&oacute;a - x&atilde; hội. Th&ocirc;ng qua c&aacute;c chủ
        trương v&agrave; hoạt động như: duy tr&igrave; một số Nh&agrave; s&aacute;ch ở c&aacute;c tỉnh
        c&oacute; nền kinh tế chưa ph&aacute;t triển, c&ocirc;ng tr&igrave;nh Xe s&aacute;ch Lưu động DORAEMON
        phục vụ bạn đọc ngoại th&agrave;nh tại c&aacute;c huyện v&ugrave;ng s&acirc;u, v&ugrave;ng xa, định
        kỳ tổ chức c&aacute;c Hội s&aacute;ch với nhiều quy m&ocirc; lớn nhỏ kh&aacute;c nhau&hellip; chứng
        minh rằng DORAEMON kh&ocirc;ng chỉ quan t&acirc;m đến việc kinh doanh m&agrave; c&ograve;n mang đến
        mọi người nguồn tri thức qu&yacute; b&aacute;u, g&oacute;p phần kh&ocirc;ng ngừng n&acirc;ng cao
        d&acirc;n tr&iacute; cho người d&acirc;n ở mọi miền đất nước, thể hiện sự h&agrave;i h&ograve;a giữa
        c&aacute;c mục ti&ecirc;u kinh doanh v&agrave; hoạt động phục vụ x&atilde; hội của DORAEMON.</p>
      <p style="text-align: justify;">Hiện nay, C&ocirc;ng ty DORAEMON đ&atilde; v&agrave; đang ng&agrave;y
        c&agrave;ng nỗ lực hơn trong hoạt động sản xuất kinh doanh, tiếp tục g&oacute;p phần v&agrave;o sự
        nghiệp ph&aacute;t triển &ldquo;văn h&oacute;a đọc&rdquo;, l&agrave;m cho những gi&aacute; trị vĩnh
        hằng của s&aacute;ch ng&agrave;y c&agrave;ng thấm s&acirc;u v&agrave;o đời sống văn h&oacute;a tinh
        thần của x&atilde; hội, nhằm g&oacute;p phần t&iacute;ch cực, đ&aacute;p ứng y&ecirc;u cầu
        n&acirc;ng cao d&acirc;n tr&iacute;, bồi dưỡng nh&acirc;n t&agrave;i v&agrave; nguồn nh&acirc;n lực
        cho sự nghiệp c&ocirc;ng nghiệp h&oacute;a, hiện đại h&oacute;a đất nước, trong bối cảnh
        Th&agrave;nh phố Hồ Ch&iacute; Minh v&agrave; x&atilde; hội Việt Nam đang ng&agrave;y c&agrave;ng
        hội nhập s&acirc;u rộng v&agrave;o nền văn h&oacute;a, kinh tế tri thức của thế giới.</p>
      <p class="caption" style="text-align: justify;">BẢNG V&Agrave;NG TH&Agrave;NH T&Iacute;CH DORAEMON
        Đ&Atilde; ĐẠT ĐƯỢC TỪ NĂM 2008 - 2012 TRONG HOẠT ĐỘNG SẢN XUẤT KINH DOANH V&Agrave; C&Ocirc;NG
        T&Aacute;C X&Atilde; HỘI</p>
      <ul>
        <li>&nbsp;Cờ Thi đua của Ch&iacute;nh phủ &ndash; Thủ tướng Ch&iacute;nh phủ &ndash; ng&agrave;y
          28/4/2008.</li>
        <li>Cờ thi đua Đơn vị xuất sắc năm 2008 của UBND TP.HCM.</li>
        <li>Đạt giải thưởng &laquo;&nbsp;Sao v&agrave;ng Phương Nam&nbsp;&raquo; v&agrave; giải thưởng
          &ldquo;Top 100 Sao v&agrave;ng Đất Việt&rdquo; của Ủy ban Trung ương Hội c&aacute;c
          nh&agrave;&nbsp; doanh nghiệp Trẻ Việt Nam năm 2008.</li>
        <li>Bằng khen của Bộ trưởng Bộ Th&ocirc;ng tin &amp; truyền th&ocirc;ng ho&agrave;n th&agrave;nh tốt
          nhiệm vụ ph&aacute;t h&agrave;nh xuất bản phẩm năm 2008.</li>
        <li>Top 500 nh&agrave; b&aacute;n lẻ h&agrave;ng đầu Ch&acirc;u &Aacute; &ndash; Th&aacute;i
          B&igrave;nh Dương do Tạp ch&iacute; B&aacute;n lẻ Ch&acirc;u &Aacute; (Singapore) b&igrave;nh
          chọn năm 2009.</li>
        <li>Top 10 Doanh nghiệp b&aacute;n lẻ h&agrave;ng đầu Việt Nam do tạp ch&iacute; Retail Asia 2008
          b&igrave;nh chọn.</li>
        <li>Top Trade Services 2008 do Bộ C&ocirc;ng Thương trao tặng.</li>
        <li>L&agrave; doanh nghiệp ph&aacute;t h&agrave;nh s&aacute;ch duy nhất trong 10 doanh nghiệp
          b&aacute;n lẻ h&agrave;ng đầu Việt Nam được b&igrave;nh chọn nằm trong Top 500 nh&agrave;
          b&aacute;n lẻ h&agrave;ng đầu khu vực Ch&acirc;u &Aacute; - Th&aacute;i B&igrave;nh Dương do tạp
          ch&iacute; Retail Asia năm 2009.</li>
        <li>Top 500 doanh nghiệp lớn nhất Việt Nam VNR500 do Vietnamnet xếp hạng.</li>
        <li>Giải thưởng Sao v&agrave;ng đất Việt 2009&nbsp; - Top 200 thương hiệu Việt Nam do TW Đo&agrave;n
          TNCS TP.HCM &amp; Hội c&aacute;c Nh&agrave; Doanh Nghiệp Trẻ trao tặng.</li>
        <li>Tổng Gi&aacute;m Đốc Phạm Minh Thuận được tặng Danh hiệu Doanh nh&acirc;n S&agrave;i G&ograve;n
          ti&ecirc;u biểu năm 2009.</li>
        <li>Cờ thi đua Đơn vị xuất sắc năm 2009 của UBND TP.HCM.</li>
        <li>Cờ thi đua Đơn vị xuất sắc dẫn đầu phong tr&agrave;o thi đua năm 2009 của Bộ Th&ocirc;ng tin
          &ndash; Truyền th&ocirc;ng.</li>
        <li>Thương hiệu Việt y&ecirc;u th&iacute;ch nhất 2010 (do bạn đọc b&aacute;o S&agrave;i G&ograve;n
          Giải Ph&oacute;ng b&igrave;nh chọn).</li>
        <li>Giải thưởng Sao v&agrave;ng đất Việt 2010 &ndash; Top 200 thương hiệu Việt Nam do TW Đo&agrave;n
          TNCS TP.HCM &amp; Hội c&aacute;c Nh&agrave; Doanh Nghiệp Trẻ trao tặng.</li>
        <li>Cờ thi đua Đơn vị Xuất Sắc Năm 2010 của Bộ Th&ocirc;ng Tin Truyền Th&ocirc;ng trao tặng.</li>
        <li>Cờ thi đua Đơn vị Xuất Sắc Năm 2010 của Uy Ban Nh&acirc;n D&acirc;n TP.HCM trao tặng.</li>
        <li>Top 100 Doanh Nghiệp Thương mại &ndash; Dịch Vụ Ti&ecirc;u Biểu 2010 &ndash; VietNam Top Trade
          Service Award 2010.</li>
        <li>Giải thưởng sao v&agrave;ng đất Việt 4 năm liền từ 2008 đến 2011.</li>
        <li>Giải thưởng Thương hiệu Việt được y&ecirc;u th&iacute;ch nhất 2010, 2011.</li>
        <li>Xe s&aacute;ch lưu động: Bằng khen của Ban Tuy&ecirc;n Gi&aacute;o Trung ương năm 2011.</li>
        <li>Top 50 Nh&atilde;n hiệu nổi tiếng, Top 500 doanh nghiệp lớn nhất Việt nam 2011.</li>
        <li>Doanh nh&acirc;n S&agrave;i G&ograve;n ti&ecirc;u biểu 2011.</li>
        <li>Danh hiệu H&agrave;ng Việt Nam chất lượng cao 12 liền từ 2000 đến 2012.</li>
        <li>Năm 2012, DORAEMON được Thủ tướng ch&iacute;nh phủ tặng bằng khen v&igrave; đ&atilde; c&oacute;
          th&agrave;nh t&iacute;ch trong c&ocirc;ng t&aacute;c tổ chức Hội s&aacute;ch TP.Hồ Ch&iacute;
          Minh li&ecirc;n tục nhiều năm qua.</li>
        <li>Top 500 nh&agrave; b&aacute;n lẻ h&agrave;ng đầu Ch&acirc;u &Aacute; &ndash; Th&aacute;i
          B&igrave;nh Dương, Top 10 Nh&agrave; b&aacute;n lẻ h&agrave;ng đầu Việt Nam do Tạp ch&iacute;
          B&aacute;n lẻ Ch&acirc;u &Aacute; (Singapore) b&igrave;nh chọn.</li>
      </ul>
      <p class="caption" style="text-align: justify;">Bộ m&aacute;y tổ chức</p>
    </div>
  </div>
</div>
<!-----footer------>
<%@include file="/common/web/footer.jsp"%>

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
<script src="${pageContext.request.contextPath}/templates/scripts/header.js"></script>

</body>

</html>
