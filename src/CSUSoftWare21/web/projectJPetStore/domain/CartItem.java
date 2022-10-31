package CSUSoftWare21.web.projectJPetStore.domain;

import java.math.BigDecimal;

public class CartItem {
    private Item item;
    private int quantity;
    private boolean inStock;
    private BigDecimal total;

    public CartItem(Item item, int quantity, boolean inStock, BigDecimal total) {
        this.item = item;
        this.quantity = quantity;
        this.inStock = inStock;
        this.total = total;
    }

    public CartItem() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "item=" + item +
                ", quantity=" + quantity +
                ", inStock=" + inStock +
                ", total=" + total +
                '}';
    }
}
