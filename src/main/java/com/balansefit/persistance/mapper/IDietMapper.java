package com.balansefit.persistance.mapper;

import com.balansefit.dto.DietDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IDietMapper {

    // 게시판 리스트
    List<DietDTO> getDietList() throws Exception;

    // 게시판 글 등록
    void insertDietInfo(DietDTO eDTO) throws Exception;

    // 게시판 상세보기
    DietDTO getDietInfo(DietDTO dDTO) throws Exception;

    // 게시판 글 수정
    void updateDietInfo(DietDTO eDTO) throws Exception;

    // 게시판 글 삭제
    void deleteDietInfo(DietDTO eDTO) throws Exception;
}
