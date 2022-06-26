package com.balansefit.service.impl;

import com.balansefit.dto.UserInfoDTO;
import com.balansefit.dto.UserWeightDTO;
import com.balansefit.persistance.mapper.IMyPageMapper;
import com.balansefit.service.IMyPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("MyPageService")
public class MyPageService implements IMyPageService {

    private final IMyPageMapper myPageMapper;

    @Autowired
    public MyPageService(IMyPageMapper myPageMapper) {
        this.myPageMapper = myPageMapper;
    }


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

    @Override
    public List<UserWeightDTO> getWeightList(UserWeightDTO wDTO) throws Exception {
        log.info(this.getClass().getName()+wDTO.getUser_id());
        log.info(this.getClass().getName() + "getWeightList 시작!");
        List<UserWeightDTO> flist = myPageMapper.getWeightList(wDTO);
        if (flist.size()>0){
            log.info("flist.size()"+flist.size());
        }else {
            flist= new ArrayList<>();
        }
        log.info(this.getClass().getName() + "getWeightList 시작!");

        return flist;
    }
}
