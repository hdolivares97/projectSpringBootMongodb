package com.tutorial.crud_mongo_back.CRUD.service;

import com.tutorial.crud_mongo_back.CRUD.dto.ProductDto;
import com.tutorial.crud_mongo_back.CRUD.entity.Product;
import com.tutorial.crud_mongo_back.CRUD.repository.ProductRepository;
import com.tutorial.crud_mongo_back.global.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getOne(int id) throws ResourceNotFoundException {
        return productRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    public Product save(ProductDto dto){
        int id = autoincrement();
        Product product = new Product(id, dto.getName(), dto.getPrice());
        return productRepository.save(product);
    }

    public Product update(ProductDto dto, int id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        return productRepository.save(product);
    }

    public Product delete(int id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        productRepository.delete(product);
        return product;
    }

    private int autoincrement(){
        List<Product> products = productRepository.findAll();

        return products.isEmpty() ? 1 :
                products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;
    }

}
