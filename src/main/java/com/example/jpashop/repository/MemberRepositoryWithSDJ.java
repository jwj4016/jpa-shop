package com.example.jpashop.repository;

import com.example.jpashop.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//쿼리메소드 사용
//엔티티 필드명 변경 시 인터페이스에 정의된 메소드명도 함께 바뀌어야 한다.
//사용자 정의 인터페이스 상속
public interface MemberRepositoryWithSDJ extends JpaRepository<Member, Long>
        //, MemberRepositoryCustom
    {
    Member findByUsername(String username);

    //select m from Member m where m.email = ?! and m.name = ?2
    //List<Member> findByEmailAndName(String email, String name);

    //Named Query 호출.
    //List<Member> findByUsername(@Param("username") String username);

    //@Query("select m from Member m where m.name = ?1")
    //Member findByUsernameUsingQuery(String param);

    //네이티브 SQL은 위치 기반 파라미터가 0부터 시작됨.(JPQL은 위치기반 파라미터 1부터 시작.)
    //@Query(value = "SELECT * FROM MEMBER WHERE NAME = ?0"
    //        , nativeQuery = true)
    //Member findByUsernameUsingNativeQuery(String param);

    //@Query("select m from Member m where m.name = :name")
    //Member findByUsernameUSingLocationParam(@Param("name") String param);

    //스프링 데이터 jpa 사용한 벌크성 수정 쿼리 예시
    /*
        //jpa 사용.
        int bulkPriceUp(String stockAmount){
            String qlString = "update Product p set p.price = p.price * 1.1 where
                p.stockAmount < : stockAmount";
            int resultCount = entityManager.createQuery(qlString)
                                           .setParameter("stockAmount", stockAmount)
                                           .executeUpdate();
        }

        //spring data jpa 사용.
        @Modifying
        //@Modifying(clearAutomatically = true) 벌크성 쿼리 실행 후 영속성 컨텍스트 초기화.
        @Query("update Product p set p.price = p.price * 1.1 where
            p.stockAmount < :stockAmount")
        int bulkPriceUp(@param("stockAmount") String stockAmount);
     */

    //페이징
    /*
        //count 쿼리 사용함.
        Page<Member> findByName(String name, Pageable pageable);

        //count 쿼리 사용 안 함.
        List<Member> findByName(String name, Pageable pageable);

        List<Member> findByName(String name, Sort sort);
     */

    //이름이 김으로 시작하고, 이름 내림차순이고, 첫 번째 페이지, 페이지당 보여줄 데이터 10건으로 조회하는 코드
    /*
        //repository 내부 (Pageable 인터페이스를 파라미터로 받는다.)
        Page<Member> findByNameStartingWith(String name, Pageable pageable);

        //실행 코드
        //PageRequest 는 Pageable 구현함.
        PageRequest pageRequest = new PageRequest(0, 10, new Sort(Direction.DESC, "name"));
        Page<Member> result = memberRepository.findByNameStartingWith("김", pageRequest);
        List<Member> memberList = result.getContent(); //조회된 데이터
        int totalPages = result.getTotalPAges(); //전체 페이지 수
        boolean hasNextPage = result.hasNextPage(); //다음 페이지 존재 여부
     */

    public Page<Member> findAll(Pageable pageable);
}