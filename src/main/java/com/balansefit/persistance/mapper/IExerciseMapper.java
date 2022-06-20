package com.balansefit.persistance.mapper;

import com.balansefit.dto.ExerciseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IExerciseMapper {

    // 게시판 리스트
    List<ExerciseDTO> getExerciseList() throws Exception;

    // 게시판 글 등록
    void insertExerciseInfo(ExerciseDTO eDTO) throws Exception;

    // 게시판 상세보기
    ExerciseDTO getExerciseInfo(ExerciseDTO eDTO) throws Exception;

    // 게시판 글 수정
    void updateExerciseInfo(ExerciseDTO eDTO) throws Exception;

    // 게시판 글 삭제
    void deleteExerciseInfo(ExerciseDTO eDTO) throws Exception;
}
