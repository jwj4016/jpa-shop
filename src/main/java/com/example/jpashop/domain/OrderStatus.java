package com.example.jpashop.domain;

public enum OrderStatus {
    READY("주문준비"), COMP("주문완료");

    final private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
