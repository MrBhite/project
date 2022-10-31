package CSUSoftWare21.web.projectJPetStore.persistence;

import CSUSoftWare21.web.projectJPetStore.domain.Category;

import java.util.List;

public interface CategoryMapper {
    Category selectAll() ;

    List<Category> getCategoryList();

    Category getCategory(String categoryId);
}
