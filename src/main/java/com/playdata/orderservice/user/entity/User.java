package com.playdata.orderservice.user.entity;

import com.playdata.orderservice.address.entity.Address;
import jakarta.persistence.*;
import lombok.*;

// Entitydp Setter를 구현하지 않은 이유는 Entity 자체가 DB와 연동하기 위한 객체
// DB에 삽입되는 데이터, DB에서 조회된 데이터는 그자체로 사용하고 수정되지 않게끔
//Setter를 사용하지 않는것을 권장.
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(length=20, nullable=false)
    private String name;

    @Column(nullable=false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Builder.Default // builder 패턴 사용해서 객체 초기화 시 초기값으로 세팅
    private Role role = Role.USER;

    @Embedded // @Embeddable로 선언된 값 대입
    private Address address;
    

}
