package CSUSoftWare21.web.projectJPetStore.persistence.Dao;

import CSUSoftWare21.web.projectJPetStore.domain.Productt;

import java.util.List;

public interface ProductDao {

    List<Productt> getProductListByCategory(String categoryId);

    Productt getProduct(String productId);

    List<Productt> searchProductList(String keywords);

}
