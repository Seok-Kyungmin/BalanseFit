package com.balansefit.service.impl;

import com.balansefit.dto.AdminInfoDTO;
import com.balansefit.persistance.mapper.IAdminMapper;
import com.balansefit.service.IAdminService;
import com.balansefit.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service("AdminService")
public class AdminService implements IAdminService {

    @Resource(name = "IAdminMapper")
    private IAdminMapper AdminMapper;

    //로그인
    @Override
    public int AdminLoginCheck(AdminInfoDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + "AdminService : AdminLogin 시작");

        int res = 0;

        AdminInfoDTO rDTO = AdminMapper.getAdminLogin(pDTO);

        if(rDTO == null) {
            log.info(this.getClass().getName() + "로그인 실패");
            res = 0;
        }else {
            log.info(this.getClass().getName() + "로그인 성공");
            res = 1;
        }

        log.info(this.getClass().getName() + "AdminService : AdminLogin 끝");


        return res;
    }

    //회원가입
    @Override
    public int insertAdmin(AdminInfoDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + "AdminService : insertAdmin 시작");


        //회원가입 성공 :1 ,아이디 중복 : 2, 에러 : 0
        int res = 0;

        if(pDTO == null) {
            pDTO = new AdminInfoDTO();

        }
        AdminInfoDTO rDTO = AdminMapper.getAdminExists(pDTO);
        log.info("중복체크");

        if(rDTO == null) {
            rDTO = new AdminInfoDTO();

        }

        if(CmmUtil.nvl(rDTO.getExists_yn()).equals("Y")){
            //아이디 중복이므로 회원가입 x
            res = 2;

        }else {
            int success = AdminMapper.insertAdmin(pDTO);

            if(success > 0){

                res = 1;
            }else {
                res = 0;
            }
        }
        return res;
    }

}

