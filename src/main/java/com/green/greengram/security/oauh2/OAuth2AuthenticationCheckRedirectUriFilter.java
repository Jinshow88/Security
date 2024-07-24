package com.green.greengram.security.oauh2;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2AuthenticationCheckRedirectUriFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request // 요청에대한 모든 정보
                                  , HttpServletResponse response// 응답할수 있는 객체
                                  , FilterChain filterChain// 다음 필터로 req, res 를 전달할 때 사용
    ) throws ServletException, IOException{
        /*
            호스트 값을 제외한 uri 를 리턴
            예) http://localhost:8080/aaa/bbb
            "aaa/bbb" 를 리턴
         */
        String requestUri = request.getRequestURI();
        log.info("requestUri: {}", requestUri);
    }
}
