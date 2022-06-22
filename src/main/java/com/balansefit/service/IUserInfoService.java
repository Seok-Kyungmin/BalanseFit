package com.balansefit.service;

import com.balansefit.dto.UserInfoDTO;

public interface IUserInfoService {

	// 회원정보 불러오기
	//UserInfoDTO getUserInfo(UserInfoDTO uDTO) throws Exception;

	// 회원 가입하기(회원정보 등록하기)

	//로그인
	int getUserLoginCheck(UserInfoDTO tDTO) throws Exception;

	int insertUser(UserInfoDTO tDTO) throws Exception;

	// 회원 프로필 조회
	//UserInfoDTO getUserDetail(UserInfoDTO uDTO) throws Exception;

	//UserInfoDTO idCheck(String userId) throws Exception;

}
