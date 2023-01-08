package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.IAuthorDAO;
import vn.edu.hcmuaf.fit.dao.impl.AuthorDAO;
import vn.edu.hcmuaf.fit.model.AuthorModel;
import vn.edu.hcmuaf.fit.services.IAuthorService;

import javax.inject.Inject;
import java.util.List;

public class AuthorService implements IAuthorService {

    private IAuthorDAO authorDAO = new AuthorDAO();

    @Override
    public List<AuthorModel> findAll() {
        return authorDAO.findAll();
    }

    @Override
    public List<AuthorModel> find10Author() {
        return authorDAO.find10Author();
    }
}
