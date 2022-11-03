package CSUSoftWare21.web.projectJPetStore.persistence.Dao;

import CSUSoftWare21.web.projectJPetStore.domain.Itemm;

import java.util.List;
import java.util.Map;

public interface ItemDao {

    void updateInventoryQuantity(Map<String, Object> param);

    int getInventoryQuantity(String itemId);

    List<Itemm> getItemListByProduct(String productId);

    Itemm getItem(String itemId);

}
