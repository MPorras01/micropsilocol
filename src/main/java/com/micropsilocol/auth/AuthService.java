package com.micropsilocol.auth;

import com.micropsilocol.jwt.JwtService;
import com.micropsilocol.psilouser.Role;
import com.micropsilocol.psilouser.PsiloUser;
import com.micropsilocol.psilouser.PsiloUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PsiloUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthReponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUserName()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthReponse.builder().token(token).build();
    }

    public AuthReponse register(RegisterRequest request) {
        PsiloUser user = PsiloUser.builder()
                .username(request.getUserName())
                .password(passwordEncoder.encode( request.getPassword()))
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
