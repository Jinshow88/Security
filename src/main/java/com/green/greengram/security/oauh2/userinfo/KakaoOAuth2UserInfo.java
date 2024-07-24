package com.green.greengram.security.oauh2.userinfo;

import java.util.Map;
//규격화 작업 중 (각 홈페이지 마다 코드가 달라서 우리가 사용하기 쉽게 하기 위한 작업)
public class KakaoOAuth2UserInfo extends OAuth2UserInfo {

    public KakaoOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return attributes.get("id").toString();//구글에서 한거랑 같은거 둘중 아무거나 사요 가능
    }

    @Override
    public String getName() {
        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
        return properties == null ? null : properties.get("nickname").toString();
    }

    @Override
    public String getEmail() {
        return attributes.get("account_email").toString();
    }

    @Override
    public String getProfilePicUrl() {
        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
        return properties == null ? null : properties.get("thumbnail_image").toString();
    }
}
