package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.CatalogModel;

import java.util.List;

public interface ICatalogService {
    List<CatalogModel> findAll();
    List<CatalogModel> findAllTest(int limit, int offset);

    List<CatalogModel> findAllSort(int limit, int offset, String name, String type);
    Long save(CatalogModel catalogModel);
}
