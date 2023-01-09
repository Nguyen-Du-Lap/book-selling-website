package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.RateModel;

import java.util.List;

public interface IRateDAO {
    public List<RateModel> listRate(int idBook);
}
