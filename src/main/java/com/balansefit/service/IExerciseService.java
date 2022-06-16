package com.balansefit.service;

import com.balansefit.dto.ExerciseDTO;

import java.util.List;


public interface IExerciseService {

    // 게시판 리스트
    List<ExerciseDTO> getExerciseList() throws Exception;

    // 게시판 글 등록
    void insertExerciseInfo(ExerciseDTO eDTO) throws Exception;

    // 게시판 글 수정
    void updateExerciseInfo(ExerciseDTO eDTO) throws Exception;

    // 게시판 글 삭제
    void deleteExerciseInfo(ExerciseDTO eDTO) throws Exception;
}
