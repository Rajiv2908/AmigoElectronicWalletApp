package com.amigo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amigo.entity.User;
import com.amigo.repositories.UserRepository;
import com.amigo.service.UserService;

//1. POST: http://localhost:8080/api/users/register -> Create new Users

/*
{
    "name": "Vivan",
    "email": "viv@gamil.com",
    "mobile": "9234567891",
    "password": "viv123"
}
*/

//2. Login:=> http://localhost:8080/api/users/login?emailOrMobile=vansh@gamil.com&password=vansh1234

//3. Change password:=> POST: http://localhost:8080/api/users/change-password?email=vansh@gamil.com&oldPassword=vansh123&newPassword=vansh1234


@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String emailOrMobile, @RequestParam String password) {
        return ResponseEntity.ok(userService.login(emailOrMobile, password));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String email, @RequestParam String newPassword) {
        return ResponseEntity.ok(userService.resetPassword(email, newPassword));
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestParam String email, @RequestParam String oldPassword, @RequestParam String newPassword) {
        return ResponseEntity.ok(userService.changePassword(email, oldPassword, newPassword));
    }
}
