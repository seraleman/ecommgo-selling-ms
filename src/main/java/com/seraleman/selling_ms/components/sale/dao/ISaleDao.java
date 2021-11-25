package com.seraleman.selling_ms.components.sale.dao;

import com.seraleman.selling_ms.components.sale.Sale;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISaleDao extends MongoRepository<Sale, String> {
    
}
