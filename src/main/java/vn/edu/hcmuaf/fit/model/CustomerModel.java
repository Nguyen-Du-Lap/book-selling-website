package vn.edu.hcmuaf.fit.model;

import java.sql.Timestamp;

public class CustomerModel  extends AbstractModel<CustomerModel>  {
    private int idUser;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String role;
    private int status;
    private Timestamp createdTime;
    private int totalBill;
    private String code;
    private long time_active_code;
    private int typeLogin;
    public CustomerModel(String email, String pass, String firstName, String lastName, String phone, String address, String code, long time_active_code) {
        this.email = email;
        this.password = pass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.code = code;
        this.time_active_code = time_active_code;
    }

    public CustomerModel() {

    }

    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }
    public String getCode() {
        return this.code;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }
    public long getTime_active_code() {
        return time_active_code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public void setTime_active_code(long time_active_code) {
        this.time_active_code = time_active_code;
    }

    public int getTypeLogin() {
        return typeLogin;
    }

    public void setTypeLogin(int typeLogin) {
        this.typeLogin = typeLogin;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "idUser='" + idUser + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
