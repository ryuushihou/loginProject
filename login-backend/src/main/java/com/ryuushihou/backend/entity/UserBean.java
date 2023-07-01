package com.ryuushihou.backend.entity;

import lombok.Data;

@Data
public class UserBean {

    public Integer id;
    public String username;
    public String password;
    public String email;

}
