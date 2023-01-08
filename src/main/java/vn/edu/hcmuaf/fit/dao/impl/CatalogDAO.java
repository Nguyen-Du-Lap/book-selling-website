package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.ICatalogDAO;
import vn.edu.hcmuaf.fit.db.JDBCConnector;
import vn.edu.hcmuaf.fit.model.CatalogModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAO implements ICatalogDAO {
    @Override
    public List<CatalogModel> findAll() {
        List<CatalogModel> results = new ArrayList<>();
        String sql = "SELECT * FROM catalog";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CatalogModel catalogModel = new CatalogModel();
                    catalogModel.setIdCatalog(resultSet.getInt("id_catalog"));
                    catalogModel.setName(resultSet.getString("name"));
                    catalogModel.setParentId(resultSet.getInt("parent_id"));
                    results.add(catalogModel);
                }

                return results;
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
    public List<CatalogModel> findAllTest(int limit, int offset) {
        List<CatalogModel> results = new ArrayList<>();
        String sql = "SELECT * FROM catalog LIMIT ?,?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, limit);
                statement.setInt(2, offset);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CatalogModel catalogModel = new CatalogModel();
                    catalogModel.setIdCatalog(resultSet.getInt("id_catalog"));
                    catalogModel.setName(resultSet.getString("name"));
                    catalogModel.setParentId(resultSet.getInt("parent_id"));
                    results.add(catalogModel);
                }
                return results;
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
    public List<CatalogModel> findAllSort(int limit, int offset, String name, String type) {
        List<CatalogModel> results = new ArrayList<>();
        String sql = "SELECT * FROM catalog ORDER BY ? ? LIMIT ?, ?";
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, type);
                statement.setInt(3, limit);
                statement.setInt(4, offset);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CatalogModel catalogModel = new CatalogModel();
                    catalogModel.setIdCatalog(resultSet.getInt("id_catalog"));
                    catalogModel.setName(resultSet.getString("name"));
                    catalogModel.setParentId(resultSet.getInt("parent_id"));
                    results.add(catalogModel);
                }

                return results;
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
    public Long save(CatalogModel catalogModel) {
        Long id = 1L;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO catalog VALUES(? ,? ,?)";
            connection = JDBCConnector.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            statement.setInt(1, catalogModel.getIdCatalog());
            statement.setString(2, catalogModel.getName());
            statement.setInt(3, catalogModel.getParentId());
            statement.executeUpdate();

            connection.commit();
            return id;
        }catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                if(connection != null) connection.close();
                if(statement != null) statement.close();
            } catch (SQLException e) {
                return null;
            }
        }
        return null;
    }
}
