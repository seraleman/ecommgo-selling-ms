package com.seraleman.selling_ms.components.sale;

import java.util.Date;
import java.util.List;

import com.seraleman.selling_ms.components.saleItem.SaleItem;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "sales")
public class Sale {

    @Id
    private String id;

    private Date date;

    @Field(value = "user_id")
    private String userId;

    @DBRef
    private List<SaleItem> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public Integer getTotalSalePrice() {

        Integer totalSalePrice = 0;
        for (SaleItem saleItem : items) {
            totalSalePrice += saleItem.getTotalItemPrice();
        }
        return totalSalePrice;
    }

}
