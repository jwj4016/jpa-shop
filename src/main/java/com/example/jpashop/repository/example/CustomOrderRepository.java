package com.example.jpashop.repository.example;

import com.example.jpashop.domain.Order;
import com.example.jpashop.domain.OrderSearch;

import java.util.List;

//스프링 데이터 JPA가 제공하는 공통 인터페이스는 직접 구현이 불가능하기 때문에 사용자 정의 repository 만든다.
public interface CustomOrderRepository {
    public List<Order> search(OrderSearch orderSearch);
}
