package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.AuthorModel;

import java.util.List;

public interface IAuthorDAO {
    List<AuthorModel> findAll();
    List<AuthorModel> find10Author();
}
