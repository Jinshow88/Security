package com.green.greengram.admin;

import com.green.greengram.admin.model.GetProviderReq;
import com.green.greengram.admin.model.GetProviderRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl {
    private final AdminMapper mapper;

    public List<GetProviderRes> getProvider(){
        return mapper.getProvider();
    }
}
