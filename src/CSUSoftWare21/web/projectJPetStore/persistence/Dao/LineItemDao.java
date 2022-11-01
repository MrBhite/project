package CSUSoftWare21.web.projectJPetStore.persistence.Dao;

import CSUSoftWare21.web.projectJPetStore.domain.LineItem;

import java.util.List;

public interface LineItemDao {

    List<LineItem> getLineItemsByOrderId(int orderId);

    void insertLineItem(LineItem lineItem);

}
