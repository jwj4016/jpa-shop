package com.example.jpashop.domain;

public enum OrderStatus {
    CANCEL("취소"), ORDER("주문");

    final private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
