package vn.edu.hcmuaf.fit.model;

public class StartModel {
    private int start1;
    private int start2;
    private int start3;
    private int start4;
    private int start5;

    public StartModel() {
        this.start1 = 0;
        this.start2 = 0;
        this.start3 = 0;
        this.start4 = 0;
        this.start5 = 0;
    }

    public StartModel(int start1, int start2, int start3, int start4, int start5) {
        this.start1 = start1;
        this.start2 = start2;
        this.start3 = start3;
        this.start4 = start4;
        this.start5 = start5;
    }

    public int getStart1() {
        return start1;
    }

    public void setStart1(int start1) {
        this.start1 = start1;
    }

    public int getStart2() {
        return start2;
    }

    public void setStart2(int start2) {
        this.start2 = start2;
    }

    public int getStart3() {
        return start3;
    }

    public void setStart3(int start3) {
        this.start3 = start3;
    }

    public int getStart4() {
        return start4;
    }

    public void setStart4(int start4) {
        this.start4 = start4;
    }

    public int getStart5() {
        return start5;
    }

    public void setStart5(int start5) {
        this.start5 = start5;
    }
}
