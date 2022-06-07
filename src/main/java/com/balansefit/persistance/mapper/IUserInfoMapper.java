package com.balansefit.persistance.mapper;

import com.balansefit.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserInfoMapper {

    // 회원정보 불러오기
    UserInfoDTO getUserInfo(UserInfoDTO uDTO) throws Exception;

    //회원 가입하기(회원정보 등록하기)
    int insertUserInfo(UserInfoDTO pDTO) throws Exception;

    // 회원 가입 전 중복체크하기(DB 조회하기)
    UserInfoDTO getUserExists(UserInfoDTO pDTO) throws Exception;

    // 로그인을 위해 아이디와 비밀번호가 일치하는지 확인하기
    UserInfoDTO getUserLoginCheck(UserInfoDTO pDTO) throws Exception;

    // 회원 프로필 조회
    UserInfoDTO getUserDetail(UserInfoDTO uDTO) throws Exception;

    // 1일 적정량 계산
    //UserInfoDTO sumUserRC(UserInfoDTO uDTO) throws Exception;


}