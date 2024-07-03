package com.green.greengram.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor// 생성자를 만듬(기본 생성자가 없어짐)
@Component// 클래스를 객체화 시키는 임무
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    // 클래스를 상속 받았는데 빨간줄 >>> 추상 메소드(강제성이 존재 == 꼭 구현 해야한다. )이다
    private final JwtTokenProvider2 jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //header 의 authorization 키에 저장도어 있는 값을 리턴(있으면 문자열(JWT), 없으면 null)
        //JWT 값이 있으면 로그인 상태, null  이면 비로그인 상태(로그아웃 상태)
        String token = jwtTokenProvider.resolveToken(request);
        log.info("JwtAuthenticationFilter-Token : {}", token);

        //토큰이 정상적으로 저장되어 있고, 만료가 되지 않았다면
        if(token != null && jwtTokenProvider.isValidateToken(token)) {//isValidateToken(token)(만료시간 체크)
            Authentication auth = jwtTokenProvider.getAuthentication(token);//SecurityContextHolder 의 Context 의 담기 위한 Authentication 객체 생성
            if(auth != null) {
                //Authentication 객ㅊ 주소값을 담으면 인증되었다고 인식
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);



    }
}