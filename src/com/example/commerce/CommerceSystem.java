package com.example.commerce;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

// 속성: 카테고리 목록, 고객, Scanner
//생성자: 시스템 실행에 필요한 재료 받기
//기능: start()로 프로그램 흐름 제어


    // 속성
    private List<Category> categories;
    private Customer customer;
    private Scanner scanner;


    // 생성자
    public CommerceSystem(List<Category> categories, Customer customer, Scanner scanner) {
        this.categories = categories;
        this.customer = customer;
        this.scanner = scanner;
    }

    // 기능
    public void start() {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");

        // 카테고리 목록 출력
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);

            System.out.println((i + 1) + ". " + category.getCategoryName());
        }

        System.out.println("0. 종료 | 프로그램 종료");
        System.out.print("번호를 입력하세요: ");
        int categoryChoice = scanner.nextInt();

        // 0 입력시 종료
        if (categoryChoice == 0) {
            System.out.println("커머스 플랫폼을 종료합니다.");
        } else if (categoryChoice >= 1 && categoryChoice <= categories.size()) {
            Category selectedCategory = categories.get(categoryChoice - 1);

            System.out.println("[ " + selectedCategory.getCategoryName() + " 카테고리 ]");

            List<Product> products = selectedCategory.getProducts();

            // 선택한 카테고리 안의 상품 목록 출력
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);

                System.out.println((i + 1) + ". "
                        + product.getProductName() + " | "
                        + String.format("%,d원", product.getProductPrice()) + " | "
                        + product.getProductDescription());
            }

            System.out.println("0. 뒤로 가기");
            System.out.print("번호를 입력하세요: ");
            int productChoice = scanner.nextInt();

            if (productChoice == 0) {
                System.out.println("메인 화면으로 돌아갑니다.");

            } else if (productChoice >= 1 && productChoice <= products.size()) {
                Product selectedProduct = products.get(productChoice - 1);

                System.out.println("선택한 상품: "
                        + selectedProduct.getProductName() + " | "
                        + String.format("%,d원", selectedProduct.getProductPrice()) + " | "
                        + selectedProduct.getProductDescription() + " | "
                        + "재고: " + selectedProduct.getProductStock() + "개");

            } else {
                System.out.println("올바른 번호를 입력해주세요.");
            }

        } else {
            System.out.println("올바른 번호를 입력해주세요.");
        }
    }
}
