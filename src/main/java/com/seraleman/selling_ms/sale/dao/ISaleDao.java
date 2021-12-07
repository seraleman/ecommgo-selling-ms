package com.seraleman.selling_ms.sale.dao;

import com.seraleman.selling_ms.sale.Sale;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISaleDao extends MongoRepository<Sale, String> {
    
}
