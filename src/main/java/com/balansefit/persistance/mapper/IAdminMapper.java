package com.balansefit.persistance.mapper;

import com.balansefit.dto.AdminInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAdminMapper {

    //관리자 로그인
    AdminInfoDTO getAdminLoginCheck(AdminInfoDTO tDTO) throws Exception;

    // 회원가입 아이디 중복확인
    AdminInfoDTO getAdminExists(AdminInfoDTO tDTO) throws Exception;

    // 회원가입 이메일 중복확인
    AdminInfoDTO getAdminExists2(AdminInfoDTO tDTO) throws Exception;
    //유저 회원가입
    int insertAdmin(AdminInfoDTO tDTO) throws Exception;
}
