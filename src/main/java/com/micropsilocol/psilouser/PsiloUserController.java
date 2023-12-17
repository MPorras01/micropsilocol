package com.micropsilocol.psilouser;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class PsiloUserController {

    @PostMapping(value = "user")
    public String welcome() {
        return "welcome to sercret micropsilocol";
    }
}
