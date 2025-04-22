package com.playdata.orderservice.address.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

// 타 엔터티에서 사용 가능한 형태로 만드는 아노테이션
@Embeddable
@Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    private String city;
    private String street;
    private String zipCode;

}
