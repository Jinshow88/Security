package com.green.greengram.admin;

import com.green.greengram.admin.model.GetProviderReq;
import com.green.greengram.admin.model.GetProviderRes;
import com.green.greengram.common.model.MyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminControllerImpl {
    private final AdminServiceImpl service;

    @GetMapping("/provider-count")
    public MyResponse<List<GetProviderRes>> getProvider(){
        List<GetProviderRes> list = service.getProvider();

        return MyResponse.<List<GetProviderRes>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("조회완료")
                .resultData(list)
                .build();
    }
}
