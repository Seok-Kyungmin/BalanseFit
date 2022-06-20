package com.balansefit.controller;

import com.balansefit.dto.FoodDTO;
import com.balansefit.service.IFoodService;
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
public class FoodController {

    @Resource(name = "FoodService")
    private IFoodService foodService;

    @GetMapping(value = "admin/FoodList")
    public String FoodList(ModelMap model) throws Exception {

        log.info(this.getClass().getName()+ ".FoodList start!");

        // 식품 리스트 가져오기
        List<FoodDTO> rList = foodService.getFoodList();

        if (rList == null) {
            rList = new ArrayList<>();
        }

        // 조회된 리스트 결과값 넣어주기
        model.addAttribute("rList", rList);

        log.info(this.getClass().getName()+ ".FoodList end!");

        return "/adminFood/Food";
    }

    /**
     * 게시판 글 작성
     */
    @GetMapping(value = "admin/FoodReg")
    public String FoodReg() {

        log.info(this.getClass().getName()+ ".FoodList start!");
        log.info(this.getClass().getName()+ ".FoodList end!");

        return "/adminFood/FoodReq";
    }

    /**
     * 게시판 글 등록
     */
    @PostMapping(value = "admin/FoodInsert")
    public String FoodInsert(HttpSession session, HttpServletRequest request, ModelMap model) {

        log.info(this.getClass().getName()+".FoodInsert start!");

        String msg = "";
        String url = "";

        try{
            // 운동 정보 추가하기 위해 사용되는 from객체의 하위 input 객체 등을 받아오기 위해 사용함
            String user_id = CmmUtil.nvl((String) session.getAttribute("SESSION_USER_ID"));
            String food_name = CmmUtil.nvl(request.getParameter("food_name")); // 음식명
            String food_calories = CmmUtil.nvl(request.getParameter("food_calories")); // 칼로리
            String food_carbohydrate = CmmUtil.nvl(request.getParameter("food_carbohydrate")); // 탄수화물
            String food_protein = CmmUtil.nvl(request.getParameter("food_protein")); // 단백질
            String food_fat = CmmUtil.nvl(request.getParameter("food_fat")); // 지방
            String food_sugar = CmmUtil.nvl(request.getParameter("food_sugar")); // 당
            String food_natrium = CmmUtil.nvl(request.getParameter("food_natrium")); // 나트륨
            String food_weight = CmmUtil.nvl(request.getParameter("food_weight")); // 1회제공량


            // 반드시, 값을 받았으면, 꼭 로그를 찍어서 값이 제대로 들어오는지 파악해야함 반드시 작성할 것
            log.info("user_id : " + user_id);
            log.info("exercise_name : " + food_name);
            log.info("food_calories : " + food_calories);
            log.info("food_carbohydrate : " + food_carbohydrate);
            log.info("food_protein : " + food_protein);
            log.info("food_fat : " + food_fat);
            log.info("food_sugar : " + food_sugar);
            log.info("food_natrium : " + food_natrium);
            log.info("food_weight : " + food_weight);


            FoodDTO pDTO = new FoodDTO();

            pDTO.setUser_id(user_id);
            pDTO.setFood_name(food_name);
            pDTO.setFood_calories(food_calories);
            pDTO.setFood_carbohydrate(food_carbohydrate);
            pDTO.setFood_protein(food_protein);
            pDTO.setFood_fat(food_fat);
            pDTO.setFood_sugar(food_sugar);
            pDTO.setFood_natrium(food_natrium);
            pDTO.setFood_weight(food_weight);

            // 정보 추가하기 위한 비즈니스 로직을 호출
            foodService.insertFoodInfo(pDTO);

            // 저장이 완료되면 사용자에게 보여줄 메시지
            msg = "추가되었습니다!";
            url = "/admin/FoodList";

        } catch (Exception e) {

            // 저장이 실패되면 사용자에게 보여줄 메시지
            msg = "실패하였습니다 : " + e.getMessage();
            url = "/admin/FoodList";
            log.info(e.toString());
            e.printStackTrace();

        } finally {
            log.info(this.getClass().getName() + ".FoodInsert end!");

            // 결과 메시지 전달하기
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);

        }
        return "/redirect";
    }

    /**
     * 게시판 상세보기
     */
    @GetMapping(value = "admin/FoodInfo")
    public String FoodInfo(HttpServletRequest request, ModelMap model) {

        log.info(this.getClass().getName() + ".FoodInfo start!");

        String msg = "";

        try {
            String fSeq = CmmUtil.nvl(request.getParameter("fSeq"));

            log.info("fSeq : " + fSeq);

            FoodDTO pDTO = new FoodDTO();
            pDTO.setFood_seq(fSeq);

            // 상세정보 가져오기
            FoodDTO rDTO = foodService.getFoodInfo(pDTO);

            if (rDTO == null) {
                rDTO = new FoodDTO();
            }

            log.info("getFoodInfo success!!");

            // 조회된 리스트 결과값 넣어주기
            model.addAttribute("rDTO", rDTO);

        } catch (Exception e) {

            msg= "실패하였습니다 : " + e.getMessage();
            log.info(e.toString());
            e.printStackTrace();

        }finally {

            log.info(this.getClass().getName() + ".FoodInsert end!");

            // 결과 메시지 전달
            model.addAttribute("msg", msg);

        }
        log.info(this.getClass().getName() + ".FoodInfo end!");

        return "/adminFood/FoodInfo";
    }



    /**
     * 게시판 글 삭제
     */
    @GetMapping(value = "admin/FoodDelete")
    public String FoodDelete(HttpServletRequest request, ModelMap model) {

        log.info(this.getClass().getName()+".FoodDelete start!");

        String msg = "";
        String url = "";

        try {

            String fSeq = CmmUtil.nvl(request.getParameter("fSeq"));

            log.info("fSeq : " + fSeq);

            FoodDTO pDTO = new FoodDTO();

            pDTO.setFood_seq(fSeq);

            //게시글 삭제하기 DB
            foodService.deleteFoodInfo(pDTO);

            msg = "삭제되었습니다";
            url = "/admin/FoodList";

        } catch (Exception e) {
            msg = "실패하였습니다 : " + e.getMessage();
            url = "/admin/FoodList";
            log.info(e.toString());
            e.printStackTrace();

        } finally {
            log.info(this.getClass().getName()+".FoodDelete end!");

            //결과 메시지 전달하기
            model.addAttribute("msg",msg);
            model.addAttribute("url", url);

        }
        return "/redirect";
    }

}

