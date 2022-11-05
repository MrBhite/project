package CSUSoftWare21.web.projectJPetStore.persistence.impl;

import CSUSoftWare21.web.projectJPetStore.domain.Productt;
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
    //根据category获得List
    public List<Productt> getProductListByCategory(String categoryId) {
        List<Productt> result = new ArrayList<>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_LIST_BY_CATEGORY);
            preparedStatement.setString(1,categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            /*Productt test=  new Productt();
            System.out.println(test.getName());*/
            while(resultSet.next()){
                Productt productt = new Productt();
                productt.setProductId(resultSet.getString(1));
                productt.setName(resultSet.getString(2));
                productt.setDescription(resultSet.getString(3));
                productt.setCategoryId(resultSet.getString(4));
                result.add(productt);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStaement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    //根据productId获得Product
    public Productt getProduct(String productId) {
        Productt result = new Productt();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT);
            preparedStatement.setString(1,productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                result.setProductId(resultSet.getString("PRODUCTID"));
                result.setName(resultSet.getString("NAME"));
                result.setDescription(resultSet.getString("description"));
                result.setCategoryId(resultSet.getString("categoryId"));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStaement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    //根据keywords获得List
    public List<Productt> searchProductList(String keywords) {
        List<Productt> result = new ArrayList<>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_LIST);
            preparedStatement.setString(1,keywords);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Productt productt = new Productt();
                productt.setProductId(resultSet.getString("PRODUCTID"));
                productt.setName(resultSet.getString("NAME"));
                productt.setDescription(resultSet.getString("description"));
                productt.setCategoryId(resultSet.getString("categoryId"));
                result.add(productt);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStaement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
