package com.example.jpashop.service;

import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ItemServiceTest {
    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 상품등록() {
        //참고 : @Transactional 없이 테스트 진행할 경우 member,member1,member2 주소값이 다 다르다.
        //Given
        Item item = new Item();
        item.setName("아이템1");
        item.setPrice(10000);
        item.setStockQuantity(10);

        //When
        Long savedId = itemService.saveItem(item);

        Item item1 = itemService.findOne(savedId);
        Item item2 = itemRepository.findOne(savedId);
        //Then
        Assertions.assertEquals(item, item2);
    }
}
