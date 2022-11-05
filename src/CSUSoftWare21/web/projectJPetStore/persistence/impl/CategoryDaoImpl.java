package CSUSoftWare21.web.projectJPetStore.persistence.impl;

import CSUSoftWare21.web.projectJPetStore.domain.Category;
import CSUSoftWare21.web.projectJPetStore.persistence.DBUtil;
import CSUSoftWare21.web.projectJPetStore.persistence.Dao.CategoryDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
//as取别名，因为数据库里的列名和pojo里的变量名不一致
    private static final String GET_CATEGORY_LIST =
            "SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY";
    private static final String GET_CATEGORY =
            "SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY WHERE CATID = ?";

    @Override
    //获得列表
    public List<Category> getCategoryList() {
        List<Category> result = new ArrayList<>();
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_CATEGORY_LIST);
            while(resultSet.next()){
                Category category = new Category();
                category.setCategoryId(resultSet.getString("categoryId"));
                category.setName(resultSet.getString("NAME"));
                category.setCategoryId(resultSet.getString("description"));
                result.add(category);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStaement(statement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    //根据categoryId获得List
    public Category getCategory(String categoryId) {
        Category result = new Category();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY);
            preparedStatement.setString(1,categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                result.setCategoryId(resultSet.getString("categoryId"));//如果用列名要写as之后的
                result.setName(resultSet.getString("NAME"));
                result.setDescription(resultSet.getString("description"));
            }
            System.out.println(result);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStaement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
