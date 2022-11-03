package CSUSoftWare21.web.projectJPetStore.domain;

import java.math.BigDecimal;

public class CartItem {
    private static final long serialVersionUID = 6620528781626504362L;

    private Itemm item;
    private int quantity;
    private boolean inStock;
    private BigDecimal total;

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Itemm getItem() {
        return item;
    }

    public void setItem(Itemm itemm) {
        this.item = itemm;
        calculateTotal();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateTotal();
    }

    public void incrementQuantity() {
        quantity++;
        calculateTotal();
    }

    private void calculateTotal() {
        if (item != null && item.getListPrice() != null) {
            total = item.getListPrice().multiply(new BigDecimal(quantity));
        } else {
            total = null;
        }
    }

}