package com.example.server01.filter;

import com.example.server01.service.JWTService;
import com.example.server01.service.JpaUserDetailService;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final JpaUserDetailService jpaUserDetailService;

    public JWTAuthFilter(JWTService jwtService, JpaUserDetailService jpaUserDetailService) {
        this.jwtService = jwtService;
        this.jpaUserDetailService = jpaUserDetailService;
    }

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if(authHeader != null && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = jpaUserDetailService.loadUserByUsername(username);
            if(jwtService.validateToken(token , userDetails)){
                UsernamePasswordAuthenticationToken authenticationToken = new
                        UsernamePasswordAuthenticationToken(userDetails , null , userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }else{
                throw new Exception("user and token didnot match");
            }
        }
        filterChain.doFilter(request,response);
    }
}
