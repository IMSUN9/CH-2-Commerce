package com.example.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        Product galaxyPhone = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10);
        products.add(galaxyPhone);

        Product iPhone = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 8);
        products.add(iPhone);

        Product macBook = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 5);
        products.add(macBook);

        Product airPods = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 15);
        products.add(airPods);

        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");

        // 반복문을 통해 products를 탐색하면서 상품 꺼내오기
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);

            System.out.println((i + 1) + ". "
                    + product.getProductName() + "  | "
                    + String.format("%,d원", product.getProductPrice()) + " |  "
                    + product.getProductDescription());
        }

        System.out.println("0. 종료          | 프로그램 종료");
        System.out.print("번호를 입력하세요: ");
        int choice = scanner.nextInt();

        if (choice == 0) {
            System.out.println("커머스 플랫폼을 종료합니다.");
        } else if (choice >= 1 && choice <= products.size()) {
            Product selectedProduct = products.get(choice - 1);

            System.out.println(
                    "선택한 상품: "
                    + selectedProduct.getProductName() + "  | "
                    + String.format("%,d원", selectedProduct.getProductPrice()) + " |  "
                    + selectedProduct.getProductDescription() + " |  "
                    + "재고: " + selectedProduct.getProductStock() + "개"
            );
        } else {
            System.out.println("올바른 번호를 입력해주세요.");
        }

        scanner.close();


    }
}
