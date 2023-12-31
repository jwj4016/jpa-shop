package com.example.jpashop.service;

import com.example.jpashop.domain.*;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.repository.MemberRepository;
import com.example.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberService memberService;
    private final ItemService itemService;

    /** 주문 */
    public Long order(Long memberId, Long itemId, int count) {
        //엔티티 조회
        Member member = memberService.findOne(memberId);
        Item item = itemService.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);
        return order.getId();
    }

    /**
     * 주문 취소
     */
    public void cancelOrder(Long orderId) {
        //주문 엔티티 조회
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        //주문 취소
        if (orderOptional.isPresent()) orderOptional.get().cancel();
    }

    /**
     * 주문 검색
     */
    //리팩토링 전
    //public List<Order> findOrders(OrderSearch orderSearch) {
    //    return orderRepository.findAll(orderSearch);
    //}
    public List<Order> findOrders(OrderSearch orderSearch) {
        //return orderRepository.findAll(orderSearch.toSpecification());
        return orderRepository.search(orderSearch);
    }
}
