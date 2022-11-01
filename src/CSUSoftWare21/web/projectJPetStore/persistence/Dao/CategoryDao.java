package CSUSoftWare21.web.projectJPetStore.persistence.Dao;

import CSUSoftWare21.web.projectJPetStore.domain.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getCategoryList();

    Category getCategory(String categoryId);

}
