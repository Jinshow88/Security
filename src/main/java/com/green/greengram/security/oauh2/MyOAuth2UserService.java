package com.green.greengram.security.oauh2;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.green.greengram.security.MyUser;
import com.green.greengram.security.MyUserDetails;
import com.green.greengram.security.SignInProviderType;
import com.green.greengram.user.UserMapper;
import com.green.greengram.user.model.SignInPostReq;
import com.green.greengram.user.model.SignUpPostReq;
import com.green.greengram.user.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyOAuth2UserService extends DefaultOAuth2UserService {
    private final UserMapper mapper;
    private final OAuth2UserInfoFactory oAuth2UserInfoFactory;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
       OAuth2User oAuth2User = super.loadUser(userRequest);
       try {
           return this.process(userRequest);

       } catch (Exception e){
           throw new InternalAuthenticationServiceException(e.getMessage(), e.getCause());
       }
    }

    private OAuth2User process(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        // 각 소셜 플랫폼에 맞는 enum 타입을 얻는다.
        SignInProviderType signInProviderType = SignInProviderType.valueOf(userRequest.getClientRegistration()
                                                                                        .getRegistrationId()
                                                                                        .toUpperCase()
        );
        // 규격화된 UserInfo 객체로 변환
        OAuth2UserInfo oAuth2UserInfo = oAuth2UserInfoFactory.getOAuth2UserInfo(signInProviderType, oAuth2User.getAttributes());
        SignInPostReq p = new SignInPostReq();
        p.setUid(oAuth2UserInfo.getId());
        p.setProviderType(signInProviderType.name());
        User user = mapper.signInPost(p);

        MyUserDetails signInUser = new MyUserDetails();
        MyUser myUser = new MyUser();
        myUser.setRole("ROLE_USER");


        if (user == null) {//회원가입 처리
            SignUpPostReq signupParam = new SignUpPostReq();
            signupParam.setUid(oAuth2UserInfo.getId());
            signupParam.setNm(oAuth2UserInfo.getName());
            signupParam.setPic(oAuth2UserInfo.getProfilePicUrl());
            int result = mapper.signUpPostReq(signupParam);
            myUser.setUserId(signupParam.getUserId());
        }else{
            myUser.setUserId(user.getUserId());
            signInUser.setMyUser(myUser);
            return signInUser;
        }

        return null;
    }
}







































