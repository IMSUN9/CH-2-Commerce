package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Product {
//속성: 상품명, 가격, 설명, 재고
//생성자: 상품 1개 만들기 위한 초기값 세팅
//기능: 상품 정보 조회/수정

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

    public long getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getProductStock() {
        return productStock;
    }







}
