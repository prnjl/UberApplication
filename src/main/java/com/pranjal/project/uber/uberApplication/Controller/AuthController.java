package com.pranjal.project.uber.uberApplication.Controller;


import com.pranjal.project.uber.uberApplication.Services.AuthService;
import com.pranjal.project.uber.uberApplication.dto.SignupDto;
import com.pranjal.project.uber.uberApplication.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthService authService;


    @PostMapping("/signup")
    ResponseEntity<UserDto> signUp(@RequestBody SignupDto signupDto) {

        return ResponseEntity.ok(authService.signup(signupDto));


    }
}
