package CSUSoftWare21.web.projectJPetStore.service;

import CSUSoftWare21.web.projectJPetStore.domain.Category;
import CSUSoftWare21.web.projectJPetStore.domain.Itemm;
import CSUSoftWare21.web.projectJPetStore.domain.Productt;
import CSUSoftWare21.web.projectJPetStore.persistence.Dao.CategoryDao;
import CSUSoftWare21.web.projectJPetStore.persistence.Dao.ItemDao;
import CSUSoftWare21.web.projectJPetStore.persistence.Dao.ProductDao;
import CSUSoftWare21.web.projectJPetStore.persistence.impl.CategoryDaoImpl;
import CSUSoftWare21.web.projectJPetStore.persistence.impl.ItemDaoImpl;
import CSUSoftWare21.web.projectJPetStore.persistence.impl.ProductDaoImpl;

import java.util.List;

public class CatalogService {
    /*实现功能*/
    private CategoryDao categoryDao;
    private ItemDao itemDao;
    private ProductDao productDao;

    public CatalogService(){
        this.categoryDao = new CategoryDaoImpl();
        this.itemDao = new ItemDaoImpl();
        this.productDao = new ProductDaoImpl();
    }

    public List<Category> getCategoryList() {
        return categoryDao.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryDao.getCategory(categoryId);
    }

    public Productt getProduct(String productId) {
        return productDao.getProduct(productId);
    }

    public List<Productt> getProductListByCategory(String categoryId) {
        return productDao.getProductListByCategory(categoryId);
    }

    // TODO enable using more than one keyword
    public List<Productt> searchProductList(String keyword) {
        return productDao.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Itemm> getItemListByProduct(String productId) {
        return itemDao.getItemListByProduct(productId);
    }

    public Itemm getItem(String itemId) {
        return itemDao.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemDao.getInventoryQuantity(itemId) > 0;
    }

}
