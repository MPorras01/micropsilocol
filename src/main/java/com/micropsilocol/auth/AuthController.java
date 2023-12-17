package com.micropsilocol.auth;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping(value = "login")
    public String login() {
        return "Login for public endpoint";
    }

    @PostMapping(value = "register")
    public String register() {
        return "register for public endpoint";
    }
}
