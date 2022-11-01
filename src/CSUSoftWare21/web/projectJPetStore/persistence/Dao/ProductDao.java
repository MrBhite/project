package CSUSoftWare21.web.projectJPetStore.persistence.Dao;

import CSUSoftWare21.web.projectJPetStore.domain.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProductListByCategory(String categoryId);

    Product getProduct(String productId);

    List<Product> searchProductList(String keywords);

}
