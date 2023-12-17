package com.micropsilocol.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping()
    public String welcome() {
        return "welcome to sercret micropsilocol";
    }
}
