package com.example.commerce;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

// 속성: 카테고리 목록, 고객, Scanner
//생성자: 시스템 실행에 필요한 재료 받기
//기능: start()로 프로그램 흐름 제어


    // -------------------------
    // 속성
    // -------------------------
    private final List<Category> categories;
    private final Customer customer;
    private final Scanner scanner;
    private boolean running;


    // -------------------------
    // 생성자
    // -------------------------
    public CommerceSystem(List<Category> categories, Customer customer, Scanner scanner) {
        this.categories = categories;
        this.customer = customer;
        this.scanner = scanner;
        this.running = true;
    }

    // -------------------------
    // 기능
    // -------------------------

    // 프로그램 시작
    public void start() {
        while (running) {
            showMainMenu();
        }
    }

    // 메인 화면 출력
    private void showMainMenu() {
        System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");
        System.out.println("고객: " + customer.getCustomerName() + " | 등급: " + customer.getGrade());

        // 카테고리 목록 출력
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            System.out.println((i + 1) + ". " + category.getCategoryName());
        }

        // 장바구니 메뉴 번호
        int cartMenuNumber = categories.size() + 1;
        System.out.println(cartMenuNumber + ". 장바구니 보기");

        System.out.println("0. 종료 | 프로그램 종료");
        System.out.print("번호를 입력하세요: ");
        int categoryChoice = scanner.nextInt();

        // 0 입력 시 종료
        if (categoryChoice == 0) {
            stop();
            return;
        }

        // 장바구니 보기 선택
        if (categoryChoice == cartMenuNumber) {
            showCart();
            return;
        }

        // 잘못된 번호 입력
        if (!isValidCategoryChoice(categoryChoice)) {
            printWrongInputMessage();
            return;
        }

        // 정상적인 카테고리 선택
        Category selectedCategory = categories.get(categoryChoice - 1);
        showProductMenu(selectedCategory);
    }

    // 선택한 카테고리의 상품 목록 출력
    private void showProductMenu(Category selectedCategory) {
        System.out.println("\n[ " + selectedCategory.getCategoryName() + " 카테고리 ]");

        List<Product> products = selectedCategory.getProducts();

        // 상품 목록 출력
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

        // 뒤로 가기
        if (productChoice == 0) {
            System.out.println("메인 화면으로 돌아갑니다.");
            return;
        }

        // 잘못된 번호 입력
        if (!isValidProductChoice(productChoice, products)) {
            printWrongInputMessage();
            return;
        }

        // 정상적인 상품 선택
        Product selectedProduct = products.get(productChoice - 1);
        showProductDetailMenu(selectedProduct);
    }

    // 상품 상세 메뉴
    private void showProductDetailMenu(Product selectedProduct) {
        System.out.println("\n[ 상품 상세 정보]");
        System.out.println("상품명: " + selectedProduct.getProductName());
        System.out.println("가격: " + String.format("%,d원", selectedProduct.getProductPrice()));
        System.out.println("설명: " + selectedProduct.getProductDescription());
        System.out.println("재고: " + selectedProduct.getProductStock() + "개");

        System.out.println("1. 장바구니에 담기");
        System.out.println("0. 뒤로 가기");
        System.out.print("번호를 입력하세요: ");
        int detailChoice = scanner.nextInt();

        // 뒤로 가기
        if (detailChoice == 0) {
            System.out.println("상품 목록으로 돌아갑니다.");
            return;
        }

        // 장바구니 담기
        if (detailChoice == 1) {
            addProductToCart(selectedProduct);
            return;
        }

        // 그 외 잘못된 입력
        printWrongInputMessage();
    }

    // 장바구니에 상품 1개 담기
    private void addProductToCart(Product selectedProduct) {
        customer.getCart().addProduct(selectedProduct, 1);
        System.out.println(selectedProduct.getProductName() + " 상품이 장바구니에 담겼습니다.");
    }

    // 장바구니 보기
    private void showCart() {
        System.out.println("\n[ " + customer.getCustomerName() + "님의 장바구니 ]");
        customer.getCart().showCartItems();
    }

    // 카테고리 번호가 올바른지 검사
    private boolean isValidCategoryChoice(int categoryChoice) {
        return categoryChoice >= 1 && categoryChoice <= categories.size();
    }

    // 상품 번호가 올바른지 검사
    private boolean isValidProductChoice(int productChoice, List<Product> products) {
        return productChoice >= 1 && productChoice <= products.size();
    }

    // 종료 처리
    private void stop() {
        System.out.println("커머스 플랫폼을 종료합니다.");
        this.running = false;
    }

    // 공통 잘못된 입력 메시지
    private void printWrongInputMessage() {
        System.out.println("올바른 번호를 입력해주세요.");
    }

}