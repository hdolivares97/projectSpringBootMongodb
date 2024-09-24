package com.tutorial.crud_mongo_back.CRUD.repository;

import com.tutorial.crud_mongo_back.CRUD.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
}
