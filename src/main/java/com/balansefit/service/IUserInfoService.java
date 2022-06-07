package com.balansefit.service;

import com.balansefit.dto.UserInfoDTO;

public interface IUserInfoService {

	// 회원정보 불러오기
	UserInfoDTO getUserInfo(UserInfoDTO uDTO) throws Exception;

	// 회원 가입하기(회원정보 등록하기)
	int insertUserInfo(UserInfoDTO pDTO) throws Exception;

	// 로그인을 위해 이메일과 비밀번호가 일치하는지 확인하기
	int getUserLoginCheck(UserInfoDTO pDTO) throws Exception;

	// 회원 프로필 조회
	UserInfoDTO getUserDetail(UserInfoDTO uDTO) throws Exception;

//	int updateJoinStudy(Map<String, String> sMap) throws Exception;

//	int updateLeaveStudy(Map<String, String> pMap) throws Exception;

//	int updateUserMbti(UserInfoDTO pDTO) throws Exception;
//
//	List<String> getUserMbti(List<String> list) throws Exception;
//
//	UserInfoDTO getUserKakao(HashMap<String, String> pMap);
//
//	HashMap<String, Integer> getMbtiCount();

}
