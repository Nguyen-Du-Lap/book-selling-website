package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.RateModel;

import java.util.List;

public interface IRateDAO {
    public List<RateModel> listRate(int idBook);
    public List<RateModel> listAll();
    public void hideRate(String idOrder, String idBook);

    void actitvityRate(String idOrder, String idBook);
}
