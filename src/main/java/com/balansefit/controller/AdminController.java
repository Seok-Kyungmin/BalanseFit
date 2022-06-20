package com.balansefit.controller;

import com.balansefit.dto.AdminInfoDTO;
import com.balansefit.service.IAdminService;
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
public class AdminController {

    @Resource(name = "AdminService")
    private IAdminService AdminService;

    // 메인 페이지
    @GetMapping(value = "adminIndex")
    public String adminIndex() {

        return "/admin/adminIndex";

    }

    //로그인 페이지
    @GetMapping(value = "/adminLoginPage")
    public String adminLogin() throws Exception{

        return "/login/adminLogin";

    }


    //로그인페이지 로직
    @PostMapping(value = "/adminLoginPage1")
    public  String adminLoginPage(HttpServletRequest request, HttpSession session, ModelMap model)
            throws Exception {

        log.info(this.getClass().getName() + "AdminController : 로그인페이지 시작");

        String msg = "";
        String url = "";
        String icon = "";
        int res = 0;

        AdminInfoDTO pDTO = null;


        try {
            String adm_id = CmmUtil.nvl(request.getParameter("adm_id"));
            String adm_pw = CmmUtil.nvl(request.getParameter("adm_pw"));

            log.info("adm_id : " + adm_id);
            log.info("adm_pw : " + adm_pw);

            pDTO = new AdminInfoDTO();
            pDTO.setAdm_id(adm_id);
            pDTO.setAdm_pw(EncryptUtil.encHashSHA256(adm_pw));

            res = AdminService.AdminLoginCheck(pDTO);
            session.setAttribute("SS_Adm_ID", adm_id);

            if (res == 1) {
                msg = "로그인 성공";
                url = "/adminIndex";
                icon = "success";
                log.info("adm_id : " + adm_id);

            }else {
                msg = "로그인 실패!";
                url = "/adminLoginPage";
                icon = "error";
            }
        } catch (Exception e) {
            res = 2;
            log.info(e.toString());
            e.printStackTrace();

        } finally {

            log.info(this.getClass().getName() + "AdminController : 로그인페이지 끝!");
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            model.addAttribute("icon", icon);

            pDTO = null;

        }
        return  "/redirect";
    }

    @GetMapping(value = "/adminLogout") // 로그아웃
    public String userLogout(HttpServletRequest request, ModelMap model) {
        log.info(this.getClass().getName() + ".admin/adminLogout start");
        HttpSession session = request.getSession();

        String url = "/adminIndex";
        String msg = "로그아웃 성공";

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);
        return "/admin/adminIndex";
    }

    //회원가입페이지
    @GetMapping(value = "/regAdmin")
    public  String regAdmin() throws Exception{
        log.info("회원가입 페이지 시작!");

        log.info("회원가입 페이지 끝");

        return "/register/admin";

    }

    //회원가입 로직 시작
    @PostMapping(value = "/regAdmin1")
    public String insertAdmin(HttpServletRequest request, ModelMap model) throws Exception {

        log.info(this.getClass().getName() + "AdminController : 회원가입 시작");


        // 회원가입 결과에 대한 메시지 전달할 변수
        String msg = "";
        String url = "";
        String icon = "";
        String contents = "";
        //웹 회원가입결과에 대한 메시지를 전달할변수
        AdminInfoDTO pDTO = null;

        try {

            String adm_id = CmmUtil.nvl(request.getParameter("adm_id")); //회원아이디
            String adm_pw = CmmUtil.nvl(request.getParameter("adm_pw")); // 비밀번호
            String adm_name = CmmUtil.nvl(request.getParameter("adm_name"));  //회원이름
            String adm_email = CmmUtil.nvl(request.getParameter("adm_email"));  //이메일


            log.info("adm_id :" + adm_id);
            log.info("adm_pw :" + adm_pw);
            log.info("adm_name :" + adm_name);
            log.info("adm_email :" + adm_email);

            //유저 정보를 담기위함
            pDTO = new AdminInfoDTO();

            pDTO.setAdm_id(adm_id);
            pDTO.setAdm_pw(EncryptUtil.encHashSHA256(adm_pw)); // 비밀번호 해시 알고리즘 암호화
            pDTO.setAdm_name(adm_name);
            pDTO.setAdm_email(EncryptUtil.encAES128CBC(adm_email)); // 이메일 AES-128-CBC 암호화

            int res = AdminService.insertAdmin(pDTO);


            if (res == 1) {
                msg = "회원가입이 되었습니다.";
                url = "/adminLoginPage";
                icon = "success";
                contents = "회원가입을 축하드립니다";
            } else if(res == 2) {
                msg = "이미 가입된 ID입니다";
                url = "/regAdmin";
                icon = "warning";
                contents = "이미 가입된 ID입니다";
            }else {
                msg = "오류로 인해 회원가입이 실패했습니다.";
                url = "/regAdmin";
                icon = "warning";
                System.out.println("오류로 회원가입이 실패했습니다");
            }

        } catch (Exception e) {
            // 저장이 실패되면 유저 보여줄 메시지
            msg = "회원가입에 실패하였습니다.";
            log.info(e.toString());
            e.printStackTrace();
        } finally {
            log.info(this.getClass().getName() + "AdminController : 회원가입 끝");

            // 회원가입 여부 결과 메시지 전달하기
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            model.addAttribute("icon",icon);
            model.addAttribute("contents", contents);

            pDTO = null;
        }
        return "/redirect";
    }

}
