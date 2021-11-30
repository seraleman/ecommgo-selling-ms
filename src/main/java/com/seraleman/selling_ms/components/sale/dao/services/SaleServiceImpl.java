package com.seraleman.selling_ms.components.sale.dao.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.seraleman.selling_ms.components.sale.Sale;
import com.seraleman.selling_ms.components.sale.dao.ISaleDao;
import com.seraleman.selling_ms.services.response.IResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements ISaleService {

    @Autowired
    private ISaleDao saleDao;

    @Autowired
    private IResponseService response;

    @Override
    public ResponseEntity<?> list() {

        List<Sale> sales = new ArrayList<>();

        try {
            sales = saleDao.findAll();
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (sales.size() == 0) {
            return response.empty();
        }
        return response.list(sales);
    }

    @Override
    public ResponseEntity<?> show(String id) {

        Sale sale = null;

        try {
            sale = saleDao.findById(id.toString()).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (sale == null) {
            return response.notFound(id.toString());
        }
        return response.found(sale);
    }

    @Override
    public ResponseEntity<?> create(Sale sale) {

        Sale saleNew = null;
        sale.setDate(LocalDateTime.now());
        try {
            saleNew = saleDao.save(sale);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.created(saleNew);
    }

    @Override
    public ResponseEntity<?> update(String id, Sale sale) {

        Sale saleCurrent = null;

        try {
            saleCurrent = saleDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (saleCurrent == null) {
            return response.notFound(id);
        }

        try {
            saleCurrent.setDate(sale.getDate());
            saleCurrent.setUser(sale.getUser());
            saleCurrent.setItems(sale.getItems());

            saleDao.save(saleCurrent);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.updated(saleCurrent);
    }

    @Override
    public ResponseEntity<?> delete(String id) {

        Sale sale = null;

        try {
            sale = saleDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (sale == null) {
            return response.notFound(id);
        }

        try {
            saleDao.deleteById(id);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.deleted();
    }

}
