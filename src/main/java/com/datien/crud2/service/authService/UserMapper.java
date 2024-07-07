package com.datien.crud2.service.authService;

import com.datien.crud2.model.role.Role;
import com.datien.crud2.model.user.User;
import com.datien.crud2.model.user.UserDto;
import com.datien.crud2.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public User toUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.firstname() + " " + userDto.lastname());
        user.setEmail(userDto.email());
        user.setPassword(passwordEncoder.encode(userDto.password()));

        var role = roleRepository.findByName("ADMIN")
                        .orElseGet(() -> {
            Role newRole = new Role();
            newRole.setName("ADMIN");
            roleRepository.save(newRole);
            return newRole;
        });
        user.setRoles(List.of(role));
        return user;
    }

    public UserDto toUserDto(User user) {
        String[] str = user.getUsername().split(" ");
        return new UserDto(str[0], str[1], user.getEmail(), user.getPassword());
    }

}
