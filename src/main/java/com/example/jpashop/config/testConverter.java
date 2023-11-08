package com.example.jpashop.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)    //모든 Boolean 타입에 컨버터를 적용한다.
public class testConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute){
        return (attribute != null && attribute) ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData){
        return "Y".equals(dbData);
    }
}


/**
    //엔티티 필드에 convert 어노테이션 적용.
    @Entity
    public class Member {
        @Id @generatedValue
        private Long id;

        @Column(name = "MEMBER_NAME")
        private String username;

        @Convert(converter = testConverter.class)
        private boolean vip;
    }

    //엔티티 클래스에 convert 어노테이션 적용.
    @Entity
    @Convert(converter=BooleanToYNConverter.class, attributeName = "vip")
    public class Member {
        @Id
        private String id;
        private String username;

        private boolean vip;
    }


*/
