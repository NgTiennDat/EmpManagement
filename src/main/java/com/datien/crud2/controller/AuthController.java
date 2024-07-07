package com.datien.crud2.controller;

import com.datien.crud2.model.user.User;
import com.datien.crud2.model.user.UserDto;
import com.datien.crud2.service.authService.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    // handler method to handle home page request
    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "/register";
    }

    @GetMapping("/register/save")
    public String registration(
            @Valid @ModelAttribute("user") UserDto userDto,
            BindingResult result,
            Model model
    ) {
        User existingUser = userService.findUserByEmail(userDto.email());

        if (existingUser != null && existingUser.getEmail() != null &&  !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "This email is already in use");
        }

        if(result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }
        userService.savedUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "users";
    }

}
