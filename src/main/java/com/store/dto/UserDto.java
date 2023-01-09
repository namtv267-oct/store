package com.store.dto;

import lombok.Data;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private String phone;

    public UserDto(String firstName, String lastName, String username, String password, String address, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public UserDto() {
    }
}
