package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IBookManagementDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.BookManagementModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagementDAO implements IBookManagementDAO {

    @Override
    public List<BookManagementModel> findAllBook() {
        List<BookManagementModel> listBook = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, b.quantity," +
                "CASE" +
                "      WHEN b.quantity>0 THEN 'Còn hàng'" +
                "      WHEN b.quantity=0 THEN 'Hết hàng'" +
                "END," +
                "b.price, c.name" +
                "  FROM book b JOIN catalog c ON b.id_catalog = c.id_catalog" +
                " Where isActive = 1");


        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BookManagementModel bookManagementModel = new BookManagementModel();
                    bookManagementModel.setId(resultSet.getInt(1));
                    bookManagementModel.setName(resultSet.getString(2));
                    bookManagementModel.setQuantity(resultSet.getInt(3));
                    bookManagementModel.setStatus(resultSet.getString(4));
                    bookManagementModel.setPrice(resultSet.getDouble(5));
                    bookManagementModel.setCategory(resultSet.getString(6));

                    String image = findImageById(resultSet.getInt(1));
                    bookManagementModel.setImage(image);
                    listBook.add(bookManagementModel);
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
    public int deleteById(int id) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("UPDATE book SET isActive = 0 WHERE id_book = ?");
        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, id);
                return statement.executeUpdate();
            } catch (SQLException e) {
                return  0;
            } finally {
                try {
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }
    @Override
    public BookManagementModel findById(int id){
        List<BookManagementModel> users = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT b.id_book, b.name, b.quantity," +
                "CASE" +
                "      WHEN b.quantity>0 THEN 'Còn hàng'" +
                "      WHEN b.quantity=0 THEN 'Hết hàng'" +
                "END," +
                "b.price, c.name, b.discount_price" +
                "  FROM book b JOIN catalog c ON b.id_catalog = c.id_catalog" +
                " Where isActive = 1 AND id_book = ?");

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BookManagementModel bookManagementModel = new BookManagementModel();
                    bookManagementModel.setId(resultSet.getInt(1));
                    bookManagementModel.setName(resultSet.getString(2));
                    bookManagementModel.setQuantity(resultSet.getInt(3));
                    bookManagementModel.setStatus(resultSet.getString(4));
                    bookManagementModel.setPrice(resultSet.getDouble(5));
                    bookManagementModel.setCategory(resultSet.getString(6));
                    bookManagementModel.setDiscount(resultSet.getDouble(7));
                    users.add(bookManagementModel);
                }

                return users.isEmpty() ? null : users.get(0);
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
    public int update(int id, String name, int quantity, double price, double discount) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("UPDATE book \n" +
                "SET name = ?,\n" +
                "\tquantity = ?,\n" +
                "\tdiscount_price = ?,\n" +
                "\tprice = ?\t\n" +
                "WHERE id_book = ?");

        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(5, id);
                statement.setString(1, name);
                statement.setInt(2, quantity);
                statement.setDouble(3, discount);
                statement.setDouble(4, price);
                return statement.executeUpdate();
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public List<String> listCatalog() {
        List<String> list = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("Select name FROM catalog");

        PreparedStatement statement = null;
        ResultSet resultSet;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    list.add(resultSet.getString(1));
                }
                return list;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public List<String> listPublisherCompany() {
        List<String> list = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("Select name From publisher_company");

        PreparedStatement statement = null;
        ResultSet resultSet;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    list.add(resultSet.getString(1));
                }
                return list;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }

    public List<String> listPublisher() {
        List<String> list = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("Select name From publisher");

        PreparedStatement statement = null;
        ResultSet resultSet;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    list.add(resultSet.getString(1));
                }
                return list;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }
    @Override
    public List<String> listById(String id) {
        List<String> list = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("Select id_book From book where id_book = ?");

        PreparedStatement statement = null;
        ResultSet resultSet;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    list.add(resultSet.getString(1));
                }
                return list;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public int findIdCatalogByName(String catalog) {
        List<Integer> list = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("Select id_catalog From catalog Where name = ?");
        PreparedStatement statement = null;
        ResultSet resultSet;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, catalog);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    list.add(resultSet.getInt(1));
                }
                return list.isEmpty() ? null : list.get(0);
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public int findIdPCByName(String publisherCompany) {
        List<Integer> list = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("Select id_pc From publisher_company Where name = ?");
        PreparedStatement statement = null;
        ResultSet resultSet;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, publisherCompany);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    list.add(resultSet.getInt(1));
                }
                return list.isEmpty() ? null : list.get(0);
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public int findIdPByName(String publisher) {
        List<Integer> list = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("Select id_p From publisher Where name = ?");
        PreparedStatement statement = null;
        ResultSet resultSet;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, publisher);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    list.add(resultSet.getInt(1));
                }
                return list.isEmpty() ? null : list.get(0);
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public int insertBook(String name, int idCatalog, int quantityInt, double primeCostDouble, double priceDouble
            , int isNewAfter, int isActiveAfter, int id_pc, int id_p, int year) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("INSERT INTO book(name, id_author, id_catalog, quantity, prime_cost, " +
                "price, isNew, isActive, id_pc, id_p, published_time) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)");

        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, name);
                statement.setInt(2, 1);
                statement.setInt(3, idCatalog);
                statement.setInt(4, quantityInt);
                statement.setDouble(5, primeCostDouble);
                statement.setDouble(6, priceDouble);
                statement.setInt(7, isNewAfter);
                statement.setInt(8, isActiveAfter);
                statement.setInt(9, id_pc);
                statement.setInt(10, id_p);
                statement.setInt(11, year);
                return statement.executeUpdate();
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;

    }

    @Override
    public int insertBookDetail(int id, String isbn, int year, double weight, String size, int page, String language, String description) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("INSERT INTO book_details(id_book, isbn, year, weight, size, page, " +
                "language, description) " +
                "VALUES (?,?,?,?,?,?,?,?)");

        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, id);
                statement.setString(2, isbn);
                statement.setInt(3, year);
                statement.setDouble(4, weight);
                statement.setString(5, size);
                statement.setInt(6, page);
                statement.setString(7, language);
                statement.setString(8, description);
                return statement.executeUpdate();
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public int insertPublisherCompany(String publisherCompany) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("INSERT INTO publisher_company(name) " +
                "VALUES (?)");

        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, publisherCompany);
                return statement.executeUpdate();
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public void saveImage(int id, String pathF) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("INSERT INTO image_book(id_book, image) " +
                "VALUES (?, ?)");

        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setInt(1, id);
                statement.setString(2, pathF);
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

    @Override
    public int findIdByName(String name) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT id_book FROM book WHERE name = ?");
        List<Integer> listId = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, name);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    listId.add(resultSet.getInt(1));
                }
                return listId.isEmpty() ? null : listId.get(0);
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public int insertPublisher(String publisher) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("INSERT INTO publisher(name) " +
                "VALUES (?)");

        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, publisher);
                return statement.executeUpdate();
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public int insertCatalog(String catalog) {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("INSERT INTO catalog(name) " +
                "VALUES (?)");

        PreparedStatement statement = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, catalog);
                return statement.executeUpdate();
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public int findListNameByName(String name) {
        int result =0;
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT COUNT(*) FROM book WHERE name = ?");

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                statement.setString(1, name);
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
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 0;
    }


}
