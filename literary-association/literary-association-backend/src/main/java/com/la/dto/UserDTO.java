package com.la.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String type;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String state;
    private String city;
    private String email;
    private boolean active;
    private boolean deleted;
}
