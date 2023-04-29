package vn.edu.hcmuaf.fit.model;

import java.sql.Date;
import java.sql.Timestamp;

public class SlidePrModel  extends AbstractModel<SlidePrModel>  {
    private int idPr;
    private String namePr;
    private String img;
    private String link;
    private Date startTime;
    private Date finishTime;
    private Timestamp createTime;
    private int status;

    public SlidePrModel() {
    }

    public int getIdPr() {
        return idPr;
    }

    public void setIdPr(int idPr) {
        this.idPr = idPr;
    }

    public String getNamePr() {
        return namePr;
    }

    public void setNamePr(String namePr) {
        this.namePr = namePr;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SlidePrModel{" +
                "idPr='" + idPr + '\'' +
                ", namePr='" + namePr + '\'' +
                ", img='" + img + '\'' +
                ", link='" + link + '\'' +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", createTime=" + createTime +
                '}';
    }
}
