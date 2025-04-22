package com.playdata.orderservice.user.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLoginReqDto {
    private String email;
    private String password;
}
