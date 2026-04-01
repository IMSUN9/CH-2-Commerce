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

        System.out.println("0. 종료 | 프로그램 종료");

        // 장바구니가 비어 있지 않을 때 주문 관리 메뉴 출력
        if(!customer.getCart().isEmpty()) {
            System.out.println("\n[ 주문 관리 ]");
            System.out.println("4. 장바구니 확인     | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. 주문 취소        |  진행중인 주문을 취소합니다.");
        }

        System.out.print("번호를 입력하세요: ");
        int categoryChoice = scanner.nextInt();

        // 0 입력 시 종료
        if (categoryChoice == 0) {
            stop();
            return;
        }

        // 장바구가 비어 있지 않을 때만 4, 5 처리
        if (!customer.getCart().isEmpty()) {
            if (categoryChoice == 4) {
                showOrderMenu();
                return;
            }

            if (categoryChoice == 5) {
                cancelOrder();
                return;
            }
        } else {
            // 장바구니가 비어 있을  4, 5 입력 시 예외 처리 느낌의 안내
            if (categoryChoice == 4 || categoryChoice == 5) {
                System.out.println("진행중인 주문이 없습니다.");
                return;
            }
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
                    + product.getProductDescription() + " | "
                    + "재고: " + product.getProductStock() + "개");
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

    // 상품 선택 후 장바구니 추가 확인 메뉴
    private void showProductDetailMenu(Product selectedProduct) {
        System.out.println("선택한 상품: "
                + selectedProduct.getProductName() + " | "
                + String.format("%,d원", selectedProduct.getProductPrice()) + " | "
                + selectedProduct.getProductDescription() + " | "
                + "재고: " + selectedProduct.getProductStock() + "개");

        System.out.println();
        System.out.println("\"" + selectedProduct.getProductName() + " | "
                + String.format("%,d원",selectedProduct.getProductPrice()) + " | "
                + selectedProduct.getProductDescription() + "\"");
        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        System.out.print("번호를 입력하세요: ");
        int detailChoice = scanner.nextInt();

        // 확인
        if (detailChoice == 1) {
            addProductToCart(selectedProduct);
            return;
        }

        // 취소
        if (detailChoice == 2) {
            System.out.println("장바구니 추가를 취소했습니다.");
            return;
        }

        // 그 외 잘못된 입력
        printWrongInputMessage();
    }

    // 장바구니에 상품 1개 담기
    private void addProductToCart(Product selectedProduct) {
        Cart cart = customer.getCart();

        // 이미 장바구니 같은 상품이 몇 개 들어있는지 확인
        int currentCartQuantity = cart.getQuantityByProduct(selectedProduct);

        // 이번에 1개 더 담았을 때 재고를 넘는지 검사
        if (!selectedProduct.hasEnoughStock(currentCartQuantity + 1)) {
            System.out.println("재고가 부족하여 장바구니에 담을 수 없습니다.");
            return;
        }

        cart.addProduct(selectedProduct, 1);
        System.out.println(selectedProduct.getProductName() + "가 장바구니에 추가되었습니다.");
    }

    // 장바구니 확인 / 주문 화면
    private void showOrderMenu() {
        Cart cart = customer.getCart();

        System.out.println("\n아래와 같이 주문 하시겠습니까?");
        System.out.println("\n[ 장바구니 내역 ]");

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            System.out.println(product.getProductName() + " | "
                    + String.format("%,d원", product.getProductPrice()) + " | "
                    + product.getProductDescription() + " | "
                    + "수량: " + item.getQuantity() + "개");
        }

        System.out.println("\n[ 총 주문 금액 ]");
        System.out.println(String.format("%,d원", cart.getTotalPrice()));

        System.out.println("\n1. 주문 확정    2. 메인으로 돌아가기");
        System.out.print("번호를 입력하세요: ");
        int orderChoice = scanner.nextInt();

        if (orderChoice == 1) {
            confirmOrder();
            return;
        }

        if (orderChoice == 2) {
            System.out.println("메인 화면으로 돌아갑니다.");
            return;
        }

        printWrongInputMessage();
    }

    // 주문 확정
    private void confirmOrder() {
        Cart cart = customer.getCart();

        // 주문 직전에 재고를 한 번 더 검사
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if (!product.hasEnoughStock(quantity)) {
                System.out.println(product.getProductName() + " 상품의 재고가 부족하여 주문할 수 없습니다.");
                return;
            }
        }

        long totalPrice = cart.getTotalPrice();

        System.out.println("주문이 완료되었습니다! 총 금액: " + String.format("%,d원", totalPrice));

        // 실제 재고 차감
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            int beforeStock = product.getProductStock();
            product.decreaseStock(quantity);
            int afterStock = product.getProductStock();

            System.out.println(product.getProductName() + " 재고가 "
                    + beforeStock + "개 -> " + afterStock + "개로 업데이트되었습니다.");
        }

        // 주문 완료 후 장바구니 초기화
        cart.clear();
    }

    // 주문 취소
    public void cancelOrder() {
        customer.getCart().clear();
        System.out.println("진행중인 주문을 취소했습니다.");
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