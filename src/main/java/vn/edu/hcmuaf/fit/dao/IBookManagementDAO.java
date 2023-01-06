package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.BookManagementModel;

import java.nio.file.Files;
import java.util.List;

public interface IBookManagementDAO {
    List<BookManagementModel> findAllBook();
    int deleteById(int id);

    BookManagementModel findById(int id);
    List<String> listById(String id);
    int update(int id, String name, int quantity, double price, double discount);
    List<String> listCatalog();

    List<String> listPublisherCompany();
    List<String> listPublisher();

    int findIdCatalogByName(String catalog);

    int findIdPCByName(String publisherCompany);

    int findIdPByName(String publisher);

    int insertBook(String name, int idCatalog, int quantityInt, double primeCostDouble
            , double priceDouble, int isNewAfter, int isActiveAfter, int id_pc, int id_p, int year);

    int insertBookDetail(int id, String isbn, int year, double weight, String size, int page, String language, String description);

    int insertPublisherCompany(String publisherCompany);

    void saveImage(int id, String pathF);

    int findIdByName(String name);

    int insertPublisher(String publisher);

    int insertCatalog(String catalog);

    int findListNameByName(String name);
}
