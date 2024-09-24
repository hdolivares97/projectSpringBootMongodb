package com.tutorial.crud_mongo_back.CRUD.controller;

import com.tutorial.crud_mongo_back.CRUD.dto.ProductDto;
import com.tutorial.crud_mongo_back.CRUD.entity.Product;
import com.tutorial.crud_mongo_back.CRUD.service.ProductService;
import com.tutorial.crud_mongo_back.global.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductDto dto){
        return ResponseEntity.ok(productService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody ProductDto dto, @PathVariable int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.update(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.delete(id));
    }
}
