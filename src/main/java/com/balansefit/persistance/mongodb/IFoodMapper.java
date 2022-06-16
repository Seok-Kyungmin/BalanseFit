package com.balansefit.persistance.mongodb;

import com.balansefit.dto.FoodDTO;

import java.util.List;

public interface IFoodMapper {

    /**
     * 음식 리스트 저장하기
     *
     * @param pList 저장될 정보
     * @param colNm 저장할 컬렉션 이름
     * @return 저장 결과
     */
    int insertFood(List<FoodDTO> fList, String colNm) throws Exception;

    /**
     * 수집된 음식 리스트 가져오기
     *
     * @param colNm 조회할 컬렉션 이름
     * @return 노래 리스트
     */
    List<FoodDTO> getFoodList(String colNm) throws Exception;

    // 게시판 글 추가
    void insertFoodInfo(FoodDTO foDTO) throws Exception;

    // 게시판 글 수정
    void updateFoodInfo(FoodDTO foDTO) throws Exception;

    // 게시판 글 삭제
    void deleteFoodInfo(FoodDTO foDTO) throws Exception;

    // 검색

}
