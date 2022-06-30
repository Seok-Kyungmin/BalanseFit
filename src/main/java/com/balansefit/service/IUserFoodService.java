package com.balansefit.service;

import com.balansefit.dto.FoodDTO;

import java.util.List;

public interface IUserFoodService {

    // 수집된 음식 리스트 가져오기
    List<FoodDTO> getUserFoodList() throws Exception;

    // 음식 정보 상세보기
    FoodDTO getUserFoodInfo(FoodDTO pDTO) throws Exception;
}
