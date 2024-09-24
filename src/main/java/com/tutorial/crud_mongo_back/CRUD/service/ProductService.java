package com.tutorial.crud_mongo_back.CRUD.service;

import com.tutorial.crud_mongo_back.CRUD.dto.ProductDto;
import com.tutorial.crud_mongo_back.CRUD.entity.Product;
import com.tutorial.crud_mongo_back.CRUD.repository.ProductRepository;
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

    public Product getOne(int id){
        return productRepository.findById(id).get();
    }

    public Product save(ProductDto dto){
        int id = autoincrement();
        Product product = new Product(id, dto.getName(), dto.getPrice());
        return productRepository.save(product);
    }

    public Product update(ProductDto dto, int id){
        Product product = productRepository.findById(id).get();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        return productRepository.save(product);
    }

    public Product delete(int id){
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        return product;
    }

    private int autoincrement(){
        List<Product> products = productRepository.findAll();

        return products.isEmpty() ? 1 :
                products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;
    }

}
