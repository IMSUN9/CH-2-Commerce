package com.example.commerce;

import java.util.List;

public class Category {
// 속성: 카테고리 이름, 상품 리스트
//생성자: 카테고리와 그 안의 상품 목록 세팅
//기능: 카테고리 이름/상품 목록 조회


    // 속성
    private String categoryName;
    private List<Product> products;

    // 생성자
    public Category(String categoryName, List<Product> products) {
        this.categoryName = categoryName;
        this.products = products;
    }

    // 기능
    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }
}
