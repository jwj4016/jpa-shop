package com.example.jpashop.repository;

import com.example.jpashop.domain.item.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //JPA 예외가 발생해도 스프링 예외로 던진다.
public class ItemRepository {
    @PersistenceContext //엔티티 매니저 주입
    EntityManager entityManager;

    public Long save(Item item) {
        if (item.getId() == null) {
            entityManager.persist(item);
        } else {
            entityManager.merge(item);
        }
        return item.getId();
    }

    public Item findOne(Long id) {
        return entityManager.find(Item.class, id);
    }


    public List<Item> findAll() {
        return entityManager.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
