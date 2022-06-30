package com.balansefit.service;

import com.balansefit.dto.DietDTO;
import com.balansefit.dto.UserDietDTO;

import java.util.List;

public interface IUserDietService {

    List<DietDTO> getUserDietList() throws Exception;

    // 유저 식단 등록
    void insertUserDietInfo(UserDietDTO dDTO) throws Exception;

    // 유저 식단 상세보기
    UserDietDTO getUserDietInfo(UserDietDTO dDTO) throws Exception;

    // 유저 식단 삭제
    void deleteUserDietInfo(UserDietDTO dDTO) throws Exception;
}
