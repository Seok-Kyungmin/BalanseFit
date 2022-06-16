package com.balansefit.service.impl;

import com.balansefit.dto.UserInfoDTO;
import com.balansefit.dto.UserWeightDTO;
import com.balansefit.persistance.mapper.IMyPageMapper;
import com.balansefit.service.IMyPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service("MyPageService")
public class MyPageService implements IMyPageService {

    @Resource(name = "IMyPageMapper")
    private IMyPageMapper myPageMapper;

    // 마이 페이지 사용자게시판
    @Override
    public List<UserInfoDTO> getSmallInfoList() throws Exception{
        return myPageMapper.getSmallInfoList();
    }

    // 프로필 리스트
    @Override
    public List<UserInfoDTO> getUserInfoList() throws Exception{
        return myPageMapper.getUserInfoList();
    }

    // 프로필 글 수정
    @Transactional
    @Override
    public void updateUserInfo(UserInfoDTO uDTO) throws Exception {

        log.info(this.getClass().getName() + "updateUserInfo 시작!");

        myPageMapper.updateUserInfo(uDTO);

        log.info(this.getClass().getName() + "updateUserInfo 끝!");
    }

    // 일일 몸무게 리스트
    @Override
    public List<UserWeightDTO> getWeightList() throws Exception {
        log.info(this.getClass().getName() + "getWeightList 시작!");
        return myPageMapper.getWeightList();
    }
}
