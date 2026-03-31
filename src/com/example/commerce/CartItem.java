package com.example.commerce;

public class CartItem {

    // -------------------------
    // 속성
    // -------------------------
    private Product product;
    private int quantity;


    // -------------------------
    // 생성자
    // -------------------------
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }


    // -------------------------
    // getter
    // -------------------------
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }


    // -------------------------
    // 기능
    // -------------------------

    // 장바구니에 담긴 수량을 증가시키는 메서드
    public void increaseQuantity(int amount) {
        if (amount <= 0){
            return;
        }

        quantity += amount;
    }

    // 이 CartItem의 총 가격 계산
    public long getTotalPrice() {
        return product.getProductPrice() * quantity;
    }

}
