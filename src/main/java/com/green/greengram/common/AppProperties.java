package com.green.greengram.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Getter
@ConfigurationProperties(prefix = "app")// prefix의 'app'은 application.yaml파일

public class AppProperties {
    private final Jwt jwt = new Jwt();
    private final OAuth2 = new OAuth2();

    public Object getOauth2() {
    }

    // class 명 Jwt 는 application.yaml 의 45Line 의 jwt 를 의미
    // 멤버필드명은 application.yaml 의 app/jwt/*속성명과 매칭
    //application.yaml 에서 '-'는 멤버필드에서 카멜케이스기법과 매칭
    @Setter
    @Getter
    public static class Jwt{
        private String secret;
        private String headerSchemaName;
        private String tokenType;
        private long accessTokenExpiry;
        private long refreshTokenExpiry;
        private int refreshTokenCookieMaxAge;

        public void setRefreshTokenExpiry(long refreshTokenExpiry){
            this.refreshTokenExpiry = refreshTokenExpiry;
            this.refreshTokenCookieMaxAge = (int) (refreshTokenExpiry * 0.001); // ms > s변환
        }
    }
    
    @Getter
    @Setter
    public static class OAuth2{
        private String authorizationRequest;
        private String removeAuthorizationRequest;
        private int cookieExpirySeconds;
    }
}
