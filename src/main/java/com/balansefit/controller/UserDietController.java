package com.balansefit.controller;

import com.balansefit.dto.UserDietDTO;
import com.balansefit.service.IUserDietService;
import com.balansefit.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class UserDietController {

    @Resource(name = "UserDietService")
    private IUserDietService userDietService;

    // 유저 식단 정보 리스트 띄우기
    @GetMapping(value = "diet/UDietList")
    public String DietList(ModelMap model) throws Exception {

        log.info(this.getClass().getName() + ".UDietList 시작!");

        // 식단 리스트 가져오기
        List<UserDietDTO> dList = userDietService.getUserDietList();

        if (dList == null) {
            dList = new ArrayList<>();
        }

        // 조회된 리스트 결과값 보여주기
        model.addAttribute("dList", dList);

        log.info(this.getClass().getName() + ".UDietList 끝!");

        return "/diet/UDietList";

    }

    // 식단 작성 페이지 이동
    @GetMapping(value = "diet/UDietReg")
    public String FoodReg() {

        log.info(this.getClass().getName() + ".UDietReg 시작!");

        log.info(this.getClass().getName() + ".UDietReg 끝!");

        return "/diet/UDietReg";
    }

    // 식단 등록
    @PostMapping(value = "diet/UDietInsert")
    public String FoodInsert(HttpSession session, HttpServletRequest request, ModelMap model) {

        log.info(this.getClass().getName() + ".UDietInsert 시작!");

        String msg = "";

        try {
            String user_id = CmmUtil.nvl((String) session.getAttribute("SESSION_USER_ID"));
            String diet_name = CmmUtil.nvl(request.getParameter("diet_name"));
            String food_name = CmmUtil.nvl(request.getParameter("food_name"));
            String food_number = CmmUtil.nvl(request.getParameter("food_number"));
            String diet_calories = CmmUtil.nvl(request.getParameter("diet_calories"));

            log.info("user_id : "+ user_id);
            log.info("diet_name : " + diet_name);
            log.info("food_name : " + food_name);
            log.info("food_number : " + food_number);
            log.info("diet_calories : " + diet_calories);

            UserDietDTO dDTO = new UserDietDTO();

            dDTO.setUser_id(user_id);
            dDTO.setDiet_name(diet_name);
            dDTO.setFood_name(food_name);
            dDTO.setFood_number(food_number);
            dDTO.setDiet_calories(diet_calories);

            userDietService.insertUserDietInfo(dDTO);

            msg = "등록되었습니다";

        }catch (Exception d) {
            msg = "실패했습니다 :" + d.getMessage();
            log.info(d.toString());
            d.printStackTrace();

        }finally {
            log.info(this.getClass().getName() + ".UDietInsert 끝!");

            // 결과메시지 전달하기
            model.addAttribute("msg",msg);

        }
        return "/redirect";
    }

    // 식단 상세보기
    @GetMapping(value = "diet/UDietInfo")
    public String FoodInfo(HttpServletRequest request, ModelMap model) {

        log.info(this.getClass().getName() + ".UDietInfo start!");

        String msg = "";

        try {
            String dSeq = CmmUtil.nvl(request.getParameter("dSeq"));

            log.info("dSeq : " + dSeq);

            UserDietDTO dDTO = new UserDietDTO();
            dDTO.setDiet_seq(dSeq);

            // 상세정보 가져오기
            UserDietDTO rDTO = userDietService.getUserDietInfo(dDTO);

            if (rDTO == null) {
                rDTO = new UserDietDTO();
            }

            log.info("getUDietInfo success!!");

            // 조회된 리스트 결과값 넣어주기
            model.addAttribute("rDTO", rDTO);

        } catch (Exception d) {

            msg= "실패하였습니다 : " + d.getMessage();
            log.info(d.toString());
            d.printStackTrace();

        }finally {

            log.info(this.getClass().getName() + ".UDietInsert end!");

            // 결과 메시지 전달
            model.addAttribute("msg", msg);

        }
        log.info(this.getClass().getName() + ".UDietInfo end!");

        return "/diet/UDietInfo";
    }

    /**
     * 게시판 글 삭제
     */
    @GetMapping(value = "/diet/UDietDelete")
    public String FoodDelete(HttpServletRequest request, ModelMap model) {

        log.info(this.getClass().getName()+".UDietDelete start!");

        String msg = "";
        String url = "";

        try {

            String dSeq = CmmUtil.nvl(request.getParameter("dSeq"));

            log.info("dSeq : " + dSeq);

            UserDietDTO dDTO = new UserDietDTO();

            dDTO.setUser_id(dSeq);

            //게시글 삭제하기 DB
            userDietService.deleteUserDietInfo(dDTO);

            msg = "삭제되었습니다";
            url = "/diet/UDietList";

        } catch (Exception d) {
            msg = "실패하였습니다 : " + d.getMessage();
            url = "/diet/UDietList";
            log.info(d.toString());
            d.printStackTrace();

        } finally {
            log.info(this.getClass().getName()+".UDietDelete end!");

            //결과 메시지 전달하기
            model.addAttribute("msg",msg);
            model.addAttribute("url", url);

        }
        return "/redirect";
    }

//    // 음식 검색
//    @GetMapping(value = "/getSearchList")
//    @ResponseBody


}
