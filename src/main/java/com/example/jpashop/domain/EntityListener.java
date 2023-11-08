package com.example.jpashop.domain;

import jakarta.persistence.*;

//요구사항 예시 : 언제 어떤 사용자가 삭제를 요청했는지 로그 남기기.
//@Entity
//@EntityListeners(EventListener.class)
public class EntityListener {
    //@Id @GeneratedValue
    public Long id;

    private String name;
    /**
        //엔티티에 이벤트를 직접 적용하는 방식
        @PrePersist
        public void prePersist() {
            //persist() 호출 후 엔티티를 영속성 컨텍스트에 관리하기 직전에 호출.
            //To do...
        }

        @PostPersist
        public void postPersist() {
            //flush or commit 호출 후 엔티티를 db 저장 직후에 호출. 식별자 항상 존재.
            //참고 : 식별자 생성 전략이 IDENTITY면 식별자 생성을 위해 persist() 호출 후 바로 이벤트 발생.
            //To do...
        }

        @PostLoad
        public void postLoad() {
            //엔티티가 영속성 컨텍스트에 조회된 직후 또는 refresh를 호출한 후 이벤트 발생.(2차 캐시에 저장되어 있어도 호출된다.)
            //To do...
        }

        @PreRemove
        public void preRemove() {
            //remove 메소드 호출해 엔티티를 영속성 컨텍스트에 삭제하기 직전에 호출.
            //To do...
        }

        @PostRemove
        public void postRemove() {
            //flush나 commit을 호출해서 엔티티를 db에 삭제한 직후에 호출.
            //To do...
        }
     */
}
