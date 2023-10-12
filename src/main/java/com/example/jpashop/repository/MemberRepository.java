package com.example.jpashop.repository;

import com.example.jpashop.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //JPA 예외가 발생해도 스프링 예외로 던진다.
public class MemberRepository {
    //순수 자바 환경에서는 엔티티 매니저 팩토리에서 엔티티 매니저 직접 생성 사용.
    //스프링 환경에서는 컨테이너가 엔티티 매니저 관리하고 제공.
    //엔티티 매니저 팩토리를 주입 받으려면,아래와 같이 사용.
    //@PersistenceUnit
    //EntityManagerFactory emf;
    @PersistenceContext //엔티티 매니저 주입
    EntityManager entityManager;

    public void save(Member member) {
        entityManager.persist(member);
//        System.out.println(entityManager.contains(member));
    }

    public Member findOne(Long id) {
        return entityManager.find(Member.class, id);
    }

    public List<Member> findAll() {
        return entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return entityManager.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
