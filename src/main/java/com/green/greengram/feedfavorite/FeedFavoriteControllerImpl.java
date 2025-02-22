package com.green.greengram.feedfavorite;

import com.green.greengram.common.model.MyResponse;
import com.green.greengram.feedfavorite.model.FeedFavoriteReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed/favorite")
public class FeedFavoriteControllerImpl implements FeedFavoriteController {
    private final FeedFavoriteService service;

    @GetMapping
    public MyResponse<Integer> toggleReq(FeedFavoriteReq p) {

        int result = service.toggleReq(p);
        return MyResponse.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(result == 0? "좋아요 취소" : "좋아요")
                .resultData(result)
                .build();
    }
}
