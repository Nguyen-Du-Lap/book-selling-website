package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IProductDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.BookDetails;
import vn.edu.hcmuaf.fit.model.BookModel;
import vn.edu.hcmuaf.fit.model.ImageBookModel;
import vn.edu.hcmuaf.fit.model.Product;

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
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price - b.price * b.discount_price AS giagiam \n" +
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
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price - b.price * b.discount_price AS giagiam \n" +
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
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price - b.price * b.discount_price AS giagiam \n" +
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
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price - b.price * b.discount_price AS giagiam \n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment,b.id_pc,b.id_p\n" +
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
                    bookModel.setIdCP(resultSet.getString(9));
                    bookModel.setIdP(resultSet.getString(10));
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

    @Override
    public List<String> findAddImage(int id) {
        List<String> listImage = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT image\n" +
                "FROM image_book\n" +
                "WHERE id_book = ?");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    listImage.add(resultSet.getString(1));
                }

                return listImage;
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
    public List<BookModel> find12BookSearch(String key) {
        List<BookModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price - b.price * b.discount_price AS giagiam \n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment , b.id_pc, b.id_p\n" +
                "FROM book b LEFT JOIN author a ON b.id_author = a.id_author\n" +
                "LEFT JOIN v_rate ON b.id_book = v_rate.id_book \n" +
                "LEFT JOIN v_comment ON b.id_book = v_comment.id_book\n" +
                "JOIN publisher ON b.id_p = publisher.id_p\n" +
                "JOIN publisher_company ON b.id_pc = publisher_company.id_pc\n" +
                "WHERE b.name LIKE ? OR a.name LIKE ? \n" +
                "OR publisher.name LIKE ? OR publisher_company.name LIKE ? ;");

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, "%"+key+"%");
                statement.setString(2, "%"+key+"%");
                statement.setString(3, "%"+key+"%");
                statement.setString(4, "%"+key+"%");

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
    public List<BookModel> find12BookCatalog(int idInt) {
        List<BookModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price - b.price * b.discount_price AS giagiam \n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment,b.id_pc,b.id_p\n" +
                "FROM book b LEFT JOIN author a ON b.id_author = a.id_author\n" +
                "LEFT JOIN v_rate ON b.id_book = v_rate.id_book \n" +
                "LEFT JOIN v_comment ON b.id_book = v_comment.id_book " +
                "WHERE b.id_catalog = ?");


        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, idInt);
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
    public List<BookModel> find12BookPublisher(int idInt) {
        List<BookModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, a.name, b.price - b.price * b.discount_price AS giagiam \n" +
                ", b.price, b.discount_price*100 AS giam, IF(v_rate.`start` is null, 0, v_rate.`start`) AS `start`\n" +
                ", IF(v_comment.sl_comment is null, 0, v_comment.sl_comment) AS sl_comment ,b.id_pc,b.id_p\n" +
                "FROM book b LEFT JOIN author a ON b.id_author = a.id_author\n" +
                "LEFT JOIN v_rate ON b.id_book = v_rate.id_book \n" +
                "LEFT JOIN v_comment ON b.id_book = v_comment.id_book\n" +
                "WHERE b.id_pc = ?");


        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, idInt);
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
    public int totalProduct() {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT Count(*) FROM book");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int result=0;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result = resultSet.getInt(1);
                }

                return result;
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }
    @Override
    public int outOfStock() {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT Count(*) FROM book WHERE quantity < 10");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int result=0;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result = resultSet.getInt(1);
                }

                return result;
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    //Giỏ hàng
    public String find1ImageById(int id) {
        String image = "";
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT image FROM image_book \n" +
                "WHERE id_book = ?\n" +
                "LIMIT 1;");

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    image = resultSet.getString(1);
                }

                return image;
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
    public Product getProductById(int parseInt) {
        Product product = new Product();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, b.price - b.price * b.discount_price  AS giagiam,b.price, b.quantity, bd.size,bd.weight\n" +
                " FROM book b join book_details bd\n" +
                " WHERE b.id_book = ? AND b.isActive = 1;");

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, parseInt);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    product = new Product();
                    product.setIdBook(resultSet.getInt(1));
                    product.setImage(find1ImageById(parseInt));
                    product.setName(resultSet.getString(2));
                    product.setPriceDiscount(resultSet.getDouble(3));
                    product.setPrice(resultSet.getDouble(4));
                    product.setQuantity(resultSet.getInt(5));
                    product.setSize(resultSet.getString(6));
                    product.setWeight(resultSet.getDouble(7));
                }

                return product;
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
    public int getRemainQuantity(int idBook) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT quantity FROM book WHERE id_book = ?");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int result=0;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, idBook);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result = resultSet.getInt(1);
                }

                return result;
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public void updateQuantity(int idBook, int i) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("UPDATE book SET quantity = ? WHERE id_book = ?");
        PreparedStatement statement = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, i);
                statement.setInt(2, idBook);
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
