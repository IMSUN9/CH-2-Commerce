package com.example.commerce;

public class Customer {

// 속성: 고객명, 이메일, 등급
//생성자: 고객 정보 초기 세팅
//기능: 고객 정보 조회/수정

    // -------------------------
    // 속성
    // -------------------------
    private String customerName;
    private String email;
    private String grade;
    private Cart cart;


    // -------------------------
    // 생성자
    // -------------------------
    public Customer(String customerName, String email, String grade) {
        this.customerName = customerName;
        this.email = email;
        this.grade = grade;
        this.cart = new Cart(); // 고객이 생성될 때 빈 장바구니도 같이 생성
    }


    // -------------------------
    // getter
    // -------------------------
    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getGrade() {
        return grade;
    }

    public Cart getCart() {
        return cart;
    }

    // -------------------------
    // 기능
    // -------------------------
}
