package com.seraleman.selling_ms.services.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseServiceimpl implements IResponseService {

    private Map<String, Object> response;

    @Override
    public ResponseEntity<Map<String, Object>> list(List<?> objs) {
        response = new HashMap<>();
        response.put("message", "Lista de objetos disponible");
        response.put("data", objs);
        return new ResponseEntity<Map<String, Object>>(this.response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> found(Object obj) {
        response = new HashMap<>();
        response.put("message", "Objeto disponible");
        response.put("data", obj);
        return new ResponseEntity<Map<String, Object>>(this.response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> empty() {
        response = new HashMap<>();
        response.put("message", "No hay objetos en la lista");
        return new ResponseEntity<Map<String, Object>>(this.response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> notFound(Object id) {
        response = new HashMap<>();
        response.put("message", "Objeto con id '".concat(id.toString()).concat("' no existe en la base de datos"));
        return new ResponseEntity<Map<String, Object>>(this.response, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Map<String, Object>> created(Object obj) {
        response = new HashMap<>();
        response.put("message", "Objeto creado");
        response.put("data", obj);
        return new ResponseEntity<Map<String, Object>>(this.response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Map<String, Object>> notCreated() {
        response = new HashMap<>();
        response.put("message", "Objeto no creado, validar");
        return new ResponseEntity<Map<String, Object>>(this.response, HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Map<String, Object>> updated(Object obj) {
        response = new HashMap<>();
        response.put("message", "Objeto actualizado");
        response.put("data", obj);
        return new ResponseEntity<Map<String, Object>>(this.response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Map<String, Object>> notUpdated() {
        response = new HashMap<>();
        response.put("message", "Objeto no actualizado, validar");
        return new ResponseEntity<Map<String, Object>>(this.response, HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Map<String, Object>> deleted() {
        response = new HashMap<>();
        response.put("message", "Objeto eliminado");
        return new ResponseEntity<Map<String, Object>>(this.response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> errorDataAccess(DataAccessException e) {
        response = new HashMap<>();
        response.put("message", "Error en la base de datos");
        response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
        return new ResponseEntity<Map<String, Object>>(this.response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
