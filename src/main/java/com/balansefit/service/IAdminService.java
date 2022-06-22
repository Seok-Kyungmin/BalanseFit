package com.balansefit.service;

import com.balansefit.dto.AdminInfoDTO;

public interface IAdminService {

    //관리자 로그인
    int getAdminLoginCheck(AdminInfoDTO tDTO) throws Exception;

    //회원가입
    int insertAdmin(AdminInfoDTO tDTO) throws Exception;
}
