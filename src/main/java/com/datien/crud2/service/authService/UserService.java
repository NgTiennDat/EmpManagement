package com.datien.crud2.service.authService;

import com.datien.crud2.model.user.User;
import com.datien.crud2.model.user.UserDto;

import java.util.List;

public interface UserService {
    void savedUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUser();
}
