package com.balansefit.service;

import com.balansefit.dto.FoodDTO;
import com.balansefit.dto.UserDietDTO;

import java.util.List;

public interface IUserDietService {

    List<UserDietDTO> getUserDietList() throws Exception;

    // 유저 식단 등록
    void insertUserDietInfo(UserDietDTO dDTO) throws Exception;

    // 유저 식단 상세보기
    UserDietDTO getUserDietInfo(UserDietDTO dDTO) throws Exception;

    // 유저 식단 수정
//    void updateUserDietInfo(UserDietDTO dDTO) throws Exception;

    // 유저 식단 삭제
    void deleteUserDietInfo(UserDietDTO dDTO) throws Exception;

    // 음식 정보 검색
    List<FoodDTO> findFood(String keyword);

    // 식품 리스트
    List<FoodDTO> getUserFoodList() throws Exception;
}
