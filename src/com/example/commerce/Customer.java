package com.example.commerce;

public class Customer {

// 속성: 고객명, 이메일, 등급
//생성자: 고객 정보 초기 세팅
//기능: 고객 정보 조회/수정

    // 속성
    private String customerName;
    private String email;
    private String grade;

    // 생성자
    public Customer(String customerName, String email, String grade) {
        this.customerName = customerName;
        this.email = email;
        this.grade = grade;
    }

    // 기능
    public String getCustomerName() {
        return customerName;
    }
    
    public String getEmail() {
        return email;
    }

    public String getGrade() {
        return grade;
    }
}
