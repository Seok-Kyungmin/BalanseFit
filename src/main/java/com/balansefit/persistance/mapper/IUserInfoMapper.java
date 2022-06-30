package com.balansefit.persistance.mapper;

import com.balansefit.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserInfoMapper {

    // 회원정보 불러오기
    //UserInfoDTO getUserInfo(UserInfoDTO uDTO) throws Exception;

    // 로그인 체크
    UserInfoDTO getUserLoginCheck(UserInfoDTO tDTO) throws Exception;

    //관리자 로그인
    UserInfoDTO getAdminLoginCheck(UserInfoDTO tDTO) throws Exception;

    // 회원가입 아이디 중복확인
    UserInfoDTO getUserExists(UserInfoDTO tDTO) throws Exception;

    // 회원가입 이메일 중복확인
    int getUserExists2(UserInfoDTO tDTO) throws Exception;
    //유저 회원가입
    int insertUser(UserInfoDTO tDTO) throws Exception;

//    // 비밀번호 찾기
//    String findPw(HttpServletResponse resp, UserInfoDTO tDTO) throws Exception;


}