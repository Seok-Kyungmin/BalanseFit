package com.balansefit.controller;

import com.balansefit.dto.DietDTO;
import com.balansefit.service.IDietService;
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
public class DietController {

    @Resource(name = "DietService")
    private IDietService dietService;

    /**
     * 식단 리스트 보여주기
     */
    @GetMapping(value = "admin/DietList")
    public String DietList(ModelMap model) throws Exception{

        log.info(this.getClass().getName()+".DietList start!");

        // 식단 리스트 가져오기
        List<DietDTO> dList = dietService.getDietList();

        if (dList == null) {
            dList = new ArrayList<>();
        }

        // 조회된 결과값 가져오기
        model.addAttribute("dList", dList);

        log.info(this.getClass().getName()+".DietList end!");

        return "/admin/Diet";

    }

    /**
     * 식단정보 작성 페이지 이동
     */
    @GetMapping(value = "admin/DietReg")
    public String DietReg() {
        log.info(this.getClass().getName()+".DietReg start!");
        log.info(this.getClass().getName()+".DietReg end!");

        return "/admin/DietReg";
    }

    /**
     * 식단 추가
     */
    @PostMapping(value = "admin/DietInsert")
    public String DietInsert(HttpSession session, HttpServletRequest request, ModelMap model) {

        log.info(this.getClass().getName()+".DietInsert start!");

        String msg = "";
        String url = "";

        try{
            // 식단 추가하기 위해 사용되는 from객체의 하위 input 객체 등을 받아오기 위해 사용함
            String diet_name = CmmUtil.nvl(request.getParameter("diet_name")); // 식단 이름
            String food_name = CmmUtil.nvl(request.getParameter("food_name")); // 식단 음식 이름
            String food_number = CmmUtil.nvl(request.getParameter("food_number")); // 식단 음식 이름
            String diet_calories = CmmUtil.nvl(request.getParameter("diet_calories")); // 식단 음식 이름

            // 반드시, 값을 받았으면, 꼭 로그를 찍어서 값이 제대로 들어오는지 파악해야함 반드시 작성할 것
            log.info("diet_name : " + diet_name);
            log.info("food_name : " + food_name);
            log.info("food_number : " + food_number);
            log.info("diet_calories : " + diet_calories);

            DietDTO dDTO = new DietDTO();

            dDTO.setDiet_name(diet_name);
            dDTO.setFood_name(food_name);
            dDTO.setFood_number(food_number);
            dDTO.setDiet_calories(diet_calories);

            // 정보 추가하기 위한 비즈니스 로직을 호출
            dietService.insertDietInfo(dDTO);

            msg = "추가되었습니다!";
            url = "/admin/DietList";

        } catch (Exception d) {

            // 저장이 실패되면 사용자에게 보여줄 메시지
            msg = "실패하였습니다 : " + d.getMessage();
            url = "/admin/DietList";
            log.info(d.toString());
            d.printStackTrace();

        } finally {
            log.info(this.getClass().getName() + ".DietInsert end!");

            // 결과 메시지 전달하기
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);

        }
        return "/redirect";
    }

    /**
     * 게시판 상세보기
     */
    @GetMapping(value = "admin/DietInfo")
    public String DietInfo(HttpServletRequest request, ModelMap model) {

        log.info(this.getClass().getName()+".DietInfo start!");

        String msg = "";

        try {
            String dSeq = CmmUtil.nvl(request.getParameter("dSeq")); // 식단 번호

            log.info("dSeq : " + dSeq);

            DietDTO dDTO = new DietDTO();
            dDTO.setDiet_seq(dSeq);

            // 식단 상세정보 가져오기
            DietDTO rDTO  = dietService.getDietInfo(dDTO);

            if (rDTO == null) {
                rDTO = new DietDTO();

            }

            log.info("getDietInfo success!!!");

            model.addAttribute("rDTO", rDTO);

        } catch (Exception d) {
            msg = "실패하였습니다. :" + d.getMessage();
            log.info(d.toString());
            d.printStackTrace();

        } finally {
            log.info(this.getClass().getName() + ".DietInsert end!");

            // 결과 메시지 전달하기
            model.addAttribute("msg", msg);

        }

        log.info(this.getClass().getName() + ".DietInfo end!");

        return "/admin/DietInfo";
    }

    /**
     * 게시판 글 수정
     */
    @PostMapping(value = "admin/DietUpdate")
    public String DietUpdate(HttpSession session, HttpServletRequest request, ModelMap model) {

        log.info(this.getClass().getName()+".DietUpdate start!");

        String msg = "";
        String url = "";

        try{

            String diet_seq = CmmUtil.nvl(request.getParameter("diet_seq"));
            String diet_name = CmmUtil.nvl(request.getParameter("diet_name")); // 식단 이름
            String food_name = CmmUtil.nvl(request.getParameter("food_name")); // 식단 음식 이름
            String food_number = CmmUtil.nvl(request.getParameter("food_number")); // 식단 음식 이름
            String diet_calories = CmmUtil.nvl(request.getParameter("diet_calories")); // 식단 음식 이름

            // 반드시, 값을 받았으면, 꼭 로그를 찍어서 값이 제대로 들어오는지 파악해야함 반드시 작성할 것
            log.info("diet_seq : " + diet_seq);
            log.info("diet_name : " + diet_name);
            log.info("food_name : " + food_name);
            log.info("food_number : " + food_number);
            log.info("diet_calories : " + diet_calories);

            DietDTO dDTO = new DietDTO();

            dDTO.setDiet_seq(diet_seq);
            dDTO.setDiet_name(diet_name);
            dDTO.setFood_name(food_name);
            dDTO.setFood_number(food_number);
            dDTO.setDiet_calories(diet_calories);

            //게시글 수정하기 DB
            dietService.updateDietInfo(dDTO);

            msg = "수정되었습니다.";
            url = "/admin/DietList";

        } catch (Exception d) {
            msg = "실패하였습니다 : " + d.getMessage();
            url = "/admin/DietList";
            log.info(d.toString());
            d.printStackTrace();

        } finally {
            log.info(this.getClass().getName()+".DietUpdate end!");

            // 결과 메시지 전달하기
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);

        }
        return "/redirect";
    }
    /**
     * 게시판 글 삭제
     */
    @GetMapping(value = "admin/DietDelete")
    public String DietDelete(HttpServletRequest request, ModelMap model) {

        log.info(this.getClass().getName()+".DietDelete start!");

        String msg = "";
        String url = "";

        try {
            String dSeq = CmmUtil.nvl(request.getParameter("dSeq"));

            log.info("dSeq : " + dSeq);

            DietDTO dDTO = new DietDTO();

            dDTO.setDiet_seq(dSeq);

            //게시글 삭제하기 DB
            dietService.deleteDietInfo(dDTO);

            msg = "삭제되었습니다";
            url = "/admin/DietList";

        } catch (Exception d) {
            msg = "실패하였습니다 : " + d.getMessage();
            url = "/admin/DietList";
            log.info(d.toString());
            d.printStackTrace();

        } finally {
            log.info(this.getClass().getName()+".DietDelete end!");

            //결과 메시지 전달하기
            model.addAttribute("msg",msg);
            model.addAttribute("url", url);

        }
        return "/redirect";
    }


}
