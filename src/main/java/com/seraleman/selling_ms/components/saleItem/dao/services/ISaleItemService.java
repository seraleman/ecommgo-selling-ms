package com.seraleman.selling_ms.components.saleItem.dao.services;

import com.seraleman.selling_ms.components.saleItem.SaleItem;

import org.springframework.http.ResponseEntity;

public interface ISaleItemService {
    
    public ResponseEntity<?> list();

    public ResponseEntity<?> show(String id);

    public ResponseEntity<?> create(SaleItem saleItem);

    public ResponseEntity<?> update(String id, SaleItem saleItem);

    public ResponseEntity<?> delete(String id);
}
