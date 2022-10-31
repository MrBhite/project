package CSUSoftWare21.web.projectJPetStore.persistence;

import CSUSoftWare21.web.projectJPetStore.domain.Item;

import java.util.List;
import java.util.Map;

public interface ItemMapper {
    List<Item> selectAllItem();

    void updateInventoryQuantity(Map<String, Object> param);

    int getInventoryQuantity(String itemId);

    List<Item> getItemListByProduct(String productId);

    Item getItem(String itemId);
}