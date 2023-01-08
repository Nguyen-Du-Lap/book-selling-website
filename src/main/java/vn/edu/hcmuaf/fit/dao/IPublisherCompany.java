package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.PublisherCompanyModel;

import java.util.List;

public interface IPublisherCompany {
    List<PublisherCompanyModel> findAll();
}
