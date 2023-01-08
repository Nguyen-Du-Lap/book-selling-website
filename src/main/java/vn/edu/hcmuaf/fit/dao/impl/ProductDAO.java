package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IProductDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.BookDetails;
import vn.edu.hcmuaf.fit.model.BookModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    @Override
    public List<BookModel> findAll() {
        List<BookModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price * b.discount_price + b.price AS giagiam \n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment\n" +
                "FROM book b LEFT JOIN author a ON b.id_author = a.id_author\n" +
                "LEFT JOIN v_rate ON b.id_book = v_rate.id_book \n" +
                "LEFT JOIN v_comment ON b.id_book = v_comment.id_book;");


        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BookModel bookModel = new BookModel();
                    bookModel.setIdBook(resultSet.getInt(1));
                    bookModel.setName(resultSet.getString(2));
                    bookModel.setNameAuthor(resultSet.getString(3));
                    bookModel.setPriceDiscount(resultSet.getDouble(4));
                    bookModel.setPrice(resultSet.getDouble(5));
                    bookModel.setDiscount(resultSet.getInt(6));
                    bookModel.setQuantityStart(resultSet.getInt(7));
                    bookModel.setQuantityComment(resultSet.getInt(8));

                    String image = findImageById(resultSet.getInt(1));
                    bookModel.setImage(image);
                    listBook.add(bookModel);
                }

                return listBook;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public List<BookModel> find12Book() {
        List<BookModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price * b.discount_price + b.price AS giagiam \n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment\n" +
                "FROM book b LEFT JOIN author a ON b.id_author = a.id_author\n" +
                "LEFT JOIN v_rate ON b.id_book = v_rate.id_book \n" +
                "LEFT JOIN v_comment ON b.id_book = v_comment.id_book\n" +
                "LIMIT 12;");


        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BookModel bookModel = new BookModel();
                    bookModel.setIdBook(resultSet.getInt(1));
                    bookModel.setName(resultSet.getString(2));
                    bookModel.setNameAuthor(resultSet.getString(3));
                    bookModel.setPriceDiscount(resultSet.getDouble(4));
                    bookModel.setPrice(resultSet.getDouble(5));
                    bookModel.setDiscount(resultSet.getInt(6));
                    bookModel.setQuantityStart(resultSet.getInt(7));
                    bookModel.setQuantityComment(resultSet.getInt(8));

                    String image = findImageById(resultSet.getInt(1));
                    bookModel.setImage(image);
                    listBook.add(bookModel);
                }

                return listBook;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }
    public String findImageById(int id) {
        List<String> images = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT image FROM image_book WHERE id_book = ?");

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    images.add(resultSet.getString(1));
                }
                return images.isEmpty() ? null : images.get(0);
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }
    @Override
    public List<BookModel> findAllLimitOffset(int limit, int offset) {
        List<BookModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price * b.discount_price + b.price AS giagiam \n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment\n" +
                "FROM book b LEFT JOIN author a ON b.id_author = a.id_author\n" +
                "LEFT JOIN v_rate ON b.id_book = v_rate.id_book \n" +
                "LEFT JOIN v_comment ON b.id_book = v_comment.id_book LIMIT ?,?");


        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, limit);
                statement.setInt(2, offset);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BookModel bookModel = new BookModel();
                    bookModel.setIdBook(resultSet.getInt(1));
                    bookModel.setName(resultSet.getString(2));
                    bookModel.setNameAuthor(resultSet.getString(3));
                    bookModel.setPriceDiscount(resultSet.getDouble(4));
                    bookModel.setPrice(resultSet.getDouble(5));
                    bookModel.setDiscount(resultSet.getInt(6));
                    bookModel.setQuantityStart(resultSet.getInt(7));
                    bookModel.setQuantityComment(resultSet.getInt(8));

                    String image = findImageById(resultSet.getInt(1));
                    bookModel.setImage(image);
                    listBook.add(bookModel);
                }

                return listBook;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public BookModel findBookDetailById(int id) {
        List<BookModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price * b.discount_price + b.price AS giagiam \n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment\n" +
                "FROM book b LEFT JOIN author a ON b.id_author = a.id_author\n" +
                "LEFT JOIN v_rate ON b.id_book = v_rate.id_book \n" +
                "LEFT JOIN v_comment ON b.id_book = v_comment.id_book\n" +
                "WHERE b.id_book = ?;");


        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BookModel bookModel = new BookModel();
                    bookModel.setIdBook(resultSet.getInt(1));
                    bookModel.setName(resultSet.getString(2));
                    bookModel.setNameAuthor(resultSet.getString(3));
                    bookModel.setPriceDiscount(resultSet.getDouble(4));
                    bookModel.setPrice(resultSet.getDouble(5));
                    bookModel.setDiscount(resultSet.getInt(6));
                    bookModel.setQuantityStart(resultSet.getInt(7));
                    bookModel.setQuantityComment(resultSet.getInt(8));

                    String image = findImageById(resultSet.getInt(1));
                    bookModel.setImage(image);
                    listBook.add(bookModel);
                }

                return listBook.isEmpty() ? null : listBook.get(0);
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public BookDetails findBookDetail1ById(int id){
        List<BookDetails> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT DISTINCT B.id_book, A.name, P.name, B.published_time, BD.weight, BD.isbn,\n" +
                "BD.size, BD.page, BD.`language`, BD.description\n" +
                "FROM book_details BD JOIN book B ON BD.id_book = B.id_book\n" +
                "JOIN author A ON A.id_author = B.id_author\n" +
                "JOIN publisher P ON B.id_p = P.id_p\n" +
                "WHERE BD.id_book = ?");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BookDetails bookDetails = new BookDetails();
                    bookDetails.setId(resultSet.getInt(1));
                    bookDetails.setNameAuthor(resultSet.getString(2));
                    bookDetails.setName(resultSet.getString(3));
                    bookDetails.setYear(resultSet.getInt(4));
                    bookDetails.setId(resultSet.getInt(5));
                    bookDetails.setIsbn(resultSet.getString(6));
                    bookDetails.setSize(resultSet.getString(7));
                    bookDetails.setPage(resultSet.getInt(8));
                    bookDetails.setLanguage(resultSet.getString(9));
                    bookDetails.setDescription(resultSet.getString(10));
                    listBook.add(bookDetails);
                }

                return listBook.isEmpty() ? null : listBook.get(0);
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }
}
