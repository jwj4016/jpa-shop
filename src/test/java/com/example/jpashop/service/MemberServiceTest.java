package com.example.jpashop.service;

import com.example.jpashop.domain.Member;
import com.example.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() {
        //참고 : @Transactional 없이 테스트 진행할 경우 member,member1,member2 주소값이 다 다르다.
        //Given
        Member member = new Member();
        member.setName("Jung");

        //When
        Long savedId = memberService.join(member);

        Member member1 = memberService.findOne(savedId);
        Member member2 = memberRepository.findOne(savedId);
        //Then
        Assertions.assertEquals(member, member2);
    }

    @Test
    public void 중복_회원_예외() {
        //Given
        Member member1 = new Member();
        member1.setName("jung");

        Member member2 = new Member();
        member2.setName("jung");

        //When
        memberService.join(member1);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);    //예외 발생.
        });
    }
}
