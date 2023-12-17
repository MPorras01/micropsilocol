package com.micropsilocol.auth;

import com.micropsilocol.jwt.JwtService;
import com.micropsilocol.psilouser.Role;
import com.micropsilocol.psilouser.PsiloUser;
import com.micropsilocol.psilouser.PsiloUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PsiloUserRepository userRepository;
    private final JwtService jwtService;
    public AuthReponse login(LoginRequest request) {
        return null;
    }

    public AuthReponse register(RegisterRequest request) {
        PsiloUser user = PsiloUser.builder()
                .username(request.getUserName())
                .password(request.getPassword())
                .firstName(request.firstName)
                .lastname(request.lastname)
                .country(request.country)
                .role(Role.USER)
                .build();

        userRepository.save(user);
        return AuthReponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
