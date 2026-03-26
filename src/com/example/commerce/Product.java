package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Product {
// 개별 상품 정보를 가지는 클래스
// 상품명, 가격, 설명, 재고수량
// 예시: Galaxy S24, 12000000, 최신 스마트폰, 50
// new Product("Galaxy S24, 12000000, 최신 스마트폰, 50")

    // 속성
    private String productName;
    private long productPrice = 0;
    private String productDescription;
    private int productStock = 0;

    // 생성자
    public Product(String productName, long productPrice, String productDescription, int productStock) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productStock = productStock;
    }


    // 기능


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(long productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }







}
