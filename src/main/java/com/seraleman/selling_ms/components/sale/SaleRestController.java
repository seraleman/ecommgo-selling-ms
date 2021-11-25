package com.seraleman.selling_ms.components.sale;

import com.seraleman.selling_ms.components.sale.dao.services.ISaleService;

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
@RequestMapping("ms/api/sales")
public class SaleRestController {

    @Autowired
    private ISaleService saleService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        return saleService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable String id) {
        return saleService.show(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Sale sale) {
        return saleService.create(sale);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Sale sale) {
        return saleService.update(id, sale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return saleService.delete(id);
    }
}
