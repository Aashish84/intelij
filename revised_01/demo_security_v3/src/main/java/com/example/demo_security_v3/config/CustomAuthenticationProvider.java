package com.example.demo_security_v3.config;

import com.example.demo_security_v3.entity.AuthUser;
import com.example.demo_security_v3.repo.AuthUserRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final PasswordEncoder encoder;
    private final AuthUserRepo authUserRepo;
    private final HttpServletRequest request;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        certificate login
        X509Certificate[] clientCertificates = (X509Certificate[]) request.getAttribute("jakarta.servlet.request.X509Certificate");
        if (clientCertificates != null) {
//        TODO:validate certificate with trust-store
            System.out.println(clientCertificates.length);
//            System.out.println(clientCertificates[1]);
            return new UsernamePasswordAuthenticationToken("test", "test", new ArrayList<>());
        }

//      form login
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        AuthUser authUser = authUserRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user " + email + " not found"));
        List<GrantedAuthority> tempAuthUserRoles = new ArrayList<>();
        authUser.getRoles().forEach(e -> tempAuthUserRoles.add(new SimpleGrantedAuthority(e.getRole())));

        if (encoder.matches(password, authUser.getPassword()))
            return new UsernamePasswordAuthenticationToken(email, password, tempAuthUserRoles);

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
