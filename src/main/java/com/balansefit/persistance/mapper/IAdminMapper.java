package com.balansefit.persistance.mapper;

import com.balansefit.dto.AdminInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAdminMapper {

    //회원가입 중복확인
    AdminInfoDTO getAdminExists(AdminInfoDTO pDTO) throws Exception;

    AdminInfoDTO getAdminLogin(AdminInfoDTO pDTO) throws Exception;
    //판매자 회원가입
    int insertAdmin(AdminInfoDTO pDTO) throws Exception;
}
