package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    // -------------------------
    // 속성
    // -------------------------
    private List<CartItem> items;


    // -------------------------
    // 생성자
    // -------------------------
    public Cart() {
        this.items = new ArrayList<>();
    }


    // -------------------------
    // getter
    // -------------------------
    public List<CartItem> getItems() {
        return items;
    }


    // -------------------------
    // 기능
    // -------------------------

    // 장바구니에 상품 추가
    public void addProduct(Product product, int quantity) {
        // 잘못된 수량이면 추가하지 않음
        if (quantity <= 0) {
            return;
        }

        // 이미 장바구니에 같은 상품이 있으면 수량만 증가
        for (CartItem item : items) {
            if (item.getProduct() == product) {
                item.increaseQuantity(quantity);
                return;
            }
        }

        // 처음 담는 상품이면 새로운 CartItem 생성
        CartItem newItem = new CartItem(product, quantity);
        items.add(newItem);
    }

    // 장바구니가 비어있는지 확인
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // 장바구니 전체 금액 계산
    public long getTotalPrice() {
        long totalPrice = 0;

        for (CartItem item : items) {
            totalPrice += item.getTotalPrice();
        }

        return totalPrice;
    }

    // 장바구니 목록 출력
    public void showCartItems() {
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return;
        }

        System.out.println("\n [ 장바구니 목록 ]");

        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);

            System.out.println((i + 1) + ". "
                    + item.getProduct().getProductName()
                    + " | 수량: " + item.getQuantity()
                    + " | 합계: " + String.format("%,d원", item.getTotalPrice()));
        }

        System.out.println("총 금액: " + String.format("%,d원", getTotalPrice()));
    }

    // 특정 상품이 장바구니에 몇 개 담겨 있는지 확인하는 메서드
    public int getQuantityByProduct(Product product) {
        for (CartItem item : items) {
            if (item.getProduct() == product) {
                return item.getQuantity();
            }
        }
        return 0;

    }


}
