package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.IBookManagementDAO;
import vn.edu.hcmuaf.fit.dao.impl.BookManagementDAO;
import vn.edu.hcmuaf.fit.model.BookManagementModel;
import vn.edu.hcmuaf.fit.services.IBookManagementService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BookManagementService implements IBookManagementService {

    IBookManagementDAO iBookManagementDAO = new BookManagementDAO();
    @Override
    public List<BookManagementModel> findAll() {
        return iBookManagementDAO.findAllBook();
    }

    @Override
    public boolean deleteById(int id) {
        return iBookManagementDAO.deleteById(id) >= 1 ;
    }

    @Override
    public BookManagementModel findById(int id) {
        return iBookManagementDAO.findById(id);
    }

    @Override
    public int update(int id, String name, int quantity, double price, double discount) {
        return iBookManagementDAO.update(id, name, quantity, price, discount);
    }

    @Override
    public boolean addBook( String name, int quantityInt, String status, String isNew, String catalog
            , String publisherCompany, double priceDouble, double primeCostDouble, String isbn, int year
            , double weight, String size, int page, String language, String description, String publisher) {
        int idCatalog = iBookManagementDAO.findIdCatalogByName(catalog);
        int id_pc = iBookManagementDAO.findIdPCByName(publisherCompany);
        int id_p = iBookManagementDAO.findIdPByName(publisher);
        int isNewAfter = 0;
        int isActiveAfter = 0;
        if (isNew.equalsIgnoreCase("Sách mới")) {
            isNewAfter = 1;
        }
        if (status.equalsIgnoreCase("Mở bán")) {
            isActiveAfter = 1;
        }
        int insertBook = iBookManagementDAO.insertBook(name, idCatalog, quantityInt, primeCostDouble, priceDouble
                , isNewAfter, isActiveAfter, id_pc, id_p, year);
        int id = iBookManagementDAO.findIdByName(name);

        int inserBookDetail = iBookManagementDAO.insertBookDetail(id, isbn, year, weight, size, page, language, description);
        return insertBook + inserBookDetail >= 2 ;
    }

    @Override
    public boolean insertPublisherCompany(String publisherCompany) {
        return iBookManagementDAO.insertPublisherCompany(publisherCompany) >= 1 ;
    }

    @Override
    public boolean insertPublisher(String publisher) {
        return iBookManagementDAO.insertPublisher(publisher) >= 1 ;
    }

    @Override
    public void addImage(HttpServletRequest request, HttpServletResponse response, Part part, int id) {
        try {
            String realPath = request.getServletContext().getRealPath("/templates/images/sachUpload");
            String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();

            if(!Files.exists(Path.of(realPath))) {
                Files.createDirectory(Path.of(realPath));
            }
            if( !filename.equals("")) {
                //luu vao thu muc
                String pathF = realPath +"\\"+id+"-"+filename;
                part.write(pathF);
                //luu vao database
                iBookManagementDAO.saveImage(id, "/templates/images/sachUpload/"+id+"-"+filename);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean insertCatalog(String catalog) {
        return iBookManagementDAO.insertCatalog(catalog) >= 1 ;
    }

    @Override
    public boolean checkNameBook(String name) {
        return iBookManagementDAO.findListNameByName(name) >= 1;
    }
}
