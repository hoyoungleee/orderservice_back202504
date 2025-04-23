package com.playdata.orderservice.user.dto;

import com.playdata.orderservice.address.entity.Address;
import com.playdata.orderservice.user.entity.Role;
import com.playdata.orderservice.user.entity.User;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResDto {

    private Long id;
    private String email;
    private String name;
    private Role role;
    private Address address;



}
