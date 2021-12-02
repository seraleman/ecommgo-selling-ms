package com.seraleman.selling_ms.sale;

public class SaleItem {

    private String productId;

    private Integer quantity;

    private Integer price;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTotalItemPrice() {
        return this.price * this.quantity;
    }

}
