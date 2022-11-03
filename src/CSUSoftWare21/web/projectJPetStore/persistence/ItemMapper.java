package CSUSoftWare21.web.projectJPetStore.persistence;

import CSUSoftWare21.web.projectJPetStore.domain.Itemm;

import java.util.List;
import java.util.Map;

public interface ItemMapper {
    List<Itemm> selectAllItem();

    void updateInventoryQuantity(Map<String, Object> param);

    int getInventoryQuantity(String itemId);

    List<Itemm> getItemListByProduct(String productId);

    Itemm getItem(String itemId);
}
