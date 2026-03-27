package com.example.commerce;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {


    // 속성
    private List<Product> products;
    private Scanner scanner = new Scanner(System.in);

    // 생성자
    public CommerceSystem(List<Product> products) {
        this.products = products;
    }

    // 기능
    public void start() {
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
