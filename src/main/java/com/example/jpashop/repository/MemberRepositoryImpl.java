package com.example.jpashop.repository;

import com.example.jpashop.domain.Member;

import java.util.List;

//naming convention => name of Interface + "Impl"
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    @Override
    public List<Member> findMemberCustom() {
        //사용자 정의 구현.
        return null;
    }
}
