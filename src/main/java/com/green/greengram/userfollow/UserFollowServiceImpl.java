package com.green.greengram.userfollow;

import com.green.greengram.entity.User;
import com.green.greengram.entity.UserFollow;
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

    @Override
    public int postUserFollow(UserFollowReq p) {
        UserFollow userFollow = new UserFollow();
        userFollow.setFromUser(userFollow.getFromUser());
        userFollow.setToUser(userFollow.getToUser());
        userFollowRepository.save(userFollow);

//        return mapper.insUserFollow(p);
        return 1;
    }

    @Override
    public int deleteUserFollow(UserFollowReq p) {
//        long find = userFollowRepository.findByFromUserAndToUser();
//        userFollowRepository.deleteById(find);



        return mapper.delUserFollow(p);
//        return 1;
    }
}
