package com.green.greengram.feedfavorite;

import com.green.greengram.entity.FeedFavorite;
import com.green.greengram.entity.User;
import com.green.greengram.feedfavorite.model.FeedFavoriteReq;
import com.green.greengram.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeedFavoriteServiceImpl implements FeedFavoriteService {
    private final FeedFavoriteMapper mapper;
    private final AuthenticationFacade authenticationFacade;
    private final FeedFavoriteRepository feedFavoriteRepository;

    public int toggleReq(FeedFavoriteReq p) {
        FeedFavorite feedFavorite = feedFavoriteRepository.getReferenceById(authenticationFacade.getLoginUserId());
        feedFavoriteRepository.deleteById(feedFavorite.getFeed().getFeedId());
        if (feedFavorite.getFeedFavoriteId() == 1){
            return 0;
        }
        return feedFavoriteRepository.save();









        //        p.setUserId(authenticationFacade.getLoginUserId());
//        int result = mapper.delFeedFavorite(p);
//        if(result == 1) {
//            return 0;
//        }
//        return mapper.insFeedFavorite(p);

    }

}