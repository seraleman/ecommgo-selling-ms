package com.seraleman.selling_ms.components.saleItem.dao;

import com.seraleman.selling_ms.components.saleItem.SaleItem;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISaleItemDao extends MongoRepository<SaleItem, String>{
    
}
