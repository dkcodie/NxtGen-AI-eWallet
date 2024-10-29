package com.dkcodie.ewallet.controller;

import com.dkcodie.ewallet.dto.UserDto;
import com.dkcodie.ewallet.entity.User;
import com.dkcodie.ewallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class WalletController {

    private final UserService userService;

    @Autowired
    public WalletController(UserService userService) {
        this.userService = userService;
    }

   // Get user details including wallet balance
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable Long id) {
        User user = userService.findById(id); // Assuming findById method exists in UserService
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/api/users") //List Peer Users Endpoint
    public ResponseEntity<List<UserDto>> listAllUsers() {
        List<UserDto> users = userService.findAllUsers(); // Adjust to exclude the current user if needed
        return ResponseEntity.ok(users);
    }


}
