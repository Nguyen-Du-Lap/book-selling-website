package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.ICatalogDAO;
import vn.edu.hcmuaf.fit.model.CatalogModel;
import vn.edu.hcmuaf.fit.services.ICatalogService;

import javax.inject.Inject;
import java.util.List;

public class CatalogService implements ICatalogService {
    @Inject
    private ICatalogDAO catalogDAO;

    @Override
    public List<CatalogModel> findAll() {
        return catalogDAO.findAll();
    }

    @Override
    public List<CatalogModel> findAllTest(int limit, int offset) {
        return catalogDAO.findAllTest(limit, offset);
    }

    public List<CatalogModel> findAllSort(int limit, int offset, String name, String type){
        return catalogDAO.findAllSort(limit, offset, name, type);
    }

    @Override
    public Long save(CatalogModel catalogModel) {
        return catalogDAO.save(catalogModel);
    }

}
