package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IBookDAO;
import vn.edu.hcmuaf.fit.dao.IBookManagementDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.BookModel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO {
    @Override
    public List<BookModel> listBookPayTop() {
        List<BookModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book,b.name, a.name, b.price - b.price * b.discount_price AS giagiam\n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment,b.id_pc,b.id_p\n" +
                "FROM book b LEFT JOIN author a ON b.id_author = a.id_author\n" +
                "LEFT JOIN v_rate ON b.id_book = v_rate.id_book\n" +
                "LEFT JOIN v_comment ON b.id_book = v_comment.id_book\n" +
                "JOIN v_sl_pay_top ON b.id_book = v_sl_pay_top.id_book\n" +
                "ORDER BY v_sl_pay_top.sl_book DESC\n" +
                "LIMIT 10");


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
                    bookModel.setIdCP(resultSet.getString(9));
                    bookModel.setIdP(resultSet.getString(10));

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
    public List<BookModel> listBookPayTopInProduct() {
        List<BookModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book ,b.name, a.name, b.price - b.price * b.discount_price AS giagiam\n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment,b.id_pc,b.id_p\n" +
                "FROM book b LEFT JOIN author a ON b.id_author = a.id_author\n" +
                "LEFT JOIN v_rate ON b.id_book = v_rate.id_book\n" +
                "LEFT JOIN v_comment ON b.id_book = v_comment.id_book\n" +
                "JOIN v_sl_pay_top ON b.id_book = v_sl_pay_top.id_book\n" +
                "ORDER BY v_sl_pay_top.sl_book DESC");


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
                    bookModel.setIdCP(resultSet.getString(9));
                    bookModel.setIdP(resultSet.getString(10));
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
    public List<BookModel> listBookNewReissue() {
        List<BookModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price - b.price * b.discount_price + b.price AS giagiam \n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment,b.id_pc,b.id_p\n" +
                "FROM book b LEFT JOIN author a ON b.id_author = a.id_author\n" +
                "LEFT JOIN v_rate ON b.id_book = v_rate.id_book \n" +
                "LEFT JOIN v_comment ON b.id_book = v_comment.id_book\n" +
                "WHERE b.isNew = 1\n" +
                "LIMIT 10");


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
                    bookModel.setIdCP(resultSet.getString(9));
                    bookModel.setIdP(resultSet.getString(10));
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
    public List<BookModel> listBookNewInProduct() {
        List<BookModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price - b.price * b.discount_price + b.price AS giagiam \n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment,b.id_pc,b.id_p\n" +
                "FROM book b LEFT JOIN author a ON b.id_author = a.id_author\n" +
                "LEFT JOIN v_rate ON b.id_book = v_rate.id_book \n" +
                "LEFT JOIN v_comment ON b.id_book = v_comment.id_book\n" +
                "WHERE b.isNew = 1");


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
                    bookModel.setIdCP(resultSet.getString(9));
                    bookModel.setIdP(resultSet.getString(10));
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
    public List<BookModel> listBookReissue() {
        List<BookModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price - b.price * b.discount_price AS giagiam \n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment,b.id_pc,b.id_p\n" +
                "FROM book b LEFT JOIN author a ON b.id_author = a.id_author\n" +
                "LEFT JOIN v_rate ON b.id_book = v_rate.id_book \n" +
                "LEFT JOIN v_comment ON b.id_book = v_comment.id_book\n" +
                "WHERE b.isNew = 1 AND b.quantity = 0\n" +
                "LIMIT 10");


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
                    bookModel.setIdCP(resultSet.getString(9));
                    bookModel.setIdP(resultSet.getString(10));
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
    public List<BookModel> listBookReissueInProduct() {
        List<BookModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price - b.price * b.discount_price AS giagiam \n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment,b.id_pc,b.id_p\n" +
                "FROM book b LEFT JOIN author a ON b.id_author = a.id_author\n" +
                "LEFT JOIN v_rate ON b.id_book = v_rate.id_book \n" +
                "LEFT JOIN v_comment ON b.id_book = v_comment.id_book\n" +
                "WHERE b.isNew = 0");


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
                    bookModel.setIdCP(resultSet.getString(9));
                    bookModel.setIdP(resultSet.getString(10));
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
}
