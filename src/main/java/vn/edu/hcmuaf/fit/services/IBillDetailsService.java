package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.BillDetail;

import java.util.*;

public interface IBillDetailsService {
    List<BillDetail> findAll();
    BillDetail findByID(int id);
}
