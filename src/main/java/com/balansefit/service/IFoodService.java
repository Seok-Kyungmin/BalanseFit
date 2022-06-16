package com.balansefit.service;

import com.balansefit.dto.FoodDTO;

import java.util.List;

public interface IFoodService {

    // 음식리스트 저장하기
    int collectFoodSong() throws Exception;

    // 수집된 음식 리스트 가져오기
    List<FoodDTO> getFoodList() throws Exception;
}
