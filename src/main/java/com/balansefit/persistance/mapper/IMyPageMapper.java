package com.balansefit.persistance.mapper;

import com.balansefit.dto.UserInfoDTO;
import com.balansefit.dto.UserWeightDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMyPageMapper {

    // 마이 페이지 사용자 정보
    List<UserInfoDTO> getSmallInfoList() throws Exception;

    // 프로필 리스트
    List<UserInfoDTO> getUserInfoList() throws Exception;

    // 프로필 글 수정
    void updateUserInfo(UserInfoDTO uDTO) throws Exception;

    // 일일 회원 몸무게 가져오기
    List<UserWeightDTO> getWeightList() throws Exception;
}
