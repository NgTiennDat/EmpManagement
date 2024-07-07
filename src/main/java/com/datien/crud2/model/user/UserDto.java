package com.datien.crud2.model.user;

public record UserDto(
        String firstname,
        String lastname,
        String email,
        String password
) {

}
