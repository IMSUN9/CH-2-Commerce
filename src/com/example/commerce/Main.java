package com.example.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<Product> electronicsProducts = new ArrayList<>();

        Product galaxyPhone = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10);
        electronicsProducts.add(galaxyPhone);

        Product iPhone = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 8);
        electronicsProducts.add(iPhone);

        Product macBook = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 5);
        electronicsProducts.add(macBook);

        Product airPods = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 15);
        electronicsProducts.add(airPods);


        List<Product> clothesProducts = new ArrayList<>();

        Product sweatShirt = new Product("맨투맨", 49000, "편하게 입을 수 있는 상의", 20);
        clothesProducts.add(sweatShirt);

        Product jeans = new Product("청바지", 59000, "데일리로 입기 좋은 바지", 18);
        clothesProducts.add(jeans);


        List<Product> foodProducts = new ArrayList<>();

        Product apple = new Product("사과", 12000, "신선한 사과 한 박스", 30);
        foodProducts.add(apple);

        Product milk = new Product("우유", 2500, "1L 우유", 40);
        foodProducts.add(milk);

        // 카테고리 객체 생성
        Category electronics = new Category("전자제품", electronicsProducts);
        Category clothes = new Category("의류", clothesProducts);
        Category food = new Category("식품", foodProducts);

        // 카테고리 리스트 생성
        List<Category> categories = new ArrayList<>();
        categories.add(electronics);
        categories.add(clothes);
        categories.add(food);

        // 고객 객체 생성
        Customer customer = new Customer("임선구", "sungu4790@naver.com", "GOLD");

        // 시스템  실행
        CommerceSystem commerceSystem = new CommerceSystem(categories, customer, scanner);
        commerceSystem.start();

        scanner.close();

    }
}
