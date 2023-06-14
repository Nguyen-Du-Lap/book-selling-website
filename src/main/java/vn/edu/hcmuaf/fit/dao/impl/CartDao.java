package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    public int setID() {
        Connection connection = JDBCConnector.getConnection();
        String sql = new String("SELECT id FROM carts ORDER BY id DESC LIMIT 1;");
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql.toString());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result = resultSet.getInt(1);
                }

                return result+1;
            } catch (SQLException e) {
                return 0;
            } finally {
                try {
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                    if (resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return 0;
                }
            }
        }
        return 1;
    }
    public void insertCart(int id, int idUser, String timeShip, double feeShip, double totalPrice, String infoShip) {
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                String sql = "INSERT INTO carts VALUES (?, ?, ?, ?, ?, ?,null)";
                statement = connection.prepareStatement(sql);

                statement.setInt(1, id);
                statement.setInt(2, idUser);
                statement.setString(3, timeShip);
                statement.setDouble(4, feeShip);
                statement.setDouble(5, totalPrice);
                statement.setString(6, infoShip);

                statement.executeUpdate();
                System.out.println("CartModel inserted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public OrderReviewDetail getAllByIdUserAndIdCart(int id, int idCart) {
        OrderReviewDetail orderReviewDetail = new OrderReviewDetail();
        String sql = "SELECT  CONCAT(t.first_name, ' ', t.last_name) AS fullname, b.address, b.phone, t.email, b.idCart, b.create_order_time, e.timeShip, e.totalPrice, b.shipping_info\n" +
                " FROM bill b JOIN carts e ON b.idCart = e.id JOIN customer t ON e.idUser = t.id_user WHERE t.id_user = ? and b.idCart =?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.setInt(2, idCart);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    orderReviewDetail.setFullName(resultSet.getString(1));
                    orderReviewDetail.setAddress(resultSet.getString(2));
                    orderReviewDetail.setPhone(resultSet.getString(3));
                    orderReviewDetail.setEmail(resultSet.getString(4));
                    orderReviewDetail.setIdcart(resultSet.getInt(5));
                    orderReviewDetail.setCreate_order_time(resultSet.getString(6));
                    orderReviewDetail.setTimeShip(resultSet.getString(7));
                    orderReviewDetail.setTotolPrice(resultSet.getInt(8));
                    orderReviewDetail.setTrangThai(resultSet.getInt(9));
                }

                return orderReviewDetail;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }
    public List<CartDetailModel> getAllDetailCart(int id, int idCart) {
        List<CartDetailModel> result = new ArrayList<>();

        String sql = "SELECT b.idCart ,bk.name, b.quantity, imb.image, b.quantity* bk.price AS tongtien\n" +
                "FROM bill b\n" +
                "JOIN carts e ON b.idCart = e.id\n" +
                "JOIN book bk ON b.id_book = bk.id_book\n" +
                "JOIN (\n" +
                "  SELECT id_book, image\n" +
                "  FROM image_book\n" +
                "  GROUP BY id_book\n" +
                ") imb ON bk.id_book = imb.id_book WHERE b.id_user =? and b.idCart = ?  ";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.setInt(2, idCart);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CartDetailModel cartDetailModel = new CartDetailModel();
                   cartDetailModel.setId(resultSet.getInt(1));
                   cartDetailModel.setNameSach(resultSet.getString(2));
                   cartDetailModel.setQuantity(resultSet.getInt(3));
                   cartDetailModel.setImage(resultSet.getString(4));
                   cartDetailModel.setTotalPrice(resultSet.getInt(5));
                   result.add(cartDetailModel);

                }

                return result;
            } catch (SQLException e) {
                e.printStackTrace();
                return new ArrayList<>();
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
    public CartModel getCartById( int idCart) {
        CartModel result = new CartModel();

        String sql = "SELECT id, idUser, timeShip, feeShip, totalPrice, infoShip, create_Time FROM carts WHERE id =?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, idCart);

                resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    result.setId(resultSet.getInt(1));
                    result.setIdUser(resultSet.getInt(2));
                    result.setTimeShip(resultSet.getString(3));
                    result.setShip(resultSet.getInt(4));
                    result.setTotalPrice(resultSet.getInt(5));
                    result.setInShip(resultSet.getInt(6));
                    result.setCreateTime(resultSet.getTimestamp(7));

                }

                return result;
            } catch (SQLException e) {
                e.printStackTrace();
                return result;
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
    public ArrayList<CartModel> getAllCart() {
        ArrayList<CartModel> result = new ArrayList<>();
        String sql = "SELECT id, idUser, timeShip, feeShip, totalPrice, infoShip, create_time\n" +
                "FROM carts ";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CartModel cartModel = new CartModel();
                    cartModel.setId(resultSet.getInt(1));
                    cartModel.setIdUser(resultSet.getInt(2));
                    cartModel.setTimeShip(resultSet.getString(3));
                    cartModel.setShip(resultSet.getInt(4));
                    cartModel.setTotalPrice(resultSet.getDouble(5));
                    cartModel.setInShip(resultSet.getInt(6));
                    cartModel.setCreateTime(resultSet.getTimestamp(7));
                    result.add(cartModel);

                }

                return result;
            } catch (SQLException e) {
                e.printStackTrace();
                return result;
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
    public ArrayList<BookModel> top5BookBanChay() {
        String sql = "SELECT s.id_book, s.name, sum(b.quantity), s.price,SUM(b.quantity * s.price), ct.name\n" +
                "FROM bill b JOIN book s\n" +
                "ON b.id_book = s.id_book JOIN carts c\n" +
                "ON b.idCart = c.id JOIN catalog ct ON s.id_catalog = ct.id_catalog\n" +
                "WHERE c.infoShip = 3\n" +
                "GROUP BY s.id_book\n" +
                "ORDER by SUM(b.quantity * s.price)  DESC\n" +
                "LIMIT 5";
        ArrayList<BookModel> result  = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BookModel bookModel = new BookModel();
                    bookModel.setIdBook(resultSet.getInt(1));
                    bookModel.setName(resultSet.getString(2));
                    bookModel.setQuantity(resultSet.getInt(3));
                    bookModel.setPrice(resultSet.getInt(4));
                    bookModel.setCatalog(resultSet.getString(6));
                    result.add(bookModel);
                }

                return result;
            } catch (SQLException e) {
                e.printStackTrace();
                return result;
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
    public ArrayList<BookModel> bookHetHang() {
        String sql = "SELECT b.id_book, b.NAME, b.quantity, b.price,  ct.name\n" +
                "FROM book b JOIN catalog ct ON b.id_catalog = ct.id_catalog\n" +
                "WHERE quantity =0";
        ArrayList<BookModel> result  = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    BookModel bookModel = new BookModel();
                    bookModel.setIdBook(resultSet.getInt(1));
                    bookModel.setName(resultSet.getString(2));
                    bookModel.setQuantity(resultSet.getInt(3));
                    bookModel.setPrice(resultSet.getInt(4));
                    bookModel.setCatalog(resultSet.getString(5));
                    result.add(bookModel);
                }

                return result;
            } catch (SQLException e) {
                e.printStackTrace();
                return result;
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
    public int soLuongKhachMoi() {
        String sql = "SELECT COUNT(*) FROM customer  WHERE created_time >= DATE_SUB(NOW(), INTERVAL 1 MONTH) AND ROLE = 'user';";
        int result = 0;
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result = resultSet.getInt(1);
                }

                return result;
            } catch (SQLException e) {
                e.printStackTrace();
                return result;
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
    public int getAllSanPham() {
        String sql = "SELECT sum(quantity) FROM book";
        int result = 0;
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result = resultSet.getInt(1);
                }

                return result;
            } catch (SQLException e) {
                e.printStackTrace();
                return result;
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
    public double chiPhiDonHang(int idCart) {
        double  result = 0.0;

        String sql = "SELECT SUM(b.prime_cost)\n" +
                "FROM book b JOIN bill c\n" +
                "ON b.id_book = c.id_book\n" +
                "WHERE c.idCart = ?\n" +
                "GROUP BY c.idCart";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, idCart);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                   result = resultSet.getDouble(1);
                }

                return result;
            } catch (SQLException e) {
                e.printStackTrace();
                return result;
            } finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                } catch (SQLException e) {
                    return 0.0;
                }
            }
        }
        return 0.0;
    }
    public ArrayList<CartModel> getAllCartByIdUser(int idUser) {
        ArrayList<CartModel> result = new ArrayList<>();
        String sql = "SELECT id, idUser, timeShip, feeShip, totalPrice, infoShip, create_time\n" +
                "FROM carts where idUser = ? ";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, idUser);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CartModel cartModel = new CartModel();
                    cartModel.setId(resultSet.getInt(1));
                    cartModel.setIdUser(resultSet.getInt(2));
                    cartModel.setTimeShip(resultSet.getString(3));
                    cartModel.setShip(resultSet.getInt(4));
                    cartModel.setTotalPrice(resultSet.getDouble(5));
                    cartModel.setInShip(resultSet.getInt(6));
                    cartModel.setCreateTime(resultSet.getTimestamp(7));
                    result.add(cartModel);

                }

                return result;
            } catch (SQLException e) {
                e.printStackTrace();
                return result;
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
    public void updateCart(int id,int infoShip) {
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                String sql = " update carts set infoShip = ? where id = ?";
                statement = connection.prepareStatement(sql);

                statement.setInt(1, infoShip);
                statement.setInt(2, id);

                statement.executeUpdate();
                System.out.println("CartModel update successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
