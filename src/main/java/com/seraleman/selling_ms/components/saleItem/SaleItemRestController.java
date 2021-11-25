package com.seraleman.selling_ms.components.saleItem;

import com.seraleman.selling_ms.components.saleItem.dao.services.ISaleItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ms/saleItems")
public class SaleItemRestController {

    @Autowired
    private ISaleItemService saleItemService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        return saleItemService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable String id) {
        return saleItemService.show(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody SaleItem saleItem) {
        return saleItemService.create(saleItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody SaleItem saleItem) {
        return saleItemService.update(id, saleItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return saleItemService.delete(id);
    }
}
