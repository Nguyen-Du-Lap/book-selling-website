package vn.edu.hcmuaf.fit.model;

public class ChangePasswordModel extends AbstractModel<ChangePasswordModel> {
    private String email;
    private String oldPass;
    private String newPass;
    private String confirmPass;

    public ChangePasswordModel() {
    }

    public ChangePasswordModel(String email, String oldPass, String newPass, String confirmPass) {
        this.email = email;
        this.oldPass = oldPass;
        this.newPass = newPass;
        this.confirmPass = confirmPass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }
}
