package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.AuthorModel;

import java.util.List;

public interface IAuthorService {
    List<AuthorModel> findAll();
    List<AuthorModel> find10Author();
}
