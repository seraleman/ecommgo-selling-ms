package com.seraleman.selling_ms.sale.dao.services;

import com.seraleman.selling_ms.sale.Sale;

import org.springframework.http.ResponseEntity;

public interface ISaleService {
    
    public ResponseEntity<?> list();

    public ResponseEntity<?> show(String id);

    public ResponseEntity<?> create(Sale sale);

    public ResponseEntity<?> update(String id, Sale sale);

    public ResponseEntity<?> delete(String id);
}
