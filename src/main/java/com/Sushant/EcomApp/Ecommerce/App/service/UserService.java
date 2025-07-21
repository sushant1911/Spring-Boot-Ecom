package com.Sushant.EcomApp.Ecommerce.App.service;

import com.Sushant.EcomApp.Ecommerce.App.Entity.Role;
import com.Sushant.EcomApp.Ecommerce.App.Entity.User;
import com.Sushant.EcomApp.Ecommerce.App.repo.RoleRepo;
import com.Sushant.EcomApp.Ecommerce.App.repo.UserRepo;
import com.Sushant.EcomApp.Ecommerce.App.utils.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private  final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepository;

    public UserService(UserRepo userRepository, PasswordEncoder passwordEncoder, RoleRepo roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User registerUser(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists with email");
        }

        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("USER role not found"));

        User user = new User();
        user.setUserFirstName(request.getUserFirstName());
        user.setUserMiddleName(request.getUserMiddleName());
        user.setUserLastName(request.getUserLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setMobileNumber(request.getMobileNumber());
        user.setBirthday(request.getBirthday());
        user.setRoles(List.of(userRole));

        return userRepository.save(user);
    }

}
