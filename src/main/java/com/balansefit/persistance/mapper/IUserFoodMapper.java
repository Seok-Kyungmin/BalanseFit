package com.balansefit.persistance.mapper;

import com.balansefit.dto.FoodDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserFoodMapper {

    // 식품 리스트
    List<FoodDTO> getUserFoodList() throws Exception ;
    //Page<FoodDTO> getUserFoodList(Pageable pageable) throws Exception ;

    // 식품 상세보기
    FoodDTO getUserFoodInfo(FoodDTO pDTO) throws Exception;
}
