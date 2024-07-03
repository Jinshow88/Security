package com.green.greengram.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CookieUtils {

    private final ObjectMapper om;


    public Cookie getCookie(HttpServletRequest req, String name){
        Cookie[] cookies = req.getCookies();//요청에서 모든 쿠키 정보를 받는다.
        if (cookies != null && cookies.length > 0){//쿠키 정보가 있고 쿠키가 하나 이상 담겨있는게 있다면
            for(Cookie cookie : cookies){
                // 찾는 key 가 있는지 확인 후 있다면 해당 쿠키 리턴
                if(name.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;
    }

    public <T> T getCookie (HttpServletRequest req, String name, Class<T> valueType){
        Cookie cookie = getCookie(req, name);
        try {
            return om.redValue(cookie.getValue(),valueType);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    public void setCookie(HttpServletResponse res, String name, String value, int maxAge){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");//Root URL(우리 백엔드 모든 요청에 대항하게 세팅)
        cookie.setHttpOnly(true);//보안 쿠키
        cookie.setMaxAge(maxAge);//만료시간
        res.addCookie(cookie);
    }

    public void deleteCookie(HttpServletResponse res, String name){
        setCookie(res,name, null, 0);

    }
}
