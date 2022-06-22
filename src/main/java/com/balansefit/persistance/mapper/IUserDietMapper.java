package com.balansefit.persistance.mapper;

import com.balansefit.dto.FoodDTO;
import com.balansefit.dto.UserDietDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserDietMapper {


    // 게시판 리스트
    List<UserDietDTO> getUserDietList() throws Exception;

    // 게시판 글 등록
    void insertUserDietInfo(UserDietDTO dDTO) throws Exception;

    // 게시판 상세보기
    UserDietDTO getUserDietInfo(UserDietDTO dDTO) throws Exception;

    // 게시판 글 수정
//    void updateUserDietInfo(UserDietDTO dDTO) throws Exception;

    // 게시판 글 삭제
    void deleteUserDietInfo(UserDietDTO dDTO) throws Exception;

    // 식품 리스트
    List<FoodDTO> getUserFoodList() throws Exception;

    List<FoodDTO> findFood(String keyword);

    // 음식 정보 검색
//    List<FoodDTO> findFood(FoodDTO fDTO) throws Exception;

}
