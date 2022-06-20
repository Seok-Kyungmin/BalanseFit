package com.balansefit.controller;

import com.balansefit.dto.UserInfoDTO;
import com.balansefit.dto.UserWeightDTO;
import com.balansefit.persistance.mapper.IMyPageMapper;
import com.balansefit.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MyPageController {

    @Resource(name = "UserInfoService")
    private IUserInfoService userInfoService;
    private IMyPageMapper myPageService;

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
    public String getWeightList(ModelMap model) throws Exception{

        log.info(this.getClass().getName()+".WeightGraph start!");

        // 리스트 가져오기
        List<UserWeightDTO> wList = myPageService.getWeightList();

        if (wList == null) {
            wList = new ArrayList<>();

        }

        //조회된 리스트 결과값 보여주기
        model.addAttribute("wList", wList);

        log.info(this.getClass().getName()+".WeightGraph end!");

        return "/mypage/WeightGraph";
    }
}
