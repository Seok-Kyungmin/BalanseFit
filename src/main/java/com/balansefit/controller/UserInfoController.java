package com.balansefit.controller;

import com.balansefit.dto.UserInfoDTO;
import com.balansefit.service.IFoodService;
import com.balansefit.service.IUserInfoService;
import com.balansefit.util.CmmUtil;
import com.balansefit.util.EncryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class UserInfoController {

    @Resource(name = "UserInfoService")
    private IUserInfoService UserInfoService;

    @Resource(name = "FoodService")
    private IFoodService foodService;

    @GetMapping(value="/top")
    public  String top() throws Exception{

        log.info(this.getClass().getName()+ ".top ok");

        return "/login/top";
    }

    // 관리자 메인 페이지
    @GetMapping(value = "userIndex")
    public String userIndex() {

        return "/user/userIndex";

    }

    /*
     * 회원가입 화면으로 이동
     */
    @GetMapping(value="/regUser")
    public  String regUser() throws Exception{

        log.info(this.getClass().getName()+ ".signUp ok");

        return "/register/user";
    }

    /*
     * 회원가입 로직 처리
     */
    @PostMapping(value = "/regUser1")
    public String insertUser(HttpServletRequest request, ModelMap model) throws Exception {

        log.info(this.getClass().getName() + "UserController : 회원가입 시작");


        // 회원가입 결과에 대한 메시지 전달할 변수
        String msg = "";
        String url = "";
        //웹 회원가입결과에 대한 메시지를 전달할변수
        UserInfoDTO tDTO = null;

        try {
            //오류났던 이유 HttpServletRequest(여기 둘다 같아서 HttpServletRequest, HttpServletResponse 오른쪽에 있던걸로 써서 getParameter 빨간줄 뜸) request, HttpServletResponse response,
            String user_id = CmmUtil.nvl(request.getParameter("user_id"));
            String user_pw = CmmUtil.nvl(request.getParameter("user_pw"));
            String user_name = CmmUtil.nvl(request.getParameter("user_name"));
            String user_email = CmmUtil.nvl(request.getParameter("user_email"));
            String user_age = CmmUtil.nvl(request.getParameter("user_age"));
            String user_gender = CmmUtil.nvl(request.getParameter("user_gender"));
            String user_height = CmmUtil.nvl(request.getParameter("user_height"));
            String user_weight = CmmUtil.nvl(request.getParameter("user_weight"));

            log.info("user_id "+ user_id);
            log.info("user_name "+ user_name);
            log.info("user_email "+ user_email);
            log.info("user_pw "+ user_pw);
            log.info("user_age "+ user_age);
            log.info("user_gender "+ user_gender);
            log.info("user_height "+ user_height);
            log.info("user_weight "+ user_weight);

            tDTO = new UserInfoDTO();
            tDTO.setUser_id(user_id);
            tDTO.setUser_name(user_name);
            tDTO.setUser_age(user_age);
            tDTO.setUser_gender(user_gender);
            tDTO.setUser_pw(EncryptUtil.encHashSHA256(user_pw)); // 비밀번호 해시 알고리즘 암호화
            tDTO.setUser_email(EncryptUtil.encAES128CBC(user_email)); // 이메일 AES-128-CBC 암호화
            tDTO.setUser_height(user_height);
            tDTO.setUser_weight(user_weight);

            int res = UserInfoService.insertUser(tDTO);


            if (res == 1) {
                msg = "회원가입이 되었습니다.";
                url = "/loginPage";
            } else if(res == 2) {
                msg = "이미 가입된 ID입니다";
                url = "/regUser";
            }else {
                msg = "오류로 인해 회원가입이 실패했습니다.";
                url = "/regUser";
                System.out.println("오류로 회원가입이 실패했습니다");
            }

        } catch (Exception e) {
            // 저장이 실패되면 유저 보여줄 메시지
            msg = "회원가입에 실패하였습니다.";
            log.info(e.toString());
            e.printStackTrace();
        } finally {
            log.info(this.getClass().getName() + "UserController : 회원가입 끝");

            // 회원가입 여부 결과 메시지 전달하기
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            tDTO = null;

        }

        return "/redirect";

    }

    // 회원 로그인 페이지
    @GetMapping(value = "/loginPage")
    public  String userlogin() throws Exception{

        return "/login/userLogin";

    }

    // 회원 로그인페이지 로직
    @PostMapping(value = "/loginPage1")
    public  String loginPage(HttpServletRequest request, HttpSession session, ModelMap model)
            throws Exception {

        log.info(this.getClass().getName() + "UserController : 로그인페이지 시작");

        String msg = "";
        String url = "";
        String icon = "";
        int res = 0;

        UserInfoDTO tDTO = null;


        try {
            String user_id = CmmUtil.nvl(request.getParameter("user_id"));
            String user_pw = CmmUtil.nvl(request.getParameter("user_pw"));

            log.info("user_id : " + user_id);
            log.info("user_pw : " + user_pw);

            tDTO = new UserInfoDTO();
            tDTO.setUser_id(user_id);
            tDTO.setUser_pw(EncryptUtil.encHashSHA256(user_pw));

            res = UserInfoService.getUserLoginCheck(tDTO);
            session.setAttribute("SS_USER_ID", user_id);

            if (res == 1) {

                msg = "로그인 성공";
                url = "/userIndex";
                icon = "success";
                log.info("user_id : " + user_id);

            }else {
                msg = "로그인 실패!";
                url = "/loginPage";
                icon = "error";
            }
        } catch (Exception e) {
            res = 2;
            log.info(e.toString());
            e.printStackTrace();

        } finally {

            log.info(this.getClass().getName() + "UserController : 로그인페이지 끝!");
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            model.addAttribute("icon", icon);

            tDTO = null;

        }
        return  "/redirect";
        }

    @GetMapping(value = "/userlogout") // 로그아웃
    public String userLogout(HttpServletRequest request, ModelMap model) {
        log.info(this.getClass().getName() + ".user/userLogout start");
        HttpSession session = request.getSession();

        String url = "/loginPage";
        String msg = "로그아웃 성공";

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);
        return "/login/userLogin";
    }



    /*비밀번호 초기화 요청*/
//    @ResponseBody
//    @PostMapping(value = "/resetRequest")
//    public String resetRequest(HttpServletRequest request) throws Exception {
//        log.info("########"+this.getClass().getName()+ "resetRequest start");
//        String email = CmmUtil.nvl(request.getParameter("email"));
//
//        log.info("email :" + email);
//        UserInfoDTO tDTO = new UserInfoDTO();
//        tDTO.setUser_email(email);
//
//        int res = UserInfoService.getUserExists2(tDTO);
//
//
//        log.info(this.getClass().getName()+"resetRequest emailCheck 결과 : " + res);
//
//        /*email 링크 클릭 시 접속 주소*/
//        String Durl = "https://gros19.click/EmailAuthPWRestProc";
//
//        String result = "";
//
//        /*
//         * res -1 //email 미등록
//         * res -2 //email 미인증
//         * res  0 //server error
//         * res 1  //email 확인
//         * */
//        if (res==1){
//            log.info(this.getClass().getName()+"메일 전송 시작");
//            /*메일 전송*/
//            UserInfoService.sendAuthEmail(email, Durl);
//        }
//        result = String.valueOf(res);
//
//
//        log.info(this.getClass().getName()+"resetRequest ajax return 결과 : " + result);
//        log.info(this.getClass().getName()+"resetRequest end");
//        return result;
//    }
}

