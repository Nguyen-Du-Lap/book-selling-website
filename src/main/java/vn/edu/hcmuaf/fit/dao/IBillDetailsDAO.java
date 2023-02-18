package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.BillDetail;

import java.util.List;

public interface IBillDetailsDAO {
    void create(BillDetail billDetail);

    List<BillDetail> findAll();

    BillDetail findById(int id);
}
