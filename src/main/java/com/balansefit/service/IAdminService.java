package com.balansefit.service;

import com.balansefit.dto.AdminInfoDTO;

public interface IAdminService {

    //로그인
    int AdminLoginCheck(AdminInfoDTO pDTO) throws Exception;

    //회원가입
    int insertAdmin(AdminInfoDTO pDTO) throws Exception;
}
