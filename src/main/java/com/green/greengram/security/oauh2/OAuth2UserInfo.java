package com.green.greengram.security.oauh2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;


@Getter
@RequiredArgsConstructor// 내가 가지고 있는 것만 가능
public abstract class OAuth2UserInfo {
    //<key 타입, value 타입> key 를 불러오면 value 값을 가져 온다.
    //Social 플랫폼에서 받아온 Data(JSON) 을 HashMap 으로 컨버팅하여 내가 직접 DI 해준다.
    protected final Map<String, Object> attributes;

    public abstract String getId();//유니크 값 리턴
    public abstract String getName();//이름
    public abstract String getEmail();//이메일
    public abstract String getProfilePicUrl();//프로필 사진
}
