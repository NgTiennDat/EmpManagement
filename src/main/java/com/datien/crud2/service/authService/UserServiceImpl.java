package com.datien.crud2.service.authService;

import com.datien.crud2.model.user.User;
import com.datien.crud2.model.user.UserDto;
import com.datien.crud2.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserRepository repository;

    @Override
    public void savedUser(UserDto userDto) {
        var user = mapper.toUser(userDto);
        repository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public List<UserDto> findAllUser() {
        return repository.findAll()
                .stream()
                .map(mapper::toUserDto)
                .collect(Collectors.toList());
    }
}
