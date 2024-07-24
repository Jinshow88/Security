package com.green.greengram.user.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserInfoRoles extends User{
    private List<String> roles;
}
