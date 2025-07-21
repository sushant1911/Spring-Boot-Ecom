package com.Sushant.EcomApp.Ecommerce.App.controller;

import com.Sushant.EcomApp.Ecommerce.App.Entity.User;
import com.Sushant.EcomApp.Ecommerce.App.service.UserService;
import com.Sushant.EcomApp.Ecommerce.App.utils.RegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String welcome()
    {
        return  "welcome";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        User registeredUser = userService.registerUser(request);
        return ResponseEntity.ok("User registered successfully with email: " + registeredUser.getEmail());
    }
}