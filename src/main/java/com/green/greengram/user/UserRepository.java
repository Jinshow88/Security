package com.green.greengram.user;


import com.green.greengram.entity.User;
import com.green.greengram.security.SignInProviderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //메소드 쿼리
    User findUserByProviderTypeAndUid(SignInProviderType providerType, String uid);
}
