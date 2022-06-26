//package com.balansefit.controller;
//
//import com.balansefit.dto.UserInfoDTO;
//import com.balansefit.service.IPWCService;
//import com.balansefit.util.CmmUtil;
//import com.balansefit.util.EncryptUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//@Slf4j
//@Controller("PWController")
//public class PWController {
//
//    @Resource(name = "PWCService")
//    private IPWCService PWCService;
//
//    @Resource(name = "EMailService")
//    private IEMailService emailService;
//
//    //임시 비밀번호 발급 페이지
//    @RequestMapping(value = "user/password")
//    public String password(){
//        log.info("비밀번호 찾기 페이지");
//        return "user/password";
//    }
//
//    @RequestMapping(value = "user/Search")
//    public String search(HttpServletRequest request, ModelMap model)throws Exception{
//
//        String id = request.getParameter("toMail");
//        log.info("웹 사이트에서 받아온 아이디값 : "+ id);
//
//        UserInfoDTO oDTO = new UserInfoDTO();
//        oDTO.getUser_id(id);
//        log.info("oDTO에 입력된 id : " + oDTO.getUser_id());
//
//        int res = PWCService.Search(oDTO);
//
//        String result = "";
//
//        if(res ==2){
//            result = "/mail/sendEMailResult";
//        }else if( res ==1 ){
//            result="/user/Return";
//        }else{
//            result = "ERRPR : 3064";
//        }
//
//        String toMail = CmmUtil.nvl(request.getParameter("toMail"));
//        log.info("SMTP로 보낼 메일 주소" + toMail);
//        String contents = RandomStringUtils.randomAlphanumeric(10);
//
//        MailDTO pDTO = new MailDTO();
//
//        pDTO.setToMail(toMail);
//        pDTO.setTitle("임시 비밀번호 입니다. ");
//        pDTO.setContents(contents+"\n 로그인 후 마이페이지에서 비밀번호를 변경해주세요");
//
//        log.info("SMTP로 보낼 임시 비밀번호 설정 로직 실행");
//        log.info("랜덤으로 생성된 임시 비밀번호 : " + contents);
//
//        UserInfoDTO wDTO = new UserInfoDTO();
//        wDTO.setUser_pw(EncryptUtil.encHashSHA256(contents));
//        wDTO.getUser_id(id);
//        log.info("wDTO에 들어간 임시 비밀번호 : " + wDTO.getUser_pw());
//
//        int res1 = PWCService.New(wDTO);
//
//        if(res1 == 0){
//            log.info("매퍼에서 sql문 에러 -> 비밀번호 변경 실패");
//        }else{
//            log.info("매버페어 sql문 성공 -> 비밀번호 변경 성공");
//        }
//
//        int res2 = emailService.doSendEMail(pDTO);
//
//        if(res2 == 1){
//            log.info("메일발송 성공");
//        }else{
//            log.info("메일발송 실패");
//        }
//
//        model.addAttribute("res", String.valueOf(res2));
//
//        return  result;
//
//    }
//}
