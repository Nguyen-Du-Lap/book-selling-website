package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.BookManagementModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.List;

public interface IBookManagementService {
    List<BookManagementModel> findAll();
    boolean deleteById(int id);
    BookManagementModel findById(int id);
    int update(int id, String name, int quantity, double price, double discount);

    boolean addBook(String name,int quantityInt,String status,String isNew,String catalog,String publisherCompany
            ,double priceDouble,double primeCostDouble,String isbn,int year,double weight,String size,int page,
            String language,String description, String publisher);
    boolean insertPublisherCompany(String publisherCompany);

    boolean insertPublisher(String publisher);

    void addImage(HttpServletRequest request, HttpServletResponse response, Part part1, int id);

    boolean insertCatalog(String catalog);

    boolean checkNameBook(String name);
}
