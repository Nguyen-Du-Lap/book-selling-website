package vn.edu.hcmuaf.fit.model;

import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
    private List<T> listResult = new ArrayList<>();
    private int totalCard;

    public List<T> getListResult() {
        return listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

    public int getTotalCard() {
        return totalCard;
    }

    public void setTotalCard(int totalCard) {
        this.totalCard = totalCard;
    }
}
