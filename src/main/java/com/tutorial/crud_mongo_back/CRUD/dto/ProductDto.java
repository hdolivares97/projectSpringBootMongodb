package com.tutorial.crud_mongo_back.CRUD.dto;

public class ProductDto {

    private String name;
    private int price;

    public ProductDto() {
    }

    public ProductDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
