package com.balansefit.controller;

import com.balansefit.dto.UserInfoDTO;
import com.balansefit.service.IUserInfoService;
import com.balansefit.util.EncryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.balansefit.util.CmmUtil.nvl;

@Slf4j
@Controller
public class UserInfoController {

    @Resource(name = "UserInfoService")
    private IUserInfoService userInfoService;

    /*
     * 회원가입 화면으로 이동
     */
    @GetMapping(value="user/signup")
    public String signup(HttpServletRequest request, HttpSession session) {
        log.info(this.getClass().getClass().getName() +"user/signup start!!");

        return "user/Signup";
    }

    /*
     * 회원가입 로직 처리
     */
    @GetMapping(value="user/inserUserInfo")
    public String inserUserInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws Exception{

        log.info(this.getClass().getName()+ "inserUserInfo Start!!");

        // 회원가입 결과에 대한 메시지 전달할 변수
        String msg = "";
        String url = "";

        // 웹에서 받는 정보를 저장할 변수
        UserInfoDTO pDTO = null;

        try {

            /*
             웹(회원정보 입력화면)에서 받는 정보를 String 변수에 저장 시작!
             무조건 웹으로 받은 정보는 DTO에 저장하기 위해 임시로 String 변수에 저장함
             */
            String user_id = nvl(request.getParameter("user_id"));              // 아이디
            String user_name = nvl(request.getParameter("user_name"));          // 닉네임
            String user_email = nvl(request.getParameter("user_email"));        // 이메일
            String user_pw = nvl(request.getParameter("user_pw"));              // 비밀번호
            String user_age = nvl(request.getParameter("user_age"));            // 나이
            String user_gender = nvl(request.getParameter("user_gender"));      // 성별
            String user_height = nvl(request.getParameter("user_height"));      // 키
            String user_weight = nvl(request.getParameter("user_weight"));      // 몸무게

            log.info("user_id : " + user_id);
            log.info("user_email : " + user_email);
            log.info("user_pw : " + user_pw);
            log.info("user_age : " + user_age);
            log.info("user_gender : " + user_gender);
            log.info("user_height : " + user_height);
            log.info("user_weight : " + user_weight);

            // 웹(회원정보 입력화면)에서 받는 정보를 저장할 변수를 메모리에 올리기
            pDTO = new UserInfoDTO();

            pDTO.setUser_name(user_name);
            // 민감 정보인 이메일은 AES128-CBC로 암호화
            pDTO.setUser_email(EncryptUtil.encAES128CBC(user_email));

            // 비밀번호는 절대로 복호화 되지않도록 해시 알고리즘으로 암호화
            pDTO.setUser_pw(EncryptUtil.encHashSHa256(user_pw));
            pDTO.setUser_age(Integer.valueOf(user_age));
            pDTO.setUser_gender(user_gender);
            pDTO.setUser_height(Integer.valueOf(user_height));
            pDTO.setUser_weight(Integer.valueOf(user_weight));


            /*
             * 회원가입
             */
            int res = userInfoService.insertUserInfo(pDTO);

            if (res == 1) {
                msg = "회원가입이 되었습니다.";
                url = "/user/login";
            } else if (res == 2) {
                msg = "이미 가입된 이메일 주소 입니다.";
            } else {
                msg = "오류로 인해  회원가입이 실패 하였습니다.";
                url = "/user/signup.do";
            }
        } catch(Exception e) {
            // 저장이 실패되면 사용자에세 보여줄 메시지
            msg = "실패하였습니다. : " + e.toString();
            log.info(e.toString());
            e.printStackTrace();

        } finally {
            log.info(this.getClass().getName()+ "inserUserInfo End!!");

            // 회원가입 여부 결과 메시지 전달하기
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);

            // 회원가입 여부 결과 메시지 전달하기
            model.addAttribute("pDTO", pDTO);

            // 변수 초기화
            pDTO = null;
        }

        return "/user/Msg";
    }

    // 로그인
    @GetMapping(value="user/login")
    public String login(HttpServletRequest request, HttpSession session) {
        log.info(this.getClass().getClass().getName() +"user/login start!!");
        session.invalidate();

        return "user/Login";
    }

    @RequestMapping(value="user/loginProc", method = RequestMethod.GET)
    public String loginProc(HttpServletRequest request, HttpSession session, ModelMap model)
            throws Exception {

        log.info("user/loginProc Start!!");
        String user_email = nvl(request.getParameter("user_email"));
        String user_pw = nvl(request.getParameter("user_pw"));

        log.info("user_email : " + user_email);
        log.info("user_pw : " + user_pw);

        UserInfoDTO uDTO = new UserInfoDTO();

        uDTO.setUser_email(user_email);
        uDTO.setUser_pw(user_pw);

        UserInfoDTO rDTO = new UserInfoDTO();
        rDTO = userInfoService.getUserInfo(uDTO);

        String msg = "";
        String url = "";
        if(rDTO == null) {
            log.info("rDTO == null?"+(rDTO==null));
            msg = "아이디 비밀번호를 확인해주세요";
            url = "/user/login.do";
        }else {
            log.info("데이터 조회완료");

            session.setAttribute("user_email", rDTO.getUser_email());
            session.setAttribute("user_pw", rDTO.getUser_pw());

            msg = "환영합니다.";
            url = "/spoilbroth/mystudy.do";

        }
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);
        log.info("user/loginproc End!!");
        return "/redirect";
    }

    @RequestMapping(value="/user/logOut")
    public String logOut(HttpSession session, ModelMap model) throws Exception{
        log.info(this.getClass().getName() + "user/logOut start!!");

        String msg ="";
        String url ="";

        msg = "로그아웃 성공";

        session.invalidate();
        url ="/user/login.do";

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);


        log.info(this.getClass().getName() + "user/logOut end!!");
        return "/redirect";
    }

    @ResponseBody
    @GetMapping(value = "/gopage")
    public  String USer() throws Exception{
        String ok = "OK";
        log.info(ok);

        return ok;
    }

    /**
     * 로그인 처리 및
     */


}

