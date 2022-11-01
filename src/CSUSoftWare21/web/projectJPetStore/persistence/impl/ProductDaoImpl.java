package CSUSoftWare21.web.projectJPetStore.persistence.impl;

import CSUSoftWare21.web.projectJPetStore.domain.Category;
import CSUSoftWare21.web.projectJPetStore.domain.Product;
import CSUSoftWare21.web.projectJPetStore.persistence.DBUtil;
import CSUSoftWare21.web.projectJPetStore.persistence.Dao.ProductDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private static final String GET_PRODUCT_LIST_BY_CATEGORY =
            "SELECT PRODUCTID,NAME,DESCN as description,CATEGORY as categoryId FROM PRODUCT WHERE CATEGORY = ?";
    private static final String GET_PRODUCT =
            "SELECT PRODUCTID,NAME,DESCN as description,CATEGORY as categoryId FROM PRODUCT WHERE PRODUCTID = ?";
    private static final String SEARCH_PRODUCT_LIST =
            "select PRODUCTID,NAME,DESCN as description,CATEGORY as categoryId from PRODUCT WHERE lower(name) like ?";


    @Override
    //根据categoryId获得List
    public List<Product> getProductListByCategory(String categoryId) {
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_LIST_BY_CATEGORY);
            preparedStatement.setString(1,categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product = new Product();
                product.setCategoryId(resultSet.getString("PRODUCTID"));
                product.setName(resultSet.getString("NAME"));
                product.setDescription(resultSet.getString("description"));
                product.setCategoryId(resultSet.getString("categoryId"));
                productList.add(product);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStaement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    //根据productId获得Product
    public Product getProduct(String productId) {
        Product product = new Product();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT);
            preparedStatement.setString(1,productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                product.setCategoryId(resultSet.getString("PRODUCTID"));
                product.setName(resultSet.getString("NAME"));
                product.setDescription(resultSet.getString("description"));
                product.setCategoryId(resultSet.getString("categoryId"));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStaement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    //根据keywords获得List
    public List<Product> searchProductList(String keywords) {
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_LIST);
            preparedStatement.setString(1,keywords);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product = new Product();
                product.setCategoryId(resultSet.getString("PRODUCTID"));
                product.setName(resultSet.getString("NAME"));
                product.setDescription(resultSet.getString("description"));
                product.setCategoryId(resultSet.getString("categoryId"));
                productList.add(product);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStaement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }
}
