package com.green.greengram.userfollow;

import com.green.greengram.entity.User;
import com.green.greengram.entity.UserFollow;
import com.green.greengram.security.AuthenticationFacade;
import com.green.greengram.user.UserRepository;
import com.green.greengram.userfollow.model.UserFollowReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserFollowServiceImpl implements UserFollowService {
    private final UserFollowMapper mapper;
    private final UserFollowRepository userFollowRepository;
    private final AuthenticationFacade authenticationFacade;
    private final UserRepository userRepository;

    @Override
    public int postUserFollow(UserFollowReq p) {
        User fromUser = userRepository.getReferenceById(authenticationFacade.getLoginUserId());
        User toUser = userRepository.getReferenceById(p.getFromUserId());

        UserFollow userFollow = new UserFollow();
        userFollow.setFromUser(fromUser);
        userFollow.setToUser(toUser);

        userFollowRepository.save(userFollow);

//        return mapper.insUserFollow(p);
        return 1;
    }

    @Override
    public int deleteUserFollow(UserFollowReq p) {
        UserFollow userFollow = userFollowRepository.findUserFollowByFromUserAndToUser(authenticationFacade.getLoginUserId(), p.getToUserId());
//        long find = userFollowRepository.findByFromUserAndToUser();
        userFollowRepository.delete(userFollow);



//        return mapper.delUserFollow(p);
        return 1;
    }
}
