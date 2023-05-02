package vn.edu.hcmuaf.fit.model;

public class OrderReviewDetail {
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private int idcart;
    private String create_order_time;
    private String timeShip;
    private double totolPrice;
    private String trangThai;

    public OrderReviewDetail(String fullName, String address, String phone, String email, int idcart, String create_order_time, String timeShip, double totolPrice, int trangThai) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.idcart = idcart;
        this.create_order_time = create_order_time;
        this.timeShip = timeShip;
        this.totolPrice = totolPrice;

        if(trangThai == 1) {
            this.trangThai = "Chờ xử lý";
        } else if(trangThai == 2) {
            this.trangThai = "Đang vận chuyển";
        } else if(trangThai == 3) {
            this.trangThai = "Đã hoàn thành";
        } else {
            this.trangThai = "Đã hủy";
        }
    }

    public OrderReviewDetail() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdcart() {
        return idcart;
    }

    public void setIdcart(int idcart) {
        this.idcart = idcart;
    }

    public String getCreate_order_time() {
        return create_order_time;
    }

    public void setCreate_order_time(String create_order_time) {
        this.create_order_time = create_order_time;
    }

    public String getTimeShip() {
        return timeShip;
    }

    public void setTimeShip(String timeShip) {
        this.timeShip = timeShip;
    }

    public double getTotolPrice() {
        return totolPrice;
    }

    public void setTotolPrice(double totolPrice) {
        this.totolPrice = totolPrice;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        if(trangThai == 1) {
            this.trangThai = "Chờ xử lý";
        } else if(trangThai == 2) {
            this.trangThai = "Đang vận chuyển";
        } else if(trangThai == 3) {
            this.trangThai = "Đã hoàn thành";
        } else {
            this.trangThai = "Đã hủy";
        }
    }
}
