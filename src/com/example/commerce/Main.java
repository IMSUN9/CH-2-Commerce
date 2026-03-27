package com.example.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        Product galaxyPhone = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10);
        products.add(galaxyPhone);

        Product iPhone = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 8);
        products.add(iPhone);

        Product macBook = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 5);
        products.add(macBook);

        Product airPods = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 15);
        products.add(airPods);

        CommerceSystem commerceSystem = new CommerceSystem(products);
        commerceSystem.start();


    }
}
