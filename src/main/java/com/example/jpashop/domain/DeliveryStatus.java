package com.example.jpashop.domain;

public enum DeliveryStatus {
    READY("배송준비"), COMP("배송완료");

    final private String status;

    DeliveryStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }


}
