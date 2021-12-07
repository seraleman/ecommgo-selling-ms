package com.seraleman.selling_ms.sale;

public class SaleItem {

    private String product;

    private Integer quantity;

    private Integer price;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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
