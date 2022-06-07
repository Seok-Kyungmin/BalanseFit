package com.balansefit.service.impl;

import com.balansefit.dto.UserInfoDTO;
import com.balansefit.persistance.mapper.IUserInfoMapper;
import com.balansefit.service.IUserInfoService;
import com.balansefit.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("UserInfoService")
public class UserInfoService implements IUserInfoService {

    @Autowired
    private IUserInfoMapper userInfoMapper;

    @Override
    public UserInfoDTO getUserInfo(UserInfoDTO uDTO) throws Exception {
        return userInfoMapper.getUserInfo(uDTO);
    }

    @Override
    public int insertUserInfo(UserInfoDTO pDTO) throws Exception {

        // 회원가입 성공 : 1, 아이디 중복으로 인한 취소 : 2, 기타에러발생 :0
        int res;

        if (pDTO == null) {
            pDTO = new UserInfoDTO();
        }

        // 회원가입 중복 장지를 위해 DB에서 데이터 조회
        UserInfoDTO rDTO = userInfoMapper.getUserExists(pDTO);

        // mapper에서 값이 정상적으로 못 넘어오는 경우를 대비
        if (rDTO == null) {
            rDTO = new UserInfoDTO();
        }

        // 중복된 회원정보가 있는경우, 결과값을 2로 변경하고, 더 이상 작업 진행하지 않음
        if (CmmUtil.nvl(rDTO.getExists_yn()).equals("Y")) {
            res = 2;

        //회원가입이 중복이 아니므로, 회원가입 진행함
        } else {

            // 화원가입
            int success = userInfoMapper.insertUserInfo(pDTO);

            // db에 데이터가 등록되었다면(회언가입 성공했다면....
            if (success > 0) {
                res = 1;

                /*
                 * 메일 발송 로직 추가 시작!
                 */

            } else {
                res = 0;

            }

        }
        return res;
    }
    /**
     * 로그인을 위해 이메일과 비밀번호가 일치하는지 확인하기
     *
     * @param pDTO 로그인을 위한 회원 이메일, 비밀번호
     * @return UserInfoDTO 로그인된 회원아이디 정보
     */
    @Override
    public int getUserLoginCheck(UserInfoDTO pDTO) throws Exception{

        // 로그인 성공 : 1, 실패 : 0
        int res = 0;

        // 로그인을 위해 이메일과 비밀번호가 일치하는지 확인하기 위한 mapper 호출하기
        UserInfoDTO rDTO = userInfoMapper.getUserLoginCheck(pDTO);

        if (rDTO == null) {
            rDTO = new UserInfoDTO();
        }

        /*
         *  로그인 성공 여부 체크 시작!
         */
        if (CmmUtil.nvl(rDTO.getUser_email()).length()>0) {
            res = 1;
        }

        /*
         * 로그인 성공 여부체크 끝!
         */
        return res;
    }

    @Override
    public UserInfoDTO getUserDetail(UserInfoDTO uDTO) throws Exception {

        log.info(this.getClass().getName() + ".getUserDetail start!");

        return userInfoMapper.getUserDetail(uDTO);
    }

}
