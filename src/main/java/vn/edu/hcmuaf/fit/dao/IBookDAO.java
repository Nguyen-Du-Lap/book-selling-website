package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.BookModel;

import java.util.List;

public interface IBookDAO{
    List<BookModel> listBookPayTop();
    List<BookModel> listBookNewReissue();
    List<BookModel> listBookReissue();
}
