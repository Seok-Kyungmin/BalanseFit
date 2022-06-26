package com.balansefit.controller;

import com.balansefit.dto.UserInfoDTO;
import com.balansefit.service.IMyPageService;
import com.balansefit.service.IUserInfoService;
import com.balansefit.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MyPageController {

    @Resource(name = "UserInfoService")
    private IUserInfoService userInfoService;


    @Resource(name = "MyPageService")
    private IMyPageService myPageService;

    @GetMapping(value = "CaloricCalculator")
    public String CaloricCalculator() {
        log.info(this.getClass().getName()+ "CaloricCalculator 시작!!");
        return "/mypage/CaloricCalculator";
    }

    @GetMapping(value = "mypage")
    public String mypage(ModelMap model) throws Exception{

        log.info(this.getClass().getName()+ "mypage 시작!!");

        // 정보 리스트 가져오기
        List<UserInfoDTO> mList = myPageService.getSmallInfoList();

        if (mList == null) {
            mList = new ArrayList<>();

        }

        // 조회된 리스트 결과값 넣어주기
        model.addAttribute("mList", mList);

        log.info(this.getClass().getName()+ "mypage 끝!!");

        return "/mypage/mypage";
    }

    @RequestMapping(value = "/setting")
    public String setting(ModelMap model) throws Exception{
        log.info(this.getClass().getName()+ "setting 시작!!");

        // 정보 리스트 가져오기
        List<UserInfoDTO> uList = myPageService.getUserInfoList();

        if (uList == null) {
            uList = new ArrayList<>();

        }

        // 조회된 리스트 결과값 넣어주기
        model.addAttribute("uList", uList);

        log.info(this.getClass().getName()+ "setting 끝!!");

        return "/mypage/setting";
    }

    @GetMapping(value = "/WeightGraph")
    public String getWeightList(HttpServletRequest request, ModelMap model) throws Exception{

        log.info(this.getClass().getName()+".WeightGraph start!");

        // 웨이트디티오에 세션아이디를 넣고, 그 디티오를 파라미터로 넣는다
        String msg = "";

        try{

            /*r관리자 페이지 연결 요함*/
            String session_id = CmmUtil.nvl(request.getParameter("SESSION_USER_ID"));

            session_id ="qwe";


            log.info("uId : " + session_id);

//            UserWeightDTO pDTO = new UserWeightDTO();
//            pDTO.setUser_id(session_id);
//
//            List<UserWeightDTO> rlist = myPageService.getWeightList(pDTO);
//
//            if (rlist == null) {
//                rlist = new ArrayList<>();
//            }
//
//
//            //조회된 리스트 결과값 보여주기
//            model.addAttribute("rlist", rlist);
//
//            for(UserWeightDTO w : rlist){
//                log.info("w.getCurrent_w(): "+w.getCurrent_w());
//            }


            log.info("getWeightList success!!");
        }catch (Exception e){
            e.printStackTrace();
        }

        log.info(this.getClass().getName()+".WeightGraph end!");

        return "/mypage/WeightGraph";
    }
}
