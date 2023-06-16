package vn.edu.hcmuaf.fit.model;

public class ContactModel {
    private int id, idUser;
    private String fullName, phone,email, content;
    private int status;

    public ContactModel(int id, int idUser, String fullName, String phone, String email, String content, int status) {
        this.id = id;
        this.idUser = idUser;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.content = content;
        this.status = status;
    }

    public ContactModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
