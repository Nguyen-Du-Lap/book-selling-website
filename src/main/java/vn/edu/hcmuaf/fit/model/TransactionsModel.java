package vn.edu.hcmuaf.fit.model;

import java.sql.Timestamp;

public class TransactionsModel  extends AbstractModel<TransactionsModel>  {
    private String idTransaction;
    private String status;
    private String idUser;
    private String nameCustomer;
    private String emailCustomer;
    private String phoneCustomer;
    private int quantity;
    private String payment;
    private String paymentInfo;
    private String messenger;
    private String security;
    private Timestamp created;

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "TransactionsModel{" +
                "idTransaction='" + idTransaction + '\'' +
                ", status='" + status + '\'' +
                ", idUser='" + idUser + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", emailCustomer='" + emailCustomer + '\'' +
                ", phoneCustomer='" + phoneCustomer + '\'' +
                ", quantity=" + quantity +
                ", payment='" + payment + '\'' +
                ", paymentInfo='" + paymentInfo + '\'' +
                ", messenger='" + messenger + '\'' +
                ", security='" + security + '\'' +
                ", created=" + created +
                '}';
    }
}
