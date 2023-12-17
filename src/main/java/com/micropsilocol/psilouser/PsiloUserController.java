package com.micropsilocol.psilouser;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class PsiloUserController {

    @PostMapping()
    public String welcome() {
        return "welcome to sercret micropsilocol";
    }
}
