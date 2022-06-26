package com.balansefit.service.impl;

import com.balansefit.dto.UserInfoDTO;
import com.balansefit.persistance.mapper.IUserInfoMapper;
import com.balansefit.service.IUserInfoService;
import com.balansefit.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Service("UserInfoService")
public class UserInfoService implements IUserInfoService {

    @Resource(name = "IUserInfoMapper")
    private IUserInfoMapper UserInfoMapper;

//    @Override
//    public UserInfoDTO getUserInfo(UserInfoDTO uDTO) throws Exception {
//
//        return userInfoMapper.getUserInfo(uDTO);
//    }


    //회원가입
    @Override
    public int insertUser(UserInfoDTO pDTO) throws Exception{

        log.info(this.getClass().getName() + "UserService : insertUser 시작!");

        //회원가입 성공 : 1, 아이디 중복 : 2, 에러 : 0
        int res = 0;

        if (pDTO == null) {
            pDTO = new UserInfoDTO();
        }

        UserInfoDTO rDTO = UserInfoMapper.getUserExists(pDTO);
        log.info("중복체크");

        if(rDTO == null){
            rDTO = new UserInfoDTO();
        }

        log.info("rDTO.getExists_yn()).equals(\"Y\") :  " + rDTO.getExists_yn());
        if(CmmUtil.nvl(rDTO.getExists_yn()).equals("Y")){
            //아이디 중복이므로 회원가입 x
            res = 2;

        }else {
            int success = UserInfoMapper.insertUser(pDTO);

            if(success > 0){

                res = 1;
            }
            else {
                res = 0;
            }
        }
        return res;
    }

    //로그인 체크
    @Override
    public int getUserLoginCheck(UserInfoDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + "UserService : getUserLoginCheck 시작");
        //성공: 1  실패: 0
        int res = 0;

        UserInfoDTO rDTO = UserInfoMapper.getUserLoginCheck(pDTO);

        if(rDTO == null) {
            log.info(this.getClass().getName() + "로그인 실패");
            res = 0;
        }else {
            log.info(this.getClass().getName() + "로그인 성공");
            res = 1;
        }

        log.info(this.getClass().getName() + "UserService : getUserLoginCheck 끝");

        return res;
    }

    // 아이디 확인
//    @Override
//    public UserInfoDTO idCheck(String userId) throws Exception {
//
//        return userInfoMapper.idCheck(userId);
//    }
//
//    @Override
//    public UserInfoDTO getUserDetail(UserInfoDTO uDTO) throws Exception {
//
//        log.info(this.getClass().getName() + ".getUserDetail start!");
//
//        return userInfoMapper.getUserDetail(uDTO);
//    }

    //비밀번호 찾기 이메일발송
    public String findPw(HttpServletResponse resp, UserInfoDTO tDTO) throws Exception{

        HtmlEmail email1 = new HtmlEmail();
        email1.setHostName("smtp.naver.com");
        email1.setSmtpPort(465);
        email1.setAuthentication("본인네이버이메일", "네이버 비밀번호");

        email1.setSSLOnConnect(true);
        email1.setStartTLSEnabled(true);

        int res = 0;
        return "";

    }

    @Override
    public int getUserExists2(UserInfoDTO tDTO) throws Exception {

        int res = UserInfoMapper.getUserExists2(tDTO);
        return res;
    }


    public int sendAuthEmail(String email, String url) throws InvalidAlgorithmParameterException, UnsupportedEncodingException,
            NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        log.info(this.getClass().getName()+ "메일 전송 시작");

        HtmlEmail email1 = new HtmlEmail();
        email1.setHostName("smtp.naver.com");
        email1.setSmtpPort(465);
        email1.setAuthentication("sukm386@naver.com", "sukm0219*");

        email1.setSSLOnConnect(true);
        email1.setStartTLSEnabled(true);

        int res = 0;





        try{
            email1.setFrom("sukm386@naver.com", "BalanceFit manager", "utf-8");
            email1.addTo(email, "BalanceFit", "utf-8");
            email1.setSubject("authentication");

            StringBuffer msg = new StringBuffer();

            msg.append("<p>I'm BalanceFit manager.</p>");
            msg.append("<p>you can certify</p>");
            msg.append("<a href='" + url +"?email="+ email + "'>plz click this link</a>");


            email1.setHtmlMsg(msg.toString());
            email1.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }


        log.info(this.getClass().getName()+ "메일 전송 완료");

        return 0;
    }}