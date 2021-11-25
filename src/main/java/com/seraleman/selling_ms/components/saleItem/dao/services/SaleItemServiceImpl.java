package com.seraleman.selling_ms.components.saleItem.dao.services;

import java.util.ArrayList;
import java.util.List;

import com.seraleman.selling_ms.components.saleItem.SaleItem;
import com.seraleman.selling_ms.components.saleItem.dao.ISaleItemDao;
import com.seraleman.selling_ms.services.response.IResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaleItemServiceImpl implements ISaleItemService {

    @Autowired
    private ISaleItemDao saleItemDao;

    @Autowired
    private IResponseService response;

    @Override
    public ResponseEntity<?> list() {

        List<SaleItem> saleItems = new ArrayList<>();

        try {
            saleItems = saleItemDao.findAll();
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (saleItems.size() == 0) {
            return response.empty();
        }
        return response.list(saleItems);
    }

    @Override
    public ResponseEntity<?> show(String id) {

        SaleItem saleItem = null;

        try {
            saleItem = saleItemDao.findById(id.toString()).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (saleItem == null) {
            return response.notFound(id.toString());
        }
        return response.found(saleItem);
    }

    @Override
    public ResponseEntity<?> create(SaleItem saleItem) {

        SaleItem saleItemNew = null;

        try {
            saleItemNew = saleItemDao.save(saleItem);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.created(saleItemNew);
    }

    @Override
    public ResponseEntity<?> update(String id, SaleItem saleItem) {

        SaleItem saleItemCurrent = null;

        try {
            saleItemCurrent = saleItemDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (saleItemCurrent == null) {
            return response.notFound(id);
        }

        try {
            saleItemCurrent.setPrice(saleItem.getPrice());
            saleItemCurrent.setProductId(saleItem.getProductId());
            saleItemCurrent.setQuantity(saleItem.getQuantity());
            saleItemDao.save(saleItemCurrent);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.updated(saleItemCurrent);
    }

    @Override
    public ResponseEntity<?> delete(String id) {

        SaleItem saleItem = null;

        try {
            saleItem = saleItemDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (saleItem == null) {
            return response.notFound(id);
        }

        try {
            saleItemDao.deleteById(id);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.deleted();
    }
}
